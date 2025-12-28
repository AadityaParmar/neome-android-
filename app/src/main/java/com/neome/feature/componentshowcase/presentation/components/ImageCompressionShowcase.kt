package com.neome.feature.componentshowcase.presentation.components

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Compress
import androidx.compose.material.icons.filled.Image
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.neome.feature.filepicker.domain.model.FilePickerMode
import com.neome.feature.filepicker.domain.model.FilePickerResult
import com.neome.feature.filepicker.presentation.rememberFilePicker
import com.neome.feature.utils.CompressionOutcome
import com.neome.feature.utils.CompressionResult
import com.neome.feature.utils.ImageCompressor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Image Compression showcase demonstrating the native compression utility.
 *
 * Architecture justification:
 * - Uses stateless helper (ImageCompressor) instead of ViewModel because:
 *   1. Compression is a single synchronous operation
 *   2. No complex state management or lifecycle concerns
 *   3. No side effects beyond compression (no network, no persistence)
 *   4. Consistent with FilePickerShowcase and MediaShowcase patterns
 */
@Composable
fun ImageCompressionShowcase() {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    // State
    var pickedImage by remember { mutableStateOf<FilePickerResult?>(null) }
    var originalBitmap by remember { mutableStateOf<Bitmap?>(null) }
    var originalSize by remember { mutableStateOf(0L) }
    // UI state: String for TextField (allows empty/partial input)
    var qualityText by remember { mutableStateOf("75") }
    // Derived business state: parsed Int, defaults to 0 if empty/invalid
    val compressionPercentage = qualityText.toIntOrNull()?.coerceIn(0, 100) ?: 0
    val isQualityValid = qualityText.isEmpty() || (qualityText.toIntOrNull()?.let { it in 0..100 } == true)
    var compressionResult by remember { mutableStateOf<CompressionResult?>(null) }
    var compressedBitmap by remember { mutableStateOf<Bitmap?>(null) }
    var errorMessage by remember { mutableStateOf<String?>(null) }
    var isCompressing by remember { mutableStateOf(false) }

    // File picker
    val pickImage = rememberFilePicker(mode = FilePickerMode.IMAGE) { result ->
        if (result != null) {
            pickedImage = result
            originalSize = result.fileSize
            // Load original bitmap
            scope.launch {
                originalBitmap = loadBitmapFromUri(context, result)
            }
            // Reset compression results
            compressionResult = null
            compressedBitmap = null
            errorMessage = null
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Image Compression",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = "Compress images using native Android SDK. No external libraries used.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Image Picker Card
        ImagePickerCard(
            pickedImage = pickedImage,
            onPickClick = pickImage,
            onClear = {
                pickedImage = null
                originalBitmap = null
                originalSize = 0L
                compressionResult = null
                compressedBitmap = null
                errorMessage = null
            }
        )

        // Compression Controls (only show when image is picked)
        if (pickedImage != null) {
            CompressionControlsCard(
                qualityText = qualityText,
                onQualityTextChange = { newValue ->
                    // Only allow digits, let user type freely
                    qualityText = newValue.filter { it.isDigit() }
                    errorMessage = null
                },
                isQualityValid = isQualityValid,
                isCompressing = isCompressing,
                onCompress = {
                    val currentBitmap = originalBitmap
                    if (currentBitmap != null && !currentBitmap.isRecycled) {
                        isCompressing = true
                        errorMessage = null
                        scope.launch {
                            val outcome = withContext(Dispatchers.Default) {
                                ImageCompressor.compress(currentBitmap, compressionPercentage)
                            }
                            when (outcome) {
                                is CompressionOutcome.Success -> {
                                    compressionResult = outcome.result.copy(
                                        originalSize = originalSize
                                    )
                                    compressedBitmap = withContext(Dispatchers.Default) {
                                        BitmapFactory.decodeByteArray(
                                            outcome.result.bytes,
                                            0,
                                            outcome.result.bytes.size
                                        )
                                    }
                                    errorMessage = null
                                }
                                is CompressionOutcome.Error -> {
                                    errorMessage = outcome.message
                                    compressionResult = null
                                    compressedBitmap = null
                                }
                            }
                            isCompressing = false
                        }
                    } else {
                        errorMessage = "Image not loaded. Please pick an image first."
                    }
                }
            )
        }

        // Error display
        errorMessage?.let { error ->
            ErrorCard(message = error)
        }

        // Preview Cards (only show when we have images)
        if (originalBitmap != null || compressedBitmap != null) {
            ImagePreviewSection(
                originalBitmap = originalBitmap,
                originalSize = originalSize,
                compressedBitmap = compressedBitmap,
                compressionResult = compressionResult
            )
        }
    }
}

@Composable
private fun ImagePickerCard(
    pickedImage: FilePickerResult?,
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
                        imageVector = Icons.Default.Image,
                        contentDescription = null,
                        modifier = Modifier.size(32.dp),
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Column {
                        Text(
                            text = "Source Image",
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            text = if (pickedImage != null) pickedImage.fileName else "No image selected",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }

                if (pickedImage != null) {
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
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    imageVector = Icons.Default.Image,
                    contentDescription = null,
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.size(8.dp))
                Text(if (pickedImage == null) "Pick Image" else "Change Image")
            }

            if (pickedImage != null) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Size: ${formatFileSize(pickedImage.fileSize)} | Type: ${pickedImage.mimeType}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@Composable
private fun CompressionControlsCard(
    qualityText: String,
    onQualityTextChange: (String) -> Unit,
    isQualityValid: Boolean,
    isCompressing: Boolean,
    onCompress: () -> Unit
) {
    // Derive if we can compress: non-empty, valid range
    val canCompress = qualityText.isNotEmpty() &&
            qualityText.toIntOrNull()?.let { it in 0..100 } == true

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
                    imageVector = Icons.Default.Compress,
                    contentDescription = null,
                    modifier = Modifier.size(32.dp),
                    tint = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = "Compression Settings",
                    style = MaterialTheme.typography.titleMedium
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = qualityText,
                onValueChange = onQualityTextChange,
                label = { Text("Quality %") },
                supportingText = {
                    Text("0 = max compression, 100 = best quality")
                },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                isError = !isQualityValid
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = onCompress,
                modifier = Modifier.fillMaxWidth(),
                enabled = !isCompressing && canCompress
            ) {
                if (isCompressing) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(18.dp),
                        strokeWidth = 2.dp,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                    Spacer(modifier = Modifier.size(8.dp))
                    Text("Compressing...")
                } else {
                    Icon(
                        imageVector = Icons.Default.Compress,
                        contentDescription = null,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.size(8.dp))
                    Text("Compress Image")
                }
            }
        }
    }
}

