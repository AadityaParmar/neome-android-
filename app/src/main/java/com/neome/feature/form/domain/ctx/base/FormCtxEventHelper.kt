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
import com.neome.feature.form.presentation.state.FormEventProps
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

    /**
     * Core pure-state processing for a field value change.
     * Handles: isDirty update, trigger field + dependents, onChange cascade, validation.
     *
     * Called from:
     * - [handleFieldValueChanged] for user-initiated changes (via FormEvent.FieldValueChanged)
     * - [com.neome.feature.form.domain.ctx.base.events.FormCtxFormEvents.executeEventInternal] for event-driven setValue/clear actions
     *
     * The [depth] parameter guards against infinite onChange recursion (A→B→C→A).
     * valueMap must already be updated with the new value before calling this function.
     *
     * @param accessor Current form accessor
     * @param fieldId The field whose value changed
     * @param defnForm Form definition
     * @param depth Current cascade depth for recursion guard
     */
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
        val currentFieldTriggerResult = triggerField(
            fieldId = fieldId,
            fieldStates = accessor.getFieldStates(),
            valueMap = accessor.getValueMap(),
            errors = accessor.getErrors(),
            defnForm = defnForm,
            compSchemaMap = state.compSchemaMap,
            formEventPropsMap = state.formEventPropsMap
        ) ?: TriggerResult(accessor.getFieldStates(), accessor.getErrors())

        // Apply trigger result to accessor
        accessor.updateFieldStates(currentFieldTriggerResult.fieldStates)
        accessor.updateErrors(currentFieldTriggerResult.errors)

        // Then trigger dependent fields
        val dependents = state.fieldDependencies.getDependents(fieldId)
        val triggerResult = triggerDependentFields(
            fieldStates = accessor.getFieldStates(),
            valueMap = accessor.getValueMap(),
            dependentIds = dependents,
            defnForm = defnForm,
            errors = accessor.getErrors(),
            compSchemaMap = state.compSchemaMap,
            formEventPropsMap = state.formEventPropsMap
        )

        accessor.updateFieldStates(triggerResult.fieldStates)
        accessor.updateErrors(triggerResult.errors)

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
        val state = accessor.getState()
        val result = triggerField(
            fieldId = event.fieldId,
            fieldStates = accessor.getFieldStates(),
            valueMap = accessor.getValueMap(),
            errors = accessor.getErrors(),
            defnForm = defnForm,
            compSchemaMap = state.compSchemaMap,
            formEventPropsMap = state.formEventPropsMap
        ) ?: return

        accessor.updateFieldStates(result.fieldStates)
        accessor.updateErrors(result.errors)
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

        // Merge event values into existing valueMap (only for known leaf fields)
        val validKeys = event.valueMap.filterKeys { state.fieldStates.containsKey(it) }
        val updatedValueMap = accessor.getValueMap() + validKeys

        accessor.updateFieldStates(updatedFieldStates)

        // Update each changed field's value
        validKeys.forEach { (fieldId, value) ->
            accessor.setValue(fieldId, value)
        }

        // Trigger each changed field and its dependents to recalculate properties and validate
        var currentFieldStates = accessor.getFieldStates()
        var currentErrors = accessor.getErrors()
        val changedFieldIds = validKeys.keys

        changedFieldIds.forEach { fieldId ->
            // Trigger the changed field itself
            val fieldTriggerResult = triggerField(
                fieldId = fieldId,
                fieldStates = currentFieldStates,
                valueMap = accessor.getValueMap(),
                errors = currentErrors,
                defnForm = defnForm,
                compSchemaMap = state.compSchemaMap,
                formEventPropsMap = state.formEventPropsMap
            )
            if (fieldTriggerResult != null) {
                currentFieldStates = fieldTriggerResult.fieldStates
                currentErrors = fieldTriggerResult.errors
            }

            // Trigger dependent fields
            val dependents = state.fieldDependencies.getDependents(fieldId)
            val dependentResult = triggerDependentFields(
                fieldStates = currentFieldStates,
                valueMap = accessor.getValueMap(),
                dependentIds = dependents,
                defnForm = defnForm,
                errors = currentErrors,
                compSchemaMap = state.compSchemaMap,
                formEventPropsMap = state.formEventPropsMap
            )
            currentFieldStates = dependentResult.fieldStates
            currentErrors = dependentResult.errors
        }

        accessor.updateFieldStates(currentFieldStates)
        accessor.updateErrors(currentErrors)
    }

    internal fun triggerDependentFields(
        fieldStates: Map<MetaIdComp, FieldState>,
        valueMap: Map<MetaIdComp, JsonElement>,
        dependentIds: Set<MetaIdComp>,
        defnForm: DefnFormUi,
        errors: Map<MetaIdComp, FieldError>,
        compSchemaMap: Map<MetaIdComp, CompSchema>,
        formEventPropsMap: Map<MetaIdComp, FormEventProps> = emptyMap()
    ): TriggerResult {
        if (dependentIds.isEmpty()) return TriggerResult(fieldStates, errors)

        var updatedFieldStates = fieldStates
        var updatedErrors = errors

        dependentIds.forEach { dependentId ->
            val result = triggerField(
                fieldId = dependentId,
                fieldStates = updatedFieldStates,
                valueMap = valueMap,
                errors = updatedErrors,
                defnForm = defnForm,
                compSchemaMap = compSchemaMap,
                formEventPropsMap = formEventPropsMap
            ) ?: return@forEach

            updatedFieldStates = result.fieldStates
            updatedErrors = result.errors
        }

        return TriggerResult(updatedFieldStates, updatedErrors)
    }

    /**
     * Trigger a single field: recalculate properties from definition, apply event prop
     * overrides, and validate.
     *
     * Event props merging uses OR semantics — event overrides can only **add** restrictions
     * (hidden, disabled), never remove definition-level flags.
     *
     * @return Updated field states and errors, or null if field/defnComp not found
     */
    private fun triggerField(
        fieldId: MetaIdComp,
        fieldStates: Map<MetaIdComp, FieldState>,
        valueMap: Map<MetaIdComp, JsonElement>,
        errors: Map<MetaIdComp, FieldError>,
        defnForm: DefnFormUi,
        compSchemaMap: Map<MetaIdComp, CompSchema>,
        formEventPropsMap: Map<MetaIdComp, FormEventProps> = emptyMap()
    ): TriggerResult? {
        defnForm.compMap[fieldId] ?: return null
        val currentFieldState = fieldStates[fieldId] ?: return null

        // 1. Recalculate field properties from definition
        val newFieldState = calcCompProperties(
            fieldId = fieldId,
            currentFieldState = currentFieldState,
            defnForm = defnForm,
            valueMap = valueMap
        )

        // Note: Event props merging is handled centrally by
        // FormCtxFormEvents.mergeEventPropsIntoFieldStates() after event execution.
        // triggerField only recalculates definition-level properties.

        val updatedFieldStates = fieldStates + (fieldId to newFieldState)

        // 2. Validate field and update errors
        val updatedErrors = validateField(
            fieldId = fieldId,
            fieldValue = valueMap[fieldId],
            fieldState = newFieldState,
            errors = errors,
            compSchemaMap = compSchemaMap
        )

        return TriggerResult(updatedFieldStates, updatedErrors)
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
        valueMap: Map<MetaIdComp, JsonElement>
    ): FieldState {
        val defnComp = defnForm.compMap[fieldId] ?: return currentFieldState

        val newProperties = FieldPropertyResolver.resolveFieldProperties(
            defnComp = defnComp,
            defnForm = defnForm,
            getFieldValue = { id -> valueMap[id] }
        )

        return currentFieldState.copy(fieldProperties = newProperties)
    }

    /**
     * Validate a single field and update errors map accordingly.
     * Delegates to [FormCtxValidationHelper.updateFieldError] for error map updates.
     *
     * @param fieldValue The current field value from valueMap
     * @return Updated errors map with error set or cleared for this field
     */
    private fun validateField(
        fieldId: MetaIdComp,
        fieldValue: JsonElement?,
        fieldState: FieldState,
        errors: Map<MetaIdComp, FieldError>,
        compSchemaMap: Map<MetaIdComp, CompSchema>
    ): Map<MetaIdComp, FieldError> {
        val schema = compSchemaMap[fieldId]
            ?: return errors // No schema = no validation needed

        val error = schema.validate(fieldValue, fieldState)
        return FormCtxValidationHelper.updateFieldError(fieldId, error, errors)
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
