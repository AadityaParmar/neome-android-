package com.neome.feature.form.domain.ctx.base

import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.feature.form.domain.DefnFormUi
import com.neome.feature.form.domain.ctx.FormStateAccessor
import com.neome.feature.form.domain.ctx.base.events.FormCtxFormEvents
import com.neome.feature.form.domain.ctx.base.schema.CompSchema
import com.neome.feature.form.domain.util.FieldPropertyResolver
import com.neome.feature.form.presentation.state.FieldError
import com.neome.feature.form.presentation.state.FieldState
import com.neome.feature.form.presentation.state.FormEvent
import com.neome.feature.form.presentation.state.FormIntent
import com.neome.feature.form.presentation.state.SendBtnStateFlag
import kotlinx.serialization.json.JsonElement

object FormCtxEventHelper {

    fun handleFieldValueChanged(
        accessor: FormStateAccessor,
        event: FormEvent.FieldValueChanged,
        defnForm: DefnFormUi
    ) {
        // Save old value before updating to check if value actually changed
        val oldValue = accessor.getValue(event.fieldId)

        // Update valueMap first (for user-initiated changes, depth=0)
        if (event.value != null) {
            accessor.setValue(event.fieldId, event.value)
        } else {
            accessor.removeValue(event.fieldId)
        }

        // Only process field value changed if value actually changed
        if (event.value != oldValue) {
            processFieldValueChanged(
                accessor = accessor,
                fieldId = event.fieldId,
                defnForm = defnForm,
                depth = event.depth
            )
        }

        // Update SendBtnStateFlag.Invalid based on final error state
        syncInvalidFlag(accessor)

        val intent = FormIntent.Watch(
            fieldId = event.fieldId,
            fieldValue = event.value,
            valueMap = accessor.getValueMap()
        )

        accessor.emitIntent(intent)
    }


    fun processFieldValueChanged(
        accessor: FormStateAccessor,
        fieldId: MetaIdComp,
        defnForm: DefnFormUi,
        depth: Int = 0
    ) {
        val state = accessor.getState()
        val currentFieldState = accessor.getFieldState(fieldId)
            ?: return

        val value = accessor.getValue(fieldId)

        // Update isDirty
        val newFieldState = currentFieldState.copy(
            isDirty = value != currentFieldState.defaultValue
        )
        accessor.setFieldState(fieldId, newFieldState)

        // Trigger current field first to recalculate properties and validate
        triggerField(
            accessor = accessor,
            fieldId = fieldId,
            defnForm = defnForm
        )


        // Then trigger dependent fields
        val dependents = state.fieldDependencies.getDependents(fieldId)
        triggerDependentFields(
            accessor = accessor,
            dependentIds = dependents,
            defnForm = defnForm
        )


        // Execute onChange form events for this field
        val categorizedEvents = accessor.getState().categorizedEvents
        if (categorizedEvents != null) {
            val onChangeEventIds = categorizedEvents.onChangeMap[fieldId]
            if (!onChangeEventIds.isNullOrEmpty()) {
                FormCtxFormEvents.executeEvents(
                    eventIds = onChangeEventIds,
                    accessor = accessor,
                    defnForm = defnForm,
                    triggerValueChanged = true,
                    depth = depth
                )
            }
        }
    }

    fun handleFieldFocused(
        accessor: FormStateAccessor,
        event: FormEvent.FieldFocused
    ) {
        val currentFieldState = accessor.getFieldState(event.fieldId)
            ?: return

        val newFieldState = currentFieldState.copy(isFocused = true)
        accessor.setFieldState(event.fieldId, newFieldState)
    }

    fun handleFieldBlurred(
        accessor: FormStateAccessor,
        event: FormEvent.FieldBlurred
    ) {
        val currentFieldState = accessor.getFieldState(event.fieldId)
            ?: return

        val newFieldState = currentFieldState.copy(
            isFocused = false,
            isTouched = true
        )
        accessor.setFieldState(event.fieldId, newFieldState)
    }

