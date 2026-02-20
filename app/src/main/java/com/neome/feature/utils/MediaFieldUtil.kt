package com.neome.feature.utils

import android.content.Context
import com.neome.feature.camera.domain.model.CapturedImage
import com.neome.feature.filepicker.domain.model.FilePickerResult

/**
 * Holds the processed media metadata for form field images.
 *
 * @property compressedImage Compressed image byte array for storage/upload
 * @property blurImage Blurred version of the image for placeholder/preview
 * @property primaryColor Extracted dominant color from the image
 */
data class MediaMetaData(
    val compressedImage: ByteArray,
    val blurImage: ByteArray,
    val primaryColor: PrimaryColorResult
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as MediaMetaData
        return compressedImage.contentEquals(other.compressedImage) &&
                blurImage.contentEquals(other.blurImage) &&
                primaryColor == other.primaryColor
    }

    override fun hashCode(): Int {
        var result = compressedImage.contentHashCode()
        result = 31 * result + blurImage.contentHashCode()
        result = 31 * result + primaryColor.hashCode()
        return result
    }
}

/**
 * Utility class for processing media from form fields (image picker and camera capture).
 *
 * This class handles:
 * - Converting URIs to byte arrays
 * - Compressing images
 * - Generating blur images
 * - Extracting primary colors
 *
 * Usage:
 * ```
 * val util = MediaFieldUtil(context)
 * val metaData = util.getFieldImageMetaData(filePickerResult)
 * if (metaData != null) {
 *     // Use metaData.compressedImage, metaData.blurImage, metaData.primaryColor
 * }
 * ```
 */
class MediaFieldUtil(private val context: Context) {

    /**
     * Processes an image from the file picker and returns the media metadata.
     *
     * @param image The file picker result containing URI and file info
     * @return MediaMetaData if processing succeeds, null otherwise
     */
    fun getFieldImageMetaData(image: FilePickerResult): MediaMetaData? {
        // 1. Convert URI to ByteArray using ContentResolver
        val byteArray = context.contentResolver.openInputStream(image.uri)?.use {
            it.readBytes()
        } ?: return null

        if (byteArray.isEmpty()) return null

        // 2. Compress image
        val compressedImage = getCompressedImage(byteArray)

        // 3. Generate blur image
        val blurImage = getBlurImage(byteArray)

        // 4. Extract primary color
        val primaryColor = getPrimaryColor(byteArray) ?: return null

        // 5. Return MediaMetaData
        return MediaMetaData(
            compressedImage = compressedImage,
            blurImage = blurImage,
            primaryColor = primaryColor
        )
    }

    /**
     * Processes an image from camera capture and returns the media metadata.
     *
     * @param image The captured image containing raw bytes and metadata
     * @return MediaMetaData if processing succeeds, null otherwise
     */
    fun getFieldCameraMetaData(image: CapturedImage): MediaMetaData? {
        // 1. Use image.bytes directly
        val byteArray = image.bytes

        if (byteArray.isEmpty()) return null

        // 2. Compress image
        val compressedImage = getCompressedImage(byteArray)

        // 3. Generate blur image
        val blurImage = getBlurImage(byteArray)

        // 4. Extract primary color
        val primaryColor = getPrimaryColor(byteArray) ?: return null

        // 5. Return MediaMetaData
        return MediaMetaData(
            compressedImage = compressedImage,
            blurImage = blurImage,
            primaryColor = primaryColor
        )
    }

    /**
     * Compresses an image byte array to reduce file size.
     *
     * Quality is determined by the original size:
     * - <= 2MB  → 100% quality (no compression, returns original)
     * - 2MB to 6MB  → 90% quality
     * - 6MB to 10MB → 70% quality
     * - 10MB to 15MB → 60% quality
     * - >= 15MB → 50% quality
     *
     * @param byteArray The original image byte array
     * @return Compressed image byte array, or the original if compression is unnecessary or fails
     */
    fun getCompressedImage(byteArray: ByteArray): ByteArray {
        val quality = getQualityForSize(byteArray.size.toLong())

        // No compression needed
        if (quality == QUALITY_NO_COMPRESSION) return byteArray

        val outcome = ImageCompressor.compress(byteArray, quality)

        return when (outcome) {
            is CompressionOutcome.Success -> outcome.result.bytes
            is CompressionOutcome.Error -> byteArray
        }
    }

    /**
     * Determines JPEG quality level based on image byte size.
     */
    private fun getQualityForSize(sizeInBytes: Long): Int {
        val sizeInMB = sizeInBytes / (1024.0 * 1024.0)

        return when {
            sizeInMB <= 2.0 -> QUALITY_NO_COMPRESSION
            sizeInMB <= 6.0 -> 90
            sizeInMB <= 10.0 -> 70
            sizeInMB <= 15.0 -> 60
            else -> 50
        }
    }

    companion object {
        private const val QUALITY_NO_COMPRESSION = 100
        private const val BLUR_QUALITY = 20
    }

    /**
     * Generates a blurred version of the image.
     *
     * @param byteArray The original image byte array
     * @return Blurred image byte array
     */
    fun getBlurImage(byteArray: ByteArray): ByteArray {
        val outcome = ImageCompressor.compress(byteArray, BLUR_QUALITY)

        return when (outcome) {
            is CompressionOutcome.Success -> outcome.result.bytes
            is CompressionOutcome.Error -> byteArray
        }
    }

    /**
     * Extracts the primary/dominant color from an image.
     *
     * @param byteArray The image byte array to analyze
     * @return PrimaryColorResult if extraction succeeds, null otherwise
     */
    fun getPrimaryColor(byteArray: ByteArray): PrimaryColorResult? {
        val outcome = ImagePrimaryColorExtractor.extractPrimaryColor(byteArray)

        return when (outcome) {
            is PrimaryColorOutcome.Success -> outcome.result
            is PrimaryColorOutcome.Error -> null
        }
    }
}
