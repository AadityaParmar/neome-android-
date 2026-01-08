package com.neome.feature.utils

import java.io.ByteArrayOutputStream

/**
 * Result of audio encoding.
 *
 * @property data The encoded audio data
 * @property durationMs Duration of the audio in milliseconds
 * @property sampleRate Sample rate used for encoding
 * @property mimeType MIME type of the encoded audio
 */
data class EncodingResult(
    val data: ByteArray,
    val durationMs: Long,
    val sampleRate: Int,
    val mimeType: String
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as EncodingResult
        return data.contentEquals(other.data) &&
                durationMs == other.durationMs &&
                sampleRate == other.sampleRate &&
                mimeType == other.mimeType
    }

    override fun hashCode(): Int {
        var result = data.contentHashCode()
        result = 31 * result + durationMs.hashCode()
        result = 31 * result + sampleRate
        result = 31 * result + mimeType.hashCode()
        return result
    }
}

/**
 * Sealed class representing audio encoding outcomes.
 */
sealed class EncodingOutcome {
    data class Success(val result: EncodingResult) : EncodingOutcome()
    data class Error(val message: String) : EncodingOutcome()
}

/**
 * Stateless audio encoding utility.
 *
 * Encodes raw PCM audio data to WAV format which is natively supported by Android.
 * WAV format doesn't require external libraries and can be played by ExoPlayer.
 *
 * Note: For MP3 encoding, add a LAME library dependency and modify this encoder.
 * Recommended library: Add to JitPack and use com.github.nickartyom:lame-android-jni
 *
 * Usage:
 * ```
 * val outcome = AudioEncoder.encodeToWav(
 *     pcmData = recordedPcmBytes,
 *     sampleRate = 44100,
 *     channels = 1,
 *     bitsPerSample = 16
 * )
 * when (outcome) {
 *     is EncodingOutcome.Success -> // use outcome.result.data
 *     is EncodingOutcome.Error -> // handle error
 * }
 * ```
 */
object AudioEncoder {

    private const val WAV_HEADER_SIZE = 44

    /**
     * Encodes raw PCM audio data to WAV format.
     *
     * @param pcmData Raw PCM audio data (16-bit signed, little-endian)
     * @param sampleRate Sample rate in Hz (e.g., 44100)
     * @param channels Number of channels (1 = mono, 2 = stereo)
     * @param bitsPerSample Bits per sample (typically 16)
     * @return EncodingOutcome containing either the encoded WAV data or an error
     */
    fun encodeToWav(
        pcmData: ByteArray,
        sampleRate: Int = 44100,
        channels: Int = 1,
        bitsPerSample: Int = 16
    ): EncodingOutcome {
        if (pcmData.isEmpty()) {
            return EncodingOutcome.Error("No audio data to encode")
        }

        return try {
            val wavData = createWavFile(pcmData, sampleRate, channels, bitsPerSample)

            // Calculate duration from PCM data
            val bytesPerSample = bitsPerSample / 8
            val totalSamples = pcmData.size / (channels * bytesPerSample)
            val durationMs = (totalSamples * 1000L) / sampleRate

            EncodingOutcome.Success(
                EncodingResult(
                    data = wavData,
                    durationMs = durationMs,
                    sampleRate = sampleRate,
                    mimeType = "audio/wav"
                )
            )
        } catch (e: Exception) {
            EncodingOutcome.Error("WAV encoding failed: ${e.message ?: "Unknown error"}")
        }
    }

    /**
     * Creates a WAV file from PCM data.
     */
    private fun createWavFile(
        pcmData: ByteArray,
        sampleRate: Int,
        channels: Int,
        bitsPerSample: Int
    ): ByteArray {
        val output = ByteArrayOutputStream()

        val byteRate = sampleRate * channels * bitsPerSample / 8
        val blockAlign = channels * bitsPerSample / 8
        val dataSize = pcmData.size
        val fileSize = dataSize + WAV_HEADER_SIZE - 8

        // RIFF header
        output.write("RIFF".toByteArray())
        output.write(intToByteArrayLE(fileSize))
        output.write("WAVE".toByteArray())

        // fmt subchunk
        output.write("fmt ".toByteArray())
        output.write(intToByteArrayLE(16)) // Subchunk1Size (16 for PCM)
        output.write(shortToByteArrayLE(1)) // AudioFormat (1 = PCM)
        output.write(shortToByteArrayLE(channels.toShort()))
        output.write(intToByteArrayLE(sampleRate))
        output.write(intToByteArrayLE(byteRate))
        output.write(shortToByteArrayLE(blockAlign.toShort()))
        output.write(shortToByteArrayLE(bitsPerSample.toShort()))

        // data subchunk
        output.write("data".toByteArray())
        output.write(intToByteArrayLE(dataSize))
        output.write(pcmData)

        return output.toByteArray()
    }

    /**
     * Converts an integer to a 4-byte little-endian array.
     */
    private fun intToByteArrayLE(value: Int): ByteArray {
        return byteArrayOf(
            (value and 0xFF).toByte(),
            ((value shr 8) and 0xFF).toByte(),
            ((value shr 16) and 0xFF).toByte(),
            ((value shr 24) and 0xFF).toByte()
        )
    }

    /**
     * Converts a short to a 2-byte little-endian array.
     */
    private fun shortToByteArrayLE(value: Short): ByteArray {
        return byteArrayOf(
            (value.toInt() and 0xFF).toByte(),
            ((value.toInt() shr 8) and 0xFF).toByte()
        )
    }
}
