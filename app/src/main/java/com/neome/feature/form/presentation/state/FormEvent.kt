package com.neome.feature.form.presentation.state

import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.api.meta.base.Types.RowId
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
     * Always triggers validation and dependent fields to recalculate their properties.
     *
     * @param depth Cascade depth for onChange event recursion guard.
     *              0 = user-initiated change, >0 = triggered by form event setValue/clear.
     *              Used to prevent infinite recursion (A→B→C→A).
     */
    data class FieldValueChanged(
        val fieldId: MetaIdComp,
        val value: JsonElement?,
        val depth: Int = 0
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
     * Always triggers validation and dependent fields to recalculate their properties.
     */
    data class SetValues(
        val valueMap: Map<MetaIdComp, JsonElement>
    ) : FormEvent

    // ==================== Send Button Flag Events ====================

    /**
     * Add a send button state flag. When any non-Invisible flag is present, the send button is disabled.
     */
    data class AddSendBtnStateFlag(val flag: SendBtnStateFlag) : FormEvent

    /**
     * Remove a send button state flag. When all non-Invisible flags are removed, the send button is enabled.
     */
    data class RemoveSendBtnStateFlag(val flag: SendBtnStateFlag) : FormEvent

    // ==================== Click Events ====================

    /**
     * Field/component was clicked.
     * Triggers onClickButton form events defined for this component.
     */
    data class Click(
        val buttonCompId: MetaIdComp
    ) : FormEvent

    // ==================== Grid Events ====================

    /**
     * Open grid row editor for adding a new row or editing an existing row.
     * Initializes FormState.gridCtx with row state.
     * - rowId = null → add new row
     * - rowId = non-null → edit existing row
     */
    data class GridOpen(
        val gridId: MetaIdComp,
        val rowId: RowId? = null
    ) : FormEvent

    /**
     * Remove a grid row. Emits FormIntent.GridRemove to parent.
     */
    data class GridRemove(
        val gridId: MetaIdComp,
        val rowId: RowId
    ) : FormEvent

    /**
     * Close grid row editor without saving. Clears FormState.gridCtx.
     */
    data class GridClose(
        val gridId: MetaIdComp
    ) : FormEvent

    /**
     * Submit grid row: validate all fields, merge into parent grid value,
     * clear FormState.gridCtx.
     */
    data class GridSubmit(
        val gridId: MetaIdComp
    ) : FormEvent
}
