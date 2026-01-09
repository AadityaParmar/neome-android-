# Cropper Feature Overview

## 1. High-Level Purpose

### What the Cropper Feature Does

The Cropper feature provides a standalone image cropping solution for the application. It allows users to select a region of an image through intuitive touch gestures and produces a cropped result.

### Problem It Solves

The feature abstracts the complexity of image cropping into a reusable, self-contained module. It handles:

- Interactive crop region selection with corner and edge handles
- Touch gesture detection with proper pointer locking
- Visual feedback with darkened overlay and grid lines
- Image rotation correction during crop processing
- Memory-efficient bitmap operations with proper cleanup

### Where It Is Used

The Cropper feature is a general-purpose image manipulation tool. It can be used by:

- **Camera feature** - Crop photos after capture
- **Gallery/File picker** - Crop images selected from device storage
- **Profile editing** - Crop user avatars or cover photos
- **Any feature** - That needs to let users select a region of an image

The feature is designed to work with any image source, not just camera captures.

---

## 2. Feature Structure

### Architectural Overview

The Cropper feature follows Clean Architecture principles with two layers:

```
┌─────────────────────────────────────────────────────────┐
│                   PRESENTATION LAYER                     │
│  (UI components, state management, user interaction)     │
├─────────────────────────────────────────────────────────┤
│                     DOMAIN LAYER                         │
│  (Business logic, models, use cases)                     │
└─────────────────────────────────────────────────────────┘
```

**Note:** The Cropper feature has no data layer because it does not persist data. It receives an image, processes it in memory, and returns the result.

### Layer Responsibilities

**Domain Layer (Pure Kotlin)**
- Defines data models for croppable images and crop regions
- Contains use cases that perform the actual cropping operation
- Uses Android Bitmap APIs for image processing (allowed as implementation detail)

**Presentation Layer (UI and State)**
- Contains one MVI-based screen: image crop
- Manages UI state through ViewModel with immutable state object
- Handles user events and emits one-time effects
- Includes reusable composable components (crop overlay, handles)

### File Organization

```
cropper/
├── domain/
│   ├── model/
│   │   ├── CropRegion.kt         # Normalized crop coordinates (0.0-1.0)
│   │   └── CroppableImage.kt     # Generic image model for cropping
│   └── usecase/
│       └── CropImageUseCase.kt   # Performs the crop operation
│
└── presentation/
    ├── ImageCropState.kt         # MVI state
    ├── ImageCropEvent.kt         # User actions
    ├── ImageCropEffect.kt        # One-time effects
    ├── ImageCropViewModel.kt     # State management
    ├── ImageCropScreen.kt        # Composable UI
    └── components/
        ├── CropOverlay.kt        # Interactive crop region overlay
        └── CropHandles.kt        # Draggable corner handles
```

**Rationale:** The simple two-layer structure reflects the feature's focused purpose. No data layer is needed because cropping is a pure transformation with no persistence.

---

## 3. Data & Flow Explanation

### Entry Point

Other features invoke the `ImageCropScreen` composable with:

1. A `CroppableImage` - The source image to crop
2. Callbacks for crop confirmed, cancelled, and error

```kotlin
ImageCropScreen(
    sourceImage = croppableImage,
    onCropConfirmed = { croppedImage -> /* handle result */ },
    onCancelled = { originalImage -> /* handle cancel */ },
    onError = { message -> /* handle error */ }
)
```

### Main Flow

```
Caller provides image → Crop screen displayed
→ User adjusts crop region → User confirms
→ Image cropped in background → Cropped image returned to caller
```

### State Flow Within Crop Screen

The screen follows unidirectional data flow (MVI pattern):

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

### Crop Region Model

The crop region uses normalized coordinates (0.0 to 1.0):

```
(0,0) ─────────────────────── (1,0)
  │                             │
  │    (left, top)              │
  │        ┌─────────┐          │
  │        │  CROP   │          │
  │        │  REGION │          │
  │        └─────────┘          │
  │              (right, bottom)│
  │                             │
(0,1) ─────────────────────── (1,1)
```

This normalization makes the crop region independent of actual image dimensions.

### One-Time Effects

For actions that should happen exactly once:

```
ViewModel emits effect → Screen collects effect → Callback triggered once
```

Effects:
- `CropConfirmed` - Carries the cropped image
- `Cancelled` - Carries the original image
- `Error` - Carries error message

### Error Handling

