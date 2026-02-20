package com.neome.feature.form.presentation.components.field

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldSignatureData
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueEntUserIdData
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueLocationData
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueSignatureData
import com.neome.api.meta.base.Types.EnumDefnCaptureValueKind
import com.neome.feature.form.presentation.components.base.FieldBase
import com.neome.feature.form.presentation.components.base.rememberFieldController
import com.neome.feature.form.presentation.state.FieldError
import com.neome.feature.form.presentation.state.FieldEvent

/**
 * Signature field component for form.
 *
 * Displays a non-editable text field showing the signature value,
 * with a trailing clear (cross) icon. Actual signature capture
 * functionality will be implemented later.
 *
 * Optionally renders capture metadata properties (time, user, location)
 * below the text field via [RawCaptureExtraProperties].
 *
 * Uses [FieldValueSignatureData] as the value type.
 *
 * @param defnComp  Field definition (expected to be [DefnFieldSignatureData])
 * @param onFieldEvent Callback to emit field events to the form
 * @param modifier  Modifier for customization
 */
@Composable
fun FieldSignature(
    defnComp: DefnCompSeal,
    onFieldEvent: (FieldEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    val signatureDefn = defnComp as? DefnFieldSignatureData ?: return

    val fieldController = rememberFieldController<FieldValueSignatureData>(
        defnComp = defnComp,
        onFieldEvent = onFieldEvent
    )

    if (fieldController.fieldId == null) return

    val fieldValue = fieldController.value.value
    val (properties, error) = fieldController.field.value

    if (properties.hidden) return

    // Display text: show signature value when present
    val displayValue = fieldValue?.signature ?: ""
    val hasValue = fieldValue != null

    // Capture flags from definition
    val captureTimeEnabled = signatureDefn.captureTime == true
    val captureUserEnabled = signatureDefn.captureUser == true
    val captureLocationEnabled = signatureDefn.captureLocation == true
    val hasCaptureEnabled = captureTimeEnabled || captureUserEnabled || captureLocationEnabled

    // Capture values from field value
    val captureTime = fieldValue?.captureTime
    val captureUser = fieldValue?.captureUser
    val captureLocation = fieldValue?.captureLocation
    val captureLocationLatLng = fieldValue?.captureLocation?.value?.geoPoint?.toString()

    val isInteractive = !properties.disabled && !properties.readOnly

    FieldBase(modifier = modifier, properties = properties) {
        SignatureTextField(
            displayValue = displayValue,
            label = properties.label,
            placeholder = properties.placeholder,
            helperText = properties.helperText,
            error = error,
            isDisabled = properties.disabled,
            isInteractive = isInteractive,
            hasValue = hasValue,
            onClearClick = { fieldController.onChange(null) }
        )

        // Conditional: capture metadata rows
        if (hasCaptureEnabled) {
            Spacer(modifier = Modifier.height(4.dp))
            RawCaptureExtraProperties(
                captureTime = captureTime,
                captureUser = captureUser,
                captureLocation = captureLocation,
                captureLocationError = null,
                captureLocationStatus = null,
                showCapturedValues = signatureDefn.showCapturedValuesOnAside,
                captureLocationLatLng = captureLocationLatLng,
                onRetryLocation = { /* TODO: retry location capture */ },
                onOpenLocationInMap = { /* TODO: open maps intent */ }
            )
        }
    }
}

// =============================================================================
// UI Components
// =============================================================================

/**
 * The main text field for the signature field.
 *
 * Layout:
 * ----------------------------------------------------------
 * | Non-editable area (signature value)        | cross icon |
 * ----------------------------------------------------------
 * helper text || error text
 *
 * The text area is always read-only. The cross icon clears the value.
 */
@Composable
private fun SignatureTextField(
    displayValue: String,
    label: String?,
    placeholder: String?,
    helperText: String?,
    error: FieldError?,
    isDisabled: Boolean,
    isInteractive: Boolean,
    hasValue: Boolean,
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
        trailingIcon = {
            IconButton(
                onClick = onClearClick,
                enabled = isInteractive && hasValue
            ) {
                Icon(
                    imageVector = Icons.Default.Clear,
                    contentDescription = "Clear signature",
                    tint = if (isInteractive && hasValue) {
                        MaterialTheme.colorScheme.onSurface
                    } else {
                        MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
                    }
                )
            }
        }
    )
}
