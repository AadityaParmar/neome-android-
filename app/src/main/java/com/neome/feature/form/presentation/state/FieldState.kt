package com.neome.feature.form.presentation.state

import androidx.compose.runtime.Immutable
import com.neome.core.common.serializer.api.meta.base.dto.DefnDtoColorData
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

/**
 * Runtime state for a single form field.
 * Contains interaction state and computed properties.
 *
 * Note: Field values are stored centrally in FormState.valueMap, not here.
 * Note: Field errors are stored centrally in FormState.errors, not here.
 */
@Immutable
@Serializable
data class FieldState(
    // Default value (set once on init from initialValue, does not change)
    val defaultValue: JsonElement? = null,

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
     * @param value The current field value from FormState.valueMap
     */
    fun computeIsDirty(value: JsonElement?): Boolean = value != defaultValue
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
    val label: String? = null,

    // Text/Paragraph/Password validation constraints
    val minCharCount: Long? = null,
    val maxCharCount: Long? = null,
    val lineCount: Long? = null,         // Paragraph

    // Number/Counter validation constraints
    val minNumber: Long? = null,
    val maxNumber: Long? = null,
    val step: Long? = null,              // Counter
    val minDisplayValue: Long? = null,   // Counter

    // Decimal validation constraints
    val minDecimal: Double? = null,
    val maxDecimal: Double? = null,

    // Display/UI properties
    val showAsCheckbox: Boolean? = null,   // Switch
    val showLabel: Boolean? = null,        // Image, Camera, ShowCode
    val showPreview: Boolean? = null,      // Image, Camera, Video
    val showSize: Boolean? = null,         // Document, Image, Camera, Video
    val showSecond: Boolean? = null,       // Time
    val showAsDropdown: Boolean? = null,   // PickUser, SetOfUser

    // Media properties
    val maxSize: Long? = null,             // Audio, Document, Image, Camera, Video, Voice

    // Button properties
    val textSize: String? = null,          // Button (EnumDefnTextSize.value)
    val disableElevation: Boolean? = null, // Button
    val buttonVariant: String? = null,     // Button variant: "text", "contained", "outlined", "icon"
    val bgColor: DefnDtoColorData? = null, // Button background color
    val buttonPosition: String? = null,    // Button alignment (EnumDefnPlacement.value): "start", "center", "end"
    val iconPosition: String? = null,      // Icon position (EnumDefnPlacement.value): "start", "end"
    val toolTip: String? = null,           // Button tooltip / content description
    val icon: String? = null,              // Icon name (MUI icon name string)

    // Layout properties
    val justifyContent: String? = null,    // Counter (EnumDefnPlacement.value)
    val flexHeight: Boolean? = null        // Paragraph
)
