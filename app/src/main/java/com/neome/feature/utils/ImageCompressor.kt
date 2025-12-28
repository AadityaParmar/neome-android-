package com.neome.feature.utils

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.media.ExifInterface
import java.io.ByteArrayOutputStream
import java.io.InputStream

/**
 * Result of image compression operation.
 *
 * @property bytes The compressed image as a byte array
 * @property width Width of the compressed image in pixels
 * @property height Height of the compressed image in pixels
 * @property originalSize Size of the original image in bytes
 * @property compressedSize Size of the compressed image in bytes
 */
data class CompressionResult(
    val bytes: ByteArray,
    val width: Int,
    val height: Int,
    val originalSize: Long,
    val compressedSize: Long
) {
    val compressionRatio: Float
        get() = if (originalSize > 0) compressedSize.toFloat() / originalSize.toFloat() else 1f

    val savedPercentage: Float
        get() = if (originalSize > 0) ((originalSize - compressedSize).toFloat() / originalSize.toFloat()) * 100f else 0f

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as CompressionResult
        if (!bytes.contentEquals(other.bytes)) return false
        if (width != other.width) return false
        if (height != other.height) return false
        if (originalSize != other.originalSize) return false
        if (compressedSize != other.compressedSize) return false
        return true
    }

    override fun hashCode(): Int {
        var result = bytes.contentHashCode()
        result = 31 * result + width
        result = 31 * result + height
        result = 31 * result + originalSize.hashCode()
        result = 31 * result + compressedSize.hashCode()
        return result
    }
}

/**
 * Sealed class representing compression operation outcomes.
 */
sealed class CompressionOutcome {
    data class Success(val result: CompressionResult) : CompressionOutcome()
    data class Error(val message: String) : CompressionOutcome()
}

/**
 * Stateless image compression utility using Android SDK Bitmap APIs.
 *
 * This utility provides image compression without any external libraries.
 * Compression percentage maps directly to JPEG quality (0-100).
 *
 * Usage:
 * ```
 * val outcome = ImageCompressor.compress(bitmap, compressionPercentage = 75)
 * when (outcome) {
 *     is CompressionOutcome.Success -> // use outcome.result.bytes
 *     is CompressionOutcome.Error -> // handle error
 * }
 * ```
 */
object ImageCompressor {

    private const val MIN_QUALITY = 0
    private const val MAX_QUALITY = 100

    /**
     * Compresses a Bitmap to JPEG format with the specified quality.
     *
     * @param bitmap The source bitmap to compress. Must not be recycled.
     * @param compressionPercentage Quality level (0-100). Higher values mean better quality but larger size.
     *        - 0: Maximum compression, lowest quality
     *        - 100: No quality loss, minimal compression
     * @return CompressionOutcome containing either the compressed result or an error.
     *
     * Note: The original bitmap is NOT modified or recycled by this function.
     */
    fun compress(
        bitmap: Bitmap,
        compressionPercentage: Int
    ): CompressionOutcome {
        // Validate compression percentage
        if (compressionPercentage < MIN_QUALITY || compressionPercentage > MAX_QUALITY) {
            return CompressionOutcome.Error(
                "Invalid compression percentage: $compressionPercentage. Must be between $MIN_QUALITY and $MAX_QUALITY."
            )
        }

        // Validate bitmap
        if (bitmap.isRecycled) {
            return CompressionOutcome.Error("Cannot compress a recycled bitmap.")
        }

        return try {
            // Calculate original size (estimate based on bitmap dimensions and config)
            val originalSize = estimateBitmapSize(bitmap)

            // Compress to JPEG
            val outputStream = ByteArrayOutputStream()
            val success = bitmap.compress(
                Bitmap.CompressFormat.JPEG,
                compressionPercentage,
                outputStream
            )

            if (!success) {
                return CompressionOutcome.Error("Bitmap compression failed.")
            }

            val compressedBytes = outputStream.toByteArray()

            CompressionOutcome.Success(
                CompressionResult(
                    bytes = compressedBytes,
                    width = bitmap.width,
                    height = bitmap.height,
                    originalSize = originalSize,
                    compressedSize = compressedBytes.size.toLong()
                )
            )
        } catch (e: Exception) {
            CompressionOutcome.Error("Compression error: ${e.message ?: "Unknown error"}")
        }
    }

