package com.neome.feature.form.domain.ctx

import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.core.common.serializer.api.meta.base.dto.DefnFormData
import com.neome.feature.form.presentation.state.FieldError
import com.neome.feature.form.presentation.state.FieldState
import com.neome.feature.form.presentation.state.FormState
import kotlinx.coroutines.flow.StateFlow
import kotlinx.serialization.json.JsonElement

/**
 * Internal form context for field components.
 * Provides access to form operations without exposing full FormRef.
 *
 * This is passed to all field renderers so they can:
 * - Access other field values (for dependent calculations)
 * - Trigger recalculation of field properties
 * - Query field states
 * - Validate fields
 * - Watch state changes
 */
interface FormCtx {

    /**
     * Trigger field to recalculate its fieldProperties.
     * Call this when a value that affects another field's properties changes.
     *
     * @param fieldId The field to trigger
     */
    fun trigger(fieldId: MetaIdComp)

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
    fun getDefnForm(): DefnFormData?

    // ==================== Validation ====================

    /**
     * Trigger validation for specific field or entire form.
     *
     * @param fieldId Field to validate, or null for entire form
     * @return true if validation passed
     */
    fun validate(fieldId: MetaIdComp? = null): Boolean

    // ==================== Reactive Streams ====================

    /**
     * Watch field state changes as StateFlow.
     * Use in Composables with collectAsStateWithLifecycle().
     *
     * @param fieldId Field identifier
     * @return StateFlow of FieldState
     */
    fun watchFieldState(fieldId: MetaIdComp): StateFlow<FieldState?>

    /**
     * Watch field error changes as StateFlow (isolated observation).
     * Use in Composables with collectAsStateWithLifecycle() when you only need error state.
     * This prevents unnecessary recomposition when other field properties change.
     *
     * @param fieldId Field identifier
     * @return StateFlow of FieldError (null if no error)
     */
    fun watchFieldError(fieldId: MetaIdComp): StateFlow<FieldError?>

    /**
     * Watch entire form state.
     *
     * @return StateFlow of FormState
     */
    fun watchFormState(): StateFlow<FormState>
}
