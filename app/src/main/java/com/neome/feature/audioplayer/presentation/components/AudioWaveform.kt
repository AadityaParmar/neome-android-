package com.neome.feature.audioplayer.presentation.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlin.math.max

/**
 * Audio waveform visualization for player.
 * Shows played/unplayed portions based on progress.
 */
@Composable
fun AudioWaveform(
    waveformData: List<Float>,
    progress: Float,
    isPlaying: Boolean,
    modifier: Modifier = Modifier,
    playedColor: Color = MaterialTheme.colorScheme.primary,
    unplayedColor: Color = MaterialTheme.colorScheme.surfaceVariant,
    barCount: Int = 50,
    barWidth: Float = 4f,
    barSpacing: Float = 2f,
    cornerRadius: Float = 2f
) {
    val animatedAlpha by animateFloatAsState(
        targetValue = if (isPlaying) 1f else 0.7f,
        label = "waveform_alpha"
    )

    // Generate placeholder waveform if no data provided
    val displayData = remember(waveformData, barCount) {
        if (waveformData.isEmpty()) {
            // Generate placeholder waveform pattern
            List(barCount) { index ->
                val normalized = index.toFloat() / barCount
                val pattern = kotlin.math.sin(normalized * kotlin.math.PI * 4).toFloat()
                (0.3f + pattern * 0.2f).coerceIn(0.1f, 0.8f)
            }
        } else {
            // Resample waveform data to fit bar count
            resampleWaveform(waveformData, barCount)
        }
    }

    Canvas(
        modifier = modifier
            .fillMaxWidth()
            .height(80.dp)
    ) {
        val canvasWidth = size.width
        val canvasHeight = size.height
        val totalBarWidth = barWidth + barSpacing
        val actualBarCount = (canvasWidth / totalBarWidth).toInt().coerceAtMost(displayData.size)
        val startOffset = (canvasWidth - (actualBarCount * totalBarWidth)) / 2

        val progressBarIndex = (progress * actualBarCount).toInt()

        for (i in 0 until actualBarCount) {
            val dataIndex = (i.toFloat() / actualBarCount * displayData.size).toInt()
                .coerceIn(0, displayData.size - 1)
            val amplitude = displayData[dataIndex]
            val barHeight = max(4f, amplitude * canvasHeight * 0.8f)

            val x = startOffset + i * totalBarWidth
            val y = (canvasHeight - barHeight) / 2

            val color = if (i <= progressBarIndex) {
                playedColor.copy(alpha = animatedAlpha)
            } else {
                unplayedColor.copy(alpha = animatedAlpha * 0.6f)
            }

            drawRoundRect(
                color = color,
                topLeft = Offset(x, y),
                size = Size(barWidth, barHeight),
                cornerRadius = CornerRadius(cornerRadius, cornerRadius)
            )
        }
    }
}

/**
 * Resample waveform data to target size using linear interpolation.
 */
private fun resampleWaveform(data: List<Float>, targetSize: Int): List<Float> {
    if (data.isEmpty()) return List(targetSize) { 0.5f }
    if (data.size == targetSize) return data

    return List(targetSize) { index ->
        val sourceIndex = (index.toFloat() / targetSize * data.size).coerceIn(0f, (data.size - 1).toFloat())
        val lowerIndex = sourceIndex.toInt()
        val upperIndex = (lowerIndex + 1).coerceAtMost(data.size - 1)
        val fraction = sourceIndex - lowerIndex

        data[lowerIndex] * (1 - fraction) + data[upperIndex] * fraction
    }
}
