package com.neome.feature.form.presentation.components.field

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Description
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
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

import com.neome.api.meta.base.Types.EnumDefnDocFileExt
import com.neome.api.meta.base.dto.DefnFieldDocument
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueDocumentData
import com.neome.feature.filepicker.domain.model.FilePickerResult
import com.neome.feature.filepicker.presentation.rememberMultiTypePicker
import com.neome.feature.form.presentation.components.base.FieldBase
import com.neome.feature.form.presentation.components.base.rememberFieldController
import com.neome.feature.form.presentation.state.FieldEvent

// ============================================================================
// Constants
// ============================================================================

private const val BYTES_PER_MEGABYTE = 1024 * 1024L
private const val BYTES_PER_KILOBYTE = 1024L

// ============================================================================
// Supported File Types
// ============================================================================

/**
 * Mapping of file extensions to their MIME types.
 * Used to construct the file picker filter.
 */
private val FILE_EXTENSION_TO_MIME_TYPE: Map<EnumDefnDocFileExt, String> = mapOf(
    EnumDefnDocFileExt.ai to "application/postscript",
    EnumDefnDocFileExt.any to "*/*",
    EnumDefnDocFileExt.avi to "video/x-msvideo",
    EnumDefnDocFileExt.cdr to "application/cdr",
    EnumDefnDocFileExt.csv to "text/csv",
    EnumDefnDocFileExt.dll to "application/x-msdownload",
    EnumDefnDocFileExt.doc to "application/msword",
    EnumDefnDocFileExt.docx to "application/vnd.openxmlformats-officedocument.wordprocessingml.document",
    EnumDefnDocFileExt.drawio to "application/xml",
    EnumDefnDocFileExt.dwg to "application/acad",
    EnumDefnDocFileExt.eml to "message/rfc822",
    EnumDefnDocFileExt.gif to "image/gif",
    EnumDefnDocFileExt.jar to "application/java-archive",
    EnumDefnDocFileExt.jpeg to "image/jpeg",
    EnumDefnDocFileExt.jpg to "image/jpeg",
    EnumDefnDocFileExt.json to "application/json",
    EnumDefnDocFileExt.mov to "video/quicktime",
    EnumDefnDocFileExt.mp3 to "audio/mpeg",
    EnumDefnDocFileExt.mp4 to "video/mp4",
    EnumDefnDocFileExt.msg to "application/vnd.ms-outlook",
    EnumDefnDocFileExt.oga to "audio/ogg",
    EnumDefnDocFileExt.ogg to "audio/ogg",
    EnumDefnDocFileExt.pdf to "application/pdf",
    EnumDefnDocFileExt.png to "image/png",
    EnumDefnDocFileExt.ppt to "application/vnd.ms-powerpoint",
    EnumDefnDocFileExt.pptx to "application/vnd.openxmlformats-officedocument.presentationml.presentation",
    EnumDefnDocFileExt.rvt to "application/octet-stream",
    EnumDefnDocFileExt.std to "application/octet-stream",
    EnumDefnDocFileExt.svg to "image/svg+xml",
    EnumDefnDocFileExt.tiff to "image/tiff",
    EnumDefnDocFileExt.txt to "text/plain",
    EnumDefnDocFileExt.wav to "audio/wav",
    EnumDefnDocFileExt.webm to "video/webm",
    EnumDefnDocFileExt.xls to "application/vnd.ms-excel",
    EnumDefnDocFileExt.xlsx to "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
    EnumDefnDocFileExt.xml to "application/xml",
    EnumDefnDocFileExt.zip to "application/zip"
)

/**
 * File extensions that support in-app or system preview.
 */
private val PREVIEWABLE_EXTENSIONS: Set<EnumDefnDocFileExt> = setOf(
    EnumDefnDocFileExt.pdf,
    EnumDefnDocFileExt.jpg,
    EnumDefnDocFileExt.jpeg,
    EnumDefnDocFileExt.png,
    EnumDefnDocFileExt.gif,
    EnumDefnDocFileExt.svg,
    EnumDefnDocFileExt.tiff,
    EnumDefnDocFileExt.txt,
    EnumDefnDocFileExt.mp4,
    EnumDefnDocFileExt.mov,
    EnumDefnDocFileExt.avi,
    EnumDefnDocFileExt.webm,
    EnumDefnDocFileExt.mp3,
    EnumDefnDocFileExt.wav,
    EnumDefnDocFileExt.ogg,
    EnumDefnDocFileExt.oga
)

