package com.neome.feature.componentshowcase.presentation.components

import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Camera
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Crop
import androidx.compose.material.icons.filled.Image
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.neome.feature.camera.domain.model.CapturedImage
import com.neome.feature.camera.presentation.capture.CameraCaptureScreen
import com.neome.feature.cropper.domain.model.CroppableImage
import com.neome.feature.cropper.presentation.ImageCropScreen

/**
 * Media showcase demonstrating camera features.
 *
 * Two flows only:
 * 1. Simple Camera: Capture only, returns immediately
 * 2. Camera with Preview: Capture → Preview → (Optional Crop) → Done
 */
@Composable
fun MediaShowcase() {
    // Simple states - no boolean explosion
    var showSimpleCamera by remember { mutableStateOf(false) }
    var showCameraForPreview by remember { mutableStateOf(false) }
    var previewImage by remember { mutableStateOf<CapturedImage?>(null) }
    var finalImage by remember { mutableStateOf<CapturedImage?>(null) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Media Features",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = "Test the camera capture and preview features.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Simple Camera Card
        MediaFeatureCard(
            title = "Simple Camera",
            description = "Capture only - no preview, no crop. Returns raw image data immediately after capture.",
            icon = Icons.Default.CameraAlt,
            buttonText = "Open Camera",
            onClick = { showSimpleCamera = true }
        )

        // Camera with Preview Card (crop is optional inside preview)
        MediaFeatureCard(
            title = "Camera with Preview",
            description = "Capture and preview. Optionally crop the image before confirming.",
            icon = Icons.Default.Image,
            buttonText = "Capture & Preview",
            onClick = { showCameraForPreview = true }
        )

        // Show final captured image if available
        finalImage?.let { image ->
            CapturedImagePreviewCard(
                image = image,
                onClear = { finalImage = null }
            )
        }
    }

    // Simple Camera Dialog - capture and immediately return
    if (showSimpleCamera) {
        FullScreenCameraDialog(
            onDismiss = { showSimpleCamera = false }
        ) {
            CameraCaptureScreen(
                onImageCaptured = { image ->
                    finalImage = image
                    showSimpleCamera = false
                },
                onCancelled = {
                    showSimpleCamera = false
                },
                onError = {
                    showSimpleCamera = false
                }
            )
        }
    }

    // Camera for Preview flow - capture then show preview
    if (showCameraForPreview) {
        FullScreenCameraDialog(
            onDismiss = { showCameraForPreview = false }
        ) {
            CameraCaptureScreen(
                onImageCaptured = { image ->
                    // Camera closes, Preview opens with captured image
                    previewImage = image
                    showCameraForPreview = false
                },
                onCancelled = {
                    showCameraForPreview = false
                },
                onError = {
                    showCameraForPreview = false
                }
            )
        }
    }

    // Preview Dialog - single source of truth for image state
    // Crop is an optional action within preview, not a separate flow
    if (previewImage != null) {
        ImagePreviewWithCropDialog(
            image = previewImage!!,
            onImageUpdated = { updatedImage ->
                // Cropped image replaces original in preview
                previewImage = updatedImage
            },
            onDismiss = {
                // Cancel - discard image
                previewImage = null
            },
            onConfirm = { confirmedImage ->
                // Done - save final image
                finalImage = confirmedImage
                previewImage = null
            }
        )
    }
}

@Composable
private fun MediaFeatureCard(
    title: String,
    description: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    buttonText: String,
    onClick: () -> Unit
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
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = description,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = onClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    imageVector = Icons.Default.Camera,
                    contentDescription = null,
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.size(8.dp))
                Text(buttonText)
            }
        }
    }
}

