package com.neome.feature.audiorecorder.domain.model

/**
 * Sealed interface for recorder errors.
 */
sealed interface RecorderError {
    val message: String

    data class PermissionDenied(
        override val message: String = "Microphone permission required"
    ) : RecorderError

    data class InitializationFailed(
        override val message: String
    ) : RecorderError

    data class RecordingFailed(
        override val message: String
    ) : RecorderError

    data class EncodingFailed(
        override val message: String
    ) : RecorderError

    data class MaxDurationReached(
        override val message: String = "Maximum recording duration reached"
    ) : RecorderError
}
