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
import com.neome.feature.camera.presentation.crop.ImageCropScreen

/**
 * Media showcase demonstrating camera features.
 */
@Composable
fun MediaShowcase() {
    var showSimpleCamera by remember { mutableStateOf(false) }
    var showCameraWithPreview by remember { mutableStateOf(false) }
    var showCameraWithCropper by remember { mutableStateOf(false) }
    var capturedImage by remember { mutableStateOf<CapturedImage?>(null) }
    var showImagePreview by remember { mutableStateOf(false) }
    var showCropScreen by remember { mutableStateOf(false) }

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
            text = "Test the camera capture, preview, and crop features.",
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

        // Camera with Preview Card
        MediaFeatureCard(
            title = "Camera with Preview",
            description = "Capture and view the image. Shows a preview of the captured photo before confirming.",
            icon = Icons.Default.Image,
            buttonText = "Capture & Preview",
            onClick = { showCameraWithPreview = true }
        )

        // Camera with Cropper Card
        MediaFeatureCard(
            title = "Camera with Cropper",
            description = "Capture, crop (square), and view. Full flow with aspect ratio constraint.",
            icon = Icons.Default.Crop,
            buttonText = "Capture & Crop",
            onClick = { showCameraWithCropper = true }
        )

        // Show captured image if available
        capturedImage?.let { image ->
            CapturedImagePreviewCard(
                image = image,
                onClear = { capturedImage = null }
            )
        }
    }

    // Simple Camera Dialog
    if (showSimpleCamera) {
        FullScreenCameraDialog(
            onDismiss = { showSimpleCamera = false }
        ) {
            CameraCaptureScreen(
                onImageCaptured = { image ->
                    capturedImage = image
                    showSimpleCamera = false
                },
                onCancelled = {
                    showSimpleCamera = false
                },
                onError = { error ->
                    showSimpleCamera = false
                }
            )
        }
    }

    // Camera with Preview Dialog
    if (showCameraWithPreview) {
        FullScreenCameraDialog(
            onDismiss = { showCameraWithPreview = false }
        ) {
            CameraCaptureScreen(
                onImageCaptured = { image ->
                    capturedImage = image
                    showCameraWithPreview = false
                    showImagePreview = true
                },
                onCancelled = {
                    showCameraWithPreview = false
                },
                onError = { error ->
                    showCameraWithPreview = false
                }
            )
        }
    }

    // Image Preview Dialog
    if (showImagePreview && capturedImage != null) {
        ImagePreviewDialog(
            image = capturedImage!!,
            onDismiss = {
                showImagePreview = false
            },
            onConfirm = {
                showImagePreview = false
            }
        )
    }

    // Camera with Cropper Dialog
    if (showCameraWithCropper) {
        FullScreenCameraDialog(
            onDismiss = { showCameraWithCropper = false }
        ) {
            CameraCaptureScreen(
                onImageCaptured = { image ->
                    capturedImage = image
                    showCameraWithCropper = false
                    showCropScreen = true
                },
                onCancelled = {
                    showCameraWithCropper = false
                },
                onError = { error ->
                    showCameraWithCropper = false
                }
            )
        }
    }

    // Crop Screen Dialog
    if (showCropScreen && capturedImage != null) {
        FullScreenCameraDialog(
            onDismiss = { showCropScreen = false }
        ) {
            ImageCropScreen(
                sourceImage = capturedImage!!,
                onCropConfirmed = { croppedImage ->
                    capturedImage = croppedImage
                    showCropScreen = false
                },
                onCancelled = { originalImage ->
                    showCropScreen = false
                },
                onError = { message ->
                    showCropScreen = false
                }
            )
        }
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

@Composable
private fun ImagePreviewDialog(
    image: CapturedImage,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
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
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                // Top bar
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.surface)
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = onDismiss) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Close"
                        )
                    }
                    Text(
                        text = "Preview",
                        style = MaterialTheme.typography.titleMedium
                    )
                    FilledTonalButton(onClick = onConfirm) {
                        Text("Done")
                    }
                }

                // Image
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
        }
    }
}
