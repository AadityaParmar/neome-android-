package com.neome.feature.componentshowcase.presentation.components

import android.Manifest
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.MyLocation
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.neome.feature.componentshowcase.presentation.location.LocationEvent
import com.neome.feature.componentshowcase.presentation.location.LocationState
import com.neome.feature.componentshowcase.presentation.location.LocationViewModel
import kotlinx.coroutines.delay

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun LocationShowcase(
    modifier: Modifier = Modifier,
    viewModel: LocationViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    // Handle location permissions
    val locationPermissionsState = rememberMultiplePermissionsState(
        listOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )
    )

    // Update permission state in ViewModel
    LaunchedEffect(locationPermissionsState.allPermissionsGranted) {
        viewModel.onEvent(LocationEvent.PermissionResult(locationPermissionsState.allPermissionsGranted))
    }

    LocationShowcaseContent(
        state = state,
        onEvent = viewModel::onEvent,
        onRequestPermission = { locationPermissionsState.launchMultiplePermissionRequest() },
        permissionGranted = locationPermissionsState.allPermissionsGranted,
        modifier = modifier
    )
}

@Composable
private fun LocationShowcaseContent(
    state: LocationState,
    onEvent: (LocationEvent) -> Unit,
    onRequestPermission: () -> Unit,
    permissionGranted: Boolean,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Location Services", style = MaterialTheme.typography.headlineSmall)

        // Current Location Card
        OutlinedCard(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Icon(
                        Icons.Default.MyLocation,
                        contentDescription = "Current Location",
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        "Current Location",
                        style = MaterialTheme.typography.titleMedium
                    )
                }

                HorizontalDivider()

                // Loading indicator
                if (state.isLoading) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 16.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        CircularProgressIndicator(modifier = Modifier.size(24.dp))
                        Spacer(modifier = Modifier.padding(8.dp))
                        Text(
                            "Fetching location...",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }

                // Location data
                if (state.location != null && !state.isLoading) {
                    LocationInfoRow("Latitude", state.location.geoPoint.lat.toString())
                    LocationInfoRow("Longitude", state.location.geoPoint.lng.toString())

                    if (state.location.dateTime != null) {
                        LocationInfoRow("DateTime", state.location.dateTime)
                    }

                    if (state.location.address != null) {
                        Text(
                            state.location.address,
                            style = MaterialTheme.typography.bodyMedium
                        )

                        if (state.location.city != null) {
                            LocationInfoRow("City", state.location.city)
                        }
                        if (state.location.country != null) {
                            LocationInfoRow("Country", state.location.country)
                        }
                    }
                }

                // No location message
                if (state.location == null && !state.isLoading && state.error == null) {
                    Text(
                        "No location data available",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }

        // Error Card
        if (state.error != null) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.errorContainer
                )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        "Error",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onErrorContainer
                    )
                    Text(
                        state.error,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onErrorContainer
                    )
                }
            }
        }

        // Permission Request Card
        if (!permissionGranted) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.secondaryContainer
                )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        "Permission Required",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )
                    Text(
                        "Location permission is required to get your current location.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )
                    Button(
                        onClick = onRequestPermission,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Grant Permission")
                    }
                }
            }
        }

        // Action Buttons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = { onEvent(LocationEvent.GetLocation) },
                modifier = Modifier.weight(1f),
                enabled = !state.isLoading && permissionGranted
            ) {
                Icon(Icons.Default.LocationOn, contentDescription = null)
                Spacer(modifier = Modifier.padding(4.dp))
                Text(if (state.isLoading) "Loading..." else "Get Location")
            }

            FilledTonalButton(
                onClick = { onEvent(LocationEvent.ClearLocation) },
                modifier = Modifier.weight(1f),
                enabled = state.location != null && !state.isLoading
            ) {
                Text("Clear")
            }
        }

        HorizontalDivider()

        // Auto-load Location Card
        AutoLoadLocationCard(
            state = state,
            onEvent = onEvent,
            permissionGranted = permissionGranted
        )
    }
}

@Composable
private fun AutoLoadLocationCard(
    state: LocationState,
    onEvent: (LocationEvent) -> Unit,
    permissionGranted: Boolean
) {
    var countdown by remember { mutableIntStateOf(5) }
    var hasTriggered by remember { mutableIntStateOf(0) }

    // 5-second countdown timer
    LaunchedEffect(permissionGranted) {
        if (permissionGranted && hasTriggered == 0) {
            while (countdown > 0) {
                delay(1000)
                countdown--
            }
            // Trigger auto-load location fetch after 5 seconds
            onEvent(LocationEvent.GetAutoLoadLocation)
            hasTriggered = 1
        }
    }

    Card(
                modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                "On Load Capture Location",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onTertiaryContainer
            )

            HorizontalDivider()

            // Countdown or address display
            if (countdown > 0 && hasTriggered == 0 && permissionGranted) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(20.dp),
                        strokeWidth = 2.dp
                    )
                    Spacer(modifier = Modifier.padding(8.dp))
                    Text(
                        "Auto-loading in ${countdown}s...",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onTertiaryContainer
                    )
                }
            } else if (!permissionGranted) {
                Text(
                    "Waiting for location permission...",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onTertiaryContainer
                )
            } else if (state.autoLoadedLocation != null && state.autoLoadedLocation.address != null) {
                // Display auto-loaded address
                Text(
                    state.autoLoadedLocation.address,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onTertiaryContainer
                )
            } else if (state.isAutoLoading) {
                Text(
                    "Loading location...",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onTertiaryContainer
                )
            } else if (state.autoLoadError != null) {
                Text(
                    "Error: ${state.autoLoadError}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onTertiaryContainer
                )
            } else {
                Text(
                    "No address available",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onTertiaryContainer
                )
            }
        }
    }
}

@Composable
private fun LocationInfoRow(
    label: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            label,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Text(
            value,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}