package com.neome.feature.form.domain.ctx.helper

import com.neome.api.meta.base.Types.EnumDefnKindEventAction
import com.neome.api.meta.base.Types.EnumDefnKindFormEvent
import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.api.meta.base.Types.MetaIdFormEvent
import com.neome.api.meta.base.dto.DefnEventAction
import com.neome.api.meta.base.dto.FieldDtoArg
import com.neome.feature.form.domain.DefnFormUi
import com.neome.feature.form.domain.util.ConditionResolver
import com.neome.feature.form.presentation.state.FieldProperties
import com.neome.feature.form.presentation.state.FormState
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonPrimitive

object FormCtxFormEvents {

    /**
     * Categorized form event IDs, organized by trigger type for fast lookup during form lifecycle.
     * Events are stored as [MetaIdFormEvent] references — actual event data is accessed
     * via [DefnFormUi.eventMap] at execution time.
     *
     * @property onChangeMap      fieldId → list of event IDs that fire when that field changes
     * @property onSubmitFormList  event IDs that fire on form submit
     * @property onClickButtonMap buttonCompId → list of event IDs that fire when that button is clicked
     */
    data class CategorizedEvents(
        val onChangeMap: Map<MetaIdComp, List<MetaIdFormEvent>>,
        val onSubmitFormList: List<MetaIdFormEvent>,
        val onClickButtonMap: Map<MetaIdComp, List<MetaIdFormEvent>>
    )

    /**
     * Traverses [defnForm.eventMap], categorizes each event by kind, and immediately
     * executes any [EnumDefnKindFormEvent.onInitForm] events, accumulating state changes.
     *
     * @return A pair of the categorized events (null if no eventMap) and the updated [FormState].
     */
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

    /**
     * Executes a single event by iterating its action bindings in order.
     * Each binding is optionally gated by a condition; if the condition fails the action is skipped.
     *
     * @param eventId The event ID to look up in [defnForm.eventMap]
     * @return Updated [FormState] after all applicable actions have been applied.
     */
    fun executeEvent(
        eventId: MetaIdFormEvent,
        state: FormState,
        defnForm: DefnFormUi
    ): FormState {
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
        }

        return currentState
    }

    /**
     * Executes a single action, dispatching on [action.kind].
     *
     * State-modifying actions (setValue, clear, visible, invisible, hidden, enable, disable)
     * return an updated [FormState] via immutable copy operations.
     *
     * UI-only / async actions (highlight, blink, shake, executeAction, executeFormula, click)
     * are logged as TODOs and return state unchanged.
     */
    private fun executeAction(
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
                    if (resolvedValue != null) {
                        updatedValueMap = updatedValueMap + (compId to resolvedValue)
                    } else {
                        updatedValueMap = updatedValueMap - compId
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
                    updatedValueMap = updatedValueMap - compId

                    val fieldState = updatedFieldStates[compId]
                    if (fieldState != null) {
                        updatedFieldStates = updatedFieldStates + (compId to fieldState.copy(isDirty = false))
                    }
                }

                state.copy(valueMap = updatedValueMap, fieldStates = updatedFieldStates)
            }

            EnumDefnKindEventAction.visible -> {
                updateFieldProperties(state, action.compIdSet) { props ->
                    props.copy(hidden = false)
                }
            }

            EnumDefnKindEventAction.invisible -> {
                updateFieldProperties(state, action.compIdSet) { props ->
                    props.copy(hidden = true)
                }
            }

            EnumDefnKindEventAction.hidden -> {
                updateFieldProperties(state, action.compIdSet) { props ->
                    props.copy(hidden = true)
                }
            }

            EnumDefnKindEventAction.enable -> {
                updateFieldProperties(state, action.compIdSet) { props ->
                    props.copy(disabled = false)
                }
            }

            EnumDefnKindEventAction.disable -> {
                updateFieldProperties(state, action.compIdSet) { props ->
                    props.copy(disabled = true)
                }
            }

            EnumDefnKindEventAction.highlight -> {
                println("FormCtxFormEvents: TODO ${action.kind}")
                state
            }

            EnumDefnKindEventAction.blink -> {
                println("FormCtxFormEvents: TODO ${action.kind}")
                state
            }

            EnumDefnKindEventAction.shake -> {
                println("FormCtxFormEvents: TODO ${action.kind}")
                state
            }

            EnumDefnKindEventAction.executeAction -> {
                println("FormCtxFormEvents: TODO ${action.kind}")
                state
            }

            EnumDefnKindEventAction.executeFormula -> {
                println("FormCtxFormEvents: TODO ${action.kind}")
                state
            }

            EnumDefnKindEventAction.click -> {
                println("FormCtxFormEvents: TODO ${action.kind}")
                state
            }
        }
    }

    /**
     * Resolves a [FieldDtoArg] source to a concrete [JsonElement] value.
     *
     * Resolution priority (first non-null wins):
     * 1. [FieldDtoArg.valueFieldId] → look up current value from [FormState.valueMap]
     * 2. [FieldDtoArg.valueText]    → wrap as [JsonPrimitive]
     * 3. [FieldDtoArg.valueLong]    → wrap as [JsonPrimitive]
     * 4. [FieldDtoArg.valueDouble]  → wrap as [JsonPrimitive]
     * 5. [FieldDtoArg.valueBoolean] → wrap as [JsonPrimitive]
     *
     * @return The resolved [JsonElement], or null if source is null or no value could be resolved.
     */
    private fun resolveSourceValue(
        source: FieldDtoArg?,
        state: FormState,
        @Suppress("UNUSED_PARAMETER") defnForm: DefnFormUi
    ): JsonElement? {
        if (source == null) return null

        source.valueFieldId?.let { fieldId -> return state.valueMap[fieldId] }
        source.valueText?.let { return JsonPrimitive(it) }
        source.valueLong?.let { return JsonPrimitive(it) }
        source.valueDouble?.let { return JsonPrimitive(it) }
        source.valueBoolean?.let { return JsonPrimitive(it) }

        return null
    }

    /**
     * Applies a property [update] function to the [FieldProperties] of each component
     * in [compIdSet], returning an updated [FormState] via immutable copies.
     *
     * Components not found in [FormState.fieldStates] are silently skipped.
     */
    private fun updateFieldProperties(
        state: FormState,
        compIdSet: List<MetaIdComp>?,
        update: (FieldProperties) -> FieldProperties
    ): FormState {
        if (compIdSet.isNullOrEmpty()) return state

        var updatedFieldStates = state.fieldStates

        for (compId in compIdSet) {
            val fieldState = updatedFieldStates[compId] ?: continue
            val updatedProperties = update(fieldState.fieldProperties)
            updatedFieldStates = updatedFieldStates + (compId to fieldState.copy(fieldProperties = updatedProperties))
        }

        return state.copy(fieldStates = updatedFieldStates)
    }
}
