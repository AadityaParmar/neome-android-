# Media Carousel Feature Documentation

## Overview

The Media Carousel is a reusable presentation component designed to preview multiple media items in a horizontally swipeable interface. It supports images, videos, and generic file types, adapting its display behavior based on the media type. This feature is presentation-focused and delegates file selection to the existing FilePicker feature and image manipulation to the existing Cropper feature.

---

## Feature Purpose

The Media Carousel serves as a unified preview interface for mixed media content. Its primary responsibilities include:

- Displaying images with optional cropping support
- Playing videos with standard playback controls
- Showing file metadata for unsupported file types
- Supporting both embedded (compact) and full-screen display modes
- Providing a consistent horizontal pagination experience across all media types

This component is designed for reuse across multiple screens and contexts within the application. It is not a standalone screen feature but a composable building block that can be embedded in cards, dialogs, forms, or expanded to full-screen view.

---

## Data Source and Dependencies

### Input Source

The Media Carousel does not handle file selection. All media items must be provided externally, typically originating from:

- **FilePicker Feature**: The existing file selection feature provides media metadata including file URI, file name, file size, and MIME type
- **Camera Feature**: Captured images can be converted to the carousel's expected input format
- **External Sources**: Any pre-existing media URIs from the network or local storage

### Feature Dependencies

| Dependency | Purpose | Integration |
|------------|---------|-------------|
| FilePicker | Provides media selection results | Consumes FilePickerResult as input |
| Cropper | Handles image cropping operations | Opens cropper screen, receives modified image |

### Dependency Rules

- The Media Carousel must NOT implement any file picking UI or logic
- The Media Carousel must NOT implement any cropping algorithms
- All cropping requests must delegate to the Cropper feature
- The carousel consumes outputs from dependencies and manages only presentation state

---

## Supported Media Types

### Images

**Display Behavior:**
- Render the image visually within the carousel viewport
- Support pinch-to-zoom and pan gestures in full-screen mode
- Maintain aspect ratio while fitting within available bounds
- Load images asynchronously with placeholder support

**Cropping Support:**
- Cropping is controlled by a configuration flag
- When cropping is enabled, display a crop action button in the image preview
- Crop action triggers navigation to the Cropper feature
- Upon crop confirmation, replace the original image with the cropped result in the carousel
- Upon crop cancellation, retain the original image unchanged
- Cropping applies only to the individual image, not to the entire carousel

### Videos

**Display Behavior:**
- Render a video player within the carousel viewport
- Display a thumbnail preview before playback begins
- Support automatic pause when swiping away from the video

**Required Controls:**
- Play and Pause toggle button
- Progress bar with seek functionality (user can drag to position)
- Mute and Unmute toggle button
- Current time and total duration display

**Playback Behavior:**
- Video should auto-pause when the carousel scrolls to a different item
- Video should pause when the carousel exits the visible screen area
- Playback state resets when returning to a previously viewed video
- Controls must function identically in both embedded and full-screen modes

### Other File Types

**Display Behavior:**
- No visual preview is rendered
- Display a placeholder icon representing the file category
- Show the file name prominently
- Show the file size in a human-readable format
- All content must be center-aligned both horizontally and vertically

**Information Display:**
- File name should truncate with ellipsis if too long
- File size should display in appropriate units (bytes, KB, MB, GB)
- The placeholder icon should be visually distinct from image and video previews

---

## Carousel Behavior

### Navigation Mechanics

- Horizontal swipe gestures navigate between adjacent media items
- Page indicator shows the current position within the media list
- Supports both drag-to-scroll and snap-to-item behaviors
- Optional discrete page dots or linear progress indicator

### Mixed Media Handling

- A single carousel instance can contain any combination of images, videos, and files
- Media type determines the rendering strategy for each page
- Transitions between different media types should be visually consistent
- No special handling required at type boundaries

### Layout Adaptability

The carousel must support two primary display contexts without requiring configuration changes:

**Embedded Mode:**
- Fits within a constrained parent container
- Respects parent padding and margins
- Video controls scale appropriately for smaller viewports
- Cropping button remains accessible but sized for compact display

**Full-Screen Mode:**
- Expands to fill the entire screen
- Background dims or blacks out non-carousel content
- Video controls use larger touch targets
- Supports system back gesture or button to exit
- Maintains state continuity when transitioning between modes

### State Preservation

- Current page index persists across configuration changes
- Video playback position resets on page change
- Cropped image updates persist for the session
- Full-screen to embedded transition preserves current index

---

## Media Showcase Integration

### Purpose

