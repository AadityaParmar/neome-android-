package com.neome.feature.form.presentation.components.field

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Image
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.Stable
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
import androidx.compose.ui.window.DialogProperties
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

// ============================================================================
// Constants
// ============================================================================

private const val MIN_ZOOM_SCALE = 1f
private const val MAX_ZOOM_SCALE = 4f
private val DIALOG_CONTENT_SIZE = 400.dp
private val ERROR_ICON_SIZE = 48.dp

// ============================================================================
// Main Component
// ============================================================================

/**
 * Full-screen image preview dialog with zoom and pan support.
 *
 * Displays the image from a content URI with the ability to zoom in/out
 * and pan around the image when zoomed.
 *
 * Features:
 * - Pinch-to-zoom gesture support
 * - Pan gesture when zoomed in
 * - Loading state indicator
 * - Error state with placeholder icon
 *
 * @param uri URI of the image to preview
 * @param fileName Name of the file for display in the dialog title
 * @param onDismiss Callback when the dialog is dismissed
 */
@Composable
fun ImagePreviewDialog(
    uri: Uri,
    fileName: String,
    onDismiss: () -> Unit
) {
    val context = LocalContext.current
    val previewState = rememberImagePreviewState()

    // Load bitmap from URI on background thread
    LaunchedEffect(uri) {
        previewState.loadImage {
            withContext(Dispatchers.IO) {
                loadBitmapFromUri(context, uri)
            }
        }
    }

    AlertDialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false),
        title = {
            Text(
                text = fileName,
                maxLines = 1
            )
        },
        text = {
            ImagePreviewContent(
                bitmap = previewState.bitmap,
                isLoading = previewState.isLoading,
                scale = previewState.scale,
                offsetX = previewState.offsetX,
                offsetY = previewState.offsetY,
                onTransformGesture = previewState::handleTransformGesture
            )
        },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text("Close")
            }
        }
    )
}

/**
 * Full-screen image preview dialog for ByteArray-based images (e.g., camera capture).
 *
 * Same zoom/pan functionality as the URI variant but decodes directly from a ByteArray.
 *
 * @param byteArray Raw image bytes to preview
 * @param fileName Name of the file for display in the dialog title
 * @param onDismiss Callback when the dialog is dismissed
 */
@Composable
fun ImagePreviewDialog(
    byteArray: ByteArray,
    fileName: String,
    onDismiss: () -> Unit
) {
    val previewState = rememberImagePreviewState()

    // Decode ByteArray to Bitmap on background thread
    LaunchedEffect(byteArray) {
        previewState.loadImage {
            withContext(Dispatchers.IO) {
                BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)
            }
        }
    }

    AlertDialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false),
        title = {
            Text(
                text = fileName,
                maxLines = 1
            )
        },
        text = {
            ImagePreviewContent(
                bitmap = previewState.bitmap,
                isLoading = previewState.isLoading,
                scale = previewState.scale,
                offsetX = previewState.offsetX,
                offsetY = previewState.offsetY,
                onTransformGesture = previewState::handleTransformGesture
            )
        },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text("Close")
            }
        }
    )
}

// ============================================================================
// State Holder
// ============================================================================

/**
 * State holder for the image preview dialog.
 *
 * Manages loading state, bitmap data, and transform (zoom/pan) state.
 */
@Stable
class ImagePreviewState {
    var bitmap by mutableStateOf<Bitmap?>(null)
        private set

    var isLoading by mutableStateOf(true)
        private set

    var scale by mutableFloatStateOf(MIN_ZOOM_SCALE)
        private set

    var offsetX by mutableFloatStateOf(0f)
        private set

    var offsetY by mutableFloatStateOf(0f)
        private set

    /**
     * Loads the image using the provided loader function.
     */
    suspend fun loadImage(loader: suspend () -> Bitmap?) {
        isLoading = true
        bitmap = loader()
        isLoading = false
    }

    /**
     * Handles pinch-to-zoom and pan gestures.
     *
     * @param pan The pan offset from the gesture
     * @param zoom The zoom factor from the gesture
     */
    fun handleTransformGesture(pan: androidx.compose.ui.geometry.Offset, zoom: Float) {
        // Apply zoom with constraints
        scale = (scale * zoom).coerceIn(MIN_ZOOM_SCALE, MAX_ZOOM_SCALE)

        // Only allow panning when zoomed in
        if (scale > MIN_ZOOM_SCALE) {
            offsetX += pan.x
            offsetY += pan.y
        } else {
            // Reset pan offset when zoomed out completely
            offsetX = 0f
            offsetY = 0f
        }
    }
}

/**
 * Creates and remembers an [ImagePreviewState] instance.
 */
@Composable
private fun rememberImagePreviewState(): ImagePreviewState {
    return remember { ImagePreviewState() }
}

// ============================================================================
// UI Components
// ============================================================================

/**
 * The main content area of the preview dialog.
 * Shows loading indicator, image, or error state.
 */
@Composable
private fun ImagePreviewContent(
    bitmap: Bitmap?,
    isLoading: Boolean,
    scale: Float,
    offsetX: Float,
    offsetY: Float,
    onTransformGesture: (pan: androidx.compose.ui.geometry.Offset, zoom: Float) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .size(DIALOG_CONTENT_SIZE),
        contentAlignment = Alignment.Center
    ) {
        when {
            isLoading -> LoadingIndicator()
            bitmap != null -> ZoomableImage(
                bitmap = bitmap,
                scale = scale,
                offsetX = offsetX,
                offsetY = offsetY,
                onTransformGesture = onTransformGesture
            )
            else -> ErrorPlaceholder()
        }
    }
}

/**
 * Loading state indicator.
 */
@Composable
private fun LoadingIndicator() {
    CircularProgressIndicator()
}

/**
 * Zoomable and pannable image display.
 */
@Composable
private fun ZoomableImage(
    bitmap: Bitmap,
    scale: Float,
    offsetX: Float,
    offsetY: Float,
    onTransformGesture: (pan: androidx.compose.ui.geometry.Offset, zoom: Float) -> Unit
) {
    Image(
        bitmap = bitmap.asImageBitmap(),
        contentDescription = "Image preview",
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTransformGestures { _, pan, zoom, _ ->
                    onTransformGesture(pan, zoom)
                }
            }
            .graphicsLayer(
                scaleX = scale,
                scaleY = scale,
                translationX = offsetX,
                translationY = offsetY
            ),
        contentScale = ContentScale.Fit
    )
}

/**
 * Error state placeholder shown when image fails to load.
 */
@Composable
private fun ErrorPlaceholder() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surfaceVariant),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = Icons.Default.Image,
            contentDescription = "Failed to load image",
            modifier = Modifier.size(ERROR_ICON_SIZE),
            tint = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

// ============================================================================
// Utility Functions
// ============================================================================

/**
 * Loads a bitmap from a content URI.
 *
 * @param context Android context for content resolver access
 * @param uri The content URI of the image
 * @return The loaded Bitmap, or null if loading fails
 */
private fun loadBitmapFromUri(
    context: android.content.Context,
    uri: Uri
): Bitmap? {
    return try {
        context.contentResolver.openInputStream(uri)?.use { stream ->
            BitmapFactory.decodeStream(stream)
        }
    } catch (e: Exception) {
        null
    }
}
