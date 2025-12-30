package com.neome.feature.media_carousel.presentation.components

import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Crop
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.neome.feature.media_carousel.domain.model.MediaItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun ImagePreview(
    imageItem: MediaItem.ImageItem,
    modifier: Modifier = Modifier,
    cropperEnabled: Boolean = false,
    isFullScreen: Boolean = false,
    onCropClick: () -> Unit = {}
) {
    val context = LocalContext.current

    // Use bytes hashCode as part of the key to detect when image content changes (e.g., after cropping)
    val contentKey = remember(imageItem.id, imageItem.bytes?.size) {
        "${imageItem.id}_${imageItem.bytes?.size ?: 0}"
    }

    // Initialize with imageItem.bitmap if available, otherwise null to trigger loading
    var bitmap by remember(contentKey) { mutableStateOf(imageItem.bitmap) }
    var isLoading by remember(contentKey) { mutableStateOf(false) }

    // Zoom and pan state for full screen
    var scale by remember { mutableFloatStateOf(1f) }
    var offsetX by remember { mutableFloatStateOf(0f) }
    var offsetY by remember { mutableFloatStateOf(0f) }

    // Load bitmap from bytes or URI when not already available
    LaunchedEffect(contentKey) {
        // Use provided bitmap first, then try to load from bytes, then from URI
        val providedBitmap = imageItem.bitmap
        if (providedBitmap != null) {
            bitmap = providedBitmap
            return@LaunchedEffect
        }

        // Need to load bitmap
        isLoading = true
        bitmap = withContext(Dispatchers.IO) {
            try {
                when {
                    imageItem.bytes != null -> {
                        BitmapFactory.decodeByteArray(
                            imageItem.bytes,
                            0,
                            imageItem.bytes.size
                        )
                    }
                    else -> {
                        context.contentResolver.openInputStream(imageItem.uri)?.use { stream ->
                            BitmapFactory.decodeStream(stream)
                        }
                    }
                }
            } catch (e: Exception) {
                null
            }
        }
        isLoading = false
    }

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        when {
            isLoading -> {
                CircularProgressIndicator()
            }
            bitmap != null -> {
                val imageModifier = if (isFullScreen) {
                    Modifier
                        .fillMaxSize()
                        .pointerInput(Unit) {
                            detectTransformGestures { _, pan, zoom, _ ->
                                scale = (scale * zoom).coerceIn(1f, 4f)
                                if (scale > 1f) {
                                    offsetX += pan.x
                                    offsetY += pan.y
                                } else {
                                    offsetX = 0f
                                    offsetY = 0f
                                }
                            }
                        }
                        .graphicsLayer(
                            scaleX = scale,
                            scaleY = scale,
                            translationX = offsetX,
                            translationY = offsetY
                        )
                } else {
                    Modifier.fillMaxSize()
                }

                Image(
                    bitmap = bitmap!!.asImageBitmap(),
                    contentDescription = "Image preview",
                    modifier = imageModifier,
                    contentScale = if (isFullScreen) ContentScale.Fit else ContentScale.Crop
                )
            }
            else -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.surfaceVariant),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Crop,
                        contentDescription = "Image error",
                        modifier = Modifier.size(48.dp),
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }

        // Crop button
        if (cropperEnabled && bitmap != null) {
            IconButton(
                onClick = onCropClick,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(8.dp)
                    .background(
                        MaterialTheme.colorScheme.surface.copy(alpha = 0.8f),
                        CircleShape
                    )
            ) {
                Icon(
                    imageVector = Icons.Default.Crop,
                    contentDescription = "Crop image",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}
