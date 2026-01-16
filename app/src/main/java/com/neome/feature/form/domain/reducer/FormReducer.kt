package com.neome.feature.form.domain.reducer

import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.api.meta.base.dto.DefnComp
import com.neome.core.common.serializer.api.meta.base.dto.DefnFormData
import com.neome.feature.form.domain.util.PropertyResolver
import com.neome.feature.form.presentation.state.FieldError
import com.neome.feature.form.presentation.state.FieldState
import com.neome.feature.form.presentation.state.FormEvent
import com.neome.feature.form.presentation.state.FormIntent
import com.neome.feature.form.presentation.state.FormState

/**
 * Result of processing a FormEvent.
 * Contains the new state and optional side effect (intent to emit to parent).
 */
data class FormReducerResult(
    val state: FormState,
    val intent: FormIntent? = null
)

/**
 * Pure reducer for Form state management.
 *
 * Follows MVI pattern:
 * - Takes current state and event
 * - Returns new state and optional side effect
 * - No side effects inside reducer (pure function)
 */
object FormReducer {

    /**
     * Process a FormEvent and return new state with optional intent.
     *
     * @param state Current form state
     * @param event Event to process
     * @param defnForm Form definition (needed for property resolution)
     * @return FormReducerResult containing new state and optional intent
     */
    fun reduce(
        state: FormState,
        event: FormEvent,
        defnForm: DefnFormData
    ): FormReducerResult {
        return when (event) {
            is FormEvent.Initialize -> handleInitialize(state)
            is FormEvent.FieldValueChanged -> handleFieldValueChanged(state, event, defnForm)
            is FormEvent.FieldFocused -> handleFieldFocused(state, event)
            is FormEvent.FieldBlurred -> handleFieldBlurred(state, event)
            is FormEvent.FieldTouched -> handleFieldTouched(state, event)
            is FormEvent.TriggerField -> handleTriggerField(state, event, defnForm)
            is FormEvent.ValidateField -> handleValidateField(state, event)
            is FormEvent.ValidationResult -> handleValidationResult(state, event)
            is FormEvent.ValidateAll -> handleValidateAll(state)
            is FormEvent.SetFieldError -> handleSetFieldError(state, event)
            is FormEvent.ClearFieldError -> handleClearFieldError(state, event)
            is FormEvent.ClearAllErrors -> handleClearAllErrors(state)
            is FormEvent.Submit -> handleSubmit(state)
            is FormEvent.Reset -> handleReset(state, event)
            is FormEvent.SetValues -> handleSetValues(state, event)
        }
    }

    // ==================== Event Handlers ====================

    private fun handleInitialize(state: FormState): FormReducerResult {
        // Actual initialization is done by initializeFormState()
        return FormReducerResult(state)
    }

    private fun handleFieldValueChanged(
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

        // Trigger dependent fields to recalculate properties
        val dependents = state.fieldDependencies.getDependents(event.fieldId)
        val updatedFieldStates = triggerDependentFields(
            fieldStates = newFieldStates,
            dependentIds = dependents,
            defnForm = defnForm
        )

        val newState = state.copy(fieldStates = updatedFieldStates)

        // Emit Watch intent
        val intent = FormIntent.Watch(
            fieldId = event.fieldId,
            fieldValue = event.value,
            valueMap = newState.getValueMap()
        )

        return FormReducerResult(newState, intent)
    }

