package com.neome.feature.camera.presentation.capture

/**
 * Single immutable state for camera capture screen.
 */
data class CameraCaptureState(
    val isCameraReady: Boolean = false,
    val isCapturing: Boolean = false,
    val flashMode: FlashMode = FlashMode.OFF,
    val cameraFacing: CameraFacing = CameraFacing.BACK,
    val error: CameraError? = null
)

enum class FlashMode { OFF, ON, AUTO }

enum class CameraFacing { FRONT, BACK }

sealed interface CameraError {
    data object PermissionDenied : CameraError
    data object CameraUnavailable : CameraError
    data class CaptureError(val message: String) : CameraError
}
