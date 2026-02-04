package com.neome.feature.form.presentation.components.field

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueTextData
import com.neome.feature.form.presentation.components.base.FieldBase
import com.neome.feature.form.presentation.components.base.rememberFieldController
import com.neome.feature.form.presentation.state.FieldError
import com.neome.feature.form.presentation.state.FieldEvent

/**
 * Simple text field component for form.
 *
 * Stateful wrapper that uses rememberFieldController for state management.
 * Delegates rendering to stateless FieldTextContent for optimal recomposition.
 *
 * FormCtx is accessed via LocalFormCtx.current inside rememberFieldController,
 * so this composable must be called inside a Form composable tree.
 *
 * @param defnComp Field definition containing field configuration
 * @param onFieldEvent Callback to emit field events to the form
 * @param modifier Modifier for customization
 */
@Composable
fun FieldText(
    defnComp: DefnCompSeal,
    onFieldEvent: (FieldEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    // Use field controller composable with FieldValueTextData type
    val fieldController = rememberFieldController<FieldValueTextData>(
        defnComp = defnComp,
        onFieldEvent = onFieldEvent
    )

    // Early return if field setup is invalid
    if (fieldController.fieldId == null) return

    // Watch field properties reactively through controller
    val properties by fieldController.fieldPropertiesFlow.collectAsStateWithLifecycle()

    // Early return if field is hidden
    if (properties.hidden) return

    // Watch error reactively through controller
    val error by fieldController.errorFlow.collectAsStateWithLifecycle()

    // Get current text value from FieldValueTextData
    val currentValue = fieldController.fieldValue?.value ?: ""

    // Local state for text input - keyed to currentValue for external updates
    var textValue by remember(currentValue) { mutableStateOf(currentValue) }

    // Delegate to stateless content for optimal recomposition
    FieldBase(modifier = modifier) {
        FieldTextContent(
            value = textValue,
            label = properties.label,
            placeholder = properties.placeholder,
            helperText = properties.helperText,
            error = error,
            enabled = !properties.disabled,
            readOnly = properties.readOnly,
            onValueChange = { newValue ->
                textValue = newValue
                // Use controller's onChange callback with FieldValueTextData
                val fieldValue = if (newValue.isEmpty()) null else FieldValueTextData(newValue)
                fieldController.onChange(fieldValue)
            }
        )
    }
}

/**
 * Stateless text field content for optimal recomposition control.
 *
 * Only recomposes when its parameters change. Uses fixed placeholder space
 * for supporting text to prevent layout jumps when error/helper text changes.
 *
 * @param value Current text value
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
private fun FieldTextContent(
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
        supportingText = {
            // Always render with placeholder space to prevent layout jumps
            // Space character reserves height when no error or helper text
            Text(text = error?.message ?: helperText ?: " ")
        },
        enabled = enabled,
        readOnly = readOnly,
        maxLines = 1,
        modifier = modifier.fillMaxWidth(),
        onValueChange = onValueChange
    )
}