    /**
     * Compresses a ByteArray image to JPEG format with the specified quality.
     * Preserves EXIF orientation data.
     *
     * @param imageBytes The source image as a byte array (JPEG, PNG, etc.)
     * @param compressionPercentage Quality level (0-100).
     * @return CompressionOutcome containing either the compressed result or an error.
     *
     * Note: The original byte array is NOT modified.
     */
    fun compress(
        imageBytes: ByteArray,
        compressionPercentage: Int
    ): CompressionOutcome {
        // Validate compression percentage
        if (compressionPercentage < MIN_QUALITY || compressionPercentage > MAX_QUALITY) {
            return CompressionOutcome.Error(
                "Invalid compression percentage: $compressionPercentage. Must be between $MIN_QUALITY and $MAX_QUALITY."
            )
        }

        // Validate input
        if (imageBytes.isEmpty()) {
            return CompressionOutcome.Error("Image bytes cannot be empty.")
        }

        return try {
            val originalSize = imageBytes.size.toLong()

            // Decode with orientation handling
            val bitmap = decodeBitmapWithOrientation(imageBytes)
                ?: return CompressionOutcome.Error("Failed to decode image from bytes.")

            // Compress
            val outputStream = ByteArrayOutputStream()
            val success = bitmap.compress(
                Bitmap.CompressFormat.JPEG,
                compressionPercentage,
                outputStream
            )

            // Clean up decoded bitmap
            bitmap.recycle()

            if (!success) {
                return CompressionOutcome.Error("Bitmap compression failed.")
            }

            val compressedBytes = outputStream.toByteArray()

            // Decode compressed to get final dimensions
            val options = BitmapFactory.Options().apply { inJustDecodeBounds = true }
            BitmapFactory.decodeByteArray(compressedBytes, 0, compressedBytes.size, options)

            CompressionOutcome.Success(
                CompressionResult(
                    bytes = compressedBytes,
                    width = options.outWidth,
                    height = options.outHeight,
                    originalSize = originalSize,
                    compressedSize = compressedBytes.size.toLong()
                )
            )
        } catch (e: Exception) {
            CompressionOutcome.Error("Compression error: ${e.message ?: "Unknown error"}")
        }
    }

    /**
     * Compresses an image from an InputStream with the specified quality.
     * Preserves EXIF orientation data.
     *
     * @param inputStream The input stream containing image data.
     * @param compressionPercentage Quality level (0-100).
     * @return CompressionOutcome containing either the compressed result or an error.
     *
     * Note: The caller is responsible for closing the input stream.
     */
    fun compress(
        inputStream: InputStream,
        compressionPercentage: Int
    ): CompressionOutcome {
        return try {
            val imageBytes = inputStream.readBytes()
            compress(imageBytes, compressionPercentage)
        } catch (e: Exception) {
            CompressionOutcome.Error("Failed to read input stream: ${e.message ?: "Unknown error"}")
        }
    }

    /**
     * Decodes a bitmap from bytes and applies EXIF orientation correction.
     */
    private fun decodeBitmapWithOrientation(imageBytes: ByteArray): Bitmap? {
        // First decode the bitmap
        val bitmap = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
            ?: return null

        // Try to read EXIF orientation
        return try {
            val exif = ExifInterface(imageBytes.inputStream())
            val orientation = exif.getAttributeInt(
                ExifInterface.TAG_ORIENTATION,
                ExifInterface.ORIENTATION_NORMAL
            )

            val matrix = Matrix()
            when (orientation) {
                ExifInterface.ORIENTATION_ROTATE_90 -> matrix.postRotate(90f)
                ExifInterface.ORIENTATION_ROTATE_180 -> matrix.postRotate(180f)
                ExifInterface.ORIENTATION_ROTATE_270 -> matrix.postRotate(270f)
                ExifInterface.ORIENTATION_FLIP_HORIZONTAL -> matrix.preScale(-1f, 1f)
                ExifInterface.ORIENTATION_FLIP_VERTICAL -> matrix.preScale(1f, -1f)
                ExifInterface.ORIENTATION_TRANSPOSE -> {
                    matrix.postRotate(90f)
                    matrix.preScale(-1f, 1f)
                }
                ExifInterface.ORIENTATION_TRANSVERSE -> {
                    matrix.postRotate(-90f)
                    matrix.preScale(-1f, 1f)
                }
                else -> return bitmap // No rotation needed
            }

            val rotatedBitmap = Bitmap.createBitmap(
                bitmap, 0, 0, bitmap.width, bitmap.height, matrix, true
            )

            // Recycle original if a new bitmap was created
            if (rotatedBitmap != bitmap) {
                bitmap.recycle()
            }

            rotatedBitmap
        } catch (e: Exception) {
            // If EXIF reading fails, return the bitmap as-is
            bitmap
        }
    }

    /**
     * Estimates the uncompressed size of a bitmap in bytes.
     */
    private fun estimateBitmapSize(bitmap: Bitmap): Long {
        return bitmap.allocationByteCount.toLong()
    }
}
