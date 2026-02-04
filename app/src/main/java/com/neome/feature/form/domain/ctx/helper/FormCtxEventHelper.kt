package com.neome.feature.form.domain.ctx.helper

import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.core.common.serializer.api.meta.base.dto.DefnFormData
import com.neome.feature.form.domain.util.FieldPropertyResolver
import com.neome.feature.form.presentation.state.FieldState
import com.neome.feature.form.presentation.state.FormEvent
import com.neome.feature.form.presentation.state.FormIntent
import com.neome.feature.form.presentation.state.FormState
import kotlinx.serialization.json.JsonElement

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

        val dependents = state.fieldDependencies.getDependents(event.fieldId)
        val updatedFieldStates = triggerDependentFields(
            fieldStates = newFieldStates,
            dependentIds = dependents,
            defnForm = defnForm
        )

        val newState = state.copy(fieldStates = updatedFieldStates)

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
        val defnComp = defnForm.compMap[event.fieldId]
            ?: return FormReducerResult(state)
        val currentFieldState = state.fieldStates[event.fieldId]
            ?: return FormReducerResult(state)

        val newProperties = FieldPropertyResolver.resolveFieldProperties(
            defnComp = defnComp,
            defnForm,
            getFieldValue = { id -> state.getValue(id) }
        )

        val newFieldState = currentFieldState.copy(fieldProperties = newProperties)
        val newState = state.copy(
            fieldStates = state.fieldStates + (event.fieldId to newFieldState)
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
        defnForm: DefnFormData
    ): Map<MetaIdComp, FieldState> {
        if (dependentIds.isEmpty()) return fieldStates

        val updates = dependentIds.mapNotNull { dependentId ->
            val defnComp = defnForm.compMap[dependentId] ?: return@mapNotNull null
            val currentState = fieldStates[dependentId] ?: return@mapNotNull null

            val newProperties = FieldPropertyResolver.resolveFieldProperties(
                defnComp = defnComp,
                defnForm,
                getFieldValue = { id -> fieldStates[id]?.value }
            )

            dependentId to currentState.copy(fieldProperties = newProperties)
        }.toMap()

        return fieldStates + updates
    }
}
