package com.neome.feature.componentshowcase.presentation.location

import com.neome.feature.location.domain.model.Location

/**
 * UI State for Location showcase
 * Immutable data class following MVI pattern
 */
data class LocationState(
    val location: Location? = null,
    val isLoading: Boolean = false,
    val error: String? = null,
    val permissionGranted: Boolean = false
)