**Decode Failure:** If the image bytes cannot be decoded, an error is shown.

**Invalid Crop Region:** If the calculated crop region is invalid (negative dimensions, out of bounds), an error is shown.

**Memory Issues:** Large images may cause out-of-memory errors. The use case catches these and reports failure.

**User Cancellation:** User can cancel at any time. The original image is returned unchanged.

---

## 4. Component Responsibilities

### Crop Screen

**State Object**
- Holds the source image to be cropped
- Holds the current crop region (normalized coordinates)
- Tracks whether crop processing is in progress
- Holds any active error message

**Event Types**
- Crop region changed (user dragged handles)
- Confirm crop pressed
- Cancel pressed
- Reset pressed (reverts to full image)

**Effect Types**
- Crop confirmed (carries the result image)
- Flow cancelled (carries the original image)
- Error occurred

**ViewModel Responsibilities**
- Accepts the source image to initialize the screen
- Tracks crop region changes from user gestures
- Invokes crop use case when user confirms
- Skips cropping if region covers the full image (optimization)
- Does NOT render the crop overlay (that's a UI component)

**Screen Composable Responsibilities**
- Decodes image bytes into displayable bitmap
- Renders the image with crop overlay on top
- Provides cancel and reset controls at top
- Provides confirm control at bottom
- Shows loading indicator during processing
- Displays error message when crop fails

### Crop Overlay Component

**What It Does**
- Renders a darkened overlay outside the crop region
- Draws crop boundary with white border
- Draws 3x3 grid lines for composition guidance
- Draws corner handles (L-shaped) at each corner
- Draws edge handles at center of each edge
- Detects which handle is touched based on proximity
- Tracks drag gestures with single-pointer locking
- Updates crop region based on drag delta
- Enforces minimum crop size (3% of image)
- Constrains crop region to valid bounds (0.0 to 1.0)

**What It Does NOT Do**
- Does not crop the image (only defines the region)
- Does not know about the source image dimensions
- Does not persist crop state (reports changes to parent)

### Crop Handles Component

**What It Does**
- Provides individual draggable handle components
- Separates touch target (48dp) from visual indicator (24dp)
- Positions handles at crop region corners

**What It Does NOT Do**
- Does not calculate new crop regions (delegates to overlay)
- Not currently used (overlay has integrated handle detection)

### Crop Image Use Case

**What It Does**
- Decodes image bytes to Bitmap
- Applies rotation correction if needed
- Calculates pixel coordinates from normalized region
- Validates crop coordinates
- Creates cropped bitmap
- Compresses result to JPEG bytes
- Properly recycles all intermediate bitmaps

**What It Does NOT Do**
- Does not manage UI state
- Does not handle user interaction
- Does not persist results

---

## 5. Integration Points

### How Other Features Use the Cropper

Features invoke the crop screen as a composable:

```kotlin
ImageCropScreen(
    sourceImage = CroppableImage(
        bytes = imageBytes,
        width = imageWidth,
        height = imageHeight,
        rotation = 0,
        mimeType = "image/jpeg"
    ),
    onCropConfirmed = { croppedImage ->
        // croppedImage.bytes contains the cropped JPEG
        // croppedImage.width/height are the new dimensions
    },
    onCancelled = { originalImage ->
        // User cancelled, originalImage is unchanged
    },
    onError = { message ->
        // Show error to user
    }
)
```

### CroppableImage Model

The `CroppableImage` is the feature's public interface:

| Field | Type | Description |
|-------|------|-------------|
| bytes | ByteArray | Raw image data (JPEG) |
| width | Int | Image width in pixels |
| height | Int | Image height in pixels |
| rotation | Int | Rotation in degrees (0, 90, 180, 270) |
| mimeType | String | MIME type (default: "image/jpeg") |

### Converting From Other Image Types

Features using their own image models should convert to `CroppableImage`:

```kotlin
// From Camera's CapturedImage
fun CapturedImage.toCroppableImage() = CroppableImage(
    bytes = bytes,
    width = width,
    height = height,
    rotation = rotation,
    mimeType = mimeType
)

// From URI (conceptual)
fun loadFromUri(uri: Uri, context: Context): CroppableImage {
    val bytes = context.contentResolver.openInputStream(uri)?.readBytes()
    val options = BitmapFactory.Options().apply { inJustDecodeBounds = true }
    BitmapFactory.decodeByteArray(bytes, 0, bytes.size, options)
    return CroppableImage(
        bytes = bytes,
        width = options.outWidth,
        height = options.outHeight
    )
}
```

### Dependencies on External Systems

**Android Graphics APIs**
- Uses BitmapFactory for decoding
- Uses Bitmap for manipulation
- Uses Matrix for rotation
- Uses Bitmap.compress for encoding

**Compose Graphics**
- Uses Canvas for overlay rendering
- Uses pointer input for gesture detection

### What Other Features May Depend On

Any feature that needs to:
- Let users crop images from any source
- Select regions of images
- Resize or adjust image framing

These features should depend on Cropper's `ImageCropScreen` and `CroppableImage`.

---

## 6. Extension & Modification Guidance

### Common Edit Scenarios

**Changing Overlay Appearance**
- Modify colors and strokes in `CropOverlay.kt`
- Drawing functions are at the bottom of the file
- Safe to change without affecting crop logic

**Changing Handle Size**
- Modify touch radius constants in `CropOverlay.kt`
- `cornerTouchRadius` for corners (default 56dp)
- `edgeTouchWidth` for edges (default 44dp)
- Ensure accessibility (minimum 48dp touch target)

**Changing Minimum Crop Size**
- Modify `minSize` in `applyDrag` function
- Currently 0.03f (3% of image)
- Consider usability implications

**Adding Aspect Ratio Constraints**
- The `AspectRatio` interface exists but is currently ignored
- Would require modifying `applyDrag` to maintain ratio during resize
- Consider adding aspect ratio selector UI
- Significant change affecting user experience

**Changing Output Quality**
- Modify compression quality in `CropImageUseCase.kt`
- Currently 90 (on scale of 0-100)
- Higher quality = larger file size

**Supporting Other Image Formats**
- Currently hardcoded to JPEG
- Would require modifying compress call and mimeType handling

### Components That Should Not Be Modified Lightly

**CropRegion Validation**
- The model validates coordinates at construction
- Changing validation rules could allow invalid states
- Thoroughly test any changes to bounds checking

**Bitmap Memory Management**
- The use case explicitly recycles bitmaps
- Removing or reordering recycle calls can cause memory leaks
- Any changes must maintain proper cleanup

**Pointer Locking in Overlay**
- The overlay uses single-pointer locking to prevent erratic behavior
- Multi-touch would cause unpredictable crop region changes
- Do not remove the pointer ID tracking

**Handle Detection Logic**
- Corner detection uses distance-based proximity
- Edge detection uses half-width from edge line
- Changes affect which handle is selected on touch

### Design Assumptions and Constraints

**Free-Form Crop Only**
- The screen does not enforce aspect ratios
- AspectRatio interface exists for future use
- Adding aspect ratio requires UI and logic changes

**JPEG Output**
- Cropped images are always JPEG format
- Quality is fixed at 90%
- Other formats would require significant changes

**Rotation Applied During Crop**
- If source has rotation, it's applied before cropping
- Result always has rotation = 0
- This simplifies downstream handling

**Stateless Use Case**
- CropImageUseCase can be instantiated without DI
- Do not add mutable state
- Each invocation is independent

**No Persistence**
- Feature only transforms images in memory
- No files are saved or loaded
- Caller is responsible for persistence

### File Reference Guide for AI Agents

| Change Type | Primary Files to Modify |
|-------------|------------------------|
| Crop UI changes | `ImageCropScreen.kt`, `components/CropOverlay.kt` |
| Overlay appearance | `components/CropOverlay.kt` (drawing functions) |
| Handle behavior | `components/CropOverlay.kt` (detectHandle, applyDrag) |
| Crop logic | `domain/usecase/CropImageUseCase.kt` |
| Models | `domain/model/CropRegion.kt`, `domain/model/CroppableImage.kt` |
| State management | `ImageCropViewModel.kt` |
| Add aspect ratios | `ImageCropState.kt`, `CropOverlay.kt`, `ImageCropViewModel.kt` |

### Testing Considerations

When modifying this feature, consider testing:

- Cropping to minimum allowed size
- Cropping at image boundaries (all four corners)
- Cropping entire image (no-op optimization)
- Drag each handle type (corners, edges, center pan)
- Multi-touch rejection (should ignore second finger)
- Large images (memory handling)
- Images with rotation (90, 180, 270 degrees)
- Cancel at various states
- Reset after adjusting crop region
- Error handling for corrupt image data
- Portrait and landscape source images
- Device rotation during crop
