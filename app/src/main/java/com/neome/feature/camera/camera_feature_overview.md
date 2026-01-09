# Camera Feature Overview

## 1. High-Level Purpose

### What the Camera Feature Does

The Camera feature provides an image capture pipeline for the application. It allows users to take photos using the device camera, optionally crop the captured image (via the separate Cropper feature), and save the result to device storage.

### Problem It Solves

The feature abstracts the complexity of Android camera operations into a focused module. It handles:

- Camera hardware initialization and lifecycle management
- Runtime permission requests for camera access
- Image capture with flash and camera-switching controls
- Cross-version storage compatibility (Android 9 and below vs. Android 10+)
- Memory-efficient image processing with proper resource cleanup

**Note:** Image cropping functionality is provided by the separate **Cropper feature** (`feature/cropper`). The Camera feature delegates to it when cropping is enabled.

### Where It Is Used

The Camera feature serves as a general-purpose image capture solution. Typical use cases include:

- Profile photo capture (capture, crop to focus on face, save)
- Document scanning (capture with maximum quality, save without cropping)
- Quick photo capture (capture and return raw bytes without saving)

The feature is invoked by other parts of the app through a flow coordinator that manages the entire capture-to-save journey.

---

## 2. Feature Structure

### Architectural Overview

The Camera feature follows Clean Architecture principles with three distinct layers:

```
┌─────────────────────────────────────────────────────────┐
│                   PRESENTATION LAYER                     │
│  (UI components, state management, user interaction)     │
├─────────────────────────────────────────────────────────┤
│                     DOMAIN LAYER                         │
│  (Business logic, models, use cases, contracts)          │
├─────────────────────────────────────────────────────────┤
│                      DATA LAYER                          │
│  (File storage, Android APIs, platform-specific code)    │
└─────────────────────────────────────────────────────────┘
```

**Key Principle:** Dependencies flow inward. The domain layer has no knowledge of the presentation or data layers. Both outer layers depend on domain abstractions.

### External Feature Dependency

The Camera feature depends on the **Cropper feature** for image cropping:

```
┌─────────────────┐         ┌─────────────────┐
│  Camera Feature │ ──────▶ │ Cropper Feature │
│                 │  uses   │                 │
│  (capture/save) │         │  (crop images)  │
└─────────────────┘         └─────────────────┘
```

