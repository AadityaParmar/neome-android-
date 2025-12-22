package com.neome.feature.form.presentation.form

sealed interface FormEffect {
    data class ShowSnackbar(val message: String) : FormEffect
    data object NavigateBack : FormEffect
}
