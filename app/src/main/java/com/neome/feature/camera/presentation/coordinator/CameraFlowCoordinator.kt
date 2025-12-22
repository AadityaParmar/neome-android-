package com.neome.feature.camera.presentation.coordinator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.neome.feature.camera.domain.model.CapturedImage
import com.neome.feature.camera.domain.usecase.SaveImageUseCase
import com.neome.feature.camera.presentation.capture.CameraCaptureScreen
import com.neome.feature.camera.presentation.capture.CameraError
import com.neome.feature.camera.presentation.crop.ImageCropScreen
import kotlinx.coroutines.launch

/**
 * Flow stage state machine.
 */
private sealed interface FlowStage {
    data object Capture : FlowStage
    data class Crop(val image: CapturedImage) : FlowStage
    data class Saving(val image: CapturedImage, val wasCropped: Boolean) : FlowStage
}

/**
 * Coordinates the flow between capture, crop, and save.
 *
 * Flow A: Capture Only
 *   Camera → Return CapturedImage
 *
 * Flow B: Capture → Crop → Save
 *   Camera → Crop (preview here) → Save → Return SavedImageResult
 *
 * Flow C: Capture → Save
 *   Camera → Save → Return SavedImageResult (no preview)
 */
@Composable
fun CameraFlowCoordinator(
    config: CameraFlowConfig,
    saveImageUseCase: SaveImageUseCase,
    onResult: (CameraFlowResult) -> Unit
) {
    var currentStage: FlowStage by remember { mutableStateOf(FlowStage.Capture) }

    when (val stage = currentStage) {
        is FlowStage.Capture -> {
            CameraCaptureScreen(
                onImageCaptured = { capturedImage ->
                    when {
                        config.enableCropping -> {
                            // Move to crop stage
                            currentStage = FlowStage.Crop(capturedImage)
                        }
                        config.enableSaving -> {
                            // Skip crop, move to save stage
                            currentStage = FlowStage.Saving(capturedImage, wasCropped = false)
                        }
                        else -> {
                            // Capture only - return immediately
                            onResult(
                                CameraFlowResult.Success(
                                    capturedImage = capturedImage,
                                    savedResult = null,
                                    wasCropped = false
                                )
                            )
                        }
                    }
                },
                onCancelled = {
                    onResult(CameraFlowResult.Cancelled)
                },
                onError = { error ->
                    onResult(
                        CameraFlowResult.Error(
                            message = when (error) {
                                is CameraError.PermissionDenied -> "Camera permission denied"
                                is CameraError.CameraUnavailable -> "Camera unavailable"
                                is CameraError.CaptureError -> error.message
                            },
                            stage = CameraFlowResult.ErrorStage.CAPTURE
                        )
                    )
                }
            )
        }

        is FlowStage.Crop -> {
            ImageCropScreen(
                sourceImage = stage.image,
                onCropConfirmed = { croppedImage ->
                    if (config.enableSaving) {
                        // Move to save stage
                        currentStage = FlowStage.Saving(croppedImage, wasCropped = true)
                    } else {
                        // Return cropped image without saving
                        onResult(
                            CameraFlowResult.Success(
                                capturedImage = croppedImage,
                                savedResult = null,
                                wasCropped = true
                            )
                        )
                    }
                },
                onCancelled = { _ ->
                    // Cancel flow
                    onResult(CameraFlowResult.Cancelled)
                },
                onError = { message ->
                    onResult(
                        CameraFlowResult.Error(
                            message = message,
                            stage = CameraFlowResult.ErrorStage.CROP
                        )
                    )
                }
            )
        }

        is FlowStage.Saving -> {
            SaveStage(
                image = stage.image,
                wasCropped = stage.wasCropped,
                config = config,
                saveImageUseCase = saveImageUseCase,
                onResult = onResult
            )
        }
    }
}

@Composable
private fun SaveStage(
    image: CapturedImage,
    wasCropped: Boolean,
    config: CameraFlowConfig,
    saveImageUseCase: SaveImageUseCase,
    onResult: (CameraFlowResult) -> Unit
) {
    val scope = rememberCoroutineScope()

    // Trigger save on first composition
    LaunchedEffect(image) {
        scope.launch {
            saveImageUseCase(
                image = image,
                quality = config.imageQuality,
                directory = config.saveDirectory
            ).onSuccess { savedResult ->
                onResult(
                    CameraFlowResult.Success(
                        capturedImage = image,
                        savedResult = savedResult,
                        wasCropped = wasCropped
                    )
                )
            }.onFailure { error ->
                onResult(
                    CameraFlowResult.Error(
                        message = error.message ?: "Failed to save image",
                        stage = CameraFlowResult.ErrorStage.SAVE
                    )
                )
            }
        }
    }

    // Show loading indicator while saving
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator(
                color = Color.White
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Saving...",
                color = Color.White
            )
        }
    }
}
