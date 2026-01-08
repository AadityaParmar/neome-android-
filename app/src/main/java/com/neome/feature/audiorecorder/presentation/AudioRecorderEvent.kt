package com.neome.feature.audiorecorder.presentation

/**
 * All possible user actions on audio recorder screen.
 */
sealed interface AudioRecorderEvent {
    data object StartRecording : AudioRecorderEvent
    data object PauseRecording : AudioRecorderEvent
    data object ResumeRecording : AudioRecorderEvent
    data object StopRecording : AudioRecorderEvent
    data object CancelRecording : AudioRecorderEvent
    data object RequestPermission : AudioRecorderEvent
    data object PermissionGranted : AudioRecorderEvent
    data object PermissionDenied : AudioRecorderEvent
    data object ClearError : AudioRecorderEvent
    data object RetryRecording : AudioRecorderEvent
}
