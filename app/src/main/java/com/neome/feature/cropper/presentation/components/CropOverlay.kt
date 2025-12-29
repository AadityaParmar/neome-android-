package com.neome.feature.cropper.presentation.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.*
import com.neome.feature.cropper.domain.model.CropRegion
import kotlin.math.min
import kotlin.math.sqrt

private enum class DragHandle {
    NONE,
    TOP_LEFT, TOP_RIGHT, BOTTOM_LEFT, BOTTOM_RIGHT,
    TOP_EDGE, BOTTOM_EDGE, LEFT_EDGE, RIGHT_EDGE,
    CENTER
}

@Composable
fun CropOverlay(
    cropRegion: CropRegion,
    onCropRegionChanged: (CropRegion) -> Unit,
    imageAspectRatio: Float,
    modifier: Modifier = Modifier,
    safePadding: Dp = 24.dp
) {
    val density = LocalDensity.current
    val safePaddingPx = with(density) { safePadding.toPx() }
    val cornerTouchRadius = with(density) { 56.dp.toPx() }
    val edgeTouchWidth = with(density) { 44.dp.toPx() }

    var canvasSize by remember { mutableStateOf(Size.Zero) }
    var activeHandle by remember { mutableStateOf(DragHandle.NONE) }

    // Use rememberUpdatedState to always access the latest cropRegion
    val currentCropRegion by rememberUpdatedState(cropRegion)

    // Calculate the actual image display bounds within the container
    // This matches ContentScale.Fit behavior
    val imageBounds = remember(canvasSize, safePaddingPx, imageAspectRatio) {
        if (canvasSize.width <= 0 || canvasSize.height <= 0 || imageAspectRatio <= 0) {
            Rect.Zero
        } else {
            val availableWidth = canvasSize.width - safePaddingPx * 2
            val availableHeight = canvasSize.height - safePaddingPx * 2

            if (availableWidth <= 0 || availableHeight <= 0) {
                Rect.Zero
            } else {
                val containerAspect = availableWidth / availableHeight

                val (imageWidth, imageHeight) = if (imageAspectRatio > containerAspect) {
                    // Image is wider than container - fit to width
                    availableWidth to (availableWidth / imageAspectRatio)
                } else {
                    // Image is taller than container - fit to height
                    (availableHeight * imageAspectRatio) to availableHeight
                }

                // Center the image bounds within the available area
                val offsetX = safePaddingPx + (availableWidth - imageWidth) / 2
                val offsetY = safePaddingPx + (availableHeight - imageHeight) / 2

                Rect(offsetX, offsetY, offsetX + imageWidth, offsetY + imageHeight)
            }
        }
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .onSizeChanged { canvasSize = it.toSize() }
            .pointerInput(imageBounds) {

                awaitEachGesture {

                    // 1. LOCK TO ONE POINTER
                    val down = awaitFirstDown()
                    val pointerId = down.id

                    // Always read the latest cropRegion via rememberUpdatedState
                    val cropRect = calculateCropRect(currentCropRegion, imageBounds)
                    activeHandle = detectHandle(
                        down.position,
                        cropRect,
                        cornerTouchRadius,
                        edgeTouchWidth
                    )

                    if (activeHandle == DragHandle.NONE) return@awaitEachGesture

                    down.consume()

                    var lastPosition = down.position
                    var currentRegion = currentCropRegion

                    // 2. CONTINUOUS DRAG LOOP
                    while (true) {
                        val event = awaitPointerEvent()
                        val change = event.changes.firstOrNull { it.id == pointerId } ?: break

                        if (!change.pressed) {
                            activeHandle = DragHandle.NONE
                            break
                        }

                        val delta = change.position - lastPosition
                        if (delta != Offset.Zero) {
                            val updated = applyDrag(
                                handle = activeHandle,
                                currentRegion = currentRegion,
                                dragDelta = delta,
                                contentArea = imageBounds
                            )
                            if (updated != null) {
                                currentRegion = updated
                                onCropRegionChanged(updated)
                            }
                        }

                        lastPosition = change.position
                        change.consume()
                    }
                }
            }
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            if (imageBounds == Rect.Zero) return@Canvas

            val rect = calculateCropRect(currentCropRegion, imageBounds)
            if (rect.width <= 0 || rect.height <= 0) return@Canvas

            drawOverlay(rect, imageBounds)
            drawCropBorder(rect)
            drawGridLines(rect)
            drawCornerHandles(rect)
            drawEdgeHandles(rect)
        }
    }
}

