package com.neome.core.common

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Sealed class for handling data states (Loading, Success, Error)
 * Following Clean Architecture pattern from CLAUDE.md
 */
sealed class Resource<out T> {
    data object Loading : Resource<Nothing>()
    data class Success<T>(val data: T) : Resource<T>()
    data class Error(val message: String, val throwable: Throwable? = null) : Resource<Nothing>()

    val isLoading get() = this is Loading
    val isSuccess get() = this is Success
    val isError get() = this is Error

    fun getOrNull(): T? = (this as? Success)?.data
}

/**
 * Extension function to wrap Flow<T> in Resource
 */
fun <T> Flow<T>.asResource(): Flow<Resource<T>> = flow {
    emit(Resource.Loading)
    try {
        collect { emit(Resource.Success(it)) }
    } catch (e: Exception) {
        emit(Resource.Error(e.message ?: "Unknown error", e))
    }
}