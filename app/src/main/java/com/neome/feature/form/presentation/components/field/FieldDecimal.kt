package com.neome.feature.form.presentation.components.field

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueDecimalData
import com.neome.feature.form.domain.ctx.FormCtx
import com.neome.feature.form.presentation.components.base.FieldBase
import com.neome.feature.form.presentation.components.base.rememberFieldController
import com.neome.feature.form.presentation.state.FieldEvent

/**
 * Simple decimal field component for form.
 *
 * Basic decimal number input that uses standardized field interface with fieldValue, error, fieldProperties, and onChange.
 *
 * @param defnComp Field definition containing field configuration
 * @param onFieldEvent Callback to emit field events to the form
 * @param formCtx Form context for accessing field state and other field values
 * @param modifier Modifier for customization
 */
@Composable
fun FieldDecimal(
    defnComp: DefnCompSeal,
    onFieldEvent: (FieldEvent) -> Unit,
    formCtx: FormCtx,
    modifier: Modifier = Modifier
) {
    // Use field controller composable with FieldValueDecimalData type
    val fieldController = rememberFieldController<FieldValueDecimalData>(
        defnComp = defnComp,
        onFieldEvent = onFieldEvent,
        formCtx = formCtx
    )

    // Early return if field setup is invalid
    if (fieldController.fieldId == null || fieldController.fieldState == null) return

    // Early return if field is hidden
    if (fieldController.fieldProperties.hidden) return

    val properties = fieldController.fieldProperties

    // Get current decimal value from FieldValueDecimalData
    val currentValue = fieldController.fieldValue?.value?.toString() ?: ""

    // Local state for decimal input
    var textValue by remember(currentValue) { mutableStateOf(currentValue) }

    // Handle decimal value changes
    fun onValueChange(newValue: String) {
        // Allow empty string or valid decimal input
        if (newValue.isEmpty() || newValue == "-" || newValue == "." || newValue == "-.") {
            textValue = newValue
            fieldController.onChange(null)
            return
        }

        // Try to parse as Long (for decimal values stored as Long)
        val longValue = newValue.toLongOrNull()
        if (longValue != null) {
            textValue = newValue
            // Use controller's onChange callback with FieldValueDecimalData
            fieldController.onChange(FieldValueDecimalData(longValue))
        }
        // If parsing fails, don't update state (keep previous valid value)
    }

    FieldBase(modifier = modifier) {
        OutlinedTextField(
            value = textValue,
            label = properties.label?.let { { Text(it) } },
            placeholder = properties.placeholder?.let { { Text(it) } },
            supportingText = properties.helperText?.let { { Text(it) } },
            enabled = !properties.disabled,
            readOnly = properties.readOnly,
            maxLines = 1,
            modifier = modifier.fillMaxWidth(),
            onValueChange = ::onValueChange,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
        )
    }
}
