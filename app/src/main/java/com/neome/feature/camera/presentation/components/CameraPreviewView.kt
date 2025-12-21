package com.neome.feature.camera.presentation.components

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import com.neome.feature.camera.domain.model.CapturedImage
import com.neome.feature.camera.presentation.capture.CameraFacing
import com.neome.feature.camera.presentation.capture.FlashMode
import java.io.ByteArrayOutputStream
import java.util.concurrent.Executors

/**
 * Camera preview composable using CameraX.
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
    val lifecycleOwner = LocalLifecycleOwner.current

    var imageCapture by remember { mutableStateOf<ImageCapture?>(null) }
    val cameraExecutor = remember { Executors.newSingleThreadExecutor() }

    val previewView = remember { PreviewView(context) }

    // Trigger capture when isCapturing changes to true
    LaunchedEffect(isCapturing) {
        if (isCapturing && imageCapture != null) {
            captureImage(
                imageCapture = imageCapture!!,
                context = context,
                onImageCaptured = onImageCaptured,
                onError = onError
            )
        }
    }

    // Setup camera
    LaunchedEffect(cameraFacing, flashMode) {
        val cameraProviderFuture = ProcessCameraProvider.getInstance(context)

        cameraProviderFuture.addListener({
            try {
                val cameraProvider = cameraProviderFuture.get()

                val preview = Preview.Builder()
                    .build()
                    .also {
                        it.surfaceProvider = previewView.surfaceProvider
                    }

                imageCapture = ImageCapture.Builder()
                    .setCaptureMode(ImageCapture.CAPTURE_MODE_MINIMIZE_LATENCY)
                    .setFlashMode(
                        when (flashMode) {
                            FlashMode.OFF -> ImageCapture.FLASH_MODE_OFF
                            FlashMode.ON -> ImageCapture.FLASH_MODE_ON
                            FlashMode.AUTO -> ImageCapture.FLASH_MODE_AUTO
                        }
                    )
                    .build()

                val cameraSelector = when (cameraFacing) {
                    CameraFacing.BACK -> CameraSelector.DEFAULT_BACK_CAMERA
                    CameraFacing.FRONT -> CameraSelector.DEFAULT_FRONT_CAMERA
                }

                cameraProvider.unbindAll()
                cameraProvider.bindToLifecycle(
                    lifecycleOwner,
                    cameraSelector,
                    preview,
                    imageCapture
                )

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
