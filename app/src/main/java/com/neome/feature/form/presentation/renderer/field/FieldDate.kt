package com.neome.feature.form.presentation.renderer.field

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * Renderer for DATE field type
 */
object FieldDate : ComponentRenderer {

    private val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

    @Composable
    override fun Render(
        defnComp: DefnComp,
        defnForm: DefnForm,
        formRef: FormRef,
        modifier: Modifier
    ) {
        val fieldId = defnComp.name.name
        val value by formRef.watch<Date>(fieldId).collectAsStateWithLifecycle(initialValue = null)
        val isError = !formRef.isValid(fieldId)
        val errorMessage = if (isError) "Invalid date" else null

        val displayValue = value?.let { dateFormat.format(it) } ?: ""

        OutlinedTextField(
            value = displayValue,
            onValueChange = { newValue ->
                // Simple text input for now, proper date picker can be added later
                try {
                    val date = dateFormat.parse(newValue)
                    if (date != null) {
                        formRef.setValue(fieldId, date)
                    }
                } catch (e: Exception) {
                    // Invalid date format, ignore
                }
            },
            label = { Text(defnComp.label ?: defnComp.name.name) },
            enabled = defnComp.disabled != true && defnComp.readOnly != true,
            isError = isError,
            supportingText = if (errorMessage != null) {
                { Text(errorMessage) }
            } else {
                { Text("Format: yyyy-MM-dd") }
            },
            trailingIcon = {
                IconButton(onClick = { /* TODO: Show date picker */ }) {
                    Icon(Icons.Default.DateRange, contentDescription = "Select date")
                }
            },
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
    }
}
