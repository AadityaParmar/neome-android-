package com.neome.feature.location.domain.usecase

import com.neome.core.common.Resource
import com.neome.feature.location.domain.model.PlaceDetail
import com.neome.feature.location.domain.repository.SearchRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Use case for getting detailed information about a place
 * Single responsibility: Coordinate place details fetching
 */
class GetPlaceDetailsUseCase @Inject constructor(
    private val repository: SearchRepository
) {
    operator fun invoke(placeId: String): Flow<Resource<PlaceDetail>> {
        return repository.getPlaceDetails(placeId)
    }
}