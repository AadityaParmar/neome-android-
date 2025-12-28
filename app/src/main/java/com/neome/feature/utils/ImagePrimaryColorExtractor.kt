package com.neome.feature.utils

import android.graphics.Bitmap
import android.graphics.Color
import androidx.annotation.ColorInt

/**
 * Result of primary color extraction.
 *
 * @property color The extracted primary color as an ARGB integer
 * @property red Red component (0-255)
 * @property green Green component (0-255)
 * @property blue Blue component (0-255)
 * @property hexString Hex representation of the color (e.g., "#FF5733")
 * @property pixelsSampled Number of non-transparent pixels analyzed
 */
data class PrimaryColorResult(
    @ColorInt val color: Int,
    val red: Int,
    val green: Int,
    val blue: Int,
    val hexString: String,
    val pixelsSampled: Int
)

/**
 * Sealed class representing color extraction outcomes.
 */
sealed class PrimaryColorOutcome {
    data class Success(val result: PrimaryColorResult) : PrimaryColorOutcome()
    data class Error(val message: String) : PrimaryColorOutcome()
}

/**
 * Stateless image primary color extraction utility using Android SDK Bitmap pixel analysis.
 *
 * This utility extracts the dominant/primary color from an image without any external libraries.
 * It uses a bucket-based color quantization algorithm for efficient and accurate results.
 *
 * Usage:
 * ```
 * val outcome = ImagePrimaryColorExtractor.extractPrimaryColor(bitmap)
 * when (outcome) {
 *     is PrimaryColorOutcome.Success -> // use outcome.result.color
 *     is PrimaryColorOutcome.Error -> // handle error
 * }
 * ```
 *
 * Architecture justification for stateless helper:
 * - Single synchronous operation (no complex state management)
 * - No lifecycle concerns (color is returned immediately)
 * - No side effects (no network, no persistence, no image mutation)
 * - Consistent with ImageCompressor and VideoThumbnailExtractor patterns
 */
object ImagePrimaryColorExtractor {

    // Number of buckets per color channel (reduces 256 values to fewer buckets)
    // 32 buckets means each bucket covers 8 values (256/32 = 8)
    private const val BUCKET_COUNT = 32
    private const val BUCKET_SIZE = 256 / BUCKET_COUNT

    // Maximum dimension for sampling (downscale large images for performance)
    private const val MAX_SAMPLE_DIMENSION = 100

    // Minimum alpha to consider a pixel non-transparent
    private const val MIN_ALPHA = 128

    /**
     * Extracts the primary/dominant color from a Bitmap.
     *
     * @param bitmap The source bitmap to analyze. Must not be recycled.
     * @return PrimaryColorOutcome containing either the extracted color or an error.
     *
     * Note: The original bitmap is NOT modified by this function.
     */
    fun extractPrimaryColor(bitmap: Bitmap): PrimaryColorOutcome {
        // Validate bitmap
        if (bitmap.isRecycled) {
            return PrimaryColorOutcome.Error("Cannot analyze a recycled bitmap.")
        }

        if (bitmap.width == 0 || bitmap.height == 0) {
            return PrimaryColorOutcome.Error("Bitmap has invalid dimensions.")
        }

        return try {
            // Downsample for performance if needed
            val sampleBitmap = downsampleIfNeeded(bitmap)

            // Extract dominant color using bucket-based quantization
            val result = analyzeDominantColor(sampleBitmap)

            // Recycle the sample bitmap only if it's a new one (not the original)
            if (sampleBitmap != bitmap && !sampleBitmap.isRecycled) {
                sampleBitmap.recycle()
            }

            result
        } catch (e: Exception) {
            PrimaryColorOutcome.Error("Color extraction failed: ${e.message ?: "Unknown error"}")
        }
    }

