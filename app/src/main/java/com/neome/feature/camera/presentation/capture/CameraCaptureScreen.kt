package com.neome.feature.camera.presentation.capture

import android.Manifest
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cameraswitch
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.FlashAuto
import androidx.compose.material.icons.filled.FlashOff
import androidx.compose.material.icons.filled.FlashOn
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.neome.feature.camera.domain.model.CapturedImage
import com.neome.feature.camera.presentation.components.CameraPreviewView
import com.neome.feature.camera.presentation.components.CaptureButton

@Composable
fun CameraCaptureScreen(
    viewModel: CameraCaptureViewModel = hiltViewModel(),
    onImageCaptured: (CapturedImage) -> Unit,
    onCancelled: () -> Unit,
    onError: (CameraError) -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    // Permission launcher
    val permissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            viewModel.onEvent(CameraCaptureEvent.CameraReady)
        } else {
            viewModel.onPermissionDenied()
        }
    }

    // Request permission on first composition
    LaunchedEffect(Unit) {
        permissionLauncher.launch(Manifest.permission.CAMERA)
    }

    // Collect effects
    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is CameraCaptureEffect.ImageCaptured -> onImageCaptured(effect.image)
                is CameraCaptureEffect.Cancelled -> onCancelled()
                is CameraCaptureEffect.Error -> onError(effect.error)
            }
        }
    }

    CameraCaptureContent(
        state = state,
        onEvent = viewModel::onEvent,
        onImageCaptured = viewModel::onImageCaptured,
        onCaptureError = viewModel::onCaptureError,
        onRetryPermission = { permissionLauncher.launch(Manifest.permission.CAMERA) }
    )
}

@Composable
private fun CameraCaptureContent(
    state: CameraCaptureState,
    onEvent: (CameraCaptureEvent) -> Unit,
    onImageCaptured: (CapturedImage) -> Unit,
    onCaptureError: (String) -> Unit,
    onRetryPermission: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        when {
            state.error is CameraError.PermissionDenied -> {
                PermissionDeniedContent(
                    onRetry = onRetryPermission,
                    onCancel = { onEvent(CameraCaptureEvent.Cancel) }
                )
            }

            state.error is CameraError.CameraUnavailable -> {
                CameraUnavailableContent(
                    onCancel = { onEvent(CameraCaptureEvent.Cancel) }
                )
            }

            state.error is CameraError.CaptureError -> {
                CaptureErrorContent(
                    message = (state.error as CameraError.CaptureError).message,
                    onRetry = { onEvent(CameraCaptureEvent.CaptureClicked) },
                    onCancel = { onEvent(CameraCaptureEvent.Cancel) }
                )
            }

            else -> {
                // Camera preview
                CameraPreviewView(
                    cameraFacing = state.cameraFacing,
                    flashMode = state.flashMode,
                    isCapturing = state.isCapturing,
                    onImageCaptured = onImageCaptured,
                    onError = onCaptureError,
                    onCameraReady = { onEvent(CameraCaptureEvent.CameraReady) },
                    modifier = Modifier.fillMaxSize()
                )

                // Top controls
                TopControls(
                    flashMode = state.flashMode,
                    onFlashModeChanged = { onEvent(CameraCaptureEvent.FlashModeChanged(it)) },
                    onClose = { onEvent(CameraCaptureEvent.Cancel) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.TopCenter)
                        .padding(16.dp)
                )

                // Bottom controls
                BottomControls(
                    isCapturing = state.isCapturing,
                    onCaptureClick = { onEvent(CameraCaptureEvent.CaptureClicked) },
                    onSwitchCamera = { onEvent(CameraCaptureEvent.SwitchCamera) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter)
                        .padding(32.dp)
                )
            }
        }
    }
}

@Composable
private fun TopControls(
    flashMode: FlashMode,
    onFlashModeChanged: (FlashMode) -> Unit,
    onClose: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = onClose) {
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = "Close",
                tint = Color.White
            )
        }

        IconButton(
            onClick = {
                val nextMode = when (flashMode) {
                    FlashMode.OFF -> FlashMode.ON
                    FlashMode.ON -> FlashMode.AUTO
                    FlashMode.AUTO -> FlashMode.OFF
                }
                onFlashModeChanged(nextMode)
            }
        ) {
            Icon(
                imageVector = when (flashMode) {
                    FlashMode.OFF -> Icons.Default.FlashOff
                    FlashMode.ON -> Icons.Default.FlashOn
                    FlashMode.AUTO -> Icons.Default.FlashAuto
                },
                contentDescription = "Flash mode",
                tint = Color.White
            )
        }
    }
}

@Composable
private fun BottomControls(
    isCapturing: Boolean,
    onCaptureClick: () -> Unit,
    onSwitchCamera: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Placeholder for symmetry
        Spacer(modifier = Modifier.size(48.dp))

        // Capture button
        if (isCapturing) {
            CircularProgressIndicator(
                modifier = Modifier.size(72.dp),
                color = Color.White
            )
        } else {
            CaptureButton(
                onClick = onCaptureClick,
                modifier = Modifier.size(72.dp)
            )
        }

        // Switch camera
        IconButton(onClick = onSwitchCamera) {
            Icon(
                imageVector = Icons.Default.Cameraswitch,
                contentDescription = "Switch camera",
                tint = Color.White,
                modifier = Modifier.size(32.dp)
            )
        }
    }
}

@Composable
private fun PermissionDeniedContent(
    onRetry: () -> Unit,
    onCancel: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Camera Permission Required",
            style = MaterialTheme.typography.headlineSmall,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Please grant camera permission to take photos.",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.White.copy(alpha = 0.7f)
        )
        Spacer(modifier = Modifier.height(32.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            Button(onClick = onCancel) {
                Text("Cancel")
            }
            Button(onClick = onRetry) {
                Text("Grant Permission")
            }
        }
    }
}

@Composable
private fun CameraUnavailableContent(
    onCancel: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Camera Unavailable",
            style = MaterialTheme.typography.headlineSmall,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "The camera is not available on this device.",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.White.copy(alpha = 0.7f)
        )
        Spacer(modifier = Modifier.height(32.dp))
        Button(onClick = onCancel) {
            Text("Close")
        }
    }
}

@Composable
private fun CaptureErrorContent(
    message: String,
    onRetry: () -> Unit,
    onCancel: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Capture Failed",
            style = MaterialTheme.typography.headlineSmall,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = message,
            style = MaterialTheme.typography.bodyMedium,
            color = Color.White.copy(alpha = 0.7f)
        )
        Spacer(modifier = Modifier.height(32.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            Button(onClick = onCancel) {
                Text("Cancel")
            }
            Button(onClick = onRetry) {
                Text("Retry")
            }
        }
    }
}
