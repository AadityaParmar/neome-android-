package com.neome.feature.cropper.presentation

import com.neome.feature.cropper.domain.model.CroppableImage

/**
 * One-time side effects from crop screen.
 */
sealed interface ImageCropEffect {
    data class CropConfirmed(val croppedImage: CroppableImage) : ImageCropEffect
    data class Cancelled(val originalImage: CroppableImage) : ImageCropEffect
    data class Error(val message: String) : ImageCropEffect
}
