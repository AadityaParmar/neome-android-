package com.neome.feature.form.presentation.component.field

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.neome.api.meta.base.dto.DefnField
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.feature.form.presentation.ctx.FormCtx
import com.neome.feature.form.presentation.state.FieldEvent
import kotlinx.serialization.json.JsonPrimitive

/**
 * Simple text field component for form.
 *
 * Basic text box that uses value from fieldState (accessed via formCtx) and updates value on change.
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
    val fieldId = (defnComp as? DefnField)?.metaId ?: return
    val fieldState = formCtx.getFieldState(fieldId) ?: return

    // Get current text value from JsonElement
    val currentValue = fieldState.value?.let {
        when (it) {
            is JsonPrimitive -> it.content
            else -> it.toString()
        }
    } ?: ""

    // Local state for text input
    var textValue by remember(currentValue) { mutableStateOf(currentValue) }

    OutlinedTextField(
        value = textValue,
        onValueChange = { newValue ->
            textValue = newValue
            // Emit value change event
            val jsonValue = if (newValue.isEmpty()) null else JsonPrimitive(newValue)
            onFieldEvent(FieldEvent.ValueChanged(fieldId, jsonValue))
        },
        modifier = modifier.fillMaxWidth()
    )
}
