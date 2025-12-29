# Media Utilities Documentation

This document describes the behavior and usage of three stateless media processing utilities. All utilities follow a consistent architectural pattern: they are singleton objects with no state, no lifecycle dependencies, and no UI coupling.

---

## Image Compressor

### Purpose

Reduces image file size through JPEG quality compression while preserving correct orientation. Solves the common problem of large camera images consuming excessive storage or bandwidth during upload.

### Input

Accepts image data in three forms:

- **Bitmap**: Must be a valid, non-recycled bitmap
- **ByteArray**: Raw image bytes (JPEG, PNG, or other decodable format); must not be empty
- **InputStream**: Stream containing image data; caller is responsible for closing the stream

Additionally requires a **compression percentage** (0-100):
- 0 = maximum compression, lowest quality
- 100 = minimal compression, highest quality

### Output

Returns a sealed outcome type with two variants:

**Success** contains:
- Compressed image bytes in JPEG format
- Final image dimensions (width, height)
- Original size in bytes
- Compressed size in bytes
- Computed compression ratio (0.0-1.0)
- Computed savings percentage

**Error** contains a descriptive message explaining the failure.

### How It Works

**Step 1: Input Validation**
- Checks compression percentage is within 0-100 range
- Verifies bitmap is not recycled (for bitmap input)
- Verifies byte array is not empty (for byte array input)

**Step 2: Original Size Calculation**
- For bitmap input: uses `bitmap.allocationByteCount` to get memory footprint
- For byte array input: uses the byte array length directly

**Step 3: EXIF Orientation Handling** (byte array and stream inputs only)
- Reads EXIF metadata from image bytes using `ExifInterface`
- Extracts the `TAG_ORIENTATION` attribute
- Based on orientation value, creates a transformation matrix:
  - `ORIENTATION_ROTATE_90`: rotates 90 degrees clockwise
  - `ORIENTATION_ROTATE_180`: rotates 180 degrees
  - `ORIENTATION_ROTATE_270`: rotates 270 degrees clockwise
  - `ORIENTATION_FLIP_HORIZONTAL`: mirrors horizontally
  - `ORIENTATION_FLIP_VERTICAL`: mirrors vertically
  - `ORIENTATION_TRANSPOSE`: rotates 90 degrees + horizontal flip
  - `ORIENTATION_TRANSVERSE`: rotates -90 degrees + horizontal flip
- Applies matrix transformation to create correctly-oriented bitmap
- Recycles the original bitmap if a new rotated bitmap was created

**Step 4: JPEG Compression**
- Creates a `ByteArrayOutputStream` to hold compressed data
- Calls `bitmap.compress(Bitmap.CompressFormat.JPEG, quality, outputStream)`
- The quality parameter maps directly to the compression percentage input
- Converts output stream to byte array

**Step 5: Dimension Extraction**
- Decodes compressed bytes with `BitmapFactory.Options.inJustDecodeBounds = true`
- This reads dimensions without allocating full bitmap memory
- Extracts `outWidth` and `outHeight` from options

**Step 6: Cleanup**
- Recycles any temporary bitmaps created during processing
- Original input bitmap is never modified or recycled

### Core Behavior

**What it does**:
- Compresses any decodable image format to JPEG
- Corrects image orientation based on EXIF metadata
- Provides size statistics for before/after comparison

**What it does not do**:
- Does not resize or scale images
- Does not preserve original format (always outputs JPEG)
- Does not handle animated images
- Does not strip EXIF metadata beyond orientation

### Error Handling

Fails fast with descriptive errors for:
- Compression percentage outside 0-100 range
- Recycled bitmap input
- Empty byte array input
- Failed image decoding (corrupted or unsupported format)
- Stream read failures

EXIF processing failures degrade gracefully: if orientation cannot be read, the image is compressed without rotation correction.

### Usage Context

Designed for use in media upload flows where bandwidth or storage optimization is required. Expected to run on `Dispatchers.Default` due to CPU-intensive compression operations. Stateless and thread-safe; can be called from any coroutine context.

---

## Image Primary Color Extractor

### Purpose

Extracts the single most dominant color from an image using color quantization. Useful for generating dynamic UI themes, placeholder backgrounds, or visual categorization based on image content.

### Input

Accepts a single **Bitmap**:
- Must be valid and non-recycled
- Must have positive dimensions (width > 0, height > 0)

Large images are automatically downsampled internally for performance; the original bitmap is not modified.

### Output

Returns a sealed outcome type with two variants:

**Success** contains:
- Primary color as an ARGB integer
- Individual RGB component values (0-255 each)
- Hex string representation (e.g., "#3A7BD5")
- Count of pixels that were sampled

**Error** contains a descriptive message explaining the failure.

### How It Works

**Step 1: Input Validation**
- Checks bitmap is not recycled
- Verifies dimensions are greater than zero

**Step 2: Downsampling for Performance**
- Checks if bitmap exceeds 100x100 pixels
- If larger, calculates scale factor: `100 / max(width, height)`
- Creates scaled bitmap using `Bitmap.createScaledBitmap()`
- Minimum dimension is clamped to 1 pixel

**Step 3: Pixel Extraction**
- Calculates total pixel count: `width × height`
- Allocates `IntArray` of that size
- Calls `bitmap.getPixels()` to copy all pixel data into array
- Each pixel is stored as ARGB integer

**Step 4: Transparency Filtering**
- Iterates through each pixel
- Extracts alpha component using `Color.alpha(pixel)`
- Skips pixels with alpha < 128 (less than 50% opacity)
- Counts non-transparent pixels for result metadata

