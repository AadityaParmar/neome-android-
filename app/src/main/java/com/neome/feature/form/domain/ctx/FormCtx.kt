package com.neome.feature.form.domain.ctx

import androidx.compose.runtime.State
import androidx.compose.runtime.staticCompositionLocalOf
import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.feature.form.domain.DefnFormUi
import com.neome.feature.form.presentation.state.FieldError
import com.neome.feature.form.presentation.state.FieldState
import com.neome.feature.form.presentation.state.FormState
import com.neome.feature.form.presentation.state.SendBtnDisableFlag
import kotlinx.serialization.json.JsonElement

/**
 * Internal form context for field components.
 * Provides access to form operations without exposing full FormRef.
 *
 * This is passed to all field renderers via CompositionLocal so they can:
 * - Access form state reactively via [formState]
 * - Access other field values (for dependent calculations)
 * - Trigger recalculation of field properties
 * - Query field states
 * - Validate fields
 *
 * All mutations are synchronous via dispatch. For future threading,
 * callers wrap dispatch calls in their own dispatcher.
 */
interface FormCtx {

    // ==================== Reactive State ====================

    /**
     * Compose State holding the current FormState.
     * Reading this in a composable automatically triggers recomposition on change.
     * Use derivedStateOf for per-field granularity.
     */
    val formState: State<FormState>

    // ==================== Field Trigger ====================

    /**
     * Trigger field to recalculate its fieldProperties.
     * Call this when a value that affects another field's properties changes.
     *
     * @param fieldId The field to trigger
     */
    fun trigger(fieldId: MetaIdComp)

    // ==================== Read Operations ====================

    /**
     * Get current form values as a map.
     *
     * @return Map of field IDs to their current values
     */
    fun getValues(): Map<MetaIdComp, JsonElement>

    /**
     * Get specific field state.
     *
     * @param fieldId The field ID to look up
     * @return FieldState or null if field doesn't exist
     */
    fun getFieldState(fieldId: MetaIdComp): FieldState?

    /**
     * Get field value (convenience method).
     *
     * @param fieldId The field ID to look up
     * @return JsonElement value or null if field doesn't exist or has no value
     */
    fun getValue(fieldId: MetaIdComp): JsonElement?

    /**
     * Get field error (convenience method).
     *
     * @param fieldId The field ID to look up
     * @return FieldError or null if field has no error
     */
    fun getError(fieldId: MetaIdComp): FieldError?

    /**
     * Optional API context provider.
     * Implementations may override to expose additional APIs specific to this form.
     * This is intentionally nullable to keep backward compatibility prior to API wiring.
     */
    fun getApiCtx(): FormApiContext? = null

    /**
     * Check if a field exists in the form.
     *
     * @param fieldId The field ID to check
     * @return true if field exists
     */
    fun hasField(fieldId: MetaIdComp): Boolean

    /**
     * Get the DefnForm data.
     * Useful for accessing form-level configuration.
     */
    fun getDefnForm(): DefnFormUi?

    // ==================== Validation ====================

    /**
     * Trigger validation for specific field or entire form.
     *
     * @param fieldId Field to validate, or null for entire form
     */
    fun validate(fieldId: MetaIdComp? = null)

    /**
     * Set error on a specific field.
     *
     * @param fieldId The field to set error on
     * @param error The error message
     */
    fun setError(fieldId: MetaIdComp, error: String)

    /**
     * Clear error on a specific field.
     *
     * @param fieldId The field to clear error from
     */
    fun clearError(fieldId: MetaIdComp)

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
}

/**
 * CompositionLocal to provide FormCtx to nested composables.
 * FormCtx is a stable pointer that never changes after initialization.
 *
 * Usage:
 * ```kotlin
 * val formCtx = LocalFormCtx.current
 * val fieldState = formCtx.getFieldState(fieldId)
 * ```
 */
val LocalFormCtx = staticCompositionLocalOf<FormCtx> {
    error("FormCtx not provided. Ensure Form composable is in the composition tree.")
}