// ============================================================================
// Main Component
// ============================================================================

/**
 * Document field component for form.
 *
 * FormCtx is accessed via LocalFormCtx.current inside rememberFieldController, so this composable
 * must be called inside a Form composable tree.
 *
 * A specialized field that allows users to select document files from their device.
 * Behaves exactly like the Image Field but with document-specific features.
 *
 * Key Features (reused from ImageField):
 * - File selection via system file picker
 * - File name display in a read-only text field
 * - Preview button (Eye icon) to view the selected document
 * - Clear button (Cross icon) to remove the selection
 * - File size validation against optional maxSize property
 * - Support for disabled and read-only states
 *
 * Document-specific Features:
 * - File type filtering based on fileTypeSet property
 * - File size display in helper text area
 * - Support for multiple document formats
 * - System viewer integration for preview
 *
 * Supported Properties:
 * - required
 * - disabled
 * - helperText
 * - fileTypeSet (list of allowed file extensions)
 * - maxSize (maximum file size in MB)
 * - showSize (whether to display file size)
 * - disablePreview (whether to disable preview functionality)
 *
 * @param defnComp Field definition containing field configuration
 * @param onFieldEvent Callback to emit field events to the form
 * @param modifier Modifier for customization
 */
@Composable
fun FieldDocument(
    defnComp: DefnCompSeal,
    onFieldEvent: (FieldEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    // ========== REUSED FROM ImageField: Field Controller Setup ==========
    val fieldController = rememberFieldController<FieldValueDocumentData>(
        defnComp = defnComp,
        onFieldEvent = onFieldEvent
    )

    if (fieldController.fieldId == null) return

    // ========== Collect reactive field value separately for finer-grained recomposition ==========
    val fieldValue = fieldController.value.value

    // ========== Collect reactive field properties and error ==========
    val (properties, error) = fieldController.field.value

    if (properties.hidden) return

    // ========== Document-specific: Extract Field Definition ==========
    val defnFieldDocument = defnComp as? DefnFieldDocument
    val maxSizeBytes = extractDocumentMaxSizeBytes(defnFieldDocument)
    val allowedFileTypes = extractAllowedFileTypes(defnFieldDocument)
    val showFileSize = defnFieldDocument?.showSize != false
    val disablePreview = defnFieldDocument?.disablePreview == true

    // ========== Document-specific: Build MIME Types Array ==========
    val mimeTypes = remember(allowedFileTypes) {
        buildMimeTypesArray(allowedFileTypes)
    }

    // ========== REUSED FROM ImageField: State Holder ==========
    val documentState = rememberFieldDocumentState(
        initialFileName = fieldValue?.value?.fileName,
        initialFileSize = fieldValue?.value?.fileSize,
        maxSizeBytes = maxSizeBytes,
        allowedFileTypes = allowedFileTypes,
        onValueChange = { fieldController.onChange(null) },
        onClear = { fieldController.onChange(null) }
    )

    // ========== Document-specific: File Picker with MIME Types ==========
    val launchFilePicker = rememberMultiTypePicker(
        mimeTypes = mimeTypes,
        onResult = { result -> documentState.handleFilePickerResult(result) }
    )

    // ========== REUSED FROM ImageField: Derived State ==========
    val isInteractive = !properties.disabled && !properties.readOnly
    val hasDocument by remember { derivedStateOf { documentState.displayFileName.isNotBlank() } }
    val canPreview = hasDocument && !disablePreview && documentState.isPreviewSupported

    // ========== REUSED FROM ImageField: Interaction Source ==========
    val interactionSource = remember { MutableInteractionSource() }

    // ========== REUSED FROM ImageField: Text Field Click Handling ==========
    LaunchedEffect(interactionSource, isInteractive) {
        if (isInteractive) {
            interactionSource.interactions.collect { interaction ->
                if (interaction is PressInteraction.Release) {
                    launchFilePicker()
                }
            }
        }
    }

    // ========== Document-specific: Context for Preview ==========
    val context = LocalContext.current

    // ========== REUSED FROM ImageField: UI ==========
    FieldBase(modifier = modifier) {
        DocumentTextField(
            displayFileName = documentState.displayFileName,
            fileSize = if (showFileSize) documentState.fileSizeBytes else null,
            label = properties.label,
            placeholder = properties.placeholder,
            helperText = properties.helperText,
            errorMessage = error?.message ?: documentState.validationError,
            isDisabled = properties.disabled,
            isInteractive = isInteractive,
            hasDocument = hasDocument,
            canPreview = canPreview,
            interactionSource = interactionSource,
            onPreviewClick = {
                documentState.selectedUri?.let { uri ->
                    openDocumentPreview(context, uri, documentState.mimeType)
                }
            },
            onClearClick = { documentState.clear() }
        )
    }
}

// ============================================================================
// State Holder
// ============================================================================

/**
 * State holder for FieldDocument component.
 *
 * Encapsulates all mutable state and business logic for the document field.
 * Follows the same pattern as FieldImageState.
 */
@Stable
class FieldDocumentState(
    initialFileName: String?,
    initialFileSize: Long?,
    private val maxSizeBytes: Long?,
    private val allowedFileTypes: List<EnumDefnDocFileExt>,
    private val onValueChange: () -> Unit,
    private val onClear: () -> Unit
) {
    var displayFileName by mutableStateOf(initialFileName ?: "")
        private set

    var fileSizeBytes by mutableLongStateOf(initialFileSize ?: 0L)
        private set

    var selectedUri by mutableStateOf<Uri?>(null)
        private set

    var mimeType by mutableStateOf<String?>(null)
        private set

    var validationError by mutableStateOf<String?>(null)
        private set

    val isPreviewSupported: Boolean
        get() {
            val extension = getFileExtension(displayFileName)
            return extension != null && extension in PREVIEWABLE_EXTENSIONS
        }

    /**
     * Handles the result from the file picker.
     * Validates file size and type, then updates state accordingly.
     */
    fun handleFilePickerResult(result: FilePickerResult?) {
        if (result == null) return

        // Validate file size
        val sizeValidationError = validateDocumentFileSize(result.fileSize, maxSizeBytes)
        if (sizeValidationError != null) {
            validationError = sizeValidationError
            return
        }

        // Validate file type if restrictions are specified
        val typeValidationError = validateFileType(result.fileName, allowedFileTypes)
        if (typeValidationError != null) {
            validationError = typeValidationError
            return
        }

        validationError = null
        displayFileName = result.fileName
        fileSizeBytes = result.fileSize
        selectedUri = result.uri
        mimeType = result.mimeType
        onValueChange()
    }

    /**
     * Clears the current document selection.
     */
    fun clear() {
        displayFileName = ""
        fileSizeBytes = 0L
        selectedUri = null
        mimeType = null
        validationError = null
        onClear()
    }
}

/**
 * Creates and remembers a [FieldDocumentState] instance.
 */
@Composable
private fun rememberFieldDocumentState(
    initialFileName: String?,
    initialFileSize: Long?,
    maxSizeBytes: Long?,
    allowedFileTypes: List<EnumDefnDocFileExt>,
    onValueChange: () -> Unit,
    onClear: () -> Unit
): FieldDocumentState {
    return remember(initialFileName, initialFileSize) {
        FieldDocumentState(
            initialFileName = initialFileName,
            initialFileSize = initialFileSize,
            maxSizeBytes = maxSizeBytes,
            allowedFileTypes = allowedFileTypes,
            onValueChange = onValueChange,
            onClear = onClear
        )
    }
}

// ============================================================================
// UI Components
// ============================================================================

/**
 * The main text field for displaying the selected document file name.
 * Follows the same structure as ImageTextField.
 */
@Composable
private fun DocumentTextField(
    displayFileName: String,
    fileSize: Long?,
    label: String?,
    placeholder: String?,
    helperText: String?,
    errorMessage: String?,
    isDisabled: Boolean,
    isInteractive: Boolean,
    hasDocument: Boolean,
    canPreview: Boolean,
    interactionSource: MutableInteractionSource,
    onPreviewClick: () -> Unit,
    onClearClick: () -> Unit
) {
    OutlinedTextField(
        value = displayFileName,
        onValueChange = { /* Read-only, no manual text input */ },
        label = label?.let { { Text(it) } },
        placeholder = { Text(placeholder ?: "Select a document") },
        supportingText = if (errorMessage != null || helperText != null || (fileSize != null && fileSize > 0)) ({
            DocumentSupportingText(
                errorMessage = errorMessage,
                helperText = helperText,
                fileSize = fileSize
            )
        }) else null,
        isError = errorMessage != null,
        enabled = !isDisabled,
        readOnly = true,
        modifier = Modifier.fillMaxWidth(),
        interactionSource = interactionSource,
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Description,
                contentDescription = "Document field"
            )
        },
        trailingIcon = {
            DocumentTrailingIcons(
                isInteractive = isInteractive,
                hasDocument = hasDocument,
                canPreview = canPreview,
                onPreviewClick = onPreviewClick,
                onClearClick = onClearClick
            )
        }
    )
}

