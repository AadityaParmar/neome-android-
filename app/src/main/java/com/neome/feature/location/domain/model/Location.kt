package com.neome.feature.location.domain.model

/**
 * Domain model for location data
 * Pure Kotlin class with no Android dependencies
 */
data class Location(
    val latitude: Double,
    val longitude: Double,
    val accuracy: Float,
    val address: String? = null,
    val city: String? = null,
    val state: String? = null,
    val country: String? = null,
    val postalCode: String? = null
)