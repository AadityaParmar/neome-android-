package com.neome.feature.form.presentation.renderer.field

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.neome.api.meta.base.dto.DefnComp
import com.neome.api.meta.base.dto.DefnForm
import com.neome.feature.form.presentation.ref.FormRef
import com.neome.feature.form.presentation.renderer.ComponentRenderer

/**
 * Renderer for NUMBER field type
 */
object FieldNumber : ComponentRenderer {
    @Composable
    override fun Render(
        defnComp: DefnComp,
        defnForm: DefnForm,
        formRef: FormRef,
        modifier: Modifier
    ) {
        val fieldId = defnComp.name.name
        val value by formRef.watch<Double>(fieldId).collectAsStateWithLifecycle(initialValue = 0.0)
        val isError = !formRef.isValid(fieldId)
        val errorMessage = if (isError) "Invalid number" else null

        OutlinedTextField(
            value = value?.toString() ?: "",
            onValueChange = { newValue ->
                val number = newValue.toDoubleOrNull()
                if (number != null || newValue.isEmpty()) {
                    formRef.setValue(fieldId, number ?: 0.0)
                }
            },
            label = { Text(defnComp.label ?: defnComp.name.name) },
            enabled = defnComp.disabled != true && defnComp.readOnly != true,
            isError = isError,
            supportingText = if (errorMessage != null) {
                { Text(errorMessage) }
            } else null,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
    }
}
