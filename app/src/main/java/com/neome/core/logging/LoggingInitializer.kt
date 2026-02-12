package com.neome.core.logging

import android.content.Context
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import java.io.File

/**
 * Initializes the file-based logging system.
 *
 * Call [init] once from [android.app.Application.onCreate].
 * Call [shutdown] from [android.app.Application.onTerminate] or when the app is closing
 * (though onTerminate is not guaranteed on real devices).
 *
 * After initialization:
 * - [AppLogger] writes full untruncated messages to the session log file
 * - [LogcatReader] captures system/framework logs for this process
 * - Both write to the same file under `filesDir/logs/`
 *
 * Log files are session-based (one per app launch) with automatic cleanup
 * of old sessions beyond the retention limit.
 */
object LoggingInitializer {

    private var fileManager: LogFileManager? = null
    private var logcatReader: LogcatReader? = null
    private val loggingScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    /**
     * Initializes the logging system. Safe to call multiple times (subsequent calls are no-ops).
     *
     * @param context Application context, used to resolve filesDir for log storage.
     * @param maxSessions Maximum number of session log files to retain (default: 5).
     */
    fun init(context: Context, maxSessions: Int = 5) {
        if (fileManager != null) return // Already initialized

        val logsDir = File(context.filesDir, "logs")
        val fm = LogFileManager(logsDir, maxSessions)
        fm.init()
        fileManager = fm

        // Wire up AppLogger to write to this file manager
        AppLogger.fileManager = fm

        // Start logcat reader for system/framework logs
        val reader = LogcatReader(fm, loggingScope)
        reader.start()
        logcatReader = reader

        AppLogger.i("LoggingInitializer", "Logging system initialized. Log file: ${fm.getCurrentFile()?.absolutePath}")
    }

    /**
     * Shuts down the logging system, stopping the logcat reader and closing the file.
     */
    fun shutdown() {
        AppLogger.i("LoggingInitializer", "Logging system shutting down.")
        logcatReader?.stop()
        logcatReader = null
        AppLogger.fileManager = null
        fileManager?.close()
        fileManager = null
    }
}