/**
 * Trailing icons for preview and clear actions.
 * Follows the same structure as ImageField's TrailingIcons.
 */
@Composable
private fun DocumentTrailingIcons(
    isInteractive: Boolean,
    hasDocument: Boolean,
    canPreview: Boolean,
    onPreviewClick: () -> Unit,
    onClearClick: () -> Unit
) {
    Row {
        // Preview button - enabled only when a document is selected and preview is supported
        IconButton(
            onClick = onPreviewClick,
            enabled = isInteractive && canPreview
        ) {
            Icon(
                imageVector = Icons.Default.Visibility,
                contentDescription = "Preview document",
                tint = documentIconTint(
                    isEnabled = isInteractive && canPreview,
                    enabledColor = MaterialTheme.colorScheme.primary
                )
            )
        }

        // Clear button - enabled only when a document is selected and field is interactive
        IconButton(
            onClick = onClearClick,
            enabled = isInteractive && hasDocument
        ) {
            Icon(
                imageVector = Icons.Default.Clear,
                contentDescription = "Clear document",
                tint = documentIconTint(
                    isEnabled = isInteractive && hasDocument,
                    enabledColor = MaterialTheme.colorScheme.onSurface
                )
            )
        }
    }
}

/**
 * Supporting text that shows error message, helper text, and/or file size.
 */
