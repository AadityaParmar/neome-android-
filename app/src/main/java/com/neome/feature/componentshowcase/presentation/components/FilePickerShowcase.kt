package com.neome.feature.componentshowcase.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachFile
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.VideoFile
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.neome.feature.filepick.domain.model.FilePickerMode
import com.neome.feature.filepick.domain.model.FilePickerResult
import com.neome.feature.filepick.presentation.rememberFilePicker
import com.neome.feature.filepick.presentation.rememberMultiTypePicker

@Composable
fun FilePickerShowcase() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "File Picker",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = "Select files from device storage using system file pickers.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(8.dp))

        FilePickerCard(
            title = "Pick Image",
            description = "Select a single image file",
            icon = Icons.Default.Image,
            mode = FilePickerMode.IMAGE
        )

        FilePickerCard(
            title = "Pick Video",
            description = "Select a single video file",
            icon = Icons.Default.VideoFile,
            mode = FilePickerMode.VIDEO
        )

        ImageVideoPickerCard()

        FilePickerCard(
            title = "Pick PDF",
            description = "Select a PDF document",
            icon = Icons.Default.Description,
            mode = FilePickerMode.PDF
        )

        FilePickerCard(
            title = "Pick All Files",
            description = "Select any file type",
            icon = Icons.Default.AttachFile,
            mode = FilePickerMode.ALL
        )
    }
}

@Composable
private fun FilePickerCard(
    title: String,
    description: String,
    icon: ImageVector,
    mode: FilePickerMode
) {
    var result by remember { mutableStateOf<FilePickerResult?>(null) }

    val pickFile = rememberFilePicker(mode = mode) { pickedResult ->
        result = pickedResult
    }

    FilePickerCardContent(
        title = title,
        description = description,
        icon = icon,
        result = result,
        onPickClick = pickFile
    )
}

@Composable
private fun ImageVideoPickerCard() {
    var result by remember { mutableStateOf<FilePickerResult?>(null) }

    val pickFile = rememberMultiTypePicker(
        mimeTypes = arrayOf("image/*", "video/*")
    ) { pickedResult ->
        result = pickedResult
    }

    FilePickerCardContent(
        title = "Pick Image + Video",
        description = "Select an image or video file",
        icon = Icons.Default.Image,
        result = result,
        onPickClick = pickFile
    )
}

@Composable
private fun FilePickerCardContent(
    title: String,
    description: String,
    icon: ImageVector,
    result: FilePickerResult?,
    onPickClick: () -> Unit
) {
    ElevatedCard(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    modifier = Modifier.size(32.dp),
                    tint = MaterialTheme.colorScheme.primary
                )
                Column {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = description,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = onPickClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.size(8.dp))
                Text("Select File")
            }

            if (result != null) {
                Spacer(modifier = Modifier.height(12.dp))
                FileMetadataDisplay(result = result)
            }
        }
    }
}

@Composable
private fun FileMetadataDisplay(result: FilePickerResult) {
    ElevatedCard(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.elevatedCardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = "Selected File",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.primary
            )

            MetadataRow(label = "Name", value = result.fileName)
            MetadataRow(label = "Size", value = formatFileSize(result.fileSize))
            MetadataRow(label = "Type", value = result.mimeType)
            MetadataRow(label = "URI", value = result.uri.toString(), maxLines = 2)
        }
    }
}

@Composable
private fun MetadataRow(
    label: String,
    value: String,
    maxLines: Int = 1
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "$label:",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodySmall,
            maxLines = maxLines
        )
    }
}

private fun formatFileSize(bytes: Long): String {
    return when {
        bytes < 1024 -> "$bytes B"
        bytes < 1024 * 1024 -> "${bytes / 1024} KB"
        bytes < 1024 * 1024 * 1024 -> "${bytes / (1024 * 1024)} MB"
        else -> "${bytes / (1024 * 1024 * 1024)} GB"
    }
}