The Component Showcase feature includes a dedicated section for demonstrating media-related components. The Media Carousel must be integrated into this showcase for development testing and visual verification.

### Showcase Requirements

Add a new tab or section within MediaShowcase that demonstrates:

**Demonstration One: Mixed Media Carousel**
- Include at least one image and one video
- Cropping functionality disabled
- Demonstrates basic navigation and video playback
- Shows handling of different aspect ratios

**Demonstration Two: Image Carousel with Cropping**
- Include multiple images only
- Cropping functionality enabled
- Demonstrates crop button visibility
- Shows crop flow integration and result handling

### Showcase Constraints

- Showcase implementations are for demonstration only
- Showcase must not contain production business logic
- Test media should be embedded or loaded from assets
- Showcase should work offline without network dependencies

---

## Architecture and Folder Structure

### Package Location

The feature resides under the feature module directory following the established pattern:

```
feature/media_carousel/
```

### Internal Structure

Following the Clean Architecture pattern established in this codebase:

```
media_carousel/
├── domain/
│   └── model/
│       ├── MediaItem              # Sealed type representing displayable media
│       ├── MediaType              # Enum distinguishing images, videos, files
│       └── CarouselConfiguration  # Display settings and feature flags
└── presentation/
    ├── state/
    │   ├── MediaCarouselState     # Immutable UI state
    │   ├── MediaCarouselEvent     # User interaction events
    │   └── MediaCarouselEffect    # One-time navigation and result events
    ├── MediaCarouselViewModel     # State management and event handling
    ├── MediaCarousel              # Primary composable entry point
    └── components/
        ├── ImagePreview           # Image display with optional crop action
        ├── VideoPreview           # Video player with controls
        ├── FilePreview            # Generic file metadata display
        ├── CarouselPager          # Horizontal paging container
        ├── PageIndicator          # Current position indicator
        └── VideoControls          # Play, pause, seek, mute controls
```

### Layer Responsibilities

**Domain Layer:**
- Contains pure data models with no Android dependencies
- Defines the structure of media items and configuration
- No business logic beyond basic data validation

**Presentation Layer:**
- Manages UI state through ViewModel
- Handles user events and emits effects
- Contains all composable components
- Coordinates with external features (Cropper) via effects

### Module Boundaries

- No imports from other feature packages except defined integration points
- Cropper integration occurs through navigation, not direct code coupling
- FilePicker results are transformed into MediaItem at the call site
- No shared mutable state between features

---

## State and Responsibility Distribution

### Media Carousel Responsibilities

| Responsibility | Owner |
|----------------|-------|
| Current page index tracking | MediaCarouselState |
| Page transition animations | CarouselPager |
| Image display and gestures | ImagePreview |
| Video playback state | VideoPreview (local state) |
| Video control interactions | VideoControls |
| Crop button visibility | ImagePreview (via configuration) |
| Triggering crop navigation | MediaCarouselEffect |
| Updating item after crop | MediaCarouselViewModel |
| File metadata display | FilePreview |

### FilePicker Responsibilities

| Responsibility | Owner |
|----------------|-------|
| File selection UI | FilePicker |
| File system access | FilePicker |
| MIME type detection | FilePicker |
| Metadata extraction | FilePicker |
| Result delivery | FilePickerResult |

### Cropper Responsibilities

| Responsibility | Owner |
|----------------|-------|
| Crop region selection UI | Cropper |
| Crop gesture handling | Cropper |
| Image transformation | CropImageUseCase |
| Result delivery | ImageCropEffect |

### Data Flow: Crop Operation

The following describes the sequence when a user initiates cropping:

1. User taps crop action on an image in the carousel
2. Carousel emits a navigation effect containing the image data and item index
3. Parent screen navigates to Cropper screen
4. User completes or cancels the crop operation
5. Cropper emits result effect (confirmed with new image or cancelled)
6. Parent screen receives result and calls carousel update function
7. Carousel ViewModel replaces the item at the specified index
8. UI recomposes to show the updated image

### Data Flow: External Media Addition

When new media is provided from FilePicker:

1. External component invokes FilePicker
2. FilePicker returns FilePickerResult
3. External component transforms result to MediaItem
4. External component updates the list passed to MediaCarousel
5. Carousel observes the new list and updates internal state

---

## Extensibility Considerations

### Adding New Media Types

To support additional media types in the future:

1. Extend the MediaType enumeration with the new type identifier
2. Add a new sealed variant to MediaItem for type-specific data
3. Create a new preview component for the rendering logic
4. Update the pager to select the appropriate preview based on type
5. No changes required to carousel navigation or state management

