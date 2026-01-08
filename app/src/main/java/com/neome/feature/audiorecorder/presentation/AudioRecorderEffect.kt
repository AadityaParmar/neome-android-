package com.neome.feature.audiorecorder.presentation

import com.neome.feature.audiorecorder.domain.model.RecordedAudio

/**
 * One-time side effects from audio recorder screen.
 */
sealed interface AudioRecorderEffect {
    data class RecordingComplete(val audio: RecordedAudio) : AudioRecorderEffect
    data object Cancelled : AudioRecorderEffect
    data class Error(val message: String) : AudioRecorderEffect
    data object RequestMicrophonePermission : AudioRecorderEffect
}
