package com.neome.feature.form.presentation.components.field

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldLogCounterData
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueNumberData
import com.neome.feature.form.presentation.components.base.FieldBase
import com.neome.feature.form.presentation.components.base.rememberFieldController
import com.neome.feature.form.presentation.state.FieldEvent

/**
 * Log counter field component for form.
 *
 * Extends counter behavior with log-specific features:
 * - hideInfo: hides supplementary info display
 * - logReadRoleSet: role-based read access control
 *
 * Reuses [FieldCounterContent] and [RawCounter] for the counter UI.
 * Additional log-specific features will be added here.
 *
 * @param defnComp Field definition (must be DefnFieldLogCounterData)
 * @param onFieldEvent Callback to emit field events to the form
 * @param modifier Modifier for customization
 */
@Composable
fun FieldLogCounter(
    defnComp: DefnCompSeal,
    onFieldEvent: (FieldEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    val logCounterDefn = defnComp as? DefnFieldLogCounterData ?: return

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

    val minValue = logCounterDefn.min ?: Long.MIN_VALUE
    val maxValue = logCounterDefn.max ?: Long.MAX_VALUE
    val stepValue = logCounterDefn.step ?: 1L
    val defaultValue = logCounterDefn.defaultValue ?: logCounterDefn.minDisplayValue ?: 0L
    val hideLabel = logCounterDefn.hideLabel == true

    // Log-specific properties (available for future use)
    // val hideInfo = logCounterDefn.hideInfo == true
    // val logReadRoleSet = logCounterDefn.logReadRoleSet

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
