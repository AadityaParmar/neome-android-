package com.neome.feature.form.presentation.components.field

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType

import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueNumberData
import com.neome.feature.form.presentation.components.base.FieldBase
import com.neome.feature.form.presentation.components.base.rememberFieldController
import com.neome.feature.form.presentation.state.FieldError
import com.neome.feature.form.presentation.state.FieldEvent

/**
 * Number field component for form.
 *
 * Stateful wrapper that uses rememberFieldController for state management.
 * Delegates rendering to stateless FieldNumberContent for optimal recomposition.
 *
 * FormCtx is accessed via LocalFormCtx.current inside rememberFieldController,
 * so this composable must be called inside a Form composable tree.
 *
 * @param defnComp Field definition containing field configuration
 * @param onFieldEvent Callback to emit field events to the form
 * @param modifier Modifier for customization
 */
@Composable
fun FieldNumber(
    defnComp: DefnCompSeal,
    onFieldEvent: (FieldEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    // Stable field controller remembered across recompositions
    val fieldController = rememberFieldController<FieldValueNumberData>(
        defnComp = defnComp,
        onFieldEvent = onFieldEvent
    )

    // Early return if field setup is invalid
    if (fieldController.fieldId == null) return

    // Collect reactive field value separately for finer-grained recomposition
    val fieldValue = fieldController.value.value

    // Collect reactive field properties and error
    val (properties, error) = fieldController.field.value

    // Early return if field is hidden
    if (properties.hidden) return

    // Get current number value from FieldValueNumberData
    val currentValue = fieldValue?.value?.toString() ?: ""

    // Delegate to stateless content for optimal recomposition
    FieldBase(modifier = modifier) {
        FieldNumberContent(
            value = currentValue,
            label = properties.label,
            placeholder = properties.placeholder,
            helperText = properties.helperText,
            error = error,
            enabled = !properties.disabled,
            readOnly = properties.readOnly,
            onValueChange = { newValue ->
                // Allow empty string or valid number input
                if (newValue.isEmpty() || newValue == "-") {
                    fieldController.onChange(null)
                    return@FieldNumberContent
                }

                // Try to parse as Long
                val longValue = newValue.toLongOrNull()
                if (longValue != null) {
                    fieldController.onChange(FieldValueNumberData(longValue))
                }
                // If parsing fails, don't update state (keep previous valid value)
            }
        )
    }
}

/**
 * Stateless number field content for optimal recomposition control.
 *
 * Only recomposes when its parameters change. Uses fixed placeholder space
 * for supporting text to prevent layout jumps when error/helper text changes.
 *
 * @param value Current text value (string representation of number)
 * @param label Field label
 * @param placeholder Field placeholder
 * @param helperText Helper text to display below field
 * @param error Field error, if any
 * @param enabled Whether field is enabled
 * @param readOnly Whether field is read-only
 * @param onValueChange Callback when value changes
 * @param modifier Modifier for customization
 */
@Composable
private fun FieldNumberContent(
    value: String,
    label: String?,
    placeholder: String?,
    helperText: String?,
    error: FieldError?,
    enabled: Boolean,
    readOnly: Boolean,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = value,
        label = label?.let { { Text(it) } },
        placeholder = placeholder?.let { { Text(it) } },
        isError = error != null,
        supportingText = error?.message?.let { { Text(it) } } ?: helperText?.let { { Text(it) } },
        enabled = enabled,
        readOnly = readOnly,
        maxLines = 1,
        modifier = modifier.fillMaxWidth(),
        onValueChange = onValueChange,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}
