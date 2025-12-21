package com.neome.feature.camera.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

/**
 * Represents a corner position for crop handles.
 */
enum class HandlePosition {
    TOP_LEFT,
    TOP_RIGHT,
    BOTTOM_LEFT,
    BOTTOM_RIGHT
}

/**
 * A draggable handle for crop region corners.
 * Provides a larger touch target for accessibility (48dp minimum).
 */
@Composable
fun CropHandle(
    position: HandlePosition,
    offsetX: Float,
    offsetY: Float,
    onDrag: (Offset) -> Unit,
    modifier: Modifier = Modifier,
    handleSize: Dp = 24.dp,
    touchTargetSize: Dp = 48.dp,
    handleColor: Color = Color.White
) {
    Box(
        modifier = modifier
            .offset { IntOffset(offsetX.roundToInt(), offsetY.roundToInt()) }
            .size(touchTargetSize)
            .pointerInput(Unit) {
                detectDragGestures { change, dragAmount ->
                    change.consume()
                    onDrag(dragAmount)
                }
            }
    ) {
        // Visual handle (smaller than touch target)
        Box(
            modifier = Modifier
                .size(handleSize)
                .background(handleColor, CircleShape)
        )
    }
}

/**
 * Container for all four crop handles.
 * Positions handles at the corners of the crop region.
 */
@Composable
fun CropHandlesContainer(
    cropLeft: Float,
    cropTop: Float,
    cropRight: Float,
    cropBottom: Float,
    onHandleDrag: (HandlePosition, Offset) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        // Top-left handle
        CropHandle(
            position = HandlePosition.TOP_LEFT,
            offsetX = cropLeft - 24f,
            offsetY = cropTop - 24f,
            onDrag = { offset -> onHandleDrag(HandlePosition.TOP_LEFT, offset) }
        )

        // Top-right handle
        CropHandle(
            position = HandlePosition.TOP_RIGHT,
            offsetX = cropRight - 24f,
            offsetY = cropTop - 24f,
            onDrag = { offset -> onHandleDrag(HandlePosition.TOP_RIGHT, offset) }
        )

        // Bottom-left handle
        CropHandle(
            position = HandlePosition.BOTTOM_LEFT,
            offsetX = cropLeft - 24f,
            offsetY = cropBottom - 24f,
            onDrag = { offset -> onHandleDrag(HandlePosition.BOTTOM_LEFT, offset) }
        )

        // Bottom-right handle
        CropHandle(
            position = HandlePosition.BOTTOM_RIGHT,
            offsetX = cropRight - 24f,
            offsetY = cropBottom - 24f,
            onDrag = { offset -> onHandleDrag(HandlePosition.BOTTOM_RIGHT, offset) }
        )
    }
}
