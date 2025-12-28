package com.neome.feature.utils

import android.content.ContentResolver
import android.graphics.Bitmap
import android.media.MediaMetadataRetriever
import android.net.Uri

/**
 * Result of video thumbnail extraction.
 *
 * @property bitmap The extracted thumbnail as a Bitmap
 * @property width Width of the thumbnail in pixels
 * @property height Height of the thumbnail in pixels
 * @property videoDurationMs Duration of the source video in milliseconds (null if unavailable)
 */
data class ThumbnailResult(
    val bitmap: Bitmap,
    val width: Int,
    val height: Int,
    val videoDurationMs: Long?
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as ThumbnailResult
        if (bitmap != other.bitmap) return false
        if (width != other.width) return false
        if (height != other.height) return false
        if (videoDurationMs != other.videoDurationMs) return false
        return true
    }

    override fun hashCode(): Int {
        var result = bitmap.hashCode()
        result = 31 * result + width
        result = 31 * result + height
        result = 31 * result + (videoDurationMs?.hashCode() ?: 0)
        return result
    }
}

/**
 * Sealed class representing thumbnail extraction outcomes.
 */
sealed class ThumbnailOutcome {
    data class Success(val result: ThumbnailResult) : ThumbnailOutcome()
    data class Error(val message: String) : ThumbnailOutcome()
}

/**
 * Stateless video thumbnail extraction utility using Android SDK MediaMetadataRetriever.
 *
 * This utility extracts the first frame of a video without any external libraries.
 *
 * Usage:
 * ```
 * val outcome = VideoThumbnailExtractor.extractThumbnail(contentResolver, videoUri)
 * when (outcome) {
 *     is ThumbnailOutcome.Success -> // use outcome.result.bitmap
 *     is ThumbnailOutcome.Error -> // handle error
 * }
 * ```
 *
 * Architecture justification for stateless helper:
 * - Single synchronous operation (no complex state management)
 * - No lifecycle concerns (extracted bitmap is returned immediately)
 * - No side effects beyond extraction (no network, no persistence)
 * - Consistent with ImageCompressor pattern in this codebase
 */
object VideoThumbnailExtractor {

    private const val FRAME_TIME_US = 0L // First frame at timestamp 0

    /**
     * Extracts the first frame thumbnail from a video Uri.
     *
     * @param contentResolver ContentResolver to open the video Uri
     * @param videoUri The Uri of the video file to extract thumbnail from
     * @return ThumbnailOutcome containing either the extracted thumbnail or an error
     *
     * Note: The caller is responsible for recycling the returned Bitmap when done.
     */
    fun extractThumbnail(
        contentResolver: ContentResolver,
        videoUri: Uri
    ): ThumbnailOutcome {
        val retriever = MediaMetadataRetriever()

        return try {
            // Set data source using ContentResolver for Uri support
            retriever.setDataSource(contentResolver.openFileDescriptor(videoUri, "r")?.fileDescriptor)

            // Extract frame at timestamp 0 (first frame)
            val bitmap = retriever.getFrameAtTime(
                FRAME_TIME_US,
                MediaMetadataRetriever.OPTION_CLOSEST_SYNC
            )

            if (bitmap == null) {
                return ThumbnailOutcome.Error("Failed to extract frame from video. Video may be corrupted or unsupported.")
            }

            // Get video duration (optional metadata)
            val durationString = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION)
            val durationMs = durationString?.toLongOrNull()

            ThumbnailOutcome.Success(
                ThumbnailResult(
                    bitmap = bitmap,
                    width = bitmap.width,
                    height = bitmap.height,
                    videoDurationMs = durationMs
                )
            )
        } catch (e: IllegalArgumentException) {
            ThumbnailOutcome.Error("Invalid video Uri or unsupported format: ${e.message}")
        } catch (e: SecurityException) {
            ThumbnailOutcome.Error("Permission denied to access video: ${e.message}")
        } catch (e: Exception) {
            ThumbnailOutcome.Error("Thumbnail extraction failed: ${e.message ?: "Unknown error"}")
        } finally {
            try {
                retriever.release()
            } catch (e: Exception) {
                // Ignore release errors
            }
        }
    }
}
