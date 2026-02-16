package com.neome.feature.form.presentation.components.field

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.neome.api.meta.base.Types.EnumDefnCaptureValueKind
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueEntUserIdData
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueLocationData

/**
 * UI-specific status for location capture progress.
 * Only location has multi-step fetching (lat/lng → address via Google API).
 */
enum class CaptureLocationStatus {
    GettingLatLng,
    GettingAddress
}

/**
 * Reusable component that displays capture metadata rows (time, user, location)
 * below a field's primary UI.
 *
 * Designed to be shared across any field type that supports capture properties
 * (Switch, Voice, Signature, ScanCode, Camera, Location, etc.).
 *
 * Each enabled capture kind renders a row conditionally:
 * - If the kind is in [showCapturedValues]: always shown (key: status/value format).
 * - If not in [showCapturedValues]: shown only while capturing (status-only), hidden once value arrives.
 * - Error rows always shown with a retry button.
 *
 * @param captureTime Current captured time value (null = not yet captured)
 * @param captureUser Current captured user display string (null = not yet captured)
 * @param captureLocation Current captured location display string (null = not yet captured)
 * @param captureLocationError Error string for location capture (null = no error)
 * @param captureLocationStatus Current location fetching phase (null = idle/done)
 * @param showCapturedValues Which capture kinds to show persistently with key: value format
 * @param captureLocationLatLng Lat,lng string for "open in maps" button (null = not available)
 * @param onRetryLocation Callback when retry is tapped on location error row
 * @param onOpenLocationInMap Callback when "open in maps" is tapped on location row
 * @param modifier Modifier for customization
 */
@Composable
fun RawCaptureExtraProperties(
    captureTime: String?,
    captureUser: FieldValueEntUserIdData?,
    captureLocation: FieldValueLocationData?,
    captureLocationError: String?,
    captureLocationStatus: CaptureLocationStatus?,
    showCapturedValues: List<EnumDefnCaptureValueKind>?,
    captureLocationLatLng: String?,
    onRetryLocation: () -> Unit,
    onOpenLocationInMap: () -> Unit,
    modifier: Modifier = Modifier
) {
    val showSet = showCapturedValues?.toSet() ?: emptySet()

    // Determine which rows to render
    val timeRow = if (captureTime != null) {
        buildRowState(
            kind = EnumDefnCaptureValueKind.captureTime,
            value = captureTime,
            isInShowList = EnumDefnCaptureValueKind.captureTime in showSet,
            error = null,
            statusText = null,
            keyLabel = "Captured time"
        )
    } else null

    val userRow = if (captureUser != null) {
        buildRowState(
            kind = EnumDefnCaptureValueKind.captureUser,
            value = captureUser.displayField ?: captureUser.value.toString(),
            isInShowList = EnumDefnCaptureValueKind.captureUser in showSet,
            error = null,
            statusText = null,
            keyLabel = "Captured user"
        )
    } else null

    val locationRow = if (captureLocation != null) {
        // Location has specific status phases
        val locationStatusText = when (captureLocationStatus) {
            CaptureLocationStatus.GettingLatLng -> "Getting coordinates..."
            CaptureLocationStatus.GettingAddress -> "Getting address..."
            null -> "Capturing location..."
        }
        buildRowState(
            kind = EnumDefnCaptureValueKind.captureLocation,
            value = captureLocation.value.address ?: captureLocation.value.geoPoint.toString(),
            error = captureLocationError,
            isInShowList = EnumDefnCaptureValueKind.captureLocation in showSet,
            statusText = locationStatusText,
            keyLabel = "Captured location"
        )
    } else null

    val rows = showSet.mapNotNull { item ->
        when (item) {
            EnumDefnCaptureValueKind.captureTime -> timeRow
            EnumDefnCaptureValueKind.captureUser -> userRow
            EnumDefnCaptureValueKind.captureLocation -> locationRow
        }
    }

    if (rows.isEmpty()) return

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        rows.forEach { state ->
            if (state.shouldRender) {
                CaptureRow(
                    text = state.displayText,
                    isError = state.hasError,
                    showRetryButton = state.hasError,
                    showOpenMapButton = state.kind == EnumDefnCaptureValueKind.captureLocation
                        && captureLocationLatLng != null,
                    onRetry = when (state.kind) {
                        EnumDefnCaptureValueKind.captureTime -> null
                        EnumDefnCaptureValueKind.captureUser -> null
                        EnumDefnCaptureValueKind.captureLocation -> onRetryLocation
                    },
                    onOpenMap = onOpenLocationInMap
                )
            }
        }
    }
}

