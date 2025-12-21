package com.neome.feature.camera.presentation.capture

import com.neome.feature.camera.domain.model.CapturedImage

/**
 * One-time side effects from camera screen.
 */
sealed interface CameraCaptureEffect {
    data class ImageCaptured(val image: CapturedImage) : CameraCaptureEffect
    data object Cancelled : CameraCaptureEffect
    data class Error(val error: CameraError) : CameraCaptureEffect
}
