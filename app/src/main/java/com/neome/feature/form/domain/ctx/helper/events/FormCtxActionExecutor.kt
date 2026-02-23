package com.neome.feature.form.domain.ctx.helper.events

import android.util.Log
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.DefnComp
import com.neome.api.meta.base.dto.DefnEventAction
import com.neome.api.meta.base.dto.DefnSection
import com.neome.api.meta.base.dto.FieldDtoArg
import com.neome.feature.form.domain.DefnFormUi
import com.neome.feature.form.domain.ctx.FormStateAccessor
import com.neome.feature.form.domain.util.ConditionResolver
import com.neome.feature.form.domain.util.FieldVal.FieldValueResolver
import com.neome.feature.form.presentation.state.FormState
import com.neome.feature.form.presentation.state.SendBtnStateFlag
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonPrimitive

object FormCtxActionExecutor {

    private const val TAG = "FormCtxActionExecutor"

    fun executeAction(
        accessor: FormStateAccessor,
        action: DefnEventAction,
        defnForm: DefnFormUi
    ) {
        val targetNames = actionTargetNames(defnForm, action)
        Log.d(TAG, "Action running: ${action.kind} on ${action.actionOn} targets: $targetNames")
        when (action.actionOn) {
            Types.EnumDefnKindEventActionOn.field -> executeActionOnField(accessor, action, defnForm)
            Types.EnumDefnKindEventActionOn.component -> executeActionOnComponent(accessor, action, defnForm)
            Types.EnumDefnKindEventActionOn.sendButton -> executeActionOnSendButton(accessor, action)
            else -> {}
        }
    }

    /**
     * Resolves human-readable target names for logging: field/section/grid label or name, or "submit btn".
     */
    private fun actionTargetNames(defnForm: DefnFormUi, action: DefnEventAction): String {
        return when (action.actionOn) {
            Types.EnumDefnKindEventActionOn.sendButton -> "submit btn"
            else -> {
                val compIdSet = action.compIdSet ?: return ""
                compIdSet.mapNotNull { compId ->
                    (defnForm.compMap[compId] as? DefnComp)?.let { comp ->
                        comp.label?.takeIf { it.isNotBlank() } ?: comp.name.toString()
                    }
                }.joinToString(", ").ifBlank { "" }
            }
        }
    }

    private fun executeActionOnField(
        accessor: FormStateAccessor,
        action: DefnEventAction,
        defnForm: DefnFormUi
    ) {
        when (action.kind) {

            Types.EnumDefnKindEventAction.setValue -> {
                val resolvedValue = resolveSourceValue(action.source, accessor, defnForm)
                val compIdSet = action.compIdSet
                if (compIdSet.isNullOrEmpty()) return

                for (compId in compIdSet) {
                    if (compId is Types.MetaIdField) {
                        if (resolvedValue != null) {
                            val compType = defnForm.compMap[compId]?.type ?: continue
                            val fieldVal = FieldValueResolver.fnRawValueToFieldValue(compType, resolvedValue)
                            val jsonElement = FieldValueResolver.fnFieldValueToJsonElement(compType, fieldVal)
                            if (jsonElement != null) {
                                accessor.setValue(compId, jsonElement)
                            }
                        } else {
                            accessor.removeValue(compId)
                        }
                    }
                }

                // Only update valueMap here; isDirty, validation, and onChange
                // cascading are handled by processFieldValueChanged in executeEventInternal
            }

            Types.EnumDefnKindEventAction.clear -> {
                val compIdSet = action.compIdSet
                if (compIdSet.isNullOrEmpty()) return

                for (compId in compIdSet) {
                    if (compId is Types.MetaIdField) {
                        accessor.removeValue(compId)
                    }
                }

                // Only update valueMap here; isDirty, validation, and onChange
                // cascading are handled by processFieldValueChanged in executeEventInternal
            }

            Types.EnumDefnKindEventAction.visible -> {
                FormCtxEventPropsHelper.updateFormEventProps(accessor, action.compIdSet) { props ->
                    props.copy(hidden = false, invisible = false)
                }
            }

            Types.EnumDefnKindEventAction.invisible -> {
                FormCtxEventPropsHelper.updateFormEventProps(accessor, action.compIdSet) { props ->
                    props.copy(invisible = true)
                }
            }

            Types.EnumDefnKindEventAction.hidden -> {
                FormCtxEventPropsHelper.updateFormEventProps(accessor, action.compIdSet) { props ->
                    props.copy(hidden = true)
                }
            }

            Types.EnumDefnKindEventAction.enable -> {
                FormCtxEventPropsHelper.updateFormEventProps(accessor, action.compIdSet) { props ->
                    props.copy(disabled = false)
                }
            }

            Types.EnumDefnKindEventAction.disable -> {
                FormCtxEventPropsHelper.updateFormEventProps(accessor, action.compIdSet) { props ->
                    props.copy(disabled = true)
                }
            }

            Types.EnumDefnKindEventAction.highlight -> {
                FormCtxEventPropsHelper.updateFormEventProps(accessor, action.compIdSet) { props ->
                    props.copy(highlight = true)
                }
            }

            Types.EnumDefnKindEventAction.blink -> {
                FormCtxEventPropsHelper.updateFormEventProps(accessor, action.compIdSet) { props ->
                    props.copy(blink = true)
                }
            }

            Types.EnumDefnKindEventAction.shake -> {
                FormCtxEventPropsHelper.updateFormEventProps(accessor, action.compIdSet) { props ->
                    props.copy(shake = true)
                }
            }

            Types.EnumDefnKindEventAction.executeAction -> {
                Log.d(TAG, "TODO: ${action.kind} not yet implemented")
            }

            Types.EnumDefnKindEventAction.executeFormula -> {
                Log.d(TAG, "TODO: ${action.kind} not yet implemented")
            }

            Types.EnumDefnKindEventAction.click -> {
                Log.d(TAG, "TODO: ${action.kind} not yet implemented")
            }
        }
    }

