package com.neome.feature.audioplayer.presentation

/**
 * Sealed interface for audio player one-time side effects.
 */
sealed interface AudioPlayerEffect {
    /** Playback finished */
    data object PlaybackCompleted : AudioPlayerEffect

    /** Error occurred */
    data class Error(val message: String) : AudioPlayerEffect
}
