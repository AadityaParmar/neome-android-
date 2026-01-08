package com.neome.feature.audiorecorder.domain.model

/**
 * Configuration for audio recording.
 * Uses WAV format with PCM encoding.
 */
data class RecordingConfig(
    val sampleRate: Int = 44100,
    val channels: Int = 1,
    val bitsPerSample: Int = 16,
    val maxDurationMs: Long = 5 * 60 * 1000L
) {
    companion object {
        val DEFAULT = RecordingConfig()

        val HIGH_QUALITY = RecordingConfig(
            sampleRate = 44100,
            channels = 2,
            bitsPerSample = 16
        )

        val LOW_QUALITY = RecordingConfig(
            sampleRate = 22050,
            channels = 1,
            bitsPerSample = 16
        )
    }
}
