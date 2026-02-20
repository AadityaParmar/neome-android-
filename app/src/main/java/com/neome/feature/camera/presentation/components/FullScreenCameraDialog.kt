package com.neome.feature.camera.presentation.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

/**
 * Full-screen dialog wrapper for camera capture.
 *
 * Provides a full-screen surface with standard dialog properties
 * suitable for hosting a camera capture screen.
 *
 * @param onDismiss Callback when the dialog is dismissed (back press)
 * @param content The composable content to display (e.g., CameraCaptureScreen)
 */
@Composable
fun FullScreenCameraDialog(
    onDismiss: () -> Unit,
    content: @Composable () -> Unit
) {
    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = false,
            usePlatformDefaultWidth = false
        )
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            content()
        }
    }
}
