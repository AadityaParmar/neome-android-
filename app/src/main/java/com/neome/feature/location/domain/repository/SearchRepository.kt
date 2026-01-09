package com.neome.feature.location.domain.repository

import com.neome.core.common.Resource
import com.neome.feature.location.domain.model.PlaceDetail
import com.neome.feature.location.domain.model.SearchPlace
import kotlinx.coroutines.flow.Flow

/**
 * Repository interface for location search operations
 * Pure Kotlin interface with no Android dependencies
 */
interface SearchRepository {
    /**
     * Search for location suggestions based on query
     * Returns Flow<Resource<List<SearchPlace>>> for reactive updates
     *
     * @param query Search query text
     * @return Flow of search suggestions
     */
    fun searchPlaces(query: String): Flow<Resource<List<SearchPlace>>>

    /**
     * Get detailed information about a place
     * Returns Flow<Resource<PlaceDetail>> for reactive updates
     *
     * @param placeId Unique place identifier
     * @return Flow of place details
     */
    fun getPlaceDetails(placeId: String): Flow<Resource<PlaceDetail>>
}