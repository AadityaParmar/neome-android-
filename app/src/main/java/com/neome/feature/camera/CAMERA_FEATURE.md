# Camera Feature - Reusable Capture with Optional Crop and Save

## Overview

A modular, native camera feature providing image capture with optional in-app cropping and saving. Designed for reuse across multiple app contexts with explicit control over each step.

**Pattern:** MVI (complex state management with multiple user interactions)

---

## Design Principles

1. **Composable, not prescriptive** - Camera captures, caller decides what happens next
2. **Explicit control** - No hidden behavior, no implicit navigation
3. **Separation of concerns** - Capture, crop, and save are independent modules
4. **Zero third-party dependencies** - Platform-native APIs only (CameraX is AndroidX)
5. **Opt-in cropping** - Never implicit, always caller-requested

---

## Folder Structure

```
feature/camera/
├── domain/
│   ├── model/
│   │   ├── CapturedImage.kt           # Captured image data
│   │   ├── CropRegion.kt              # Crop coordinates (0-1 normalized)
│   │   ├── SavedImageResult.kt        # Save operation result
│   │   └── ImageQuality.kt            # Compression quality enum
│   │
│   ├── repository/
│   │   └── ImageStorageRepository.kt  # Save/delete interface
│   │
│   └── usecase/
│       ├── CropImageUseCase.kt        # Crop business logic
│       └── SaveImageUseCase.kt        # Save business logic
│
├── data/
│   ├── repository/
│   │   └── ImageStorageRepositoryImpl.kt
│   │
│   └── source/
│       └── ImageFileDataSource.kt     # File I/O operations
│
├── presentation/
│   ├── capture/                       # MVI - Camera Screen
│   │   ├── CameraCaptureState.kt
│   │   ├── CameraCaptureEvent.kt
│   │   ├── CameraCaptureEffect.kt
│   │   ├── CameraCaptureViewModel.kt
│   │   └── CameraCaptureScreen.kt
│   │
│   ├── crop/                          # MVI - Crop Screen
│   │   ├── ImageCropState.kt
│   │   ├── ImageCropEvent.kt
│   │   ├── ImageCropEffect.kt
│   │   ├── ImageCropViewModel.kt
│   │   └── ImageCropScreen.kt
│   │
│   ├── components/                    # Reusable UI components
│   │   ├── CameraPreviewView.kt
│   │   ├── CaptureButton.kt
│   │   ├── CropOverlay.kt
│   │   └── CropHandles.kt
│   │
│   └── coordinator/                   # Flow orchestration
│       ├── CameraFlowConfig.kt
│       ├── CameraFlowResult.kt
│       └── CameraFlowCoordinator.kt
│
└── di/
    └── CameraModule.kt                # Hilt DI module
```

---

## Domain Layer

### Models (Pure Kotlin - No Android Dependencies)

#### CapturedImage.kt
```kotlin
package com.neome.feature.camera.domain.model

/**
 * Represents a captured image with raw bytes and metadata.
 * Returned from camera capture, passed to crop/save.
 */
data class CapturedImage(
    val bytes: ByteArray,
    val width: Int,
    val height: Int,
    val rotation: Int,
    val mimeType: String = "image/jpeg",
    val timestamp: Long = System.currentTimeMillis()
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as CapturedImage
        return bytes.contentEquals(other.bytes) &&
                width == other.width &&
                height == other.height &&
                rotation == other.rotation
    }

    override fun hashCode(): Int {
        var result = bytes.contentHashCode()
        result = 31 * result + width
        result = 31 * result + height
        result = 31 * result + rotation
        return result
    }
}
```

#### CropRegion.kt
```kotlin
package com.neome.feature.camera.domain.model

/**
 * Normalized crop region (0.0 to 1.0 percentages).
 * Independent of actual image dimensions.
 */
data class CropRegion(
    val left: Float,
    val top: Float,
    val right: Float,
    val bottom: Float
) {
    init {
        require(left in 0f..1f) { "left must be between 0 and 1" }
        require(top in 0f..1f) { "top must be between 0 and 1" }
        require(right in 0f..1f) { "right must be between 0 and 1" }
        require(bottom in 0f..1f) { "bottom must be between 0 and 1" }
        require(left < right) { "left must be less than right" }
        require(top < bottom) { "top must be less than bottom" }
    }

    companion object {
        val FULL = CropRegion(0f, 0f, 1f, 1f)
    }

    val widthPercent: Float get() = right - left
    val heightPercent: Float get() = bottom - top
}
```

