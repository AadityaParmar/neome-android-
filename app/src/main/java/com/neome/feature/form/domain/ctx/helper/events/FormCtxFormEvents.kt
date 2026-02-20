package com.neome.feature.form.domain.ctx.helper.events

import android.util.Log
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.DefnEventAction
import com.neome.api.meta.base.dto.DefnSection
import com.neome.api.meta.base.dto.FieldDtoArg
import com.neome.feature.form.domain.DefnFormUi
import com.neome.feature.form.domain.ctx.helper.FormCtxEventHelper
import com.neome.feature.form.domain.util.ConditionResolver
import com.neome.feature.form.domain.util.FieldVal.FieldValueResolver
import com.neome.feature.form.presentation.state.FormEventProps
import com.neome.feature.form.presentation.state.FormState
import com.neome.feature.form.presentation.state.SendBtnStateFlag
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonPrimitive

object FormCtxFormEvents {

    private const val TAG = "FormCtxFormEvents"

    /** Maximum onChange cascade depth to prevent infinite recursion (e.g. A→B→C→A). */
    private const val MAX_CASCADE_DEPTH = 5

    data class CategorizedEvents(
        val onChangeMap: Map<Types.MetaIdComp, List<Types.MetaIdFormEvent>>,
        val onSubmitFormList: List<Types.MetaIdFormEvent>,
        val onClickButtonMap: Map<Types.MetaIdComp, List<Types.MetaIdFormEvent>>
    )


    fun initEvents(defnForm: DefnFormUi, state: FormState): Pair<CategorizedEvents?, FormState> {
        val eventMap = defnForm.eventMap ?: return Pair(null, state)

        val onChangeMap = mutableMapOf<Types.MetaIdComp, MutableList<Types.MetaIdFormEvent>>()
        val onSubmitFormList = mutableListOf<Types.MetaIdFormEvent>()
        val onClickButtonMap = mutableMapOf<Types.MetaIdComp, MutableList<Types.MetaIdFormEvent>>()

        var currentState = state

        // Iterate keys in order to preserve event sequence defined in the form definition
        for (eventId in eventMap.keys) {
            val event = eventMap.map[eventId] ?: continue

            when (event.kind) {
                Types.EnumDefnKindFormEvent.onChange -> {
                    // Null or empty eventFieldIdSet means this event applies to all fields
                    val fieldIds = event.eventFieldIdSet?.takeIf { it.isNotEmpty() }
                        ?: state.fieldStates.keys
                    fieldIds.forEach { fieldId ->
                        onChangeMap.getOrPut(fieldId) { mutableListOf() }.add(event.metaId)
                    }
                }

                Types.EnumDefnKindFormEvent.onSubmitForm -> {
                    onSubmitFormList.add(event.metaId)
                }

                Types.EnumDefnKindFormEvent.onClickButton -> {
                    // For button events, eventFieldIdSet holds the button component IDs
                    event.eventFieldIdSet?.forEach { compId ->
                        onClickButtonMap.getOrPut(compId) { mutableListOf() }.add(event.metaId)
                    }
                }

                Types.EnumDefnKindFormEvent.onInitForm -> {
                    // Execute immediately and accumulate state changes
                    currentState = executeEvent(event.metaId, currentState, defnForm)
                    currentState = mergeEventPropsIntoFieldStates(currentState)
                }
            }
        }

        val categorizedEvents = CategorizedEvents(
            onChangeMap = onChangeMap,
            onSubmitFormList = onSubmitFormList,
            onClickButtonMap = onClickButtonMap
        )

        return Pair(categorizedEvents, currentState)
    }


    fun executeEvents(
        eventIds: List<Types.MetaIdFormEvent>,
        state: FormState,
        defnForm: DefnFormUi,
        triggerValueChanged: Boolean = false,
        depth: Int = 0
    ): FormState {
        // Reset formEventPropsMap before each event cycle so stale overrides are cleared.
        // Events will re-establish any visibility/disability overrides that still apply.
        var currentState = state.copy(formEventPropsMap = emptyMap())

        for (eventId in eventIds) {
            currentState = executeEventInternal(
                eventId = eventId,
                state = currentState,
                defnForm = defnForm,
                triggerValueChanged = triggerValueChanged,
                depth = depth
            )
        }

        // Merge event props into field states once after all events complete
        currentState = mergeEventPropsIntoFieldStates(currentState)

        return currentState
    }

