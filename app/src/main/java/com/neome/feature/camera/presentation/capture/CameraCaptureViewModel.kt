package com.neome.feature.camera.presentation.capture

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.neome.feature.camera.domain.model.CapturedImage
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * ViewModel for camera capture screen.
 * Manages camera state using MVI pattern.
 */
class CameraCaptureViewModel : ViewModel() {

    private val _state = MutableStateFlow(CameraCaptureState())
    val state = _state.asStateFlow()

    private val _effect = Channel<CameraCaptureEffect>()
    val effect = _effect.receiveAsFlow()

    /**
     * Single entry point for all user actions.
     */
    fun onEvent(event: CameraCaptureEvent) {
        when (event) {
            is CameraCaptureEvent.CaptureClicked -> captureImage()
            is CameraCaptureEvent.SwitchCamera -> switchCamera()
            is CameraCaptureEvent.FlashModeChanged -> updateFlashMode(event.mode)
            is CameraCaptureEvent.RetryPermission -> retryPermission()
            is CameraCaptureEvent.CameraReady -> cameraReady()
            is CameraCaptureEvent.Cancel -> cancel()
        }
    }

    private fun captureImage() {
        viewModelScope.launch {
            _state.update { it.copy(isCapturing = true) }
            // Actual capture is triggered from CameraPreviewView
            // Result is received via onImageCaptured() callback
        }
    }

    private fun switchCamera() {
        _state.update {
            it.copy(
                cameraFacing = if (it.cameraFacing == CameraFacing.BACK)
                    CameraFacing.FRONT else CameraFacing.BACK
            )
        }
    }

    private fun updateFlashMode(mode: FlashMode) {
        _state.update { it.copy(flashMode = mode) }
    }

    private fun cameraReady() {
        _state.update { it.copy(isCameraReady = true, error = null) }
    }

    private fun retryPermission() {
        _state.update { it.copy(error = null) }
    }

    private fun cancel() {
        viewModelScope.launch {
            _effect.send(CameraCaptureEffect.Cancelled)
        }
    }

    /**
     * Called from CameraPreviewView when capture completes.
     */
    fun onImageCaptured(image: CapturedImage) {
        viewModelScope.launch {
            _state.update { it.copy(isCapturing = false) }
            _effect.send(CameraCaptureEffect.ImageCaptured(image))
        }
    }

    /**
     * Called when capture fails.
     */
    fun onCaptureError(message: String) {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    isCapturing = false,
                    error = CameraError.CaptureError(message)
                )
            }
            _effect.send(CameraCaptureEffect.Error(CameraError.CaptureError(message)))
        }
    }

    /**
     * Called when camera permission is denied.
     */
    fun onPermissionDenied() {
        _state.update { it.copy(error = CameraError.PermissionDenied) }
    }

    /**
     * Called when camera is unavailable.
     */
    fun onCameraUnavailable() {
        _state.update { it.copy(error = CameraError.CameraUnavailable) }
    }
}
