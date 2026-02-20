package com.neome.feature.form.presentation.components.field

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
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

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
 * |                 Done     |
 * ---------------------------
 * ```
 *
 * The canvas tracks touch/drag gestures and renders freeform strokes.
 * Actual bitmap export and value persistence are deferred to a future
 * implementation — this is currently UI-only.
 *
 * @param onDismiss Called when the user presses back arrow or system back
 * @param onConfirm Called when the user taps "Done"
 */
@Composable
fun SignatureDrawDialog(
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
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
 * Stateless content layout for the signature draw dialog.
 *
 * Manages drawing state (strokes) internally since it is transient
 * UI state that does not outlive the dialog.
 */
@Composable
private fun SignatureDrawContent(
    onBackClick: () -> Unit,
    onDoneClick: () -> Unit
) {
    // Drawing state — transient, lives only while the dialog is open
    var completedPaths by remember { mutableStateOf(listOf<List<Offset>>()) }
    var currentPath by remember { mutableStateOf(listOf<Offset>()) }

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
            modifier = Modifier.weight(1f)
        )

        // Bottom bar
        SignatureBottomBar(
            onClearClick = {
                completedPaths = emptyList()
                currentPath = emptyList()
            },
            onDoneClick = onDoneClick
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
 * @param modifier Modifier for sizing (use weight(1f) to fill available space)
 */
@Composable
private fun SignatureCanvas(
    completedPaths: List<List<Offset>>,
    currentPath: List<Offset>,
    onDragStart: (Offset) -> Unit,
    onDrag: (Offset) -> Unit,
    onDragEnd: () -> Unit,
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
                width = 3.dp.toPx(),
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
// Utility
// =============================================================================

/**
 * Converts a list of [Offset] points into a smooth [Path].
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
