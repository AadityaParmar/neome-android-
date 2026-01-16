package com.neome.feature.form.domain.ref

import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.core.common.serializer.api.meta.base.dto.FormValueRawData
import com.neome.feature.form.presentation.state.FieldState
import com.neome.feature.form.presentation.state.FormEvent
import com.neome.feature.form.presentation.state.FormState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.serialization.json.JsonElement

/**
 * Implementation of FormRef that provides external API for form operations.
 *
 * @param formStateFlow StateFlow of the current FormState
 * @param dispatchEvent Function to dispatch FormEvent
 * @param coroutineScope CoroutineScope for managing StateFlows
 */
class FormRefImpl(
    private val formStateFlow: StateFlow<FormState>,
    private val dispatchEvent: (FormEvent) -> Unit,
    private val coroutineScope: CoroutineScope
) : FormRef {

    private val currentState: FormState
        get() = formStateFlow.value

    // Cache for field state StateFlows
    private val fieldStateFlows = mutableMapOf<MetaIdComp, StateFlow<FieldState?>>()

    // ==================== Read Operations ====================

    override fun getValue(fieldId: MetaIdComp): JsonElement? {
        return currentState.getValue(fieldId)
    }

    override fun getValues(): FormValueRawData? {
        val state = currentState
        val initialValue = state.initialFormValue ?: return null

        return FormValueRawData(
            createdBy = initialValue.createdBy,
            createdOn = initialValue.createdOn,
            rowId = initialValue.rowId,
            rowOrder = initialValue.rowOrder,
            updatedBy = initialValue.updatedBy,
            updatedOn = initialValue.updatedOn,
            valueMap = state.getValueMap()
        )
    }

    override fun getValueMap(): Map<MetaIdComp, JsonElement> {
        return currentState.getValueMap()
    }

    override fun getFieldState(fieldId: MetaIdComp): FieldState? {
        return currentState.getFieldState(fieldId)
    }

    // ==================== Write Operations ====================

    override fun setValue(fieldId: MetaIdComp, value: JsonElement?, shouldValidate: Boolean) {
        dispatchEvent(FormEvent.FieldValueChanged(fieldId, value, shouldValidate))
    }

    override fun setValues(valueMap: Map<MetaIdComp, JsonElement>, shouldValidate: Boolean) {
        dispatchEvent(FormEvent.SetValues(valueMap, shouldValidate))
    }

    // ==================== Validation ====================

    override fun validate(fieldId: MetaIdComp?): Boolean {
        if (fieldId != null) {
            dispatchEvent(FormEvent.ValidateField(fieldId))
            // Return validation result from current state
            return !currentState.hasError(fieldId)
        } else {
            dispatchEvent(FormEvent.ValidateAll)
            // Return validation result from current state
            return currentState.isValid
        }
    }

    override fun setError(fieldId: MetaIdComp, error: String) {
        dispatchEvent(FormEvent.SetFieldError(fieldId, error))
    }

    override fun clearErrors(fieldId: MetaIdComp?) {
        if (fieldId != null) {
            dispatchEvent(FormEvent.ClearFieldError(fieldId))
        } else {
            dispatchEvent(FormEvent.ClearAllErrors)
        }
    }

    // ==================== Form Operations ====================

    override fun submit() {
        dispatchEvent(FormEvent.Submit)
    }

    override fun reset(valueMap: Map<MetaIdComp, JsonElement>?) {
        dispatchEvent(FormEvent.Reset(valueMap))
    }

    // ==================== State Queries ====================

    override fun isDirty(fieldId: MetaIdComp?): Boolean {
        val state = currentState
        return if (fieldId != null) {
            state.getFieldState(fieldId)?.isDirty ?: false
        } else {
            state.isDirty
        }
    }

    override fun isValid(fieldId: MetaIdComp?): Boolean {
        val state = currentState
        return if (fieldId != null) {
            !state.hasError(fieldId) && state.getFieldState(fieldId)?.let { fieldState ->
                !fieldState.fieldProperties.required || fieldState.value != null
            } ?: true
        } else {
            state.isValid
        }
    }

    override fun isTouched(fieldId: MetaIdComp?): Boolean {
        val state = currentState
        return if (fieldId != null) {
            state.getFieldState(fieldId)?.isTouched ?: false
        } else {
            state.fieldStates.values.any { it.isTouched }
        }
    }

    // ==================== Reactive Streams ====================

    override fun watchFieldState(fieldId: MetaIdComp): StateFlow<FieldState?> {
        // Return cached StateFlow or create a new one
        return fieldStateFlows.getOrPut(fieldId) {
            formStateFlow
                .map { formState -> formState.getFieldState(fieldId) }
                .distinctUntilChanged()
                .stateIn(
                    scope = coroutineScope,
                    started = SharingStarted.WhileSubscribed(5000),
                    initialValue = currentState.getFieldState(fieldId)
                )
        }
    }

    override fun watchFormState(): StateFlow<FormState> {
        return formStateFlow
    }
}
