package com.neome.feature.form.presentation.renderer.field

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.neome.api.meta.base.dto.DefnComp
import com.neome.api.meta.base.dto.DefnForm
import com.neome.feature.form.presentation.ref.FormRef
import com.neome.feature.form.presentation.renderer.ComponentRenderer

/**
 * Renderer for PICK_TEXT field type (dropdown)
 */
object FieldPickText : ComponentRenderer {
    @OptIn(ExperimentalMaterial3Api::class)
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
        val errorMessage = if (isError) "Please select an option" else null

        var expanded by remember { mutableStateOf(false) }

        // TODO: Get options from DefnComp (need to check DefnFieldPickText structure)
        val options = listOf("Option 1", "Option 2", "Option 3")  // Placeholder

        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                if (defnComp.disabled != true && defnComp.readOnly != true) {
                    expanded = !expanded
                }
            },
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            OutlinedTextField(
                value = value ?: "",
                onValueChange = {},
                readOnly = true,
                label = { Text(defnComp.label ?: defnComp.name.name) },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                enabled = defnComp.disabled != true && defnComp.readOnly != true,
                isError = isError,
                supportingText = if (errorMessage != null) {
                    { Text(errorMessage) }
                } else null,
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth()
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                options.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option) },
                        onClick = {
                            formRef.setValue(fieldId, option)
                            expanded = false
                        }
                    )
                }
            }
        }
    }
}
