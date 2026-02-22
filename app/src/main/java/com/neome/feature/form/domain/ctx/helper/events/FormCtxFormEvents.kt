package com.neome.feature.form.domain.ctx.helper.events

import android.util.Log
import com.neome.api.meta.base.Types
import com.neome.feature.form.domain.DefnFormUi
import com.neome.feature.form.domain.ctx.helper.FormCtxEventHelper
import com.neome.feature.form.domain.util.ConditionResolver
import com.neome.feature.form.presentation.state.FormState

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
        return FormCtxInitEvents.initEvents(defnForm, state)
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
        currentState = FormCtxEventPropsHelper.mergeEventPropsIntoFieldStates(currentState)

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

    fun mergeEventPropsIntoFieldStates(state: FormState): FormState {
        return FormCtxEventPropsHelper.mergeEventPropsIntoFieldStates(state)
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
                FormCtxActionExecutor.resolveAffectedFieldIds(action, defnForm)
            } else {
                emptyList()
            }

            val oldValues = affectedFieldIds.associateWith { fieldId ->
                currentState.valueMap[fieldId]
            }

            // --- Execute action ---
            currentState = FormCtxActionExecutor.executeAction(action, currentState, defnForm)

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
}
