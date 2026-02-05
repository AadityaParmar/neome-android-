package com.neome.feature.form.domain.ref

import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.core.common.serializer.api.meta.base.dto.FormValueRawData
import com.neome.feature.form.presentation.state.FieldState
import com.neome.feature.form.presentation.state.FormState
import com.neome.feature.form.presentation.state.SendBtnDisableFlag
import kotlinx.coroutines.flow.StateFlow
import kotlinx.serialization.json.JsonElement

/**
 * External API for parent screens to interact with the Form component.
 *
 * Inspired by React Hook Form's ref pattern.
 * This provides an imperative API for:
 * - Reading form/field values
 * - Setting form/field values
 * - Error management
 * - Form operations (submit, reset)
 * - State queries (dirty, valid, touched)
 * - Reactive state watching
 *
 * Note: For validation and watching state, use FormCtx which is available
 * internally to field components.
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
     *
     * @param fieldId Field identifier
     * @param value New value
     * @param shouldValidate Whether to validate after setting (default: true)
     */
    fun setValue(fieldId: MetaIdComp, value: JsonElement?, shouldValidate: Boolean = true)

    /**
     * Set multiple field values at once.
     * Sets FormValueRawData.valueMap.
     *
     * @param valueMap Map of field IDs to values
     * @param shouldValidate Whether to validate after setting (default: true)
     */
    fun setValues(valueMap: Map<MetaIdComp, JsonElement>, shouldValidate: Boolean = true)

    // ==================== Validation ====================

    /**
     * Validate a specific field or all fields.
     *
     * @param fieldId Field to validate, or null for entire form
     * @return true if validation passed
     */
    fun validate(fieldId: MetaIdComp? = null): Boolean

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

    // ==================== Reactive Streams ====================

    /**
     * Watch field state changes as StateFlow.
     * Use in Composables with collectAsStateWithLifecycle().
     *
     * @param fieldId Field identifier
     * @return StateFlow of FieldState, or null if field doesn't exist
     */
    fun watchFieldState(fieldId: MetaIdComp): StateFlow<FieldState?>

    /**
     * Watch entire form state changes as StateFlow.
     * Use in Composables with collectAsStateWithLifecycle().
     *
     * @return StateFlow of FormState
     */
    fun watchFormState(): StateFlow<FormState>

    // ==================== Send Button Control ====================

    /**
     * Add a flag that disables the send button.
     * When any flag is present, the send button is disabled.
     *
     * @param flag The flag to add
     */
    fun addSendBtnDisableFlag(flag: SendBtnDisableFlag)

    /**
     * Remove a flag that disables the send button.
     * When all flags are removed, the send button is enabled.
     *
     * @param flag The flag to remove
     */
    fun removeSendBtnDisableFlag(flag: SendBtnDisableFlag)

    /**
     * Check if send button is enabled.
     * Returns true when no disable flags are present.
     *
     * @return true if send button is enabled
     */
    fun isSendBtnEnabled(): Boolean
}