@Composable
private fun ImagePreviewSection(
    originalBitmap: Bitmap?,
    originalSize: Long,
    compressedBitmap: Bitmap?,
    compressionResult: CompressionResult?
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Preview",
            style = MaterialTheme.typography.titleLarge
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Original Image Preview
            ImagePreviewCard(
                title = "Original",
                bitmap = originalBitmap,
                sizeBytes = originalSize,
                modifier = Modifier.weight(1f)
            )

            // Compressed Image Preview
            ImagePreviewCard(
                title = "Compressed",
                bitmap = compressedBitmap,
                sizeBytes = compressionResult?.compressedSize ?: 0L,
                modifier = Modifier.weight(1f)
            )
        }

        // Compression Stats
        compressionResult?.let { result ->
            CompressionStatsCard(result = result)
        }
    }
}

@Composable
private fun ImagePreviewCard(
    title: String,
    bitmap: Bitmap?,
    sizeBytes: Long,
    modifier: Modifier = Modifier
) {
    ElevatedCard(
        modifier = modifier,
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(8.dp))

            if (bitmap != null && !bitmap.isRecycled) {
                Image(
                    bitmap = bitmap.asImageBitmap(),
                    contentDescription = "$title image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f)
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "${bitmap.width} x ${bitmap.height}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            } else {
                ElevatedCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f),
                    colors = CardDefaults.elevatedCardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant
                    )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(1f),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Image,
                            contentDescription = null,
                            modifier = Modifier.size(32.dp),
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "No image",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }

            if (sizeBytes > 0) {
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = formatFileSize(sizeBytes),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@Composable
private fun CompressionStatsCard(result: CompressionResult) {
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
                text = "Compression Results",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                StatItem(
                    label = "Original",
                    value = formatFileSize(result.originalSize)
                )
                StatItem(
                    label = "Compressed",
                    value = formatFileSize(result.compressedSize)
                )
                StatItem(
                    label = "Saved",
                    value = "${result.savedPercentage.toInt()}%"
                )
            }
        }
    }
}

@Composable
private fun StatItem(
    label: String,
    value: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = value,
            style = MaterialTheme.typography.titleMedium,
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
private fun ErrorCard(message: String) {
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

private suspend fun loadBitmapFromUri(
    context: Context,
    result: FilePickerResult
): Bitmap? {
    return withContext(Dispatchers.IO) {
        try {
            context.contentResolver.openInputStream(result.uri)?.use { inputStream ->
                BitmapFactory.decodeStream(inputStream)
            }
        } catch (e: Exception) {
            null
        }
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
