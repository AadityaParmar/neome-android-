package com.neome.feature.form.presentation.components.field

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType

import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueEmailData
import com.neome.feature.form.presentation.components.base.FieldBase
import com.neome.feature.form.presentation.components.base.rememberFieldController
import com.neome.feature.form.presentation.state.FieldEvent

/**
 * Email field component for form.
 *
 * Email input field that uses standardized field interface with fieldValue, error, fieldProperties, and onChange.
 * Configured with email keyboard type and basic email validation.
 *
 * FormCtx is accessed via LocalFormCtx.current inside rememberFieldController,
 * so this composable must be called inside a Form composable tree.
 *
 * @param defnComp Field definition containing field configuration
 * @param onFieldEvent Callback to emit field events to the form
 * @param modifier Modifier for customization
 */
@Composable
fun FieldEmail(
    defnComp: DefnCompSeal,
    onFieldEvent: (FieldEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    // Stable field controller remembered across recompositions
    val fieldController = rememberFieldController<FieldValueEmailData>(
        defnComp = defnComp,
        onFieldEvent = onFieldEvent
    )

    // Early return if field setup is invalid
    if (fieldController.fieldId == null) return

    // Collect reactive field value separately for finer-grained recomposition
    val fieldValue = fieldController.value.value

    // Collect reactive field properties and error
    val (properties, _) = fieldController.field.value

    // Early return if field is hidden
    if (properties.hidden) return

    // Get current email value from FieldValueEmailData
    val currentValue = fieldValue?.value ?: ""

    // Handle email value changes
    fun onValueChange(newValue: String) {
        val fv = if (newValue.isEmpty()) null else FieldValueEmailData(newValue)
        fieldController.onChange(fv)
    }

    FieldBase(modifier = modifier) {
        OutlinedTextField(
            value = currentValue,
            label = properties.label?.let { { Text(it) } },
            isError = currentValue.isNotEmpty() && !currentValue.contains("@"),
            placeholder = properties.placeholder?.let { { Text(it) } },
            supportingText = properties.helperText?.let { { Text(it) } },
            enabled = !properties.disabled,
            readOnly = properties.readOnly,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = modifier.fillMaxWidth(),
            onValueChange = ::onValueChange
        )
    }
}