#### ImageQuality.kt
```kotlin
package com.neome.feature.camera.domain.model

/**
 * JPEG compression quality levels.
 */
enum class ImageQuality(val compressionPercent: Int) {
    LOW(50),
    MEDIUM(75),
    HIGH(90),
    MAXIMUM(100)
}
```

#### SavedImageResult.kt
```kotlin
package com.neome.feature.camera.domain.model

/**
 * Result of a successful image save operation.
 */
data class SavedImageResult(
    val uri: String,
    val fileName: String,
    val filePath: String,
    val sizeBytes: Long,
    val timestamp: Long = System.currentTimeMillis()
)
```

### Repository Interface

#### ImageStorageRepository.kt
```kotlin
package com.neome.feature.camera.domain.repository

import com.neome.feature.camera.domain.model.CapturedImage
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

enum class ImageDirectory {
    PICTURES,
    DCIM,
    APP_INTERNAL
}
```

### Use Cases

#### CropImageUseCase.kt
```kotlin
package com.neome.feature.camera.domain.usecase

import com.neome.feature.camera.domain.model.CapturedImage
import com.neome.feature.camera.domain.model.CropRegion
import javax.inject.Inject

/**
 * Crops an image based on the provided region.
 * Performs the operation on a background thread.
 */
class CropImageUseCase @Inject constructor() {

    suspend operator fun invoke(
        image: CapturedImage,
        cropRegion: CropRegion
    ): Result<CapturedImage>
}
```

#### SaveImageUseCase.kt
```kotlin
package com.neome.feature.camera.domain.usecase

import com.neome.feature.camera.domain.model.CapturedImage
import com.neome.feature.camera.domain.model.ImageQuality
import com.neome.feature.camera.domain.model.SavedImageResult
import com.neome.feature.camera.domain.repository.ImageStorageRepository
import javax.inject.Inject

/**
 * Saves an image to device storage.
 */
class SaveImageUseCase @Inject constructor(
    private val repository: ImageStorageRepository
) {
    suspend operator fun invoke(
        image: CapturedImage,
        fileName: String? = null,
        quality: ImageQuality = ImageQuality.HIGH
    ): Result<SavedImageResult> {
        return repository.saveImage(image, fileName, quality)
    }
}
```

---

## Presentation Layer - Camera Capture (MVI)

### CameraCaptureState.kt
```kotlin
package com.neome.feature.camera.presentation.capture

import com.neome.feature.camera.domain.model.CapturedImage

/**
 * Single immutable state for camera capture screen.
 */
data class CameraCaptureState(
    val isCameraReady: Boolean = false,
    val isCapturing: Boolean = false,
    val flashMode: FlashMode = FlashMode.OFF,
    val cameraFacing: CameraFacing = CameraFacing.BACK,
    val error: CameraError? = null
)

enum class FlashMode { OFF, ON, AUTO }

enum class CameraFacing { FRONT, BACK }

sealed interface CameraError {
    data object PermissionDenied : CameraError
    data object CameraUnavailable : CameraError
    data class CaptureError(val message: String) : CameraError
}
```

### CameraCaptureEvent.kt
```kotlin
package com.neome.feature.camera.presentation.capture

/**
 * All possible user actions on camera screen.
 */
sealed interface CameraCaptureEvent {
    data object CaptureClicked : CameraCaptureEvent
    data object SwitchCamera : CameraCaptureEvent
    data class FlashModeChanged(val mode: FlashMode) : CameraCaptureEvent
    data object RetryPermission : CameraCaptureEvent
    data object CameraReady : CameraCaptureEvent
    data object Cancel : CameraCaptureEvent
}
```

### CameraCaptureEffect.kt
```kotlin
package com.neome.feature.camera.presentation.capture

import com.neome.feature.camera.domain.model.CapturedImage

/**
 * One-time side effects from camera screen.
 */
sealed interface CameraCaptureEffect {
    data class ImageCaptured(val image: CapturedImage) : CameraCaptureEffect
    data object Cancelled : CameraCaptureEffect
    data class Error(val error: CameraError) : CameraCaptureEffect
}
```

