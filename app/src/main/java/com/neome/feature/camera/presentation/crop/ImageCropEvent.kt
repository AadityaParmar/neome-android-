package com.neome.feature.camera.presentation.crop

import com.neome.feature.camera.domain.model.CropRegion

/**
 * All possible user actions on crop screen.
 */
sealed interface ImageCropEvent {
    data class CropRegionChanged(val region: CropRegion) : ImageCropEvent
    data class AspectRatioSelected(val ratio: AspectRatio) : ImageCropEvent
    data object ConfirmCrop : ImageCropEvent
    data object Cancel : ImageCropEvent
    data object Reset : ImageCropEvent
}