    fun handleFieldTouched(
        accessor: FormStateAccessor,
        event: FormEvent.FieldTouched
    ) {
        val currentFieldState = accessor.getFieldState(event.fieldId)
            ?: return

        val newFieldState = currentFieldState.copy(isTouched = true)
        accessor.setFieldState(event.fieldId, newFieldState)
    }

    fun handleTriggerField(
        accessor: FormStateAccessor,
        event: FormEvent.TriggerField,
        defnForm: DefnFormUi
    ) {
        triggerField(
            accessor = accessor,
            fieldId = event.fieldId,
            defnForm = defnForm
        )

    }

    fun handleClick(
        accessor: FormStateAccessor,
        event: FormEvent.Click,
        defnForm: DefnFormUi
    ) {
        val state = accessor.getState()

        // Execute onClickButton form events for this component
        val categorizedEvents = state.categorizedEvents
        if (categorizedEvents != null) {
            val onClickButtonEventIds = categorizedEvents.onClickButtonMap[event.buttonCompId]
            if (!onClickButtonEventIds.isNullOrEmpty()) {
                FormCtxFormEvents.executeEvents(
                    eventIds = onClickButtonEventIds,
                    accessor = accessor,
                    defnForm = defnForm,
                    triggerValueChanged = true
                )
            }
        }

        // Update SendBtnStateFlag.Invalid based on final error state
        syncInvalidFlag(accessor)
    }

    fun handleSubmit(accessor: FormStateAccessor, defnForm: DefnFormUi) {
        FormCtxValidationHelper.handleValidateAll(accessor)

        val state = accessor.getState()
        if (!state.isValid) {
            return
        }

        // Execute onSubmitForm events before submitting
        val categorizedEvents = state.categorizedEvents
        if (categorizedEvents != null) {
            val onSubmitFormEventIds = categorizedEvents.onSubmitFormList
            if (!onSubmitFormEventIds.isNullOrEmpty()) {
                FormCtxFormEvents.executeEvents(
                    eventIds = onSubmitFormEventIds,
                    accessor = accessor,
                    defnForm = defnForm
                )
            }
        }

        accessor.setIsSubmitting(true)
        val intent = FormIntent.Submit(valueMap = accessor.getValueMap())
        accessor.emitIntent(intent)
    }

    fun handleReset(
        accessor: FormStateAccessor,
        event: FormEvent.Reset
    ) {
        val state = accessor.getState()
        val initialValueMap = event.valueMap
            ?: state.initialFormValue?.valueMap
            ?: emptyMap()

        val resetFieldStates = state.fieldStates.mapValues { (fieldId, fieldState) ->
            val value = initialValueMap[fieldId]
            fieldState.copy(
                defaultValue = value,
                isTouched = false,
                isDirty = false,
                isFocused = false
            )
        }

        // Build reset valueMap (only non-null entries from initialValueMap for leaf fields)
        val resetValueMap = initialValueMap.filterKeys { state.fieldStates.containsKey(it) }

        accessor.updateState { currentState ->
            currentState.copy(
                fieldStates = resetFieldStates,
                valueMap = resetValueMap,
                errors = emptyMap(),
                isSubmitting = false
            )
        }
    }

    fun handleSetValues(
        accessor: FormStateAccessor,
        event: FormEvent.SetValues,
        defnForm: DefnFormUi
    ) {
        val state = accessor.getState()
        val updatedFieldStates = state.fieldStates.mapValues { (fieldId, fieldState) ->
            val newValue = event.valueMap[fieldId]
            if (newValue != null) {
                fieldState.copy(
                    isDirty = newValue != fieldState.defaultValue
                )
            } else {
                fieldState
            }
        }

        val validKeys = event.valueMap.filterKeys { state.fieldStates.containsKey(it) }

        accessor.updateFieldStates(updatedFieldStates)

        // Update each changed field's value
        validKeys.forEach { (fieldId, value) ->
            accessor.setValue(fieldId, value)
        }

        // Trigger each changed field and its dependents to recalculate properties and validate

        val changedFieldIds = validKeys.keys

        changedFieldIds.forEach { fieldId ->
            // Trigger the changed field itself
            triggerField(
                accessor = accessor,
                fieldId = fieldId,
                defnForm = defnForm
            )

            // Trigger dependent fields
            val dependents = state.fieldDependencies.getDependents(fieldId)
            triggerDependentFields(
                accessor = accessor,
                dependentIds = dependents,
                defnForm = defnForm
            )

        }


    }