### Custom Controls

Video controls are designed as a separate composable to allow:

- Custom control layouts for specific use cases
- Theming and styling overrides
- Additional controls (playback speed, quality selection)
- Controls can be hidden entirely via configuration

### External State Hoisting

For advanced use cases requiring external state management:

- Current index can be controlled via a two-way binding parameter
- Item list updates can be observed via callback
- Crop results can be intercepted before automatic application
- Full-screen state can be externally controlled

### Analytics and Callbacks

The following callback points support analytics integration:

- Page change events with previous and current index
- Video playback start, pause, and completion
- Crop initiated and crop completed events
- Full-screen entry and exit events
- Item tap or long-press events

---

## Non-Goals and Explicit Exclusions

This feature intentionally excludes the following capabilities:

### File Selection
- No file picker UI within the carousel
- No direct file system browsing
- No camera capture initiation
- No drag-and-drop file addition

### File System Operations
- No file saving or export
- No file deletion
- No file renaming
- No file moving or copying

### Business Logic
- No media upload handling
- No media compression or transformation (except via Cropper)
- No media validation rules
- No network operations

### Duplicate Implementations
- No cropping algorithm implementation
- No image processing beyond display
- No file metadata extraction
- No thumbnail generation

### Persistence
- No internal caching of media files
- No history of viewed items
- No persistent playback position
- State exists only for the session lifetime

---

## Input Model Specification

### MediaItem Structure

The primary input model represents a single displayable media item:

**Required Properties:**
- Unique identifier for the item within the list
- Media type indicator (image, video, or file)
- Content URI for loading the media

**Image-Specific Properties:**
- Image byte array or URI
- Width and height dimensions
- Rotation information
- MIME type

**Video-Specific Properties:**
- Video URI
- Duration in milliseconds
- Thumbnail URI or byte array

**File-Specific Properties:**
- Display name
- File size in bytes
- MIME type for icon selection

### Configuration Structure

The carousel accepts a configuration object controlling behavior:

**Display Options:**
- Initial page index
- Page indicator visibility
- Page indicator style (dots or linear)

**Feature Flags:**
- Cropping enabled (applies to images only)
- Full-screen expansion enabled
- Video auto-play enabled

**Constraint Options:**
- Maximum items (zero for unlimited)
- Supported media types filter

---

## UI Composition Guidelines

### Component Hierarchy

```
MediaCarousel (entry point)
└── CarouselPager (handles paging)
    ├── ImagePreview (for image items)
    │   └── CropActionButton (when enabled)
    ├── VideoPreview (for video items)
    │   └── VideoControls
    │       ├── PlayPauseButton
    │       ├── SeekBar
    │       ├── TimeDisplay
    │       └── MuteButton
    └── FilePreview (for other items)
        ├── FileIcon
        ├── FileName
        └── FileSize
```

### Composable Parameters Pattern

All preview components follow the stateless composable pattern:

- Accept state as parameters
- Accept event callbacks as parameters
- Accept modifier as the final optional parameter
- Provide default values where appropriate
- Remain internally stateless for testability

### Preview Support

Each component should support compose previews showing:

- Default state
- Loading state
- Error state
- Various content scenarios

---

## Error Handling

### Image Loading Errors
- Display a placeholder indicating the image failed to load
- Provide a retry action if applicable
- Do not block carousel navigation

### Video Loading Errors
- Display error state in the video area
- Show error message describing the issue
- Allow navigation to other items

### Crop Integration Errors
- Handle cropper returning an error effect
- Display error feedback to user
- Preserve original image on failure

### Invalid Input Handling
- Empty item list shows empty state
- Invalid URIs show appropriate error placeholder
- Unsupported MIME types fall back to file preview

---

## Testing Considerations

### Unit Testing Targets
- ViewModel state transitions
- Event to state mapping
- Effect emission timing
- Index boundary handling

### Integration Testing Targets
- Cropper navigation and result handling
- Media item list updates
- Configuration flag behavior

### UI Testing Targets
- Swipe gesture recognition
- Video control interactions
- Full-screen transition
- Crop button tap handling

---

## Summary

The Media Carousel feature provides a focused, reusable presentation component for displaying mixed media content. It strictly adheres to the principle of single responsibility by delegating file selection to FilePicker and image manipulation to Cropper. The feature follows the established Clean Architecture pattern with MVI state management, ensuring predictable state transitions and clear separation of concerns.

Implementation should proceed layer by layer, starting with domain models, then state management, and finally composable components. The showcase integration provides a controlled environment for validating the implementation against the documented requirements.
