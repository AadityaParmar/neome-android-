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
import com.neome.feature.form.presentation.state.FieldEvent

/**
 * Simple text field component for form.
 *
 * Basic text box that uses standardized field interface with fieldValue, error, fieldProperties, and onChange.
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


    // Get current text value from FieldValueTextData
    val currentValue = fieldController.fieldValue?.value ?: ""

    // Local state for text input
    var textValue by remember(currentValue) { mutableStateOf(currentValue) }

    // Handle text value changes
    fun onValueChange(newValue: String) {
        textValue = newValue
        // Use controller's onChange callback with FieldValueTextData
        val fieldValue = if (newValue.isEmpty()) null else FieldValueTextData(newValue)

        fieldController.onChange(fieldValue)
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
            onValueChange = ::onValueChange
        )
    }
}
