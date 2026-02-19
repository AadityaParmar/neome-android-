package com.neome.feature.form.domain.ctx.helper

import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.feature.form.domain.DefnFormUi
import com.neome.feature.form.domain.ctx.helper.schema.CompSchema
import com.neome.feature.form.domain.util.FieldPropertyResolver
import com.neome.feature.form.presentation.state.FieldError
import com.neome.feature.form.presentation.state.FieldState
import com.neome.feature.form.presentation.state.FormEvent
import com.neome.feature.form.presentation.state.FormIntent
import com.neome.feature.form.presentation.state.FormState
import kotlinx.serialization.json.JsonElement

object FormCtxEventHelper {

    fun handleFieldValueChanged(
        state: FormState,
        event: FormEvent.FieldValueChanged,
        defnForm: DefnFormUi
    ): FormReducerResult {
        val currentFieldState = state.fieldStates[event.fieldId]
            ?: return FormReducerResult(state)

        // Update valueMap
        val newValueMap = if (event.value != null) {
            state.valueMap + (event.fieldId to event.value)
        } else {
            state.valueMap - event.fieldId
        }

        val newFieldState = currentFieldState.copy(
            isDirty = event.value != currentFieldState.defaultValue
        )

        val newFieldStates = state.fieldStates + (event.fieldId to newFieldState)

        // Trigger current field first to recalculate properties and validate
        val currentFieldTriggerResult = triggerField(
            fieldId = event.fieldId,
            fieldStates = newFieldStates,
            valueMap = newValueMap,
            errors = state.errors,
            defnForm = defnForm,
            compSchemaMap = state.compSchemaMap
        ) ?: TriggerResult(newFieldStates, state.errors)

        // Then trigger dependent fields
        val dependents = state.fieldDependencies.getDependents(event.fieldId)
        val triggerResult = triggerDependentFields(
            fieldStates = currentFieldTriggerResult.fieldStates,
            valueMap = newValueMap,
            dependentIds = dependents,
            defnForm = defnForm,
            errors = currentFieldTriggerResult.errors,
            compSchemaMap = state.compSchemaMap
        )

        var newState = state.copy(
            fieldStates = triggerResult.fieldStates,
            valueMap = newValueMap,
            errors = triggerResult.errors
        )

        val intent = FormIntent.Watch(
            fieldId = event.fieldId,
            fieldValue = event.value,
            valueMap = newState.valueMap
        )

        // Execute onChange form events for this field
        val categorizedEvents = newState.categorizedEvents
        if (categorizedEvents != null) {
            val onChangeEventIds = categorizedEvents.onChangeMap[event.fieldId]
            if (!onChangeEventIds.isNullOrEmpty()) {
                var stateAfterEvents = newState
                for (eventId in onChangeEventIds) {
                    stateAfterEvents = FormCtxFormEvents.executeEvent(
                        eventId = eventId,
                        state = stateAfterEvents,
                        defnForm = defnForm
                    )
                }
                newState = stateAfterEvents
            }
        }

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
        defnForm: DefnFormUi
    ): FormReducerResult {
        val result = triggerField(
            fieldId = event.fieldId,
            fieldStates = state.fieldStates,
            valueMap = state.valueMap,
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
        val intent = FormIntent.Submit(valueMap = validatedState.valueMap)

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
                defaultValue = value,
                isTouched = false,
                isDirty = false,
                isFocused = false
            )
        }

        // Build reset valueMap (only non-null entries from initialValueMap for leaf fields)
        val resetValueMap = initialValueMap.filterKeys { state.fieldStates.containsKey(it) }

        val newState = state.copy(
            fieldStates = resetFieldStates,
            valueMap = resetValueMap,
            errors = emptyMap(),
            isSubmitting = false
        )

        return FormReducerResult(newState)
    }

    fun handleSetValues(
        state: FormState,
        event: FormEvent.SetValues,
        defnForm: DefnFormUi
    ): FormReducerResult {
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
        val updatedValueMap = state.valueMap + validKeys

        // Trigger each changed field and its dependents to recalculate properties and validate
        var currentFieldStates = updatedFieldStates
        var currentErrors = state.errors
        val changedFieldIds = validKeys.keys

        changedFieldIds.forEach { fieldId ->
            // Trigger the changed field itself
            val fieldTriggerResult = triggerField(
                fieldId = fieldId,
                fieldStates = currentFieldStates,
                valueMap = updatedValueMap,
                errors = currentErrors,
                defnForm = defnForm,
                compSchemaMap = state.compSchemaMap
            )
            if (fieldTriggerResult != null) {
                currentFieldStates = fieldTriggerResult.fieldStates
                currentErrors = fieldTriggerResult.errors
            }

            // Trigger dependent fields
            val dependents = state.fieldDependencies.getDependents(fieldId)
            val dependentResult = triggerDependentFields(
                fieldStates = currentFieldStates,
                valueMap = updatedValueMap,
                dependentIds = dependents,
                defnForm = defnForm,
                errors = currentErrors,
                compSchemaMap = state.compSchemaMap
            )
            currentFieldStates = dependentResult.fieldStates
            currentErrors = dependentResult.errors
        }

        val newState = state.copy(
            fieldStates = currentFieldStates,
            valueMap = updatedValueMap,
            errors = currentErrors
        )
        return FormReducerResult(newState)
    }

    internal fun triggerDependentFields(
        fieldStates: Map<MetaIdComp, FieldState>,
        valueMap: Map<MetaIdComp, JsonElement>,
        dependentIds: Set<MetaIdComp>,
        defnForm: DefnFormUi,
        errors: Map<MetaIdComp, FieldError>,
        compSchemaMap: Map<MetaIdComp, CompSchema>
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
        valueMap: Map<MetaIdComp, JsonElement>,
        errors: Map<MetaIdComp, FieldError>,
        defnForm: DefnFormUi,
        compSchemaMap: Map<MetaIdComp, CompSchema>
    ): TriggerResult? {
        defnForm.compMap[fieldId] ?: return null
        val currentFieldState = fieldStates[fieldId] ?: return null

        // 1. Recalculate field properties
        val newFieldState = calcCompProperties(
            fieldId = fieldId,
            currentFieldState = currentFieldState,
            defnForm = defnForm,
            valueMap = valueMap
        )
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
     * Result of triggering field(s) containing updated field states and errors.
     */
    data class TriggerResult(
        val fieldStates: Map<MetaIdComp, FieldState>,
        val errors: Map<MetaIdComp, FieldError>
    )
}
