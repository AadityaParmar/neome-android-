package com.neome.feature.audiorecorder.presentation

import androidx.compose.runtime.Immutable
import com.neome.feature.audiorecorder.domain.model.RecorderError
import com.neome.feature.audiorecorder.domain.model.RecordingConfig

/**
 * Recording status enumeration.
 */
enum class RecordingStatus {
    IDLE,
    RECORDING,
    PAUSED,
    PROCESSING
}

/**
 * Immutable state for audio recorder screen.
 */
@Immutable
data class AudioRecorderState(
    val status: RecordingStatus = RecordingStatus.IDLE,
    val elapsedTimeMs: Long = 0L,
    val amplitudes: List<Float> = emptyList(),
    val config: RecordingConfig = RecordingConfig(),
    val hasPermission: Boolean = false,
    val error: RecorderError? = null
) {
    val isRecording: Boolean get() = status == RecordingStatus.RECORDING
    val isPaused: Boolean get() = status == RecordingStatus.PAUSED
    val isProcessing: Boolean get() = status == RecordingStatus.PROCESSING
    val isIdle: Boolean get() = status == RecordingStatus.IDLE

    val canRecord: Boolean get() = hasPermission && status == RecordingStatus.IDLE
    val canPause: Boolean get() = status == RecordingStatus.RECORDING
    val canResume: Boolean get() = status == RecordingStatus.PAUSED
    val canStop: Boolean get() = status in listOf(RecordingStatus.RECORDING, RecordingStatus.PAUSED)

    val formattedTime: String
        get() {
            val seconds = (elapsedTimeMs / 1000) % 60
            val minutes = (elapsedTimeMs / 1000) / 60
            return "%02d:%02d".format(minutes, seconds)
        }

    val progressPercent: Float
        get() = if (config.maxDurationMs > 0) {
            (elapsedTimeMs.toFloat() / config.maxDurationMs).coerceIn(0f, 1f)
        } else 0f
}
