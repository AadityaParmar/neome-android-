package com.neome.feature.location.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Retrofit API interface for Google Places API
 * Base URL: https://maps.googleapis.com/maps/api/
 */
interface PlacesApiService {

    /**
     * Places Autocomplete API
     * Search for location suggestions based on query text
     *
     * @param input Search query text
     * @param key Google API key
     * @param types Optional filter for place types (e.g., "geocode", "establishment")
     * @param language Optional language code (e.g., "en")
     */
    @GET("place/autocomplete/json")
    suspend fun autocomplete(
        @Query("input") input: String,
        @Query("key") key: String,
        @Query("types") types: String? = null,
        @Query("language") language: String? = "en"
    ): PlacesAutocompleteResponse

    /**
     * Places Details API
     * Get detailed information about a place using place_id
     *
     * @param placeId Unique identifier for a place
     * @param key Google API key
     * @param fields Optional comma-separated list of fields to return
     */
    @GET("place/details/json")
    suspend fun placeDetails(
        @Query("place_id") placeId: String,
        @Query("key") key: String,
        @Query("fields") fields: String? = "place_id,name,formatted_address,geometry,address_components"
    ): PlaceDetailsResponse
}