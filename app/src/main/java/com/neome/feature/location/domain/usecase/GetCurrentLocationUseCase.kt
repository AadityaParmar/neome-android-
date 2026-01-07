package com.neome.feature.location.domain.usecase

import com.neome.core.common.Resource
import com.neome.feature.location.domain.model.Location
import com.neome.feature.location.domain.repository.LocationRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Use case for getting current location with address
 * Single responsibility: Coordinate location fetching logic
 */
class GetCurrentLocationUseCase @Inject constructor(
    private val repository: LocationRepository
) {
    operator fun invoke(): Flow<Resource<Location>> {
        return repository.getCurrentLocationWithAddress()
    }
}