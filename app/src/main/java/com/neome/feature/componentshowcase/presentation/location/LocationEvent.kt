package com.neome.feature.componentshowcase.presentation.location

/**
 * User events for Location showcase
 * Sealed interface following MVI pattern
 */
sealed interface LocationEvent {
    data object GetLocation : LocationEvent
    data object ClearLocation : LocationEvent
    data class PermissionResult(val granted: Boolean) : LocationEvent
}