package com.neome.feature.componentshowcase.presentation.location

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.neome.core.common.Resource
import com.neome.feature.location.domain.usecase.GetCurrentLocationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel for Location showcase
 * Follows MVI pattern with single onEvent entry point
 */
@HiltViewModel
class LocationViewModel @Inject constructor(
    private val getCurrentLocationUseCase: GetCurrentLocationUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(LocationState())
    val state = _state.asStateFlow()

    fun onEvent(event: LocationEvent) {
        when (event) {
            is LocationEvent.GetLocation -> {
                if (_state.value.permissionGranted) {
                    getCurrentLocation()
                } else {
                    _state.update {
                        it.copy(
                            error = "Location permission not granted. Please grant permission to access location."
                        )
                    }
                }
            }
            is LocationEvent.ClearLocation -> {
                _state.update {
                    it.copy(
                        location = null,
                        error = null
                    )
                }
            }
            is LocationEvent.PermissionResult -> {
                _state.update { it.copy(permissionGranted = event.granted) }
                if (event.granted) {
                    // Clear any previous permission error
                    _state.update { it.copy(error = null) }
                }
            }
        }
    }

    private fun getCurrentLocation() {
        viewModelScope.launch {
            getCurrentLocationUseCase().collect { resource ->
                when (resource) {
                    is Resource.Loading -> {
                        _state.update {
                            it.copy(
                                isLoading = true,
                                error = null
                            )
                        }
                    }
                    is Resource.Success -> {
                        _state.update {
                            it.copy(
                                location = resource.data,
                                isLoading = false,
                                error = null
                            )
                        }
                    }
                    is Resource.Error -> {
                        _state.update {
                            it.copy(
                                isLoading = false,
                                error = resource.message
                            )
                        }
                    }
                }
            }
        }
    }
}