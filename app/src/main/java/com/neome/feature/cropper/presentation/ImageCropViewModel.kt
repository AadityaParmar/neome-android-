package com.neome.feature.cropper.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.neome.feature.cropper.domain.model.CroppableImage
import com.neome.feature.cropper.domain.model.CropRegion
import com.neome.feature.cropper.domain.usecase.CropImageUseCase
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * ViewModel for image crop screen.
 * Manages crop state using MVI pattern.
 *
 * Only FREE crop mode is supported - no aspect ratio constraints.
 */
class ImageCropViewModel(
    private val cropImageUseCase: CropImageUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(ImageCropState())
    val state = _state.asStateFlow()

    private val _effect = Channel<ImageCropEffect>()
    val effect = _effect.receiveAsFlow()

    /**
     * Set the source image to be cropped.
     */
    fun setSourceImage(image: CroppableImage) {
        _state.update { it.copy(sourceImage = image) }
    }

    /**
     * Set initial aspect ratio (kept for backward compatibility, but ignored).
     */
    fun setAspectRatio(aspectRatio: AspectRatio) {
        // Ignored - only free crop is supported
    }

    /**
     * Single entry point for all user actions.
     */
    fun onEvent(event: ImageCropEvent) {
        when (event) {
            is ImageCropEvent.CropRegionChanged -> updateCropRegion(event.region)
            is ImageCropEvent.ConfirmCrop -> confirmCrop()
            is ImageCropEvent.Cancel -> cancel()
            is ImageCropEvent.Reset -> reset()
        }
    }

    private fun updateCropRegion(region: CropRegion) {
        _state.update { it.copy(cropRegion = region) }
    }

    private fun confirmCrop() {
        val sourceImage = _state.value.sourceImage ?: return
        val cropRegion = _state.value.cropRegion

        // If crop region is full, skip cropping
        if (cropRegion == CropRegion.FULL) {
            viewModelScope.launch {
                _effect.send(ImageCropEffect.CropConfirmed(sourceImage))
            }
            return
        }

        viewModelScope.launch {
            _state.update { it.copy(isProcessing = true, error = null) }

            cropImageUseCase(sourceImage, cropRegion)
                .onSuccess { croppedImage ->
                    _state.update { it.copy(isProcessing = false) }
                    _effect.send(ImageCropEffect.CropConfirmed(croppedImage))
                }
                .onFailure { error ->
                    _state.update {
                        it.copy(isProcessing = false, error = error.message)
                    }
                    _effect.send(ImageCropEffect.Error(error.message ?: "Crop failed"))
                }
        }
    }

    private fun cancel() {
        viewModelScope.launch {
            _state.value.sourceImage?.let { image ->
                _effect.send(ImageCropEffect.Cancelled(image))
            }
        }
    }

    private fun reset() {
        _state.update { it.copy(cropRegion = CropRegion.FULL, error = null) }
    }

    /**
     * Factory for creating ImageCropViewModel with manual dependency injection.
     */
    class Factory(
        private val cropImageUseCase: CropImageUseCase
    ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(ImageCropViewModel::class.java)) {
                return ImageCropViewModel(cropImageUseCase) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    }
}
