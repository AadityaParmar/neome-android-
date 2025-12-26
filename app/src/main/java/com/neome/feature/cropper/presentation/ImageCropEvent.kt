package com.neome.feature.cropper.presentation

import com.neome.feature.cropper.domain.model.CropRegion

/**
 * All possible user actions on crop screen.
 *
 * Note: AspectRatioSelected removed - only free crop is supported.
 */
sealed interface ImageCropEvent {
    data class CropRegionChanged(val region: CropRegion) : ImageCropEvent
    data object ConfirmCrop : ImageCropEvent
    data object Cancel : ImageCropEvent
    data object Reset : ImageCropEvent
}
