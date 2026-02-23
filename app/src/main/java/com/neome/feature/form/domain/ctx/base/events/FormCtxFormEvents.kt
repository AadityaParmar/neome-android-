package com.neome.feature.form.domain.ctx.base.events

import android.util.Log
import com.neome.api.meta.base.Types
import com.neome.feature.form.domain.DefnFormUi
import com.neome.feature.form.domain.ctx.FormStateAccessor
import com.neome.feature.form.domain.ctx.base.FormCtxEventHelper
import com.neome.feature.form.domain.util.ConditionResolver

object FormCtxFormEvents {

    private const val TAG = "FormCtxFormEvents"

    /** Maximum onChange cascade depth to prevent infinite recursion (e.g. A→B→C→A). */
    private const val MAX_CASCADE_DEPTH = 5

    data class CategorizedEvents(
        val onChangeMap: Map<Types.MetaIdComp, List<Types.MetaIdFormEvent>>,
        val onSubmitFormList: List<Types.MetaIdFormEvent>,
        val onClickButtonMap: Map<Types.MetaIdComp, List<Types.MetaIdFormEvent>>
    )

    fun executeEvents(
        eventIds: List<Types.MetaIdFormEvent>,
        accessor: FormStateAccessor,
        defnForm: DefnFormUi,
        triggerValueChanged: Boolean = false,
        depth: Int = 0
    ) {
        // Reset formEventPropsMap before each event cycle so stale overrides are cleared.
        // Events will re-establish any visibility/disability overrides that still apply.
        accessor.setFormEventPropsMap(emptyMap())

        for (eventId in eventIds) {
            executeEventInternal(
                eventId = eventId,
                accessor = accessor,
                defnForm = defnForm,
                triggerValueChanged = triggerValueChanged,
                depth = depth
            )
        }

        // Merge event props into field states once after all events complete
        FormCtxEventPropsHelper.mergeEventPropsIntoFieldStates(accessor)
    }

    fun executeEvent(
        eventId: Types.MetaIdFormEvent,
        accessor: FormStateAccessor,
        defnForm: DefnFormUi,
        depth: Int = 0
    ) {
        executeEventInternal(
            eventId = eventId,
            accessor = accessor,
            defnForm = defnForm,
            triggerValueChanged = false,
            depth = depth
        )
    }


    private fun executeEventInternal(
        eventId: Types.MetaIdFormEvent,
        accessor: FormStateAccessor,
        defnForm: DefnFormUi,
        triggerValueChanged: Boolean,
        depth: Int = 0
    ) {
        // Guard against infinite recursion during onChange cascading
        if (depth >= MAX_CASCADE_DEPTH) {
            Log.w(TAG, "Max cascade depth ($MAX_CASCADE_DEPTH) reached for event $eventId")
            return
        }

        val state = accessor.getState()
        val eventMap = defnForm.eventMap ?: return
        val event = eventMap.map[eventId] ?: return
        val actionBindingMap = event.actionBindingMap ?: return

        Log.d(TAG, "Event executed: $eventId | kind = ${event.kind}")

        // Iterate binding keys in order to preserve action sequence
        for (bindingKey in actionBindingMap.keys) {
            val binding = actionBindingMap.map[bindingKey] ?: continue

            // --- Condition check ---
            val conditionId = binding.conditionId
            val hadCondition = conditionId != null
            if (conditionId != null) {
                val conditionMap = eventMap.conditions?.map?.get(conditionId)
                if (conditionMap != null) {
                    var conditionResult = ConditionResolver.resolve(
                        conditionMap = conditionMap,
                        defnForm = defnForm,
                        formValue = state.initialFormValue,
                        getValue = { metaIdComp -> accessor.getValue(metaIdComp) }
                    )

                    // Apply notCondition flag: invert result when true
                    if (binding.notCondition == true) {
                        conditionResult = conditionResult?.let { !it }
                    }

                    // Skip action if condition is false or unresolvable
                    if (conditionResult != true) {
//                        Log.d(TAG, "  Action skipped: ${binding.actionId} (condition not met)")
                        continue
                    }
                }
            }

            // --- Action lookup ---
            val action = eventMap.actions?.map?.get(binding.actionId) ?: continue
            Log.d(
                TAG,
                "  Action executed: ${binding.actionId} (${action.kind}) — ${if (hadCondition) "condition passed" else "no condition"}"
            )

            // --- Save old values before executing action for setValue/clear ---
            val affectedFieldIds = if (triggerValueChanged &&
                (action.kind == Types.EnumDefnKindEventAction.setValue || action.kind == Types.EnumDefnKindEventAction.clear)
            ) {
                FormCtxActionExecutor.resolveAffectedFieldIds(action, defnForm)
            } else {
                emptyList()
            }

            val oldValues = affectedFieldIds.associateWith { fieldId ->
                accessor.getValue(fieldId)
            }

            // --- Execute action ---
            FormCtxActionExecutor.executeAction(accessor, action, defnForm)

            // --- Trigger processFieldValueChanged for setValue/clear ---
            // Only when executed from onChange/onClickButton context (not onSubmitForm/onInitForm).
            // Routes through processFieldValueChanged which handles:
            // isDirty, trigger field + dependents, onChange cascade, validation
            // Only processes fields whose values actually changed
            if (affectedFieldIds.isNotEmpty()) {
                for (fieldId in affectedFieldIds) {
                    val newValue = accessor.getValue(fieldId)
                    val oldValue = oldValues[fieldId]

                    // Only call processFieldValueChanged if value actually changed
                    if (newValue != oldValue) {
                        FormCtxEventHelper.processFieldValueChanged(
                            accessor = accessor,
                            fieldId = fieldId,
                            defnForm = defnForm,
                            depth = depth + 1
                        )
                    }
                }
            }
        }
    }
}
