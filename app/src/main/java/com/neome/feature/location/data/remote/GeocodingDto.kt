package com.neome.feature.location.data.remote

import com.google.gson.annotations.SerializedName

/**
 * DTOs for Google Geocoding API response
 * https://developers.google.com/maps/documentation/geocoding/overview
 */
data class GeocodingResponse(
    @SerializedName("results")
    val results: List<GeocodingResult>,
    @SerializedName("status")
    val status: String,
    @SerializedName("error_message")
    val errorMessage: String? = null
)

data class GeocodingResult(
    @SerializedName("formatted_address")
    val formattedAddress: String,
    @SerializedName("address_components")
    val addressComponents: List<AddressComponent>,
    @SerializedName("geometry")
    val geometry: Geometry
)

data class AddressComponent(
    @SerializedName("long_name")
    val longName: String,
    @SerializedName("short_name")
    val shortName: String,
    @SerializedName("types")
    val types: List<String>
)

data class Geometry(
    @SerializedName("location")
    val location: GeocodingLocation
)

data class GeocodingLocation(
    @SerializedName("lat")
    val lat: Double,
    @SerializedName("lng")
    val lng: Double
)

/**
 * Extension function to extract specific address component
 */
fun List<AddressComponent>.findByType(type: String): String? {
    return firstOrNull { it.types.contains(type) }?.longName
}