package com.neome.feature.camera.domain.repository

import com.neome.feature.camera.domain.model.CapturedImage
import com.neome.feature.camera.domain.model.ImageDirectory
import com.neome.feature.camera.domain.model.ImageQuality
import com.neome.feature.camera.domain.model.SavedImageResult

/**
 * Repository interface for image storage operations.
 * Implementation handles MediaStore/FileProvider based on Android version.
 */
interface ImageStorageRepository {

    suspend fun saveImage(
        image: CapturedImage,
        fileName: String? = null,
        quality: ImageQuality = ImageQuality.HIGH,
        directory: ImageDirectory = ImageDirectory.PICTURES
    ): Result<SavedImageResult>

    suspend fun deleteImage(uri: String): Result<Unit>
}
