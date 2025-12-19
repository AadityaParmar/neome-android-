package com.neome.feature.form.presentation.state

/**
 * State for individual form field
 */
data class FieldState<T>(
    val value: T,
    val defaultValue: T,
    val isRequired: Boolean = false,
    val isDisabled: Boolean = false,
    val isTouched: Boolean = false,
    val isDirty: Boolean = false,
    val dependsOn: List<String> = emptyList()
)
