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
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Visibility
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.neome.api.meta.base.SysId
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.DefnFieldImage
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.core.common.serializer.api.meta.base.dto.FieldDtoImageData
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueImageData
import com.neome.feature.filepicker.domain.model.FilePickerMode
import com.neome.feature.filepicker.domain.model.FilePickerResult
import com.neome.feature.filepicker.presentation.rememberFilePicker
import com.neome.feature.form.presentation.components.base.FieldBase
import com.neome.feature.form.presentation.components.base.rememberFieldController
import com.neome.feature.form.presentation.state.FieldEvent
import com.neome.feature.utils.MediaFieldUtil

// ============================================================================
// Constants
// ============================================================================

private const val BYTES_PER_MEGABYTE = 1024 * 1024L

// ============================================================================
// Main Component
// ============================================================================

/**
 * Image field component for form.
 *
 * FormCtx is accessed via LocalFormCtx.current inside rememberFieldController, so this composable
 * must be called inside a Form composable tree.
 *
 * A specialized field that allows users to select images from their device.
 * Displays the selected image file name and provides preview and clear actions.
 *
 * Key Features:
 * - Image selection via system file picker
 * - File name display in a read-only text field
 * - Preview button to view the selected image in a dialog
 * - Clear button to remove the selection
 * - File size validation against optional maxSize property
 * - Support for disabled and read-only states
 *
 * @param defnComp Field definition containing field configuration
 * @param onFieldEvent Callback to emit field events to the form
 * @param modifier Modifier for customization
 */
@Composable
fun FieldImage(
    defnComp: DefnCompSeal,
    onFieldEvent: (FieldEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    // Field controller setup
    val fieldController = rememberFieldController<FieldValueImageData>(
        defnComp = defnComp,
        onFieldEvent = onFieldEvent
    )

    if (fieldController.fieldId == null) return

    // Collect reactive field value separately for finer-grained recomposition
    val fieldValue = fieldController.value.value

    // Collect reactive field properties and error
    val (properties, error) = fieldController.field.value

    if (properties.hidden) return

    val context = LocalContext.current

    // Extract max file size from field definition
    val maxSizeBytes = extractMaxSizeBytes(defnComp)

    // --- State ---------------------------------------------------------------
    var showPreviewDialog by remember { mutableStateOf(false) }
    var selectedImageBytes by remember { mutableStateOf<ByteArray?>(null) }

    // Display text: show file name when an image is selected
    val displayFileName = fieldValue?.value?.fileName ?: ""
    val hasImage = fieldValue != null

    // --- Image picked handler ------------------------------------------------
    val onImagePicked: (FilePickerResult) -> Unit = onImagePicked@{ result ->
        // Validate file size
        val sizeValidationError = validateFileSize(result.fileSize, maxSizeBytes)
        if (sizeValidationError != null) {
            // TODO: Show validation error to user
            return@onImagePicked
        }

        val mediaFieldUtil = MediaFieldUtil(context)

        val metaData = mediaFieldUtil.getFieldImageMetaData(result)
            ?: return@onImagePicked

        // Store byteArrays in temp variables for later use (e.g., upload)
        val compressedImageBytes = metaData.compressedImage
        val blurImageBytes = metaData.blurImage

        // Store compressed bytes for preview
        selectedImageBytes = compressedImageBytes

        val fieldValueImageData = FieldValueImageData(
            value = FieldDtoImageData(
                fileName = result.fileName,
                width = 0L,
                height = 0L,
                size = result.fileSize,
                mediaIdImage = SysId.nextId(Types.MediaIdImage::class.java),
                mediaIdBlurImage = SysId.nextId(Types.MediaIdImage::class.java),
                primaryColor = metaData.primaryColor.hexString
            )
        )

        fieldController.onChange(fieldValueImageData)
    }

    // File picker integration
    val launchFilePicker = rememberFilePicker(
        mode = FilePickerMode.IMAGE,
        onResult = { result ->
            if (result != null) {
                onImagePicked(result)
            }
        }
    )

    // Derived state for UI logic
    val isInteractive = !properties.disabled && !properties.readOnly

    // Interaction source for text field click handling
    val interactionSource = remember { MutableInteractionSource() }

    // Handle text field click to open file picker
    LaunchedEffect(interactionSource, isInteractive) {
        if (isInteractive) {
            interactionSource.interactions.collect { interaction ->
                if (interaction is PressInteraction.Release) {
                    launchFilePicker()
                }
            }
        }
    }

    // --- UI ------------------------------------------------------------------
    FieldBase(modifier = modifier, properties = properties) {
        ImageTextField(
            displayFileName = displayFileName,
            label = properties.label,
            placeholder = properties.placeholder,
            helperText = properties.helperText,
            errorMessage = error?.message,
            isDisabled = properties.disabled,
            isInteractive = isInteractive,
            hasImage = hasImage,
            interactionSource = interactionSource,
            onPreviewClick = { showPreviewDialog = true },
            onClearClick = {
                fieldController.onChange(null)
                selectedImageBytes = null
            }
        )

        // Conditional: image preview box
        if (hasImage) {
            Spacer(modifier = Modifier.height(8.dp))
            ImagePreviewBox(
                imageBytes = selectedImageBytes,
                onPreviewClick = { showPreviewDialog = true }
            )
        }
    }

    // --- Full-screen image preview dialog ------------------------------------
    if (showPreviewDialog && selectedImageBytes != null) {
        ImagePreviewDialog(
            byteArray = selectedImageBytes!!,
            fileName = displayFileName,
            onDismiss = { showPreviewDialog = false }
        )
    }
}

// ============================================================================
// UI Components
// ============================================================================

/**
 * The main text field for displaying the selected image file name.
 */
@Composable
private fun ImageTextField(
    displayFileName: String,
    label: String?,
    placeholder: String?,
    helperText: String?,
    errorMessage: String?,
    isDisabled: Boolean,
    isInteractive: Boolean,
    hasImage: Boolean,
    interactionSource: MutableInteractionSource,
    onPreviewClick: () -> Unit,
    onClearClick: () -> Unit
) {
    OutlinedTextField(
        value = displayFileName,
        onValueChange = { /* Read-only, no manual text input */ },
        label = label?.let { { Text(it) } },
        placeholder = { Text(placeholder ?: "Select an image") },
        supportingText = if (errorMessage != null || helperText != null) ({
            SupportingText(
                errorMessage = errorMessage,
                helperText = helperText
            )
        }) else null,
        isError = errorMessage != null,
        enabled = !isDisabled,
        readOnly = true,
        modifier = Modifier.fillMaxWidth(),
        interactionSource = interactionSource,
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Image,
                contentDescription = "Image field"
            )
        },
        trailingIcon = {
            TrailingIcons(
                isInteractive = isInteractive,
                hasImage = hasImage,
                onPreviewClick = onPreviewClick,
                onClearClick = onClearClick
            )
        }
    )
}

