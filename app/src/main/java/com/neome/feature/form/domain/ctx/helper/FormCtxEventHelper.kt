package com.neome.feature.form.domain.ctx.helper

import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.core.common.serializer.api.meta.base.dto.DefnFormData
import com.neome.feature.form.domain.ctx.helper.schema.DefnCompSchema
import com.neome.feature.form.domain.util.FieldPropertyResolver
import com.neome.feature.form.presentation.state.FieldError
import com.neome.feature.form.presentation.state.FieldState
import com.neome.feature.form.presentation.state.FormEvent
import com.neome.feature.form.presentation.state.FormIntent
import com.neome.feature.form.presentation.state.FormState

object FormCtxEventHelper {

    fun handleFieldValueChanged(
        state: FormState,
        event: FormEvent.FieldValueChanged,
        defnForm: DefnFormData
    ): FormReducerResult {
        val currentFieldState = state.fieldStates[event.fieldId]
            ?: return FormReducerResult(state)

        val newFieldState = currentFieldState.copy(
            value = event.value,
            isDirty = event.value != currentFieldState.defaultValue
        )

        val newFieldStates = state.fieldStates + (event.fieldId to newFieldState)

        // Trigger current field first to recalculate properties and validate
        val currentFieldTriggerResult = triggerField(
            fieldId = event.fieldId,
            fieldStates = newFieldStates,
            errors = state.errors,
            defnForm = defnForm,
            compSchemaMap = state.compSchemaMap
        ) ?: TriggerResult(newFieldStates, state.errors)

        // Then trigger dependent fields
        val dependents = state.fieldDependencies.getDependents(event.fieldId)
        val triggerResult = triggerDependentFields(
            fieldStates = currentFieldTriggerResult.fieldStates,
            dependentIds = dependents,
            defnForm = defnForm,
            errors = currentFieldTriggerResult.errors,
            compSchemaMap = state.compSchemaMap
        )

        val newState = state.copy(
            fieldStates = triggerResult.fieldStates,
            errors = triggerResult.errors
        )

        val intent = FormIntent.Watch(
            fieldId = event.fieldId,
            fieldValue = event.value,
            valueMap = newState.getValueMap()
        )

        return FormReducerResult(newState, intent)
    }

    fun handleFieldFocused(
        state: FormState,
        event: FormEvent.FieldFocused
    ): FormReducerResult {
        val currentFieldState = state.fieldStates[event.fieldId]
            ?: return FormReducerResult(state)

        val newFieldState = currentFieldState.copy(isFocused = true)
        val newState = state.copy(
            fieldStates = state.fieldStates + (event.fieldId to newFieldState)
        )

        return FormReducerResult(newState)
    }

    fun handleFieldBlurred(
        state: FormState,
        event: FormEvent.FieldBlurred
    ): FormReducerResult {
        val currentFieldState = state.fieldStates[event.fieldId]
            ?: return FormReducerResult(state)

        val newFieldState = currentFieldState.copy(
            isFocused = false,
            isTouched = true
        )
        val newState = state.copy(
            fieldStates = state.fieldStates + (event.fieldId to newFieldState)
        )

        return FormReducerResult(newState)
    }

    fun handleFieldTouched(
        state: FormState,
        event: FormEvent.FieldTouched
    ): FormReducerResult {
        val currentFieldState = state.fieldStates[event.fieldId]
            ?: return FormReducerResult(state)

        val newFieldState = currentFieldState.copy(isTouched = true)
        val newState = state.copy(
            fieldStates = state.fieldStates + (event.fieldId to newFieldState)
        )

        return FormReducerResult(newState)
    }

    fun handleTriggerField(
        state: FormState,
        event: FormEvent.TriggerField,
        defnForm: DefnFormData
    ): FormReducerResult {
        val result = triggerField(
            fieldId = event.fieldId,
            fieldStates = state.fieldStates,
            errors = state.errors,
            defnForm = defnForm,
            compSchemaMap = state.compSchemaMap
        ) ?: return FormReducerResult(state)

        val newState = state.copy(
            fieldStates = result.fieldStates,
            errors = result.errors
        )

        return FormReducerResult(newState)
    }

    fun handleSubmit(state: FormState): FormReducerResult {
        val validationResult = FormCtxValidationHelper.handleValidateAll(state)
        val validatedState = validationResult.state

        if (!validatedState.isValid) {
            return FormReducerResult(validatedState)
        }

        val newState = validatedState.copy(isSubmitting = true)
        val intent = FormIntent.Submit(valueMap = validatedState.getValueMap())

        return FormReducerResult(newState, intent)
    }