### CameraCaptureViewModel.kt
```kotlin
package com.neome.feature.camera.presentation.capture

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CameraCaptureViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow(CameraCaptureState())
    val state = _state.asStateFlow()

    private val _effect = Channel<CameraCaptureEffect>()
    val effect = _effect.receiveAsFlow()

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
            // Camera capture logic - result sent via effect
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

    // Called from CameraPreviewView when capture completes
    fun onImageCaptured(image: CapturedImage) {
        viewModelScope.launch {
            _state.update { it.copy(isCapturing = false) }
            _effect.send(CameraCaptureEffect.ImageCaptured(image))
        }
    }

    fun onCaptureError(message: String) {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    isCapturing = false,
                    error = CameraError.CaptureError(message)
                )
            }
        }
    }

    fun onPermissionDenied() {
        _state.update { it.copy(error = CameraError.PermissionDenied) }
    }

    fun onCameraUnavailable() {
        _state.update { it.copy(error = CameraError.CameraUnavailable) }
    }
}
```

### CameraCaptureScreen.kt
```kotlin
package com.neome.feature.camera.presentation.capture

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.neome.feature.camera.domain.model.CapturedImage

@Composable
fun CameraCaptureScreen(
    viewModel: CameraCaptureViewModel = hiltViewModel(),
    onImageCaptured: (CapturedImage) -> Unit,
    onCancelled: () -> Unit,
    onError: (CameraError) -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

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
        onEvent = viewModel::onEvent
    )
}

@Composable
private fun CameraCaptureContent(
    state: CameraCaptureState,
    onEvent: (CameraCaptureEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    // Camera preview + capture button
    // Error handling UI
    // Flash/switch camera controls
}
```

---

## Presentation Layer - Image Crop (MVI)

### ImageCropState.kt
```kotlin
package com.neome.feature.camera.presentation.crop

import com.neome.feature.camera.domain.model.CapturedImage
import com.neome.feature.camera.domain.model.CropRegion

/**
 * Single immutable state for crop screen.
 * NOTE: Image preview is ONLY shown in this screen.
 */
data class ImageCropState(
    val sourceImage: CapturedImage? = null,
    val cropRegion: CropRegion = CropRegion.FULL,
    val aspectRatio: AspectRatio = AspectRatio.Free,
    val isProcessing: Boolean = false,
    val error: String? = null
)

sealed interface AspectRatio {
    data object Free : AspectRatio
    data object Square : AspectRatio        // 1:1
    data object FourThree : AspectRatio     // 4:3
    data object SixteenNine : AspectRatio   // 16:9
    data class Custom(val width: Int, val height: Int) : AspectRatio
}
```

### ImageCropEvent.kt
```kotlin
package com.neome.feature.camera.presentation.crop

import com.neome.feature.camera.domain.model.CropRegion

/**
 * All possible user actions on crop screen.
 */
sealed interface ImageCropEvent {
    data class CropRegionChanged(val region: CropRegion) : ImageCropEvent
    data class AspectRatioSelected(val ratio: AspectRatio) : ImageCropEvent
    data object ConfirmCrop : ImageCropEvent
    data object Cancel : ImageCropEvent
    data object Reset : ImageCropEvent
}
```

### ImageCropEffect.kt
```kotlin
package com.neome.feature.camera.presentation.crop

import com.neome.feature.camera.domain.model.CapturedImage

/**
 * One-time side effects from crop screen.
 */
sealed interface ImageCropEffect {
    data class CropConfirmed(val croppedImage: CapturedImage) : ImageCropEffect
    data class Cancelled(val originalImage: CapturedImage) : ImageCropEffect
    data class Error(val message: String) : ImageCropEffect
}
```

### ImageCropViewModel.kt
```kotlin
package com.neome.feature.camera.presentation.crop

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.neome.feature.camera.domain.model.CapturedImage
import com.neome.feature.camera.domain.usecase.CropImageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ImageCropViewModel @Inject constructor(
    private val cropImageUseCase: CropImageUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = MutableStateFlow(ImageCropState())
    val state = _state.asStateFlow()

    private val _effect = Channel<ImageCropEffect>()
    val effect = _effect.receiveAsFlow()

    fun setSourceImage(image: CapturedImage) {
        _state.update { it.copy(sourceImage = image) }
    }

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

        viewModelScope.launch {
            _state.update { it.copy(isProcessing = true) }

            cropImageUseCase(sourceImage, _state.value.cropRegion)
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
        _state.update { it.copy(cropRegion = CropRegion.FULL) }
    }
}
```

