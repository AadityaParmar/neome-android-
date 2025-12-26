package com.neome.feature.cropper.domain.model

/**
 * Represents an image that can be cropped.
 * Contains raw bytes and metadata needed for crop operations.
 *
 * This model is decoupled from camera-specific models to allow
 * the cropper to be used with images from any source.
 */
data class CroppableImage(
    val bytes: ByteArray,
    val width: Int,
    val height: Int,
    val rotation: Int = 0,
    val mimeType: String = "image/jpeg"
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as CroppableImage
        return bytes.contentEquals(other.bytes) &&
                width == other.width &&
                height == other.height &&
                rotation == other.rotation
    }

    override fun hashCode(): Int {
        var result = bytes.contentHashCode()
        result = 31 * result + width
        result = 31 * result + height
        result = 31 * result + rotation
        return result
    }
}
