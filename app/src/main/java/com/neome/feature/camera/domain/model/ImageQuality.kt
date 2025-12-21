package com.neome.feature.camera.domain.model

/**
 * JPEG compression quality levels.
 */
enum class ImageQuality(val compressionPercent: Int) {
    LOW(50),
    MEDIUM(75),
    HIGH(90),
    MAXIMUM(100)
}
