package com.neome.feature.camera.presentation.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import com.neome.feature.camera.domain.model.CropRegion
import kotlin.math.max
import kotlin.math.min

private enum class DragHandle {
    NONE, TOP_LEFT, TOP_RIGHT, BOTTOM_LEFT, BOTTOM_RIGHT, CENTER
}

/**
 * Crop overlay with draggable handles.
 */
@Composable
fun CropOverlay(
    cropRegion: CropRegion,
    aspectRatio: Float?,
    onCropRegionChanged: (CropRegion) -> Unit,
    modifier: Modifier = Modifier
) {
    var currentHandle by remember { mutableStateOf(DragHandle.NONE) }
    var canvasSize by remember { mutableStateOf(Size.Zero) }

    // Convert normalized crop region to pixel coordinates
    val cropRect = remember(cropRegion, canvasSize) {
        Rect(
            left = cropRegion.left * canvasSize.width,
            top = cropRegion.top * canvasSize.height,
            right = cropRegion.right * canvasSize.width,
            bottom = cropRegion.bottom * canvasSize.height
        )
    }

    Canvas(
        modifier = modifier
            .fillMaxSize()
            .pointerInput(aspectRatio) {
                detectDragGestures(
                    onDragStart = { offset ->
                        currentHandle = detectHandle(offset, cropRect)
                    },
                    onDragEnd = {
                        currentHandle = DragHandle.NONE
                    },
                    onDrag = { change, dragAmount ->
                        change.consume()

                        val newRegion = calculateNewCropRegion(
                            currentHandle = currentHandle,
                            currentRegion = cropRegion,
                            dragAmount = dragAmount,
                            canvasSize = canvasSize,
                            aspectRatio = aspectRatio
                        )

                        if (newRegion != null) {
                            onCropRegionChanged(newRegion)
                        }
                    }
                )
            }
    ) {
        canvasSize = size

        // Draw semi-transparent overlay outside crop region
        val overlayColor = Color.Black.copy(alpha = 0.5f)

        // Top
        drawRect(
            color = overlayColor,
            topLeft = Offset.Zero,
            size = Size(size.width, cropRect.top)
        )

        // Bottom
        drawRect(
            color = overlayColor,
            topLeft = Offset(0f, cropRect.bottom),
            size = Size(size.width, size.height - cropRect.bottom)
        )

        // Left
        drawRect(
            color = overlayColor,
            topLeft = Offset(0f, cropRect.top),
            size = Size(cropRect.left, cropRect.height)
        )

        // Right
        drawRect(
            color = overlayColor,
            topLeft = Offset(cropRect.right, cropRect.top),
            size = Size(size.width - cropRect.right, cropRect.height)
        )

        // Draw crop border
        drawRect(
            color = Color.White,
            topLeft = Offset(cropRect.left, cropRect.top),
            size = Size(cropRect.width, cropRect.height),
            style = Stroke(width = 2.dp.toPx())
        )

        // Draw grid lines (rule of thirds)
        val thirdWidth = cropRect.width / 3
        val thirdHeight = cropRect.height / 3

        // Vertical lines
        for (i in 1..2) {
            drawLine(
                color = Color.White.copy(alpha = 0.5f),
                start = Offset(cropRect.left + thirdWidth * i, cropRect.top),
                end = Offset(cropRect.left + thirdWidth * i, cropRect.bottom),
                strokeWidth = 1.dp.toPx()
            )
        }

        // Horizontal lines
        for (i in 1..2) {
            drawLine(
                color = Color.White.copy(alpha = 0.5f),
                start = Offset(cropRect.left, cropRect.top + thirdHeight * i),
                end = Offset(cropRect.right, cropRect.top + thirdHeight * i),
                strokeWidth = 1.dp.toPx()
            )
        }

        // Draw corner handles
        val handleSize = 24.dp.toPx()
        val handleStroke = 4.dp.toPx()

        // Top-left corner
        drawCornerHandle(
            center = Offset(cropRect.left, cropRect.top),
            handleSize = handleSize,
            strokeWidth = handleStroke,
            isTopLeft = true,
            isTopRight = false,
            isBottomLeft = false,
            isBottomRight = false
        )

        // Top-right corner
        drawCornerHandle(
            center = Offset(cropRect.right, cropRect.top),
            handleSize = handleSize,
            strokeWidth = handleStroke,
            isTopLeft = false,
            isTopRight = true,
            isBottomLeft = false,
            isBottomRight = false
        )

        // Bottom-left corner
        drawCornerHandle(
            center = Offset(cropRect.left, cropRect.bottom),
            handleSize = handleSize,
            strokeWidth = handleStroke,
            isTopLeft = false,
            isTopRight = false,
            isBottomLeft = true,
            isBottomRight = false
        )

        // Bottom-right corner
        drawCornerHandle(
            center = Offset(cropRect.right, cropRect.bottom),
            handleSize = handleSize,
            strokeWidth = handleStroke,
            isTopLeft = false,
            isTopRight = false,
            isBottomLeft = false,
            isBottomRight = true
        )
    }
}

