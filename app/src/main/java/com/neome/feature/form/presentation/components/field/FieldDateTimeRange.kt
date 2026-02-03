package com.neome.feature.form.presentation.components.field

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import kotlinx.coroutines.flow.collectLatest
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueDateTimeRangeData
import com.neome.feature.form.presentation.components.base.FieldBase
import com.neome.feature.form.presentation.components.base.rememberFieldController
import com.neome.feature.form.presentation.state.FieldEvent
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

/**
 * DateTime Range field component for form.
 *
 * FormCtx is accessed via LocalFormCtx.current inside rememberFieldController, so this composable
 * must be called inside a Form composable tree.
 *
 * Renders two DateTime inputs (From/To) as a single logical field.
 * The "To" datetime is constrained to be on or after the "From" datetime.
 *
 * Key Features (reused from FieldDate/FieldDateTime):
 * - Matches OutlinedTextField UI exactly
 * - Two-step picker flow: Date -> Time (for each input)
 * - Read-only text fields (no direct typing)
 * - Stores as ISO datetime strings (yyyy-MM-dd'T'HH:mm)
 * - Displays in friendly format (dd MMM yyyy, HH:mm)
 * - Same properties, state handling, validation, styling, error handling, enabled/disabled logic
 *
 * DateTimeRange-specific Features:
 * - Two datetime inputs: "From" (start) and "To" (end)
 * - "To" date picker enforces minimum date based on selected "From" date
 * - "To" time picker enforces minimum time when same date as "From" is selected
 * - If "From" datetime changes to be later than "To", the "To" datetime is auto-cleared
 * - Single field value (FieldValueDateTimeRangeData) with `from` and `to` properties
 *
 * @param defnComp Field definition containing field configuration
 * @param onFieldEvent Callback to emit field events to the form
 * @param modifier Modifier for customization
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FieldDateTimeRange(
    defnComp: DefnCompSeal,
    onFieldEvent: (FieldEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    // ========== REUSED FROM FieldDate: Field Controller Setup ==========
    val fieldController = rememberFieldController<FieldValueDateTimeRangeData>(
        defnComp = defnComp,
        onFieldEvent = onFieldEvent
    )

    if (fieldController.fieldId == null) return

    // ========== REUSED FROM FieldDate: Reactive Properties ==========
    val properties by fieldController.fieldPropertiesFlow.collectAsStateWithLifecycle()

    if (properties.hidden) return

    // ========== DateTimeRange-specific: Get Current Values ==========
    val currentFromValue = fieldController.fieldValue?.from
    val currentToValue = fieldController.fieldValue?.to

    // ========== REUSED FROM FieldDate: Local State for Immediate UI Updates ==========
    var displayFromValue by remember(currentFromValue) { mutableStateOf(currentFromValue) }
    var displayToValue by remember(currentToValue) { mutableStateOf(currentToValue) }

    // ========== DateTimeRange-specific: Picker State Management ==========
    // Which field is being edited: "from" or "to"
    var activeField by remember { mutableStateOf<String?>(null) }
    var showDatePicker by remember { mutableStateOf(false) }
    var showTimePicker by remember { mutableStateOf(false) }

    // Temporarily store selected date timestamp while user picks time
    var selectedDateMillis by remember { mutableLongStateOf(0L) }

    // ========== REUSED FROM FieldDateTime: Date/Time Formatters ==========
    val isoFormat = remember { SimpleDateFormat("yyyy-MM-dd'T'HH:mm", Locale.getDefault()) }
    val displayFormat = remember { SimpleDateFormat("dd MMM yyyy, HH:mm", Locale.getDefault()) }

    // ========== REUSED FROM FieldDateTime: Date Conversion Functions ==========
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

    // ========== REUSED FROM FieldDateTime: Display Formatting ==========
    fun formatDateTimeForDisplay(dateString: String?): String {
        if (dateString.isNullOrBlank()) return ""
        val date = stringToDate(dateString) ?: return ""
        return displayFormat.format(date)
    }

    // ========== REUSED FROM FieldDateTime: Combine Date + Time ==========
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

    // ========== DateTimeRange-specific: Helper to check if two dates are the same day ==========
    fun isSameDay(date1: Date?, date2: Date?): Boolean {
        if (date1 == null || date2 == null) return false
        val cal1 = Calendar.getInstance().apply { time = date1 }
        val cal2 = Calendar.getInstance().apply { time = date2 }
        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
                cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR)
    }

    // ========== DateTimeRange-specific: Get date-only millis (midnight) ==========
    fun getDateOnlyMillis(date: Date?): Long {
        if (date == null) return 0L
        val calendar = Calendar.getInstance().apply {
            time = date
            set(Calendar.HOUR_OF_DAY, 0)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }
        return calendar.timeInMillis
    }

    // ========== REUSED FROM FieldDateTime: Extract Time from Value ==========
    fun getHourFromValue(value: String?): Int {
        val date = stringToDate(value) ?: return Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
        return Calendar.getInstance().apply { time = date }.get(Calendar.HOUR_OF_DAY)
    }

    fun getMinuteFromValue(value: String?): Int {
        val date = stringToDate(value) ?: return Calendar.getInstance().get(Calendar.MINUTE)
        return Calendar.getInstance().apply { time = date }.get(Calendar.MINUTE)
    }

    // ========== DateTimeRange-specific: Update Field Value ==========
    fun updateFieldValue(from: String?, to: String?) {
        val newValue = if (from == null && to == null) {
            null
        } else {
            FieldValueDateTimeRangeData(from = from, to = to)
        }
        fieldController.onChange(newValue)
    }

    // ========== DateTimeRange-specific: Validate and Handle "To" Value When "From" Changes ==========
    fun validateToValueAgainstFrom(newFrom: String?, currentTo: String?): String? {
        val fromDate = stringToDate(newFrom)
        val toDate = stringToDate(currentTo)

        // If "To" is before "From", clear it
        if (fromDate != null && toDate != null && toDate.before(fromDate)) {
            return null
        }
        return currentTo
    }

    // ========== DateTimeRange-specific: Date Selection Handlers ==========
    fun onFromDateConfirmed(timestamp: Long?) {
        if (timestamp != null) {
            selectedDateMillis = timestamp
            showDatePicker = false
            showTimePicker = true
        }
    }

    fun onFromTimeConfirmed(hour: Int, minute: Int) {
        val combinedDateTime = combineDateAndTime(selectedDateMillis, hour, minute)
        val dateTimeString = dateToIsoString(combinedDateTime)
        displayFromValue = dateTimeString

        // Validate and potentially clear "To" value
        val validatedToValue = validateToValueAgainstFrom(dateTimeString, displayToValue)
        if (validatedToValue != displayToValue) {
            displayToValue = validatedToValue
        }

        updateFieldValue(dateTimeString, validatedToValue)
        showTimePicker = false
        activeField = null
    }

    fun onToDateConfirmed(timestamp: Long?) {
        if (timestamp != null) {
            selectedDateMillis = timestamp
            showDatePicker = false
            showTimePicker = true
        }
    }

    fun onToTimeConfirmed(hour: Int, minute: Int) {
        val combinedDateTime = combineDateAndTime(selectedDateMillis, hour, minute)
        val toDate = combinedDateTime
        val fromDate = stringToDate(displayFromValue)

        // Validate: "To" must be >= "From"
        val dateTimeString = if (fromDate != null && toDate.before(fromDate)) {
            // If user selected time that makes "To" before "From", adjust to match "From"
            dateToIsoString(fromDate)
        } else {
            dateToIsoString(toDate)
        }

        displayToValue = dateTimeString
        updateFieldValue(displayFromValue, dateTimeString)
        showTimePicker = false
        activeField = null
    }

    // ========== DateTimeRange-specific: Clear Handlers ==========
    fun onClearFromDateTime() {
        displayFromValue = null
        displayToValue = null // Clear "To" as well for consistency
        updateFieldValue(null, null)
    }

    fun onClearToDateTime() {
        displayToValue = null
        updateFieldValue(displayFromValue, null)
    }

    // ========== REUSED FROM FieldDate: Interactive State ==========
    val isInteractive = !properties.disabled && !properties.readOnly

    // ========== REUSED FROM FieldDate: InteractionSources for TextField Clicks ==========
    val fromInteractionSource = remember { MutableInteractionSource() }
    val toInteractionSource = remember { MutableInteractionSource() }

    // Listen for press interactions on "From" field
    LaunchedEffect(fromInteractionSource, isInteractive) {
        if (isInteractive) {
            fromInteractionSource.interactions.collect { interaction ->
                if (interaction is PressInteraction.Release) {
                    activeField = "from"
                    showDatePicker = true
                }
            }
        }
    }

    // Listen for press interactions on "To" field
    LaunchedEffect(toInteractionSource, isInteractive) {
        if (isInteractive) {
            toInteractionSource.interactions.collect { interaction ->
                if (interaction is PressInteraction.Release) {
                    activeField = "to"
                    showDatePicker = true
                }
            }
        }
    }

    // ========== UI: Two DateTime Fields Stacked Vertically ==========
    FieldBase(modifier = modifier) {
        Column(modifier = Modifier.fillMaxWidth()) {
            // ===== FROM DATETIME FIELD =====
            OutlinedTextField(
                value = formatDateTimeForDisplay(displayFromValue),
                onValueChange = { /* Read-only */ },
                label = { Text(properties.label?.let { "$it (From)" } ?: "From") },
                placeholder = properties.placeholder?.let { { Text(it) } },
                enabled = !properties.disabled,
                readOnly = true,
                modifier = Modifier.fillMaxWidth(),
                interactionSource = fromInteractionSource,
                trailingIcon = {
                    Row {
                        if (isInteractive) {
                            IconButton(onClick = {
                                activeField = "from"
                                showDatePicker = true
                            }) {
                                Icon(
                                    imageVector = Icons.Default.CalendarToday,
                                    contentDescription = "Select start date and time"
                                )
                            }
                        }
                        if (isInteractive && !displayFromValue.isNullOrBlank()) {
                            IconButton(onClick = { onClearFromDateTime() }) {
                                Icon(
                                    imageVector = Icons.Default.Clear,
                                    contentDescription = "Clear start date and time"
                                )
                            }
                        }
                    }
                }
            )

            Spacer(modifier = Modifier.height(8.dp))

            // ===== TO DATETIME FIELD =====
            OutlinedTextField(
                value = formatDateTimeForDisplay(displayToValue),
                onValueChange = { /* Read-only */ },
                label = { Text(properties.label?.let { "$it (To)" } ?: "To") },
                placeholder = properties.placeholder?.let { { Text(it) } },
                supportingText = properties.helperText?.let { { Text(it) } },
                enabled = !properties.disabled,
                readOnly = true,
                modifier = Modifier.fillMaxWidth(),
                interactionSource = toInteractionSource,
                trailingIcon = {
                    Row {
                        if (isInteractive) {
                            IconButton(onClick = {
                                activeField = "to"
                                showDatePicker = true
                            }) {
                                Icon(
                                    imageVector = Icons.Default.CalendarToday,
                                    contentDescription = "Select end date and time"
                                )
                            }
                        }
                        if (isInteractive && !displayToValue.isNullOrBlank()) {
                            IconButton(onClick = { onClearToDateTime() }) {
                                Icon(
                                    imageVector = Icons.Default.Clear,
                                    contentDescription = "Clear end date and time"
                                )
                            }
                        }
                    }
                }
            )
        }
    }

    // ========== DatePickerDialog (Step 1) ==========
    if (showDatePicker) {
        val isFromField = activeField == "from"
        val currentDisplayValue = if (isFromField) displayFromValue else displayToValue
        val initialDate = stringToDate(currentDisplayValue)
        val fromDate = stringToDate(displayFromValue)

        // For "To" field: create SelectableDates that enforces minimum date
        val selectableDates = remember(fromDate, isFromField) {
            if (!isFromField && fromDate != null) {
                val minDateMillis = getDateOnlyMillis(fromDate)
                object : SelectableDates {
                    override fun isSelectableDate(utcTimeMillis: Long): Boolean {
                        return utcTimeMillis >= minDateMillis
                    }
                    override fun isSelectableYear(year: Int): Boolean = true
                }
            } else {
                object : SelectableDates {
                    override fun isSelectableDate(utcTimeMillis: Long): Boolean = true
                    override fun isSelectableYear(year: Int): Boolean = true
                }
            }
        }

        val datePickerState = rememberDatePickerState(
            initialSelectedDateMillis = initialDate?.time
                ?: (if (!isFromField && fromDate != null) fromDate.time else System.currentTimeMillis()),
            selectableDates = selectableDates
        )

        DatePickerDialog(
            onDismissRequest = {
                showDatePicker = false
                activeField = null
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        if (isFromField) {
                            onFromDateConfirmed(datePickerState.selectedDateMillis)
                        } else {
                            onToDateConfirmed(datePickerState.selectedDateMillis)
                        }
                    }
                ) {
                    Text("Next")
                }
            },
            dismissButton = {
                TextButton(onClick = {
                    showDatePicker = false
                    activeField = null
                }) {
                    Text("Cancel")
                }
            }
        ) {
            DatePicker(state = datePickerState)
        }
    }

    // ========== TimePickerDialog (Step 2) ==========
    if (showTimePicker) {
        val isFromField = activeField == "from"
        val currentDisplayValue = if (isFromField) displayFromValue else displayToValue
        val fromDate = stringToDate(displayFromValue)

        // Convert selectedDateMillis to local calendar for proper day comparison
        val selectedCalendar = remember(selectedDateMillis) {
            Calendar.getInstance().apply {
                timeInMillis = selectedDateMillis
            }
        }
        val fromCalendar = remember(fromDate) {
            fromDate?.let {
                Calendar.getInstance().apply { time = it }
            }
        }

        // Check if "To" date picker selected the same day as "From"
        val isToFieldSameDayAsFrom = remember(isFromField, selectedCalendar, fromCalendar) {
            !isFromField && fromCalendar != null &&
                    selectedCalendar.get(Calendar.YEAR) == fromCalendar.get(Calendar.YEAR) &&
                    selectedCalendar.get(Calendar.DAY_OF_YEAR) == fromCalendar.get(Calendar.DAY_OF_YEAR)
        }

        // Compute minimum time from "From" value (only applies when same day)
        // This is the absolute minimum time allowed for "To" field
        val minTimeInMinutes = remember(isToFieldSameDayAsFrom, fromCalendar) {
            if (isToFieldSameDayAsFrom && fromCalendar != null) {
                fromCalendar.get(Calendar.HOUR_OF_DAY) * 60 + fromCalendar.get(Calendar.MINUTE)
            } else {
                0 // No minimum time constraint
            }
        }
        val minHour = minTimeInMinutes / 60
        val minMinute = minTimeInMinutes % 60

        // Determine initial hour/minute for the picker
        val existingHour = getHourFromValue(currentDisplayValue)
        val existingMinute = getMinuteFromValue(currentDisplayValue)
        val existingMinutes = existingHour * 60 + existingMinute

        // For "To" field on same day: start at minimum time if existing value is invalid or empty
        val initialHour: Int
        val initialMinute: Int

        if (isToFieldSameDayAsFrom) {
            if (currentDisplayValue.isNullOrBlank() || existingMinutes < minTimeInMinutes) {
                // Use minimum time as starting point
                initialHour = minHour
                initialMinute = minMinute
            } else {
                initialHour = existingHour
                initialMinute = existingMinute
            }
        } else {
            initialHour = existingHour
            initialMinute = existingMinute
        }

        val timePickerState = rememberTimePickerState(
            initialHour = initialHour,
            initialMinute = initialMinute,
            is24Hour = true
        )

        // Track the currently selected time in minutes for reactive validation
        // Using mutableState to track picker changes and trigger recomposition
        var currentSelectedMinutes by remember { mutableIntStateOf(initialHour * 60 + initialMinute) }

        // Use snapshotFlow to reactively track time picker state changes
        LaunchedEffect(timePickerState) {
            snapshotFlow {
                timePickerState.hour * 60 + timePickerState.minute
            }.collectLatest { selectedMinutes ->
                currentSelectedMinutes = selectedMinutes
            }
        }

        // Derive validity based on tracked current selection
        val isTimeSelectionValid by remember(isToFieldSameDayAsFrom, minTimeInMinutes) {
            derivedStateOf {
                if (!isToFieldSameDayAsFrom) {
                    true // No constraint for "From" field or when on different day
                } else {
                    currentSelectedMinutes >= minTimeInMinutes
                }
            }
        }

        AlertDialog(
            onDismissRequest = {
                showTimePicker = false
                activeField = null
            },
            title = { Text(if (isFromField) "Select Start Time" else "Select End Time") },
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
                    // Show constraint info for "To" field on same day
                    if (isToFieldSameDayAsFrom) {
                        Text(
                            text = if (isTimeSelectionValid) {
                                "Minimum time: ${String.format("%02d:%02d", minHour, minMinute)}"
                            } else {
                                "Time must be ${String.format("%02d:%02d", minHour, minMinute)} or later"
                            },
                            modifier = Modifier.padding(top = 8.dp),
                            style = MaterialTheme.typography.bodySmall,
                            color = if (isTimeSelectionValid) {
                                MaterialTheme.colorScheme.primary
                            } else {
                                MaterialTheme.colorScheme.error
                            }
                        )
                    }
                }
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        if (isFromField) {
                            onFromTimeConfirmed(timePickerState.hour, timePickerState.minute)
                        } else {
                            onToTimeConfirmed(timePickerState.hour, timePickerState.minute)
                        }
                    },
                    // CRITICAL: Disable OK button when selected time is before minimum
                    // This prevents invalid selections at the picker UI level
                    enabled = isTimeSelectionValid
                ) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        showTimePicker = false
                        showDatePicker = true // Go back to date picker
                    }
                ) {
                    Text("Back")
                }
            }
        )
    }
}