/**
 * Internal state holder for a single capture row's rendering decision.
 */
private data class CaptureRowState(
    val kind: EnumDefnCaptureValueKind,
    val shouldRender: Boolean,
    val displayText: String,
    val hasError: Boolean
)

/**
 * Determines whether a capture row should render and what text to display.
 *
 * Visibility rules:
 * - In showList + has value → render "Key: value"
 * - In showList + no value + has error → render "Key: errorText" (with retry)
 * - In showList + no value + no error → render "Key: statusText"
 * - Not in showList + capturing (no value, no error) → render statusText only (temporary)
 * - Not in showList + has value → don't render (disappear)
 * - Not in showList + has error → render errorText (with retry)
 */
private fun buildRowState(
    kind: EnumDefnCaptureValueKind,
    value: String?,
    error: String?,
    isInShowList: Boolean,
    statusText: String?,
    keyLabel: String?
): CaptureRowState {
    val hasValue = !value.isNullOrBlank()
    val hasError = !error.isNullOrBlank()
    val isCapturing = !hasValue && !hasError

    return if (isInShowList) {
        // Always render when in show list
        val text = when {
            hasError -> "$keyLabel: $error"
            hasValue -> "$keyLabel: $value"
            else -> "$keyLabel: $statusText"
        }

        CaptureRowState(
            kind = kind,
            shouldRender = true,
            displayText = text,
            hasError = hasError
        )
    } else {
        // Not in show list: transient status only
        when {
            isCapturing -> CaptureRowState(
                kind = kind,
                shouldRender = true,
                displayText = statusText ?: "",
                hasError = false
            )

            hasError -> CaptureRowState(
                kind = kind,
                shouldRender = true,
                displayText = error,
                hasError = true
            )

            else -> CaptureRowState(
                kind = kind,
                shouldRender = false,
                displayText = "",
                hasError = false
            )
        }
    }
}

/**
 * A single capture metadata row.
 *
 * Layout: [Text] [RetryButton?] [OpenMapButton?]
 */
@Composable
private fun CaptureRow(
    text: String,
    isError: Boolean,
    showRetryButton: Boolean,
    showOpenMapButton: Boolean,
    onRetry: (() -> Unit)?,
    onOpenMap: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelSmall,
            color = if (isError) {
                MaterialTheme.colorScheme.error
            } else {
                MaterialTheme.colorScheme.onSurfaceVariant
            },
            modifier = Modifier.weight(1f, fill = false)
        )

        if (showRetryButton) {
            Spacer(modifier = Modifier.width(4.dp))
            IconButton(
                onClick = onRetry ?: {},
                modifier = Modifier.size(20.dp)
            ) {
                Icon(
                    imageVector = Icons.Outlined.Refresh,
                    contentDescription = "Retry",
                    tint = MaterialTheme.colorScheme.error,
                    modifier = Modifier.size(14.dp)
                )
            }
        }

        if (showOpenMapButton) {
            Spacer(modifier = Modifier.width(4.dp))
            IconButton(
                onClick = onOpenMap,
                modifier = Modifier.size(20.dp)
            ) {
                Icon(
                    imageVector = Icons.Outlined.LocationOn,
                    contentDescription = "Open in Maps",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(14.dp)
                )
            }
        }
    }
}
