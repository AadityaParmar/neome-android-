package com.neome.feature.filepicker.presentation

import android.content.Context
import android.net.Uri
import android.provider.OpenableColumns
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.neome.feature.filepicker.domain.model.FilePickerMode
import com.neome.feature.filepicker.domain.model.FilePickerResult

@Composable
fun rememberFilePicker(
    mode: FilePickerMode,
    onResult: (FilePickerResult?) -> Unit
): () -> Unit {
    val context = LocalContext.current

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        if (uri != null) {
            val result = extractFileMetadata(context, uri)
            onResult(result)
        } else {
            onResult(null)
        }
    }

    return remember(mode) {
        { launcher.launch(mode.mimeType) }
    }
}

@Composable
fun rememberMultiTypePicker(
    mimeTypes: Array<String>,
    onResult: (FilePickerResult?) -> Unit
): () -> Unit {
    val context = LocalContext.current

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.OpenDocument()
    ) { uri: Uri? ->
        if (uri != null) {
            val result = extractFileMetadata(context, uri)
            onResult(result)
        } else {
            onResult(null)
        }
    }

    return remember(mimeTypes.contentHashCode()) {
        { launcher.launch(mimeTypes) }
    }
}

@Composable
fun rememberMultiFilePicker(
    mode: FilePickerMode,
    onResult: (List<FilePickerResult>) -> Unit
): () -> Unit {
    val context = LocalContext.current

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetMultipleContents()
    ) { uris: List<Uri> ->
        if (uris.isNotEmpty()) {
            val results = uris.mapNotNull { uri ->
                extractFileMetadata(context, uri)
            }
            onResult(results)
        } else {
            onResult(emptyList())
        }
    }

    return remember(mode) {
        { launcher.launch(mode.mimeType) }
    }
}

@Composable
fun rememberMultiFileMultiTypePicker(
    mimeTypes: Array<String>,
    onResult: (List<FilePickerResult>) -> Unit
): () -> Unit {
    val context = LocalContext.current

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.OpenMultipleDocuments()
    ) { uris: List<Uri> ->
        if (uris.isNotEmpty()) {
            val results = uris.mapNotNull { uri ->
                extractFileMetadata(context, uri)
            }
            onResult(results)
        } else {
            onResult(emptyList())
        }
    }

    return remember(mimeTypes.contentHashCode()) {
        { launcher.launch(mimeTypes) }
    }
}

private fun extractFileMetadata(context: Context, uri: Uri): FilePickerResult? {
    return try {
        context.contentResolver.query(uri, null, null, null, null)?.use { cursor ->
            if (cursor.moveToFirst()) {
                val nameIndex = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)
                val sizeIndex = cursor.getColumnIndex(OpenableColumns.SIZE)

                val fileName = if (nameIndex >= 0) {
                    cursor.getString(nameIndex) ?: "Unknown"
                } else {
                    "Unknown"
                }

                val fileSize = if (sizeIndex >= 0) {
                    cursor.getLong(sizeIndex)
                } else {
                    0L
                }

                val mimeType = context.contentResolver.getType(uri) ?: "application/octet-stream"

                FilePickerResult(
                    fileName = fileName,
                    fileSize = fileSize,
                    mimeType = mimeType,
                    uri = uri
                )
            } else {
                null
            }
        }
    } catch (e: Exception) {
        null
    }
}
