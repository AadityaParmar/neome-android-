package com.neome.feature.form.presentation.components.field

import android.graphics.Bitmap
import android.util.Base64
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import java.io.ByteArrayOutputStream

// =============================================================================
// Constants
// =============================================================================

private const val STROKE_WIDTH_DP = 3
private const val CROP_PADDING_PX = 16
private const val PNG_QUALITY = 100

/**
 * Full-screen dialog for drawing a signature.
 *
 * Layout:
 * ```
 * ___________________________
 * | <-  Draw signature      |
 * ---------------------------
 * |                          |
 * |    (drawing canvas)      |
 * |                          |
 * ---------------------------
 * | Clear              Done  |
 * ---------------------------
 * ```
 *
 * The canvas tracks touch/drag gestures and renders freeform strokes.
 * On "Done", the drawn strokes are rendered to a [Bitmap], cropped to
 * the bounding box of the signature, encoded as a base64 PNG string,
 * and returned via [onConfirm].
 *
 * @param onDismiss Called when the user presses back arrow or system back
 * @param onConfirm Called when the user taps "Done" with the base64-encoded
 *                  signature PNG string. Null if canvas is empty.
 */
@Composable
fun SignatureDrawDialog(
    onDismiss: () -> Unit,
    onConfirm: (base64Signature: String?) -> Unit
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
            SignatureDrawContent(
                onBackClick = onDismiss,
                onDoneClick = onConfirm
            )
        }
    }
}

// =============================================================================
// Content
// =============================================================================

/**
 * Content layout for the signature draw dialog.
 *
 * Manages drawing state (strokes) and canvas dimensions internally
 * since they are transient UI state that does not outlive the dialog.
 */
@Composable
private fun SignatureDrawContent(
    onBackClick: () -> Unit,
    onDoneClick: (String?) -> Unit
) {
    // Drawing state — transient, lives only while the dialog is open
    var completedPaths by remember { mutableStateOf(listOf<List<Offset>>()) }
    var currentPath by remember { mutableStateOf(listOf<Offset>()) }

    // Canvas pixel dimensions — needed to create a matching Bitmap on "Done"
    var canvasWidthPx by remember { mutableIntStateOf(0) }
    var canvasHeightPx by remember { mutableIntStateOf(0) }

    Column(modifier = Modifier.fillMaxSize()) {
        // Top bar
        SignatureTopBar(onBackClick = onBackClick)

        // Canvas area — takes all remaining vertical space
        SignatureCanvas(
            completedPaths = completedPaths,
            currentPath = currentPath,
            onDragStart = { offset ->
                currentPath = listOf(offset)
            },
            onDrag = { offset ->
                currentPath = currentPath + offset
            },
            onDragEnd = {
                if (currentPath.size > 1) {
                    completedPaths = completedPaths + listOf(currentPath)
                }
                currentPath = emptyList()
            },
            onCanvasSizeChanged = { width, height ->
                canvasWidthPx = width
                canvasHeightPx = height
            },
            modifier = Modifier.weight(1f)
        )

        // Bottom bar
        SignatureBottomBar(
            onClearClick = {
                completedPaths = emptyList()
                currentPath = emptyList()
            },
            onDoneClick = {
                if (completedPaths.isEmpty()) {
                    onDoneClick(null)
                } else {
                    val base64 = renderSignatureToBase64(
                        paths = completedPaths,
                        canvasWidth = canvasWidthPx,
                        canvasHeight = canvasHeightPx
                    )
                    onDoneClick(base64)
                }
            }
        )
    }
}

// =============================================================================
// Top Bar
// =============================================================================

/**
 * Top bar with back arrow and title.
 *
 * Layout: [<- ] [Draw signature]
 */
@Composable
private fun SignatureTopBar(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surface)
            .padding(horizontal = 4.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = onBackClick) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Back"
            )
        }
        Text(
            text = "Draw signature",
            style = MaterialTheme.typography.titleMedium
        )
    }
}

// =============================================================================
// Canvas
// =============================================================================

/**
 * Drawing surface that captures touch/drag gestures and renders strokes.
 *
 * Each stroke is a `List<Offset>` converted to a [Path] for drawing.
 * The canvas renders all completed strokes plus the current in-progress stroke.
 *
 * @param completedPaths All previously completed strokes
 * @param currentPath The stroke currently being drawn (empty when idle)
 * @param onDragStart Called with the starting offset when a new stroke begins
 * @param onDrag Called with each new offset as the finger moves
 * @param onDragEnd Called when the finger lifts — stroke is finalized
 * @param onCanvasSizeChanged Called when the canvas size is measured (width, height in pixels)
 * @param modifier Modifier for sizing (use weight(1f) to fill available space)
 */
@Composable
private fun SignatureCanvas(
    completedPaths: List<List<Offset>>,
    currentPath: List<Offset>,
    onDragStart: (Offset) -> Unit,
    onDrag: (Offset) -> Unit,
    onDragEnd: () -> Unit,
    onCanvasSizeChanged: (width: Int, height: Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val strokeColor = MaterialTheme.colorScheme.onSurface
    val canvasShape = RoundedCornerShape(8.dp)

    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clip(canvasShape)
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.outlineVariant,
                shape = canvasShape
            )
            .background(Color.White)
    ) {
        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .onSizeChanged { size ->
                    onCanvasSizeChanged(size.width, size.height)
                }
                .pointerInput(Unit) {
                    detectDragGestures(
                        onDragStart = { offset -> onDragStart(offset) },
                        onDrag = { change, _ ->
                            change.consume()
                            onDrag(change.position)
                        },
                        onDragEnd = { onDragEnd() },
                        onDragCancel = { onDragEnd() }
                    )
                }
        ) {
            val stroke = Stroke(
                width = STROKE_WIDTH_DP.dp.toPx(),
                cap = StrokeCap.Round,
                join = StrokeJoin.Round
            )

            // Draw completed strokes
            completedPaths.forEach { points ->
                if (points.size > 1) {
                    drawPath(
                        path = points.toPath(),
                        color = strokeColor,
                        style = stroke
                    )
                }
            }

            // Draw current in-progress stroke
            if (currentPath.size > 1) {
                drawPath(
                    path = currentPath.toPath(),
                    color = strokeColor,
                    style = stroke
                )
            }
        }
    }
}

