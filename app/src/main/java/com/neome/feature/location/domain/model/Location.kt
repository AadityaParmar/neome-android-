package com.neome.feature.location.domain.model

/**
 * Domain model for location data
 * Matches FieldDtoLocation format
 * Pure Kotlin class with no Android dependencies
 */
data class Location(
    val address: String? = null,
    val city: String? = null,
    val country: String? = null,
    val dateTime: String? = null,
    val geoPoint: GeoPoint
)

/**
 * GeoPoint model matching API format
 */
data class GeoPoint(
    val lat: Double,
    val lng: Double
)