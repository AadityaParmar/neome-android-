package com.neome.feature.camera.presentation.crop

import com.neome.feature.camera.domain.model.CapturedImage
import com.neome.feature.camera.domain.model.CropRegion

/**
 * Single immutable state for crop screen.
 * NOTE: Image preview is ONLY shown in this screen.
 */
data class ImageCropState(
    val sourceImage: CapturedImage? = null,
    val cropRegion: CropRegion = CropRegion.FULL,
    val aspectRatio: AspectRatio = AspectRatio.Free,
    val isProcessing: Boolean = false,
    val error: String? = null
)

sealed interface AspectRatio {
    data object Free : AspectRatio
    data object Square : AspectRatio        // 1:1
    data object FourThree : AspectRatio     // 4:3
    data object SixteenNine : AspectRatio   // 16:9
    data class Custom(val width: Int, val height: Int) : AspectRatio

    fun toRatio(): Float? = when (this) {
        is Free -> null
        is Square -> 1f
        is FourThree -> 4f / 3f
        is SixteenNine -> 16f / 9f
        is Custom -> width.toFloat() / height.toFloat()
    }
}
