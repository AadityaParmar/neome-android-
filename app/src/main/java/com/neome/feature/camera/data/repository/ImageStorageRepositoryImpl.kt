package com.neome.feature.camera.data.repository

import com.neome.feature.camera.data.source.ImageFileDataSource
import com.neome.feature.camera.domain.model.CapturedImage
import com.neome.feature.camera.domain.model.ImageDirectory
import com.neome.feature.camera.domain.model.ImageQuality
import com.neome.feature.camera.domain.model.SavedImageResult
import com.neome.feature.camera.domain.repository.ImageStorageRepository
import javax.inject.Inject

/**
 * Implementation of ImageStorageRepository.
 * Delegates to ImageFileDataSource for actual file operations.
 */
class ImageStorageRepositoryImpl @Inject constructor(
    private val imageFileDataSource: ImageFileDataSource
) : ImageStorageRepository {

    override suspend fun saveImage(
        image: CapturedImage,
        fileName: String?,
        quality: ImageQuality,
        directory: ImageDirectory
    ): Result<SavedImageResult> {
        return imageFileDataSource.saveImage(image, fileName, quality, directory)
    }

    override suspend fun deleteImage(uri: String): Result<Unit> {
        return imageFileDataSource.deleteImage(uri)
    }
}
