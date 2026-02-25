package com.neome.feature.form.presentation.components.field

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.QrCodeScanner
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.neome.api.meta.base.Types.EnumDefnScanCodeType
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldScanCodeData
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueScanCodeData
import com.neome.feature.camera.presentation.components.FullScreenCameraDialog
import com.neome.feature.form.presentation.components.base.FieldBase
import com.neome.feature.form.presentation.components.base.rememberFieldController
import com.neome.feature.form.presentation.state.FieldError
import com.neome.feature.form.presentation.state.FieldEvent

/**
 * Scan-code field component for form.
 *
 * Displays a non-editable text field showing the scanned code value,
 * with a QR-scanner trailing icon and a clear (cross) trailing icon.
 * Tapping inside the text field or the QR icon opens [RawScanCode] in a
 * full-screen dialog.
 *
 * Layout:
 * ```
 * --------------------------------------------------------
 * | Non editable text field       | qr icon | cross icon |
 * --------------------------------------------------------
 * helper text || error text
 * [RawCaptureExtraProperties]       ← TODO: handled later
 * ```
 *
 * The allowed scan formats are derived from [DefnFieldScanCodeData.qrCode] and
 * [DefnFieldScanCodeData.barCode] boolean flags:
 * - Both true → scan all formats
 * - Only qrCode true → scan QR-type formats only
 * - Only barCode true → scan barcode formats only
 * - Neither true → defaults to all formats
 *
 * On successful scan the value is stored as [FieldValueScanCodeData] with:
 * - `scanCode` = the decoded string
 * - `scanCodeType` = [EnumDefnScanCodeType.qrCode] or [EnumDefnScanCodeType.barCode]
 *   based on whichever flag is enabled in the definition.
 *
 * Uses [FieldValueScanCodeData] as the value type and
 * [DefnFieldScanCodeData] as the field definition.
 *
 * @param defnComp  Field definition (expected to be [DefnFieldScanCodeData])
 * @param onFieldEvent Callback to emit field events to the form
 * @param modifier  Modifier for customization
 */
