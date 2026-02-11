package com.neome.feature.form.presentation.components.field

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

/**
 * Raw counter component — stateless, reusable counter UI.
 *
 * Layout: [ - ] [ INPUT ] [ + ]
 *
 * Uses BasicTextField for compact, dynamic-width input that sizes to content.
 * When [value] is null, the input appears empty until user interacts.
 * State is fully controlled by the caller via [value] and [onValueChange].
 *
 * @param value Current counter value (null means not yet set — shows empty input)
 * @param onValueChange Callback when value changes (clamped to min/max)
 * @param min Minimum allowed value
 * @param max Maximum allowed value
 * @param step Increment/decrement step size
 * @param enabled Whether the counter is interactive
 * @param readOnly Whether the counter is read-only
 * @param isError Whether to show error styling on the input
 * @param modifier Modifier for customization
 */
@Composable
fun RawCounter(
    value: Long?,
    onValueChange: (Long?) -> Unit,
    min: Long,
    max: Long,
    step: Long,
    enabled: Boolean,
    readOnly: Boolean,
    isError: Boolean,
    modifier: Modifier = Modifier
) {
    val focusManager = LocalFocusManager.current
    val isInteractive = enabled && !readOnly

    // Show empty when value is null (not yet set), otherwise show the number
    val initialText = value?.toString() ?: ""

    // Local text state keyed to value. Re-initializes when value changes externally.
    var textValue by remember(value) { mutableStateOf(initialText) }
    var isFocused by remember { mutableStateOf(false) }

    // For button logic: use current value or 0 as base for increment/decrement
    val baseValue = value ?: 0L
    val canDecrement = isInteractive && baseValue > min
    val canIncrement = isInteractive && baseValue < max

    val borderColor = when {
        isError -> MaterialTheme.colorScheme.error
        isFocused -> MaterialTheme.colorScheme.primary
        else -> MaterialTheme.colorScheme.outline
    }
    val borderWidth = if (isFocused) 2.dp else 1.dp

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Decrement button
        IconButton(
            onClick = {
                val current = textValue.toLongOrNull() ?: baseValue
                val newValue = (current - step).coerceIn(min, max)
                textValue = newValue.toString()
                onValueChange(newValue)
                focusManager.clearFocus(force = true)
            },
            enabled = canDecrement,
            modifier = Modifier.size(36.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Remove,
                contentDescription = "Decrement",
                tint = if (canDecrement) {
                    MaterialTheme.colorScheme.primary
                } else {
                    MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
                }
            )
        }

        Spacer(modifier = Modifier.width(4.dp))

        // Compact input — Box uses IntrinsicSize.Min to shrink-wrap the text
        Box(
            modifier = Modifier
                .width(64.dp)
                .border(borderWidth, borderColor, RoundedCornerShape(4.dp))
                .padding(horizontal = 4.dp, vertical = 4.dp),
            contentAlignment = Alignment.Center
        ) {
            // Invisible measuring text — drives the Box width via IntrinsicSize.Min
            // Uses a minimum of "00" width so empty input isn't too tiny
            Text(
                text = textValue.ifEmpty { "00" },
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.drawBehind { /* invisible — only for measurement */ },
                color = Color.Transparent
            )

            BasicTextField(
                value = textValue,
                onValueChange = { newText ->
                    if (newText.isEmpty()) {
                        textValue = newText
                        return@BasicTextField
                    }

                    if (newText == "-" && min < 0) {
                        textValue = newText
                        return@BasicTextField
                    }

                    val parsed = newText.toLongOrNull() ?: return@BasicTextField
                    val clamped = parsed.coerceIn(min, max)
                    textValue = clamped.toString()
                    onValueChange(clamped)
                },
                enabled = isInteractive,
                singleLine = true,
                textStyle = MaterialTheme.typography.bodyLarge.copy(
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onSurface
                ),
                cursorBrush = SolidColor(MaterialTheme.colorScheme.primary),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier
                    .widthIn(min = 24.dp)
                    .onFocusChanged { focusState ->
                        isFocused = focusState.isFocused
                        if (!focusState.isFocused) {
                            val parsed = textValue.toLongOrNull()
                            if (parsed != null) {
                                val clamped = parsed.coerceIn(min, max)
                                textValue = clamped.toString()
                                onValueChange(clamped)
                            } else {
                                // Empty or invalid — reset to current value or empty
                                textValue = value?.toString() ?: ""
                            }
                        }
                    }
            )
        }

        Spacer(modifier = Modifier.width(4.dp))

        // Increment button
        IconButton(
            onClick = {
                val current = textValue.toLongOrNull() ?: baseValue
                val newValue = (current + step).coerceIn(min, max)
                textValue = newValue.toString()
                onValueChange(newValue)
                focusManager.clearFocus(force = true)
            },
            enabled = canIncrement,
            modifier = Modifier.size(36.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Increment",
                tint = if (canIncrement) {
                    MaterialTheme.colorScheme.primary
                } else {
                    MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
                }
            )
        }
    }
}
