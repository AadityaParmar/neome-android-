package com.neome.feature.location.data.repository

import com.neome.BuildConfig
import com.neome.core.common.Resource
import com.neome.feature.location.data.remote.PlacesApiService
import com.neome.feature.location.data.remote.findByType
import com.neome.feature.location.data.remote.toGeoPoint
import com.neome.feature.location.domain.model.PlaceDetail
import com.neome.feature.location.domain.model.SearchPlace
import com.neome.feature.location.domain.repository.SearchRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * Implementation of SearchRepository using Google Places API
 * Handles location search and place details fetching
 */
class SearchRepositoryImpl @Inject constructor(
    private val placesApi: PlacesApiService
) : SearchRepository {

    override fun searchPlaces(query: String): Flow<Resource<List<SearchPlace>>> = flow {
        emit(Resource.Loading)

        try {
            // Don't search if query is too short
            if (query.length < 2) {
                emit(Resource.Success(emptyList()))
                return@flow
            }

            // Call Places Autocomplete API
            val response = placesApi.autocomplete(
                input = query,
                key = BuildConfig.GOOGLE_API_KEY,
                types = null // Search all types of places
            )

            // Handle response status
            when (response.status) {
                "OK" -> {
                    val searchPlaces = response.predictions.map { prediction ->
                        SearchPlace(
                            placeId = prediction.placeId,
                            name = prediction.structuredFormatting.mainText,
                            address = prediction.description,
                            types = prediction.types
                        )
                    }
                    emit(Resource.Success(searchPlaces))
                }
                "ZERO_RESULTS" -> {
                    emit(Resource.Success(emptyList()))
                }
                else -> {
                    emit(Resource.Error(
                        message = response.errorMessage
                            ?: "Search error: ${response.status}"
                    ))
                }
            }
        } catch (e: Exception) {
            emit(Resource.Error("Search failed: ${e.message}"))
        }
    }.flowOn(Dispatchers.IO)

    override fun getPlaceDetails(placeId: String): Flow<Resource<PlaceDetail>> = flow {
        emit(Resource.Loading)

        try {
            // Call Places Details API
            val response = placesApi.placeDetails(
                placeId = placeId,
                key = BuildConfig.GOOGLE_API_KEY
            )

            // Handle response status
            when (response.status) {
                "OK" -> {
                    val place = response.result
                    val placeDetail = PlaceDetail(
                        placeId = place.placeId,
                        name = place.name,
                        address = place.formattedAddress,
                        geoPoint = place.geometry.location.toGeoPoint(),
                        city = place.addressComponents?.findByType("locality"),
                        country = place.addressComponents?.findByType("country")
                    )
                    emit(Resource.Success(placeDetail))
                }
                else -> {
                    emit(Resource.Error(
                        message = response.errorMessage
                            ?: "Details error: ${response.status}"
                    ))
                }
            }
        } catch (e: Exception) {
            emit(Resource.Error("Failed to get place details: ${e.message}"))
        }
    }.flowOn(Dispatchers.IO)
}