    private fun handleFieldFocused(
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

    private fun handleFieldBlurred(
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

    private fun handleFieldTouched(
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

    private fun handleTriggerField(
        state: FormState,
        event: FormEvent.TriggerField,
        defnForm: DefnFormData
    ): FormReducerResult {
        val defnComp = defnForm.compMap[event.fieldId]
            ?: return FormReducerResult(state)
        val currentFieldState = state.fieldStates[event.fieldId]
            ?: return FormReducerResult(state)

        val newProperties = PropertyResolver.resolveFieldProperties(
            defnComp = defnComp,
            getFieldValue = { id -> state.getValue(id) }
        )

        val newFieldState = currentFieldState.copy(fieldProperties = newProperties)
        val newState = state.copy(
            fieldStates = state.fieldStates + (event.fieldId to newFieldState)
        )

        return FormReducerResult(newState)
    }

    private fun handleValidateField(
        state: FormState,
        event: FormEvent.ValidateField
    ): FormReducerResult {
        val currentFieldState = state.fieldStates[event.fieldId]
            ?: return FormReducerResult(state)

        val defnComp = state.defnForm?.compMap?.get(event.fieldId)
            ?: return FormReducerResult(state)

        // Mark field as validating
        val validatingFieldState = currentFieldState.copy(isValidating = true)
        val validatingState = state.copy(
            fieldStates = state.fieldStates + (event.fieldId to validatingFieldState)
        )

        // Perform validation
        val validationError = validateField(event.fieldId, currentFieldState, defnComp)

        // Emit validation result event
        val validationResultEvent = FormEvent.ValidationResult(event.fieldId, validationError)

        // Process the validation result immediately
        return handleValidationResult(validatingState, validationResultEvent)
    }

    private fun handleValidationResult(
        state: FormState,
        event: FormEvent.ValidationResult
    ): FormReducerResult {
        val currentFieldState = state.fieldStates[event.fieldId]

        // Update field validating state
        val newFieldStates = if (currentFieldState != null) {
            state.fieldStates + (event.fieldId to currentFieldState.copy(isValidating = false))
        } else {
            state.fieldStates
        }

        // Update errors map
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

    private fun handleValidateAll(state: FormState): FormReducerResult {
        val defnForm = state.defnForm ?: return FormReducerResult(state)

        // Mark all fields as validating
        val validatingFieldStates = state.fieldStates.mapValues { (_, fieldState) ->
            fieldState.copy(isValidating = true)
        }

        var validatingState = state.copy(fieldStates = validatingFieldStates)

        // Validate each field and collect results
        val validationResults = mutableListOf<FormEvent.ValidationResult>()

        state.fieldStates.forEach { (fieldId, fieldState) ->
            val defnComp = defnForm.compMap[fieldId] ?: return@forEach
            val error = validateField(fieldId, fieldState, defnComp)
            validationResults.add(FormEvent.ValidationResult(fieldId, error))
        }

        // Apply all validation results
        validationResults.forEach { result ->
            val resultState = handleValidationResult(validatingState, result)
            validatingState = resultState.state
        }

        return FormReducerResult(validatingState)
    }

    private fun handleSetFieldError(
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

    private fun handleClearFieldError(
        state: FormState,
        event: FormEvent.ClearFieldError
    ): FormReducerResult {
        val newState = state.copy(errors = state.errors - event.fieldId)
        return FormReducerResult(newState)
    }

    private fun handleClearAllErrors(state: FormState): FormReducerResult {
        val newState = state.copy(errors = emptyMap())
        return FormReducerResult(newState)
    }

    private fun handleSubmit(state: FormState): FormReducerResult {
        // Validate all fields before submitting
        val validationResult = handleValidateAll(state)
        val validatedState = validationResult.state

        // Check if form is valid after validation
        if (!validatedState.isValid) {
            // Form has validation errors, don't submit
            return FormReducerResult(validatedState)
        }

        // Form is valid, proceed with submission
        val newState = validatedState.copy(isSubmitting = true)
        val intent = FormIntent.Submit(valueMap = validatedState.getValueMap())

        return FormReducerResult(newState, intent)
    }

    private fun handleReset(
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

    private fun handleSetValues(
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

    // ==================== Helper Functions ====================

    /**
     * Trigger dependent fields to recalculate their properties (optimized batching).
     *
     * PERFORMANCE OPTIMIZATION:
     * - Batches all property recalculations for dependent fields
     * - Applies all updates in a single map operation (reduces map copies from N to 1)
     * - Prevents multiple sequential state copies
     */
    private fun triggerDependentFields(
        fieldStates: Map<MetaIdComp, FieldState>,
        dependentIds: Set<MetaIdComp>,
        defnForm: DefnFormData
    ): Map<MetaIdComp, FieldState> {
        if (dependentIds.isEmpty()) return fieldStates

        // Batch: Calculate new properties for ALL dependents at once
        val updates = dependentIds.mapNotNull { dependentId ->
            val defnComp = defnForm.compMap[dependentId] ?: return@mapNotNull null
            val currentState = fieldStates[dependentId] ?: return@mapNotNull null

            val newProperties = PropertyResolver.resolveFieldProperties(
                defnComp = defnComp,
                getFieldValue = { id -> fieldStates[id]?.value }
            )

            // Return update pair
            dependentId to currentState.copy(fieldProperties = newProperties)
        }.toMap()

        // Apply all updates in a single operation (1 map copy instead of N)
        return fieldStates + updates
    }

    // ==================== Validation Functions ====================

    /**
     * Validate a single field.
     *
     * @param fieldId The field to validate
     * @param fieldState Current field state
     * @param defnComp Field definition
     * @return Validation error message, or null if valid
     */
    private fun validateField(
        fieldId: MetaIdComp,
        fieldState: FieldState,
        defnComp: DefnComp
    ): String? {
        // Check required validation
        if (fieldState.fieldProperties.required && fieldState.value == null) {
            return "This field is required"
        }

        // TODO: Add more validation rules based on DefnComp type
        // For example: email validation, number range validation, etc.

        // Field is valid
        return null
    }
}
