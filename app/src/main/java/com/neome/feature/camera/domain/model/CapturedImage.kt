package com.neome.feature.camera.domain.model

/**
 * Represents a captured image with raw bytes and metadata.
 * Returned from camera capture, passed to crop/save.
 */
data class CapturedImage(
    val bytes: ByteArray,
    val width: Int,
    val height: Int,
    val rotation: Int,
    val mimeType: String = "image/jpeg",
    val timestamp: Long = System.currentTimeMillis()
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as CapturedImage
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