    fun handleReset(
        state: FormState,
        event: FormEvent.Reset
    ): FormReducerResult {
        val initialValueMap = event.valueMap
            ?: state.initialFormValue?.valueMap
            ?: emptyMap()

        val resetFieldStates = state.fieldStates.mapValues { (fieldId, fieldState) ->
            val value = initialValueMap[fieldId]
            fieldState.copy(
                value = value,
                defaultValue = value,
                isTouched = false,
                isDirty = false,
                isFocused = false
            )
        }

        val newState = state.copy(
            fieldStates = resetFieldStates,
            errors = emptyMap(),
            isSubmitting = false
        )

        return FormReducerResult(newState)
    }

    fun handleSetValues(
        state: FormState,
        event: FormEvent.SetValues
    ): FormReducerResult {
        val updatedFieldStates = state.fieldStates.mapValues { (fieldId, fieldState) ->
            val newValue = event.valueMap[fieldId]
            if (newValue != null) {
                fieldState.copy(
                    value = newValue,
                    isDirty = newValue != fieldState.defaultValue
                )
            } else {
                fieldState
            }
        }

        val newState = state.copy(fieldStates = updatedFieldStates)
        return FormReducerResult(newState)
    }

    internal fun triggerDependentFields(
        fieldStates: Map<MetaIdComp, FieldState>,
        dependentIds: Set<MetaIdComp>,
        defnForm: DefnFormData,
        errors: Map<MetaIdComp, FieldError>,
        compSchemaMap: Map<MetaIdComp, DefnCompSchema>
    ): TriggerResult {
        if (dependentIds.isEmpty()) return TriggerResult(fieldStates, errors)

        var updatedFieldStates = fieldStates
        var updatedErrors = errors

        dependentIds.forEach { dependentId ->
            val result = triggerField(
                fieldId = dependentId,
                fieldStates = updatedFieldStates,
                errors = updatedErrors,
                defnForm = defnForm,
                compSchemaMap = compSchemaMap
            ) ?: return@forEach

            updatedFieldStates = result.fieldStates
            updatedErrors = result.errors
        }

        return TriggerResult(updatedFieldStates, updatedErrors)
    }

    /**
     * Trigger a single field: recalculate properties and validate.
     *
     * @return Updated field states and errors, or null if field/defnComp not found
     */
    private fun triggerField(
        fieldId: MetaIdComp,
        fieldStates: Map<MetaIdComp, FieldState>,
        errors: Map<MetaIdComp, FieldError>,
        defnForm: DefnFormData,
        compSchemaMap: Map<MetaIdComp, DefnCompSchema>
    ): TriggerResult? {
        defnForm.compMap[fieldId] ?: return null
        val currentFieldState = fieldStates[fieldId] ?: return null

        // 1. Recalculate field properties
        val newFieldState = calcCompProperties(
            fieldId = fieldId,
            currentFieldState = currentFieldState,
            defnForm = defnForm,
            fieldStates = fieldStates
        )
        val updatedFieldStates = fieldStates + (fieldId to newFieldState)

        // 2. Validate field and update errors
        val updatedErrors = validateField(
            fieldId = fieldId,
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
        defnForm: DefnFormData,
        fieldStates: Map<MetaIdComp, FieldState>
    ): FieldState {
        val defnComp = defnForm.compMap[fieldId] ?: return currentFieldState

        val newProperties = FieldPropertyResolver.resolveFieldProperties(
            defnComp = defnComp,
            defnForm = defnForm,
            getFieldValue = { id -> fieldStates[id]?.value }
        )

        return currentFieldState.copy(fieldProperties = newProperties)
    }

    /**
     * Validate a single field and update errors map accordingly.
     * Sets error if validation fails, clears error if validation passes.
     *
     * Uses pure validation (no side effects) to avoid dispatching events
     * during event processing.
     *
     * @return Updated errors map with error set or cleared for this field
     */
    private fun validateField(
        fieldId: MetaIdComp,
        fieldState: FieldState,
        errors: Map<MetaIdComp, FieldError>,
        compSchemaMap: Map<MetaIdComp, DefnCompSchema>
    ): Map<MetaIdComp, FieldError> {
        val schema = compSchemaMap[fieldId]
            ?: return errors // No schema = no validation needed

        // Use pure validation to get error without side effects
        val error = schema.validatePure(fieldState.value, fieldState)

        return if (error != null) {
            // Set error
            errors + (fieldId to FieldError(
                message = error,
                type = FieldError.ErrorType.Validation
            ))
        } else {
            // Clear error (only validation errors, keep custom/server errors)
            val existingError = errors[fieldId]
            if (existingError?.type == FieldError.ErrorType.Validation) {
                errors - fieldId
            } else {
                errors
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
