package com.neome.feature.componentshowcase.presentation.searchlocation

/**
 * One-time effects for Search Location screen (MVI pattern)
 * Used for side effects like showing snackbar or navigation
 */
sealed interface SearchLocationEffect {
    data class ShowError(val message: String) : SearchLocationEffect
    data class ShowSuccess(val message: String) : SearchLocationEffect
}