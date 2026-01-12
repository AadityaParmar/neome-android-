package com.neome.feature.form.presentation.state

import androidx.compose.runtime.Immutable

/**
 * Represents a validation error for a field.
 */
@Immutable
data class FieldError(
    val message: String,
    val type: ErrorType = ErrorType.Validation
) {
    /**
     * Type of error.
     */
    enum class ErrorType {
        /** Validation error (e.g., required, format) */
        Validation,

        /** Custom error set programmatically */
        Custom,

        /** Server-side error */
        Server
    }
}
