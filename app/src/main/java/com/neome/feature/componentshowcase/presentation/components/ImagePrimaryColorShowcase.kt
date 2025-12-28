package com.neome.feature.componentshowcase.presentation.components

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.ColorLens
import androidx.compose.material.icons.filled.Image
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.neome.feature.filepicker.domain.model.FilePickerMode
import com.neome.feature.filepicker.domain.model.FilePickerResult
import com.neome.feature.filepicker.presentation.rememberFilePicker
import com.neome.feature.utils.ImagePrimaryColorExtractor
import com.neome.feature.utils.PrimaryColorOutcome
import com.neome.feature.utils.PrimaryColorResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Image Primary Color showcase demonstrating native color extraction.
 *
 * Architecture justification:
 * - Uses stateless helper (ImagePrimaryColorExtractor) instead of ViewModel because:
 *   1. Color extraction is a single synchronous operation
 *   2. No complex state management or lifecycle concerns
 *   3. No side effects beyond extraction (no network, no persistence)
 *   4. Consistent with ImageCompressionShowcase and ThumbnailPickerShowcase patterns
 */
@Composable
fun ImagePrimaryColorShowcase() {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    // State
    var pickedImage by remember { mutableStateOf<FilePickerResult?>(null) }
    var imageBitmap by remember { mutableStateOf<Bitmap?>(null) }
    var colorResult by remember { mutableStateOf<PrimaryColorResult?>(null) }
    var errorMessage by remember { mutableStateOf<String?>(null) }
    var isExtracting by remember { mutableStateOf(false) }

    // File picker for images
    val pickImage = rememberFilePicker(mode = FilePickerMode.IMAGE) { result ->
        if (result != null) {
            pickedImage = result
            colorResult = null
            errorMessage = null

            // Load bitmap and extract color
            isExtracting = true
            scope.launch {
                val bitmap = loadBitmapFromUri(context, result)
                imageBitmap = bitmap

                if (bitmap != null) {
                    val outcome = withContext(Dispatchers.Default) {
                        ImagePrimaryColorExtractor.extractPrimaryColor(bitmap)
                    }
                    when (outcome) {
                        is PrimaryColorOutcome.Success -> {
                            colorResult = outcome.result
                            errorMessage = null
                        }
                        is PrimaryColorOutcome.Error -> {
                            errorMessage = outcome.message
                            colorResult = null
                        }
                    }
                } else {
                    errorMessage = "Failed to load image"
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
            text = "Image Primary Color",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = "Extract the dominant color from an image using native Android SDK pixel analysis. No external libraries used.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Image Picker Card
        ColorImagePickerCard(
            pickedImage = pickedImage,
            isExtracting = isExtracting,
            onPickClick = pickImage,
            onClear = {
                pickedImage = null
                imageBitmap = null
                colorResult = null
                errorMessage = null
            }
        )

        // Error display
        errorMessage?.let { error ->
            ColorErrorCard(message = error)
        }

        // Image Preview with Color Swatch
        if (imageBitmap != null || colorResult != null) {
            ColorPreviewSection(
                bitmap = imageBitmap,
                colorResult = colorResult
            )
        }
    }
}

@Composable
private fun ColorImagePickerCard(
    pickedImage: FilePickerResult?,
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
                        imageVector = Icons.Default.ColorLens,
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

                if (pickedImage != null && !isExtracting) {
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
                    Text("Analyzing...")
                } else {
                    Icon(
                        imageVector = Icons.Default.Image,
                        contentDescription = null,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.size(8.dp))
                    Text(if (pickedImage == null) "Pick Image" else "Change Image")
                }
            }

            if (pickedImage != null) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Size: ${formatFileSizeForColor(pickedImage.fileSize)} | Type: ${pickedImage.mimeType}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@Composable
private fun ColorPreviewSection(
    bitmap: Bitmap?,
    colorResult: PrimaryColorResult?
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Image Preview
        if (bitmap != null && !bitmap.isRecycled) {
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
                            modifier = Modifier.size(24.dp),
                            tint = MaterialTheme.colorScheme.primary
                        )
                        Text(
                            text = "Image Preview",
                            style = MaterialTheme.typography.titleMedium
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Image(
                        bitmap = bitmap.asImageBitmap(),
                        contentDescription = "Selected image",
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(4f / 3f)
                            .clip(RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Fit
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "${bitmap.width} x ${bitmap.height} pixels",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }

        // Color Result
        colorResult?.let { result ->
            PrimaryColorResultCard(result = result)
        }
    }
}

@Composable
private fun PrimaryColorResultCard(result: PrimaryColorResult) {
    val extractedColor = Color(result.color)

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
                    imageVector = Icons.Default.ColorLens,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp),
                    tint = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = "Extracted Primary Color",
                    style = MaterialTheme.typography.titleMedium
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Large color swatch
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(120.dp)
                        .clip(CircleShape)
                        .background(extractedColor)
                        .border(
                            width = 4.dp,
                            color = MaterialTheme.colorScheme.outline,
                            shape = CircleShape
                        )
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Color details card
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
                        text = "Color Details",
                        style = MaterialTheme.typography.titleSmall,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    // Hex value with color preview
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Hex",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(20.dp)
                                    .clip(RoundedCornerShape(4.dp))
                                    .background(extractedColor)
                                    .border(
                                        width = 1.dp,
                                        color = MaterialTheme.colorScheme.outline,
                                        shape = RoundedCornerShape(4.dp)
                                    )
                            )
                            Text(
                                text = result.hexString,
                                style = MaterialTheme.typography.titleSmall,
                                color = MaterialTheme.colorScheme.onPrimaryContainer
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    // RGB values
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "RGB",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                        Text(
                            text = "(${result.red}, ${result.green}, ${result.blue})",
                            style = MaterialTheme.typography.titleSmall,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    // Pixels analyzed
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Pixels Analyzed",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                        Text(
                            text = formatPixelCount(result.pixelsSampled),
                            style = MaterialTheme.typography.titleSmall,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun ColorErrorCard(message: String) {
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

private fun formatFileSizeForColor(bytes: Long): String {
    return when {
        bytes < 1024 -> "$bytes B"
        bytes < 1024 * 1024 -> String.format("%.1f KB", bytes / 1024.0)
        bytes < 1024 * 1024 * 1024 -> String.format("%.2f MB", bytes / (1024.0 * 1024.0))
        else -> String.format("%.2f GB", bytes / (1024.0 * 1024.0 * 1024.0))
    }
}

private fun formatPixelCount(count: Int): String {
    return when {
        count < 1000 -> "$count"
        count < 1_000_000 -> String.format("%.1fK", count / 1000.0)
        else -> String.format("%.2fM", count / 1_000_000.0)
    }
}