    fun executeEvent(
        eventId: Types.MetaIdFormEvent,
        state: FormState,
        defnForm: DefnFormUi,
        depth: Int = 0
    ): FormState {
        return executeEventInternal(
            eventId = eventId,
            state = state,
            defnForm = defnForm,
            triggerValueChanged = false,
            depth = depth
        )
    }

    private fun executeEventInternal(
        eventId: Types.MetaIdFormEvent,
        state: FormState,
        defnForm: DefnFormUi,
        triggerValueChanged: Boolean,
        depth: Int = 0
    ): FormState {
        // Guard against infinite recursion during onChange cascading
        if (depth >= MAX_CASCADE_DEPTH) {
            Log.w(TAG, "Max cascade depth ($MAX_CASCADE_DEPTH) reached for event $eventId")
            return state
        }

        val eventMap = defnForm.eventMap ?: return state
        val event = eventMap.map[eventId] ?: return state
        val actionBindingMap = event.actionBindingMap ?: return state

        var currentState = state

        // Iterate binding keys in order to preserve action sequence
        for (bindingKey in actionBindingMap.keys) {
            val binding = actionBindingMap.map[bindingKey] ?: continue

            // --- Condition check ---
            val conditionId = binding.conditionId
            if (conditionId != null) {
                val conditionMap = eventMap.conditions?.map?.get(conditionId)
                if (conditionMap != null) {
                    var conditionResult = ConditionResolver.resolve(
                        conditionMap = conditionMap,
                        defnForm = defnForm,
                        formValue = currentState.initialFormValue,
                        getValue = { metaIdComp -> currentState.valueMap[metaIdComp] }
                    )

                    // Apply notCondition flag: invert result when true
                    if (binding.notCondition == true) {
                        conditionResult = conditionResult?.let { !it }
                    }

                    // Skip action if condition is false or unresolvable
                    if (conditionResult != true) continue
                }
            }

            // --- Action lookup ---
            val action = eventMap.actions?.map?.get(binding.actionId) ?: continue

            // --- Save old values before executing action for setValue/clear ---
            val affectedFieldIds = if (triggerValueChanged &&
                (action.kind == Types.EnumDefnKindEventAction.setValue || action.kind == Types.EnumDefnKindEventAction.clear)
            ) {
                resolveAffectedFieldIds(action, defnForm)
            } else {
                emptyList()
            }

            val oldValues = affectedFieldIds.associateWith { fieldId ->
                currentState.valueMap[fieldId]
            }

            // --- Execute action ---
            currentState = executeAction(action, currentState, defnForm)

            // --- Trigger processFieldValueChanged for setValue/clear ---
            // Only when executed from onChange/onClickButton context (not onSubmitForm/onInitForm).
            // Routes through processFieldValueChanged which handles:
            // isDirty, trigger field + dependents, onChange cascade, validation
            // Only processes fields whose values actually changed
            if (affectedFieldIds.isNotEmpty()) {
                for (fieldId in affectedFieldIds) {
                    val newValue = currentState.valueMap[fieldId]
                    val oldValue = oldValues[fieldId]

                    // Only call processFieldValueChanged if value actually changed
                    if (newValue != oldValue) {
                        currentState = FormCtxEventHelper.processFieldValueChanged(
                            state = currentState,
                            fieldId = fieldId,
                            value = newValue,
                            defnForm = defnForm,
                            depth = depth + 1
                        )
                    }
                }
            }
        }

        return currentState
    }

    private fun executeAction(
        action: DefnEventAction,
        state: FormState,
        defnForm: DefnFormUi
    ): FormState {
        return when (action.actionOn) {
            Types.EnumDefnKindEventActionOn.field -> executeActionOnField(action, state, defnForm)
            Types.EnumDefnKindEventActionOn.component -> executeActionOnComponent(action, state, defnForm)
            Types.EnumDefnKindEventActionOn.sendButton -> executeActionOnSendButton(action, state)
            else -> state
        }
    }

