package com.neome.feature.form.presentation.state

import androidx.compose.runtime.Immutable
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

/**
 * Runtime state for a single form field.
 * Contains current value, interaction state, and computed properties.
 *
 * Note: Field errors are stored centrally in FormState.errors, not here.
 */
@Immutable
@Serializable
data class FieldState(
    // Values
    val value: JsonElement? = null,
    val defaultValue: JsonElement? = null,  // Set on init from initialValue

    // Interaction state
    val isTouched: Boolean = false,
    val isDirty: Boolean = false,
    val isFocused: Boolean = false,
    val isValidating: Boolean = false,

    // Computed properties (recalculated on trigger)
    val fieldProperties: FieldProperties = FieldProperties()
) {
    /**
     * Check if field value differs from default.
     */
    fun computeIsDirty(): Boolean = value != defaultValue
}

/**
 * Computed field properties.
 * Recalculated when field is triggered (on init or when dependent field changes).
 *
 * Properties can be resolved from DefnComp in 3 ways:
 * 1. Direct value: defnComp.placeHolder (String)
 * 2. Variable: defnComp.placeHolderVar (DefnDtoText) -> resolveArgValue()
 * 3. Field reference: defnComp.placeHolderFieldId -> get value from another field
 */
@Immutable
@Serializable
data class FieldProperties(
    val required: Boolean = false,
    val disabled: Boolean = false,
    val readOnly: Boolean = false,
    val hidden: Boolean = false,
    val helperText: String? = null,
    val placeholder: String? = null,
    val label: String? = null
    // More properties to be added as needed
)
