package com.neome.feature.camera.presentation.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.compose.ui.input.pointer.changedToUp
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import com.neome.feature.camera.domain.model.CropRegion
import kotlin.math.max
import kotlin.math.min
import kotlin.math.sqrt

/**
 * Drag handle types for crop interaction.
 */
private enum class DragHandle {
    NONE,
    TOP_LEFT, TOP_RIGHT, BOTTOM_LEFT, BOTTOM_RIGHT,
    TOP_EDGE, BOTTOM_EDGE, LEFT_EDGE, RIGHT_EDGE,
    CENTER
}

/**
 * Crop overlay with robust, intuitive drag gestures.
 *
 * Key features:
 * - Uses awaitEachGesture with Initial pass for highest priority gesture capture
 * - Very forgiving touch targets (56dp corners, 44dp edges) with overlapping areas
 * - Smooth movement without restrictive clamping
 * - Internal safe padding keeps handles away from screen edges
 * - Center drag works for entire interior of crop box
 * - All gestures consumed to prevent parent interference
 */
@Composable
fun CropOverlay(
    cropRegion: CropRegion,
    onCropRegionChanged: (CropRegion) -> Unit,
    modifier: Modifier = Modifier,
    safePadding: Dp = 24.dp
) {
    val density = LocalDensity.current

    // Convert dp values to pixels - generous touch targets
    val safePaddingPx = with(density) { safePadding.toPx() }
    val cornerTouchRadius = with(density) { 56.dp.toPx() }
    val edgeTouchWidth = with(density) { 44.dp.toPx() }

    var canvasSize by remember { mutableStateOf(Size.Zero) }
    var activeHandle by remember { mutableStateOf(DragHandle.NONE) }

    // Calculate content area with safe padding
    val contentArea = remember(canvasSize, safePaddingPx) {
        if (canvasSize.width > safePaddingPx * 2 && canvasSize.height > safePaddingPx * 2) {
            Rect(
                left = safePaddingPx,
                top = safePaddingPx,
                right = canvasSize.width - safePaddingPx,
                bottom = canvasSize.height - safePaddingPx
            )
        } else {
            Rect(0f, 0f, canvasSize.width, canvasSize.height)
        }
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .onSizeChanged { size: IntSize ->
                canvasSize = size.toSize()
            }
            // Use Initial pass for highest priority - capture before anything else
            .pointerInput(cropRegion, contentArea) {
                awaitEachGesture {
                    // Wait for first touch - don't require unconsumed
                    val down = awaitFirstDown(requireUnconsumed = false)

                    // Calculate current crop rect in pixels
                    val cropRect = calculateCropRect(cropRegion, contentArea)
                    if (cropRect.width <= 0 || cropRect.height <= 0) return@awaitEachGesture

                    // Detect which handle was touched with priority order
                    activeHandle = detectHandle(
                        touchPoint = down.position,
                        cropRect = cropRect,
                        cornerRadius = cornerTouchRadius,
                        edgeWidth = edgeTouchWidth
                    )

                    // If no handle detected, let parent handle the gesture
                    if (activeHandle == DragHandle.NONE) return@awaitEachGesture

                    // CONSUME the down event immediately to prevent parent gestures
                    down.consume()

                    // Track position for delta calculation
                    var lastPosition = down.position
                    var currentRegion = cropRegion

                    // Process drag events
                    while (true) {
                        val event = awaitPointerEvent(PointerEventPass.Initial)
                        val change = event.changes.firstOrNull() ?: break

                        // Consume immediately to block parent
                        change.consume()

                        if (change.changedToUp()) {
                            activeHandle = DragHandle.NONE
                            break
                        }

                        // Calculate drag delta
                        val dragDelta = change.position - lastPosition
                        if (dragDelta != Offset.Zero && contentArea.width > 0 && contentArea.height > 0) {
                            val newRegion = applyDrag(
                                handle = activeHandle,
                                currentRegion = currentRegion,
                                dragDelta = dragDelta,
                                contentArea = contentArea
                            )
                            if (newRegion != null) {
                                currentRegion = newRegion
                                onCropRegionChanged(newRegion)
                            }
                        }
                        lastPosition = change.position
                    }
                }
            }
    ) {
        // Drawing layer
        Canvas(modifier = Modifier.fillMaxSize()) {
            val cropRect = calculateCropRect(cropRegion, contentArea)
            if (cropRect.width <= 0 || cropRect.height <= 0) return@Canvas

            drawOverlay(cropRect)
            drawCropBorder(cropRect)
            drawGridLines(cropRect)
            drawCornerHandles(cropRect)
            drawEdgeHandles(cropRect)
        }
    }
}

