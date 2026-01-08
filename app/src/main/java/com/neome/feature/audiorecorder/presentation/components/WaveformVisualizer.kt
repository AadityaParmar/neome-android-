package com.neome.feature.audiorecorder.presentation.components

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap

/**
 * Real-time audio waveform visualization using Canvas.
 */
@Composable
fun WaveformVisualizer(
    amplitudes: List<Float>,
    isRecording: Boolean,
    modifier: Modifier = Modifier,
    barColor: Color = MaterialTheme.colorScheme.primary,
    inactiveColor: Color = MaterialTheme.colorScheme.outlineVariant
) {
    val infiniteTransition = rememberInfiniteTransition(label = "waveform")
    val animatedAlpha by infiniteTransition.animateFloat(
        initialValue = 0.6f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(300),
            repeatMode = RepeatMode.Reverse
        ),
        label = "alpha"
    )

    Canvas(modifier = modifier.fillMaxSize()) {
        val barWidth = 4f
        val gap = 3f
        val totalBars = ((size.width) / (barWidth + gap)).toInt()
        val centerY = size.height / 2

        if (isRecording && amplitudes.isNotEmpty()) {
            val displayAmplitudes = if (amplitudes.size >= totalBars) {
                amplitudes.takeLast(totalBars)
            } else {
                List(totalBars - amplitudes.size) { 0f } + amplitudes
            }

            displayAmplitudes.forEachIndexed { index, amplitude ->
                val barHeight = (amplitude * size.height * 0.8f).coerceAtLeast(4f)
                val x = index * (barWidth + gap)

                drawLine(
                    color = barColor.copy(alpha = animatedAlpha),
                    start = Offset(x, centerY - barHeight / 2),
                    end = Offset(x, centerY + barHeight / 2),
                    strokeWidth = barWidth,
                    cap = StrokeCap.Round
                )
            }
        } else {
            // Static placeholder bars
            repeat(totalBars) { index ->
                val x = index * (barWidth + gap)
                drawLine(
                    color = inactiveColor,
                    start = Offset(x, centerY - 2f),
                    end = Offset(x, centerY + 2f),
                    strokeWidth = barWidth,
                    cap = StrokeCap.Round
                )
            }
        }
    }
}
