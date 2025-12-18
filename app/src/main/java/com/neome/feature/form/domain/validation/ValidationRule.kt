package com.neome.feature.form.domain.validation

import com.neome.feature.form.presentation.state.FieldState

/**
 * Validation rule interface for type-safe validation
 */
sealed interface ValidationRule<T> {
    fun validate(value: T, allFields: Map<String, FieldState<*>>): ValidationResult

    data class Required<T>(val message: String = "This field is required") : ValidationRule<T> {
        override fun validate(value: T, allFields: Map<String, FieldState<*>>): ValidationResult {
            return when {
                value == null -> ValidationResult.Error(message)
                value is String && value.isBlank() -> ValidationResult.Error(message)
                value is Collection<*> && value.isEmpty() -> ValidationResult.Error(message)
                else -> ValidationResult.Success
            }
        }
    }

    data class MinLength(
        val min: Int,
        val message: String = "Minimum $min characters required"
    ) : ValidationRule<String> {
        override fun validate(
            value: String,
            allFields: Map<String, FieldState<*>>
        ): ValidationResult {
            return if (value.length < min) {
                ValidationResult.Error(message)
            } else {
                ValidationResult.Success
            }
        }
    }

    data class MaxLength(
        val max: Int,
        val message: String = "Maximum $max characters allowed"
    ) : ValidationRule<String> {
        override fun validate(
            value: String,
            allFields: Map<String, FieldState<*>>
        ): ValidationResult {
            return if (value.length > max) {
                ValidationResult.Error(message)
            } else {
                ValidationResult.Success
            }
        }
    }

    data class Email(
        val message: String = "Invalid email format"
    ) : ValidationRule<String> {
        override fun validate(
            value: String,
            allFields: Map<String, FieldState<*>>
        ): ValidationResult {
            val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\$".toRegex()
            return if (emailRegex.matches(value)) {
                ValidationResult.Success
            } else {
                ValidationResult.Error(message)
            }
        }
    }

    data class Phone(
        val message: String = "Invalid phone number"
    ) : ValidationRule<String> {
        override fun validate(
            value: String,
            allFields: Map<String, FieldState<*>>
        ): ValidationResult {
            val phoneRegex =
                "^[+]?[(]?[0-9]{1,4}[)]?[-\\s.]?[(]?[0-9]{1,4}[)]?[-\\s.]?[0-9]{1,9}\$".toRegex()
            return if (phoneRegex.matches(value)) {
                ValidationResult.Success
            } else {
                ValidationResult.Error(message)
            }
        }
    }

    data class MinValue<T : Comparable<T>>(
        val min: T,
        val message: String = "Value must be at least $min"
    ) : ValidationRule<T> {
        override fun validate(value: T, allFields: Map<String, FieldState<*>>): ValidationResult {
            return if (value >= min) {
                ValidationResult.Success
            } else {
                ValidationResult.Error(message)
            }
        }
    }

    data class MaxValue<T : Comparable<T>>(
        val max: T,
        val message: String = "Value must be at most $max"
    ) : ValidationRule<T> {
        override fun validate(value: T, allFields: Map<String, FieldState<*>>): ValidationResult {
            return if (value <= max) {
                ValidationResult.Success
            } else {
                ValidationResult.Error(message)
            }
        }
    }

    data class MatchesField<T>(
        val otherFieldId: String,
        val message: String = "Values do not match"
    ) : ValidationRule<T> {
        @Suppress("UNCHECKED_CAST")
        override fun validate(value: T, allFields: Map<String, FieldState<*>>): ValidationResult {
            val otherField = allFields[otherFieldId] as? FieldState<T>
            return if (otherField != null && value == otherField.value) {
                ValidationResult.Success
            } else {
                ValidationResult.Error(message)
            }
        }
    }

    data class Custom<T>(
        val message: String,
        val validator: (T) -> Boolean
    ) : ValidationRule<T> {
        override fun validate(value: T, allFields: Map<String, FieldState<*>>): ValidationResult {
            return if (validator(value)) {
                ValidationResult.Success
            } else {
                ValidationResult.Error(message)
            }
        }
    }
}

/**
 * Result of validation
 */
sealed interface ValidationResult {
    data object Success : ValidationResult
    data class Error(val message: String) : ValidationResult
}