/**
 * Backward compatibility overload - ignores aspectRatio parameter.
 */
@Composable
fun CropOverlay(
    cropRegion: CropRegion,
    aspectRatio: Float?,
    onCropRegionChanged: (CropRegion) -> Unit,
    modifier: Modifier = Modifier,
    safePadding: Dp = 24.dp
) {
    CropOverlay(
        cropRegion = cropRegion,
        onCropRegionChanged = onCropRegionChanged,
        modifier = modifier,
        safePadding = safePadding
    )
}

private fun calculateCropRect(cropRegion: CropRegion, contentArea: Rect): Rect {
    return Rect(
        left = contentArea.left + cropRegion.left * contentArea.width,
        top = contentArea.top + cropRegion.top * contentArea.height,
        right = contentArea.left + cropRegion.right * contentArea.width,
        bottom = contentArea.top + cropRegion.bottom * contentArea.height
    )
}

private fun detectHandle(
    touchPoint: Offset,
    cropRect: Rect,
    cornerRadius: Float,
    edgeWidth: Float
): DragHandle {
    // Priority 1: Check corners first - these have highest priority
    // Use distance-based detection for natural feel
    val corners = listOf(
        DragHandle.TOP_LEFT to Offset(cropRect.left, cropRect.top),
        DragHandle.TOP_RIGHT to Offset(cropRect.right, cropRect.top),
        DragHandle.BOTTOM_LEFT to Offset(cropRect.left, cropRect.bottom),
        DragHandle.BOTTOM_RIGHT to Offset(cropRect.right, cropRect.bottom)
    )

    // Find closest corner if within range
    var closestCorner: DragHandle = DragHandle.NONE
    var closestDist = cornerRadius
    for ((handle, corner) in corners) {
        val dist = distance(touchPoint, corner)
        if (dist < closestDist) {
            closestDist = dist
            closestCorner = handle
        }
    }
    if (closestCorner != DragHandle.NONE) {
        return closestCorner
    }

    // Priority 2: Check edges with generous hit areas (no gaps)
    val halfEdge = edgeWidth / 2

    // Calculate edge distances for priority detection
    val distToTop = kotlin.math.abs(touchPoint.y - cropRect.top)
    val distToBottom = kotlin.math.abs(touchPoint.y - cropRect.bottom)
    val distToLeft = kotlin.math.abs(touchPoint.x - cropRect.left)
    val distToRight = kotlin.math.abs(touchPoint.x - cropRect.right)

    // Top edge - extends full width, not blocked by corners
    val inTopEdge = distToTop <= halfEdge &&
            touchPoint.x >= cropRect.left - halfEdge &&
            touchPoint.x <= cropRect.right + halfEdge

    // Bottom edge
    val inBottomEdge = distToBottom <= halfEdge &&
            touchPoint.x >= cropRect.left - halfEdge &&
            touchPoint.x <= cropRect.right + halfEdge

    // Left edge
    val inLeftEdge = distToLeft <= halfEdge &&
            touchPoint.y >= cropRect.top - halfEdge &&
            touchPoint.y <= cropRect.bottom + halfEdge

    // Right edge
    val inRightEdge = distToRight <= halfEdge &&
            touchPoint.y >= cropRect.top - halfEdge &&
            touchPoint.y <= cropRect.bottom + halfEdge

    // If multiple edges match (near corner but outside corner radius),
    // pick the one with closest distance
    val edgeCandidates = mutableListOf<Pair<DragHandle, Float>>()
    if (inTopEdge) edgeCandidates.add(DragHandle.TOP_EDGE to distToTop)
    if (inBottomEdge) edgeCandidates.add(DragHandle.BOTTOM_EDGE to distToBottom)
    if (inLeftEdge) edgeCandidates.add(DragHandle.LEFT_EDGE to distToLeft)
    if (inRightEdge) edgeCandidates.add(DragHandle.RIGHT_EDGE to distToRight)

    if (edgeCandidates.isNotEmpty()) {
        return edgeCandidates.minByOrNull { it.second }!!.first
    }

    // Priority 3: Check if inside crop box (for moving entire box)
    // Use slightly expanded bounds for easier center drag activation
    val expandedRect = Rect(
        left = cropRect.left + halfEdge,
        top = cropRect.top + halfEdge,
        right = cropRect.right - halfEdge,
        bottom = cropRect.bottom - halfEdge
    )

    if (expandedRect.width > 0 && expandedRect.height > 0 && expandedRect.contains(touchPoint)) {
        return DragHandle.CENTER
    }

    // Also accept if strictly inside the crop rect
    if (cropRect.contains(touchPoint)) {
        return DragHandle.CENTER
    }

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
    if (contentArea.width <= 0 || contentArea.height <= 0) return null

    // Convert pixel delta to normalized delta
    val dx = dragDelta.x / contentArea.width
    val dy = dragDelta.y / contentArea.height

    // Minimum size (3% - very small to allow fine adjustments)
    val minSize = 0.03f

    var left = currentRegion.left
    var top = currentRegion.top
    var right = currentRegion.right
    var bottom = currentRegion.bottom

    when (handle) {
        DragHandle.TOP_LEFT -> {
            left += dx
            top += dy
        }
        DragHandle.TOP_RIGHT -> {
            right += dx
            top += dy
        }
        DragHandle.BOTTOM_LEFT -> {
            left += dx
            bottom += dy
        }
        DragHandle.BOTTOM_RIGHT -> {
            right += dx
            bottom += dy
        }
        DragHandle.TOP_EDGE -> {
            top += dy
        }
        DragHandle.BOTTOM_EDGE -> {
            bottom += dy
        }
        DragHandle.LEFT_EDGE -> {
            left += dx
        }
        DragHandle.RIGHT_EDGE -> {
            right += dx
        }
        DragHandle.CENTER -> {
            // Move entire crop box - smooth with boundary handling
            val width = right - left
            val height = bottom - top

            left += dx
            top += dy
            right = left + width
            bottom = top + height
        }
        DragHandle.NONE -> return null
    }

    // Apply constraints AFTER the delta, allowing smooth drag to boundaries
    // This prevents "sticking" by allowing continued drag along boundaries

    // Handle corner and edge resizing constraints
    when (handle) {
        DragHandle.TOP_LEFT, DragHandle.LEFT_EDGE -> {
            left = left.coerceIn(0f, right - minSize)
        }
        DragHandle.TOP_RIGHT, DragHandle.RIGHT_EDGE -> {
            right = right.coerceIn(left + minSize, 1f)
        }
        DragHandle.BOTTOM_LEFT -> {
            left = left.coerceIn(0f, right - minSize)
            bottom = bottom.coerceIn(top + minSize, 1f)
        }
        DragHandle.BOTTOM_RIGHT -> {
            right = right.coerceIn(left + minSize, 1f)
            bottom = bottom.coerceIn(top + minSize, 1f)
        }
        else -> {}
    }

    when (handle) {
        DragHandle.TOP_LEFT, DragHandle.TOP_RIGHT, DragHandle.TOP_EDGE -> {
            top = top.coerceIn(0f, bottom - minSize)
        }
        DragHandle.BOTTOM_EDGE -> {
            bottom = bottom.coerceIn(top + minSize, 1f)
        }
        else -> {}
    }

    // For center drag, clamp to keep entire box within bounds
    if (handle == DragHandle.CENTER) {
        val width = right - left
        val height = bottom - top

        // Clamp left/top, then recalculate right/bottom
        left = left.coerceIn(0f, 1f - width)
        top = top.coerceIn(0f, 1f - height)
        right = left + width
        bottom = top + height
    }

    // Final safety clamp for all values
    left = left.coerceIn(0f, 1f - minSize)
    top = top.coerceIn(0f, 1f - minSize)
    right = right.coerceIn(minSize, 1f)
    bottom = bottom.coerceIn(minSize, 1f)

    // Ensure minimum size is maintained
    if (right - left < minSize) {
        right = min(left + minSize, 1f)
        left = right - minSize
    }
    if (bottom - top < minSize) {
        bottom = min(top + minSize, 1f)
        top = bottom - minSize
    }

    // Final validation - ensure valid region
    if (left >= right || top >= bottom) return null
    if (left < 0f || top < 0f || right > 1f || bottom > 1f) return null

    return try {
        CropRegion(
            left = left,
            top = top,
            right = right,
            bottom = bottom
        )
    } catch (e: IllegalArgumentException) {
        // CropRegion's require statements failed - return null gracefully
        null
    }
}

