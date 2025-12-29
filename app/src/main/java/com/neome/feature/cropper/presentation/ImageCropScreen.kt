package com.neome.feature.cropper.presentation

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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.neome.feature.cropper.domain.model.CroppableImage
import com.neome.feature.cropper.domain.usecase.CropImageUseCase
import com.neome.feature.cropper.presentation.components.CropOverlay

/**
 * Image crop screen with free crop mode only.
 *
 * Features:
 * - Free crop (always movable and resizable)
 * - Consistent action buttons with proper tap areas
 * - Safe padding to prevent gesture conflicts
 * - Smooth, intuitive interactions
 */
@Composable
fun ImageCropScreen(
    sourceImage: CroppableImage,
    aspectRatio: AspectRatio = AspectRatio.Free,
    viewModel: ImageCropViewModel = viewModel(
        factory = ImageCropViewModel.Factory(
            cropImageUseCase = CropImageUseCase()
        )
    ),
    onCropConfirmed: (CroppableImage) -> Unit,
    onCancelled: (CroppableImage) -> Unit,
    onError: (String) -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    // Initialize with source image
    LaunchedEffect(sourceImage) {
        viewModel.setSourceImage(sourceImage)
    }

    // Collect effects
    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is ImageCropEffect.CropConfirmed -> onCropConfirmed(effect.croppedImage)
                is ImageCropEffect.Cancelled -> onCancelled(effect.originalImage)
                is ImageCropEffect.Error -> onError(effect.message)
            }
        }
    }

    ImageCropContent(
        state = state,
        onEvent = viewModel::onEvent
    )
}

@Composable
private fun ImageCropContent(
    state: ImageCropState,
    onEvent: (ImageCropEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        if (state.isProcessing) {
            // Loading overlay
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    CircularProgressIndicator(color = Color.White)
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Processing...",
                        color = Color.White,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        } else if (state.sourceImage != null) {
            // Image with crop overlay
            val bitmap = remember(state.sourceImage) {
                BitmapFactory.decodeByteArray(
                    state.sourceImage.bytes,
                    0,
                    state.sourceImage.bytes.size
                )
            }

            // Image area with safe margins for controls
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 72.dp, bottom = 88.dp)
            ) {
                if (bitmap != null) {
                    val imageAspectRatio = remember(bitmap) {
                        bitmap.width.toFloat() / bitmap.height.toFloat()
                    }

                    Image(
                        bitmap = bitmap.asImageBitmap(),
                        contentDescription = "Image to crop",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Fit
                    )

                    CropOverlay(
                        cropRegion = state.cropRegion,
                        onCropRegionChanged = { region ->
                            onEvent(ImageCropEvent.CropRegionChanged(region))
                        },
                        imageAspectRatio = imageAspectRatio,
                        modifier = Modifier.fillMaxSize(),
                        safePadding = 24.dp
                    )
                }
            }

            // Top controls - Cancel and Reset
            TopControls(
                onClose = { onEvent(ImageCropEvent.Cancel) },
                onReset = { onEvent(ImageCropEvent.Reset) },
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopCenter)
                    .background(Color.Black.copy(alpha = 0.3f))
                    .padding(horizontal = 8.dp, vertical = 12.dp)
            )

            // Bottom controls - Confirm button
            BottomControls(
                onConfirm = { onEvent(ImageCropEvent.ConfirmCrop) },
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .background(Color.Black.copy(alpha = 0.3f))
                    .padding(horizontal = 16.dp, vertical = 16.dp)
            )

            // Error message
            state.error?.let { error ->
                Surface(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(32.dp),
                    color = MaterialTheme.colorScheme.errorContainer,
                    shape = MaterialTheme.shapes.medium
                ) {
                    Text(
                        text = error,
                        color = MaterialTheme.colorScheme.onErrorContainer,
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        } else {
            // No image
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "No image to crop",
                    color = Color.White,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}

/**
 * Top controls with Cancel and Reset buttons.
 * All buttons have consistent size (48dp) and tap area.
 */
@Composable
private fun TopControls(
    onClose: () -> Unit,
    onReset: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Cancel button - 48dp touch target
        IconButton(
            onClick = onClose,
            modifier = Modifier.size(48.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = "Cancel",
                tint = Color.White,
                modifier = Modifier.size(28.dp)
            )
        }

        // Reset button - 48dp touch target
        IconButton(
            onClick = onReset,
            modifier = Modifier.size(48.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Refresh,
                contentDescription = "Reset crop",
                tint = Color.White,
                modifier = Modifier.size(28.dp)
            )
        }
    }
}

/**
 * Bottom controls with Confirm button.
 * Confirm button matches the size and style of other action buttons.
 */
@Composable
private fun BottomControls(
    onConfirm: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Confirm button - prominent, easy to tap (56dp)
        FilledIconButton(
            onClick = onConfirm,
            modifier = Modifier.size(56.dp),
            shape = CircleShape,
            colors = IconButtonDefaults.filledIconButtonColors(
                containerColor = Color.White,
                contentColor = Color.Black
            )
        ) {
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = "Confirm crop",
                modifier = Modifier.size(32.dp)
            )
        }
    }
}
