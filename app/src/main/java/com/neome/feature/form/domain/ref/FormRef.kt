package com.neome.feature.form.domain.ref

import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.core.common.serializer.api.meta.base.dto.FormValueRawData
import com.neome.feature.form.presentation.state.FieldState
import com.neome.feature.form.presentation.state.SendBtnStateFlag
import kotlinx.serialization.json.JsonElement

/**
 * External API for parent screens to interact with the Form component.
 *
 * Inspired by React Hook Form's ref pattern.
 * All operations are synchronous. State is updated immediately after each call.
 *
 * This provides an imperative API for:
 * - Reading form/field values
 * - Setting form/field values
 * - Error management
 * - Form operations (submit, reset)
 * - State queries (dirty, valid, touched)
 */
interface FormRef {

    // ==================== Read Operations ====================

    /**
     * Get single field value by ID.
     *
     * @param fieldId Field identifier
     * @return Field value or null if field doesn't exist or has no value
     */
    fun getValue(fieldId: MetaIdComp): JsonElement?

    /**
     * Get all form values as FormValueRawData.
     *
     * @return Complete form data ready for API submission, or null if form not initialized
     */
    fun getValues(): FormValueRawData?

    /**
     * Get all form values as a map.
     *
     * @return Map of field IDs to their current values
     */
    fun getValueMap(): Map<MetaIdComp, JsonElement>

    /**
     * Get field state by ID.
     *
     * @param fieldId Field identifier
     * @return FieldState or null if field doesn't exist
     */
    fun getFieldState(fieldId: MetaIdComp): FieldState?

    // ==================== Write Operations ====================

    /**
     * Set single field value.
     * Dispatches FieldValueChanged event internally.
     * Always triggers validation.
     *
     * @param fieldId Field identifier
     * @param value New value
     */
    fun setValue(fieldId: MetaIdComp, value: JsonElement?)

    /**
     * Set multiple field values at once.
     * Always triggers validation.
     *
     * @param valueMap Map of field IDs to values
     */
    fun setValues(valueMap: Map<MetaIdComp, JsonElement>)

    // ==================== Validation ====================

    /**
     * Validate a specific field or all fields.
     *
     * @param fieldId Field to validate, or null for entire form
     */
    fun validate(fieldId: MetaIdComp? = null)

    /**
     * Set custom validation error for a field.
     *
     * @param fieldId Field identifier
     * @param error Error message
     */
    fun setError(fieldId: MetaIdComp, error: String)

    /**
     * Clear validation errors.
     *
     * @param fieldId Field to clear errors for, or null for all fields
     */
    fun clearErrors(fieldId: MetaIdComp? = null)

    // ==================== Form Operations ====================

    /**
     * Submit the form.
     * Validates all fields and emits FormIntent.Submit if valid.
     */
    fun submit()

    /**
     * Reset form to initial values or provided values.
     *
     * @param valueMap Optional new values to reset to
     */
    fun reset(valueMap: Map<MetaIdComp, JsonElement>? = null)

    // ==================== State Queries ====================

    /**
     * Check if field or form is dirty (modified from initial value).
     *
     * @param fieldId Field to check, or null for entire form
     * @return true if dirty
     */
    fun isDirty(fieldId: MetaIdComp? = null): Boolean

    /**
     * Check if field or form is valid.
     *
     * @param fieldId Field to check, or null for entire form
     * @return true if valid
     */
    fun isValid(fieldId: MetaIdComp? = null): Boolean

    /**
     * Check if field or form is touched (user has interacted with it).
     *
     * @param fieldId Field to check, or null for entire form
     * @return true if touched
     */
    fun isTouched(fieldId: MetaIdComp? = null): Boolean

    // ==================== Send Button Control ====================

    /**
     * Add a send button state flag.
     * When any flag is present, the send button is disabled.
     *
     * @param flag The state flag to add
     */
    fun addSendBtnStateFlag(flag: SendBtnStateFlag)

    /**
     * Remove a send button state flag.
     * When all flags are removed, the send button is enabled.
     *
     * @param flag The state flag to remove
     */
    fun removeSendBtnStateFlag(flag: SendBtnStateFlag)

    /**
     * Check if send button is enabled.
     * Returns true when no disable flags are present.
     *
     * @return true if send button is enabled
     */
    fun isSendBtnEnabled(): Boolean

    /**
     * Check if send button should be invisible.
     * Returns true when the Invisible flag is present.
     *
     * @return true if send button should be invisible
     */
    fun isSendBtnInvisible(): Boolean
}