private fun androidx.compose.ui.graphics.drawscope.DrawScope.drawCornerHandle(
    center: Offset,
    handleSize: Float,
    strokeWidth: Float,
    isTopLeft: Boolean,
    isTopRight: Boolean,
    isBottomLeft: Boolean,
    isBottomRight: Boolean
) {
    val path = Path()

    when {
        isTopLeft -> {
            path.moveTo(center.x, center.y + handleSize)
            path.lineTo(center.x, center.y)
            path.lineTo(center.x + handleSize, center.y)
        }
        isTopRight -> {
            path.moveTo(center.x - handleSize, center.y)
            path.lineTo(center.x, center.y)
            path.lineTo(center.x, center.y + handleSize)
        }
        isBottomLeft -> {
            path.moveTo(center.x, center.y - handleSize)
            path.lineTo(center.x, center.y)
            path.lineTo(center.x + handleSize, center.y)
        }
        isBottomRight -> {
            path.moveTo(center.x - handleSize, center.y)
            path.lineTo(center.x, center.y)
            path.lineTo(center.x, center.y - handleSize)
        }
    }

    drawPath(
        path = path,
        color = Color.White,
        style = Stroke(width = strokeWidth)
    )
}

private fun detectHandle(offset: Offset, cropRect: Rect): DragHandle {
    val touchRadius = 48f

    return when {
        offset.distanceTo(Offset(cropRect.left, cropRect.top)) < touchRadius -> DragHandle.TOP_LEFT
        offset.distanceTo(Offset(cropRect.right, cropRect.top)) < touchRadius -> DragHandle.TOP_RIGHT
        offset.distanceTo(Offset(cropRect.left, cropRect.bottom)) < touchRadius -> DragHandle.BOTTOM_LEFT
        offset.distanceTo(Offset(cropRect.right, cropRect.bottom)) < touchRadius -> DragHandle.BOTTOM_RIGHT
        cropRect.contains(offset) -> DragHandle.CENTER
        else -> DragHandle.NONE
    }
}

private fun Offset.distanceTo(other: Offset): Float {
    val dx = x - other.x
    val dy = y - other.y
    return kotlin.math.sqrt(dx * dx + dy * dy)
}

private fun calculateNewCropRegion(
    currentHandle: DragHandle,
    currentRegion: CropRegion,
    dragAmount: Offset,
    canvasSize: Size,
    aspectRatio: Float?
): CropRegion? {
    if (canvasSize.width == 0f || canvasSize.height == 0f) return null

    val deltaX = dragAmount.x / canvasSize.width
    val deltaY = dragAmount.y / canvasSize.height

    val minSize = 0.1f // Minimum 10% of the image

    var newLeft = currentRegion.left
    var newTop = currentRegion.top
    var newRight = currentRegion.right
    var newBottom = currentRegion.bottom

    when (currentHandle) {
        DragHandle.TOP_LEFT -> {
            newLeft = (currentRegion.left + deltaX).coerceIn(0f, currentRegion.right - minSize)
            newTop = (currentRegion.top + deltaY).coerceIn(0f, currentRegion.bottom - minSize)
        }
        DragHandle.TOP_RIGHT -> {
            newRight = (currentRegion.right + deltaX).coerceIn(currentRegion.left + minSize, 1f)
            newTop = (currentRegion.top + deltaY).coerceIn(0f, currentRegion.bottom - minSize)
        }
        DragHandle.BOTTOM_LEFT -> {
            newLeft = (currentRegion.left + deltaX).coerceIn(0f, currentRegion.right - minSize)
            newBottom = (currentRegion.bottom + deltaY).coerceIn(currentRegion.top + minSize, 1f)
        }
        DragHandle.BOTTOM_RIGHT -> {
            newRight = (currentRegion.right + deltaX).coerceIn(currentRegion.left + minSize, 1f)
            newBottom = (currentRegion.bottom + deltaY).coerceIn(currentRegion.top + minSize, 1f)
        }
        DragHandle.CENTER -> {
            val width = currentRegion.right - currentRegion.left
            val height = currentRegion.bottom - currentRegion.top

            newLeft = (currentRegion.left + deltaX).coerceIn(0f, 1f - width)
            newTop = (currentRegion.top + deltaY).coerceIn(0f, 1f - height)
            newRight = newLeft + width
            newBottom = newTop + height
        }
        DragHandle.NONE -> return null
    }

    // Apply aspect ratio constraint if specified
    if (aspectRatio != null && currentHandle != DragHandle.CENTER) {
        val currentWidth = newRight - newLeft
        val currentHeight = newBottom - newTop
        val currentRatio = currentWidth / currentHeight

        if (currentRatio > aspectRatio) {
            // Too wide, adjust width
            val targetWidth = currentHeight * aspectRatio
            when (currentHandle) {
                DragHandle.TOP_LEFT, DragHandle.BOTTOM_LEFT -> {
                    newLeft = newRight - targetWidth
                }
                DragHandle.TOP_RIGHT, DragHandle.BOTTOM_RIGHT -> {
                    newRight = newLeft + targetWidth
                }
                else -> {}
            }
        } else {
            // Too tall, adjust height
            val targetHeight = currentWidth / aspectRatio
            when (currentHandle) {
                DragHandle.TOP_LEFT, DragHandle.TOP_RIGHT -> {
                    newTop = newBottom - targetHeight
                }
                DragHandle.BOTTOM_LEFT, DragHandle.BOTTOM_RIGHT -> {
                    newBottom = newTop + targetHeight
                }
                else -> {}
            }
        }
    }

    return try {
        CropRegion(
            left = newLeft.coerceIn(0f, 1f),
            top = newTop.coerceIn(0f, 1f),
            right = newRight.coerceIn(0f, 1f),
            bottom = newBottom.coerceIn(0f, 1f)
        )
    } catch (e: IllegalArgumentException) {
        null
    }
}
