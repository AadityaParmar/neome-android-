package com.neome.feature.camera.presentation.coordinator

import com.neome.feature.camera.domain.model.ImageDirectory
import com.neome.feature.camera.domain.model.ImageQuality
import com.neome.feature.camera.presentation.capture.CameraFacing

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
 *
 * Note: Cropping is always FREE mode (no aspect ratio constraints).
 */
data class CameraFlowConfig(
    val enableCropping: Boolean = false,
    val enableSaving: Boolean = false,
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
         * Capture with free crop and save.
         * User can crop to any shape/size they want.
         */
        val PROFILE_PHOTO = CameraFlowConfig(
            enableCropping = true,
            enableSaving = true,
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