@Composable
fun FieldScanCode(
    defnComp: DefnCompSeal,
    onFieldEvent: (FieldEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    val scanCodeDefn = defnComp as? DefnFieldScanCodeData ?: return

    val fieldController = rememberFieldController<FieldValueScanCodeData>(
        defnComp = defnComp,
        onFieldEvent = onFieldEvent
    )

    if (fieldController.fieldId == null) return

    val fieldValue = fieldController.value.value
    val (properties, error) = fieldController.field.value

    if (properties.hidden) return

    // Display text: show the scanned code value when available
    val displayValue = fieldValue?.scanCode ?: ""
    val hasValue = fieldValue != null

    val isInteractive = !properties.disabled && !properties.readOnly

    // --- Resolve allowed scan formats from defn flags ------------------------
    val qrEnabled = scanCodeDefn.qrCode == true
    val barEnabled = scanCodeDefn.barCode == true

    val allowedFormats = when {
        qrEnabled && barEnabled -> ScanCodeFormat.all
        qrEnabled -> ScanCodeFormat.qrCodeTypes
        barEnabled -> ScanCodeFormat.barCodeTypes
        else -> ScanCodeFormat.all // fallback: accept everything
    }

    // Resolve scanCodeType to store in the field value.
    // When only one type is enabled, use that type directly.
    // When both are enabled, default to qrCode (the scanner decodes whatever
    // it finds first; a more precise approach would inspect the ZXing
    // BarcodeFormat of the result, but that is outside the scope of the
    // current RawScanCode API).
    val resolvedScanCodeType = when {
        qrEnabled && !barEnabled -> EnumDefnScanCodeType.qrCode
        barEnabled && !qrEnabled -> EnumDefnScanCodeType.barCode
        else -> EnumDefnScanCodeType.qrCode // default when both or neither
    }

    // --- Capture flags (for future RawCaptureExtraProperties) ----------------
    val captureTimeEnabled = scanCodeDefn.captureTime == true
    val captureUserEnabled = scanCodeDefn.captureUser == true
    val captureLocationEnabled = scanCodeDefn.captureLocation == true
    val hasCaptureEnabled = captureTimeEnabled || captureUserEnabled || captureLocationEnabled

    // Capture values from field value
    val captureTime = fieldValue?.captureTime
    val captureUser = fieldValue?.captureUser
    val captureLocation = fieldValue?.captureLocation
    val captureLocationLatLng = fieldValue?.captureLocation?.value?.geoPoint?.toString()

    // --- State ---------------------------------------------------------------
    var showScanner by remember { mutableStateOf(false) }

    // --- Click detection on text field ---------------------------------------
    val interactionSource = remember { MutableInteractionSource() }

    LaunchedEffect(interactionSource, isInteractive) {
        if (isInteractive) {
            interactionSource.interactions.collect { interaction ->
                if (interaction is PressInteraction.Release) {
                    showScanner = true
                }
            }
        }
    }

    // --- UI ------------------------------------------------------------------
    FieldBase(modifier = modifier, properties = properties) {
        ScanCodeTextField(
            displayValue = displayValue,
            label = properties.label,
            placeholder = properties.placeholder,
            helperText = properties.helperText,
            error = error,
            isDisabled = properties.disabled,
            isInteractive = isInteractive,
            hasValue = hasValue,
            interactionSource = interactionSource,
            onScanClick = { showScanner = true },
            onClearClick = { fieldController.onChange(null) }
        )

        // Capture metadata rows (placeholder for future implementation)
        if (hasCaptureEnabled) {
            Spacer(modifier = Modifier.height(4.dp))
            RawCaptureExtraProperties(
                captureTime = captureTime,
                captureUser = captureUser,
                captureLocation = captureLocation,
                captureLocationError = null,
                captureLocationStatus = null,
                showCapturedValues = scanCodeDefn.showCapturedValuesOnAside,
                captureLocationLatLng = captureLocationLatLng,
                onRetryLocation = { /* TODO: capture handler callback */ },
                onOpenLocationInMap = { /* TODO: maps intent callback */ }
            )
        }
    }

    // --- Scanner dialog ------------------------------------------------------
    if (showScanner) {
        FullScreenCameraDialog(
            onDismiss = { showScanner = false }
        ) {
            RawScanCode(
                codeTypes = allowedFormats,
                onScanned = { scannedValue ->
                    val fieldValueScanCodeData = FieldValueScanCodeData(
                        scanCode = scannedValue,
                        scanCodeType = resolvedScanCodeType
                    )
                    fieldController.onChange(fieldValueScanCodeData)
                    showScanner = false
                },
                onDismiss = { showScanner = false }
            )
        }
    }
}

// =============================================================================
// UI Components
// =============================================================================

/**
 * The main text field for the scan-code field.
 *
 * Layout:
 * ```
 * --------------------------------------------------------
 * | Non editable text field       | qr icon | cross icon |
 * --------------------------------------------------------
 * helper text || error text
 * ```
 *
 * Clicking anywhere on the text field (via [interactionSource]) opens the
 * scanner when the field is interactive.
 *
 * @param displayValue The scanned code string to display
 * @param label Optional label above the field
 * @param placeholder Optional placeholder when empty
 * @param helperText Optional helper text below the field
 * @param error Validation error to display (overrides helperText)
 * @param isDisabled Whether the field is disabled
 * @param isInteractive Whether the field responds to user input
 * @param hasValue Whether a scanned value exists
 * @param interactionSource Interaction source for detecting taps on the text field
 * @param onScanClick Called when the QR scan icon is tapped
 * @param onClearClick Called when the clear icon is tapped
 */
@Composable
private fun ScanCodeTextField(
    displayValue: String,
    label: String?,
    placeholder: String?,
    helperText: String?,
    error: FieldError?,
    isDisabled: Boolean,
    isInteractive: Boolean,
    hasValue: Boolean,
    interactionSource: MutableInteractionSource,
    onScanClick: () -> Unit,
    onClearClick: () -> Unit
) {
    OutlinedTextField(
        value = displayValue,
        onValueChange = {},
        label = label?.let { { Text(it) } },
        placeholder = placeholder?.let { { Text(it) } },
        isError = error != null,
        supportingText = error?.message?.let { { Text(it) } }
            ?: helperText?.let { { Text(it) } },
        enabled = !isDisabled,
        readOnly = true,
        maxLines = 1,
        modifier = Modifier.fillMaxWidth(),
        interactionSource = interactionSource,
        trailingIcon = {
            ScanCodeTrailingIcons(
                isInteractive = isInteractive,
                hasValue = hasValue,
                onScanClick = onScanClick,
                onClearClick = onClearClick
            )
        }
    )
}

/**
 * Trailing icons: QR scanner and clear (cross).
 *
 * - **QR icon**: enabled when the field is interactive
 * - **Clear icon**: enabled when the field is interactive and has a value
 */
@Composable
private fun ScanCodeTrailingIcons(
    isInteractive: Boolean,
    hasValue: Boolean,
    onScanClick: () -> Unit,
    onClearClick: () -> Unit
) {
    Row {
        IconButton(
            onClick = onScanClick,
            enabled = isInteractive
        ) {
            Icon(
                imageVector = Icons.Default.QrCodeScanner,
                contentDescription = "Scan code",
                tint = if (isInteractive) {
                    MaterialTheme.colorScheme.primary
                } else {
                    MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
                }
            )
        }

        IconButton(
            onClick = onClearClick,
            enabled = isInteractive && hasValue
        ) {
            Icon(
                imageVector = Icons.Default.Clear,
                contentDescription = "Clear scanned value",
                tint = if (isInteractive && hasValue) {
                    MaterialTheme.colorScheme.onSurface
                } else {
                    MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
                }
            )
        }
    }
}
