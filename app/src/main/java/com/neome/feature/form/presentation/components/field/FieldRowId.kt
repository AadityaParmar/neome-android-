package com.neome.feature.form.presentation.components.field

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.feature.form.presentation.components.base.FieldBase
import com.neome.feature.form.presentation.components.base.rememberFieldController
import com.neome.feature.form.presentation.state.FieldError
import com.neome.feature.form.presentation.state.FieldEvent

/**
 * RowId field component for form.
 *
 * Renders a simple text input for entering/displaying a RowId value.
 * The field value is a RowId (string).
 *
 * Stateful wrapper that uses rememberFieldController for state management.
 * Delegates rendering to stateless FieldRowIdContent for optimal recomposition.
 *
 * FormCtx is accessed via LocalFormCtx.current inside rememberFieldController,
 * so this composable must be called inside a Form composable tree.
 *
 * @param defnComp Field definition containing field configuration
 * @param onFieldEvent Callback to emit field events to the form
 * @param modifier Modifier for customization
 */
@Composable
fun FieldRowId(
    defnComp: DefnCompSeal,
    onFieldEvent: (FieldEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    // Stable field controller remembered across recompositions
    // Using String as field value type (RowId is a string)
    val fieldController = rememberFieldController<String>(
        defnComp = defnComp,
        onFieldEvent = onFieldEvent
    )

    // Early return if field setup is invalid
    if (fieldController.fieldId == null) return

    // Read reactive field value (derivedStateOf provides fine-grained recomposition)
    val fieldValue = fieldController.value.value

    // Read reactive field properties and error
    val (properties, error) = fieldController.field.value

    // Get current text value (field value is directly the RowId string)
    val currentValue = fieldValue ?: ""

    // Early return if field is hidden
    if (properties.hidden) return

    // Delegate to stateless content for optimal recomposition
    FieldBase(modifier = modifier, properties = properties) {
        FieldRowIdContent(
            value = currentValue,
            label = properties.label,
            placeholder = properties.placeholder,
            helperText = properties.helperText,
            error = error,
            enabled = !properties.disabled,
            readOnly = properties.readOnly,
            onValueChange = { newValue ->
                // Pass raw string or null when empty
                fieldController.onChange(newValue.ifEmpty { null })
            }
        )
    }
}

/**
 * Stateless RowId field content for optimal recomposition control.
 *
 * Only recomposes when its parameters change. Renders a simple text input
 * with support for helper text and error display.
 *
 * @param value Current text value (RowId string)
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
private fun FieldRowIdContent(
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
        onValueChange = onValueChange
    )
}
