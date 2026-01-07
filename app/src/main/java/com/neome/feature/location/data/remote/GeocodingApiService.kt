package com.neome.feature.location.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Retrofit API interface for Google Geocoding API
 * https://maps.googleapis.com/maps/api/geocode/json
 */
interface GeocodingApiService {

    /**
     * Reverse geocoding: Convert coordinates to address
     * @param latlng Latitude,Longitude (e.g., "40.714224,-73.961452")
     * @param key Google API key
     */
    @GET("geocode/json")
    suspend fun reverseGeocode(
        @Query("latlng") latlng: String,
        @Query("key") key: String
    ): GeocodingResponse
}