    private fun executeActionOnComponent(
        accessor: FormStateAccessor,
        action: DefnEventAction,
        defnForm: DefnFormUi
    ) {
        when (action.kind) {

            Types.EnumDefnKindEventAction.clear -> {
                val compIdSet = action.compIdSet
                if (compIdSet.isNullOrEmpty()) return

                for (compId in compIdSet) {
                    when (compId) {
                        is Types.MetaIdGrid -> {
                            // Clear grid value
                            accessor.removeValue(compId)
                        }

                        is Types.MetaIdSection -> {
                            // Clear all fields in the section
                            val section = defnForm.compMap[compId] as DefnSection?
                            if (section != null && section.type === Types.EnumDefnCompType.section) {
                                val fieldIdSet = section.fieldIdSet
                                if (!fieldIdSet.isNullOrEmpty()) {
                                    for (fieldId in fieldIdSet) {
                                        accessor.removeValue(fieldId)
                                    }
                                }
                            }
                        }
                    }
                }

                // Only update valueMap here; isDirty, validation, and onChange
                // cascading are handled by processFieldValueChanged in executeEventInternal
            }

            Types.EnumDefnKindEventAction.visible -> {
                FormCtxEventPropsHelper.updateFormEventProps(accessor, action.compIdSet) { props ->
                    props.copy(hidden = false, invisible = false)
                }
            }

            Types.EnumDefnKindEventAction.invisible -> {
                FormCtxEventPropsHelper.updateFormEventProps(accessor, action.compIdSet) { props ->
                    props.copy(invisible = true)
                }
            }

            Types.EnumDefnKindEventAction.hidden -> {
                FormCtxEventPropsHelper.updateFormEventProps(accessor, action.compIdSet) { props ->
                    props.copy(hidden = true)
                }
            }

            Types.EnumDefnKindEventAction.enable -> {
                FormCtxEventPropsHelper.updateFormEventProps(accessor, action.compIdSet) { props ->
                    props.copy(disabled = false)
                }
            }

            Types.EnumDefnKindEventAction.disable -> {
                FormCtxEventPropsHelper.updateFormEventProps(accessor, action.compIdSet) { props ->
                    props.copy(disabled = true)
                }
            }

            Types.EnumDefnKindEventAction.highlight -> {
                FormCtxEventPropsHelper.updateFormEventProps(accessor, action.compIdSet) { props ->
                    props.copy(highlight = true)
                }
            }

            Types.EnumDefnKindEventAction.blink -> {
                FormCtxEventPropsHelper.updateFormEventProps(accessor, action.compIdSet) { props ->
                    props.copy(blink = true)
                }
            }

            Types.EnumDefnKindEventAction.shake -> {
                FormCtxEventPropsHelper.updateFormEventProps(accessor, action.compIdSet) { props ->
                    props.copy(shake = true)
                }
            }

            else -> {}
        }
    }

