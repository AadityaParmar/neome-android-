package com.neome.feature.form.presentation.components.field

import android.graphics.BitmapFactory
import android.util.Base64
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldSignatureData
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueSignatureData
import com.neome.feature.form.presentation.components.base.FieldBase
import com.neome.feature.form.presentation.components.base.rememberFieldController
import com.neome.feature.form.presentation.state.FieldError
import com.neome.feature.form.presentation.state.FieldEvent

/**
 * Signature field component for form.
 *
 * Displays a non-editable text field. When tapped, opens a full-screen
 * [SignatureDrawDialog] for freeform signature drawing. On "Done", the
 * drawn signature is cropped, encoded as a base64 PNG string, and stored
 * in [FieldValueSignatureData.signature]. The signature is also displayed
 * as an image preview below the text field.
 *
 * Optionally renders capture metadata properties (time, user, location)
 * below the preview via [RawCaptureExtraProperties].
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

    // Display text: show "Signed" indicator when signature exists
    val hasValue = fieldValue != null
    val displayValue = if (hasValue) "Signed" else ""

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

    // --- State ---------------------------------------------------------------
    var showSignatureDialog by remember { mutableStateOf(false) }

    // --- Click detection on text field ---------------------------------------
    val interactionSource = remember { MutableInteractionSource() }

    LaunchedEffect(interactionSource, isInteractive) {
        if (isInteractive) {
            interactionSource.interactions.collect { interaction ->
                if (interaction is PressInteraction.Release) {
                    showSignatureDialog = true
                }
            }
        }
    }

    // --- UI ------------------------------------------------------------------
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
            interactionSource = interactionSource,
            onClearClick = { fieldController.onChange(null) }
        )

        // Conditional: signature image preview
        if (fieldValue != null) {
            Spacer(modifier = Modifier.height(8.dp))
            SignatureImagePreview(base64Signature = fieldValue.signature)
        }

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

    // --- Signature draw dialog -----------------------------------------------
    if (showSignatureDialog) {
        SignatureDrawDialog(
            onDismiss = { showSignatureDialog = false },
            onConfirm = { base64Signature ->
                showSignatureDialog = false
                if (base64Signature != null) {
                    val signatureValue = FieldValueSignatureData(
                        handle = "",
                        signature = base64Signature
                    )
                    fieldController.onChange(signatureValue)
                }
            }
        )
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
 * Clicking anywhere on the text field (via [interactionSource]) triggers
 * the signature draw dialog when the field is interactive.
 * The cross icon clears the value.
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
    interactionSource: MutableInteractionSource,
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

/**
 * Displays the signature as a decoded image from its base64 PNG string.
 *
 * Shows the cropped signature image inside a bordered box.
 * If decoding fails, nothing is rendered.
 *
 * @param base64Signature Base64-encoded PNG string of the signature
 * @param modifier Modifier for customization
 */
@Composable
private fun SignatureImagePreview(
    base64Signature: String,
    modifier: Modifier = Modifier
) {
    val bitmap = remember(base64Signature) {
        try {
            val bytes = Base64.decode(base64Signature, Base64.NO_WRAP)
            BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
        } catch (e: Exception) {
            null
        }
    }

    if (bitmap != null) {
        val shape = RoundedCornerShape(8.dp)
        Box(
            modifier = modifier
                .fillMaxWidth()
                .heightIn(min = 80.dp, max = 150.dp)
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.outlineVariant,
                    shape = shape
                )
                .clip(shape),
            contentAlignment = Alignment.Center
        ) {
            Image(
                bitmap = bitmap.asImageBitmap(),
                contentDescription = "Signature preview",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Fit
            )
        }
    }
}