**Step 5: Color Bucketing**
- For each non-transparent pixel, extracts RGB components
- Calculates bucket index for each channel: `value / 8` (divides 256 values into 32 buckets)
- Combines into single bucket key: `(rBucket × 1024) + (gBucket × 32) + bBucket`
- Stores original pixel color in HashMap keyed by bucket
- This creates 32,768 possible buckets (32³)

**Step 6: Dominant Bucket Selection**
- Finds bucket with maximum pixel count using `maxByOrNull { it.value.size }`
- This bucket contains the most frequently occurring color group

**Step 7: Color Averaging**
- Sums all red, green, and blue values from pixels in dominant bucket
- Divides each sum by pixel count to get average
- Clamps results to 0-255 range

**Step 8: Result Construction**
- Combines averaged RGB into single color using `Color.rgb()`
- Formats hex string as `#RRGGBB`
- Returns result with all color representations

**Step 9: Cleanup**
- Recycles downsampled bitmap if different from original
- Original bitmap is never modified

### Core Behavior

**What it does**:
- Groups similar colors together using 32-level quantization per channel
- Returns the average color of the largest color group
- Ignores transparent/semi-transparent pixels

**What it does not do**:
- Does not return multiple colors or a palette
- Does not weight colors by visual prominence or position
- Does not consider perceptual color differences (uses simple RGB distance)
- Does not modify the input bitmap

### Error Handling

Fails with descriptive errors for:
- Recycled bitmap input
- Zero-dimension bitmap input
- Images containing only transparent pixels
- Empty bucket structures (edge case)

### Usage Context

Designed for feature screens that need dynamic theming based on displayed images. Computation-heavy due to pixel iteration; expected to run on `Dispatchers.Default`. Stateless and reusable across any image source.

---

## Video Thumbnail Extractor

### Purpose

Extracts the first frame of a video file as a static bitmap thumbnail. Solves the common need for video preview images in galleries, lists, or upload previews without playing the video.

### Input

Requires two parameters:
- **ContentResolver**: System content resolver for accessing the video file
- **Uri**: Video file location (supports content://, file://, and other standard URI schemes)

Caller must have read permission for the specified URI.

### Output

Returns a sealed outcome type with two variants:

**Success** contains:
- Thumbnail bitmap (caller is responsible for recycling when done)
- Thumbnail dimensions (width, height)
- Video duration in milliseconds (nullable; may not be available for all formats)

**Error** contains a descriptive message explaining the failure.

### How It Works

**Step 1: Retriever Initialization**
- Creates new `MediaMetadataRetriever` instance
- This is Android's built-in class for extracting media metadata and frames

**Step 2: Data Source Setup**
- Opens file descriptor from URI using `contentResolver.openFileDescriptor(uri, "r")`
- The "r" mode opens for read-only access
- Extracts raw `FileDescriptor` from `ParcelFileDescriptor`
- Passes file descriptor to `retriever.setDataSource()`
- This approach supports all URI types (content providers, file system, etc.)

**Step 3: Frame Extraction**
- Calls `retriever.getFrameAtTime(0, OPTION_CLOSEST_SYNC)`
- First parameter (0) specifies timestamp in microseconds (first frame)
- `OPTION_CLOSEST_SYNC` finds the nearest sync frame (keyframe)
- Sync frames are complete frames that don't depend on other frames
- Returns null if extraction fails

**Step 4: Duration Metadata Extraction**
- Calls `retriever.extractMetadata(METADATA_KEY_DURATION)`
- Returns duration as string in milliseconds
- Safely parses to Long with `toLongOrNull()` fallback
- Duration may be null for some video formats

**Step 5: Result Construction**
- Creates `ThumbnailResult` with bitmap and dimensions
- Dimensions come from `bitmap.width` and `bitmap.height`
- Includes nullable duration metadata

**Step 6: Resource Cleanup**
- Calls `retriever.release()` in finally block
- Ensures cleanup happens even if exceptions occur
- Catches and ignores release errors to prevent masking original exceptions

### Core Behavior

**What it does**:
- Extracts the first keyframe from any supported video format
- Provides video duration metadata when available
- Handles URI permission abstraction through ContentResolver

**What it does not do**:
- Does not allow extracting frames at arbitrary timestamps
- Does not scale or resize the extracted frame
- Does not handle audio-only files
- Does not cache results

### Error Handling

Provides specific error messages for:
- `IllegalArgumentException`: Invalid or malformed URIs, unsupported formats
- `SecurityException`: Permission denied (missing read access)
- General `Exception`: Catch-all with descriptive message
- Null bitmap: Video corrupted or unsupported

Resource cleanup is guaranteed through finally-block handling, preventing system resource leaks even when extraction fails.

### Usage Context

Designed for media pickers, galleries, and upload previews that need static video representations. Involves file system access; expected to run on `Dispatchers.IO`. Caller must manage the returned bitmap's lifecycle and recycle it when no longer needed.

---

## Shared Architectural Properties

All three utilities share these characteristics:

| Property | Description |
|----------|-------------|
| Stateless | No internal state; each call is independent |
| Thread-safe | Can be called concurrently from multiple coroutines |
| No UI dependency | Pure processing logic with no framework coupling |
| Sealed outcomes | Explicit success/error handling without exceptions |
| No external dependencies | Uses only Android SDK APIs |
| Single responsibility | Each utility performs exactly one operation |

## Dispatcher Recommendations

| Utility | Recommended Dispatcher | Reason |
|---------|----------------------|--------|
| Image Compressor | `Dispatchers.Default` | CPU-intensive bitmap processing |
| Primary Color Extractor | `Dispatchers.Default` | CPU-intensive pixel iteration |
| Video Thumbnail Extractor | `Dispatchers.IO` | File system access via ContentResolver |