### ImageCropScreen.kt
```kotlin
package com.neome.feature.camera.presentation.crop

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.neome.feature.camera.domain.model.CapturedImage

@Composable
fun ImageCropScreen(
    sourceImage: CapturedImage,
    aspectRatio: AspectRatio = AspectRatio.Free,
    viewModel: ImageCropViewModel = hiltViewModel(),
    onCropConfirmed: (CapturedImage) -> Unit,
    onCancelled: (CapturedImage) -> Unit,
    onError: (String) -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(sourceImage) {
        viewModel.setSourceImage(sourceImage)
    }

    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is ImageCropEffect.CropConfirmed -> onCropConfirmed(effect.croppedImage)
                is ImageCropEffect.Cancelled -> onCancelled(effect.originalImage)
                is ImageCropEffect.Error -> onError(effect.message)
            }
        }
    }

    ImageCropContent(
        state = state,
        onEvent = viewModel::onEvent
    )
}

@Composable
private fun ImageCropContent(
    state: ImageCropState,
    onEvent: (ImageCropEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    // Image preview with crop overlay
    // Crop handles for resizing
    // Aspect ratio selector
    // Confirm/Cancel buttons
}
```

---

## Flow Coordinator

### CameraFlowConfig.kt
```kotlin
package com.neome.feature.camera.presentation.coordinator

import com.neome.feature.camera.domain.model.ImageQuality
import com.neome.feature.camera.domain.repository.ImageDirectory
import com.neome.feature.camera.presentation.capture.CameraFacing
import com.neome.feature.camera.presentation.crop.AspectRatio

/**
 * Configuration for camera flow.
 * Caller controls which steps are enabled.
 */
data class CameraFlowConfig(
    val enableCropping: Boolean = false,
    val enableSaving: Boolean = false,
    val aspectRatio: AspectRatio = AspectRatio.Free,
    val imageQuality: ImageQuality = ImageQuality.HIGH,
    val saveDirectory: ImageDirectory = ImageDirectory.PICTURES,
    val initialCameraFacing: CameraFacing = CameraFacing.BACK
)
```

### CameraFlowResult.kt
```kotlin
package com.neome.feature.camera.presentation.coordinator

import com.neome.feature.camera.domain.model.CapturedImage
import com.neome.feature.camera.domain.model.SavedImageResult

/**
 * Result of the camera flow.
 */
sealed interface CameraFlowResult {
    data class Success(
        val capturedImage: CapturedImage,
        val savedResult: SavedImageResult? = null,
        val wasCropped: Boolean = false
    ) : CameraFlowResult

    data object Cancelled : CameraFlowResult

    data class Error(val message: String) : CameraFlowResult
}
```

### CameraFlowCoordinator.kt
```kotlin
package com.neome.feature.camera.presentation.coordinator

import androidx.compose.runtime.Composable
import com.neome.feature.camera.domain.model.CapturedImage
import com.neome.feature.camera.domain.model.ImageQuality
import com.neome.feature.camera.domain.usecase.SaveImageUseCase
import com.neome.feature.camera.presentation.capture.CameraCaptureScreen
import com.neome.feature.camera.presentation.crop.ImageCropScreen

/**
 * Coordinates the flow between capture, crop, and save.
 *
 * Flow A: Capture Only
 *   config = CameraFlowConfig()
 *   Camera → Return CapturedImage
 *
 * Flow B: Capture → Crop → Save
 *   config = CameraFlowConfig(enableCropping = true, enableSaving = true)
 *   Camera → Crop → Save → Return SavedImageResult
 *
 * Flow C: Capture → Save
 *   config = CameraFlowConfig(enableSaving = true)
 *   Camera → Save → Return SavedImageResult
 */
@Composable
fun CameraFlowCoordinator(
    config: CameraFlowConfig,
    onResult: (CameraFlowResult) -> Unit
) {
    // Navigation state machine handling
    // Capture → optional Crop → optional Save
}
```

---

## Supported Flows

### Flow A: Capture Only
```
Camera Screen → CapturedImage (returned to caller)
```
```kotlin
CameraFlowConfig(
    enableCropping = false,
    enableSaving = false
)
```

### Flow B: Capture → Crop → Save
```
Camera Screen → Crop Screen (preview here) → Save → SavedImageResult
```
```kotlin
CameraFlowConfig(
    enableCropping = true,
    enableSaving = true,
    aspectRatio = AspectRatio.Square
)
```

### Flow C: Capture → Save
```
Camera Screen → Save → SavedImageResult (no preview)
```
```kotlin
CameraFlowConfig(
    enableCropping = false,
    enableSaving = true
)
```

---

## Usage Examples

### Simple Capture
```kotlin
CameraFlowCoordinator(
    config = CameraFlowConfig(),
    onResult = { result ->
        when (result) {
            is CameraFlowResult.Success -> {
                val image = result.capturedImage
                // Use captured image bytes
            }
            is CameraFlowResult.Cancelled -> { /* Handle cancel */ }
            is CameraFlowResult.Error -> { /* Handle error */ }
        }
    }
)
```

