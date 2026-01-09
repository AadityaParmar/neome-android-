package com.neome.feature.componentshowcase.presentation.searchlocation

/**
 * User events for Search Location screen (MVI pattern)
 */
sealed interface SearchLocationEvent {
    data class SearchQueryChanged(val query: String) : SearchLocationEvent
    data class PlaceSelected(val placeId: String) : SearchLocationEvent
    data object ClearSearch : SearchLocationEvent
    data object DismissSuggestions : SearchLocationEvent
}