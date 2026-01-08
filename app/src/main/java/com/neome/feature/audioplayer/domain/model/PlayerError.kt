package com.neome.feature.audioplayer.domain.model

/**
 * Sealed interface for audio player errors.
 */
sealed interface PlayerError {
    val message: String

    /** Failed to load audio file */
    data class LoadFailed(
        override val message: String = "Failed to load audio file"
    ) : PlayerError

    /** Error during playback */
    data class PlaybackFailed(
        override val message: String = "Playback error occurred"
    ) : PlayerError

    /** Audio format not supported */
    data class UnsupportedFormat(
        override val message: String = "Audio format not supported"
    ) : PlayerError
}
