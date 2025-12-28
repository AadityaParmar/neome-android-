package com.neome.feature.componentshowcase.presentation.components

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.VideoLibrary
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.neome.feature.filepicker.domain.model.FilePickerMode
import com.neome.feature.filepicker.domain.model.FilePickerResult
import com.neome.feature.filepicker.presentation.rememberFilePicker
import com.neome.feature.utils.ThumbnailOutcome
import com.neome.feature.utils.ThumbnailResult
import com.neome.feature.utils.VideoThumbnailExtractor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Thumbnail Picker showcase demonstrating native video thumbnail extraction.
 *
 * Architecture justification:
 * - Uses stateless helper (VideoThumbnailExtractor) instead of ViewModel because:
 *   1. Thumbnail extraction is a single synchronous operation
 *   2. No complex state management or lifecycle concerns
 *   3. No side effects beyond extraction (no network, no persistence)
 *   4. Consistent with ImageCompressionShowcase pattern
 */
@Composable
fun ThumbnailPickerShowcase() {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    // State
    var pickedVideo by remember { mutableStateOf<FilePickerResult?>(null) }
    var thumbnailResult by remember { mutableStateOf<ThumbnailResult?>(null) }
    var errorMessage by remember { mutableStateOf<String?>(null) }
    var isExtracting by remember { mutableStateOf(false) }

    // File picker for videos
    val pickVideo = rememberFilePicker(mode = FilePickerMode.VIDEO) { result ->
        if (result != null) {
            pickedVideo = result
            thumbnailResult = null
            errorMessage = null

            // Extract thumbnail immediately after picking
            isExtracting = true
            scope.launch {
                val outcome = withContext(Dispatchers.IO) {
                    VideoThumbnailExtractor.extractThumbnail(
                        contentResolver = context.contentResolver,
                        videoUri = result.uri
                    )
                }
                when (outcome) {
                    is ThumbnailOutcome.Success -> {
                        thumbnailResult = outcome.result
                        errorMessage = null
                    }
                    is ThumbnailOutcome.Error -> {
                        errorMessage = outcome.message
                        thumbnailResult = null
                    }
                }
                isExtracting = false
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Video Thumbnail Picker",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = "Extract the first frame of a video using native Android SDK. No external libraries used.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Video Picker Card
        VideoPickerCard(
            pickedVideo = pickedVideo,
            isExtracting = isExtracting,
            onPickClick = pickVideo,
            onClear = {
                pickedVideo = null
                thumbnailResult = null
                errorMessage = null
            }
        )

        // Error display
        errorMessage?.let { error ->
            ThumbnailErrorCard(message = error)
        }

        // Thumbnail Preview
        thumbnailResult?.let { result ->
            ThumbnailPreviewCard(
                result = result,
                videoFileName = pickedVideo?.fileName ?: "Unknown"
            )
        }
    }
}

@Composable
private fun VideoPickerCard(
    pickedVideo: FilePickerResult?,
    isExtracting: Boolean,
    onPickClick: () -> Unit,
    onClear: () -> Unit
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
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.VideoLibrary,
                        contentDescription = null,
                        modifier = Modifier.size(32.dp),
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Column {
                        Text(
                            text = "Source Video",
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            text = if (pickedVideo != null) pickedVideo.fileName else "No video selected",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }

                if (pickedVideo != null && !isExtracting) {
                    IconButton(onClick = onClear) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Clear"
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = onPickClick,
                modifier = Modifier.fillMaxWidth(),
                enabled = !isExtracting
            ) {
                if (isExtracting) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(18.dp),
                        strokeWidth = 2.dp,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                    Spacer(modifier = Modifier.size(8.dp))
                    Text("Extracting...")
                } else {
                    Icon(
                        imageVector = Icons.Default.VideoLibrary,
                        contentDescription = null,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.size(8.dp))
                    Text(if (pickedVideo == null) "Pick Video" else "Change Video")
                }
            }

            if (pickedVideo != null) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Size: ${formatFileSize(pickedVideo.fileSize)} | Type: ${pickedVideo.mimeType}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@Composable
private fun ThumbnailPreviewCard(
    result: ThumbnailResult,
    videoFileName: String
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
                    imageVector = Icons.Default.Image,
                    contentDescription = null,
                    modifier = Modifier.size(32.dp),
                    tint = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = "Extracted Thumbnail",
                    style = MaterialTheme.typography.titleMedium
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Thumbnail image
            if (!result.bitmap.isRecycled) {
                Image(
                    bitmap = result.bitmap.asImageBitmap(),
                    contentDescription = "Video thumbnail for $videoFileName",
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(16f / 9f)
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Fit
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Thumbnail metadata
            ThumbnailMetadataCard(result = result)
        }
    }
}

@Composable
private fun ThumbnailMetadataCard(result: ThumbnailResult) {
    ElevatedCard(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.elevatedCardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "Thumbnail Details",
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ThumbnailStatItem(
                    label = "Dimensions",
                    value = "${result.width} x ${result.height}"
                )
                ThumbnailStatItem(
                    label = "Frame",
                    value = "First (0ms)"
                )
                result.videoDurationMs?.let { durationMs ->
                    ThumbnailStatItem(
                        label = "Video Duration",
                        value = formatDuration(durationMs)
                    )
                }
            }
        }
    }
}

@Composable
private fun ThumbnailStatItem(
    label: String,
    value: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = value,
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.onPrimaryContainer
        )
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.7f)
        )
    }
}

@Composable
private fun ThumbnailErrorCard(message: String) {
    ElevatedCard(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.elevatedCardColors(
            containerColor = MaterialTheme.colorScheme.errorContainer
        )
    ) {
        Text(
            text = message,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onErrorContainer,
            modifier = Modifier.padding(16.dp)
        )
    }
}

private fun formatFileSize(bytes: Long): String {
    return when {
        bytes < 1024 -> "$bytes B"
        bytes < 1024 * 1024 -> String.format("%.1f KB", bytes / 1024.0)
        bytes < 1024 * 1024 * 1024 -> String.format("%.2f MB", bytes / (1024.0 * 1024.0))
        else -> String.format("%.2f GB", bytes / (1024.0 * 1024.0 * 1024.0))
    }
}

private fun formatDuration(durationMs: Long): String {
    val totalSeconds = durationMs / 1000
    val minutes = totalSeconds / 60
    val seconds = totalSeconds % 60
    return if (minutes > 0) {
        "${minutes}m ${seconds}s"
    } else {
        "${seconds}s"
    }
}
