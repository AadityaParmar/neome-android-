package com.neome.feature.location.data.remote

import com.google.gson.annotations.SerializedName
import com.neome.feature.location.domain.model.GeoPoint

/**
 * DTOs for Google Places API Autocomplete
 * https://developers.google.com/maps/documentation/places/web-service/autocomplete
 */
data class PlacesAutocompleteResponse(
    @SerializedName("predictions")
    val predictions: List<PlacePrediction>,
    @SerializedName("status")
    val status: String,
    @SerializedName("error_message")
    val errorMessage: String? = null
)

data class PlacePrediction(
    @SerializedName("description")
    val description: String,
    @SerializedName("place_id")
    val placeId: String,
    @SerializedName("structured_formatting")
    val structuredFormatting: StructuredFormatting,
    @SerializedName("types")
    val types: List<String>
)

data class StructuredFormatting(
    @SerializedName("main_text")
    val mainText: String,
    @SerializedName("secondary_text")
    val secondaryText: String?
)

/**
 * DTOs for Google Places Details API
 * https://developers.google.com/maps/documentation/places/web-service/details
 */
data class PlaceDetailsResponse(
    @SerializedName("result")
    val result: PlaceDetails,
    @SerializedName("status")
    val status: String,
    @SerializedName("error_message")
    val errorMessage: String? = null
)

data class PlaceDetails(
    @SerializedName("place_id")
    val placeId: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("formatted_address")
    val formattedAddress: String,
    @SerializedName("geometry")
    val geometry: PlaceGeometry,
    @SerializedName("address_components")
    val addressComponents: List<AddressComponent>? = null
)

data class PlaceGeometry(
    @SerializedName("location")
    val location: PlaceLocation
)

data class PlaceLocation(
    @SerializedName("lat")
    val lat: Double,
    @SerializedName("lng")
    val lng: Double
)

/**
 * Extension to convert PlaceLocation to GeoPoint
 */
fun PlaceLocation.toGeoPoint(): GeoPoint {
    return GeoPoint(lat = lat, lng = lng)
}