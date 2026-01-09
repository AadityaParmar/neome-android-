package com.neome.feature.componentshowcase.presentation.searchlocation

import com.neome.feature.location.domain.model.PlaceDetail
import com.neome.feature.location.domain.model.SearchPlace

/**
 * UI State for Search Location screen (MVI pattern)
 * Manages search query, suggestions, and selected place
 */
data class SearchLocationState(
    val searchQuery: String = "",
    val searchSuggestions: List<SearchPlace> = emptyList(),
    val selectedPlace: PlaceDetail? = null,
    val isSearching: Boolean = false,
    val isLoadingDetails: Boolean = false,
    val error: String? = null,
    val showSuggestions: Boolean = false
)