// =============================================================================
// Bottom Bar
// =============================================================================

/**
 * Bottom bar with "Clear" button on the left and "Done" button on the right.
 *
 * Layout: [Clear                    Done]
 */
@Composable
private fun SignatureBottomBar(
    onClearClick: () -> Unit,
    onDoneClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surface)
            .padding(horizontal = 16.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        OutlinedButton(onClick = onClearClick) {
            Text("Clear")
        }
        Button(onClick = onDoneClick) {
            Text("Done")
        }
    }
}

// =============================================================================
// Bitmap Rendering & Base64 Encoding
// =============================================================================

/**
 * Renders the drawn strokes onto a [Bitmap], crops to the bounding box
 * of the signature (with padding), and encodes as a base64 PNG string.
 *
 * Steps:
 * 1. Create a full-size transparent Bitmap matching the canvas dimensions
 * 2. Draw all strokes onto the Bitmap's Canvas using Android graphics Path
 * 3. Compute the bounding box of all stroke points
 * 4. Crop the Bitmap to the bounding box (with [CROP_PADDING_PX] padding)
 * 5. Compress to PNG and encode as base64
 *
 * @param paths All completed stroke paths (List of point lists)
 * @param canvasWidth Canvas width in pixels
 * @param canvasHeight Canvas height in pixels
 * @return Base64-encoded PNG string of the cropped signature
 */
private fun renderSignatureToBase64(
    paths: List<List<Offset>>,
    canvasWidth: Int,
    canvasHeight: Int
): String {
    // 1. Create transparent Bitmap matching canvas size
    val bitmap = Bitmap.createBitmap(canvasWidth, canvasHeight, Bitmap.Config.ARGB_8888)
    val canvas = android.graphics.Canvas(bitmap)

    // 2. Draw all strokes using Android graphics
    val paint = android.graphics.Paint().apply {
        color = android.graphics.Color.BLACK
        strokeWidth = STROKE_WIDTH_DP * 3f // approximate dp-to-px for ~3dp
        style = android.graphics.Paint.Style.STROKE
        strokeCap = android.graphics.Paint.Cap.ROUND
        strokeJoin = android.graphics.Paint.Join.ROUND
        isAntiAlias = true
    }

    paths.forEach { points ->
        if (points.size > 1) {
            val path = android.graphics.Path()
            path.moveTo(points.first().x, points.first().y)
            for (i in 1 until points.size) {
                path.lineTo(points[i].x, points[i].y)
            }
            canvas.drawPath(path, paint)
        }
    }

    // 3. Compute bounding box of all stroke points
    var minX = Float.MAX_VALUE
    var minY = Float.MAX_VALUE
    var maxX = Float.MIN_VALUE
    var maxY = Float.MIN_VALUE

    paths.forEach { points ->
        points.forEach { offset ->
            if (offset.x < minX) minX = offset.x
            if (offset.y < minY) minY = offset.y
            if (offset.x > maxX) maxX = offset.x
            if (offset.y > maxY) maxY = offset.y
        }
    }

    // 4. Crop to bounding box with padding
    val cropLeft = (minX - CROP_PADDING_PX).coerceAtLeast(0f).toInt()
    val cropTop = (minY - CROP_PADDING_PX).coerceAtLeast(0f).toInt()
    val cropRight = (maxX + CROP_PADDING_PX).coerceAtMost(canvasWidth.toFloat()).toInt()
    val cropBottom = (maxY + CROP_PADDING_PX).coerceAtMost(canvasHeight.toFloat()).toInt()

    val cropWidth = (cropRight - cropLeft).coerceAtLeast(1)
    val cropHeight = (cropBottom - cropTop).coerceAtLeast(1)

    val croppedBitmap = Bitmap.createBitmap(bitmap, cropLeft, cropTop, cropWidth, cropHeight)

    // Recycle the full-size bitmap if it differs from the cropped one
    if (croppedBitmap !== bitmap) {
        bitmap.recycle()
    }

    // 5. Encode to base64 PNG
    val outputStream = ByteArrayOutputStream()
    croppedBitmap.compress(Bitmap.CompressFormat.PNG, PNG_QUALITY, outputStream)
    croppedBitmap.recycle()

    val byteArray = outputStream.toByteArray()
    return Base64.encodeToString(byteArray, Base64.NO_WRAP)
}

// =============================================================================
// Utility
// =============================================================================

/**
 * Converts a list of [Offset] points into a Compose [Path].
 */
private fun List<Offset>.toPath(): Path {
    return Path().apply {
        val first = this@toPath.first()
        moveTo(first.x, first.y)
        for (i in 1 until this@toPath.size) {
            lineTo(this@toPath[i].x, this@toPath[i].y)
        }
    }
}
