package com.neome.feature.camera.presentation.capture

/**
 * All possible user actions on camera screen.
 */
sealed interface CameraCaptureEvent {
    data object CaptureClicked : CameraCaptureEvent
    data object SwitchCamera : CameraCaptureEvent
    data class FlashModeChanged(val mode: FlashMode) : CameraCaptureEvent
    data object RetryPermission : CameraCaptureEvent
    data object CameraReady : CameraCaptureEvent
    data object Cancel : CameraCaptureEvent
}
