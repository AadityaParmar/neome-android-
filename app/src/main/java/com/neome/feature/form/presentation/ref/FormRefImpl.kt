package com.neome.feature.form.presentation.ref

import com.neome.api.meta.base.dto.DefnForm
import com.neome.api.meta.base.dto.FormValueRaw
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * Implementation of FormRef interface.
 * Manages all runtime form state internally.
 *
 * @param scope CoroutineScope for managing StateFlows (typically viewModelScope)
 */
class FormRefImpl(
    private val scope: CoroutineScope
) : FormRef {

    // Internal state management
    private var defnForm: DefnForm? = null
    private var initialFormValue: FormValueRaw? = null

    // Field values: fieldId -> StateFlow<Any?>
    private val fieldValues = mutableMapOf<String, MutableStateFlow<Any?>>()

    // Field errors: fieldId -> error message
    private val fieldErrors = mutableMapOf<String, String>()

    // Dirty tracking: fieldId -> isDirty
    private val fieldDirtyState = mutableMapOf<String, Boolean>()

    // Touched tracking: fieldId -> isTouched
    private val fieldTouchedState = mutableMapOf<String, Boolean>()

    /**
     * Initialize FormRef with form definition and initial values.
     * Must be called before using FormRef.
     */
    fun initialize(defnForm: DefnForm, formValueRaw: FormValueRaw?) {
        this.defnForm = defnForm
        this.initialFormValue = formValueRaw

        // Initialize field values from initialFormValue
        formValueRaw?.valueMap?.forEach { fieldId, value ->
            val flow = MutableStateFlow<Any?>(value)
            fieldValues[fieldId.toString()] = flow
            fieldDirtyState[fieldId.toString()] = false
            fieldTouchedState[fieldId.toString()] = false
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T> getValue(fieldId: String): T? {
        return fieldValues[fieldId]?.value as? T
    }

    override fun getValues(): FormValueRaw? {
        // TODO: Construct FormValueRaw from current field values
        // For now, return a basic implementation
        return null
    }

    override fun <T> setValue(fieldId: String, value: T, shouldValidate: Boolean) {
        // Get or create StateFlow for this field
        val flow = fieldValues.getOrPut(fieldId) {
            MutableStateFlow<Any?>(null)
        }

        // Update value
        flow.value = value

        // Mark as dirty and touched
        fieldDirtyState[fieldId] = true
        fieldTouchedState[fieldId] = true

        // Validate if requested
        if (shouldValidate) {
            trigger(fieldId)
        }
    }

    override fun setValues(formValueRaw: FormValueRaw, shouldValidate: Boolean) {
        formValueRaw.valueMap?.forEach { fieldId, value ->
            setValue(fieldId.toString(), value, shouldValidate = false)
        }

        if (shouldValidate) {
            trigger(null)
        }
    }

    override fun trigger(fieldId: String?): Boolean {
        // TODO: Implement validation logic
        // For now, always return true
        return if (fieldId != null) {
            // Validate single field
            validateField(fieldId)
        } else {
            // Validate all fields
            validateAllFields()
        }
    }

    override fun reset(formValueRaw: FormValueRaw?) {
        val valueToReset = formValueRaw ?: initialFormValue

        // Clear all state
        fieldValues.clear()
        fieldErrors.clear()
        fieldDirtyState.clear()
        fieldTouchedState.clear()

        // Re-initialize with reset values
        valueToReset?.valueMap?.forEach { fieldId, value ->
            val flow = MutableStateFlow<Any?>(value)
            fieldValues[fieldId.toString()] = flow
            fieldDirtyState[fieldId.toString()] = false
            fieldTouchedState[fieldId.toString()] = false
        }
    }

    override fun clearErrors(fieldId: String?) {
        if (fieldId != null) {
            fieldErrors.remove(fieldId)
        } else {
            fieldErrors.clear()
        }
    }

    override fun setError(fieldId: String, error: String) {
        fieldErrors[fieldId] = error
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T> watch(fieldId: String): StateFlow<T?> {
        val flow = fieldValues.getOrPut(fieldId) {
            MutableStateFlow<Any?>(null)
        }
        return flow.asStateFlow() as StateFlow<T?>
    }

    override fun isDirty(fieldId: String?): Boolean {
        return if (fieldId != null) {
            fieldDirtyState[fieldId] ?: false
        } else {
            fieldDirtyState.values.any { it }
        }
    }

    override fun isValid(fieldId: String?): Boolean {
        return if (fieldId != null) {
            !fieldErrors.containsKey(fieldId)
        } else {
            fieldErrors.isEmpty()
        }
    }

    // Private validation methods

    private fun validateField(fieldId: String): Boolean {
        // TODO: Implement field-specific validation
        // For now, always return true
        clearErrors(fieldId)
        return true
    }

    private fun validateAllFields(): Boolean {
        // TODO: Implement full form validation
        // For now, always return true
        clearErrors(null)
        return true
    }
}
