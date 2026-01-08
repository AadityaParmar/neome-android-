package com.neome.feature.audiorecorder.presentation

import android.Manifest
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material3.Button
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.neome.feature.audiorecorder.domain.model.RecordedAudio
import com.neome.feature.audiorecorder.domain.model.RecorderError
import com.neome.feature.audiorecorder.presentation.components.RecordingControls
import com.neome.feature.audiorecorder.presentation.components.RecordingTimer
import com.neome.feature.audiorecorder.presentation.components.WaveformVisualizer

/**
 * Audio recorder screen composable.
 */
@Composable
fun AudioRecorderScreen(
    onRecordingComplete: (RecordedAudio) -> Unit,
    onCancelled: () -> Unit,
    onError: (String) -> Unit,
    viewModel: AudioRecorderViewModel = viewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    // Permission launcher
    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            viewModel.onEvent(AudioRecorderEvent.PermissionGranted)
        } else {
            viewModel.onEvent(AudioRecorderEvent.PermissionDenied)
        }
    }

    // Request permission on first composition
    LaunchedEffect(Unit) {
        permissionLauncher.launch(Manifest.permission.RECORD_AUDIO)
    }

    // Collect effects
    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is AudioRecorderEffect.RecordingComplete -> {
                    onRecordingComplete(effect.audio)
                }
                is AudioRecorderEffect.Cancelled -> {
                    onCancelled()
                }
                is AudioRecorderEffect.Error -> {
                    onError(effect.message)
                }
                is AudioRecorderEffect.RequestMicrophonePermission -> {
                    permissionLauncher.launch(Manifest.permission.RECORD_AUDIO)
                }
            }
        }
    }

    AudioRecorderContent(
        state = state,
        onEvent = viewModel::onEvent,
        onRetryPermission = { permissionLauncher.launch(Manifest.permission.RECORD_AUDIO) }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AudioRecorderContent(
    state: AudioRecorderState,
    onEvent: (AudioRecorderEvent) -> Unit,
    onRetryPermission: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Audio Recorder") },
                navigationIcon = {
                    IconButton(onClick = { onEvent(AudioRecorderEvent.CancelRecording) }) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Close"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            when {
                // Show permission request UI when permission is denied or not yet granted
                state.error is RecorderError.PermissionDenied -> {
                    PermissionDeniedContent(
                        onRetry = onRetryPermission,
                        onCancel = { onEvent(AudioRecorderEvent.CancelRecording) }
                    )
                }

                // Show permission request UI when permission hasn't been granted yet
                !state.hasPermission && state.status == RecordingStatus.IDLE -> {
                    PermissionRequiredContent(
                        onRequestPermission = onRetryPermission,
                        onCancel = { onEvent(AudioRecorderEvent.CancelRecording) }
                    )
                }

                else -> {
                    // Timer display
                    RecordingTimer(
                        formattedTime = state.formattedTime,
                        isRecording = state.isRecording,
                        isPaused = state.isPaused
                    )

                    Spacer(modifier = Modifier.height(48.dp))

                    // Waveform visualization
                    WaveformVisualizer(
                        amplitudes = state.amplitudes,
                        isRecording = state.isRecording,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                    )

                    Spacer(modifier = Modifier.height(48.dp))

                    // Recording controls
                    RecordingControls(
                        status = state.status,
                        hasPermission = state.hasPermission,
                        onStartClick = { onEvent(AudioRecorderEvent.StartRecording) },
                        onPauseClick = { onEvent(AudioRecorderEvent.PauseRecording) },
                        onResumeClick = { onEvent(AudioRecorderEvent.ResumeRecording) },
                        onStopClick = { onEvent(AudioRecorderEvent.StopRecording) },
                        onCancelClick = { onEvent(AudioRecorderEvent.CancelRecording) }
                    )

                    // Processing indicator
                    if (state.isProcessing) {
                        Spacer(modifier = Modifier.height(32.dp))
                        CircularProgressIndicator(modifier = Modifier.size(48.dp))
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Processing audio...",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }

                    // Error display (non-permission errors)
                    state.error?.let { error ->
                        if (error !is RecorderError.PermissionDenied) {
                            Spacer(modifier = Modifier.height(24.dp))
                            ErrorCard(
                                error = error,
                                onDismiss = { onEvent(AudioRecorderEvent.ClearError) },
                                onRetry = { onEvent(AudioRecorderEvent.RetryRecording) }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun PermissionRequiredContent(
    onRequestPermission: () -> Unit,
    onCancel: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = Icons.Default.Mic,
            contentDescription = null,
            modifier = Modifier.size(64.dp),
            tint = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "Microphone Access Needed",
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.onSurface
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "To record audio, please allow access to your microphone.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = onRequestPermission,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Allow Microphone Access")
        }
        Spacer(modifier = Modifier.height(8.dp))
        TextButton(onClick = onCancel) {
            Text("Cancel")
        }
    }
}

@Composable
private fun PermissionDeniedContent(
    onRetry: () -> Unit,
    onCancel: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Microphone Permission Required",
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.onSurface
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Please grant microphone permission to record audio.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(modifier = Modifier.height(32.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            Button(onClick = onCancel) {
                Text("Cancel")
            }
            Button(onClick = onRetry) {
                Text("Grant Permission")
            }
        }
    }
}

@Composable
private fun ErrorCard(
    error: RecorderError,
    onDismiss: () -> Unit,
    onRetry: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.errorContainer
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = error.message,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onErrorContainer
            )
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                TextButton(onClick = onDismiss) {
                    Text("Dismiss")
                }
                if (error !is RecorderError.MaxDurationReached) {
                    TextButton(onClick = onRetry) {
                        Text("Retry")
                    }
                }
            }
        }
    }
}
