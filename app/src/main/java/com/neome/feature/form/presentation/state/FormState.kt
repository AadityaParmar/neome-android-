package com.neome.feature.form.presentation.state

/**
 * Centralized form state container
 * Single source of truth for all form data
 */
data class FormState(
    val fields: Map<String, FieldState<*>> = emptyMap(),
    val errors: Map<String, String?> = emptyMap(),
    val isDirty: Boolean = false,
    val isValid: Boolean = false,
    val isSubmitting: Boolean = false,
    val touchedFields: Set<String> = emptySet(),
    val dependencies: Map<String, List<String>> = emptyMap(),
    val submitError: String? = null
)