    internal fun triggerDependentFields(
        accessor: FormStateAccessor,
        dependentIds: Set<MetaIdComp>,
        defnForm: DefnFormUi
    ) {
        if (dependentIds.isEmpty()) return

        dependentIds.forEach { dependentId ->
            triggerField(
                accessor = accessor,
                fieldId = dependentId,
                defnForm = defnForm
            )
        }
    }

    private fun triggerField(
        accessor: FormStateAccessor,
        fieldId: MetaIdComp,
        defnForm: DefnFormUi
    ) {
        val state = accessor.getState()
        val schema = state.compSchemaMap[fieldId]

        defnForm.compMap[fieldId] ?: return
        val currentFieldState = accessor.getFieldState(fieldId) ?: return

        // 1. Recalculate field properties from definition
        val newFieldState = calcCompProperties(
            fieldId = fieldId,
            currentFieldState = currentFieldState,
            defnForm = defnForm,
            getFieldValue = { fieldId -> accessor.getValue(fieldId) }
        )
        accessor.setFieldState(fieldId, newFieldState)

        // Note: Event props merging is handled centrally by
        // FormCtxFormEvents.mergeEventPropsIntoFieldStates() after event execution.
        // triggerField only recalculates definition-level properties.


        // 2. Validate field and update errors
        if (schema != null)
            validateField(
                fieldId = fieldId,
                fieldValue = accessor.getValue(fieldId),
                fieldState = newFieldState,
                schema = schema,
                setError = { field, error -> accessor.setError(field, error) }
            )
    }

    /**
     * Recalculate computed properties for a field based on current form state.
     *
     * @return Updated FieldState with new properties
     */
    private fun calcCompProperties(
        fieldId: MetaIdComp,
        currentFieldState: FieldState,
        defnForm: DefnFormUi,
        getFieldValue: (MetaIdComp) -> JsonElement?
    ): FieldState {
        val defnComp = defnForm.compMap[fieldId] ?: return currentFieldState

        val newProperties = FieldPropertyResolver.resolveFieldProperties(
            defnComp = defnComp,
            defnForm = defnForm,
            getFieldValue = getFieldValue
        )

        return currentFieldState.copy(fieldProperties = newProperties)
    }

    /**
     * Validate a single field and update errors map accordingly.
     *
     * @param fieldValue The current field value from valueMap
     * @return Updated errors map with error set or cleared for this field
     */
    private fun validateField(
        fieldId: MetaIdComp,
        fieldValue: JsonElement?,
        fieldState: FieldState,
        schema: CompSchema,
        setError: (fieldId: MetaIdComp, error: FieldError?) -> Unit
    ) {

        val error = schema.validate(fieldValue, fieldState)
        val fieldError = FormCtxValidationHelper.updateFieldError(error)

        setError(fieldId, fieldError)

    }

    /**
     * Synchronizes [SendBtnStateFlag.Invalid] with current error state.
     * Adds the flag if errors exist, removes it if no errors.
     * This ensures the send button state is always consistent after
     * any operation that may change errors (value changes, event execution).
     */
    private fun syncInvalidFlag(accessor: FormStateAccessor) {
        val state = accessor.getState()
        val hasErrors = state.errors.isNotEmpty()
        val hasInvalidFlag = SendBtnStateFlag.Invalid in state.sendBtnStateFlags

        when {
            hasErrors && !hasInvalidFlag -> {
                accessor.setSendBtnStateFlags(state.sendBtnStateFlags + SendBtnStateFlag.Invalid)
            }

            !hasErrors && hasInvalidFlag -> {
                accessor.setSendBtnStateFlags(state.sendBtnStateFlags - SendBtnStateFlag.Invalid)
            }
        }
    }

    /**
     * Result of triggering field(s) containing updated field states and errors.
     */
    data class TriggerResult(
        val fieldStates: Map<MetaIdComp, FieldState>,
        val errors: Map<MetaIdComp, FieldError>
    )
}
