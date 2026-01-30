package com.neome.feature.form.presentation.components.field

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueHandleData
import com.neome.feature.form.domain.ctx.FormCtx
import com.neome.feature.form.presentation.components.base.FieldBase
import com.neome.feature.form.presentation.components.base.rememberFieldController
import com.neome.feature.form.presentation.state.FieldEvent

// ============================================================================
// Validation Regex Patterns
// ============================================================================

/**
 * Email validation regex pattern.
 * Reused from FieldEmail - matches standard email format.
 */
private val EMAIL_REGEX = Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")

/**
 * Mobile number validation regex pattern.
 * Format: +<country_code><10_digit_number>
 * - Must start with '+'
 * - Country code: 1 or more digits
 * - Subscriber number: exactly 10 digits
 * Examples: +918989898989, +14155552671
 */
private val MOBILE_REGEX = Regex("^\\+[0-9]+[0-9]{10}$")

// ============================================================================
// Validation Result
// ============================================================================

/**
 * Represents the result of handle validation.
 */
private sealed interface HandleValidationResult {
    data object Valid : HandleValidationResult
    data object Empty : HandleValidationResult
    data class Invalid(val message: String) : HandleValidationResult
}

// ============================================================================
// Validation Functions
// ============================================================================

/**
 * Validates if the input is a valid email address.
 * Reuses the same validation logic as FieldEmail.
 *
 * @param input The string to validate
 * @return true if input matches email format
 */
private fun isValidEmail(input: String): Boolean {
    return EMAIL_REGEX.matches(input)
}

/**
 * Validates if the input is a valid mobile number in international format.
 *
 * Rules:
 * - Must start with '+'
 * - Country code can be any number of digits (1+)
 * - Subscriber number must be exactly 10 digits
 *
 * @param input The string to validate
 * @return true if input matches mobile format
 */
private fun isValidMobile(input: String): Boolean {
    if (!input.startsWith("+")) return false
    if (input.length < 12) return false // + + at least 1 country code digit + 10 subscriber digits

    // Extract digits after '+'
    val digits = input.substring(1)

    // Must be all digits
    if (!digits.all { it.isDigit() }) return false

    // Must have at least 11 digits (1 country code + 10 subscriber)
    // and subscriber number is last 10 digits
    return digits.length >= 11
}

/**
 * Validates the handle input.
 * Input is valid if it matches email format OR mobile format.
 *
 * @param input The string to validate
 * @return HandleValidationResult indicating validity
 */
private fun validateHandle(input: String): HandleValidationResult {
    if (input.isEmpty()) return HandleValidationResult.Empty

    // Check if it looks like a mobile number (starts with +)
    if (input.startsWith("+")) {
        return if (isValidMobile(input)) {
            HandleValidationResult.Valid
        } else {
            HandleValidationResult.Invalid("Invalid mobile number. Use format: +<country_code><10_digit_number>")
        }
    }

    // Otherwise, validate as email
    return if (isValidEmail(input)) {
        HandleValidationResult.Valid
    } else {
        HandleValidationResult.Invalid("Invalid email address")
    }
}

/**
 * Determines if the input has a validation error.
 * Used for the isError property of OutlinedTextField.
 *
 * @param input The current input value
 * @return true if input is non-empty and invalid
 */
private fun hasValidationError(input: String): Boolean {
    val result = validateHandle(input)
    return result is HandleValidationResult.Invalid
}

/**
 * Gets the validation error message for display.
 *
 * @param input The current input value
 * @return Error message string, or null if valid/empty
 */
private fun getValidationErrorMessage(input: String): String? {
    val result = validateHandle(input)
    return (result as? HandleValidationResult.Invalid)?.message
}

// ============================================================================
// Main Component
// ============================================================================

/**
 * Handle field component for form.
 *
 * A specialized input field that accepts either an email address OR a mobile number.
 * Behaves exactly like FieldEmail but with extended validation logic.
 *
 * Accepted Input Formats:
 * - Email: Standard email format (same validation as FieldEmail)
 * - Mobile: International format +<country_code><10_digit_number>
 *
 * Key Features (reused from FieldEmail):
 * - Same OutlinedTextField UI
 * - Same keyboard behavior and styling
 * - Same error display mechanism
 * - Same state handling and properties
 *
 * Handle-specific Features:
 * - Automatic format detection (email vs mobile)
 * - Combined validation (valid if matches either format)
 * - Format-specific error messages
 *
 * @param defnComp Field definition containing field configuration
 * @param onFieldEvent Callback to emit field events to the form
 * @param formCtx Form context for accessing field state and other field values
 * @param modifier Modifier for customization
 */
@Composable
fun FieldHandle(
    defnComp: DefnCompSeal,
    onFieldEvent: (FieldEvent) -> Unit,
    formCtx: FormCtx,
    modifier: Modifier = Modifier
) {
    // ========== REUSED FROM FieldEmail: Field Controller Setup ==========
    // Use field controller composable with FieldValueHandleData type
    val fieldController = rememberFieldController<FieldValueHandleData>(
        defnComp = defnComp,
        onFieldEvent = onFieldEvent,
        formCtx = formCtx
    )

    // ========== REUSED FROM FieldEmail: Early Returns ==========
    // Early return if field setup is invalid
    if (fieldController.fieldId == null) return

    // ========== REUSED FROM FieldEmail: Reactive Properties ==========
    // Watch field properties reactively through controller
    val properties by fieldController.fieldPropertiesFlow.collectAsStateWithLifecycle()

    // Early return if field is hidden
    if (properties.hidden) return

    // ========== REUSED FROM FieldEmail: Current Value & Local State ==========
    // Get current handle value from FieldValueHandleData
    val currentValue = fieldController.fieldValue?.value ?: ""

    // Local state for handle input
    var handleValue by remember(currentValue) { mutableStateOf(currentValue) }

    // ========== REUSED FROM FieldEmail: Value Change Handler ==========
    // Handle value changes
    fun onValueChange(newValue: String) {
        handleValue = newValue
        // Use controller's onChange callback with FieldValueHandleData
        val fieldValue = if (newValue.isEmpty()) null else FieldValueHandleData(newValue)
        fieldController.onChange(fieldValue)
    }

    // ========== Handle-specific: Validation State ==========
    val isError = hasValidationError(handleValue)
    val errorMessage = getValidationErrorMessage(handleValue)

    // ========== Handle-specific: Determine Keyboard Type ==========
    // Use phone keyboard if input starts with '+', otherwise email keyboard
    val keyboardType = if (handleValue.startsWith("+")) {
        KeyboardType.Phone
    } else {
        KeyboardType.Email
    }

    // ========== REUSED FROM FieldEmail: FieldBase + OutlinedTextField UI ==========
    FieldBase(modifier = modifier) {
        OutlinedTextField(
            value = handleValue,
            onValueChange = ::onValueChange,
            label = properties.label?.let { { Text(it) } },
            placeholder = properties.placeholder?.let { { Text(it) } },
            supportingText = {
                when {
                    // Show validation error if present
                    isError && errorMessage != null -> {
                        Text(
                            text = errorMessage,
                            color = MaterialTheme.colorScheme.error
                        )
                    }
                    // Otherwise show helper text if available
                    properties.helperText != null -> {
                        Text(properties.helperText!!)
                    }
                }
            },
            isError = isError,
            enabled = !properties.disabled,
            readOnly = properties.readOnly,
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            modifier = Modifier.fillMaxWidth()
        )
    }
}
