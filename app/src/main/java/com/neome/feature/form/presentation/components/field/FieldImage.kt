package com.neome.feature.form.presentation.components.field

import android.net.Uri
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.runtime.Stable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import com.neome.api.meta.base.dto.DefnFieldImage
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueImageData
import com.neome.feature.filepicker.domain.model.FilePickerMode
import com.neome.feature.filepicker.domain.model.FilePickerResult
import com.neome.feature.filepicker.presentation.rememberFilePicker
import com.neome.feature.form.presentation.components.base.FieldBase
import com.neome.feature.form.presentation.components.base.rememberFieldController
import com.neome.feature.form.presentation.state.FieldEvent

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

    // Extract max file size from field definition
    val maxSizeBytes = extractMaxSizeBytes(defnComp)

    // State holder for image field logic
    val imageState = rememberFieldImageState(
        initialFileName = fieldValue?.value?.fileName,
        maxSizeBytes = maxSizeBytes,
        onValueChange = { fieldController.onChange(null) },
        onClear = { fieldController.onChange(null) }
    )

    // File picker integration
    val launchFilePicker = rememberFilePicker(
        mode = FilePickerMode.IMAGE,
        onResult = { result -> imageState.handleFilePickerResult(result) }
    )

    // Derived state for UI logic
    val isInteractive = !properties.disabled && !properties.readOnly
    val hasImage by remember { derivedStateOf { imageState.displayFileName.isNotBlank() } }

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

    // UI
    FieldBase(modifier = modifier) {
        ImageTextField(
            displayFileName = imageState.displayFileName,
            label = properties.label,
            placeholder = properties.placeholder,
            helperText = properties.helperText,
            errorMessage = error?.message ?: imageState.validationError,
            isDisabled = properties.disabled,
            isInteractive = isInteractive,
            hasImage = hasImage,
            interactionSource = interactionSource,
            onPreviewClick = { imageState.showPreviewDialog = true },
            onClearClick = { imageState.clear() }
        )
    }

    // Preview dialog
    if (imageState.showPreviewDialog && imageState.selectedUri != null) {
        ImagePreviewDialog(
            uri = imageState.selectedUri!!,
            fileName = imageState.displayFileName,
            onDismiss = { imageState.showPreviewDialog = false }
        )
    }
}

// ============================================================================
// State Holder
// ============================================================================

/**
 * State holder for FieldImage component.
 *
 * Encapsulates all mutable state and business logic for the image field,
 * making the component easier to test and reason about.
 */
@Stable
class FieldImageState(
    initialFileName: String?,
    private val maxSizeBytes: Long?,
    private val onValueChange: () -> Unit,
    private val onClear: () -> Unit
) {
    var displayFileName by mutableStateOf(initialFileName ?: "")
        private set

    var selectedUri by mutableStateOf<Uri?>(null)
        private set

    var showPreviewDialog by mutableStateOf(false)

    var validationError by mutableStateOf<String?>(null)
        private set

    /**
     * Handles the result from the file picker.
     * Validates file size and updates state accordingly.
     */
    fun handleFilePickerResult(result: FilePickerResult?) {
        if (result == null) return

        val sizeValidationError = validateFileSize(result.fileSize, maxSizeBytes)

        if (sizeValidationError != null) {
            validationError = sizeValidationError
            return
        }

        validationError = null
        displayFileName = result.fileName
        selectedUri = result.uri
        onValueChange()
    }

    /**
     * Clears the current image selection.
     */
    fun clear() {
        displayFileName = ""
        selectedUri = null
        validationError = null
        onClear()
    }
}

/**
 * Creates and remembers a [FieldImageState] instance.
 */
@Composable
private fun rememberFieldImageState(
    initialFileName: String?,
    maxSizeBytes: Long?,
    onValueChange: () -> Unit,
    onClear: () -> Unit
): FieldImageState {
    return remember(initialFileName) {
        FieldImageState(
            initialFileName = initialFileName,
            maxSizeBytes = maxSizeBytes,
            onValueChange = onValueChange,
            onClear = onClear
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
