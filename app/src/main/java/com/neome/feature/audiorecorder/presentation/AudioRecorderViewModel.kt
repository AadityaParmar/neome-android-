package com.neome.feature.audiorecorder.presentation

import android.media.AudioFormat
import android.media.AudioRecord
import android.media.MediaRecorder
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.neome.feature.audiorecorder.domain.model.RecordedAudio
import com.neome.feature.audiorecorder.domain.model.RecorderError
import com.neome.feature.audiorecorder.domain.model.RecordingConfig
import com.neome.feature.utils.AudioEncoder
import com.neome.feature.utils.EncodingOutcome
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.ByteArrayOutputStream
import kotlin.math.sqrt

/**
 * ViewModel for audio recording with WAV output.
 * Manages AudioRecord lifecycle and encoding using MVI pattern.
 */
class AudioRecorderViewModel : ViewModel() {

    private val _state = MutableStateFlow(AudioRecorderState())
    val state = _state.asStateFlow()

    private val _effect = Channel<AudioRecorderEffect>()
    val effect = _effect.receiveAsFlow()

    private var audioRecord: AudioRecord? = null
    private var recordingJob: Job? = null
    private var timerJob: Job? = null
    private val pcmBuffer = ByteArrayOutputStream()
    private var recordingStartTime = 0L
    private var pausedDuration = 0L
    private var pauseStartTime = 0L

    /**
     * Single entry point for all user actions.
     */
    fun onEvent(event: AudioRecorderEvent) {
        when (event) {
            is AudioRecorderEvent.StartRecording -> startRecording()
            is AudioRecorderEvent.PauseRecording -> pauseRecording()
            is AudioRecorderEvent.ResumeRecording -> resumeRecording()
            is AudioRecorderEvent.StopRecording -> stopRecording()
            is AudioRecorderEvent.CancelRecording -> cancelRecording()
            is AudioRecorderEvent.RequestPermission -> requestPermission()
            is AudioRecorderEvent.PermissionGranted -> onPermissionGranted()
            is AudioRecorderEvent.PermissionDenied -> onPermissionDenied()
            is AudioRecorderEvent.ClearError -> clearError()
            is AudioRecorderEvent.RetryRecording -> retryRecording()
        }
    }

    /**
     * Initialize with custom config.
     */
    fun initialize(config: RecordingConfig = RecordingConfig()) {
        _state.update { it.copy(config = config) }
    }

    private fun startRecording() {
        if (!_state.value.hasPermission) {
            requestPermission()
            return
        }

        viewModelScope.launch(Dispatchers.IO) {
            try {
                initializeAudioRecord()
                audioRecord?.startRecording()
                recordingStartTime = System.currentTimeMillis()
                pausedDuration = 0L
                pcmBuffer.reset()

                _state.update { it.copy(status = RecordingStatus.RECORDING, error = null) }

                startTimerUpdates()
                startAudioCapture()
            } catch (e: SecurityException) {
                _state.update {
                    it.copy(
                        status = RecordingStatus.IDLE,
                        error = RecorderError.PermissionDenied()
                    )
                }
            } catch (e: Exception) {
                _state.update {
                    it.copy(
                        status = RecordingStatus.IDLE,
                        error = RecorderError.InitializationFailed(
                            e.message ?: "Failed to initialize recorder"
                        )
                    )
                }
            }
        }
    }

    private fun initializeAudioRecord() {
        val config = _state.value.config
        val channelConfig = if (config.channels == 1)
            AudioFormat.CHANNEL_IN_MONO
        else
            AudioFormat.CHANNEL_IN_STEREO

        val minBufferSize = AudioRecord.getMinBufferSize(
            config.sampleRate,
            channelConfig,
            AudioFormat.ENCODING_PCM_16BIT
        )

        if (minBufferSize == AudioRecord.ERROR || minBufferSize == AudioRecord.ERROR_BAD_VALUE) {
            throw IllegalStateException("Invalid AudioRecord buffer size")
        }

        audioRecord = AudioRecord(
            MediaRecorder.AudioSource.MIC,
            config.sampleRate,
            channelConfig,
            AudioFormat.ENCODING_PCM_16BIT,
            minBufferSize * 2
        )

        if (audioRecord?.state != AudioRecord.STATE_INITIALIZED) {
            audioRecord?.release()
            audioRecord = null
            throw IllegalStateException("AudioRecord initialization failed")
        }
    }

    private fun startAudioCapture() {
        recordingJob = viewModelScope.launch(Dispatchers.IO) {
            val bufferSize = 4096
            val buffer = ShortArray(bufferSize)
            val amplitudeHistory = mutableListOf<Float>()

            while (isActive && _state.value.status == RecordingStatus.RECORDING) {
                val read = audioRecord?.read(buffer, 0, bufferSize) ?: 0
                if (read > 0) {
                    // Store PCM data as bytes
                    val byteBuffer = ByteArray(read * 2)
                    for (i in 0 until read) {
                        byteBuffer[i * 2] = (buffer[i].toInt() and 0xFF).toByte()
                        byteBuffer[i * 2 + 1] = (buffer[i].toInt() shr 8).toByte()
                    }
                    synchronized(pcmBuffer) {
                        pcmBuffer.write(byteBuffer)
                    }

                    // Calculate amplitude for visualization
                    val amplitude = calculateAmplitude(buffer, read)
                    amplitudeHistory.add(amplitude)
                    if (amplitudeHistory.size > 50) {
                        amplitudeHistory.removeAt(0)
                    }

                    _state.update { it.copy(amplitudes = amplitudeHistory.toList()) }
                }

                // Check max duration
                val currentDuration = _state.value.elapsedTimeMs
                if (currentDuration >= _state.value.config.maxDurationMs) {
                    withContext(Dispatchers.Main) {
                        _state.update {
                            it.copy(error = RecorderError.MaxDurationReached())
                        }
                        stopRecording()
                    }
                    break
                }
            }
        }
    }

