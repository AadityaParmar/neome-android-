package com.neome.feature.camera.presentation.crop

import com.neome.feature.camera.domain.model.CapturedImage

/**
 * One-time side effects from crop screen.
 */
sealed interface ImageCropEffect {
    data class CropConfirmed(val croppedImage: CapturedImage) : ImageCropEffect
    data class Cancelled(val originalImage: CapturedImage) : ImageCropEffect
    data class Error(val message: String) : ImageCropEffect
}
