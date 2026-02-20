package com.neome.feature.form.presentation.components.field

import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.neome.api.meta.base.SysId
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldCameraData
import com.neome.core.common.serializer.api.meta.base.dto.FieldDtoImageData
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueCameraData
import com.neome.feature.camera.domain.model.CapturedImage
import com.neome.feature.camera.presentation.capture.CameraCaptureScreen
import com.neome.feature.form.presentation.components.base.FieldBase
import com.neome.feature.form.presentation.components.base.rememberFieldController
import com.neome.feature.form.presentation.state.FieldError
import com.neome.feature.form.presentation.state.FieldEvent
import com.neome.feature.utils.MediaFieldUtil

/**
 * Camera field component for form.
 *
 * Displays a non-editable text field showing the captured image file name,
 * with a camera leading icon, preview (eye) and clear (cross) trailing icons.
 * Tapping the camera icon or the text area opens the camera capture screen
 * in a full-screen dialog.
 *
 * Optionally renders an image preview box and capture metadata properties.
 *
 * Uses [FieldValueCameraData] as the value type.
 *
 * @param defnComp  Field definition (expected to be [DefnFieldCameraData])
 * @param onFieldEvent Callback to emit field events to the form
 * @param modifier  Modifier for customization
 */
@Composable
fun FieldCamera(
    defnComp: DefnCompSeal,
    onFieldEvent: (FieldEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    val cameraDefn = defnComp as? DefnFieldCameraData ?: return

    val fieldController = rememberFieldController<FieldValueCameraData>(
        defnComp = defnComp,
        onFieldEvent = onFieldEvent
    )

    if (fieldController.fieldId == null) return

    val fieldValue = fieldController.value.value
    val (properties, error) = fieldController.field.value

    if (properties.hidden) return

    // Display text: show file name when an image is captured
    val displayFileName = fieldValue?.value?.fileName ?: ""
    val hasImage = fieldValue != null

    // Capture flags from definition
    val captureTimeEnabled = cameraDefn.captureTime == true
    val captureUserEnabled = cameraDefn.captureUser == true
    val captureLocationEnabled = cameraDefn.captureLocation == true
    val hasCaptureEnabled = captureTimeEnabled || captureUserEnabled || captureLocationEnabled

    // Capture values from field value
    val captureTime = fieldValue?.captureTime
    val captureUser = fieldValue?.captureUser
    val captureLocation = fieldValue?.captureLocation
    val captureLocationLatLng = fieldValue?.captureLocation?.value?.geoPoint?.toString()

    val isInteractive = !properties.disabled && !properties.readOnly

    val context = LocalContext.current

    // --- State ---------------------------------------------------------------
    var showCamera by remember { mutableStateOf(false) }
    var showPreviewDialog by remember { mutableStateOf(false) }
    var capturedImageBytes by remember { mutableStateOf<ByteArray?>(null) }

    val onCameraCaptured: (CapturedImage) -> Unit = onCameraCaptured@{ capturedImage ->
        val mediaFieldUtil = MediaFieldUtil(context)

        val metaData = mediaFieldUtil.getFieldCameraMetaData(capturedImage)
            ?: return@onCameraCaptured

        // Store byteArrays in temp variables for later use (e.g., upload)
        val compressedImageBytes = metaData.compressedImage
        val blurImageBytes = metaData.blurImage

        // Store original bytes for preview
        capturedImageBytes = capturedImage.bytes

        val fieldValueCameraData = FieldValueCameraData(
            value = FieldDtoImageData(
                fileName = capturedImage.mimeType,
                width = capturedImage.width.toLong(),
                height = capturedImage.height.toLong(),
                size = capturedImage.bytes.size.toLong(),
                mediaIdImage = SysId.nextId(Types.MediaIdImage::class.java),
                mediaIdBlurImage = SysId.nextId(Types.MediaIdImage::class.java),
                primaryColor = metaData.primaryColor.hexString
            )
        )

        fieldController.onChange(fieldValueCameraData)
    }

    // --- Click detection on text field ---------------------------------------
    // When the user taps anywhere on the text field (camera icon or text area),
    // open the camera. Same pattern as FieldImage.kt.
    val interactionSource = remember { MutableInteractionSource() }

    LaunchedEffect(interactionSource, isInteractive) {
        if (isInteractive) {
            interactionSource.interactions.collect { interaction ->
                if (interaction is PressInteraction.Release) {
                    showCamera = true
                }
            }
        }
    }

    // --- UI ------------------------------------------------------------------
    FieldBase(modifier = modifier, properties = properties) {
        // Main text field row
        CameraTextField(
            displayFileName = displayFileName,
            label = properties.label,
            placeholder = properties.placeholder,
            helperText = properties.helperText,
            error = error,
            isDisabled = properties.disabled,
            isInteractive = isInteractive,
            hasImage = hasImage,
            interactionSource = interactionSource,
            onPreviewClick = { showPreviewDialog = true },
            onClearClick = {
                fieldController.onChange(null)
                capturedImageBytes = null
            }
        )

        // Conditional: image preview box
        if (hasImage) {
            Spacer(modifier = Modifier.height(8.dp))
            CameraImagePreview(
                imageBytes = capturedImageBytes,
                onPreviewClick = { showPreviewDialog = true }
            )
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
                showCapturedValues = cameraDefn.showCapturedValuesOnAside,
                captureLocationLatLng = captureLocationLatLng,
                onRetryLocation = { /* TODO: retry location capture */ },
                onOpenLocationInMap = { /* TODO: open maps intent */ }
            )
        }
    }

    // --- Full-screen camera dialog -------------------------------------------
    if (showCamera) {
        Dialog(
            onDismissRequest = { showCamera = false },
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = false,
                usePlatformDefaultWidth = false
            )
        ) {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                CameraCaptureScreen(
                    onImageCaptured = { capturedImage ->
                        showCamera = false
                        onCameraCaptured(capturedImage)
                    },
                    onCancelled = { showCamera = false },
                    onError = { showCamera = false }
                )
            }
        }
    }

    // --- Full-screen image preview dialog ------------------------------------
    if (showPreviewDialog && capturedImageBytes != null) {
        ImagePreviewDialog(
            byteArray = capturedImageBytes!!,
            fileName = displayFileName,
            onDismiss = { showPreviewDialog = false }
        )
    }
}