When cropping is enabled, the Camera's flow coordinator:
1. Converts `CapturedImage` to `CroppableImage` (Cropper's model)
2. Invokes the Cropper's `ImageCropScreen`
3. Converts the result back to `CapturedImage` for saving

### Layer Responsibilities

**Domain Layer (Pure Kotlin)**
- Defines data models representing captured images and save results
- Declares repository interfaces that abstract storage operations
- Contains use cases for saving images
- Has zero Android framework dependencies (only Kotlin coroutines allowed)

**Data Layer (Platform-Specific)**
- Implements repository interfaces defined in domain
- Contains data sources that interact with Android file system and MediaStore
- Handles version-specific storage logic (API 29+ vs earlier versions)
- Manages file naming, directory creation, and content provider operations

**Presentation Layer (UI and State)**
- Contains one MVI-based screen: camera capture
- Manages UI state through ViewModel with immutable state object
- Handles user events and emits one-time effects for navigation/callbacks
- Includes reusable composable components (preview, capture button)
- Provides a flow coordinator that orchestrates the multi-screen journey (including Cropper)

### File Organization

```
camera/
├── domain/
│   ├── model/
│   │   ├── CapturedImage.kt      # Raw image bytes with metadata
│   │   ├── ImageDirectory.kt     # Storage location enum
│   │   ├── ImageQuality.kt       # JPEG compression levels
│   │   └── SavedImageResult.kt   # Result of save operation
│   ├── repository/
│   │   └── ImageStorageRepository.kt  # Storage contract
│   └── usecase/
│       └── SaveImageUseCase.kt   # Saves image to storage
│
├── data/
│   ├── repository/
│   │   └── ImageStorageRepositoryImpl.kt
│   └── source/
│       └── ImageFileDataSource.kt  # Android storage operations
│
└── presentation/
    ├── capture/
    │   ├── CameraCaptureState.kt
    │   ├── CameraCaptureEvent.kt
    │   ├── CameraCaptureEffect.kt
    │   ├── CameraCaptureViewModel.kt
    │   └── CameraCaptureScreen.kt
    ├── components/
    │   ├── CameraPreviewView.kt   # CameraX integration
    │   └── CaptureButton.kt       # Styled capture button
    └── coordinator/
        ├── CameraFlowConfig.kt    # Flow configuration
        ├── CameraFlowCoordinator.kt  # Orchestrates capture→crop→save
        └── CameraFlowResult.kt    # Result types
```

**Rationale:** The camera feature is now focused solely on capture and storage. Cropping logic lives in the separate Cropper feature, making both features independently reusable.

---

## 3. Data & Flow Explanation

### Entry Point

The camera flow starts when another feature invokes the flow coordinator with a configuration object. This configuration specifies:

- Whether cropping should be offered after capture
- Whether the final image should be saved to storage
- Image quality level for compression
- Target storage directory
- Initial camera facing direction (front or back)

Three preset configurations exist for common scenarios:
1. **Capture Only** - Returns raw image bytes immediately after capture
2. **Profile Photo** - Enables cropping and saves with high quality
3. **Document Capture** - Saves with maximum quality, no cropping step

### Main Flow Paths

**Path A: Capture Only**
```
User opens camera → Camera preview displayed → User presses capture
→ Image bytes extracted → Raw image returned to caller
```

**Path B: Capture with Crop and Save**
```
User opens camera → Camera preview displayed → User presses capture
→ Image captured → [Cropper Feature] Crop screen displayed
→ User adjusts crop region → User confirms crop
→ [Back to Camera] Image saved to storage
→ Save result with file URI returned to caller
```

**Path C: Capture with Save (No Crop)**
```
User opens camera → Camera preview displayed → User presses capture
→ Image captured → Image saved to storage → Save result returned
```

### Model Conversion at Feature Boundary

When transitioning to the Cropper feature, the coordinator converts between models:

```
┌─────────────────┐                      ┌─────────────────┐
│  CapturedImage  │  ──── converts ────▶ │  CroppableImage │
│  (Camera model) │                      │ (Cropper model) │
└─────────────────┘                      └─────────────────┘
        ▲                                        │
        │                                        │
        └──────────── converts back ─────────────┘
```

This conversion preserves: bytes, width, height, rotation, and mimeType.

### State Flow Within Capture Screen

The capture screen follows unidirectional data flow:

```
┌──────────────┐     ┌──────────────┐     ┌──────────────┐
│  User Action │ ──▶ │    Event     │ ──▶ │  ViewModel   │
└──────────────┘     └──────────────┘     └──────────────┘
                                                  │
                                                  ▼
┌──────────────┐     ┌──────────────┐     ┌──────────────┐
│   UI Update  │ ◀── │    State     │ ◀── │ State Update │
└──────────────┘     └──────────────┘     └──────────────┘
```

The UI observes a single immutable state object. All changes flow through the ViewModel, which produces new state by copying the previous state with modifications.

### One-Time Effects

For actions that should happen exactly once (like navigation or showing a message), the feature uses an effect channel:

```
ViewModel emits effect → Screen collects effect → Callback triggered once
```

Effects are consumed immediately and not replayed on configuration changes.

### Error and Cancellation Handling

**Permission Denied:** The capture screen shows a friendly message explaining why camera access is needed, with an option to retry the permission request or cancel.

**Camera Unavailable:** If the device lacks a camera or the camera cannot be initialized, an appropriate message is displayed with a close option.

**Capture Failure:** If image capture fails (low memory, hardware issue), the user sees an error with retry and cancel options.

**Crop Failure:** Handled by the Cropper feature. Error is propagated back through the coordinator.

**Save Failure:** If storage is full or permissions are insufficient, the error is propagated back to the caller with context about which stage failed.

**User Cancellation:** At any point, the user can cancel. The cancellation is communicated back to the caller so it can respond appropriately.

---

## 4. Component Responsibilities

### Capture Screen

**State Object**
- Tracks whether the camera is ready for use
- Tracks whether a capture is in progress (prevents double-taps)
- Holds current flash mode (off, on, auto)
- Holds current camera facing (front or back)
- Holds any active error state

**Event Types**
- Capture button pressed
- Switch camera pressed
- Flash mode toggle pressed
- Retry permission pressed
- Cancel pressed
- Camera ready signal
- Camera error signal

**Effect Types**
- Image successfully captured (triggers transition to next stage)
- Flow cancelled by user
- Error occurred (for logging/analytics)

**ViewModel Responsibilities**
- Processes user events and updates state accordingly
- Coordinates with camera preview for capture timing
- Does NOT handle actual camera hardware (that's the preview component)
- Does NOT process or transform images (that's domain layer)

**Screen Composable Responsibilities**
- Requests camera permission on first composition
- Displays appropriate content based on state (preview, permission denied, error)
- Connects user interactions to event handler
- Collects effects and invokes callbacks

### Camera Preview Component

**What It Does**
- Initializes the camera provider and binds to lifecycle
- Creates preview and capture use cases
- Displays live camera preview
- Handles pinch-to-zoom gestures
- Executes image capture when triggered
- Extracts image bytes and metadata from captured frame

**What It Does NOT Do**
- Does not manage UI state (that's the ViewModel)
- Does not decide when to capture (responds to external trigger)
- Does not store images (returns bytes to caller)

### Capture Button Component

**What It Does**
- Renders a styled circular capture button
- Provides press animation (slight compression)
- Meets accessibility touch target requirements

**What It Does NOT Do**
- Does not trigger capture logic (calls provided callback)
- Does not track capture state (caller handles disabled state)

### Flow Coordinator

**What It Does**
- Maintains current stage of the multi-screen flow
- Transitions between capture, crop, and save stages based on configuration
- Converts between `CapturedImage` and `CroppableImage` at feature boundary
- Invokes the Cropper feature's `ImageCropScreen` when cropping is enabled
- Invokes save use case when saving is enabled
- Reports final result (success, cancellation, or error) to caller

**What It Does NOT Do**
- Does not manage individual screen state (each screen has its own ViewModel)
- Does not handle navigation directly (composes screens based on stage)
- Does not implement cropping logic (delegates to Cropper feature)

---

## 5. Integration Points

### How Other Features Use the Camera

Features that need camera functionality invoke the flow coordinator as a composable. They provide:

1. A configuration object specifying the desired flow
2. A result callback to receive the outcome

The result contains:
- The captured image (raw bytes with metadata)
- Optionally, the saved image result (file URI, path, name, size)
- A flag indicating whether cropping was applied

### Dependency on Cropper Feature

The Camera feature imports from the Cropper feature:

```kotlin
import com.neome.feature.cropper.domain.model.CroppableImage
import com.neome.feature.cropper.presentation.ImageCropScreen
```

The coordinator handles conversion between Camera's `CapturedImage` and Cropper's `CroppableImage`:

```kotlin
// Convert to Cropper model
private fun CapturedImage.toCroppableImage(): CroppableImage

// Convert back to Camera model
private fun CroppableImage.toCapturedImage(): CapturedImage
```

### Dependencies on External Systems

**Android Camera APIs**
- Uses CameraX library for camera operations
- CameraX abstracts Camera2 complexity and handles API level differences
- Requires CAMERA permission at runtime

**Android Storage APIs**
- Uses MediaStore for Android 10+ (scoped storage model)
- Uses direct file system access for Android 9 and below
- Targets standard directories: Pictures, DCIM, or app-internal storage

### What Other Features May Depend On

Any feature that needs to:
- Capture photos for upload or local storage
- Collect user-generated images (profile photos, attachments)
- Scan documents or capture receipts

These features depend on the Camera feature's coordinator and result types.

---

## 6. Extension & Modification Guidance

### Common Edit Scenarios

**Changing the Capture Button Appearance**
- Modify the capture button component in `presentation/components/`
- This is purely visual and isolated from capture logic
- Safe to change without affecting flow

**Adding a New Flash Mode**
- Extend the flash mode enum in the capture state
- Update the preview component to handle the new mode
- Update the capture screen to cycle through the new option

**Changing Image Quality Defaults**
- Modify the quality enum values in `domain/model/ImageQuality.kt`
- Update preset configurations in `coordinator/CameraFlowConfig.kt` if needed
- Domain layer change, minimal testing required

**Changing Storage Location**
- Modify the directory enum in `domain/model/ImageDirectory.kt`
- Update the data source to handle the new directory
- Data layer change, test on multiple Android versions

**Modifying Crop Behavior**
- Cropping is now in the separate Cropper feature
- See the Cropper feature documentation for crop-related changes
- The Camera feature only needs changes if the conversion logic changes

**Adding Image Filters or Editing**
- Would require a new screen between crop and save
- Create a new MVI screen following existing patterns
- Extend the flow coordinator to include the new stage
- Significant addition, plan carefully

### Components That Should Not Be Modified Lightly

**Version-Specific Storage Logic**
- The data source branches based on Android version
- MediaStore behavior differs significantly from file system access
- Test on both old and new Android versions after any storage changes

**Model Conversion Functions**
- The `toCroppableImage()` and `toCapturedImage()` functions must preserve all fields
- Missing fields will cause data loss or crashes
- Update both functions together if either model changes

**Camera Provider Initialization**
- The preview component manages CameraX lifecycle
- Incorrect lifecycle binding causes camera not releasing or crashes
- Changes require testing across device manufacturers

### Design Assumptions and Constraints

**Single Image Capture**
- The feature captures one image at a time
- Burst mode or multi-capture would require significant changes

**JPEG Format**
- Images are captured and stored as JPEG
- Supporting other formats would require changes across all layers

**Stateless Use Cases**
- Use cases are designed to be stateless
- They can be instantiated without dependency injection
- Do not add mutable state to use cases

**MVI Pattern Consistency**
- The capture screen uses MVI with State, Event, Effect, ViewModel, Screen files
- New screens should follow the same pattern
- Deviating from the pattern makes the codebase harder to understand

**Cropper Feature Dependency**
- The Camera feature depends on the Cropper feature, not vice versa
- Do not add Camera imports to the Cropper feature
- This keeps the Cropper reusable for non-camera use cases

### File Reference Guide for AI Agents

| Change Type | Primary Files to Modify |
|-------------|------------------------|
| Capture UI changes | `capture/CameraCaptureScreen.kt`, `components/CaptureButton.kt` |
| Capture behavior changes | `capture/CameraCaptureViewModel.kt`, `components/CameraPreviewView.kt` |
| Storage behavior changes | `data/source/ImageFileDataSource.kt` |
| Flow configuration | `coordinator/CameraFlowConfig.kt` |
| Flow orchestration | `coordinator/CameraFlowCoordinator.kt` |
| Model conversion | `coordinator/CameraFlowCoordinator.kt` (private extensions) |
| New domain models | `domain/model/` (create new data class) |
| Crop-related changes | See Cropper feature (`feature/cropper/`) |

### Testing Considerations

When modifying this feature, consider testing:

- Permission grant and denial scenarios
- Front and back camera switching
- All flash modes on devices that support flash
- Capture on low-memory devices
- Save to each supported directory
- Save on Android 9 and below
- Save on Android 10 and above
- User cancellation at each stage
- Device rotation during capture
- App backgrounding during operations
- Flow with cropping enabled (integration with Cropper)
- Flow with cropping disabled (direct to save)
- Model conversion round-trip (CapturedImage → CroppableImage → CapturedImage)
