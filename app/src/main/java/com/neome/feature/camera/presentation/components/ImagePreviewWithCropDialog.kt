package com.neome.feature.camera.presentation.components

import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Crop
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
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.neome.feature.camera.domain.model.CapturedImage
import com.neome.feature.camera.domain.model.toCroppableImage
import com.neome.feature.cropper.domain.model.toCapturedImage
import com.neome.feature.cropper.presentation.ImageCropScreen

/**
 * Preview dialog with optional crop functionality.
 *
 * Flow: Preview → (Optional Crop) → Preview → Done
 *
 * - Crop button in top bar opens cropper as overlay
 * - Cropped image replaces original in preview
 * - User can re-crop or confirm with Done
 *
 * @param image The captured image to preview
 * @param onImageUpdated Called when the image is updated (e.g., after cropping)
 * @param onDismiss Called when the user cancels/closes the dialog
 * @param onConfirm Called when the user confirms the final image
 */
@Composable
fun ImagePreviewWithCropDialog(
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
