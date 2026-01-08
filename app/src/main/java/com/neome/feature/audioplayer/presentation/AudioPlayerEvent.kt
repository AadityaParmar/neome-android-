package com.neome.feature.audioplayer.presentation

import android.net.Uri

/**
 * Sealed interface for audio player user actions.
 */
sealed interface AudioPlayerEvent {
    /** Load audio from URI */
    data class LoadAudio(val uri: Uri, val name: String = "") : AudioPlayerEvent

    /** Load audio from byte array (e.g., from RecordedAudio) */
    data class LoadFromBytes(
        val bytes: ByteArray,
        val name: String = "Recording",
        val mimeType: String = "audio/wav"
    ) : AudioPlayerEvent {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false
            other as LoadFromBytes
            return bytes.contentEquals(other.bytes) && name == other.name && mimeType == other.mimeType
        }
        override fun hashCode(): Int {
            var result = bytes.contentHashCode()
            result = 31 * result + name.hashCode()
            result = 31 * result + mimeType.hashCode()
            return result
        }
    }

    /** Start/resume playback */
    data object Play : AudioPlayerEvent

    /** Pause playback */
    data object Pause : AudioPlayerEvent

    /** Stop and reset */
    data object Stop : AudioPlayerEvent

    /** Seek to specific position in milliseconds */
    data class SeekTo(val positionMs: Long) : AudioPlayerEvent

    /** Seek to progress percentage (0-1) */
    data class SeekToProgress(val progress: Float) : AudioPlayerEvent

    /** Toggle mute state */
    data object ToggleMute : AudioPlayerEvent

    /** Set playback speed */
    data class SetPlaybackSpeed(val speed: Float) : AudioPlayerEvent

    /** Restart from beginning */
    data object Replay : AudioPlayerEvent

    /** Skip forward 10 seconds */
    data object Forward10Seconds : AudioPlayerEvent

    /** Skip backward 10 seconds */
    data object Rewind10Seconds : AudioPlayerEvent

    /** Clear current error */
    data object ClearError : AudioPlayerEvent

    /** Release player resources */
    data object Release : AudioPlayerEvent
}
