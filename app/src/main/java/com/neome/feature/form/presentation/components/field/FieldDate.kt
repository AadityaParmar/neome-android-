package com.neome.feature.form.presentation.components.field

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueDateData
import com.neome.feature.form.presentation.components.base.FieldBase
import com.neome.feature.form.presentation.components.base.rememberFieldController
import com.neome.feature.form.presentation.state.FieldEvent
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FieldDate(
    defnComp: DefnCompSeal,
    onFieldEvent: (FieldEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    val fieldController = rememberFieldController<FieldValueDateData>(
        defnComp = defnComp,
        onFieldEvent = onFieldEvent
    )

    if (fieldController.fieldId == null) return

    // Collect reactive field value separately for finer-grained recomposition
    val fieldValue by fieldController.value.collectAsStateWithLifecycle()

    // Collect reactive field properties and error
    val (properties, _) = fieldController.field.collectAsStateWithLifecycle().value

    if (properties.hidden) return

    // Get current date value from FieldValueDateData
    val currentValue = fieldValue?.value

    var showDatePicker by remember { mutableStateOf(false) }

    val isoFormat = remember { SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()) }
    val displayFormat = remember { SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()) }

    fun stringToDate(dateString: String?): Date? {
        if (dateString.isNullOrBlank()) return null
        return try {
            isoFormat.parse(dateString)
        } catch (e: Exception) {
            null
        }
    }

    fun dateToIsoString(date: Date?): String {
        if (date == null) return ""
        return isoFormat.format(date)
    }

    fun formatDateForDisplay(dateString: String?): String {
        if (dateString.isNullOrBlank()) return ""
        val date = stringToDate(dateString) ?: return ""
        return displayFormat.format(date)
    }

    fun onDateSelected(timestamp: Long?) {
        val dateString = timestamp?.let { dateToIsoString(Date(it)) }
        val newValue = dateString?.let { FieldValueDateData(it) }
        fieldController.onChange(newValue)
        showDatePicker = false
    }

    fun onClearDate() {
        fieldController.onChange(null)
    }

    val isInteractive = !properties.disabled && !properties.readOnly

    val interactionSource = remember { MutableInteractionSource() }

    LaunchedEffect(interactionSource, isInteractive) {
        if (isInteractive) {
            interactionSource.interactions.collect { interaction ->
                if (interaction is PressInteraction.Release) {
                    showDatePicker = true
                }
            }
        }
    }

    FieldBase(modifier = modifier) {
        OutlinedTextField(
            value = formatDateForDisplay(currentValue),
            onValueChange = { /* Read-only, no manual text input */ },
            label = properties.label?.let { { Text(it) } },
            placeholder = properties.placeholder?.let { { Text(it) } },
            supportingText = properties.helperText?.let { { Text(it) } },
            enabled = !properties.disabled,
            readOnly = true,
            modifier = Modifier.fillMaxWidth(),
            interactionSource = interactionSource,
            trailingIcon = {
                Row {
                    if (isInteractive) {
                        IconButton(onClick = { showDatePicker = true }) {
                            Icon(
                                imageVector = Icons.Default.CalendarToday,
                                contentDescription = "Select date"
                            )
                        }
                    }
                    if (isInteractive && !currentValue.isNullOrBlank()) {
                        IconButton(onClick = { onClearDate() }) {
                            Icon(
                                imageVector = Icons.Default.Clear,
                                contentDescription = "Clear date"
                            )
                        }
                    }
                }
            }
        )
    }

    if (showDatePicker) {
        val initialDate = stringToDate(currentValue)
        val datePickerState = rememberDatePickerState(
            initialSelectedDateMillis = initialDate?.time ?: System.currentTimeMillis()
        )

        DatePickerDialog(
            onDismissRequest = { showDatePicker = false },
            confirmButton = {
                TextButton(
                    onClick = {
                        onDateSelected(datePickerState.selectedDateMillis)
                    }
                ) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(onClick = { showDatePicker = false }) {
                    Text("Cancel")
                }
            }
        ) {
            DatePicker(state = datePickerState)
        }
    }
}
