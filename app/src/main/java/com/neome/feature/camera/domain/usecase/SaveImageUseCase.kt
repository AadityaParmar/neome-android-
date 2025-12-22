package com.neome.feature.camera.domain.usecase

import com.neome.feature.camera.domain.model.CapturedImage
import com.neome.feature.camera.domain.model.ImageDirectory
import com.neome.feature.camera.domain.model.ImageQuality
import com.neome.feature.camera.domain.model.SavedImageResult
import com.neome.feature.camera.domain.repository.ImageStorageRepository

/**
 * Saves an image to device storage.
 */
class SaveImageUseCase(
    private val repository: ImageStorageRepository
) {
    suspend operator fun invoke(
        image: CapturedImage,
        fileName: String? = null,
        quality: ImageQuality = ImageQuality.HIGH,
        directory: ImageDirectory = ImageDirectory.PICTURES
    ): Result<SavedImageResult> {
        return repository.saveImage(image, fileName, quality, directory)
    }
}
