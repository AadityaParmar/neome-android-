package com.neome.feature.camera.presentation.coordinator

import com.neome.feature.camera.domain.model.ImageDirectory
import com.neome.feature.camera.domain.model.ImageQuality
import com.neome.feature.camera.presentation.capture.CameraFacing
import com.neome.feature.camera.presentation.crop.AspectRatio

/**
 * Configuration for camera flow.
 * Caller controls which steps are enabled.
 *
 * Flow A: Capture Only (default)
 *   enableCropping = false, enableSaving = false
 *
 * Flow B: Capture → Crop → Save
 *   enableCropping = true, enableSaving = true
 *
 * Flow C: Capture → Save
 *   enableCropping = false, enableSaving = true
 */
data class CameraFlowConfig(
    val enableCropping: Boolean = false,
    val enableSaving: Boolean = false,
    val aspectRatio: AspectRatio = AspectRatio.Free,
    val imageQuality: ImageQuality = ImageQuality.HIGH,
    val saveDirectory: ImageDirectory = ImageDirectory.PICTURES,
    val initialCameraFacing: CameraFacing = CameraFacing.BACK
) {
    companion object {
        /**
         * Simple capture only - returns raw image bytes.
         */
        val CAPTURE_ONLY = CameraFlowConfig()

        /**
         * Capture with square crop and save.
         */
        val PROFILE_PHOTO = CameraFlowConfig(
            enableCropping = true,
            enableSaving = true,
            aspectRatio = AspectRatio.Square,
            imageQuality = ImageQuality.HIGH
        )

        /**
         * Capture and save directly without crop.
         */
        val DOCUMENT_CAPTURE = CameraFlowConfig(
            enableCropping = false,
            enableSaving = true,
            imageQuality = ImageQuality.MAXIMUM
        )
    }
}
