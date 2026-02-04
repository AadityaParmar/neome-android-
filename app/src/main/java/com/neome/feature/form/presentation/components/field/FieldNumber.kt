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
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueNumberData
import com.neome.feature.form.presentation.components.base.FieldBase
import com.neome.feature.form.presentation.components.base.rememberFieldController
import com.neome.feature.form.presentation.state.FieldEvent

/**
 * Simple number field component for form.
 *
 * Basic number input that uses standardized field interface with fieldValue, error, fieldProperties, and onChange.
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
    // Use field controller composable with FieldValueNumberData type
    val fieldController = rememberFieldController<FieldValueNumberData>(
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

    // Get current number value from FieldValueNumberData
    val currentValue = fieldController.fieldValue?.value?.toString() ?: ""

    // Local state for number input
    var textValue by remember(currentValue) { mutableStateOf(currentValue) }


    // Handle number value changes
    fun onValueChange(newValue: String) {
        // Allow empty string or valid number input
        if (newValue.isEmpty() || newValue == "-") {
            textValue = newValue
            fieldController.onChange(null)
            return
        }

        // Try to parse as Long
        val longValue = newValue.toLongOrNull()
        if (longValue != null) {
            textValue = newValue
            // Use controller's onChange callback with FieldValueNumberData
            fieldController.onChange(FieldValueNumberData(longValue))
        }
        // If parsing fails, don't update state (keep previous valid value)
    }

    FieldBase(modifier = modifier) {
        OutlinedTextField(
            value = textValue,
            label = properties.label?.let { { Text(it) } },
            placeholder = properties.placeholder?.let { { Text(it) } },
            isError = error != null,
            supportingText = error?.let { { Text(it.message) } } ?: properties.helperText?.let { { Text(it) } },
            enabled = !properties.disabled,
            readOnly = properties.readOnly,
            maxLines = 1,
            modifier = modifier.fillMaxWidth(),
            onValueChange = ::onValueChange,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
    }
}
