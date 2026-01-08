package com.neome.feature.audioplayer.domain.model

/**
 * Playback state enumeration for audio player.
 */
enum class AudioPlaybackState {
    /** Not loaded */
    IDLE,
    /** Loading audio */
    LOADING,
    /** Loaded, ready to play */
    READY,
    /** Currently playing */
    PLAYING,
    /** Paused */
    PAUSED,
    /** Playback completed */
    COMPLETED,
    /** Error state */
    ERROR
}
