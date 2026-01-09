package com.neome.feature.location.domain.usecase

import com.neome.core.common.Resource
import com.neome.feature.location.domain.model.SearchPlace
import com.neome.feature.location.domain.repository.SearchRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Use case for searching places by query
 * Single responsibility: Coordinate place search logic
 */
class SearchPlacesUseCase @Inject constructor(
    private val repository: SearchRepository
) {
    operator fun invoke(query: String): Flow<Resource<List<SearchPlace>>> {
        return repository.searchPlaces(query)
    }
}