package com.neome.feature.form.presentation.components.field

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueTimeData
import com.neome.feature.form.presentation.components.base.FieldBase
import com.neome.feature.form.presentation.components.base.rememberFieldController
import com.neome.feature.form.presentation.state.FieldEvent
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

/**
 * Time field component for form.
 *
 * FormCtx is accessed via LocalFormCtx.current inside rememberFieldController, so this composable
 * must be called inside a Form composable tree.
 *
 * Behaves exactly like FieldDate but allows time selection only.
 * Opens TimePickerDialog when clicking on the text field or time icon.
 *
 * Key Features (reused from FieldDate):
 * - Matches OutlinedTextField UI exactly
 * - Read-only text field (no direct typing)
 * - Follows form field architecture pattern
 * - Same properties, state handling, validation, styling, error handling, enabled/disabled logic
 *
 * Time-specific Features:
 * - Time picker dialog for hour/minute selection
 * - Stores as ISO time string (HH:mm)
 * - Displays in friendly format (HH:mm)
 * - 24-hour format (consistent with FieldDateTime)
 *
 * @param defnComp Field definition containing field configuration (label, placeholder, helperText, enabled, readOnly)
 * @param onFieldEvent Callback to emit field events to the form
 * @param modifier Modifier for customization
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FieldTime(
    defnComp: DefnCompSeal,
    onFieldEvent: (FieldEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    // ========== REUSED FROM FieldDate: Field Controller Setup ==========
    val fieldController = rememberFieldController<FieldValueTimeData>(
        defnComp = defnComp,
        onFieldEvent = onFieldEvent
    )

    if (fieldController.fieldId == null) return

    // ========== REUSED FROM FieldDate: Reactive Properties ==========
    val properties by fieldController.fieldPropertiesFlow.collectAsStateWithLifecycle()

    if (properties.hidden) return

    // ========== REUSED FROM FieldDate: Current Value & Local State ==========
    // Get current time value from FieldValueTimeData
    val currentValue = fieldController.fieldValue?.value

    // Local state for the displayed time - ensures immediate UI update when time is selected
    // The remember(currentValue) key ensures this syncs if the value changes externally
    var displayValue by remember(currentValue) { mutableStateOf(currentValue) }

    // ========== Time-specific: Picker State ==========
    var showTimePicker by remember { mutableStateOf(false) }

    // ========== Time-specific: Time Formatters ==========
    // ISO format for storage: HH:mm
    val isoFormat = remember { SimpleDateFormat("HH:mm", Locale.getDefault()) }
    // Display format: HH:mm (same as storage for time)
    val displayFormat = remember { SimpleDateFormat("HH:mm", Locale.getDefault()) }

    // ========== REUSED FROM FieldDate: Parsing Logic (adapted for time) ==========
    fun stringToDate(timeString: String?): Date? {
        if (timeString.isNullOrBlank()) return null
        return try {
            isoFormat.parse(timeString)
        } catch (e: Exception) {
            null
        }
    }

    fun dateToIsoString(date: Date?): String {
        if (date == null) return ""
        return isoFormat.format(date)
    }

    // ========== REUSED FROM FieldDate: Display Formatting (adapted for time) ==========
    fun formatTimeForDisplay(timeString: String?): String {
        if (timeString.isNullOrBlank()) return ""
        val date = stringToDate(timeString) ?: return ""
        return displayFormat.format(date)
    }

    // ========== Time-specific: Extract Hour/Minute from Existing Value ==========
    fun getExistingHour(): Int {
        val date = stringToDate(displayValue) ?: return Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
        val calendar = Calendar.getInstance().apply { time = date }
        return calendar.get(Calendar.HOUR_OF_DAY)
    }

    fun getExistingMinute(): Int {
        val date = stringToDate(displayValue) ?: return Calendar.getInstance().get(Calendar.MINUTE)
        val calendar = Calendar.getInstance().apply { time = date }
        return calendar.get(Calendar.MINUTE)
    }

    // ========== REUSED FROM FieldDate: Selection Handler (adapted for time) ==========
    fun onTimeSelected(hour: Int, minute: Int) {
        val calendar = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, hour)
            set(Calendar.MINUTE, minute)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }
        val timeString = dateToIsoString(calendar.time)
        displayValue = timeString // Update local state immediately for instant UI feedback
        val newValue = FieldValueTimeData(timeString)
        fieldController.onChange(newValue)
        showTimePicker = false
    }

    // ========== REUSED FROM FieldDate: Clear Handler ==========
    fun onClearTime() {
        displayValue = null // Update local state immediately
        fieldController.onChange(null)
    }

    // ========== REUSED FROM FieldDate: Interactive State ==========
    val isInteractive = !properties.disabled && !properties.readOnly

    // ========== REUSED FROM FieldDate: InteractionSource for TextField Click ==========
    // InteractionSource to detect clicks on the text field
    val interactionSource = remember { MutableInteractionSource() }

    // Listen for press interactions to open time picker when text field is clicked
    LaunchedEffect(interactionSource, isInteractive) {
        if (isInteractive) {
            interactionSource.interactions.collect { interaction ->
                if (interaction is PressInteraction.Release) {
                    showTimePicker = true
                }
            }
        }
    }

    // ========== REUSED FROM FieldDate: FieldBase + OutlinedTextField UI ==========
    FieldBase(modifier = modifier) {
        OutlinedTextField(
            value = formatTimeForDisplay(displayValue),
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
                        IconButton(onClick = { showTimePicker = true }) {
                            Icon(
                                imageVector = Icons.Default.AccessTime,
                                contentDescription = "Select time"
                            )
                        }
                    }
                    if (isInteractive && !displayValue.isNullOrBlank()) {
                        IconButton(onClick = { onClearTime() }) {
                            Icon(
                                imageVector = Icons.Default.Clear,
                                contentDescription = "Clear time"
                            )
                        }
                    }
                }
            }
        )
    }

    // ========== Time-specific: TimePickerDialog ==========
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
                        onTimeSelected(timePickerState.hour, timePickerState.minute)
                    }
                ) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(onClick = { showTimePicker = false }) {
                    Text("Cancel")
                }
            }
        )
    }
}