@Composable
private fun CapturedImagePreviewCard(
    image: CapturedImage,
    onClear: () -> Unit
) {
    val bitmap = remember(image) {
        BitmapFactory.decodeByteArray(image.bytes, 0, image.bytes.size)
    }

    ElevatedCard(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp)
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
                Text(
                    text = "Captured Image",
                    style = MaterialTheme.typography.titleMedium
                )
                IconButton(onClick = onClear) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Clear"
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            if (bitmap != null) {
                Image(
                    bitmap = bitmap.asImageBitmap(),
                    contentDescription = "Captured image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(4f / 3f)
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Size: ${image.width} x ${image.height} • ${image.bytes.size / 1024} KB",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
private fun FullScreenCameraDialog(
    onDismiss: () -> Unit,
    content: @Composable () -> Unit
) {
    Dialog(
        onDismissRequest = onDismiss,
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
            content()
        }
    }
}

/**
 * Preview dialog with optional crop functionality.
 *
 * Flow: Preview → (Optional Crop) → Preview → Done
 *
 * - Crop button in top bar opens cropper as overlay
 * - Cropped image replaces original in preview
 * - User can re-crop or confirm with Done
 */
@Composable
private fun ImagePreviewWithCropDialog(
    image: CapturedImage,
    onImageUpdated: (CapturedImage) -> Unit,
    onDismiss: () -> Unit,
    onConfirm: (CapturedImage) -> Unit
) {
    // Single state: is cropper showing?
    var showCropper by remember { mutableStateOf(false) }

    val bitmap = remember(image) {
        BitmapFactory.decodeByteArray(image.bytes, 0, image.bytes.size)
    }

    Dialog(
        onDismissRequest = onDismiss,
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
            Box(modifier = Modifier.fillMaxSize()) {
                // Main Preview Content
                Column(
                    modifier = Modifier.fillMaxSize()
                ) {
                    // Top bar with Close, Crop, and Done
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(MaterialTheme.colorScheme.surface)
                            .padding(horizontal = 8.dp, vertical = 4.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Close button
                        IconButton(onClick = onDismiss) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = "Close"
                            )
                        }

                        // Crop button - opens cropper overlay
                        OutlinedButton(
                            onClick = { showCropper = true }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Crop,
                                contentDescription = null,
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(modifier = Modifier.size(4.dp))
                            Text("Crop")
                        }

                        // Done button
                        FilledTonalButton(onClick = { onConfirm(image) }) {
                            Text("Done")
                        }
                    }

                    // Image preview
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(1f),
                        contentAlignment = Alignment.Center
                    ) {
                        if (bitmap != null) {
                            Image(
                                bitmap = bitmap.asImageBitmap(),
                                contentDescription = "Captured image preview",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Fit
                            )
                        }
                    }

                    // Info bar
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(MaterialTheme.colorScheme.surfaceVariant)
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "${image.width} x ${image.height} • ${image.bytes.size / 1024} KB",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }

                // Cropper Overlay - shown only when user taps Crop
                if (showCropper) {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        ImageCropScreen(
                            sourceImage = image.toCroppableImage(),
                            onCropConfirmed = { croppedImage ->
                                // Update image and return to preview
                                onImageUpdated(croppedImage.toCapturedImage())
                                showCropper = false
                            },
                            onCancelled = { _ ->
                                // Cancel crop - keep original, return to preview
                                showCropper = false
                            },
                            onError = { _ ->
                                // Error - return to preview
                                showCropper = false
                            }
                        )
                    }
                }
            }
        }
    }
}

/**
 * Convert CapturedImage to CroppableImage for use with the Cropper feature.
 */
private fun CapturedImage.toCroppableImage(): CroppableImage {
    return CroppableImage(
        bytes = bytes,
        width = width,
        height = height,
        rotation = rotation,
        mimeType = mimeType
    )
}

/**
 * Convert CroppableImage back to CapturedImage after cropping.
 */
private fun CroppableImage.toCapturedImage(): CapturedImage {
    return CapturedImage(
        bytes = bytes,
        width = width,
        height = height,
        rotation = rotation,
        mimeType = mimeType,
        timestamp = System.currentTimeMillis()
    )
}