### Capture with Square Crop and Save
```kotlin
CameraFlowCoordinator(
    config = CameraFlowConfig(
        enableCropping = true,
        enableSaving = true,
        aspectRatio = AspectRatio.Square,
        imageQuality = ImageQuality.HIGH
    ),
    onResult = { result ->
        when (result) {
            is CameraFlowResult.Success -> {
                val uri = result.savedResult?.uri
                // Use saved image URI
            }
            // ...
        }
    }
)
```

---

## Technical Notes

### Camera Implementation
- **CameraX** (AndroidX library - not third-party)
- Lifecycle-aware binding via `ProcessCameraProvider`
- `ImageCapture` use case for still photos
- Handle EXIF rotation metadata

### Image Processing
- `android.graphics.Bitmap` for cropping
- `Dispatchers.IO` for heavy operations
- `BitmapFactory.Options.inSampleSize` for large images
- Prompt resource cleanup

### Storage
- **MediaStore API** for Android 10+ (scoped storage)
- **FileProvider** for app-internal storage
- Unique filenames with timestamps
- Configurable JPEG quality

### Permissions
- `Manifest.permission.CAMERA` - Required at runtime
- No storage permission needed (MediaStore handles it on Android 10+)

---

## Preview Rules (Critical)

1. **Camera Screen**: NO image preview after capture
2. **Crop Screen**: ONLY place where image is shown
3. **Direct Save**: No preview, image flows directly to storage

---

## Validation Checklist

- [ ] Camera works independently of cropping
- [ ] Cropping can be enabled or skipped per use case
- [ ] Image preview exists ONLY in crop flow
- [ ] Capture-only flow has no preview or crop
- [ ] Saved image matches expected output
- [ ] No external/third-party dependencies
- [ ] Lifecycle-safe camera handling
- [ ] Proper resource cleanup
- [ ] Works across Android API 26+
- [ ] Handles configuration changes

---

## Dependencies

```kotlin
// CameraX (AndroidX - part of Jetpack, not third-party)
implementation("androidx.camera:camera-core:1.3.4")
implementation("androidx.camera:camera-camera2:1.3.4")
implementation("androidx.camera:camera-lifecycle:1.3.4")
implementation("androidx.camera:camera-view:1.3.4")

// Already in project
// - Jetpack Compose
// - Hilt
// - Coroutines
// - Lifecycle
```

---

## File Summary

| File | Layer | Purpose |
|------|-------|---------|
| `CapturedImage.kt` | Domain | Captured image data model |
| `CropRegion.kt` | Domain | Normalized crop coordinates |
| `SavedImageResult.kt` | Domain | Save operation result |
| `ImageQuality.kt` | Domain | Compression quality enum |
| `ImageStorageRepository.kt` | Domain | Storage interface |
| `CropImageUseCase.kt` | Domain | Crop business logic |
| `SaveImageUseCase.kt` | Domain | Save business logic |
| `ImageStorageRepositoryImpl.kt` | Data | Storage implementation |
| `ImageFileDataSource.kt` | Data | File I/O operations |
| `CameraCaptureState.kt` | Presentation | Camera screen state |
| `CameraCaptureEvent.kt` | Presentation | Camera user actions |
| `CameraCaptureEffect.kt` | Presentation | Camera side effects |
| `CameraCaptureViewModel.kt` | Presentation | Camera state management |
| `CameraCaptureScreen.kt` | Presentation | Camera UI |
| `ImageCropState.kt` | Presentation | Crop screen state |
| `ImageCropEvent.kt` | Presentation | Crop user actions |
| `ImageCropEffect.kt` | Presentation | Crop side effects |
| `ImageCropViewModel.kt` | Presentation | Crop state management |
| `ImageCropScreen.kt` | Presentation | Crop UI |
| `CameraFlowConfig.kt` | Presentation | Flow configuration |
| `CameraFlowResult.kt` | Presentation | Flow result |
| `CameraFlowCoordinator.kt` | Presentation | Flow orchestration |
| `CameraModule.kt` | DI | Hilt module |

---

## Next Steps

After approval:
1. Create domain models
2. Create repository interface and implementation
3. Implement use cases
4. Build camera capture screen (MVI)
5. Build crop screen (MVI)
6. Implement flow coordinator
7. Add DI module
8. Integration testing