    private fun executeActionOnField(
        action: DefnEventAction,
        state: FormState,
        defnForm: DefnFormUi
    ): FormState {
        return when (action.kind) {

            Types.EnumDefnKindEventAction.setValue -> {
                val resolvedValue = resolveSourceValue(action.source, state, defnForm)
                val compIdSet = action.compIdSet
                if (compIdSet.isNullOrEmpty()) return state

                var updatedValueMap = state.valueMap

                for (compId in compIdSet) {
                    if (compId is Types.MetaIdField) {
                        if (resolvedValue != null) {
                            val compType = defnForm.compMap[compId]?.type ?: continue
                            val fieldVal = FieldValueResolver.fnRawValueToFieldValue(compType, resolvedValue)
                            val jsonElement = FieldValueResolver.fnFieldValueToJsonElement(compType, fieldVal)
                            if (jsonElement != null)
                                updatedValueMap = updatedValueMap + (compId to jsonElement)
                        } else {
                            updatedValueMap = updatedValueMap - compId
                        }
                    }
                }

                // Only update valueMap here; isDirty, validation, and onChange
                // cascading are handled by processFieldValueChanged in executeEventInternal
                state.copy(valueMap = updatedValueMap)
            }

            Types.EnumDefnKindEventAction.clear -> {
                val compIdSet = action.compIdSet
                if (compIdSet.isNullOrEmpty()) return state

                var updatedValueMap = state.valueMap

                for (compId in compIdSet) {
                    if (compId is Types.MetaIdField) {
                        updatedValueMap = updatedValueMap - compId
                    }
                }

                // Only update valueMap here; isDirty, validation, and onChange
                // cascading are handled by processFieldValueChanged in executeEventInternal
                state.copy(valueMap = updatedValueMap)
            }

            Types.EnumDefnKindEventAction.visible -> {
                updateFormEventProps(state, action.compIdSet) { props ->
                    props.copy(hidden = false, invisible = false)
                }
            }

            Types.EnumDefnKindEventAction.invisible -> {
                updateFormEventProps(state, action.compIdSet) { props ->
                    props.copy(invisible = true)
                }
            }

            Types.EnumDefnKindEventAction.hidden -> {
                updateFormEventProps(state, action.compIdSet) { props ->
                    props.copy(hidden = true)
                }
            }

            Types.EnumDefnKindEventAction.enable -> {
                updateFormEventProps(state, action.compIdSet) { props ->
                    props.copy(disabled = false)
                }
            }

            Types.EnumDefnKindEventAction.disable -> {
                updateFormEventProps(state, action.compIdSet) { props ->
                    props.copy(disabled = true)
                }
            }

            Types.EnumDefnKindEventAction.highlight -> {
                updateFormEventProps(state, action.compIdSet) { props ->
                    props.copy(highlight = true)
                }
            }

            Types.EnumDefnKindEventAction.blink -> {
                updateFormEventProps(state, action.compIdSet) { props ->
                    props.copy(blink = true)
                }
            }

            Types.EnumDefnKindEventAction.shake -> {
                updateFormEventProps(state, action.compIdSet) { props ->
                    props.copy(shake = true)
                }
            }

            Types.EnumDefnKindEventAction.executeAction -> {
                Log.d(TAG, "TODO: ${action.kind} not yet implemented")
                state
            }

            Types.EnumDefnKindEventAction.executeFormula -> {
                Log.d(TAG, "TODO: ${action.kind} not yet implemented")
                state
            }

            Types.EnumDefnKindEventAction.click -> {
                Log.d(TAG, "TODO: ${action.kind} not yet implemented")
                state
            }
        }

    }

    private fun executeActionOnComponent(
        action: DefnEventAction,
        state: FormState,
        defnForm: DefnFormUi
    ): FormState {
        return when (action.kind) {

            Types.EnumDefnKindEventAction.clear -> {
                val compIdSet = action.compIdSet
                if (compIdSet.isNullOrEmpty()) return state

                var updatedValueMap = state.valueMap

                for (compId in compIdSet) {
                    when (compId) {
                        is Types.MetaIdGrid -> {
                            // Clear grid value
                            updatedValueMap = updatedValueMap - compId
                        }

                        is Types.MetaIdSection -> {
                            // Clear all fields in the section
                            val section = defnForm.compMap[compId] as DefnSection?
                            if (section != null && section.type === Types.EnumDefnCompType.section) {
                                val fieldIdSet = section.fieldIdSet
                                if (!fieldIdSet.isNullOrEmpty()) {
                                    for (fieldId in fieldIdSet) {
                                        updatedValueMap = updatedValueMap - fieldId
                                    }
                                }
                            }
                        }
                    }
                }

                // Only update valueMap here; isDirty, validation, and onChange
                // cascading are handled by processFieldValueChanged in executeEventInternal
                state.copy(valueMap = updatedValueMap)
            }

            Types.EnumDefnKindEventAction.visible -> {
                updateFormEventProps(state, action.compIdSet) { props ->
                    props.copy(hidden = false, invisible = false)
                }
            }

            Types.EnumDefnKindEventAction.invisible -> {
                updateFormEventProps(state, action.compIdSet) { props ->
                    props.copy(invisible = true)
                }
            }

            Types.EnumDefnKindEventAction.hidden -> {
                updateFormEventProps(state, action.compIdSet) { props ->
                    props.copy(hidden = true)
                }
            }

            Types.EnumDefnKindEventAction.enable -> {
                updateFormEventProps(state, action.compIdSet) { props ->
                    props.copy(disabled = false)
                }
            }

            Types.EnumDefnKindEventAction.disable -> {
                updateFormEventProps(state, action.compIdSet) { props ->
                    props.copy(disabled = true)
                }
            }

            Types.EnumDefnKindEventAction.highlight -> {
                updateFormEventProps(state, action.compIdSet) { props ->
                    props.copy(highlight = true)
                }
            }

            Types.EnumDefnKindEventAction.blink -> {
                updateFormEventProps(state, action.compIdSet) { props ->
                    props.copy(blink = true)
                }
            }

            Types.EnumDefnKindEventAction.shake -> {
                updateFormEventProps(state, action.compIdSet) { props ->
                    props.copy(shake = true)
                }
            }

            else -> state
        }

    }


