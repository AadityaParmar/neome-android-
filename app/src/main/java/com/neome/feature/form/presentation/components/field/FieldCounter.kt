package com.neome.feature.form.presentation.components.field

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp

import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldCounterData
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueNumberData
import com.neome.feature.form.presentation.components.base.FieldBase
import com.neome.feature.form.presentation.components.base.rememberFieldController
import com.neome.feature.form.presentation.state.FieldEvent

/**
 * Counter field component for form.
 *
 * Stateful wrapper that uses rememberFieldController for state management.
 * Delegates rendering to [RawCounter] for the counter UI controls.
 *
 * @param defnComp Field definition containing field configuration (must be DefnFieldCounterData)
 * @param onFieldEvent Callback to emit field events to the form
 * @param modifier Modifier for customization
 */
@Composable
fun FieldCounter(
    defnComp: DefnCompSeal,
    onFieldEvent: (FieldEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    val counterDefn = defnComp as? DefnFieldCounterData ?: return

    val fieldController = rememberFieldController<FieldValueNumberData>(
        defnComp = defnComp,
        onFieldEvent = onFieldEvent
    )

    if (fieldController.fieldId == null) return

    // Collect reactive field value separately for finer-grained recomposition
    val fieldValue = fieldController.value.value

    // Collect reactive field properties and error
    val (properties, error) = fieldController.field.value

    if (properties.hidden) return

    // Get current text value from FieldValueTextData
    val currentValue = fieldValue?.value

    val minValue = counterDefn.min ?: Long.MIN_VALUE
    val maxValue = counterDefn.max ?: Long.MAX_VALUE
    val stepValue = counterDefn.step ?: 1L
    val defaultValue = counterDefn.defaultValue ?: counterDefn.minDisplayValue ?: 0L
    val hideLabel = counterDefn.hideLabel == true

    FieldBase(modifier = modifier, properties = properties) {
        FieldCounterContent(
            value = currentValue,
            label = properties.label,
            helperText = properties.helperText,
            hideLabel = hideLabel,
            disabled = properties.disabled,
            readOnly = properties.readOnly,
            min = minValue,
            max = maxValue,
            step = stepValue,
            isError = error != null,
            errorMessage = error?.message,
            onValueChange = { newValue ->
                fieldController.onChange(if (newValue == null) null else FieldValueNumberData(newValue))
            }
        )
    }
}

/**
 * Stateless counter field content for optimal recomposition control.
 *
 * Renders label (optional), [RawCounter], and supporting text.
 */
@Composable
internal fun FieldCounterContent(
    value: Long?,
    label: String?,
    helperText: String?,
    hideLabel: Boolean,
    disabled: Boolean,
    readOnly: Boolean,
    min: Long,
    max: Long,
    step: Long,
    isError: Boolean,
    errorMessage: String?,
    onValueChange: (Long?) -> Unit,
    modifier: Modifier = Modifier
) {
    val focusManager = LocalFocusManager.current

    // Full-width clickable backdrop to clear focus when tapping outside controls
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = { focusManager.clearFocus(force = true) }
            )
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Label (if not hidden)
                if (!hideLabel && !label.isNullOrBlank()) {
                    Text(
                        text = label,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.padding(end = 8.dp)
                    )
                }

                // Counter controls
                RawCounter(
                    value = value,
                    onValueChange = onValueChange,
                    min = min,
                    max = max,
                    step = step,
                    enabled = !disabled,
                    readOnly = readOnly,
                    isError = isError
                )
            }

            // Supporting text (error or helper)
            val supportingMessage = errorMessage ?: helperText
            if (supportingMessage != null) {
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = supportingMessage,
                    style = MaterialTheme.typography.bodySmall,
                    color = if (isError) {
                        MaterialTheme.colorScheme.error
                    } else {
                        MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                    },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}
