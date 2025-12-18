package com.neome.feature.form.presentation.state

/**
 * One-time side effects that don't belong in state
 * Navigation, toasts, dialogs consumed exactly once
 */
sealed interface FormEffect {
    data class ShowSnackbar(val message: String) : FormEffect
    data class ShowToast(val message: String) : FormEffect
    data class ShowError(val message: String) : FormEffect
    data object NavigateBack : FormEffect
    data class NavigateToDetail(val id: String) : FormEffect
}
