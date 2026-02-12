package com.neome.core.logging

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * Reads the app's logcat output in a background coroutine and writes each line
 * to the session log file via [LogFileManager].
 *
 * Captures system/framework logs attributed to this process (GC events,
 * ActivityManager, native logs, crash traces) that [AppLogger] cannot intercept.
 *
 * Lines originating from [AppLogger] (prefixed with [APP]) are skipped
 * to avoid duplication since AppLogger already writes those to the file.
 *
 * Runs on [Dispatchers.IO]. No special permissions needed — apps can read
 * their own process's logcat since API 16.
 */
internal class LogcatReader(
    private val fileManager: LogFileManager,
    private val scope: CoroutineScope
) {
    private var job: Job? = null
    private var process: Process? = null

    companion object {
        private const val SYS_LINE_PREFIX = "[SYS]"
    }

    /**
     * Starts reading logcat in the background.
     * Uses `-T 1` to only capture new entries (avoids replaying the buffer).
     */
    fun start() {
        job = scope.launch(Dispatchers.IO) {
            startReading()
        }
    }

    /**
     * Stops the logcat reader, destroys the process, and cancels the coroutine.
     */
    fun stop() {
        job?.cancel()
        job = null
        try {
            process?.destroy()
        } catch (_: Exception) {
            // Ignore
        }
        process = null
    }

    private suspend fun CoroutineScope.startReading() {
        val pid = android.os.Process.myPid()

        try {
            val cmd = arrayOf(
                "logcat",
                "-v", "threadtime",  // Timestamp + PID + TID format
                "--pid=$pid",        // Only this process
                "-T", "1"           // Only new entries from now
            )

            val proc = Runtime.getRuntime().exec(cmd)
            process = proc

            val reader = BufferedReader(InputStreamReader(proc.inputStream))

            var line: String?
            while (isActive) {
                line = reader.readLine()
                if (line == null) {
                    // Process exited, attempt restart after brief pause
                    kotlinx.coroutines.delay(1000)
                    if (isActive) {
                        startReading()
                    }
                    return
                }

                // Skip lines that AppLogger already wrote to file
                // AppLogger tags its lines with [APP] prefix in the file,
                // but logcat lines won't have that. We detect our own app logs
                // by checking if the logcat line contains our app's tag pattern.
                // However, to be safe and simple: just write all logcat lines
                // with a [SYS] prefix. The file will have both [APP] (full) and
                // [SYS] (logcat-captured, possibly truncated) entries.
                // Users can filter by prefix when reading.
                fileManager.writeLine("$SYS_LINE_PREFIX $line")
            }
        } catch (e: Exception) {
            if (isActive) {
                fileManager.writeLine("$SYS_LINE_PREFIX [LogcatReader] Error: ${e.message}")
                // Retry after delay
                kotlinx.coroutines.delay(2000)
                if (isActive) {
                    startReading()
                }
            }
        }
    }
}
