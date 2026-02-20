package com.neome.feature.form.presentation.components.field

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SelectableDates
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
import androidx.compose.ui.unit.dp

import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueDateRangeData
import com.neome.feature.form.presentation.components.base.FieldBase
import com.neome.feature.form.presentation.components.base.rememberFieldController
import com.neome.feature.form.presentation.state.FieldEvent
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * Date Range field component for form.
 *
 * FormCtx is accessed via LocalFormCtx.current inside rememberFieldController, so this composable
 * must be called inside a Form composable tree.
 *
 * Renders two date inputs (From/To) as a single logical field.
 * The "To" date is constrained to be on or after the "From" date.
 *
 * Key Features (reused from FieldDate):
 * - Matches OutlinedTextField UI exactly
 * - Opens Material3 DatePickerDialog on tap
 * - Read-only text fields (no direct typing)
 * - Stores dates as ISO strings (yyyy-MM-dd)
 * - Displays in friendly format (dd/MM/yyyy)
 * - Same properties, state handling, validation, styling, error handling, enabled/disabled logic
 *
 * DateRange-specific Features:
 * - Two date inputs: "From" (start) and "To" (end)
 * - "To" date picker enforces minimum date based on selected "From" date
 * - If "From" date changes to be later than "To", the "To" date is auto-cleared
 * - Single field value (FieldValueDateRangeData) with `from` and `to` properties
 *
 * @param defnComp Field definition containing field configuration
 * @param onFieldEvent Callback to emit field events to the form
 * @param modifier Modifier for customization
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FieldDateRange(
    defnComp: DefnCompSeal,
    onFieldEvent: (FieldEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    // ========== REUSED FROM FieldDate: Field Controller Setup ==========
    val fieldController = rememberFieldController<FieldValueDateRangeData>(
        defnComp = defnComp,
        onFieldEvent = onFieldEvent
    )

    if (fieldController.fieldId == null) return

    // ========== Collect reactive field value separately for finer-grained recomposition ==========
    val fieldValue = fieldController.value.value

    // ========== Collect reactive field properties and error ==========
    val (properties, error) = fieldController.field.value

    if (properties.hidden) return

    // ========== DateRange-specific: Get Current Values ==========
    val currentFromValue = fieldValue?.from
    val currentToValue = fieldValue?.to

    // ========== DateRange-specific: Picker State Management ==========
    var showFromDatePicker by remember { mutableStateOf(false) }
    var showToDatePicker by remember { mutableStateOf(false) }

    // ========== REUSED FROM FieldDate: Date Formatters ==========
    val isoFormat = remember { SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()) }
    val displayFormat = remember { SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()) }

    // ========== REUSED FROM FieldDate: Date Conversion Functions ==========
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

    // ========== REUSED FROM FieldDate: Display Formatting ==========
    fun formatDateForDisplay(dateString: String?): String {
        if (dateString.isNullOrBlank()) return ""
        val date = stringToDate(dateString) ?: return ""
        return displayFormat.format(date)
    }

    // ========== DateRange-specific: Update Field Value ==========
    fun updateFieldValue(from: String?, to: String?) {
        val newValue = if (from == null && to == null) {
            null
        } else {
            FieldValueDateRangeData(from = from, to = to)
        }
        fieldController.onChange(newValue)
    }

    // ========== DateRange-specific: From Date Selection Handler ==========
    fun onFromDateSelected(timestamp: Long?) {
        val dateString = timestamp?.let { dateToIsoString(Date(it)) }

        // If the new "From" date is after the current "To" date, clear the "To" date
        val fromDate = stringToDate(dateString)
        val toDate = stringToDate(currentToValue)
        val newToValue = if (fromDate != null && toDate != null && toDate.before(fromDate)) {
            null // Clear "To" date since it's now invalid
        } else {
            currentToValue
        }

        updateFieldValue(dateString, newToValue)
        showFromDatePicker = false
    }

    // ========== DateRange-specific: To Date Selection Handler ==========
    fun onToDateSelected(timestamp: Long?) {
        val dateString = timestamp?.let { dateToIsoString(Date(it)) }
        updateFieldValue(currentFromValue, dateString)
        showToDatePicker = false
    }

    // ========== DateRange-specific: Clear Handlers ==========
    fun onClearFromDate() {
        // When clearing "From", also clear "To" to maintain consistency
        updateFieldValue(null, null)
    }

    fun onClearToDate() {
        updateFieldValue(currentFromValue, null)
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
                    showFromDatePicker = true
                }
            }
        }
    }

    // Listen for press interactions on "To" field
    LaunchedEffect(toInteractionSource, isInteractive) {
        if (isInteractive) {
            toInteractionSource.interactions.collect { interaction ->
                if (interaction is PressInteraction.Release) {
                    showToDatePicker = true
                }
            }
        }
    }

    // ========== UI: Two Date Fields Stacked Vertically ==========
    FieldBase(modifier = modifier, properties = properties) {
        Column(modifier = Modifier.fillMaxWidth()) {
            // ===== FROM DATE FIELD (reuses FieldDate OutlinedTextField pattern) =====
            OutlinedTextField(
                value = formatDateForDisplay(currentFromValue),
                onValueChange = { /* Read-only, no manual text input */ },
                label = { Text(properties.label?.let { "$it (From)" } ?: "From") },
                placeholder = properties.placeholder?.let { { Text(it) } },
                enabled = !properties.disabled,
                readOnly = true,
                modifier = Modifier.fillMaxWidth(),
                interactionSource = fromInteractionSource,
                trailingIcon = {
                    Row {
                        if (isInteractive) {
                            IconButton(onClick = { showFromDatePicker = true }) {
                                Icon(
                                    imageVector = Icons.Default.CalendarToday,
                                    contentDescription = "Select start date"
                                )
                            }
                        }
                        if (isInteractive && !currentFromValue.isNullOrBlank()) {
                            IconButton(onClick = { onClearFromDate() }) {
                                Icon(
                                    imageVector = Icons.Default.Clear,
                                    contentDescription = "Clear start date"
                                )
                            }
                        }
                    }
                }
            )

            Spacer(modifier = Modifier.height(8.dp))

            // ===== TO DATE FIELD (reuses FieldDate OutlinedTextField pattern) =====
            OutlinedTextField(
                value = formatDateForDisplay(currentToValue),
                onValueChange = { /* Read-only, no manual text input */ },
                label = { Text(properties.label?.let { "$it (To)" } ?: "To") },
                placeholder = properties.placeholder?.let { { Text(it) } },
            isError = error != null,
            supportingText = error?.message?.let { { Text(it) } } ?: properties.helperText?.let { { Text(it) } },
            enabled = !properties.disabled,
            readOnly = true,
            modifier = Modifier.fillMaxWidth(),
            interactionSource = toInteractionSource,
                trailingIcon = {
                    Row {
                        if (isInteractive) {
                            IconButton(onClick = { showToDatePicker = true }) {
                                Icon(
                                    imageVector = Icons.Default.CalendarToday,
                                    contentDescription = "Select end date"
                                )
                            }
                        }
                        if (isInteractive && !currentToValue.isNullOrBlank()) {
                            IconButton(onClick = { onClearToDate() }) {
                                Icon(
                                    imageVector = Icons.Default.Clear,
                                    contentDescription = "Clear end date"
                                )
                            }
                        }
                    }
                }
            )
        }
    }

    // ========== REUSED FROM FieldDate: DatePickerDialog for "From" Date ==========
    if (showFromDatePicker) {
        val initialDate = stringToDate(currentFromValue)
        val datePickerState = rememberDatePickerState(
            initialSelectedDateMillis = initialDate?.time ?: System.currentTimeMillis()
        )

        DatePickerDialog(
            onDismissRequest = { showFromDatePicker = false },
            confirmButton = {
                TextButton(
                    onClick = {
                        onFromDateSelected(datePickerState.selectedDateMillis)
                    }
                ) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(onClick = { showFromDatePicker = false }) {
                    Text("Cancel")
                }
            }
        ) {
            DatePicker(state = datePickerState)
        }
    }

    // ========== DateRange-specific: DatePickerDialog for "To" Date with Min Date Constraint ==========
    if (showToDatePicker) {
        val initialToDate = stringToDate(currentToValue)
        val minDate = stringToDate(currentFromValue)

        // Create SelectableDates that enforces minimum date constraint
        val selectableDates = remember(minDate) {
            object : SelectableDates {
                override fun isSelectableDate(utcTimeMillis: Long): Boolean {
                    // If no "From" date is set, all dates are selectable
                    if (minDate == null) return true
                    // Only allow dates on or after the "From" date
                    return utcTimeMillis >= minDate.time
                }

                override fun isSelectableYear(year: Int): Boolean {
                    // Allow all years (could be constrained further if needed)
                    return true
                }
            }
        }

        val datePickerState = rememberDatePickerState(
            initialSelectedDateMillis = initialToDate?.time ?: minDate?.time ?: System.currentTimeMillis(),
            selectableDates = selectableDates
        )

        DatePickerDialog(
            onDismissRequest = { showToDatePicker = false },
            confirmButton = {
                TextButton(
                    onClick = {
                        onToDateSelected(datePickerState.selectedDateMillis)
                    }
                ) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(onClick = { showToDatePicker = false }) {
                    Text("Cancel")
                }
            }
        ) {
            DatePicker(state = datePickerState)
        }
    }
}
