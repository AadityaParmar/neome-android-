package com.neome.feature.form.presentation.state

import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.core.mvi.UiEvent
import kotlinx.serialization.json.JsonElement

/**
 * Internal events that modify FormState.
 * These are processed by the Form component's reducer.
 */
sealed interface FormEvent : UiEvent {

    // ==================== Field Value Events ====================

    /**
     * Field value has changed.
     * Triggers validation if shouldValidate is true.
     * Also triggers dependent fields to recalculate their properties.
     */
    data class FieldValueChanged(
        val fieldId: MetaIdComp,
        val value: JsonElement?,
        val shouldValidate: Boolean = true
    ) : FormEvent

    // ==================== Field Interaction Events ====================

    /**
     * Field gained focus.
     */
    data class FieldFocused(
        val fieldId: MetaIdComp
    ) : FormEvent

    /**
     * Field lost focus.
     * Typically triggers validation.
     */
    data class FieldBlurred(
        val fieldId: MetaIdComp
    ) : FormEvent

    /**
     * Field was touched (user interacted with it).
     */
    data class FieldTouched(
        val fieldId: MetaIdComp
    ) : FormEvent

    // ==================== Field Trigger Events ====================

    /**
     * Trigger field to recalculate its fieldProperties.
     * Called when a field this one depends on changes.
     */
    data class TriggerField(
        val fieldId: MetaIdComp
    ) : FormEvent

    // ==================== Validation Events ====================

    /**
     * Validate a specific field.
     */
    data class ValidateField(
        val fieldId: MetaIdComp
    ) : FormEvent

    /**
     * Validate all fields in the form.
     */
    data object ValidateAll : FormEvent

    // ==================== Error Management Events ====================

    /**
     * Set a custom error for a field.
     */
    data class SetFieldError(
        val fieldId: MetaIdComp,
        val error: String
    ) : FormEvent

    /**
     * Clear error for a specific field.
     */
    data class ClearFieldError(
        val fieldId: MetaIdComp
    ) : FormEvent

    /**
     * Clear all field errors.
     */
    data object ClearAllErrors : FormEvent

    // ==================== Form-Level Events ====================

    /**
     * Submit the form.
     * Validates all fields before emitting FormIntent.Submit.
     */
    data object Submit : FormEvent

    /**
     * Reset the form to initial values or provided values.
     */
    data class Reset(
        val valueMap: Map<MetaIdComp, JsonElement>? = null
    ) : FormEvent

    // ==================== Bulk Operations ====================

    /**
     * Set multiple field values at once.
     */
    data class SetValues(
        val valueMap: Map<MetaIdComp, JsonElement>,
        val shouldValidate: Boolean = true
    ) : FormEvent

    // ==================== Initialization ====================

    /**
     * Initialize the form.
     * Builds dependency map, sets initial values, and calculates initial fieldProperties.
     */
    data object Initialize : FormEvent

    // ==================== Send Button Flag Events ====================

    /**
     * Add a flag that disables the send button.
     * When any flag is present, the send button is disabled.
     */
    data class AddSendBtnDisableFlag(val flag: SendBtnDisableFlag) : FormEvent

    /**
     * Remove a flag that disables the send button.
     * When all flags are removed, the send button is enabled.
     */
    data class RemoveSendBtnDisableFlag(val flag: SendBtnDisableFlag) : FormEvent
}