    private fun calculateAmplitude(buffer: ShortArray, size: Int): Float {
        var sum = 0.0
        for (i in 0 until size) {
            sum += buffer[i].toDouble() * buffer[i].toDouble()
        }
        val rms = sqrt(sum / size)
        return (rms / Short.MAX_VALUE).toFloat().coerceIn(0f, 1f)
    }

    private fun startTimerUpdates() {
        timerJob = viewModelScope.launch {
            while (_state.value.status == RecordingStatus.RECORDING) {
                val elapsed = System.currentTimeMillis() - recordingStartTime - pausedDuration
                _state.update { it.copy(elapsedTimeMs = elapsed) }
                delay(100)
            }
        }
    }

    private fun pauseRecording() {
        recordingJob?.cancel()
        timerJob?.cancel()
        audioRecord?.stop()
        pauseStartTime = System.currentTimeMillis()
        _state.update { it.copy(status = RecordingStatus.PAUSED) }
    }

    private fun resumeRecording() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                pausedDuration += System.currentTimeMillis() - pauseStartTime
                audioRecord?.startRecording()
                _state.update { it.copy(status = RecordingStatus.RECORDING) }
                startTimerUpdates()
                startAudioCapture()
            } catch (e: Exception) {
                _state.update {
                    it.copy(
                        error = RecorderError.RecordingFailed(
                            e.message ?: "Failed to resume recording"
                        )
                    )
                }
            }
        }
    }

    private fun stopRecording() {
        viewModelScope.launch {
            recordingJob?.cancel()
            timerJob?.cancel()

            try {
                audioRecord?.stop()
            } catch (e: Exception) {
                // Ignore stop errors
            }

            _state.update { it.copy(status = RecordingStatus.PROCESSING) }

            try {
                val recordedAudio = withContext(Dispatchers.IO) {
                    encodeToWav()
                }
                _effect.send(AudioRecorderEffect.RecordingComplete(recordedAudio))
                resetRecorder()
            } catch (e: Exception) {
                _state.update {
                    it.copy(
                        status = RecordingStatus.IDLE,
                        error = RecorderError.EncodingFailed(
                            e.message ?: "Failed to encode audio"
                        )
                    )
                }
                _effect.send(AudioRecorderEffect.Error(e.message ?: "Encoding failed"))
            }
        }
    }

    private fun encodeToWav(): RecordedAudio {
        val pcmData: ByteArray
        synchronized(pcmBuffer) {
            pcmData = pcmBuffer.toByteArray()
        }

        if (pcmData.isEmpty()) {
            throw IllegalStateException("No audio data recorded")
        }

        val config = _state.value.config
        val durationMs = _state.value.elapsedTimeMs

        val outcome = AudioEncoder.encodeToWav(
            pcmData = pcmData,
            sampleRate = config.sampleRate,
            channels = config.channels,
            bitsPerSample = config.bitsPerSample
        )

        return when (outcome) {
            is EncodingOutcome.Success -> RecordedAudio(
                bytes = outcome.result.data,
                durationMs = durationMs,
                sampleRate = config.sampleRate,
                channels = config.channels,
                bitsPerSample = config.bitsPerSample
            )
            is EncodingOutcome.Error -> throw Exception(outcome.message)
        }
    }

    private fun cancelRecording() {
        viewModelScope.launch {
            recordingJob?.cancel()
            timerJob?.cancel()
            releaseAudioRecord()
            resetRecorder()
            _effect.send(AudioRecorderEffect.Cancelled)
        }
    }

    private fun requestPermission() {
        viewModelScope.launch {
            _effect.send(AudioRecorderEffect.RequestMicrophonePermission)
        }
    }

    private fun onPermissionGranted() {
        _state.update { it.copy(hasPermission = true, error = null) }
    }

    private fun onPermissionDenied() {
        _state.update {
            it.copy(
                hasPermission = false,
                error = RecorderError.PermissionDenied()
            )
        }
    }

    private fun clearError() {
        _state.update { it.copy(error = null) }
    }

    private fun retryRecording() {
        clearError()
        startRecording()
    }

    private fun resetRecorder() {
        releaseAudioRecord()
        synchronized(pcmBuffer) {
            pcmBuffer.reset()
        }
        _state.update {
            it.copy(
                status = RecordingStatus.IDLE,
                elapsedTimeMs = 0L,
                amplitudes = emptyList(),
                error = null
            )
        }
    }

    private fun releaseAudioRecord() {
        try {
            audioRecord?.stop()
        } catch (e: Exception) {
            // Ignore
        }
        try {
            audioRecord?.release()
        } catch (e: Exception) {
            // Ignore
        }
        audioRecord = null
    }

    override fun onCleared() {
        super.onCleared()
        recordingJob?.cancel()
        timerJob?.cancel()
        releaseAudioRecord()
    }
}