/* -------------------- CORE LOGIC -------------------- */

private fun calculateCropRect(region: CropRegion, area: Rect): Rect =
    Rect(
        area.left + region.left * area.width,
        area.top + region.top * area.height,
        area.left + region.right * area.width,
        area.top + region.bottom * area.height
    )

private fun detectHandle(
    point: Offset,
    rect: Rect,
    cornerRadius: Float,
    edgeWidth: Float
): DragHandle {

    val corners = listOf(
        DragHandle.TOP_LEFT to Offset(rect.left, rect.top),
        DragHandle.TOP_RIGHT to Offset(rect.right, rect.top),
        DragHandle.BOTTOM_LEFT to Offset(rect.left, rect.bottom),
        DragHandle.BOTTOM_RIGHT to Offset(rect.right, rect.bottom)
    )

    var closest: DragHandle = DragHandle.NONE
    var minDist = cornerRadius

    for ((handle, pos) in corners) {
        val d = distance(point, pos)
        if (d < minDist) {
            minDist = d
            closest = handle
        }
    }
    if (closest != DragHandle.NONE) return closest

    val half = edgeWidth / 2

    if (kotlin.math.abs(point.y - rect.top) <= half) return DragHandle.TOP_EDGE
    if (kotlin.math.abs(point.y - rect.bottom) <= half) return DragHandle.BOTTOM_EDGE
    if (kotlin.math.abs(point.x - rect.left) <= half) return DragHandle.LEFT_EDGE
    if (kotlin.math.abs(point.x - rect.right) <= half) return DragHandle.RIGHT_EDGE

    if (rect.contains(point)) return DragHandle.CENTER
    return DragHandle.NONE
}

private fun distance(a: Offset, b: Offset): Float {
    val dx = a.x - b.x
    val dy = a.y - b.y
    return sqrt(dx * dx + dy * dy)
}

private fun applyDrag(
    handle: DragHandle,
    currentRegion: CropRegion,
    dragDelta: Offset,
    contentArea: Rect
): CropRegion? {

    val dx = dragDelta.x / contentArea.width
    val dy = dragDelta.y / contentArea.height
    val minSize = 0.03f

    var l = currentRegion.left
    var t = currentRegion.top
    var r = currentRegion.right
    var b = currentRegion.bottom

    when (handle) {
        DragHandle.CENTER -> {
            val w = r - l
            val h = b - t
            l = (l + dx).coerceIn(0f, 1f - w)
            t = (t + dy).coerceIn(0f, 1f - h)
            r = l + w
            b = t + h
        }
        DragHandle.LEFT_EDGE -> l += dx
        DragHandle.RIGHT_EDGE -> r += dx
        DragHandle.TOP_EDGE -> t += dy
        DragHandle.BOTTOM_EDGE -> b += dy
        DragHandle.TOP_LEFT -> { l += dx; t += dy }
        DragHandle.TOP_RIGHT -> { r += dx; t += dy }
        DragHandle.BOTTOM_LEFT -> { l += dx; b += dy }
        DragHandle.BOTTOM_RIGHT -> { r += dx; b += dy }
        else -> return null
    }

    if (r - l < minSize || b - t < minSize) return null

    l = l.coerceIn(0f, 1f)
    t = t.coerceIn(0f, 1f)
    r = r.coerceIn(0f, 1f)
    b = b.coerceIn(0f, 1f)

    return CropRegion(l, t, r, b)
}

/* -------------------- DRAWING -------------------- */

