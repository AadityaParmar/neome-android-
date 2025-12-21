package com.neome.feature.camera.domain.model

/**
 * Normalized crop region (0.0 to 1.0 percentages).
 * Independent of actual image dimensions.
 */
data class CropRegion(
    val left: Float,
    val top: Float,
    val right: Float,
    val bottom: Float
) {
    init {
        require(left in 0f..1f) { "left must be between 0 and 1" }
        require(top in 0f..1f) { "top must be between 0 and 1" }
        require(right in 0f..1f) { "right must be between 0 and 1" }
        require(bottom in 0f..1f) { "bottom must be between 0 and 1" }
        require(left < right) { "left must be less than right" }
        require(top < bottom) { "top must be less than bottom" }
    }

    companion object {
        val FULL = CropRegion(0f, 0f, 1f, 1f)
    }

    val widthPercent: Float get() = right - left
    val heightPercent: Float get() = bottom - top
}
