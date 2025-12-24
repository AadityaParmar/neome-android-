package com.neome.feature.camera.presentation.components

import android.content.Context
import android.graphics.BitmapFactory
import android.view.ScaleGestureDetector
import androidx.camera.core.Camera
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.core.ImageProxy
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.neome.feature.camera.domain.model.CapturedImage
import com.neome.feature.camera.presentation.capture.CameraFacing
import com.neome.feature.camera.presentation.capture.FlashMode
import java.util.concurrent.Executors

/**
 * Camera preview composable using CameraX with zoom and proper flash handling.
 *
 * Flash is explicitly applied at capture time to ensure the flash state
 * always matches what user expects.
 */
@Composable
fun CameraPreviewView(
    cameraFacing: CameraFacing,
    flashMode: FlashMode,
    isCapturing: Boolean,
    onImageCaptured: (CapturedImage) -> Unit,
    onError: (String) -> Unit,
    onCameraReady: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val lifecycleOwner = androidx.lifecycle.compose.LocalLifecycleOwner.current

    // Keep flash mode as updated state to ensure capture uses current value
    val currentFlashMode by rememberUpdatedState(flashMode)

    var imageCapture by remember { mutableStateOf<ImageCapture?>(null) }
    var camera by remember { mutableStateOf<Camera?>(null) }
    var currentZoom by remember { mutableFloatStateOf(1f) }
    val cameraExecutor = remember { Executors.newSingleThreadExecutor() }

    // Create PreviewView with pinch-to-zoom
    val previewView = remember {
        PreviewView(context).apply {
            val scaleGestureDetector = ScaleGestureDetector(
                context,
                object : ScaleGestureDetector.SimpleOnScaleGestureListener() {
                    override fun onScale(detector: ScaleGestureDetector): Boolean {
                        val cam = camera ?: return true
                        val zoomState = cam.cameraInfo.zoomState.value ?: return true

                        val newZoom = (currentZoom * detector.scaleFactor)
                            .coerceIn(zoomState.minZoomRatio, zoomState.maxZoomRatio)

                        cam.cameraControl.setZoomRatio(newZoom)
                        currentZoom = newZoom
                        return true
                    }
                }
            )

            setOnTouchListener { _, event ->
                scaleGestureDetector.onTouchEvent(event)
                true
            }
        }
    }

    // Trigger capture when isCapturing changes to true
    // CRITICAL: Apply flash mode at capture time for reliable flash behavior
    LaunchedEffect(isCapturing) {
        if (isCapturing) {
            val capture = imageCapture
            if (capture != null) {
                // Apply flash mode immediately before capture
                capture.flashMode = when (currentFlashMode) {
                    FlashMode.OFF -> ImageCapture.FLASH_MODE_OFF
                    FlashMode.ON -> ImageCapture.FLASH_MODE_ON
                    FlashMode.AUTO -> ImageCapture.FLASH_MODE_AUTO
                }

                captureImage(
                    imageCapture = capture,
                    context = context,
                    onImageCaptured = onImageCaptured,
                    onError = onError
                )
            } else {
                onError("Camera not ready")
            }
        }
    }

    // Setup camera - only rebind when camera facing changes
    LaunchedEffect(cameraFacing) {
        val cameraProviderFuture = ProcessCameraProvider.getInstance(context)

        cameraProviderFuture.addListener({
            try {
                val cameraProvider = cameraProviderFuture.get()

                val preview = Preview.Builder()
                    .build()
                    .also {
                        it.surfaceProvider = previewView.surfaceProvider
                    }

                // Create ImageCapture with initial flash mode
                val newImageCapture = ImageCapture.Builder()
                    .setCaptureMode(ImageCapture.CAPTURE_MODE_MINIMIZE_LATENCY)
                    .setFlashMode(
                        when (currentFlashMode) {
                            FlashMode.OFF -> ImageCapture.FLASH_MODE_OFF
                            FlashMode.ON -> ImageCapture.FLASH_MODE_ON
                            FlashMode.AUTO -> ImageCapture.FLASH_MODE_AUTO
                        }
                    )
                    .build()

                imageCapture = newImageCapture

                val cameraSelector = when (cameraFacing) {
                    CameraFacing.BACK -> CameraSelector.DEFAULT_BACK_CAMERA
                    CameraFacing.FRONT -> CameraSelector.DEFAULT_FRONT_CAMERA
                }

                cameraProvider.unbindAll()
                camera = cameraProvider.bindToLifecycle(
                    lifecycleOwner,
                    cameraSelector,
                    preview,
                    newImageCapture
                )

                // Reset zoom when switching cameras
                currentZoom = 1f

                onCameraReady()
            } catch (e: Exception) {
                onError("Failed to initialize camera: ${e.message}")
            }
        }, ContextCompat.getMainExecutor(context))
    }

    DisposableEffect(Unit) {
        onDispose {
            cameraExecutor.shutdown()
        }
    }

    AndroidView(
        factory = { previewView },
        modifier = modifier
    )
}

private fun captureImage(
    imageCapture: ImageCapture,
    context: Context,
    onImageCaptured: (CapturedImage) -> Unit,
    onError: (String) -> Unit
) {
    imageCapture.takePicture(
        ContextCompat.getMainExecutor(context),
        object : ImageCapture.OnImageCapturedCallback() {
            override fun onCaptureSuccess(image: ImageProxy) {
                try {
                    val buffer = image.planes[0].buffer
                    val bytes = ByteArray(buffer.remaining())
                    buffer.get(bytes)

                    // Decode to get dimensions
                    val options = BitmapFactory.Options().apply {
                        inJustDecodeBounds = true
                    }
                    BitmapFactory.decodeByteArray(bytes, 0, bytes.size, options)

                    val capturedImage = CapturedImage(
                        bytes = bytes,
                        width = options.outWidth,
                        height = options.outHeight,
                        rotation = image.imageInfo.rotationDegrees,
                        mimeType = "image/jpeg"
                    )

                    image.close()
                    onImageCaptured(capturedImage)
                } catch (e: Exception) {
                    image.close()
                    onError("Failed to process captured image: ${e.message}")
                }
            }

            override fun onError(exception: ImageCaptureException) {
                onError("Capture failed: ${exception.message}")
            }
        }
    )
}
