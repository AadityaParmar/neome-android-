package com.neome.feature.camera.domain.usecase

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import com.neome.feature.camera.domain.model.CapturedImage
import com.neome.feature.camera.domain.model.CropRegion
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.ByteArrayOutputStream

/**
 * Crops an image based on the provided region.
 * Performs the operation on a background thread.
 */
class CropImageUseCase {

    suspend operator fun invoke(
        image: CapturedImage,
        cropRegion: CropRegion
    ): Result<CapturedImage> = withContext(Dispatchers.IO) {
        try {
            // Decode bitmap from bytes
            val options = BitmapFactory.Options().apply {
                inMutable = true
            }
            val bitmap = BitmapFactory.decodeByteArray(image.bytes, 0, image.bytes.size, options)
                ?: return@withContext Result.failure(Exception("Failed to decode image"))

            // Apply rotation if needed
            val rotatedBitmap = if (image.rotation != 0) {
                val matrix = Matrix().apply { postRotate(image.rotation.toFloat()) }
                Bitmap.createBitmap(bitmap, 0, 0, bitmap.width, bitmap.height, matrix, true).also {
                    if (it != bitmap) bitmap.recycle()
                }
            } else {
                bitmap
            }

            // Calculate crop dimensions
            val cropX = (cropRegion.left * rotatedBitmap.width).toInt()
            val cropY = (cropRegion.top * rotatedBitmap.height).toInt()
            val cropWidth = (cropRegion.widthPercent * rotatedBitmap.width).toInt()
            val cropHeight = (cropRegion.heightPercent * rotatedBitmap.height).toInt()

            // Validate crop region
            if (cropX < 0 || cropY < 0 || cropWidth <= 0 || cropHeight <= 0 ||
                cropX + cropWidth > rotatedBitmap.width ||
                cropY + cropHeight > rotatedBitmap.height
            ) {
                rotatedBitmap.recycle()
                return@withContext Result.failure(Exception("Invalid crop region"))
            }

            // Crop the bitmap
            val croppedBitmap = Bitmap.createBitmap(
                rotatedBitmap,
                cropX,
                cropY,
                cropWidth,
                cropHeight
            )

            if (croppedBitmap != rotatedBitmap) {
                rotatedBitmap.recycle()
            }

            // Convert back to bytes
            val outputStream = ByteArrayOutputStream()
            croppedBitmap.compress(Bitmap.CompressFormat.JPEG, 90, outputStream)
            val croppedBytes = outputStream.toByteArray()

            val result = CapturedImage(
                bytes = croppedBytes,
                width = croppedBitmap.width,
                height = croppedBitmap.height,
                rotation = 0, // Rotation already applied
                mimeType = image.mimeType,
                timestamp = System.currentTimeMillis()
            )

            croppedBitmap.recycle()

            Result.success(result)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
