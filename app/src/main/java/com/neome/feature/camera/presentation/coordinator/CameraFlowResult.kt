package com.neome.feature.camera.presentation.coordinator

import com.neome.feature.camera.domain.model.CapturedImage
import com.neome.feature.camera.domain.model.SavedImageResult

/**
 * Result of the camera flow.
 */
sealed interface CameraFlowResult {

    /**
     * Flow completed successfully.
     *
     * @param capturedImage The captured (and possibly cropped) image data
     * @param savedResult The saved image result, if saving was enabled
     * @param wasCropped Whether the image was cropped
     */
    data class Success(
        val capturedImage: CapturedImage,
        val savedResult: SavedImageResult? = null,
        val wasCropped: Boolean = false
    ) : CameraFlowResult

    /**
     * User cancelled the flow.
     */
    data object Cancelled : CameraFlowResult

    /**
     * An error occurred during the flow.
     *
     * @param message Error message
     * @param stage The stage at which the error occurred
     */
    data class Error(
        val message: String,
        val stage: ErrorStage = ErrorStage.CAPTURE
    ) : CameraFlowResult

    enum class ErrorStage {
        CAPTURE,
        CROP,
        SAVE
    }
}
