package com.neome.feature.camera.presentation.crop

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.neome.feature.camera.domain.model.CapturedImage
import com.neome.feature.camera.domain.model.CropRegion
import com.neome.feature.camera.domain.usecase.CropImageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel for image crop screen.
 * Manages crop state using MVI pattern.
 */
@HiltViewModel
class ImageCropViewModel @Inject constructor(
    private val cropImageUseCase: CropImageUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(ImageCropState())
    val state = _state.asStateFlow()

    private val _effect = Channel<ImageCropEffect>()
    val effect = _effect.receiveAsFlow()

    /**
     * Set the source image to be cropped.
     */
    fun setSourceImage(image: CapturedImage) {
        _state.update { it.copy(sourceImage = image) }
    }

    /**
     * Set initial aspect ratio.
     */
    fun setAspectRatio(aspectRatio: AspectRatio) {
        _state.update { it.copy(aspectRatio = aspectRatio) }
    }

    /**
     * Single entry point for all user actions.
     */
    fun onEvent(event: ImageCropEvent) {
        when (event) {
            is ImageCropEvent.CropRegionChanged -> updateCropRegion(event.region)
            is ImageCropEvent.AspectRatioSelected -> updateAspectRatio(event.ratio)
            is ImageCropEvent.ConfirmCrop -> confirmCrop()
            is ImageCropEvent.Cancel -> cancel()
            is ImageCropEvent.Reset -> reset()
        }
    }

    private fun updateCropRegion(region: CropRegion) {
        _state.update { it.copy(cropRegion = region) }
    }

    private fun updateAspectRatio(ratio: AspectRatio) {
        _state.update { it.copy(aspectRatio = ratio) }
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
}
