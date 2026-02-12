package com.neome.feature.form.domain.ctx.helper

import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.feature.form.presentation.state.FieldError
import com.neome.feature.form.presentation.state.FormEvent
import com.neome.feature.form.presentation.state.FormIntent
import com.neome.feature.form.presentation.state.FormState
import com.neome.feature.form.presentation.state.SendBtnDisableFlag

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
        val error = schema.validate(state.valueMap[event.fieldId], currentFieldState)

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

        // Update Invalid flag based on new error state
        return updateInvalidFlag(newState)
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
            val error = schema.validate(state.valueMap[fieldId], fieldState)
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

        // Update Invalid flag based on new error state
        return updateInvalidFlag(newState)
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

        // Update Invalid flag based on new error state
        return updateInvalidFlag(newState)
    }

    fun handleClearFieldError(
        state: FormState,
        event: FormEvent.ClearFieldError
    ): FormReducerResult {
        val newState = state.copy(errors = state.errors - event.fieldId)

        // Update Invalid flag based on new error state
        return updateInvalidFlag(newState)
    }

    fun handleClearAllErrors(state: FormState): FormReducerResult {
        val newState = state.copy(errors = emptyMap())

        // Update Invalid flag based on new error state
        return updateInvalidFlag(newState)
    }

    /**
     * Updates the SendBtnDisableFlag.Invalid flag based on error state.
     * Returns updated state with correct flag and optional intent on transition.
     *
     * @param state The state after error changes
     * @return FormReducerResult with updated disableSendBtnSet and optional SendBtnStateChanged intent
     */
    private fun updateInvalidFlag(state: FormState): FormReducerResult {
        val hasErrors = state.errors.isNotEmpty()
        val hasInvalidFlag = SendBtnDisableFlag.Invalid in state.disableSendBtnSet

        return when {
            hasErrors && !hasInvalidFlag -> {
                // Add Invalid flag
                val wasEnabled = state.isSendBtnEnabled
                val newSet = state.disableSendBtnSet + SendBtnDisableFlag.Invalid
                val newState = state.copy(disableSendBtnSet = newSet)
                val intent = if (wasEnabled) FormIntent.SendBtnStateChanged(enabled = false) else null
                FormReducerResult(newState, intent)
            }

            !hasErrors && hasInvalidFlag -> {
                // Remove Invalid flag
                val newSet = state.disableSendBtnSet - SendBtnDisableFlag.Invalid
                val newState = state.copy(disableSendBtnSet = newSet)
                val isNowEnabled = newState.isSendBtnEnabled
                val intent = if (isNowEnabled) FormIntent.SendBtnStateChanged(enabled = true) else null
                FormReducerResult(newState, intent)
            }

            else -> FormReducerResult(state) // No change needed
        }
    }
}
