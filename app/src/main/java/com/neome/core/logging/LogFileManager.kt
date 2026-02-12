package com.neome.core.logging

import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * Manages log file lifecycle: creation, writing, and session cleanup.
 *
 * Each app launch creates a new session log file under [logsDir]/logs/.
 * Old session files beyond [maxSessions] are automatically deleted on init.
 *
 * Thread-safe: all writes are synchronized on an internal lock.
 */
internal class LogFileManager(
    private val logsDir: File,
    private val maxSessions: Int = 5
) {
    private val lock = Any()
    private var writer: BufferedWriter? = null
    private var currentFile: File? = null
    private var closed = false

    private val fileTimestampFormat = SimpleDateFormat("yyyy-MM-dd_HH-mm-ss", Locale.US)
    private val lineTimestampFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US)

    /**
     * Initializes the log file manager:
     * 1. Creates the logs directory if needed
     * 2. Cleans up old session files
     * 3. Opens a new session file for writing
     */
    fun init() {
        synchronized(lock) {
            logsDir.mkdirs()
            cleanupOldSessions()
            openNewSession()
        }
    }

    /**
     * Writes a pre-formatted line to the current log file.
     * Appends a newline automatically.
     */
    fun writeLine(line: String) {
        synchronized(lock) {
            if (closed) return
            try {
                writer?.apply {
                    write(line)
                    newLine()
                    flush()
                }
            } catch (e: Exception) {
                // Silently ignore write failures to avoid recursive logging
            }
        }
    }

    /**
     * Formats a timestamp for log line prefixing.
     */
    fun formatTimestamp(timeMillis: Long = System.currentTimeMillis()): String {
        return lineTimestampFormat.format(Date(timeMillis))
    }

    /**
     * Returns the current session log file, or null if not initialized.
     */
    fun getCurrentFile(): File? = synchronized(lock) { currentFile }

    /**
     * Closes the writer and releases resources.
     */
    fun close() {
        synchronized(lock) {
            closed = true
            try {
                writer?.flush()
                writer?.close()
            } catch (_: Exception) {
                // Ignore
            }
            writer = null
        }
    }

    private fun openNewSession() {
        val timestamp = fileTimestampFormat.format(Date())
        val file = File(logsDir, "log_$timestamp.txt")
        currentFile = file
        writer = BufferedWriter(FileWriter(file, true))

        // Write session header
        val header = buildString {
            appendLine("========================================")
            appendLine("  Session started: ${lineTimestampFormat.format(Date())}")
            appendLine("  PID: ${android.os.Process.myPid()}")
            appendLine("========================================")
        }
        writer?.write(header)
        writer?.flush()
    }

    private fun cleanupOldSessions() {
        val logFiles = logsDir.listFiles { file ->
            file.isFile && file.name.startsWith("log_") && file.name.endsWith(".txt")
        }?.sortedByDescending { it.lastModified() } ?: return

        if (logFiles.size >= maxSessions) {
            // Keep (maxSessions - 1) since we're about to create a new one
            logFiles.drop(maxSessions - 1).forEach { file ->
                file.delete()
            }
        }
    }
}
