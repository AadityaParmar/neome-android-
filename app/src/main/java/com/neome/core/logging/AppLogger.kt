package com.neome.core.logging

import android.util.Log
import java.io.PrintWriter
import java.io.StringWriter

/**
 * Application-wide logger that writes full untruncated messages to a session log file
 * and forwards them to Android's logcat (where they may be truncated at ~4KB).
 *
 * Usage:
 * ```
 * AppLogger.d("MyTag", "Some debug message")
 * AppLogger.e("MyTag", "Error occurred", exception)
 * ```
 *
 * Must be initialized via [LoggingInitializer.init] before use.
 * Calls before initialization are forwarded to logcat only.
 */
object AppLogger {

    private const val MAX_LOGCAT_LENGTH = 4000
    internal const val APP_LINE_PREFIX = "[APP]"

    @Volatile
    internal var fileManager: LogFileManager? = null

    // region --- Public API ---

    fun v(tag: String, msg: String, tr: Throwable? = null) {
        log(Log.VERBOSE, tag, msg, tr)
    }

    fun d(tag: String, msg: String, tr: Throwable? = null) {
        log(Log.DEBUG, tag, msg, tr)
    }

    fun i(tag: String, msg: String, tr: Throwable? = null) {
        log(Log.INFO, tag, msg, tr)
    }

    fun w(tag: String, msg: String, tr: Throwable? = null) {
        log(Log.WARN, tag, msg, tr)
    }

    fun e(tag: String, msg: String, tr: Throwable? = null) {
        log(Log.ERROR, tag, msg, tr)
    }

    fun wtf(tag: String, msg: String, tr: Throwable? = null) {
        log(Log.ASSERT, tag, msg, tr)
    }

    // endregion

    // region --- Internal ---

    private fun log(priority: Int, tag: String, msg: String, tr: Throwable?) {
        // 1. Write full untruncated message to file
        writeToFile(priority, tag, msg, tr)

        // 2. Forward to logcat (chunked if message exceeds limit)
        forwardToLogcat(priority, tag, msg, tr)
    }

    private fun writeToFile(priority: Int, tag: String, msg: String, tr: Throwable?) {
        val fm = fileManager ?: return

        val timestamp = fm.formatTimestamp()
        val pid = android.os.Process.myPid()
        val tid = Thread.currentThread().id
        val priorityChar = priorityToChar(priority)

        val line = "$APP_LINE_PREFIX $timestamp $pid-$tid/$priorityChar/$tag: $msg"
        fm.writeLine(line)

        // Write full stack trace if throwable is present
        if (tr != null) {
            val sw = StringWriter()
            tr.printStackTrace(PrintWriter(sw))
            sw.toString().lines().forEach { traceLine ->
                fm.writeLine("$APP_LINE_PREFIX $timestamp $pid-$tid/$priorityChar/$tag:   $traceLine")
            }
        }
    }

    /**
     * Forwards message to Android logcat. If the message exceeds logcat's ~4KB limit,
     * it is split into chunks to avoid truncation in logcat output.
     * (The full message is already written to file untruncated.)
     */
    private fun forwardToLogcat(priority: Int, tag: String, msg: String, tr: Throwable?) {
        if (msg.length <= MAX_LOGCAT_LENGTH) {
            if (tr != null) {
                Log.println(priority, tag, msg + "\n" + Log.getStackTraceString(tr))
            } else {
                Log.println(priority, tag, msg)
            }
            return
        }

        // Chunk the message for logcat
        var offset = 0
        var chunkIndex = 0
        while (offset < msg.length) {
            val end = (offset + MAX_LOGCAT_LENGTH).coerceAtMost(msg.length)
            val chunk = msg.substring(offset, end)
            val prefix = if (chunkIndex > 0) "(cont.) " else ""
            Log.println(priority, tag, "$prefix$chunk")
            offset = end
            chunkIndex++
        }

        // Log throwable separately if present
        if (tr != null) {
            Log.println(priority, tag, Log.getStackTraceString(tr))
        }
    }

    private fun priorityToChar(priority: Int): Char {
        return when (priority) {
            Log.VERBOSE -> 'V'
            Log.DEBUG -> 'D'
            Log.INFO -> 'I'
            Log.WARN -> 'W'
            Log.ERROR -> 'E'
            Log.ASSERT -> 'A'
            else -> '?'
        }
    }

    // endregion
}
