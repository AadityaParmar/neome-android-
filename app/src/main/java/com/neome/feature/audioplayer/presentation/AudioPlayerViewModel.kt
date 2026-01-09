package com.neome.feature.audioplayer.presentation

import android.content.Context
import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.media3.common.MediaItem
import androidx.media3.common.PlaybackException
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import com.neome.feature.audioplayer.domain.model.AudioPlaybackState
import com.neome.feature.audioplayer.domain.model.PlayerError
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

/**
 * ViewModel for audio playback using ExoPlayer.
 * Manages player lifecycle and playback state using MVI pattern.
 */
@HiltViewModel
class AudioPlayerViewModel @Inject constructor(
    @ApplicationContext private val context: Context
) : ViewModel() {

    private val _state = MutableStateFlow(AudioPlayerState())
    val state = _state.asStateFlow()

    private val _effect = Channel<AudioPlayerEffect>()
    val effect = _effect.receiveAsFlow()

    private var exoPlayer: ExoPlayer? = null
    private var positionUpdateJob: Job? = null
    private var tempAudioFile: File? = null

    // Track if we're in a seek operation to ignore buffering state
    private var isSeekingInternal = false
    // Store state before seeking to restore after seek completes
    private var stateBeforeSeek: AudioPlaybackState? = null

    private val playerListener = object : Player.Listener {
        override fun onIsPlayingChanged(isPlaying: Boolean) {
            // Don't update state during seek
            if (isSeekingInternal) return

            if (isPlaying) {
                _state.update { it.copy(playbackState = AudioPlaybackState.PLAYING) }
                startPositionUpdates()
            } else if (_state.value.playbackState == AudioPlaybackState.PLAYING) {
                _state.update { it.copy(playbackState = AudioPlaybackState.PAUSED) }
                stopPositionUpdates()
            }
        }

        override fun onPlaybackStateChanged(playbackState: Int) {
            when (playbackState) {
                Player.STATE_BUFFERING -> {
                    // Only show loading for initial load, not for seek buffering
                    // Check if audio was already loaded (not IDLE or LOADING)
                    val currentState = _state.value.playbackState
                    val isInitialLoad = currentState == AudioPlaybackState.IDLE ||
                            currentState == AudioPlaybackState.LOADING

                    if (isInitialLoad && !isSeekingInternal) {
                        _state.update { it.copy(playbackState = AudioPlaybackState.LOADING) }
                    }
                    // During seek buffering, keep the current state
                }
                Player.STATE_READY -> {
                    val duration = exoPlayer?.duration ?: 0L

                    if (isSeekingInternal) {
                        // Seek complete - restore previous state or set to playing if was playing
                        isSeekingInternal = false
                        val restoredState = stateBeforeSeek ?: AudioPlaybackState.READY
                        stateBeforeSeek = null

                        _state.update {
                            it.copy(
                                playbackState = restoredState,
                                durationMs = duration
                            )
                        }

                        // Resume position updates if playing
                        if (restoredState == AudioPlaybackState.PLAYING) {
                            startPositionUpdates()
                        }
                    } else if (_state.value.playbackState == AudioPlaybackState.LOADING) {
                        // Initial load complete
                        _state.update {
                            it.copy(
                                playbackState = AudioPlaybackState.READY,
                                durationMs = duration
                            )
                        }
                    }
                }
                Player.STATE_ENDED -> {
                    isSeekingInternal = false
                    stateBeforeSeek = null
                    _state.update {
                        it.copy(
                            playbackState = AudioPlaybackState.COMPLETED,
                            currentPositionMs = it.durationMs
                        )
                    }
                    stopPositionUpdates()
                    viewModelScope.launch {
                        _effect.send(AudioPlayerEffect.PlaybackCompleted)
                    }
                }
                Player.STATE_IDLE -> {
                    isSeekingInternal = false
                    stateBeforeSeek = null
                    _state.update { it.copy(playbackState = AudioPlaybackState.IDLE) }
                }
            }
        }

        override fun onPlayerError(error: PlaybackException) {
            val playerError = when (error.errorCode) {
                PlaybackException.ERROR_CODE_IO_FILE_NOT_FOUND,
                PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_FAILED -> {
                    PlayerError.LoadFailed(error.message ?: "Failed to load audio")
                }
                PlaybackException.ERROR_CODE_DECODING_FORMAT_UNSUPPORTED -> {
                    PlayerError.UnsupportedFormat(error.message ?: "Format not supported")
                }
                else -> {
                    PlayerError.PlaybackFailed(error.message ?: "Playback error")
                }
            }
            _state.update {
                it.copy(
                    playbackState = AudioPlaybackState.ERROR,
                    error = playerError
                )
            }
            viewModelScope.launch {
                _effect.send(AudioPlayerEffect.Error(playerError.message))
            }
        }
    }

    /**
     * Single entry point for all user actions.
     */
    fun onEvent(event: AudioPlayerEvent) {
        when (event) {
            is AudioPlayerEvent.LoadAudio -> loadAudio(event.uri, event.name)
            is AudioPlayerEvent.LoadFromBytes -> loadFromBytes(event.bytes, event.name, event.mimeType)
            is AudioPlayerEvent.Play -> play()
            is AudioPlayerEvent.Pause -> pause()
            is AudioPlayerEvent.Stop -> stop()
            is AudioPlayerEvent.SeekTo -> seekTo(event.positionMs)
            is AudioPlayerEvent.SeekToProgress -> seekToProgress(event.progress)
            is AudioPlayerEvent.SeekStarted -> onSeekStarted(event.progress)
            is AudioPlayerEvent.SeekProgressChanged -> onSeekProgressChanged(event.progress)
            is AudioPlayerEvent.SeekEnded -> onSeekEnded(event.progress)
            is AudioPlayerEvent.ToggleMute -> toggleMute()
            is AudioPlayerEvent.SetPlaybackSpeed -> setPlaybackSpeed(event.speed)
            is AudioPlayerEvent.Replay -> replay()
            is AudioPlayerEvent.Forward10Seconds -> forward10Seconds()
            is AudioPlayerEvent.Rewind10Seconds -> rewind10Seconds()
            is AudioPlayerEvent.ClearError -> clearError()
            is AudioPlayerEvent.Release -> release()
        }
    }

    private fun initializePlayer() {
        if (exoPlayer == null) {
            exoPlayer = ExoPlayer.Builder(context).build().apply {
                addListener(playerListener)
            }
        }
    }

    private fun loadAudio(uri: Uri, name: String) {
        viewModelScope.launch {
            initializePlayer()
            _state.update {
                it.copy(
                    audioUri = uri,
                    audioName = name,
                    playbackState = AudioPlaybackState.LOADING,
                    currentPositionMs = 0L,
                    error = null
                )
            }

            try {
                val mediaItem = MediaItem.fromUri(uri)
                exoPlayer?.apply {
                    setMediaItem(mediaItem)
                    prepare()
                }
            } catch (e: Exception) {
                _state.update {
                    it.copy(
                        playbackState = AudioPlaybackState.ERROR,
                        error = PlayerError.LoadFailed(e.message ?: "Failed to load audio")
                    )
                }
            }
        }
    }

    private fun loadFromBytes(bytes: ByteArray, name: String, mimeType: String) {
        viewModelScope.launch {
            initializePlayer()
            _state.update {
                it.copy(
                    audioName = name,
                    playbackState = AudioPlaybackState.LOADING,
                    currentPositionMs = 0L,
                    error = null
                )
            }

            try {
                // Create temporary file
                val extension = when (mimeType) {
                    "audio/wav" -> ".wav"
                    "audio/mpeg" -> ".mp3"
                    else -> ".audio"
                }
                tempAudioFile = File.createTempFile("audio_", extension, context.cacheDir).apply {
                    writeBytes(bytes)
                }

                val uri = Uri.fromFile(tempAudioFile)
                _state.update { it.copy(audioUri = uri) }

                val mediaItem = MediaItem.fromUri(uri)
                exoPlayer?.apply {
                    setMediaItem(mediaItem)
                    prepare()
                }
            } catch (e: Exception) {
                _state.update {
                    it.copy(
                        playbackState = AudioPlaybackState.ERROR,
                        error = PlayerError.LoadFailed(e.message ?: "Failed to load audio")
                    )
                }
            }
        }
    }

    private fun play() {
        exoPlayer?.let { player ->
            if (_state.value.playbackState == AudioPlaybackState.COMPLETED) {
                player.seekTo(0)
            }
            player.play()
        }
    }

    private fun pause() {
        exoPlayer?.pause()
    }

    private fun stop() {
        exoPlayer?.apply {
            stop()
            seekTo(0)
        }
        _state.update {
            it.copy(
                playbackState = AudioPlaybackState.IDLE,
                currentPositionMs = 0L
            )
        }
        stopPositionUpdates()
    }

    private fun seekTo(positionMs: Long) {
        val clampedPosition = positionMs.coerceIn(0L, _state.value.durationMs)
        exoPlayer?.seekTo(clampedPosition)
        _state.update { it.copy(currentPositionMs = clampedPosition) }
    }

    private fun seekToProgress(progress: Float) {
        val positionMs = (progress * _state.value.durationMs).toLong()
        seekTo(positionMs)
    }

    /**
     * Called when user starts dragging the seek bar.
     * Pauses position updates to prevent UI flicker.
     */
    private fun onSeekStarted(progress: Float) {
        stopPositionUpdates()
        val seekPositionMs = (progress * _state.value.durationMs).toLong()
        _state.update {
            it.copy(
                isSeeking = true,
                seekPositionMs = seekPositionMs
            )
        }
    }

    /**
     * Called while user is dragging the seek bar.
     * Updates display position without actually seeking the player.
     */
    private fun onSeekProgressChanged(progress: Float) {
        val seekPositionMs = (progress * _state.value.durationMs).toLong()
        _state.update { it.copy(seekPositionMs = seekPositionMs) }
    }

    /**
     * Called when user releases the seek bar.
     * Performs the actual seek and resumes position updates.
     */
    private fun onSeekEnded(progress: Float) {
        val positionMs = (progress * _state.value.durationMs).toLong()
        val clampedPosition = positionMs.coerceIn(0L, _state.value.durationMs)

        // Set seeking flag and store state BEFORE seeking to handle buffering state
        isSeekingInternal = true
        stateBeforeSeek = _state.value.playbackState

        exoPlayer?.seekTo(clampedPosition)

        _state.update {
            it.copy(
                isSeeking = false,
                seekPositionMs = 0L,
                currentPositionMs = clampedPosition
            )
        }
    }

    private fun toggleMute() {
        val newMutedState = !_state.value.isMuted
        exoPlayer?.volume = if (newMutedState) 0f else 1f
        _state.update { it.copy(isMuted = newMutedState) }
    }

    private fun setPlaybackSpeed(speed: Float) {
        exoPlayer?.setPlaybackSpeed(speed)
        _state.update { it.copy(playbackSpeed = speed) }
    }

    private fun replay() {
        exoPlayer?.apply {
            seekTo(0)
            play()
        }
    }

    private fun forward10Seconds() {
        val newPosition = (_state.value.currentPositionMs + 10_000L)
            .coerceAtMost(_state.value.durationMs)
        seekTo(newPosition)
    }

    private fun rewind10Seconds() {
        val newPosition = (_state.value.currentPositionMs - 10_000L)
            .coerceAtLeast(0L)
        seekTo(newPosition)
    }

    private fun clearError() {
        _state.update { it.copy(error = null) }
    }

    private fun release() {
        stopPositionUpdates()
        exoPlayer?.apply {
            removeListener(playerListener)
            release()
        }
        exoPlayer = null
        tempAudioFile?.delete()
        tempAudioFile = null
        _state.update { AudioPlayerState() }
    }

    private fun startPositionUpdates() {
        stopPositionUpdates()
        positionUpdateJob = viewModelScope.launch {
            while (isActive) {
                exoPlayer?.let { player ->
                    _state.update { it.copy(currentPositionMs = player.currentPosition) }
                }
                delay(100)
            }
        }
    }

    private fun stopPositionUpdates() {
        positionUpdateJob?.cancel()
        positionUpdateJob = null
    }

    override fun onCleared() {
        super.onCleared()
        release()
    }
}
