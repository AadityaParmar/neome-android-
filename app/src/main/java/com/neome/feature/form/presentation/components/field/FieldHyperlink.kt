package com.neome.feature.form.presentation.components.field

import android.content.Intent
import android.net.Uri
import android.util.Patterns
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Link
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueHyperlinkData
import com.neome.feature.form.presentation.components.base.FieldBase
import com.neome.feature.form.presentation.components.base.rememberFieldController
import com.neome.feature.form.presentation.state.FieldEvent

// ============================================================================
// URL Validation
// ============================================================================

/**
 * Validates if the input is a valid URL.
 * Uses Android's built-in Patterns.WEB_URL matcher for robust validation.
 *
 * @param input The string to validate
 * @return true if input is a valid URL
 */
private fun isValidUrl(input: String): Boolean {
    if (input.isBlank()) return false
    return Patterns.WEB_URL.matcher(input).matches()
}

/**
 * Returns whether the URL input has a validation error.
 *
 * @param input The current input value
 * @return true if input is non-empty and not a valid URL
 */
private fun hasUrlValidationError(input: String): Boolean {
    if (input.isEmpty()) return false
    return !isValidUrl(input)
}

/**
 * Normalizes a URL by adding https:// prefix if no scheme is present.
 * This ensures the URL can be opened by the system browser.
 *
 * @param url The URL to normalize
 * @return URL with scheme, or original if already has scheme
 */
private fun normalizeUrl(url: String): String {
    val trimmed = url.trim()
    return if (trimmed.contains("://")) {
        trimmed
    } else {
        "https://$trimmed"
    }
}

// ============================================================================
// Main Component
// ============================================================================

/**
 * Hyperlink field component for form.
 *
 * FormCtx is accessed via LocalFormCtx.current inside rememberFieldController, so this composable
 * must be called inside a Form composable tree.
 *
 * A specialized text field that accepts only valid URLs.
 * Behaves exactly like FieldText but with URL validation and a clickable link icon.
 *
 * Key Features (reused from FieldText):
 * - Same OutlinedTextField UI, layout, spacing, and typography
 * - Same state handling and properties
 * - Same validation UI mechanism
 * - Single line input
 *
 * Hyperlink-specific Features:
 * - URL validation using Android's Patterns.WEB_URL
 * - Paper-clip (link) icon that opens the URL in system browser
 * - Icon is disabled when field is empty, invalid, or disabled
 * - Auto-prefixes https:// if no scheme is present when opening
 *
 * Supported Properties:
 * - defaultValue
 * - required
 * - disabled
 * - helperText
 * - placeholder
 *
 * @param defnComp Field definition containing field configuration
 * @param onFieldEvent Callback to emit field events to the form
 * @param modifier Modifier for customization
 */
@Composable
fun FieldHyperlink(
    defnComp: DefnCompSeal,
    onFieldEvent: (FieldEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    // ========== REUSED FROM FieldText: Field Controller Setup ==========
    val fieldController = rememberFieldController<FieldValueHyperlinkData>(
        defnComp = defnComp,
        onFieldEvent = onFieldEvent
    )

    // ========== REUSED FROM FieldText: Early Returns ==========
    if (fieldController.fieldId == null) return

    // ========== Collect reactive field value separately for finer-grained recomposition ==========
    val fieldValue = fieldController.value.value

    // ========== Collect reactive field properties and error ==========
    val (properties, _) = fieldController.field.value

    // Early return if field is hidden
    if (properties.hidden) return

    // ========== REUSED FROM FieldText: Current Value & Local State ==========
    // Get current hyperlink value from FieldValueHyperlinkData
    val currentValue = fieldValue?.value ?: ""

    // ========== REUSED FROM FieldText: Value Change Handler ==========
    fun onValueChange(newValue: String) {
        val fv = if (newValue.isEmpty()) null else FieldValueHyperlinkData(newValue)
        fieldController.onChange(fv)
    }

    // ========== Hyperlink-specific: Validation State ==========
    val isError = hasUrlValidationError(currentValue)
    val isValidLink = currentValue.isNotEmpty() && isValidUrl(currentValue)

    // ========== Hyperlink-specific: Icon Click State ==========
    // Icon is clickable only when:
    // - Field is not disabled
    // - Field has a valid, non-empty URL
    val isIconEnabled = !properties.disabled && isValidLink

    // ========== Hyperlink-specific: Context for Intent ==========
    val context = LocalContext.current

    // ========== Hyperlink-specific: Open Link Handler ==========
    fun openLink() {
        if (!isIconEnabled) return

        try {
            val normalizedUrl = normalizeUrl(currentValue)
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(normalizedUrl))
            context.startActivity(intent)
        } catch (e: Exception) {
            // Silently fail if no browser is available or URL is malformed
        }
    }

    // ========== REUSED FROM FieldText: FieldBase + OutlinedTextField UI ==========
    FieldBase(modifier = modifier) {
        OutlinedTextField(
            value = currentValue,
            onValueChange = ::onValueChange,
            label = properties.label?.let { { Text(it) } },
            placeholder = properties.placeholder?.let { { Text(it) } },
            supportingText = {
                when {
                    // Show validation error if URL is invalid
                    isError -> {
                        Text(
                            text = "Please enter a valid URL",
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
            maxLines = 1,
            modifier = Modifier.fillMaxWidth(),
            trailingIcon = {
                IconButton(
                    onClick = { openLink() },
                    enabled = isIconEnabled
                ) {
                    Icon(
                        imageVector = Icons.Default.Link,
                        contentDescription = if (isIconEnabled) "Open link" else "Link",
                        tint = if (isIconEnabled) {
                            MaterialTheme.colorScheme.primary
                        } else {
                            MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
                        }
                    )
                }
            }
        )
    }
}
