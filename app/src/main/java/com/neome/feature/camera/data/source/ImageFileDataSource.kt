package com.neome.feature.camera.data.source

import android.content.ContentValues
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import com.neome.feature.camera.domain.model.CapturedImage
import com.neome.feature.camera.domain.model.ImageDirectory
import com.neome.feature.camera.domain.model.ImageQuality
import com.neome.feature.camera.domain.model.SavedImageResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * Data source for file I/O operations.
 * Handles MediaStore for Android 10+ and direct file access for older versions.
 */
class ImageFileDataSource(
    private val context: Context
) {

    suspend fun saveImage(
        image: CapturedImage,
        fileName: String?,
        quality: ImageQuality,
        directory: ImageDirectory
    ): Result<SavedImageResult> = withContext(Dispatchers.IO) {
        try {
            val actualFileName = fileName ?: generateFileName()

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                saveWithMediaStore(image, actualFileName, quality, directory)
            } else {
                saveToExternalStorage(image, actualFileName, quality, directory)
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun deleteImage(uri: String): Result<Unit> = withContext(Dispatchers.IO) {
        try {
            val androidUri = android.net.Uri.parse(uri)
            val deletedRows = context.contentResolver.delete(androidUri, null, null)
            if (deletedRows > 0) {
                Result.success(Unit)
            } else {
                Result.failure(Exception("Failed to delete image"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    private fun saveWithMediaStore(
        image: CapturedImage,
        fileName: String,
        quality: ImageQuality,
        directory: ImageDirectory
    ): Result<SavedImageResult> {
        val relativePath = when (directory) {
            ImageDirectory.PICTURES -> Environment.DIRECTORY_PICTURES
            ImageDirectory.DCIM -> Environment.DIRECTORY_DCIM
            ImageDirectory.APP_INTERNAL -> Environment.DIRECTORY_PICTURES
        }

        val contentValues = ContentValues().apply {
            put(MediaStore.Images.Media.DISPLAY_NAME, fileName)
            put(MediaStore.Images.Media.MIME_TYPE, image.mimeType)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                put(MediaStore.Images.Media.RELATIVE_PATH, relativePath)
                put(MediaStore.Images.Media.IS_PENDING, 1)
            }
        }

        val contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        val uri = context.contentResolver.insert(contentUri, contentValues)
            ?: return Result.failure(Exception("Failed to create MediaStore entry"))

        return try {
            context.contentResolver.openOutputStream(uri)?.use { outputStream ->
                val bitmap = BitmapFactory.decodeByteArray(image.bytes, 0, image.bytes.size)
                bitmap.compress(
                    Bitmap.CompressFormat.JPEG,
                    quality.compressionPercent,
                    outputStream
                )
                bitmap.recycle()
            }

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                contentValues.clear()
                contentValues.put(MediaStore.Images.Media.IS_PENDING, 0)
                context.contentResolver.update(uri, contentValues, null, null)
            }

            // Get file size
            val cursor = context.contentResolver.query(
                uri,
                arrayOf(MediaStore.Images.Media.SIZE, MediaStore.Images.Media.DATA),
                null,
                null,
                null
            )

            var fileSize = 0L
            var filePath = ""
            cursor?.use {
                if (it.moveToFirst()) {
                    fileSize = it.getLong(it.getColumnIndexOrThrow(MediaStore.Images.Media.SIZE))
                    filePath = it.getString(it.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)) ?: ""
                }
            }

            Result.success(
                SavedImageResult(
                    uri = uri.toString(),
                    fileName = fileName,
                    filePath = filePath,
                    sizeBytes = fileSize
                )
            )
        } catch (e: Exception) {
            context.contentResolver.delete(uri, null, null)
            Result.failure(e)
        }
    }

    @Suppress("DEPRECATION")
    private fun saveToExternalStorage(
        image: CapturedImage,
        fileName: String,
        quality: ImageQuality,
        directory: ImageDirectory
    ): Result<SavedImageResult> {
        val storageDir = when (directory) {
            ImageDirectory.PICTURES -> Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
            ImageDirectory.DCIM -> Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM)
            ImageDirectory.APP_INTERNAL -> context.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        } ?: return Result.failure(Exception("Storage directory not available"))

        if (!storageDir.exists()) {
            storageDir.mkdirs()
        }

        val file = File(storageDir, fileName)

        return try {
            FileOutputStream(file).use { outputStream ->
                val bitmap = BitmapFactory.decodeByteArray(image.bytes, 0, image.bytes.size)
                bitmap.compress(
                    Bitmap.CompressFormat.JPEG,
                    quality.compressionPercent,
                    outputStream
                )
                bitmap.recycle()
            }

            Result.success(
                SavedImageResult(
                    uri = android.net.Uri.fromFile(file).toString(),
                    fileName = fileName,
                    filePath = file.absolutePath,
                    sizeBytes = file.length()
                )
            )
        } catch (e: Exception) {
            file.delete()
            Result.failure(e)
        }
    }

    private fun generateFileName(): String {
        val timestamp = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
        return "IMG_$timestamp.jpg"
    }
}
