package com.neome.feature.form.domain.ctx.base

import com.neome.feature.form.domain.ctx.FormStateAccessor
import com.neome.feature.form.presentation.state.FieldError
import com.neome.feature.form.presentation.state.FormEvent
import com.neome.feature.form.presentation.state.FormIntent
import com.neome.feature.form.presentation.state.SendBtnStateFlag

object FormCtxValidationHelper {

    fun handleValidateField(
        accessor: FormStateAccessor,
        event: FormEvent.ValidateField
    ) {
        val state = accessor.getState()
        val currentFieldState = accessor.getFieldState(event.fieldId)
            ?: return

        val schema = state.compSchemaMap[event.fieldId]
            ?: return // No schema = no validation needed

        // 1. Mark as validating
        val validatingFieldState = currentFieldState.copy(isValidating = true)

        // 2. Use pure validation to get error without side effects
        val error = schema.validate(accessor.getValue(event.fieldId), currentFieldState)

        // 3. Update errors map
        val fieldError = updateFieldError(error = error)
        accessor.setError(fieldId = event.fieldId, error = fieldError)


        // 4. Mark as not validating
        val finalFieldState = validatingFieldState.copy(isValidating = false)

        // 5. Update field state and errors
        accessor.setFieldState(event.fieldId, finalFieldState)

        // Update Invalid flag based on new error state
        updateInvalidFlag(accessor)
    }

    fun handleValidateAll(accessor: FormStateAccessor) {
        val state = accessor.getState()

        // 1. Mark all as validating
        val validatingFieldStates = state.fieldStates.mapValues { (_, fieldState) ->
            fieldState.copy(isValidating = true)
        }

        // 2. Validate all fields with schemas using pure validation
        var updatedErrors = state.errors
        state.compSchemaMap.forEach { (fieldId, schema) ->
            val fieldState = state.fieldStates[fieldId]
            val error = schema.validate(accessor.getValue(fieldId), fieldState)
            val fieldError = updateFieldError(error = error)
            accessor.setError(fieldId = fieldId, error = fieldError)
        }

        // 3. Mark all as not validating
        val finalFieldStates = validatingFieldStates.mapValues { (_, fieldState) ->
            fieldState.copy(isValidating = false)
        }

        // 4. Update field states and errors
        accessor.updateFieldStates(finalFieldStates)
        accessor.updateErrors(updatedErrors)

        // Update Invalid flag based on new error state
        updateInvalidFlag(accessor)
    }

    /**
     * Update errors map for a single field based on validation result.
     * Sets error if validation fails, clears validation error if passes.
     * Preserves custom/server errors when clearing.
     *
     * Shared by both [FormCtxValidationHelper] and [FormCtxEventHelper]
     * to avoid duplicating error update logic.
     *
     * @param error The validation error message, or null if validation passed
     * @return Updated FieldError, or null if validation passed
     */
    internal fun updateFieldError(error: String?): FieldError? {
        return if (error != null)
            FieldError(
                message = error,
                type = FieldError.ErrorType.Validation
            ) else null
    }

    fun handleSetFieldError(
        accessor: FormStateAccessor,
        event: FormEvent.SetFieldError
    ) {
        val newError = FieldError(
            message = event.error,
            type = FieldError.ErrorType.Custom
        )

        accessor.setError(event.fieldId, newError)

        // Update Invalid flag based on new error state
        updateInvalidFlag(accessor)
    }

    fun handleClearFieldError(
        accessor: FormStateAccessor,
        event: FormEvent.ClearFieldError
    ) {
        accessor.clearError(event.fieldId)

        // Update Invalid flag based on new error state
        updateInvalidFlag(accessor)
    }

    fun handleClearAllErrors(accessor: FormStateAccessor) {
        accessor.clearAllErrors()

        // Update Invalid flag based on new error state
        updateInvalidFlag(accessor)
    }

    /**
     * Updates the SendBtnStateFlag.Invalid flag based on error state.
     * Uses accessor to read/write sendBtnStateFlags and emit intent on transition.
     *
     * @param accessor The form state accessor for reading/writing
     */
    private fun updateInvalidFlag(accessor: FormStateAccessor) {
        val state = accessor.getState()
        val hasErrors = state.errors.isNotEmpty()
        val hasInvalidFlag = SendBtnStateFlag.Invalid in state.sendBtnStateFlags

        when {
            hasErrors && !hasInvalidFlag -> {
                // Add Invalid flag
                val wasEnabled = state.isSendBtnEnabled
                val wasInvisible = state.isSendBtnInvisible
                val newSet = state.sendBtnStateFlags + SendBtnStateFlag.Invalid
                accessor.setSendBtnStateFlags(newSet)

                val newState = accessor.getState()
                val isNowEnabled = newState.isSendBtnEnabled
                val isNowInvisible = newState.isSendBtnInvisible
                val intent = if (wasEnabled != isNowEnabled || wasInvisible != isNowInvisible) {
                    FormIntent.SendBtnStateChanged(enabled = isNowEnabled, invisible = isNowInvisible)
                } else null
                intent?.let { accessor.emitIntent(it) }
            }

            !hasErrors && hasInvalidFlag -> {
                // Remove Invalid flag
                val newSet = state.sendBtnStateFlags - SendBtnStateFlag.Invalid
                accessor.setSendBtnStateFlags(newSet)

                val newState = accessor.getState()
                val isNowEnabled = newState.isSendBtnEnabled
                val isNowInvisible = newState.isSendBtnInvisible
                val intent = if (isNowEnabled != state.isSendBtnEnabled || isNowInvisible != state.isSendBtnInvisible) {
                    FormIntent.SendBtnStateChanged(enabled = isNowEnabled, invisible = isNowInvisible)
                } else null
                intent?.let { accessor.emitIntent(it) }
            }

            else -> {} // No change needed
        }
    }
}