/**
 * Trailing icons for preview and clear actions.
 */
@Composable
private fun TrailingIcons(
    isInteractive: Boolean,
    hasImage: Boolean,
    onPreviewClick: () -> Unit,
    onClearClick: () -> Unit
) {
    Row {
        // Preview button - enabled only when an image is selected
        IconButton(
            onClick = onPreviewClick,
            enabled = isInteractive && hasImage
        ) {
            Icon(
                imageVector = Icons.Default.Visibility,
                contentDescription = "Preview image",
                tint = iconTint(
                    isEnabled = isInteractive && hasImage,
                    enabledColor = MaterialTheme.colorScheme.primary
                )
            )
        }

        // Clear button - enabled only when an image is selected and field is interactive
        IconButton(
            onClick = onClearClick,
            enabled = isInteractive && hasImage
        ) {
            Icon(
                imageVector = Icons.Default.Clear,
                contentDescription = "Clear image",
                tint = iconTint(
                    isEnabled = isInteractive && hasImage,
                    enabledColor = MaterialTheme.colorScheme.onSurface
                )
            )
        }
    }
}

/**
 * Supporting text that shows either an error message or helper text.
 */
@Composable
private fun SupportingText(
    errorMessage: String?,
    helperText: String?
) {
    when {
        errorMessage != null -> {
            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.error
            )
        }
        helperText != null -> {
            Text(text = helperText)
        }
    }
}

// ============================================================================
// Utility Functions
// ============================================================================

/**
 * Extracts the maximum file size in bytes from the field definition.
 *
 * @param defnComp The field definition
 * @return Max size in bytes, or null if not specified
 */
private fun extractMaxSizeBytes(defnComp: DefnCompSeal): Long? {
    return (defnComp as? DefnFieldImage)?.maxSize?.let { maxSizeMB ->
        maxSizeMB * BYTES_PER_MEGABYTE
    }
}

/**
 * Validates the file size against the maximum allowed size.
 *
 * @param fileSize The size of the selected file in bytes
 * @param maxSizeBytes The maximum allowed size in bytes, or null for no limit
 * @return Error message if validation fails, null otherwise
 */
private fun validateFileSize(fileSize: Long, maxSizeBytes: Long?): String? {
    if (maxSizeBytes == null) return null
    if (fileSize <= maxSizeBytes) return null

    val maxSizeMB = maxSizeBytes // BYTES_PER_MEGABYTE
    return "File size exceeds maximum allowed size of ${maxSizeMB}MB"
}

/**
 * Returns the appropriate icon tint color based on enabled state.
 */
@Composable
private fun iconTint(isEnabled: Boolean, enabledColor: Color): Color {
    return if (isEnabled) {
        enabledColor
    } else {
        MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
    }
}

// ============================================================================
// Image Preview Components
// ============================================================================

/**
 * Image preview box (150dp x 150dp).
 *
 * Shows the selected image thumbnail if bytes are available, otherwise a placeholder icon.
 * Clicking the preview opens the full-screen preview dialog.
 *
 * @param imageBytes Raw image bytes to display, or null for placeholder
 * @param onPreviewClick Callback when the preview is clicked
 * @param modifier Modifier for customization
 */
@Composable
private fun ImagePreviewBox(
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
                    contentDescription = "Selected image preview",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            } else {
                ImagePreviewPlaceholder()
            }
        } else {
            ImagePreviewPlaceholder()
        }
    }
}

/**
 * Placeholder icon shown when no image is available.
 */
@Composable
private fun ImagePreviewPlaceholder() {
    Icon(
        imageVector = Icons.Default.Image,
        contentDescription = "Image preview placeholder",
        modifier = Modifier.size(48.dp),
        tint = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.4f)
    )
}
