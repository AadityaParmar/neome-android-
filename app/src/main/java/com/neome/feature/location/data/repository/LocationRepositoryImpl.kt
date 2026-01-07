package com.neome.feature.location.data.repository

import android.annotation.SuppressLint
import android.content.Context
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import com.neome.BuildConfig
import com.neome.core.common.Resource
import com.neome.feature.location.data.remote.GeocodingApiService
import com.neome.feature.location.data.remote.findByType
import com.neome.feature.location.domain.model.Location
import com.neome.feature.location.domain.repository.LocationRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

/**
 * Implementation of LocationRepository
 * Uses FusedLocationProviderClient for location and Google Geocoding API for address
 */
class LocationRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context,
    private val geocodingApi: GeocodingApiService
) : LocationRepository {

    private val fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)

    @SuppressLint("MissingPermission")
    override fun getCurrentLocationWithAddress(): Flow<Resource<Location>> = flow {
        emit(Resource.Loading)

        try {
            // Get current location using FusedLocationProviderClient
            val locationResult = fusedLocationClient.getCurrentLocation(
                Priority.PRIORITY_HIGH_ACCURACY,
                null
            ).await()

            if (locationResult == null) {
                emit(Resource.Error("Unable to get current location. Please check if location services are enabled."))
                return@flow
            }

            val latitude = locationResult.latitude
            val longitude = locationResult.longitude
            val accuracy = locationResult.accuracy

            // Get address from coordinates using Geocoding API
            try {
                val latlng = "$latitude,$longitude"
                val geocodingResponse = geocodingApi.reverseGeocode(
                    latlng = latlng,
                    key = BuildConfig.GOOGLE_API_KEY
                )

                when (geocodingResponse.status) {
                    "OK" -> {
                        val result = geocodingResponse.results.firstOrNull()
                        if (result != null) {
                            val addressComponents = result.addressComponents

                            val location = Location(
                                latitude = latitude,
                                longitude = longitude,
                                accuracy = accuracy,
                                address = result.formattedAddress,
                                city = addressComponents.findByType("locality")
                                    ?: addressComponents.findByType("administrative_area_level_2"),
                                state = addressComponents.findByType("administrative_area_level_1"),
                                country = addressComponents.findByType("country"),
                                postalCode = addressComponents.findByType("postal_code")
                            )
                            emit(Resource.Success(location))
                        } else {
                            // No results from geocoding, emit location without address
                            emit(Resource.Success(
                                Location(
                                    latitude = latitude,
                                    longitude = longitude,
                                    accuracy = accuracy,
                                    address = "Address not found"
                                )
                            ))
                        }
                    }
                    "ZERO_RESULTS" -> {
                        emit(Resource.Success(
                            Location(
                                latitude = latitude,
                                longitude = longitude,
                                accuracy = accuracy,
                                address = "No address found for this location"
                            )
                        ))
                    }
                    "OVER_QUERY_LIMIT" -> {
                        emit(Resource.Error("API quota exceeded. Error: ${geocodingResponse.status}"))
                    }
                    "REQUEST_DENIED" -> {
                        emit(Resource.Error("API request denied. Check your API key. Error: ${geocodingResponse.status}${geocodingResponse.errorMessage?.let { " - $it" } ?: ""}"))
                    }
                    "INVALID_REQUEST" -> {
                        emit(Resource.Error("Invalid API request. Error: ${geocodingResponse.status}"))
                    }
                    "UNKNOWN_ERROR" -> {
                        emit(Resource.Error("Server error. Please try again later. Error: ${geocodingResponse.status}"))
                    }
                    else -> {
                        emit(Resource.Error("Geocoding API error: ${geocodingResponse.status}${geocodingResponse.errorMessage?.let { " - $it" } ?: ""}"))
                    }
                }
            } catch (e: Exception) {
                // Network error or API error - emit location without address
                emit(Resource.Error("Failed to fetch address: ${e.message}. Check your internet connection and API key."))
            }

        } catch (e: SecurityException) {
            emit(Resource.Error("Location permission not granted: ${e.message}"))
        } catch (e: Exception) {
            emit(Resource.Error("Failed to get location: ${e.message}"))
        }
    }
}