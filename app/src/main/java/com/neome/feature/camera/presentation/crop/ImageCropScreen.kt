package com.neome.feature.camera.presentation.crop

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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.neome.feature.camera.domain.model.CapturedImage
import com.neome.feature.camera.presentation.components.CropOverlay

@Composable
fun ImageCropScreen(
    sourceImage: CapturedImage,
    aspectRatio: AspectRatio = AspectRatio.Free,
    viewModel: ImageCropViewModel = hiltViewModel(),
    onCropConfirmed: (CapturedImage) -> Unit,
    onCancelled: (CapturedImage) -> Unit,
    onError: (String) -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    // Initialize with source image and aspect ratio
    LaunchedEffect(sourceImage) {
        viewModel.setSourceImage(sourceImage)
    }

    LaunchedEffect(aspectRatio) {
        viewModel.setAspectRatio(aspectRatio)
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
                        color = Color.White
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

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 80.dp)
            ) {
                if (bitmap != null) {
                    Image(
                        bitmap = bitmap.asImageBitmap(),
                        contentDescription = "Image to crop",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Fit
                    )

                    CropOverlay(
                        cropRegion = state.cropRegion,
                        aspectRatio = state.aspectRatio.toRatio(),
                        onCropRegionChanged = { region ->
                            onEvent(ImageCropEvent.CropRegionChanged(region))
                        },
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }

            // Top controls
            TopControls(
                onClose = { onEvent(ImageCropEvent.Cancel) },
                onReset = { onEvent(ImageCropEvent.Reset) },
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopCenter)
                    .padding(16.dp)
            )

            // Bottom controls
            BottomControls(
                aspectRatio = state.aspectRatio,
                onAspectRatioSelected = { ratio ->
                    onEvent(ImageCropEvent.AspectRatioSelected(ratio))
                },
                onConfirm = { onEvent(ImageCropEvent.ConfirmCrop) },
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .padding(16.dp)
            )

            // Error message
            state.error?.let { error ->
                Text(
                    text = error,
                    color = MaterialTheme.colorScheme.error,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(16.dp)
                )
            }
        } else {
            // No image
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "No image to crop",
                    color = Color.White
                )
            }
        }
    }
}

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
        IconButton(onClick = onClose) {
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = "Cancel",
                tint = Color.White
            )
        }

        IconButton(onClick = onReset) {
            Icon(
                imageVector = Icons.Default.Refresh,
                contentDescription = "Reset",
                tint = Color.White
            )
        }
    }
}

@Composable
private fun BottomControls(
    aspectRatio: AspectRatio,
    onAspectRatioSelected: (AspectRatio) -> Unit,
    onConfirm: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Aspect ratio chips
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            AspectRatioChip(
                label = "Free",
                isSelected = aspectRatio is AspectRatio.Free,
                onClick = { onAspectRatioSelected(AspectRatio.Free) }
            )
            AspectRatioChip(
                label = "1:1",
                isSelected = aspectRatio is AspectRatio.Square,
                onClick = { onAspectRatioSelected(AspectRatio.Square) }
            )
            AspectRatioChip(
                label = "4:3",
                isSelected = aspectRatio is AspectRatio.FourThree,
                onClick = { onAspectRatioSelected(AspectRatio.FourThree) }
            )
            AspectRatioChip(
                label = "16:9",
                isSelected = aspectRatio is AspectRatio.SixteenNine,
                onClick = { onAspectRatioSelected(AspectRatio.SixteenNine) }
            )
        }

        // Confirm button
        Button(
            onClick = onConfirm,
            modifier = Modifier.size(56.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = "Confirm crop"
            )
        }
    }
}

@Composable
private fun AspectRatioChip(
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    FilterChip(
        selected = isSelected,
        onClick = onClick,
        label = { Text(label) }
    )
}
