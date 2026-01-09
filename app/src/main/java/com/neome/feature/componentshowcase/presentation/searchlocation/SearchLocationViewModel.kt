package com.neome.feature.componentshowcase.presentation.searchlocation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.neome.core.common.Resource
import com.neome.feature.location.domain.usecase.GetPlaceDetailsUseCase
import com.neome.feature.location.domain.usecase.SearchPlacesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel for Search Location screen (MVI pattern)
 * Manages location search state and handles user events
 */
@OptIn(FlowPreview::class)
@HiltViewModel
class SearchLocationViewModel @Inject constructor(
    private val searchPlacesUseCase: SearchPlacesUseCase,
    private val getPlaceDetailsUseCase: GetPlaceDetailsUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(SearchLocationState())
    val state = _state.asStateFlow()

    private val _effect = Channel<SearchLocationEffect>()
    val effect = _effect.receiveAsFlow()

    // Search query flow for debouncing
    private val searchQueryFlow = MutableStateFlow("")

    init {
        // Set up debounced search
        viewModelScope.launch {
            searchQueryFlow
                .debounce(300) // Wait 300ms after user stops typing
                .distinctUntilChanged() // Only search if query changed
                .filter { it.length >= 2 } // Only search if query is at least 2 characters
                .collect { query ->
                    performSearch(query)
                }
        }
    }

    fun onEvent(event: SearchLocationEvent) {
        when (event) {
            is SearchLocationEvent.SearchQueryChanged -> onSearchQueryChanged(event.query)
            is SearchLocationEvent.PlaceSelected -> onPlaceSelected(event.placeId)
            is SearchLocationEvent.ClearSearch -> clearSearch()
            is SearchLocationEvent.DismissSuggestions -> dismissSuggestions()
        }
    }

    private fun onSearchQueryChanged(query: String) {
        _state.update { it.copy(searchQuery = query, showSuggestions = true) }

        if (query.length < 2) {
            _state.update { it.copy(searchSuggestions = emptyList(), isSearching = false) }
            return
        }

        searchQueryFlow.value = query
    }

    private fun performSearch(query: String) {
        viewModelScope.launch {
            searchPlacesUseCase(query).collect { resource ->
                when (resource) {
                    is Resource.Loading -> {
                        _state.update { it.copy(isSearching = true, error = null) }
                    }
                    is Resource.Success -> {
                        _state.update {
                            it.copy(
                                searchSuggestions = resource.data ?: emptyList(),
                                isSearching = false,
                                error = null
                            )
                        }
                    }
                    is Resource.Error -> {
                        _state.update {
                            it.copy(
                                isSearching = false,
                                error = resource.message
                            )
                        }
                        _effect.send(SearchLocationEffect.ShowError(
                            resource.message ?: "Search failed"
                        ))
                    }
                }
            }
        }
    }

    private fun onPlaceSelected(placeId: String) {
        viewModelScope.launch {
            getPlaceDetailsUseCase(placeId).collect { resource ->
                when (resource) {
                    is Resource.Loading -> {
                        _state.update { it.copy(isLoadingDetails = true, error = null) }
                    }
                    is Resource.Success -> {
                        _state.update {
                            it.copy(
                                selectedPlace = resource.data,
                                isLoadingDetails = false,
                                showSuggestions = false,
                                error = null
                            )
                        }
                        _effect.send(SearchLocationEffect.ShowSuccess(
                            "Location selected: ${resource.data?.name}"
                        ))
                    }
                    is Resource.Error -> {
                        _state.update {
                            it.copy(
                                isLoadingDetails = false,
                                error = resource.message
                            )
                        }
                        _effect.send(SearchLocationEffect.ShowError(
                            resource.message ?: "Failed to get place details"
                        ))
                    }
                }
            }
        }
    }

    private fun clearSearch() {
        _state.update {
            SearchLocationState() // Reset to initial state
        }
        searchQueryFlow.value = ""
    }

    private fun dismissSuggestions() {
        _state.update { it.copy(showSuggestions = false) }
    }
}