// Drawing functions

private fun DrawScope.drawOverlay(cropRect: Rect) {
    val overlayColor = Color.Black.copy(alpha = 0.6f)

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
}

private fun DrawScope.drawCropBorder(cropRect: Rect) {
    drawRect(
        color = Color.White,
        topLeft = Offset(cropRect.left, cropRect.top),
        size = Size(cropRect.width, cropRect.height),
        style = Stroke(width = 2.dp.toPx())
    )
}

private fun DrawScope.drawGridLines(cropRect: Rect) {
    val thirdW = cropRect.width / 3
    val thirdH = cropRect.height / 3
    val lineColor = Color.White.copy(alpha = 0.4f)

    for (i in 1..2) {
        // Vertical
        drawLine(
            color = lineColor,
            start = Offset(cropRect.left + thirdW * i, cropRect.top),
            end = Offset(cropRect.left + thirdW * i, cropRect.bottom),
            strokeWidth = 1.dp.toPx()
        )
        // Horizontal
        drawLine(
            color = lineColor,
            start = Offset(cropRect.left, cropRect.top + thirdH * i),
            end = Offset(cropRect.right, cropRect.top + thirdH * i),
            strokeWidth = 1.dp.toPx()
        )
    }
}

private fun DrawScope.drawCornerHandles(cropRect: Rect) {
    val handleLen = 28.dp.toPx()
    val stroke = 4.dp.toPx()

    // Top-left
    drawPath(
        path = Path().apply {
            moveTo(cropRect.left, cropRect.top + handleLen)
            lineTo(cropRect.left, cropRect.top)
            lineTo(cropRect.left + handleLen, cropRect.top)
        },
        color = Color.White,
        style = Stroke(width = stroke)
    )

    // Top-right
    drawPath(
        path = Path().apply {
            moveTo(cropRect.right - handleLen, cropRect.top)
            lineTo(cropRect.right, cropRect.top)
            lineTo(cropRect.right, cropRect.top + handleLen)
        },
        color = Color.White,
        style = Stroke(width = stroke)
    )

    // Bottom-left
    drawPath(
        path = Path().apply {
            moveTo(cropRect.left, cropRect.bottom - handleLen)
            lineTo(cropRect.left, cropRect.bottom)
            lineTo(cropRect.left + handleLen, cropRect.bottom)
        },
        color = Color.White,
        style = Stroke(width = stroke)
    )

    // Bottom-right
    drawPath(
        path = Path().apply {
            moveTo(cropRect.right - handleLen, cropRect.bottom)
            lineTo(cropRect.right, cropRect.bottom)
            lineTo(cropRect.right, cropRect.bottom - handleLen)
        },
        color = Color.White,
        style = Stroke(width = stroke)
    )
}

private fun DrawScope.drawEdgeHandles(cropRect: Rect) {
    val handleLen = 32.dp.toPx()
    val stroke = 4.dp.toPx()

    // Top center
    drawLine(
        color = Color.White,
        start = Offset(cropRect.center.x - handleLen / 2, cropRect.top),
        end = Offset(cropRect.center.x + handleLen / 2, cropRect.top),
        strokeWidth = stroke
    )
    // Bottom center
    drawLine(
        color = Color.White,
        start = Offset(cropRect.center.x - handleLen / 2, cropRect.bottom),
        end = Offset(cropRect.center.x + handleLen / 2, cropRect.bottom),
        strokeWidth = stroke
    )
    // Left center
    drawLine(
        color = Color.White,
        start = Offset(cropRect.left, cropRect.center.y - handleLen / 2),
        end = Offset(cropRect.left, cropRect.center.y + handleLen / 2),
        strokeWidth = stroke
    )
    // Right center
    drawLine(
        color = Color.White,
        start = Offset(cropRect.right, cropRect.center.y - handleLen / 2),
        end = Offset(cropRect.right, cropRect.center.y + handleLen / 2),
        strokeWidth = stroke
    )
}
