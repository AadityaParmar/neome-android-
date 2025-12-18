package com.neome.feature.form.presentation.renderer.field

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.neome.api.meta.base.dto.DefnComp
import com.neome.api.meta.base.dto.DefnForm
import com.neome.feature.form.presentation.ref.FormRef
import com.neome.feature.form.presentation.renderer.ComponentRenderer

/**
 * Renderer for TEXT field type
 */
object FieldText : ComponentRenderer {
    @Composable
    override fun Render(
        defnComp: DefnComp,
        defnForm: DefnForm,
        formRef: FormRef,
        modifier: Modifier
    ) {
        val fieldId = defnComp.name.name
        val value by formRef.watch<String>(fieldId).collectAsStateWithLifecycle(initialValue = "")
        val isError = !formRef.isValid(fieldId)
        val errorMessage = if (isError) "Invalid input" else null  // TODO: Get from state

        OutlinedTextField(
            value = value ?: "",
            onValueChange = { newValue ->
                formRef.setValue(fieldId, newValue)
            },
            label = { Text(defnComp.label ?: defnComp.name.name) },
            enabled = defnComp.disabled != true && defnComp.readOnly != true,
            isError = isError,
            supportingText = if (errorMessage != null) {
                { Text(errorMessage) }
            } else null,
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
    }
}
