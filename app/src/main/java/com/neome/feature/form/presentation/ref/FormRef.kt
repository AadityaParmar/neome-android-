package com.neome.feature.form.presentation.ref

import com.neome.api.meta.base.dto.FormValueRaw
import kotlinx.coroutines.flow.StateFlow

/**
 * Imperative API for form field operations.
 * Inspired by React Hook Form's ref pattern.
 *
 * FormRef manages all runtime state internally (not in FormState):
 * - Field values
 * - Validation errors
 * - Dirty state
 * - Touched state
 */
interface FormRef {

    /**
     * Get single field value by ID.
     * @return Field value or null if field doesn't exist
     */
    fun <T> getValue(fieldId: String): T?

    /**
     * Get all form values as FormValueRaw.
     * @return Complete form data ready for API submission
     */
    fun getValues(): FormValueRaw?

    /**
     * Set single field value.
     * @param fieldId Field identifier
     * @param value New value
     * @param shouldValidate Whether to validate after setting (default: true)
     */
    fun <T> setValue(fieldId: String, value: T, shouldValidate: Boolean = true)

    /**
     * Set multiple field values from FormValueRaw.
     * Useful for prefilling form with existing data.
     * @param formValueRaw Form data to populate
     * @param shouldValidate Whether to validate after setting (default: true)
     */
    fun setValues(formValueRaw: FormValueRaw, shouldValidate: Boolean = true)

    /**
     * Trigger validation for specific field or entire form.
     * @param fieldId Field to validate, or null for entire form
     * @return true if validation passed
     */
    fun trigger(fieldId: String? = null): Boolean

    /**
     * Reset form to initial values or provided values.
     * @param formValueRaw Optional new initial values
     */
    fun reset(formValueRaw: FormValueRaw? = null)

    /**
     * Clear validation errors.
     * @param fieldId Field to clear errors for, or null for all fields
     */
    fun clearErrors(fieldId: String? = null)

    /**
     * Set custom validation error for a field.
     * @param fieldId Field identifier
     * @param error Error message
     */
    fun setError(fieldId: String, error: String)

    /**
     * Watch field value changes as StateFlow.
     * Use in Composables with collectAsStateWithLifecycle().
     *
     * @param fieldId Field identifier
     * @return StateFlow of field value
     */
    fun <T> watch(fieldId: String): StateFlow<T?>

    /**
     * Check if field or form is dirty (modified from initial value).
     * @param fieldId Field to check, or null for entire form
     * @return true if dirty
     */
    fun isDirty(fieldId: String? = null): Boolean

    /**
     * Check if field or form is valid.
     * @param fieldId Field to check, or null for entire form
     * @return true if valid
     */
    fun isValid(fieldId: String? = null): Boolean
}
