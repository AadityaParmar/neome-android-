package com.neome.feature.form.presentation.ref

import kotlinx.coroutines.flow.StateFlow

/**
 * Imperative API for external access to form state
 * Similar to React Hook Form's ref pattern
 */
interface FormRef {
    /**
     * Get value of a specific field
     */
    fun <T> getValue(fieldId: String): T?

    /**
     * Get all form values
     */
    fun getValues(): Map<String, Any?>

    /**
     * Set value of a specific field
     */
    fun <T> setValue(fieldId: String, value: T, shouldValidate: Boolean = true)

    /**
     * Set multiple field values
     */
    fun setValues(values: Map<String, Any?>, shouldValidate: Boolean = true)

    /**
     * Trigger validation for specific field or all fields
     */
    fun trigger(fieldId: String? = null): Boolean

    /**
     * Reset form to default or provided values
     */
    fun reset(values: Map<String, Any?>? = null)

    /**
     * Clear errors for specific field or all fields
     */
    fun clearErrors(fieldId: String? = null)

    /**
     * Set error for a specific field
     */
    fun setError(fieldId: String, error: String)

    /**
     * Watch field value changes
     */
    fun <T> watch(fieldId: String): StateFlow<T?>

    /**
     * Check if field or form is dirty
     */
    fun isDirty(fieldId: String? = null): Boolean

    /**
     * Check if field or form is valid
     */
    fun isValid(fieldId: String? = null): Boolean
}
