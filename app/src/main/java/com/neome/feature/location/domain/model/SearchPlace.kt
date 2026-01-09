package com.neome.feature.location.domain.model

/**
 * Domain model for a search place suggestion
 * Used in location search autocomplete
 */
data class SearchPlace(
    val placeId: String,
    val name: String,
    val address: String,
    val types: List<String> = emptyList()
)

/**
 * Domain model for a detailed place
 * Contains full location information
 */
data class PlaceDetail(
    val placeId: String,
    val name: String,
    val address: String,
    val geoPoint: GeoPoint,
    val city: String? = null,
    val country: String? = null
)