    private fun executeActionOnSendButton(
        accessor: FormStateAccessor,
        action: DefnEventAction,
    ) {
        when (action.kind) {
            Types.EnumDefnKindEventAction.visible -> {
                val state = accessor.getState()
                accessor.setSendBtnStateFlags(state.sendBtnStateFlags - SendBtnStateFlag.Invisible)
            }

            Types.EnumDefnKindEventAction.invisible -> {
                val state = accessor.getState()
                accessor.setSendBtnStateFlags(state.sendBtnStateFlags + SendBtnStateFlag.Invisible)
            }

            Types.EnumDefnKindEventAction.hidden -> {
                val state = accessor.getState()
                accessor.setSendBtnStateFlags(state.sendBtnStateFlags + SendBtnStateFlag.Invisible)
            }

            Types.EnumDefnKindEventAction.enable -> {
                val state = accessor.getState()
                accessor.setSendBtnStateFlags(state.sendBtnStateFlags - SendBtnStateFlag.Disabled)
            }

            Types.EnumDefnKindEventAction.disable -> {
                val state = accessor.getState()
                accessor.setSendBtnStateFlags(state.sendBtnStateFlags + SendBtnStateFlag.Disabled)
            }

            else -> {}
        }
    }

    fun resolveSourceValue(
        source: FieldDtoArg?,
        accessor: FormStateAccessor,
        defnForm: DefnFormUi
    ): Any? {
        if (source == null) return null

        source.valueFieldId?.let { fieldId ->
            val state = accessor.getState()
            return ConditionResolver.resolvedFieldValue(
                fieldId,
                defnForm.compMap,
                { fId ->
                    val fieldValue = accessor.getValue(fId)
                    val type = defnForm.compMap[fId]?.type
                    if (type !== null)
                        FieldValueResolver.fnFieldValueToJsonElement(type, fieldValue)
                    else null
                },
                state.initialFormValue
            )
        }
        //TODO valueText can be arg string resolve it with argResolver
        source.valueText?.let { return JsonPrimitive(it) }
        source.valueLong?.let { return JsonPrimitive(it) }
        source.valueDouble?.let { return JsonPrimitive(it) }
        source.valueBoolean?.let { return JsonPrimitive(it) }
        source.valueDate?.let { return JsonPrimitive(it) }
        source.valueSysId?.let { return JsonPrimitive(it.getId()) }
        source.valueSysIdArray?.let { return JsonArray(it.map { id -> JsonPrimitive(id.getId()) }) }
        source.valueSysIdSet?.let { return JsonArray(it.map { id -> JsonPrimitive(id.getId()) }) }
        source.valueTextArray?.let { return JsonArray(it.map { id -> JsonPrimitive(id) }) }

        return null
    }

    /**
     * Resolves the set of leaf field IDs affected by a setValue/clear action.
     * For field-level actions, returns the compIdSet directly (filtered to MetaIdField).
     * For component-level actions (section clear), expands to all fields within the section.
     */
    fun resolveAffectedFieldIds(
        action: DefnEventAction,
        defnForm: DefnFormUi
    ): List<Types.MetaIdField> {
        val compIdSet = action.compIdSet
        if (compIdSet.isNullOrEmpty()) return emptyList()

        return when (action.actionOn) {
            Types.EnumDefnKindEventActionOn.component -> {
                // Expand component IDs (sections/grids) to their constituent field IDs
                buildList {
                    for (compId in compIdSet) {
                        when (compId) {
                            is Types.MetaIdSection -> {
                                val section = defnForm.compMap[compId] as? DefnSection
                                if (section != null && section.type === Types.EnumDefnCompType.section) {
                                    section.fieldIdSet?.let { addAll(it) }
                                }
                            }
                            // Grid clear doesn't expand to leaf fields
                            else -> {}
                        }
                    }
                }
            }

            else -> {
                // Field-level: filter to MetaIdField directly
                compIdSet.filterIsInstance<Types.MetaIdField>()
            }
        }
    }
}
