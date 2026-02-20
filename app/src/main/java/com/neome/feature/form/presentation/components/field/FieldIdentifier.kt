package com.neome.feature.form.presentation.components.field

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueTextData
import com.neome.feature.form.presentation.components.base.FieldBase
import com.neome.feature.form.presentation.components.base.rememberFieldController
import com.neome.feature.form.presentation.state.FieldEvent

/**
 * Identifier field component for form.
 *
 * Renders a non-editable text field that displays a system-generated identifier value.
 * The value is typically auto-generated via textPatternVar / setOnSend and is never
 * directly editable by the user.
 *
 * Uses [FieldValueTextData] as the value type.
 *
 * @param defnComp  Field definition (expected to be [DefnFieldIdentifierData])
 * @param onFieldEvent Callback to emit field events to the form
 * @param modifier  Modifier for customization
 */
@Composable
fun FieldIdentifier(
    defnComp: DefnCompSeal,
    onFieldEvent: (FieldEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    val fieldController = rememberFieldController<FieldValueTextData>(
        defnComp = defnComp,
        onFieldEvent = onFieldEvent
    )

    if (fieldController.fieldId == null) return

    val fieldValue = fieldController.value.value
    val (properties, error) = fieldController.field.value

    if (properties.hidden) return

    val currentValue = fieldValue?.value ?: ""

    FieldBase(modifier = modifier, properties = properties) {
        OutlinedTextField(
            value = currentValue,
            onValueChange = {},
            label = properties.label?.let { { Text(it) } },
            placeholder = properties.placeholder?.let { { Text(it) } },
            isError = error != null,
            supportingText = error?.message?.let { { Text(it) } }
                ?: properties.helperText?.let { { Text(it) } },
            enabled = !properties.disabled,
            readOnly = true,
            maxLines = 1,
            modifier = Modifier.fillMaxWidth()
        )
    }
}
