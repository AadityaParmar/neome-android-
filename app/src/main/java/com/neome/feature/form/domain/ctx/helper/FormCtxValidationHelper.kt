package com.neome.feature.form.domain.ctx.helper

import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.feature.form.presentation.state.FieldError
import com.neome.feature.form.presentation.state.FormEvent
import com.neome.feature.form.presentation.state.FormState

object FormCtxValidationHelper {

    fun handleValidateField(
        state: FormState,
        event: FormEvent.ValidateField
    ): FormReducerResult {
        val currentFieldState = state.fieldStates[event.fieldId]
            ?: return FormReducerResult(state)

        val schema = state.compSchemaMap[event.fieldId]
            ?: return FormReducerResult(state) // No schema = no validation needed

        // 1. Mark as validating
        val validatingFieldState = currentFieldState.copy(isValidating = true)

        // 2. Use pure validation to get error without side effects
        val error = schema.validatePure(currentFieldState.value, currentFieldState)

        // 3. Update errors map
        val updatedErrors = updateFieldError(
            fieldId = event.fieldId,
            error = error,
            errors = state.errors
        )

        // 4. Mark as not validating
        val finalFieldState = validatingFieldState.copy(isValidating = false)

        val newState = state.copy(
            fieldStates = state.fieldStates + (event.fieldId to finalFieldState),
            errors = updatedErrors
        )

        return FormReducerResult(newState)
    }

    fun handleValidateAll(state: FormState): FormReducerResult {
        // 1. Mark all as validating
        val validatingFieldStates = state.fieldStates.mapValues { (_, fieldState) ->
            fieldState.copy(isValidating = true)
        }

        // 2. Validate all fields with schemas using pure validation
        var updatedErrors = state.errors
        state.compSchemaMap.forEach { (fieldId, schema) ->
            val fieldState = state.fieldStates[fieldId]
            val error = schema.validatePure(fieldState?.value, fieldState)
            updatedErrors = updateFieldError(
                fieldId = fieldId,
                error = error,
                errors = updatedErrors
            )
        }

        // 3. Mark all as not validating
        val finalFieldStates = validatingFieldStates.mapValues { (_, fieldState) ->
            fieldState.copy(isValidating = false)
        }

        val newState = state.copy(
            fieldStates = finalFieldStates,
            errors = updatedErrors
        )

        return FormReducerResult(newState)
    }

    /**
     * Update errors map for a single field based on validation result.
     * Sets error if validation fails, clears validation error if passes.
     * Preserves custom/server errors when clearing.
     *
     * @param fieldId The field to update
     * @param error The validation error message, or null if validation passed
     * @param errors The current errors map
     * @return Updated errors map
     */
    private fun updateFieldError(
        fieldId: MetaIdComp,
        error: String?,
        errors: Map<MetaIdComp, FieldError>
    ): Map<MetaIdComp, FieldError> {
        return if (error != null) {
            // Set validation error
            errors + (fieldId to FieldError(
                message = error,
                type = FieldError.ErrorType.Validation
            ))
        } else {
            // Clear error only if it's a validation error (preserve custom/server errors)
            val existingError = errors[fieldId]
            if (existingError?.type == FieldError.ErrorType.Validation) {
                errors - fieldId
            } else {
                errors
            }
        }
    }

    fun handleSetFieldError(
        state: FormState,
        event: FormEvent.SetFieldError
    ): FormReducerResult {
        val newErrors = state.errors + (event.fieldId to FieldError(
            message = event.error,
            type = FieldError.ErrorType.Custom
        ))

        val newState = state.copy(errors = newErrors)
        return FormReducerResult(newState)
    }

    fun handleClearFieldError(
        state: FormState,
        event: FormEvent.ClearFieldError
    ): FormReducerResult {
        val newState = state.copy(errors = state.errors - event.fieldId)
        return FormReducerResult(newState)
    }

    fun handleClearAllErrors(state: FormState): FormReducerResult {
        val newState = state.copy(errors = emptyMap())
        return FormReducerResult(newState)
    }
}
