package com.neome.feature.form.domain.ctx.helper

import android.util.Log
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnKindEventAction
import com.neome.api.meta.base.Types.EnumDefnKindFormEvent
import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.api.meta.base.Types.MetaIdFormEvent
import com.neome.api.meta.base.dto.DefnEventAction
import com.neome.api.meta.base.dto.DefnSection
import com.neome.api.meta.base.dto.FieldDtoArg
import com.neome.feature.form.domain.DefnFormUi
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
        val onChangeMap: Map<MetaIdComp, List<MetaIdFormEvent>>,
        val onSubmitFormList: List<MetaIdFormEvent>,
        val onClickButtonMap: Map<MetaIdComp, List<MetaIdFormEvent>>
    )


    data class EventExecutionResult(
        val state: FormState,
        val affectedFieldIds: Set<MetaIdComp>
    )


    fun initEvents(defnForm: DefnFormUi, state: FormState): Pair<CategorizedEvents?, FormState> {
        val eventMap = defnForm.eventMap ?: return Pair(null, state)

        val onChangeMap = mutableMapOf<MetaIdComp, MutableList<MetaIdFormEvent>>()
        val onSubmitFormList = mutableListOf<MetaIdFormEvent>()
        val onClickButtonMap = mutableMapOf<MetaIdComp, MutableList<MetaIdFormEvent>>()

        var currentState = state

        // Iterate keys in order to preserve event sequence defined in the form definition
        for (eventId in eventMap.keys) {
            val event = eventMap.map[eventId] ?: continue

            when (event.kind) {
                EnumDefnKindFormEvent.onChange -> {
                    // Null or empty eventFieldIdSet means this event applies to all fields
                    val fieldIds = event.eventFieldIdSet?.takeIf { it.isNotEmpty() }
                        ?: state.fieldStates.keys
                    fieldIds.forEach { fieldId ->
                        onChangeMap.getOrPut(fieldId) { mutableListOf() }.add(event.metaId)
                    }
                }

                EnumDefnKindFormEvent.onSubmitForm -> {
                    onSubmitFormList.add(event.metaId)
                }

                EnumDefnKindFormEvent.onClickButton -> {
                    // For button events, eventFieldIdSet holds the button component IDs
                    event.eventFieldIdSet?.forEach { compId ->
                        onClickButtonMap.getOrPut(compId) { mutableListOf() }.add(event.metaId)
                    }
                }

                EnumDefnKindFormEvent.onInitForm -> {
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
        eventIds: List<MetaIdFormEvent>,
        state: FormState,
        defnForm: DefnFormUi,
        categorizedEvents: CategorizedEvents? = null
    ): EventExecutionResult {
        // Reset formEventPropsMap before each event cycle so stale overrides are cleared.
        // Events will re-establish any visibility/disability overrides that still apply.
        var currentState = state.copy(formEventPropsMap = emptyMap())
        val allAffectedFieldIds = mutableSetOf<MetaIdComp>()

        for (eventId in eventIds) {
            val result = executeEventInternal(
                eventId = eventId,
                state = currentState,
                defnForm = defnForm,
                categorizedEvents = categorizedEvents,
                affectedFieldIds = allAffectedFieldIds
            )
            currentState = result
        }

        // Merge event props into field states once after all events complete
        currentState = mergeEventPropsIntoFieldStates(currentState)

        return EventExecutionResult(currentState, allAffectedFieldIds)
    }

    fun executeEvent(
        eventId: MetaIdFormEvent,
        state: FormState,
        defnForm: DefnFormUi,
        categorizedEvents: CategorizedEvents? = null,
        depth: Int = 0
    ): FormState {
        return executeEventInternal(
            eventId = eventId,
            state = state,
            defnForm = defnForm,
            categorizedEvents = categorizedEvents,
            depth = depth,
            affectedFieldIds = null
        )
    }

    private fun executeEventInternal(
        eventId: MetaIdFormEvent,
        state: FormState,
        defnForm: DefnFormUi,
        categorizedEvents: CategorizedEvents? = null,
        depth: Int = 0,
        affectedFieldIds: MutableSet<MetaIdComp>?
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

            // --- Execute action ---
            currentState = executeAction(action, currentState, defnForm)

            // --- Track affected fields for setValue/clear ---
            if (action.kind == EnumDefnKindEventAction.setValue || action.kind == EnumDefnKindEventAction.clear) {
                val compIds = action.compIdSet
                if (!compIds.isNullOrEmpty()) {
                    affectedFieldIds?.addAll(compIds)
                }
            }

            // --- Cascade onChange for setValue/clear when in onChange context ---
            if (categorizedEvents != null &&
                (action.kind == EnumDefnKindEventAction.setValue || action.kind == EnumDefnKindEventAction.clear)
            ) {
                val affectedCompIds = action.compIdSet
                if (!affectedCompIds.isNullOrEmpty()) {
                    for (compId in affectedCompIds) {
                        val targetEventIds = categorizedEvents.onChangeMap[compId]
                        if (!targetEventIds.isNullOrEmpty()) {
                            for (targetEventId in targetEventIds) {
                                currentState = executeEventInternal(
                                    eventId = targetEventId,
                                    state = currentState,
                                    defnForm = defnForm,
                                    categorizedEvents = categorizedEvents,
                                    depth = depth + 1,
                                    affectedFieldIds = affectedFieldIds
                                )
                            }
                        }
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

            EnumDefnKindEventAction.setValue -> {
                val resolvedValue = resolveSourceValue(action.source, state, defnForm)
                val compIdSet = action.compIdSet
                if (compIdSet.isNullOrEmpty()) return state

                var updatedValueMap = state.valueMap
                var updatedFieldStates = state.fieldStates

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

                    val fieldState = updatedFieldStates[compId]
                    if (fieldState != null) {
                        val isDirty = resolvedValue != fieldState.defaultValue
                        updatedFieldStates = updatedFieldStates + (compId to fieldState.copy(isDirty = isDirty))
                    }
                }

                state.copy(valueMap = updatedValueMap, fieldStates = updatedFieldStates)
            }

            EnumDefnKindEventAction.clear -> {
                val compIdSet = action.compIdSet
                if (compIdSet.isNullOrEmpty()) return state

                var updatedValueMap = state.valueMap
                var updatedFieldStates = state.fieldStates

                for (compId in compIdSet) {
                    if (compId is Types.MetaIdField) {
                        updatedValueMap = updatedValueMap - compId

                        val fieldState = updatedFieldStates[compId]
                        if (fieldState != null) {
                            // Cleared value is null; dirty if defaultValue was non-null
                            val isDirty = fieldState.defaultValue != null
                            updatedFieldStates = updatedFieldStates + (compId to fieldState.copy(isDirty = isDirty))
                        }
                    }
                }

                state.copy(valueMap = updatedValueMap, fieldStates = updatedFieldStates)
            }

            EnumDefnKindEventAction.visible -> {
                updateFormEventProps(state, action.compIdSet) { props ->
                    props.copy(hidden = false, invisible = false)
                }
            }

            EnumDefnKindEventAction.invisible -> {
                updateFormEventProps(state, action.compIdSet) { props ->
                    props.copy(invisible = true)
                }
            }

            EnumDefnKindEventAction.hidden -> {
                updateFormEventProps(state, action.compIdSet) { props ->
                    props.copy(hidden = true)
                }
            }

            EnumDefnKindEventAction.enable -> {
                updateFormEventProps(state, action.compIdSet) { props ->
                    props.copy(disabled = false)
                }
            }

            EnumDefnKindEventAction.disable -> {
                updateFormEventProps(state, action.compIdSet) { props ->
                    props.copy(disabled = true)
                }
            }

            EnumDefnKindEventAction.highlight -> {
                updateFormEventProps(state, action.compIdSet) { props ->
                    props.copy(highlight = true)
                }
            }

            EnumDefnKindEventAction.blink -> {
                updateFormEventProps(state, action.compIdSet) { props ->
                    props.copy(blink = true)
                }
            }

            EnumDefnKindEventAction.shake -> {
                updateFormEventProps(state, action.compIdSet) { props ->
                    props.copy(shake = true)
                }
            }

            EnumDefnKindEventAction.executeAction -> {
                Log.d(TAG, "TODO: ${action.kind} not yet implemented")
                state
            }

            EnumDefnKindEventAction.executeFormula -> {
                Log.d(TAG, "TODO: ${action.kind} not yet implemented")
                state
            }

            EnumDefnKindEventAction.click -> {
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

            EnumDefnKindEventAction.clear -> {
                val compIdSet = action.compIdSet
                if (compIdSet.isNullOrEmpty()) return state

                var updatedValueMap = state.valueMap
                var updatedFieldStates = state.fieldStates
                var allAffectedFieldIds = mutableSetOf<MetaIdComp>()

                for (compId in compIdSet) {
                    when (compId) {
                        is Types.MetaIdGrid -> {
                            // Clear grid value
                            updatedValueMap = updatedValueMap - compId
                            allAffectedFieldIds.add(compId)
                        }

                        is Types.MetaIdSection -> {
                            // Clear all fields in the section
                            val section = defnForm.compMap[compId] as DefnSection?
                            if (section != null && section.type === Types.EnumDefnCompType.section) {
                                val fieldIdSet = section.fieldIdSet
                                if (!fieldIdSet.isNullOrEmpty()) {
                                    for (fieldId in fieldIdSet) {
                                        updatedValueMap = updatedValueMap - fieldId
                                        allAffectedFieldIds.add(fieldId)

                                        val fieldState = updatedFieldStates[fieldId]
                                        if (fieldState != null) {
                                            // Cleared value is null; dirty if defaultValue was non-null
                                            val isDirty = fieldState.defaultValue != null
                                            updatedFieldStates =
                                                updatedFieldStates + (fieldId to fieldState.copy(isDirty = isDirty))
                                        }
                                    }
                                }
                            }
                        }


                    }
                }

                state.copy(valueMap = updatedValueMap, fieldStates = updatedFieldStates)
            }

            EnumDefnKindEventAction.visible -> {
                updateFormEventProps(state, action.compIdSet) { props ->
                    props.copy(hidden = false, invisible = false)
                }
            }

            EnumDefnKindEventAction.invisible -> {
                updateFormEventProps(state, action.compIdSet) { props ->
                    props.copy(invisible = true)
                }
            }

            EnumDefnKindEventAction.hidden -> {
                updateFormEventProps(state, action.compIdSet) { props ->
                    props.copy(hidden = true)
                }
            }

            EnumDefnKindEventAction.enable -> {
                updateFormEventProps(state, action.compIdSet) { props ->
                    props.copy(disabled = false)
                }
            }

            EnumDefnKindEventAction.disable -> {
                updateFormEventProps(state, action.compIdSet) { props ->
                    props.copy(disabled = true)
                }
            }

            EnumDefnKindEventAction.highlight -> {
                updateFormEventProps(state, action.compIdSet) { props ->
                    props.copy(highlight = true)
                }
            }

            EnumDefnKindEventAction.blink -> {
                updateFormEventProps(state, action.compIdSet) { props ->
                    props.copy(blink = true)
                }
            }

            EnumDefnKindEventAction.shake -> {
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
            EnumDefnKindEventAction.visible -> {
                state.copy(sendBtnStateFlags = state.sendBtnStateFlags - SendBtnStateFlag.Invisible)
            }

            EnumDefnKindEventAction.invisible -> {
                state.copy(sendBtnStateFlags = state.sendBtnStateFlags + SendBtnStateFlag.Invisible)
            }

            EnumDefnKindEventAction.hidden -> {
                state.copy(sendBtnStateFlags = state.sendBtnStateFlags + SendBtnStateFlag.Invisible)
            }

            EnumDefnKindEventAction.enable -> {
                state.copy(sendBtnStateFlags = state.sendBtnStateFlags - SendBtnStateFlag.Disabled)
            }

            EnumDefnKindEventAction.disable -> {
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

    private fun updateFormEventProps(
        state: FormState,
        compIdSet: List<MetaIdComp>?,
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