@Composable
private fun DocumentSupportingText(
    errorMessage: String?,
    helperText: String?,
    fileSize: Long?
) {
    when {
        errorMessage != null -> {
            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.error
            )
        }
        else -> {
            Column {
                if (helperText != null) {
                    Text(text = helperText)
                }
                if (fileSize != null && fileSize > 0) {
                    Text(
                        text = "Size: ${formatFileSize(fileSize)}",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}

// ============================================================================
// Utility Functions
// ============================================================================

/**
 * Extracts the maximum file size in bytes from the field definition.
 *
 * @param defnField The document field definition
 * @return Max size in bytes, or null if not specified
 */
private fun extractDocumentMaxSizeBytes(defnField: DefnFieldDocument?): Long? {
    return defnField?.maxSize?.let { maxSizeMB ->
        maxSizeMB * BYTES_PER_MEGABYTE
    }
}

/**
 * Extracts allowed file types from the field definition.
 *
 * @param defnField The document field definition
 * @return List of allowed file extensions, or empty list for "any"
 */
private fun extractAllowedFileTypes(defnField: DefnFieldDocument?): List<EnumDefnDocFileExt> {
    val fileTypeSet = defnField?.fileTypeSet
    if (fileTypeSet.isNullOrEmpty()) return listOf(EnumDefnDocFileExt.any)
    if (fileTypeSet.contains(EnumDefnDocFileExt.any)) return listOf(EnumDefnDocFileExt.any)
    return fileTypeSet
}

/**
 * Builds the MIME types array for the file picker.
 *
 * When "any" is specified, returns all supported MIME types from the list,
 * not a wildcard. This ensures only the supported file types can be selected.
 *
 * @param allowedTypes List of allowed file extensions
 * @return Array of MIME type strings
 */
private fun buildMimeTypesArray(allowedTypes: List<EnumDefnDocFileExt>): Array<String> {
    if (allowedTypes.contains(EnumDefnDocFileExt.any)) {
        // Return all supported MIME types (excluding the "any" placeholder)
        return FILE_EXTENSION_TO_MIME_TYPE
            .filterKeys { it != EnumDefnDocFileExt.any }
            .values
            .distinct()
            .toTypedArray()
    }

    return allowedTypes.mapNotNull { ext ->
        FILE_EXTENSION_TO_MIME_TYPE[ext]
    }.distinct().toTypedArray()
}

/**
 * Validates the file size against the maximum allowed size.
 *
 * @param fileSize The size of the selected file in bytes
 * @param maxSizeBytes The maximum allowed size in bytes, or null for no limit
 * @return Error message if validation fails, null otherwise
 */
private fun validateDocumentFileSize(fileSize: Long, maxSizeBytes: Long?): String? {
    if (maxSizeBytes == null) return null
    if (fileSize <= maxSizeBytes) return null

    val maxSizeMB = maxSizeBytes / BYTES_PER_MEGABYTE
    return "File size exceeds maximum allowed size of ${maxSizeMB}MB"
}

/**
 * Validates the file type against allowed types.
 *
 * @param fileName The name of the selected file
 * @param allowedTypes List of allowed file extensions
 * @return Error message if validation fails, null otherwise
 */
private fun validateFileType(fileName: String, allowedTypes: List<EnumDefnDocFileExt>): String? {
    if (allowedTypes.contains(EnumDefnDocFileExt.any)) return null

    val extension = getFileExtension(fileName) ?: return "Invalid file type"

    if (extension !in allowedTypes) {
        val allowedList = allowedTypes.joinToString(", ") { it.value.uppercase() }
        return "File type not allowed. Accepted: $allowedList"
    }

    return null
}

/**
 * Extracts the file extension from a file name and maps it to EnumDefnDocFileExt.
 *
 * @param fileName The file name
 * @return The corresponding EnumDefnDocFileExt, or null if not recognized
 */
private fun getFileExtension(fileName: String): EnumDefnDocFileExt? {
    val extension = fileName.substringAfterLast('.', "").lowercase()
    return try {
        EnumDefnDocFileExt.valueOf(extension)
    } catch (e: IllegalArgumentException) {
        null
    }
}

/**
 * Formats file size for display.
 *
 * @param bytes File size in bytes
 * @return Formatted string (e.g., "2.4 MB" or "512 KB")
 */
private fun formatFileSize(bytes: Long): String {
    return when {
        bytes >= BYTES_PER_MEGABYTE -> {
            val mb = bytes.toDouble() / BYTES_PER_MEGABYTE
            String.format("%.1f MB", mb)
        }
        bytes >= BYTES_PER_KILOBYTE -> {
            val kb = bytes.toDouble() / BYTES_PER_KILOBYTE
            String.format("%.1f KB", kb)
        }
        else -> "$bytes bytes"
    }
}

/**
 * Opens the document using the system viewer.
 *
 * @param context Android context
 * @param uri The document URI
 * @param mimeType The MIME type of the document
 */
private fun openDocumentPreview(context: Context, uri: Uri, mimeType: String?) {
    try {
        val intent = Intent(Intent.ACTION_VIEW).apply {
            setDataAndType(uri, mimeType ?: "application/octet-stream")
            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        }
        context.startActivity(intent)
    } catch (e: Exception) {
        // Silently fail if no viewer is available
    }
}

/**
 * Returns the appropriate icon tint color based on enabled state.
 * Follows the same pattern as ImageField's iconTint.
 */
@Composable
private fun documentIconTint(isEnabled: Boolean, enabledColor: Color): Color {
    return if (isEnabled) {
        enabledColor
    } else {
        MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
    }
}
