package com.neome.feature.form.presentation.form

sealed interface FormEvent {
    data object Submit : FormEvent
    data object Reset : FormEvent
}
