package com.neome.feature.form.presentation.components.field

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueDateData
import com.neome.feature.form.presentation.components.base.FieldBase
import com.neome.feature.form.presentation.components.base.rememberFieldController
import com.neome.feature.form.presentation.state.FieldEvent
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

/**
 * DateTime field component for form.
 *
 * Extends the FieldDate pattern to include time selection.
 * Opens DatePickerDialog first, then TimePickerDialog, and combines the result.
 *
 * Key Features (same as FieldDate):
 * - Matches OutlinedTextField UI exactly
 * - Read-only text field (no direct typing)
 * - Follows form field architecture pattern
 * - Same properties, state handling, validation, styling, error handling, enabled/disabled logic
 *
 * DateTime-specific Features:
 * - Two-step picker flow: Date -> Time
 * - Stores as ISO datetime string (yyyy-MM-dd'T'HH:mm)
 * - Displays in friendly format (dd MMM yyyy, HH:mm)
 *
 * FormCtx is accessed via LocalFormCtx.current inside rememberFieldController,
 * so this composable must be called inside a Form composable tree.
 *
 * @param defnComp Field definition containing field configuration (label, placeholder, helperText, enabled, readOnly)
 * @param onFieldEvent Callback to emit field events to the form
 * @param modifier Modifier for customization
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FieldDateTime(
    defnComp: DefnCompSeal,
    onFieldEvent: (FieldEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    // ========== REUSED FROM FieldDate: Field Controller Setup ==========
    val fieldController = rememberFieldController<FieldValueDateData>(
        defnComp = defnComp,
        onFieldEvent = onFieldEvent
    )

    if (fieldController.fieldId == null) return

    // ========== Collect reactive field value separately for finer-grained recomposition ==========
    val fieldValue = fieldController.value.value

    // ========== Collect reactive field properties and error ==========
    val (properties, _) = fieldController.field.value

    if (properties.hidden) return

    // ========== Current Value ==========
    val currentValue = fieldValue?.value

    // ========== DateTime-specific: Picker State Management ==========
    // Picker flow states
    var showDatePicker by remember { mutableStateOf(false) }
    var showTimePicker by remember { mutableStateOf(false) }

    // Temporarily store selected date timestamp while user picks time
    var selectedDateMillis by remember { mutableLongStateOf(0L) }

    // ========== DateTime-specific: Date/Time Formatters ==========
    // ISO format for storage: yyyy-MM-dd'T'HH:mm
    val isoFormat = remember { SimpleDateFormat("yyyy-MM-dd'T'HH:mm", Locale.getDefault()) }
    // Display format: dd MMM yyyy, HH:mm (e.g., "27 Jan 2026, 14:30")
    val displayFormat = remember { SimpleDateFormat("dd MMM yyyy, HH:mm", Locale.getDefault()) }

    // ========== REUSED FROM FieldDate: Date Parsing Logic (extended for datetime) ==========
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

    // ========== REUSED FROM FieldDate: Display Formatting (extended for datetime) ==========
    fun formatDateTimeForDisplay(dateString: String?): String {
        if (dateString.isNullOrBlank()) return ""
        val date = stringToDate(dateString) ?: return ""
        return displayFormat.format(date)
    }

    // ========== DateTime-specific: Combine Date + Time ==========
    fun combineDateAndTime(dateMillis: Long, hour: Int, minute: Int): Date {
        val calendar = Calendar.getInstance().apply {
            timeInMillis = dateMillis
            set(Calendar.HOUR_OF_DAY, hour)
            set(Calendar.MINUTE, minute)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }
        return calendar.time
    }

    // ========== DateTime-specific: Extract Time from Existing Value ==========
    fun getExistingHour(): Int {
        val date = stringToDate(currentValue) ?: return Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
        val calendar = Calendar.getInstance().apply { time = date }
        return calendar.get(Calendar.HOUR_OF_DAY)
    }

    fun getExistingMinute(): Int {
        val date = stringToDate(currentValue) ?: return Calendar.getInstance().get(Calendar.MINUTE)
        val calendar = Calendar.getInstance().apply { time = date }
        return calendar.get(Calendar.MINUTE)
    }

    // ========== DateTime-specific: Selection Handlers ==========
    fun onDateConfirmed(timestamp: Long?) {
        if (timestamp != null) {
            selectedDateMillis = timestamp
            showDatePicker = false
            showTimePicker = true // Proceed to time picker
        }
    }

    fun onTimeConfirmed(hour: Int, minute: Int) {
        val combinedDateTime = combineDateAndTime(selectedDateMillis, hour, minute)
        val dateTimeString = dateToIsoString(combinedDateTime)
        val newValue = FieldValueDateData(dateTimeString)
        fieldController.onChange(newValue)
        showTimePicker = false
    }

    // ========== REUSED FROM FieldDate: Clear Handler ==========
    fun onClearDateTime() {
        fieldController.onChange(null)
    }

    // ========== REUSED FROM FieldDate: Interactive State ==========
    val isInteractive = !properties.disabled && !properties.readOnly

    // ========== REUSED FROM FieldDate: InteractionSource for TextField Click ==========
    val interactionSource = remember { MutableInteractionSource() }

    // Listen for press interactions to open date picker when text field is clicked
    LaunchedEffect(interactionSource, isInteractive) {
        if (isInteractive) {
            interactionSource.interactions.collect { interaction ->
                if (interaction is PressInteraction.Release) {
                    showDatePicker = true
                }
            }
        }
    }

    // ========== REUSED FROM FieldDate: FieldBase + OutlinedTextField UI ==========
    FieldBase(modifier = modifier) {
        OutlinedTextField(
            value = formatDateTimeForDisplay(currentValue),
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
                                contentDescription = "Select date and time"
                            )
                        }
                    }
                    if (isInteractive && !currentValue.isNullOrBlank()) {
                        IconButton(onClick = { onClearDateTime() }) {
                            Icon(
                                imageVector = Icons.Default.Clear,
                                contentDescription = "Clear date and time"
                            )
                        }
                    }
                }
            }
        )
    }

    // ========== REUSED FROM FieldDate: DatePickerDialog (Step 1) ======
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
                        onDateConfirmed(datePickerState.selectedDateMillis)
                    }
                ) {
                    Text("Next")
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

    // ========== DateTime-specific: TimePickerDialog (Step 2) ==========
    if (showTimePicker) {
        val timePickerState = rememberTimePickerState(
            initialHour = getExistingHour(),
            initialMinute = getExistingMinute(),
            is24Hour = true
        )

        AlertDialog(
            onDismissRequest = { showTimePicker = false },
            title = { Text("Select Time") },
            text = {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    TimePicker(
                        state = timePickerState,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        onTimeConfirmed(timePickerState.hour, timePickerState.minute)
                    }
                ) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        showTimePicker = false
                        // Go back to date picker
                        showDatePicker = true
                    }
                ) {
                    Text("Back")
                }
            }
        )
    }
}