    private fun executeActionOnSendButton(
        action: DefnEventAction,
        state: FormState,
    ): FormState {
        return when (action.kind) {
            Types.EnumDefnKindEventAction.visible -> {
                state.copy(sendBtnStateFlags = state.sendBtnStateFlags - SendBtnStateFlag.Invisible)
            }

            Types.EnumDefnKindEventAction.invisible -> {
                state.copy(sendBtnStateFlags = state.sendBtnStateFlags + SendBtnStateFlag.Invisible)
            }

            Types.EnumDefnKindEventAction.hidden -> {
                state.copy(sendBtnStateFlags = state.sendBtnStateFlags + SendBtnStateFlag.Invisible)
            }

            Types.EnumDefnKindEventAction.enable -> {
                state.copy(sendBtnStateFlags = state.sendBtnStateFlags - SendBtnStateFlag.Disabled)
            }

            Types.EnumDefnKindEventAction.disable -> {
                state.copy(sendBtnStateFlags = state.sendBtnStateFlags + SendBtnStateFlag.Disabled)
            }

            else -> state
        }
    }

    private fun resolveSourceValue(
        source: FieldDtoArg?,
        state: FormState,
        defnForm: DefnFormUi
    ): Any? {
        if (source == null) return null

        source.valueFieldId?.let { fieldId ->

            return ConditionResolver.resolvedFieldValue(
                fieldId,
                defnForm.compMap,
                { fieldId ->
                    val fieldValue = state.valueMap[fieldId]
                    val type = defnForm.compMap[fieldId]?.type
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


    fun mergeEventPropsIntoFieldStates(state: FormState): FormState {
        val eventPropsMap = state.formEventPropsMap
        if (eventPropsMap.isEmpty()) return state

        var updatedFieldStates = state.fieldStates

        for ((compId, eventProps) in eventPropsMap) {
            val fieldState = updatedFieldStates[compId] ?: continue
            val base = fieldState.fieldProperties

            val mergedHidden = base.hidden || eventProps.hidden || eventProps.invisible
            val mergedDisabled = base.disabled || eventProps.disabled

            if (mergedHidden != base.hidden || mergedDisabled != base.disabled) {
                updatedFieldStates = updatedFieldStates + (compId to fieldState.copy(
                    fieldProperties = base.copy(
                        hidden = mergedHidden,
                        disabled = mergedDisabled
                    )
                ))
            }
        }

        return if (updatedFieldStates !== state.fieldStates) {
            state.copy(fieldStates = updatedFieldStates)
        } else {
            state
        }
    }

    /**
     * Resolves the set of leaf field IDs affected by a setValue/clear action.
     * For field-level actions, returns the compIdSet directly (filtered to MetaIdField).
     * For component-level actions (section clear), expands to all fields within the section.
     */
    private fun resolveAffectedFieldIds(
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

    private fun updateFormEventProps(
        state: FormState,
        compIdSet: List<Types.MetaIdComp>?,
        update: (FormEventProps) -> FormEventProps
    ): FormState {
        if (compIdSet.isNullOrEmpty()) return state

        var updatedMap = state.formEventPropsMap

        for (compId in compIdSet) {
            val current = updatedMap[compId] ?: FormEventProps()
            updatedMap = updatedMap + (compId to update(current))
        }

        return state.copy(formEventPropsMap = updatedMap)
    }
}
