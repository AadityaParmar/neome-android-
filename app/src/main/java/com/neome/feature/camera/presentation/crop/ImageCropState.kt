package com.neome.feature.camera.presentation.crop

import com.neome.feature.camera.domain.model.CapturedImage
import com.neome.feature.camera.domain.model.CropRegion

/**
 * Single immutable state for crop screen.
 * NOTE: Image preview is ONLY shown in this screen.
 *
 * Cropper is always in FREE mode - no aspect ratio constraints.
 */
data class ImageCropState(
    val sourceImage: CapturedImage? = null,
    val cropRegion: CropRegion = CropRegion.FULL,
    val isProcessing: Boolean = false,
    val error: String? = null
)

/**
 * AspectRatio kept for backward compatibility but only Free is used.
 * All fixed ratio modes have been removed per requirements.
 */
sealed interface AspectRatio {
    data object Free : AspectRatio

    /**
     * Returns null for free crop (no constraint).
     */
    fun toRatio(): Float? = null
}
