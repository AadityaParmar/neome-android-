package com.neome.feature.form.presentation.state

import com.neome.api.meta.base.Types.MetaIdComp
import kotlinx.serialization.json.JsonElement

/**
 * Actions that can be executed by the form on a background thread.
 * These are the public API for form manipulation from UI or external code.
 *
 * Actions are converted to FormEvents via [toFormEvent] for processing by the reducer.
 */
sealed interface FormAction {

    // ==================== Field Value Actions ====================

    /**
     * Set a single field value.
     * @param fieldId The field to update
     * @param value The new value (null to clear)
     * @param shouldValidate Whether to trigger validation after setting
     */
    data class SetValue(
        val fieldId: MetaIdComp,
        val value: JsonElement?,
        val shouldValidate: Boolean = true
    ) : FormAction

    /**
     * Set multiple field values at once.
     * @param valueMap Map of fieldId to value
     * @param shouldValidate Whether to trigger validation after setting
     */
    data class SetValues(
        val valueMap: Map<MetaIdComp, JsonElement>,
        val shouldValidate: Boolean = true
    ) : FormAction

    // ==================== Validation Actions ====================

    /**
     * Validate a specific field or all fields.
     * @param fieldId The field to validate, or null to validate all fields
     */
    data class Validate(
        val fieldId: MetaIdComp? = null
    ) : FormAction

    // ==================== Error Management Actions ====================

    /**
     * Set a custom error for a field.
     * @param fieldId The field to set error on
     * @param error The error message
     */
    data class SetError(
        val fieldId: MetaIdComp,
        val error: String
    ) : FormAction

    /**
     * Clear error for a specific field or all fields.
     * @param fieldId The field to clear error from, or null to clear all errors
     */
    data class ClearError(
        val fieldId: MetaIdComp? = null
    ) : FormAction

    // ==================== Form-Level Actions ====================

    /**
     * Submit the form.
     * Validates all fields before emitting FormIntent.Submit.
     */
    data object Submit : FormAction

    /**
     * Reset the form to initial values or provided values.
     * @param valueMap Optional map of values to reset to (uses initial values if null)
     */
    data class Reset(
        val valueMap: Map<MetaIdComp, JsonElement>? = null
    ) : FormAction

    // ==================== Field Trigger Actions ====================

    /**
     * Trigger field to recalculate its fieldProperties.
     * @param fieldId The field to trigger
     */
    data class Trigger(
        val fieldId: MetaIdComp
    ) : FormAction

    // ==================== Field Interaction Actions ====================

    /**
     * Set focus on a field.
     * @param fieldId The field to focus
     */
    data class Focus(
        val fieldId: MetaIdComp
    ) : FormAction

    /**
     * Remove focus from a field (blur).
     * @param fieldId The field to blur
     */
    data class Blur(
        val fieldId: MetaIdComp
    ) : FormAction

    /**
     * Mark a field as touched (user interacted with it).
     * @param fieldId The field to mark as touched
     */
    data class Touch(
        val fieldId: MetaIdComp
    ) : FormAction

    // ==================== Send Button Flag Actions ====================

    /**
     * Add a flag that disables the send button.
     * @param flag The flag to add
     */
    data class AddSendBtnFlag(
        val flag: SendBtnDisableFlag
    ) : FormAction

    /**
     * Remove a flag that disables the send button.
     * @param flag The flag to remove
     */
    data class RemoveSendBtnFlag(
        val flag: SendBtnDisableFlag
    ) : FormAction
}

/**
 * Convert a FormAction to its corresponding FormEvent for processing by the reducer.
 */
fun FormAction.toFormEvent(): FormEvent = when (this) {
    is FormAction.SetValue -> FormEvent.FieldValueChanged(
        fieldId = fieldId,
        value = value,
        shouldValidate = shouldValidate
    )

    is FormAction.SetValues -> FormEvent.SetValues(
        valueMap = valueMap,
        shouldValidate = shouldValidate
    )

    is FormAction.Validate -> if (fieldId != null) {
        FormEvent.ValidateField(fieldId = fieldId)
    } else {
        FormEvent.ValidateAll
    }

    is FormAction.SetError -> FormEvent.SetFieldError(
        fieldId = fieldId,
        error = error
    )

    is FormAction.ClearError -> if (fieldId != null) {
        FormEvent.ClearFieldError(fieldId = fieldId)
    } else {
        FormEvent.ClearAllErrors
    }

    FormAction.Submit -> FormEvent.Submit

    is FormAction.Reset -> FormEvent.Reset(valueMap = valueMap)

    is FormAction.Trigger -> FormEvent.TriggerField(fieldId = fieldId)

    is FormAction.Focus -> FormEvent.FieldFocused(fieldId = fieldId)

    is FormAction.Blur -> FormEvent.FieldBlurred(fieldId = fieldId)

    is FormAction.Touch -> FormEvent.FieldTouched(fieldId = fieldId)

    is FormAction.AddSendBtnFlag -> FormEvent.AddSendBtnDisableFlag(flag = flag)

    is FormAction.RemoveSendBtnFlag -> FormEvent.RemoveSendBtnDisableFlag(flag = flag)
}
