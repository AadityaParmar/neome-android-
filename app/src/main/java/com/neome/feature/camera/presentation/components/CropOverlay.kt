package com.neome.feature.camera.presentation.components

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
import com.neome.feature.camera.domain.model.CropRegion
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
    modifier: Modifier = Modifier,
    safePadding: Dp = 24.dp
) {
    val density = LocalDensity.current
    val safePaddingPx = with(density) { safePadding.toPx() }
    val cornerTouchRadius = with(density) { 56.dp.toPx() }
    val edgeTouchWidth = with(density) { 44.dp.toPx() }

    var canvasSize by remember { mutableStateOf(Size.Zero) }
    var activeHandle by remember { mutableStateOf(DragHandle.NONE) }

    val contentArea = remember(canvasSize, safePaddingPx) {
        if (canvasSize.width > safePaddingPx * 2 && canvasSize.height > safePaddingPx * 2) {
            Rect(
                safePaddingPx,
                safePaddingPx,
                canvasSize.width - safePaddingPx,
                canvasSize.height - safePaddingPx
            )
        } else {
            Rect(0f, 0f, canvasSize.width, canvasSize.height)
        }
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .onSizeChanged { canvasSize = it.toSize() }
            .pointerInput(contentArea) {

                awaitEachGesture {

                    // 1️⃣ LOCK TO ONE POINTER
                    val down = awaitFirstDown()
                    val pointerId = down.id

                    val cropRect = calculateCropRect(cropRegion, contentArea)
                    activeHandle = detectHandle(
                        down.position,
                        cropRect,
                        cornerTouchRadius,
                        edgeTouchWidth
                    )

                    if (activeHandle == DragHandle.NONE) return@awaitEachGesture

                    down.consume()

                    var lastPosition = down.position
                    var currentRegion = cropRegion

                    // 2️⃣ CONTINUOUS DRAG LOOP
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
                                contentArea = contentArea
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
            val rect = calculateCropRect(cropRegion, contentArea)
            if (rect.width <= 0 || rect.height <= 0) return@Canvas

            drawOverlay(rect)
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

private fun DrawScope.drawOverlay(rect: Rect) {
    val c = Color.Black.copy(alpha = 0.6f)
    drawRect(c, Offset.Zero, Size(size.width, rect.top))
    drawRect(c, Offset(0f, rect.bottom), Size(size.width, size.height - rect.bottom))
    drawRect(c, Offset(0f, rect.top), Size(rect.left, rect.height))
    drawRect(c, Offset(rect.right, rect.top), Size(size.width - rect.right, rect.height))
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