// =============================================================================
// UI Components
// =============================================================================

/**
 * The main text field for the camera field.
 *
 * Layout:
 * ----------------------------------------------------------
 * | cameraIcon | Non editable area | eye icon | cross icon |
 * ----------------------------------------------------------
 * helper text || error text
 *
 * Clicking anywhere on the text field (via [interactionSource]) triggers the
 * camera to open when the field is interactive.
 */
@Composable
private fun CameraTextField(
    displayFileName: String,
    label: String?,
    placeholder: String?,
    helperText: String?,
    error: FieldError?,
    isDisabled: Boolean,
    isInteractive: Boolean,
    hasImage: Boolean,
    interactionSource: MutableInteractionSource,
    onPreviewClick: () -> Unit,
    onClearClick: () -> Unit
) {
    OutlinedTextField(
        value = displayFileName,
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
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.CameraAlt,
                contentDescription = "Camera"
            )
        },
        trailingIcon = {
            CameraTrailingIcons(
                isInteractive = isInteractive,
                hasImage = hasImage,
                onPreviewClick = onPreviewClick,
                onClearClick = onClearClick
            )
        }
    )
}

/**
 * Trailing icons: preview (eye) and clear (cross).
 */
@Composable
private fun CameraTrailingIcons(
    isInteractive: Boolean,
    hasImage: Boolean,
    onPreviewClick: () -> Unit,
    onClearClick: () -> Unit
) {
    Row {
        IconButton(
            onClick = onPreviewClick,
            enabled = hasImage
        ) {
            Icon(
                imageVector = Icons.Default.Visibility,
                contentDescription = "Preview image",
                tint = if (hasImage) {
                    MaterialTheme.colorScheme.primary
                } else {
                    MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
                }
            )
        }

        IconButton(
            onClick = onClearClick,
            enabled = isInteractive && hasImage
        ) {
            Icon(
                imageVector = Icons.Default.Clear,
                contentDescription = "Clear image",
                tint = if (isInteractive && hasImage) {
                    MaterialTheme.colorScheme.onSurface
                } else {
                    MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
                }
            )
        }
    }
}

/**
 * Image preview box (150dp x 150dp).
 *
 * Shows the captured image if bytes are available, otherwise a placeholder icon.
 * Clicking the preview opens the full-screen preview dialog.
 *
 * @param imageBytes Raw image bytes to display, or null for placeholder
 * @param onPreviewClick Callback when the preview is clicked
 * @param modifier Modifier for customization
 */
@Composable
private fun CameraImagePreview(
    imageBytes: ByteArray?,
    onPreviewClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val shape = RoundedCornerShape(8.dp)

    Box(
        modifier = modifier
            .size(150.dp)
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.outlineVariant,
                shape = shape
            )
            .clip(shape)
            .clickable(onClick = onPreviewClick),
        contentAlignment = Alignment.Center
    ) {
        if (imageBytes != null) {
            val bitmap = remember(imageBytes) {
                BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
            }
            if (bitmap != null) {
                Image(
                    bitmap = bitmap.asImageBitmap(),
                    contentDescription = "Captured image preview",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            } else {
                CameraImagePlaceholder()
            }
        } else {
            CameraImagePlaceholder()
        }
    }
}

/**
 * Placeholder icon shown when no image is available.
 */
@Composable
private fun CameraImagePlaceholder() {
    Icon(
        imageVector = Icons.Default.CameraAlt,
        contentDescription = "Image preview placeholder",
        modifier = Modifier.size(48.dp),
        tint = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.4f)
    )
}
