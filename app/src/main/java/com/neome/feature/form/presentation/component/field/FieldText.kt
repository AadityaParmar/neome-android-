package com.neome.feature.form.presentation.component.field

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueTextData
import com.neome.feature.form.presentation.ctx.FormCtx
import com.neome.feature.form.presentation.state.FieldEvent

/**
 * Simple text field component for form.
 *
 * Basic text box that uses standardized field interface with fieldValue, error, fieldProperties, and onChange.
 *
 * @param defnComp Field definition containing field configuration
 * @param onFieldEvent Callback to emit field events to the form
 * @param formCtx Form context for accessing field state and other field values
 * @param modifier Modifier for customization
 */
@Composable
fun FieldText(
    defnComp: DefnCompSeal,
    onFieldEvent: (FieldEvent) -> Unit,
    formCtx: FormCtx,
    modifier: Modifier = Modifier
) {
    // Use field controller composable with FieldValueTextData type
    val fieldController = rememberFieldController<FieldValueTextData>(
        defnComp = defnComp,
        onFieldEvent = onFieldEvent,
        formCtx = formCtx
    )

    // Early return if field setup is invalid
    if (fieldController.fieldId == null || fieldController.fieldState == null) return

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

    FieldBase(modifier = modifier.background(color = Color(76, 175, 80, 255))) {
        OutlinedTextField(
            value = textValue,
            maxLines = 1,
            modifier = modifier.fillMaxWidth(),
            onValueChange = ::onValueChange
        )
    }
}
