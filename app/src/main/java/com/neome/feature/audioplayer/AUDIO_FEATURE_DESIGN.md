# Audio Recorder and Audio Player Feature Design

## Document Overview

This document provides the architectural design and implementation guidance for adding Audio Recorder and Audio Player features to the Neome Android application. Both features integrate with the existing MediaShowcase component and follow the established Clean Architecture + MVI patterns.

---

## Table of Contents

1. [Executive Summary](#executive-summary)
2. [Architecture Overview](#architecture-overview)
3. [Audio Recorder Feature](#audio-recorder-feature)
4. [Audio Player Feature](#audio-player-feature)
5. [MediaShowcase Integration](#mediashowcase-integration)
6. [Data Flow Diagrams](#data-flow-diagrams)
7. [MP3 Format Considerations](#mp3-format-considerations)
8. [Assumptions](#assumptions)
9. [Risks and Limitations](#risks-and-limitations)
10. [Trade-offs and Decisions](#trade-offs-and-decisions)

---

## Executive Summary

### Goals

- Implement an Audio Recorder feature outputting MP3 format
- Implement an Audio Player feature that plays MP3 files
- Integrate both features into the existing MediaShowcase component
- Follow existing architectural patterns (Clean Architecture + MVI)
- Minimize third-party library usage (LAME required for MP3 encoding)

### Key Architectural Decisions

| Decision | Rationale |
|----------|-----------|
| MVI Pattern | Complex user interactions, multiple states (recording, paused, stopped, playing) |
| MP3 via LAME library | Android has no native MP3 encoder; LAME is the minimal, industry-standard solution |
| ExoPlayer for Playback | Already in project, native MP3 support |
| Extend MediaItem sealed interface | Consistent with existing media handling |

---

## Architecture Overview

### Package Structure

```
app/src/main/java/com/neome/
├── feature/
│   ├── audiorecorder/
│   │   ├── domain/
│   │   │   └── model/
│   │   │       ├── RecordedAudio.kt
│   │   │       ├── RecordingConfig.kt
│   │   │       └── RecorderError.kt
│   │   └── presentation/
│   │       ├── AudioRecorderState.kt
│   │       ├── AudioRecorderEvent.kt
│   │       ├── AudioRecorderEffect.kt
│   │       ├── AudioRecorderViewModel.kt
│   │       ├── AudioRecorderScreen.kt
│   │       └── components/
│   │           ├── RecordingControls.kt
│   │           ├── RecordingTimer.kt
│   │           └── WaveformVisualizer.kt
│   │
│   ├── audioplayer/
│   │   ├── domain/
│   │   │   └── model/
│   │   │       ├── AudioPlaybackState.kt
│   │   │       └── PlayerError.kt
│   │   └── presentation/
│   │       ├── AudioPlayerState.kt
│   │       ├── AudioPlayerEvent.kt
│   │       ├── AudioPlayerEffect.kt
│   │       ├── AudioPlayerViewModel.kt
│   │       ├── AudioPlayerScreen.kt
│   │       └── components/
│   │           ├── PlaybackControls.kt
│   │           ├── SeekBar.kt
│   │           └── AudioWaveform.kt
│   │
│   ├── media_carousel/
│   │   └── domain/model/
│   │       └── MediaItem.kt  # Extended with AudioItem
│   │
│   ├── utils/
│   │   ├── AudioDurationExtractor.kt
│   │   └── Mp3Encoder.kt  # MP3 encoding utility (LAME wrapper)
│   │
│   └── componentshowcase/
│       └── presentation/components/
│           └── MediaShowcase.kt  # Extended with audio features
```

### Layer Responsibilities

| Layer | Responsibility | Android Dependencies |
|-------|----------------|---------------------|
| Domain | Pure Kotlin models, business rules | None |
| Presentation | UI State, Events, ViewModel, Compose UI | Compose, ViewModel, Lifecycle |
| Utility | Stateless helpers for encoding/extraction | MediaCodec, AudioRecord |

---

## Audio Recorder Feature

### Domain Layer

#### RecordedAudio.kt

Data class representing a recorded audio file.

**Properties:**
- `bytes: ByteArray` - Raw MP3-encoded audio data
- `durationMs: Long` - Duration in milliseconds
- `sampleRate: Int` - Sample rate in Hz (default: 44100 for MP3)
- `channels: Int` - Number of audio channels (1 = mono, 2 = stereo)
- `mimeType: String` - MIME type (audio/mpeg for MP3)
- `timestamp: Long` - Recording timestamp

**Computed Properties:**
- `fileSizeBytes: Int` - Size of the audio data

**Notes:**
- Must implement custom `equals()` and `hashCode()` due to `ByteArray` property

#### RecordingConfig.kt

Data class for audio recording configuration.

**Properties:**
- `sampleRate: Int` - Default: 44100 (standard for MP3)
- `channels: Int` - Default: 1 (mono)
- `bitRate: Int` - Default: 128000 (128kbps, good quality for MP3)
- `maxDurationMs: Long` - Default: 5 minutes
- `quality: Int` - LAME quality (0-9, lower is better, default: 5)

#### RecorderError.kt

Sealed interface for recorder errors with `message` property.

**Subtypes:**
- `PermissionDenied` - Microphone permission not granted
- `InitializationFailed` - AudioRecord failed to initialize
- `RecordingFailed` - Error during recording
- `EncodingFailed` - MP3 encoding failed
- `MaxDurationReached` - Recording exceeded max duration

### Presentation Layer

#### RecordingStatus (enum)

Recording state enumeration:
- `IDLE` - Not recording, ready to start
- `RECORDING` - Actively recording
- `PAUSED` - Recording paused (API 24+)
- `PROCESSING` - Converting to MP3

#### AudioRecorderState.kt

Immutable state for audio recorder screen. Implements `UiState`.

**Properties:**
- `status: RecordingStatus` - Current recording status
- `elapsedTimeMs: Long` - Elapsed recording time
- `amplitudes: List<Float>` - Amplitude data for waveform visualization
- `config: RecordingConfig` - Recording configuration
- `hasPermission: Boolean` - Whether microphone permission is granted
- `error: RecorderError?` - Current error if any

**Computed Properties:**
- `isRecording`, `isPaused`, `isProcessing` - Status convenience checks
- `canRecord`, `canPause`, `canResume`, `canStop` - Action availability
- `formattedTime: String` - Time formatted as MM:SS

#### AudioRecorderEvent.kt

Sealed interface for user actions. Implements `UiEvent`.

**Events:**
- `StartRecording` - Begin recording
- `PauseRecording` - Pause active recording
- `ResumeRecording` - Resume paused recording
- `StopRecording` - Stop and process recording
- `CancelRecording` - Cancel without saving
- `RequestPermission` - Request microphone permission
- `PermissionGranted` - Permission was granted
- `PermissionDenied` - Permission was denied
- `ClearError` - Clear current error
- `RetryRecording` - Retry after error

#### AudioRecorderEffect.kt

Sealed interface for one-time side effects.

**Effects:**
- `RecordingComplete(audio: RecordedAudio)` - Recording finished successfully
- `Cancelled` - Recording was cancelled
- `Error(message: String)` - Error occurred
- `RequestMicrophonePermission` - Trigger permission request

#### AudioRecorderViewModel.kt

ViewModel for audio recording with MP3 output.

**Key Responsibilities:**
- Manage `AudioRecord` lifecycle
- Capture PCM data and encode to MP3 via LAME
- Track recording duration and amplitude
- Handle permission state

**State Management:**
- `_state: MutableStateFlow<AudioRecorderState>` - Private mutable state
- `state: StateFlow<AudioRecorderState>` - Public immutable state
- `_effect: Channel<AudioRecorderEffect>` - One-time effects channel
- `effect: Flow<AudioRecorderEffect>` - Public effect flow

**Private Members:**
- `audioRecord: AudioRecord?` - Native audio recorder
- `recordingJob: Job?` - Coroutine job for audio capture
- `timerJob: Job?` - Coroutine job for timer updates
- `pcmBuffer: ByteArrayOutputStream` - PCM data buffer
- `recordingStartTime: Long` - Recording start timestamp
- `pausedDuration: Long` - Total paused duration

**Key Methods:**
- `onEvent(event: AudioRecorderEvent)` - Single entry point for events
- `startRecording()` - Initialize AudioRecord and start capture
- `initializeAudioRecord()` - Configure AudioRecord with settings
- `startAudioCapture()` - Coroutine loop for reading PCM data
- `calculateAmplitude()` - RMS amplitude calculation for visualization
- `startTimerUpdates()` - Coroutine for elapsed time updates
- `pauseRecording()` - Stop capture, track paused duration
- `resumeRecording()` - Resume capture after pause
- `stopRecording()` - Stop capture, trigger MP3 encoding
- `encodeToMp3()` - Convert PCM buffer to MP3 using Mp3Encoder
- `cancelRecording()` - Cancel and cleanup without saving
- `releaseAudioRecord()` - Release native resources
- `onCleared()` - Cleanup on ViewModel destruction

#### AudioRecorderScreen.kt

Composable for audio recorder UI.

**Parameters:**
- `onRecordingComplete: (RecordedAudio) -> Unit` - Success callback
- `onCancelled: () -> Unit` - Cancellation callback
- `onError: (String) -> Unit` - Error callback
- `viewModel: AudioRecorderViewModel` - ViewModel instance

**Structure:**
- Permission handling via `ActivityResultContracts.RequestPermission`
- Effect collection in `LaunchedEffect`
- Delegates to `AudioRecorderContent` for stateless UI

**AudioRecorderContent (private):**
- Stateless, testable composable
- Parameters: `state`, `onEvent`, `modifier`
- Layout: Timer → Waveform → Controls → Processing indicator → Error card

### Components

#### RecordingControls.kt

Recording control buttons composable.

**Parameters:**
- `status: RecordingStatus` - Current status
- `hasPermission: Boolean` - Permission state
- `onStartClick`, `onPauseClick`, `onResumeClick`, `onStopClick`, `onCancelClick` - Callbacks

**Behavior by Status:**
- `IDLE`: Show record button (red, microphone icon)
- `RECORDING`: Show cancel, pause, stop buttons
- `PAUSED`: Show cancel, resume, done buttons
- `PROCESSING`: No controls shown

#### RecordingTimer.kt

Recording timer display with animated color.

**Parameters:**
- `formattedTime: String` - Time string (MM:SS)
- `isRecording: Boolean` - Recording state
- `isPaused: Boolean` - Paused state

**Behavior:**
- Red color when recording
- Primary color when paused
- Default color when idle
- Monospace font for consistent width

#### WaveformVisualizer.kt

Real-time audio waveform visualization using Canvas.

**Parameters:**
- `amplitudes: List<Float>` - Amplitude values (0-1)
- `isRecording: Boolean` - Recording state
- `barColor: Color` - Active bar color
- `inactiveColor: Color` - Idle bar color

**Behavior:**
- Animated alpha when recording
- Static placeholder bars when idle
- Auto-scales to fit available width

---

## Audio Player Feature

### Domain Layer

#### AudioPlaybackState (enum)

Playback state enumeration:
- `IDLE` - Not loaded
- `LOADING` - Loading audio
- `READY` - Loaded, ready to play
- `PLAYING` - Currently playing
- `PAUSED` - Paused
- `COMPLETED` - Playback completed
- `ERROR` - Error state

#### PlayerError.kt

Sealed interface for player errors with `message` property.

**Subtypes:**
- `LoadFailed` - Failed to load audio file
- `PlaybackFailed` - Error during playback
- `UnsupportedFormat` - Audio format not supported

### Extension to MediaItem

#### MediaItem.kt (Extended)

Add `AudioItem` to existing sealed interface.

**AudioItem Properties:**
- `id: String` - Unique identifier
- `uri: Uri` - Audio file URI
- `mimeType: String` - Default: "audio/mpeg"
- `durationMs: Long` - Duration in milliseconds
- `fileName: String` - Display name
- `waveformData: List<Float>` - Pre-computed waveform
- `thumbnailBitmap: Bitmap?` - Optional album art
- `type: MediaType` - Returns `MediaType.AUDIO`

**MediaType Extension:**
Add `AUDIO` to existing enum: `IMAGE, VIDEO, FILE, AUDIO`

### Presentation Layer

#### AudioPlayerState.kt

Immutable state for audio player. Implements `UiState`.

**Properties:**
- `audioItem: MediaItem.AudioItem?` - Current audio item
- `playbackState: AudioPlaybackState` - Current playback state
- `currentPositionMs: Long` - Current playback position
- `durationMs: Long` - Total duration
- `isMuted: Boolean` - Mute state
- `playbackSpeed: Float` - Playback speed multiplier
- `error: PlayerError?` - Current error if any

**Computed Properties:**
- `isPlaying`, `isPaused`, `isLoading`, `isReady` - State convenience checks
- `progress: Float` - Playback progress (0-1)
- `formattedCurrentTime`, `formattedDuration` - Time strings (MM:SS)

#### AudioPlayerEvent.kt

Sealed interface for user actions. Implements `UiEvent`.

**Events:**
- `LoadAudio(audioItem: MediaItem.AudioItem)` - Load audio item
- `LoadFromUri(uri: Uri)` - Load from URI directly
- `Play` - Start/resume playback
- `Pause` - Pause playback
- `Stop` - Stop and reset
- `SeekTo(positionMs: Long)` - Seek to position
- `SeekToProgress(progress: Float)` - Seek to percentage
- `ToggleMute` - Toggle mute state
- `SetPlaybackSpeed(speed: Float)` - Set playback speed
- `Replay` - Restart from beginning
- `Forward10Seconds` - Skip forward 10s
- `Rewind10Seconds` - Skip backward 10s
- `ClearError` - Clear current error
- `Release` - Release player resources

#### AudioPlayerEffect.kt

Sealed interface for one-time side effects.

**Effects:**
- `PlaybackCompleted` - Playback finished
- `Error(message: String)` - Error occurred

#### AudioPlayerViewModel.kt

ViewModel for audio playback using ExoPlayer. Annotated with `@HiltViewModel`.

**Key Responsibilities:**
- Manage ExoPlayer lifecycle
- Track playback state and position
- Handle seek operations
- Support playback speed adjustment

**Constructor Dependencies:**
- `@ApplicationContext context: Context` - Application context for ExoPlayer

**State Management:**
- `_state: MutableStateFlow<AudioPlayerState>` - Private mutable state
- `state: StateFlow<AudioPlayerState>` - Public immutable state
- `_effect: Channel<AudioPlayerEffect>` - One-time effects channel
- `effect: Flow<AudioPlayerEffect>` - Public effect flow

**Private Members:**
- `exoPlayer: ExoPlayer?` - ExoPlayer instance
- `positionUpdateJob: Job?` - Position update coroutine
- `playerListener: Player.Listener` - ExoPlayer state listener

**Player Listener Callbacks:**
- `onIsPlayingChanged(isPlaying)` - Update playing state
- `onPlaybackStateChanged(state)` - Handle BUFFERING, READY, ENDED, IDLE
- `onPlayerError(error)` - Handle playback errors

**Key Methods:**
- `onEvent(event: AudioPlayerEvent)` - Single entry point for events
- `initializePlayer()` - Create ExoPlayer instance
- `loadAudio(audioItem)` - Load and prepare audio
- `loadFromUri(uri)` - Load from URI
- `play()` - Start playback, begin position updates
- `pause()` - Pause playback, stop position updates
- `stop()` - Stop and reset
- `seekTo(positionMs)` - Seek to position
- `seekToProgress(progress)` - Seek to percentage
- `toggleMute()` - Toggle volume 0/1
- `setPlaybackSpeed(speed)` - Set playback rate
- `replay()` - Seek to 0 and play
- `forward10Seconds()` - Seek +10s
- `rewind10Seconds()` - Seek -10s
- `release()` - Release ExoPlayer resources
- `startPositionUpdates()` - Coroutine for position polling
- `onCleared()` - Cleanup on ViewModel destruction

#### AudioPlayerScreen.kt

Composable for audio player UI.

**Parameters:**
- `audioItem: MediaItem.AudioItem` - Audio to play
- `onPlaybackComplete: (() -> Unit)?` - Completion callback
- `onError: ((String) -> Unit)?` - Error callback
- `viewModel: AudioPlayerViewModel` - ViewModel (hiltViewModel)

**Structure:**
- Load audio in `LaunchedEffect(audioItem)`
- Collect effects in `LaunchedEffect(Unit)`
- Release player in `DisposableEffect`
- Delegates to `AudioPlayerContent` for stateless UI

**AudioPlayerContent (private):**
- Stateless, testable composable
- Parameters: `state`, `onEvent`, `modifier`
- Layout: Waveform → SeekBar → Controls → Loading indicator → Error card

### Components

#### PlaybackControls.kt

Playback control buttons with speed selector.

**Parameters:**
- `isPlaying`, `isPaused`, `isLoading`, `isMuted` - State flags
- `playbackSpeed: Float` - Current speed
- `onPlayClick`, `onPauseClick`, `onRewindClick`, `onForwardClick`, `onMuteClick` - Callbacks
- `onSpeedChange: (Float) -> Unit` - Speed change callback

**Layout:**
- Main row: Rewind 10s, Play/Pause, Forward 10s
- Secondary row: Mute toggle, Speed selector dropdown

**Speed Options:** 0.5x, 0.75x, 1.0x, 1.25x, 1.5x, 2.0x

#### SeekBar.kt

Seek bar with time labels.

**Parameters:**
- `progress: Float` - Current progress (0-1)
- `currentTime: String` - Formatted current time
- `duration: String` - Formatted duration
- `enabled: Boolean` - Whether seeking is allowed
- `onSeek: (Float) -> Unit` - Seek callback

**Behavior:**
- Internal drag state tracking
- Updates position only when not dragging
- Calls `onSeek` on drag end

#### AudioWaveform.kt

Audio waveform visualization for player using Canvas.

**Parameters:**
- `waveformData: List<Float>` - Pre-computed waveform
- `progress: Float` - Playback progress
- `isPlaying: Boolean` - Playing state
- `playedColor: Color` - Color for played portion
- `unplayedColor: Color` - Color for unplayed portion

**Behavior:**
- Resamples waveform data to fit available width
- Colors bars based on progress position
- Shows placeholder bars if no waveform data

---

## MediaShowcase Integration

### Integration Approach

Extend the existing `MediaShowcase.kt` with audio recording and playback capabilities following the same pattern as camera/cropping integration.

### New State Variables

Add to MediaShowcase composable:
- `showAudioRecorder: Boolean` - Audio recorder dialog visibility
- `recordedAudio: RecordedAudio?` - Last recorded audio
- `showAudioPlayer: Boolean` - Audio player dialog visibility
- `audioToPlay: MediaItem.AudioItem?` - Audio item for playback

### New Feature Cards

Add two new `MediaFeatureCard` entries:

**Audio Recorder Card:**
- Title: "Audio Recorder"
- Description: "Record audio with MP3 output format. Supports pause/resume."
- Icon: `Icons.Default.Mic`
- Button: "Record Audio"
- Action: Show audio recorder dialog

**Audio Player Card:**
- Title: "Audio Player"
- Description: "Play MP3 audio files with waveform visualization."
- Icon: `Icons.Default.PlayCircle`
- Button: "Play Audio"
- Action: Convert recorded audio to AudioItem, show player dialog
- Enabled: Only when `recordedAudio != null`

### New Components

#### RecordedAudioPreviewCard

Preview card for recorded audio (similar to `CapturedImagePreviewCard`).

**Content:**
- Audio file icon with title
- Clear button (X)
- Duration and file size info
- "Play Recording" button

#### Conversion Extension

`RecordedAudio.toAudioItem()` extension function:
- Creates temporary file in cache directory
- Writes audio bytes to file
- Returns `MediaItem.AudioItem` with file URI

### Dialog Flows

**Audio Recorder Dialog:**
- Full-screen dialog containing `AudioRecorderScreen`
- On recording complete: Store result, close dialog
- On cancelled/error: Close dialog

**Audio Player Dialog:**
- Full-screen dialog containing `AudioPlayerScreen`
- On playback complete: Optional auto-close or loop
- On error: Close dialog, clear audio item

---

## Data Flow Diagrams

### Audio Recording Flow

```
┌─────────────────────────────────────────────────────────────────────┐
│                         AUDIO RECORDING FLOW                        │
└─────────────────────────────────────────────────────────────────────┘

User Action                    ViewModel                    System
    │                              │                           │
    │  StartRecording              │                           │
    ├─────────────────────────────>│                           │
    │                              │  Check Permission         │
    │                              ├──────────────────────────>│
    │                              │                           │
    │                              │  Init AudioRecord         │
    │                              ├──────────────────────────>│
    │                              │                           │
    │                              │  Start Capture Job        │
    │                              ├───────────┐               │
    │                              │           │ PCM Data Loop │
    │  State: RECORDING            │<──────────┘               │
    │<─────────────────────────────┤                           │
    │                              │                           │
    │  Amplitude Updates           │                           │
    │<─────────────────────────────┤                           │
    │                              │                           │
    │  StopRecording               │                           │
    ├─────────────────────────────>│                           │
    │                              │  Stop AudioRecord         │
    │                              ├──────────────────────────>│
    │                              │                           │
    │  State: PROCESSING           │                           │
    │<─────────────────────────────┤                           │
    │                              │                           │
    │                              │  MP3 Encoding (LAME)      │
    │                              ├───────────┐               │
    │                              │           │               │
    │                              │<──────────┘               │
    │                              │                           │
    │  Effect: RecordingComplete   │                           │
    │<─────────────────────────────┤                           │
    │                              │                           │
    ▼                              ▼                           ▼
```

### Audio Playback Flow

```
┌─────────────────────────────────────────────────────────────────────┐
│                         AUDIO PLAYBACK FLOW                         │
└─────────────────────────────────────────────────────────────────────┘

User Action                    ViewModel                   ExoPlayer
    │                              │                           │
    │  LoadAudio(item)             │                           │
    ├─────────────────────────────>│                           │
    │                              │  Initialize Player        │
    │                              ├──────────────────────────>│
    │                              │                           │
    │                              │  Set Media Item           │
    │                              ├──────────────────────────>│
    │                              │                           │
    │                              │  Prepare                  │
    │                              ├──────────────────────────>│
    │                              │                           │
    │  State: LOADING              │                           │
    │<─────────────────────────────┤                           │
    │                              │                           │
    │                              │  Player Callback: READY   │
    │                              │<──────────────────────────┤
    │                              │                           │
    │  State: READY                │                           │
    │<─────────────────────────────┤                           │
    │                              │                           │
    │  Play                        │                           │
    ├─────────────────────────────>│                           │
    │                              │  player.play()            │
    │                              ├──────────────────────────>│
    │                              │                           │
    │  State: PLAYING              │                           │
    │<─────────────────────────────┤                           │
    │                              │                           │
    │  Position Updates (100ms)    │                           │
    │<─────────────────────────────┤                           │
    │                              │                           │
    │  SeekToProgress(0.5f)        │                           │
    ├─────────────────────────────>│                           │
    │                              │  player.seekTo(ms)        │
    │                              ├──────────────────────────>│
    │                              │                           │
    │                              │  Callback: STATE_ENDED    │
    │                              │<──────────────────────────┤
    │                              │                           │
    │  Effect: PlaybackCompleted   │                           │
    │<─────────────────────────────┤                           │
    │                              │                           │
    ▼                              ▼                           ▼
```

### MediaShowcase Integration Flow

```
┌─────────────────────────────────────────────────────────────────────┐
│                    MEDIASHOWCASE INTEGRATION                        │
└─────────────────────────────────────────────────────────────────────┘

                    ┌───────────────────┐
                    │   MediaShowcase   │
                    │     (Host)        │
                    └─────────┬─────────┘
                              │
           ┌──────────────────┼──────────────────┐
           │                  │                  │
           ▼                  ▼                  ▼
   ┌───────────────┐  ┌───────────────┐  ┌───────────────┐
   │    Camera     │  │    Audio      │  │    Audio      │
   │   Capture     │  │   Recorder    │  │    Player     │
   └───────┬───────┘  └───────┬───────┘  └───────┬───────┘
           │                  │                  │
           ▼                  ▼                  ▼
   ┌───────────────┐  ┌───────────────┐  ┌───────────────┐
   │ CapturedImage │  │ RecordedAudio │  │  AudioItem    │
   └───────────────┘  └───────────────┘  └───────────────┘
           │                  │                  │
           │                  │   toAudioItem()  │
           │                  ├─────────────────>│
           │                  │                  │
           └──────────────────┼──────────────────┘
                              │
                              ▼
                    ┌───────────────────┐
                    │   Preview Cards   │
                    │  (UI Feedback)    │
                    └───────────────────┘
```

---

## MP3 Format Considerations

### Challenge: Native MP3 Encoding

Android does **not** have native MP3 encoding support. The available native encoders via `MediaRecorder` and `MediaCodec` are:
- AAC (MPEG-4 Audio)
- AMR-NB/AMR-WB
- Opus (API 29+)
- FLAC

**Why Third-Party Library is Required:**
- MP3 is a patented format (patents expired 2017, but no native Android support added)
- No `MediaCodec` encoder for MP3 exists
- LAME is the industry-standard, open-source MP3 encoder

### Solution: Mp3Encoder Utility (LAME Wrapper)

Use `AudioRecord` to capture raw PCM data, then encode to MP3 using LAME library via JNI.

#### Recommended Library

**LameMP3 for Android**

| Library | Size | License | Notes |
|---------|------|---------|-------|
| `naman14:androidlame` | ~300KB | LGPL | Pre-built LAME JNI wrapper |
| `nickartyom:lame-android` | ~250KB | LGPL | Minimal LAME wrapper |

**Gradle Dependency (choose one):**
```
implementation("com.naman14.androidlame:androidlame:1.1")
```

#### Mp3Encoder.kt

Stateless utility object wrapping LAME encoder.

**Location:** `feature/utils/Mp3Encoder.kt`

**EncodingOutcome (sealed class):**
- `Success(data: ByteArray)` - Encoded MP3 data
- `Error(message: String)` - Encoding failed

**Public Method:**
- `encode(pcmData, sampleRate, channels, bitRate, quality): EncodingOutcome`

**Implementation Approach:**
1. Initialize LAME encoder with configuration
2. Set sample rate, channels, bit rate, quality
3. Feed PCM data in chunks to LAME encoder
4. Collect encoded MP3 frames
5. Flush encoder and finalize MP3 data

**LAME Configuration Parameters:**
- `inSampleRate` - Input PCM sample rate (44100 recommended)
- `outSampleRate` - Output MP3 sample rate (same as input)
- `numChannels` - 1 (mono) or 2 (stereo)
- `bitRate` - Output bit rate in kbps (128, 192, 256, 320)
- `quality` - Encoding quality (0-9, lower is better/slower)
- `mode` - MONO, STEREO, JOINT_STEREO

**Encoding Flow:**
1. `LameBuilder()` - Create encoder instance
2. `setInSampleRate(44100)` - Set input sample rate
3. `setOutChannels(1)` - Set output channels
4. `setOutBitrate(128)` - Set bit rate
5. `setQuality(5)` - Set quality (balanced)
6. `build()` - Initialize encoder
7. `encode(pcmData, mp3Buffer)` - Encode PCM chunks
8. `flush(mp3Buffer)` - Finalize encoding

### Why LAME is the Minimal Acceptable Solution

| Criteria | LAME | MediaRecorder + AAC | FFmpeg |
|----------|------|---------------------|--------|
| Output Format | MP3 | M4A/AAC | MP3 |
| Library Size | ~300KB | 0 (native) | 2-5MB |
| Complexity | Low | Low | High |
| MP3 Compatibility | Full | None | Full |
| License | LGPL | N/A | LGPL/GPL |

**Conclusion**: LAME is required for MP3 output. It is lightweight (~300KB), well-maintained, and the industry standard for MP3 encoding.

---

## Assumptions

1. **Minimum SDK**: API 24 (Android 7.0) as per `build.gradle.kts`
2. **Permission Handling**: RECORD_AUDIO permission is managed at screen level
3. **File Storage**: Temporary files stored in app cache; persistent storage is caller's responsibility
4. **Audio Format**: MP3 with LAME encoder (44.1kHz, 128kbps, mono by default)
5. **Playback**: ExoPlayer is already configured in the project for MP3 support
6. **MediaShowcase Scope**: Extension only, no refactoring of existing camera/crop flows
7. **State Management**: MVI pattern is appropriate due to complex recording states
8. **Thread Safety**: AudioRecord and LAME encoding operations run on `Dispatchers.IO`
9. **Third-Party Dependency**: LAME library is acceptable for MP3 encoding (no native alternative)

---

## Risks and Limitations

### Technical Risks

| Risk | Impact | Mitigation |
|------|--------|------------|
| LAME library adds ~300KB to APK | Slight increase in app size | Acceptable trade-off for MP3 support; no alternatives |
| AudioRecord requires RECORD_AUDIO at runtime | App crash if permission denied | Comprehensive permission flow with fallback UI |
| Large recordings consume memory | OOM on long recordings | Stream to file instead of ByteArrayOutputStream |
| LAME encoding is CPU-intensive | UI jank during encoding | Run encoding on `Dispatchers.IO`; show processing indicator |
| Background recording not supported | Recording stops if app backgrounded | Document limitation; consider foreground service |

### Architectural Risks

| Risk | Impact | Mitigation |
|------|--------|------------|
| MediaItem.AudioItem extension may break existing code | Compile errors | Thorough testing of MediaCarousel with mixed types |
| ViewModel memory leaks if player not released | Memory pressure | DisposableEffect cleanup; onCleared() release |
| State explosion in recorder ViewModel | Hard to maintain | Keep states minimal; document state machine |
| LAME native library compatibility | Crashes on some architectures | Use library with multi-ABI support (armeabi-v7a, arm64-v8a, x86, x86_64) |

### Platform Limitations

- **API 24 Pause/Resume**: AudioRecord pause/resume works on API 24+ but may have device-specific issues
- **No Native MP3 Encoder**: Android has no built-in MP3 encoding; LAME is required
- **LGPL License**: LAME uses LGPL; ensure compliance (dynamic linking is acceptable)

---

## Trade-offs and Decisions

### Decision 1: MVI over MVVM for Recorder

**Choice**: MVI (Model-View-Intent) pattern for Audio Recorder

**Rationale**:
- Recording has complex state transitions (IDLE → RECORDING → PAUSED → PROCESSING)
- Multiple user interactions (start, pause, resume, stop, cancel)
- Side effects required (permission requests, encoding completion)
- Consistent with existing MediaCarousel implementation

**Alternative Considered**: MVVM would be simpler but doesn't handle the state machine elegantly

### Decision 2: AudioRecord over MediaRecorder

**Choice**: Use `AudioRecord` for PCM capture + LAME encoding

**Rationale**:
- MediaRecorder doesn't support MP3 output format
- AudioRecord provides raw PCM data for LAME encoding
- More control over audio quality and encoding parameters
- Allows real-time amplitude visualization

**Trade-off**: Requires third-party LAME library but achieves MP3 output requirement

### Decision 3: LAME for MP3 Encoding

**Choice**: Use LAME library via JNI wrapper

**Rationale**:
- No native Android MP3 encoder exists
- LAME is industry-standard, open-source MP3 encoder
- Lightweight (~300KB), well-maintained
- Produces fully compatible MP3 files

**Trade-off**: Adds third-party dependency, but this is unavoidable for MP3 output. LAME is the minimal, most reliable solution.

### Decision 4: ExoPlayer for Playback (No Change)

**Choice**: Use existing ExoPlayer (media3) for audio playback

**Rationale**:
- Already in project dependencies
- Native MP3 decoding support
- Consistent with VideoPreview implementation
- Handles buffering, seeking, and lifecycle automatically

**Alternative Considered**: Android MediaPlayer supports MP3 but lacks features like speed control and has inconsistent behavior

### Decision 5: Extend MediaItem vs. Separate Model

**Choice**: Extend `MediaItem` sealed interface with `AudioItem`

**Rationale**:
- Consistent with existing media handling (ImageItem, VideoItem)
- Enables future integration with MediaCarousel
- Single abstraction for all media types

**Trade-off**: Requires updating MediaCarousel components to handle AudioItem

### Decision 6: In-Memory PCM Buffer

**Choice**: Buffer PCM data in `ByteArrayOutputStream` during recording

**Rationale**:
- Simple implementation
- Suitable for recordings under 5 minutes
- Avoids file I/O during recording

**Trade-off**: Memory pressure on long recordings. For recordings > 5 minutes, should stream to temporary file.

---

## Implementation Checklist

### Phase 1: Domain Layer
- [ ] Create `RecordedAudio` data class
- [ ] Create `RecordingConfig` data class
- [ ] Create `RecorderError` sealed interface
- [ ] Create `AudioPlaybackState` enum
- [ ] Create `PlayerError` sealed interface
- [ ] Extend `MediaItem` with `AudioItem`
- [ ] Add `AUDIO` to `MediaType` enum

### Phase 2: Utility Layer
- [ ] Add LAME library dependency to `build.gradle.kts`
- [ ] Implement `Mp3Encoder` utility (LAME wrapper)
- [ ] Add `AudioDurationExtractor` utility (optional)

### Phase 3: Audio Recorder Feature
- [ ] Create `AudioRecorderState` data class
- [ ] Create `AudioRecorderEvent` sealed interface
- [ ] Create `AudioRecorderEffect` sealed interface
- [ ] Implement `AudioRecorderViewModel`
- [ ] Create `RecordingControls` composable
- [ ] Create `RecordingTimer` composable
- [ ] Create `WaveformVisualizer` composable
- [ ] Create `AudioRecorderScreen` composable

### Phase 4: Audio Player Feature
- [ ] Create `AudioPlayerState` data class
- [ ] Create `AudioPlayerEvent` sealed interface
- [ ] Create `AudioPlayerEffect` sealed interface
- [ ] Implement `AudioPlayerViewModel`
- [ ] Create `PlaybackControls` composable
- [ ] Create `SeekBar` composable
- [ ] Create `AudioWaveform` composable
- [ ] Create `AudioPlayerScreen` composable

### Phase 5: MediaShowcase Integration
- [ ] Add audio recorder card to MediaShowcase
- [ ] Add audio player card to MediaShowcase
- [ ] Create `RecordedAudioPreviewCard` composable
- [ ] Implement `RecordedAudio.toAudioItem()` extension
- [ ] Add dialog flows for recorder and player

### Phase 6: Testing
- [ ] Unit tests for `Mp3Encoder`
- [ ] Unit tests for `AudioRecorderViewModel`
- [ ] Unit tests for `AudioPlayerViewModel`
- [ ] UI tests for recorder screen
- [ ] UI tests for player screen
- [ ] Integration tests with MediaShowcase

---

## Appendix: File Reference

| File | Purpose |
|------|---------|
| `feature/audiorecorder/domain/model/RecordedAudio.kt` | Recorded audio data class |
| `feature/audiorecorder/domain/model/RecordingConfig.kt` | Recording configuration |
| `feature/audiorecorder/domain/model/RecorderError.kt` | Error types for recorder |
| `feature/audiorecorder/presentation/AudioRecorderState.kt` | MVI state |
| `feature/audiorecorder/presentation/AudioRecorderEvent.kt` | MVI events |
| `feature/audiorecorder/presentation/AudioRecorderEffect.kt` | MVI effects |
| `feature/audiorecorder/presentation/AudioRecorderViewModel.kt` | Recorder ViewModel |
| `feature/audiorecorder/presentation/AudioRecorderScreen.kt` | Main screen composable |
| `feature/audiorecorder/presentation/components/RecordingControls.kt` | Control buttons |
| `feature/audiorecorder/presentation/components/RecordingTimer.kt` | Timer display |
| `feature/audiorecorder/presentation/components/WaveformVisualizer.kt` | Real-time waveform |
| `feature/audioplayer/domain/model/AudioPlaybackState.kt` | Playback state enum |
| `feature/audioplayer/domain/model/PlayerError.kt` | Error types for player |
| `feature/audioplayer/presentation/AudioPlayerState.kt` | MVI state |
| `feature/audioplayer/presentation/AudioPlayerEvent.kt` | MVI events |
| `feature/audioplayer/presentation/AudioPlayerEffect.kt` | MVI effects |
| `feature/audioplayer/presentation/AudioPlayerViewModel.kt` | Player ViewModel |
| `feature/audioplayer/presentation/AudioPlayerScreen.kt` | Main screen composable |
| `feature/audioplayer/presentation/components/PlaybackControls.kt` | Control buttons |
| `feature/audioplayer/presentation/components/SeekBar.kt` | Seek slider |
| `feature/audioplayer/presentation/components/AudioWaveform.kt` | Static waveform |
| `feature/media_carousel/domain/model/MediaItem.kt` | Extended with AudioItem |
| `feature/utils/Mp3Encoder.kt` | PCM to MP3 encoding (LAME wrapper) |
| `feature/componentshowcase/presentation/components/MediaShowcase.kt` | Integration point |

---

*Document Version: 1.2*
*Last Updated: January 2026*
*Architecture Reference: CLAUDE.md*
*Audio Format: MP3 (LAME encoder)*
