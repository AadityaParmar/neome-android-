package com.neome.feature.audiorecorder.domain.model

/**
 * Represents a recorded audio file with raw bytes and metadata.
 * Returned from audio recording, passed to player/storage.
 */
data class RecordedAudio(
    val bytes: ByteArray,
    val durationMs: Long,
    val sampleRate: Int = 44100,
    val channels: Int = 1,
    val bitsPerSample: Int = 16,
    val mimeType: String = "audio/wav",
    val timestamp: Long = System.currentTimeMillis()
) {
    val fileSizeBytes: Int get() = bytes.size

    val formattedDuration: String
        get() {
            val seconds = (durationMs / 1000) % 60
            val minutes = (durationMs / 1000) / 60
            return "%02d:%02d".format(minutes, seconds)
        }

    val formattedFileSize: String
        get() {
            val kb = fileSizeBytes / 1024
            return if (kb < 1024) "$kb KB" else "%.1f MB".format(kb / 1024f)
        }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as RecordedAudio
        return bytes.contentEquals(other.bytes) &&
                durationMs == other.durationMs &&
                timestamp == other.timestamp
    }

    override fun hashCode(): Int {
        var result = bytes.contentHashCode()
        result = 31 * result + durationMs.hashCode()
        result = 31 * result + timestamp.hashCode()
        return result
    }
}