    /**
     * Downsamples the bitmap if it exceeds MAX_SAMPLE_DIMENSION for performance.
     */
    private fun downsampleIfNeeded(bitmap: Bitmap): Bitmap {
        val width = bitmap.width
        val height = bitmap.height

        if (width <= MAX_SAMPLE_DIMENSION && height <= MAX_SAMPLE_DIMENSION) {
            return bitmap
        }

        val scale = MAX_SAMPLE_DIMENSION.toFloat() / maxOf(width, height)
        val newWidth = (width * scale).toInt().coerceAtLeast(1)
        val newHeight = (height * scale).toInt().coerceAtLeast(1)

        return Bitmap.createScaledBitmap(bitmap, newWidth, newHeight, true)
    }

    /**
     * Analyzes the bitmap to find the dominant color using bucket-based quantization.
     *
     * Algorithm:
     * 1. Iterate through all pixels
     * 2. Skip transparent pixels (alpha < MIN_ALPHA)
     * 3. Bucket each pixel's RGB into a 3D color space grid
     * 4. Find the bucket with the most pixels
     * 5. Calculate the average color of pixels in that bucket for accuracy
     */
    private fun analyzeDominantColor(bitmap: Bitmap): PrimaryColorOutcome {
        val width = bitmap.width
        val height = bitmap.height
        val pixelCount = width * height

        // Get all pixels
        val pixels = IntArray(pixelCount)
        bitmap.getPixels(pixels, 0, width, 0, 0, width, height)

        // Bucket structure: Map of bucket key to list of colors in that bucket
        val buckets = HashMap<Int, MutableList<Int>>()
        var nonTransparentCount = 0

        for (pixel in pixels) {
            val alpha = Color.alpha(pixel)

            // Skip transparent pixels
            if (alpha < MIN_ALPHA) continue

            nonTransparentCount++

            val red = Color.red(pixel)
            val green = Color.green(pixel)
            val blue = Color.blue(pixel)

            // Calculate bucket key
            val bucketKey = getBucketKey(red, green, blue)

            // Add to bucket
            buckets.getOrPut(bucketKey) { mutableListOf() }.add(pixel)
        }

        if (nonTransparentCount == 0) {
            return PrimaryColorOutcome.Error("Image contains only transparent pixels.")
        }

        if (buckets.isEmpty()) {
            return PrimaryColorOutcome.Error("No valid color buckets found.")
        }

        // Find the bucket with the most pixels
        val dominantBucket = buckets.maxByOrNull { it.value.size }
            ?: return PrimaryColorOutcome.Error("Failed to determine dominant color bucket.")

        // Calculate the average color of pixels in the dominant bucket
        val dominantColors = dominantBucket.value
        var totalRed = 0L
        var totalGreen = 0L
        var totalBlue = 0L

        for (color in dominantColors) {
            totalRed += Color.red(color)
            totalGreen += Color.green(color)
            totalBlue += Color.blue(color)
        }

        val count = dominantColors.size
        val avgRed = (totalRed / count).toInt().coerceIn(0, 255)
        val avgGreen = (totalGreen / count).toInt().coerceIn(0, 255)
        val avgBlue = (totalBlue / count).toInt().coerceIn(0, 255)

        val primaryColor = Color.rgb(avgRed, avgGreen, avgBlue)
        val hexString = String.format("#%02X%02X%02X", avgRed, avgGreen, avgBlue)

        return PrimaryColorOutcome.Success(
            PrimaryColorResult(
                color = primaryColor,
                red = avgRed,
                green = avgGreen,
                blue = avgBlue,
                hexString = hexString,
                pixelsSampled = nonTransparentCount
            )
        )
    }

    /**
     * Calculates a unique bucket key for an RGB color.
     * This effectively quantizes the color space into BUCKET_COUNT^3 buckets.
     */
    private fun getBucketKey(red: Int, green: Int, blue: Int): Int {
        val rBucket = red / BUCKET_SIZE
        val gBucket = green / BUCKET_SIZE
        val bBucket = blue / BUCKET_SIZE

        // Combine into a single key: r * 32^2 + g * 32 + b
        return (rBucket * BUCKET_COUNT * BUCKET_COUNT) + (gBucket * BUCKET_COUNT) + bBucket
    }
}
