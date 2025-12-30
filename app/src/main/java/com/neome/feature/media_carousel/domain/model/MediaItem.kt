package com.neome.feature.media_carousel.domain.model

import android.graphics.Bitmap
import android.net.Uri

sealed interface MediaItem {
    val id: String
    val uri: Uri
    val mimeType: String
    val type: MediaType

    data class ImageItem(
        override val id: String,
        override val uri: Uri,
        override val mimeType: String = "image/jpeg",
        val bitmap: Bitmap? = null,
        val bytes: ByteArray? = null,
        val width: Int = 0,
        val height: Int = 0
    ) : MediaItem {
        override val type: MediaType = MediaType.IMAGE

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as ImageItem

            if (id != other.id) return false
            if (uri != other.uri) return false
            if (mimeType != other.mimeType) return false
            if (width != other.width) return false
            if (height != other.height) return false
            if (bytes != null) {
                if (other.bytes == null) return false
                if (!bytes.contentEquals(other.bytes)) return false
            } else if (other.bytes != null) return false

            return true
        }

        override fun hashCode(): Int {
            var result = id.hashCode()
            result = 31 * result + uri.hashCode()
            result = 31 * result + mimeType.hashCode()
            result = 31 * result + width
            result = 31 * result + height
            result = 31 * result + (bytes?.contentHashCode() ?: 0)
            return result
        }
    }

    data class VideoItem(
        override val id: String,
        override val uri: Uri,
        override val mimeType: String = "video/mp4",
        val thumbnailBitmap: Bitmap? = null,
        val durationMs: Long = 0L,
        val fileName: String = ""
    ) : MediaItem {
        override val type: MediaType = MediaType.VIDEO
    }

    data class FileItem(
        override val id: String,
        override val uri: Uri,
        override val mimeType: String,
        val fileName: String,
        val fileSize: Long
    ) : MediaItem {
        override val type: MediaType = MediaType.FILE
    }
}
