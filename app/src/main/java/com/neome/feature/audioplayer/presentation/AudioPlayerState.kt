package com.neome.feature.audioplayer.presentation

import android.net.Uri
import com.neome.feature.audioplayer.domain.model.AudioPlaybackState
import com.neome.feature.audioplayer.domain.model.PlayerError

/**
 * Immutable state for audio player screen.
 */
data class AudioPlayerState(
    val audioUri: Uri? = null,
    val audioName: String = "",
    val playbackState: AudioPlaybackState = AudioPlaybackState.IDLE,
    val currentPositionMs: Long = 0L,
    val durationMs: Long = 0L,
    val isMuted: Boolean = false,
    val playbackSpeed: Float = 1.0f,
    val waveformData: List<Float> = emptyList(),
    val error: PlayerError? = null
) {
    val isPlaying: Boolean get() = playbackState == AudioPlaybackState.PLAYING
    val isPaused: Boolean get() = playbackState == AudioPlaybackState.PAUSED
    val isLoading: Boolean get() = playbackState == AudioPlaybackState.LOADING
    val isReady: Boolean get() = playbackState == AudioPlaybackState.READY
    val isCompleted: Boolean get() = playbackState == AudioPlaybackState.COMPLETED
    val hasError: Boolean get() = playbackState == AudioPlaybackState.ERROR

    val progress: Float
        get() = if (durationMs > 0) {
            (currentPositionMs.toFloat() / durationMs).coerceIn(0f, 1f)
        } else 0f

    val formattedCurrentTime: String
        get() {
            val seconds = (currentPositionMs / 1000) % 60
            val minutes = (currentPositionMs / 1000) / 60
            return "%02d:%02d".format(minutes, seconds)
        }

    val formattedDuration: String
        get() {
            val seconds = (durationMs / 1000) % 60
            val minutes = (durationMs / 1000) / 60
            return "%02d:%02d".format(minutes, seconds)
        }

    val canPlay: Boolean get() = playbackState in listOf(
        AudioPlaybackState.READY,
        AudioPlaybackState.PAUSED,
        AudioPlaybackState.COMPLETED
    )

    val canPause: Boolean get() = playbackState == AudioPlaybackState.PLAYING

    val canSeek: Boolean get() = playbackState in listOf(
        AudioPlaybackState.READY,
        AudioPlaybackState.PLAYING,
        AudioPlaybackState.PAUSED,
        AudioPlaybackState.COMPLETED
    )
}
