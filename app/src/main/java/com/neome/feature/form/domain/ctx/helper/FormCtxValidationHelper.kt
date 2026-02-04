package com.neome.feature.form.domain.ctx.helper

import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.api.meta.base.dto.DefnComp
import com.neome.feature.form.presentation.state.FieldError
import com.neome.feature.form.presentation.state.FieldState
import com.neome.feature.form.presentation.state.FormEvent
import com.neome.feature.form.presentation.state.FormState

object FormCtxValidationHelper {

    fun handleValidateField(
        state: FormState,
        event: FormEvent.ValidateField
    ): FormReducerResult {
        val currentFieldState = state.fieldStates[event.fieldId]
            ?: return FormReducerResult(state)

        val defnComp = state.defnForm?.compMap?.get(event.fieldId)
            ?: return FormReducerResult(state)

        val validatingFieldState = currentFieldState.copy(isValidating = true)
        val validatingState = state.copy(
            fieldStates = state.fieldStates + (event.fieldId to validatingFieldState)
        )

        val validationError = validateField(event.fieldId, currentFieldState, defnComp)

        val validationResultEvent = FormEvent.ValidationResult(event.fieldId, validationError)

        return handleValidationResult(validatingState, validationResultEvent)
    }

    fun handleValidationResult(
        state: FormState,
        event: FormEvent.ValidationResult
    ): FormReducerResult {
        val currentFieldState = state.fieldStates[event.fieldId]

        val newFieldStates = if (currentFieldState != null) {
            state.fieldStates + (event.fieldId to currentFieldState.copy(isValidating = false))
        } else {
            state.fieldStates
        }

        val newErrors = if (event.error != null) {
            state.errors + (event.fieldId to FieldError(message = event.error))
        } else {
            state.errors - event.fieldId
        }

        val newState = state.copy(
            fieldStates = newFieldStates,
            errors = newErrors
        )

        return FormReducerResult(newState)
    }

    fun handleValidateAll(state: FormState): FormReducerResult {
        val defnForm = state.defnForm ?: return FormReducerResult(state)

        val validatingFieldStates = state.fieldStates.mapValues { (_, fieldState) ->
            fieldState.copy(isValidating = true)
        }

        var validatingState = state.copy(fieldStates = validatingFieldStates)

        val validationResults = mutableListOf<FormEvent.ValidationResult>()

        state.fieldStates.forEach { (fieldId, fieldState) ->
            val defnComp = defnForm.compMap[fieldId] ?: return@forEach
            val error = validateField(fieldId, fieldState, defnComp)
            validationResults.add(FormEvent.ValidationResult(fieldId, error))
        }

        validationResults.forEach { result ->
            val resultState = handleValidationResult(validatingState, result)
            validatingState = resultState.state
        }

        return FormReducerResult(validatingState)
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

    internal fun validateField(
        fieldId: MetaIdComp,
        fieldState: FieldState,
        defnComp: DefnComp
    ): String? {
        if (fieldState.fieldProperties.required && fieldState.value == null) {
            return "This field is required"
        }

        return null
    }
}
