package com.neome.feature.audioplayer.presentation

import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AudioFile
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.neome.feature.audioplayer.domain.model.AudioPlaybackState
import com.neome.feature.audioplayer.presentation.components.AudioWaveform
import com.neome.feature.audioplayer.presentation.components.PlaybackControls
import com.neome.feature.audioplayer.presentation.components.SeekBar

/**
 * Audio player screen composable.
 * Supports loading from URI or byte array.
 */
@Composable
fun AudioPlayerScreen(
    audioUri: Uri? = null,
    audioBytes: ByteArray? = null,
    audioName: String = "Audio",
    onPlaybackComplete: (() -> Unit)? = null,
    onError: ((String) -> Unit)? = null,
    onClose: (() -> Unit)? = null,
    viewModel: AudioPlayerViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    // Load audio on first composition
    LaunchedEffect(audioUri, audioBytes) {
        when {
            audioUri != null -> viewModel.onEvent(AudioPlayerEvent.LoadAudio(audioUri, audioName))
            audioBytes != null -> viewModel.onEvent(AudioPlayerEvent.LoadFromBytes(audioBytes, audioName))
        }
    }

    // Collect effects
    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is AudioPlayerEffect.PlaybackCompleted -> onPlaybackComplete?.invoke()
                is AudioPlayerEffect.Error -> onError?.invoke(effect.message)
            }
        }
    }

    // Release player on dispose
    DisposableEffect(Unit) {
        onDispose {
            viewModel.onEvent(AudioPlayerEvent.Release)
        }
    }

    AudioPlayerContent(
        state = state,
        onEvent = viewModel::onEvent,
        onClose = onClose
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AudioPlayerContent(
    state: AudioPlayerState,
    onEvent: (AudioPlayerEvent) -> Unit,
    onClose: (() -> Unit)?,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = state.audioName.ifEmpty { "Audio Player" },
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    if (onClose != null) {
                        IconButton(onClick = onClose) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = "Close"
                            )
                        }
                    }
                }
            )
        },
        modifier = modifier
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            when {
                state.isLoading -> {
                    LoadingContent()
                }
                state.hasError && state.error != null -> {
                    ErrorContent(
                        errorMessage = state.error.message,
                        onRetry = { onEvent(AudioPlayerEvent.ClearError) }
                    )
                }
                else -> {
                    PlayerContent(
                        state = state,
                        onEvent = onEvent
                    )
                }
            }
        }
    }
}

@Composable
private fun LoadingContent(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CircularProgressIndicator()
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Loading audio...",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
private fun ErrorContent(
    errorMessage: String,
    onRetry: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.errorContainer
            )
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Playback Error",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onErrorContainer
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = errorMessage,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onErrorContainer,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(16.dp))
                TextButton(onClick = onRetry) {
                    Text("Dismiss")
                }
            }
        }
    }
}

@Composable
private fun PlayerContent(
    state: AudioPlayerState,
    onEvent: (AudioPlayerEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Audio icon
        Icon(
            imageVector = Icons.Default.AudioFile,
            contentDescription = null,
            modifier = Modifier.size(80.dp),
            tint = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Waveform visualization
        AudioWaveform(
            waveformData = state.waveformData,
            progress = state.progress,
            isPlaying = state.isPlaying,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Seek bar
        SeekBar(
            progress = state.progress,
            currentTime = state.formattedCurrentTime,
            duration = state.formattedDuration,
            enabled = state.canSeek,
            onSeekStarted = { progress -> onEvent(AudioPlayerEvent.SeekStarted(progress)) },
            onSeekChanged = { progress -> onEvent(AudioPlayerEvent.SeekProgressChanged(progress)) },
            onSeekEnded = { progress -> onEvent(AudioPlayerEvent.SeekEnded(progress)) },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(32.dp))
        // Playback controls
        PlaybackControls(
            isPlaying = state.isPlaying,
            isPaused = state.isPaused,
            isLoading = state.isLoading,
            isMuted = state.isMuted,
            playbackSpeed = state.playbackSpeed,
            onPlayClick = { onEvent(AudioPlayerEvent.Play) },
            onPauseClick = { onEvent(AudioPlayerEvent.Pause) },
            onRewindClick = { onEvent(AudioPlayerEvent.Rewind10Seconds) },
            onForwardClick = { onEvent(AudioPlayerEvent.Forward10Seconds) },
            onMuteClick = { onEvent(AudioPlayerEvent.ToggleMute) },
            onSpeedChange = { speed -> onEvent(AudioPlayerEvent.SetPlaybackSpeed(speed)) },
            enabled = state.playbackState != AudioPlaybackState.IDLE
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Status text
        if (state.isCompleted) {
            Text(
                text = "Playback completed",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}