private fun DrawScope.drawOverlay(cropRect: Rect, imageBounds: Rect) {
    val dimColor = Color.Black.copy(alpha = 0.6f)
    val fullDark = Color.Black

    // Draw fully dark areas outside image bounds
    // Top area (above image)
    if (imageBounds.top > 0) {
        drawRect(fullDark, Offset.Zero, Size(size.width, imageBounds.top))
    }
    // Bottom area (below image)
    if (imageBounds.bottom < size.height) {
        drawRect(fullDark, Offset(0f, imageBounds.bottom), Size(size.width, size.height - imageBounds.bottom))
    }
    // Left area (left of image, between top/bottom dark areas)
    if (imageBounds.left > 0) {
        drawRect(fullDark, Offset(0f, imageBounds.top), Size(imageBounds.left, imageBounds.height))
    }
    // Right area (right of image, between top/bottom dark areas)
    if (imageBounds.right < size.width) {
        drawRect(fullDark, Offset(imageBounds.right, imageBounds.top), Size(size.width - imageBounds.right, imageBounds.height))
    }

    // Draw semi-transparent overlay within image bounds but outside crop region
    // Top strip (within image, above crop)
    if (cropRect.top > imageBounds.top) {
        drawRect(dimColor, Offset(imageBounds.left, imageBounds.top), Size(imageBounds.width, cropRect.top - imageBounds.top))
    }
    // Bottom strip (within image, below crop)
    if (cropRect.bottom < imageBounds.bottom) {
        drawRect(dimColor, Offset(imageBounds.left, cropRect.bottom), Size(imageBounds.width, imageBounds.bottom - cropRect.bottom))
    }
    // Left strip (within image, left of crop, between top/bottom strips)
    if (cropRect.left > imageBounds.left) {
        drawRect(dimColor, Offset(imageBounds.left, cropRect.top), Size(cropRect.left - imageBounds.left, cropRect.height))
    }
    // Right strip (within image, right of crop, between top/bottom strips)
    if (cropRect.right < imageBounds.right) {
        drawRect(dimColor, Offset(cropRect.right, cropRect.top), Size(imageBounds.right - cropRect.right, cropRect.height))
    }
}

private fun DrawScope.drawCropBorder(rect: Rect) {
    drawRect(
        Color.White,
        Offset(rect.left, rect.top),
        Size(rect.width, rect.height),
        style = Stroke(2.dp.toPx())
    )
}

private fun DrawScope.drawGridLines(rect: Rect) {
    val w = rect.width / 3
    val h = rect.height / 3
    val c = Color.White.copy(alpha = 0.4f)

    for (i in 1..2) {
        drawLine(c, Offset(rect.left + w * i, rect.top), Offset(rect.left + w * i, rect.bottom))
        drawLine(c, Offset(rect.left, rect.top + h * i), Offset(rect.right, rect.top + h * i))
    }
}

private fun DrawScope.drawCornerHandles(rect: Rect) {
    val len = 28.dp.toPx()
    val stroke = 4.dp.toPx()

    fun corner(x1: Float, y1: Float, x2: Float, y2: Float, x3: Float, y3: Float) =
        drawPath(
            Path().apply {
                moveTo(x1, y1)
                lineTo(x2, y2)
                lineTo(x3, y3)
            },
            Color.White,
            style = Stroke(stroke)
        )

    corner(rect.left, rect.top + len, rect.left, rect.top, rect.left + len, rect.top)
    corner(rect.right - len, rect.top, rect.right, rect.top, rect.right, rect.top + len)
    corner(rect.left, rect.bottom - len, rect.left, rect.bottom, rect.left + len, rect.bottom)
    corner(rect.right - len, rect.bottom, rect.right, rect.bottom, rect.right, rect.bottom - len)
}

private fun DrawScope.drawEdgeHandles(rect: Rect) {
    val len = 32.dp.toPx()
    val stroke = 4.dp.toPx()

    drawLine(Color.White, Offset(rect.center.x - len / 2, rect.top), Offset(rect.center.x + len / 2, rect.top), stroke)
    drawLine(Color.White, Offset(rect.center.x - len / 2, rect.bottom), Offset(rect.center.x + len / 2, rect.bottom), stroke)
    drawLine(Color.White, Offset(rect.left, rect.center.y - len / 2), Offset(rect.left, rect.center.y + len / 2), stroke)
    drawLine(Color.White, Offset(rect.right, rect.center.y - len / 2), Offset(rect.right, rect.center.y + len / 2), stroke)
}
