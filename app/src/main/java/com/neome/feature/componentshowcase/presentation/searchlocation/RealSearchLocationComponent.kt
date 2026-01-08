package com.neome.feature.componentshowcase.presentation.searchlocation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RealSearchLocationComponent(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        // Top Component - Fixed  50dp height with bottom border
        SearchBarComponent(modifier = Modifier.fillMaxWidth().height(50.dp))
        HorizontalDivider(thickness = 1.dp)

        // Middle Component - 40% of remaining height with bottom border
        GoogleMapComponent(
            modifier = Modifier.fillMaxWidth().weight(0.4f))
        HorizontalDivider(thickness = 1.dp)

        // Bottom Component - 60% of remaining height (no border)
        NearByPlacesComponent(
            modifier = Modifier.fillMaxWidth().weight(0.6f))
    }
}

@Composable
private fun SearchBarComponent(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Search Component (30dp)",
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Composable
private fun GoogleMapComponent(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Google map Component (40%)",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
private fun NearByPlacesComponent(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Near by places Component (60%)",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}