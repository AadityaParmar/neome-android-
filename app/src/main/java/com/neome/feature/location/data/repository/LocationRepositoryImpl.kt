package com.neome.feature.location.data.repository

import android.content.Context
import com.neome.BuildConfig
import com.neome.core.common.Resource
import com.neome.feature.location.data.remote.GeocodingApiService
import com.neome.feature.location.data.remote.findByType
import com.neome.feature.location.domain.model.Location
import com.neome.feature.location.domain.repository.LocationRepository
import com.neome.feature.utils.captureLocation
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject

/**
 * Implementation of LocationRepository
 * Uses LocationUtils for location capture and Google Geocoding API for address
 */
class LocationRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context,
    private val geocodingApi: GeocodingApiService
) : LocationRepository {

    override fun getCurrentLocationWithAddress(): Flow<Resource<Location>> = flow {
        emit(Resource.Loading)

        try {
            // Use captureLocation utility function to get current location
            val geoPoint = captureLocation(context)

            if (geoPoint == null) {
                emit(Resource.Error("Unable to get current location. Please check if location services are enabled."))
                return@flow
            }

            // Current timestamp in ISO format
            val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
            val currentDateTime = dateFormat.format(Date())

            // Get address from coordinates using Geocoding API
            try {
                val latlng = "${geoPoint.lat},${geoPoint.lng}"
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
                                address = result.formattedAddress,
                                city = addressComponents.findByType("locality")
                                    ?: addressComponents.findByType("administrative_area_level_2"),
                                country = addressComponents.findByType("country"),
                                dateTime = currentDateTime,
                                geoPoint = geoPoint
                            )
                            emit(Resource.Success(location))
                        } else {
                            // No results from geocoding, emit location without address
                            emit(Resource.Success(
                                Location(
                                    address = "Address not found",
                                    city = null,
                                    country = null,
                                    dateTime = currentDateTime,
                                    geoPoint = geoPoint
                                )
                            ))
                        }
                    }
                    "ZERO_RESULTS" -> {
                        emit(Resource.Success(
                            Location(
                                address = "No address found for this location",
                                city = null,
                                country = null,
                                dateTime = currentDateTime,
                                geoPoint = geoPoint
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