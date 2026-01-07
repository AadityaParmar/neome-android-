package com.neome.feature.location.domain.repository

import com.neome.core.common.Resource
import com.neome.feature.location.domain.model.Location
import kotlinx.coroutines.flow.Flow

/**
 * Repository interface for location operations
 * Pure Kotlin interface with no Android dependencies
 */
interface LocationRepository {
    /**
     * Get current location with address
     * Returns Flow<Resource<Location>> for reactive updates
     */
    fun getCurrentLocationWithAddress(): Flow<Resource<Location>>
}