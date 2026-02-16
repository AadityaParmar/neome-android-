package com.neome.feature.form.presentation.components.field

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.neome.api.meta.base.Types.EnumDefnPlacement
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldSwitchData
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueEntUserIdData
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueLocationData
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueSwitchData
import com.neome.feature.form.domain.util.FieldPropertyResolver
import com.neome.feature.form.presentation.components.base.FieldBase
import com.neome.feature.form.presentation.components.base.rememberFieldController
import com.neome.feature.form.presentation.state.FieldEvent

/**
 * Switch (boolean) field component for form.
 *
 * Stateful wrapper that uses rememberFieldController for state management.
 * Renders as a Switch (default) or Checkbox depending on resolved properties.
 *
 * Capture metadata is displayed via [RawCaptureExtraProperties] between the
 * toggle row and helper text. Actual capture logic is deferred to a future
 * shared capture handler.
 *
 * @param defnComp Field definition containing field configuration (must be DefnFieldSwitchData)
 * @param onFieldEvent Callback to emit field events to the form
 * @param modifier Modifier for customization
 */
@Composable
fun FieldSwitch(
    defnComp: DefnCompSeal,
    onFieldEvent: (FieldEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    val switchDefn = defnComp as? DefnFieldSwitchData ?: return

    val fieldController = rememberFieldController<FieldValueSwitchData>(
        defnComp = defnComp,
        onFieldEvent = onFieldEvent
    )

    if (fieldController.fieldId == null) return

    // Read reactive field value (derivedStateOf provides fine-grained recomposition)
    val fieldValue = fieldController.value.value

    // Read reactive field properties and error
    val (properties, error) = fieldController.field.value

    if (properties.hidden) return

    val currentValue = fieldValue?.value ?: false

    // Render mode: resolved via FieldPropertyResolver.resolveShowAsCheckbox
    val showAsCheckbox = properties.showAsCheckbox == true

    // Checkbox label from variable (used only when rendered as checkbox)
    val checkboxLabel = FieldPropertyResolver.resolveArgValue(switchDefn.checkboxLabelVar)

    // Label placement: direct > var, fallback to null (default layout)
    val labelPlacement = switchDefn.labelPlacement ?: switchDefn.labelPlacementVar

    // Position: direct > var, fallback to null
    val position = switchDefn.position ?: switchDefn.positionVar

    // Capture enable flags from field definition
    val captureTimeEnabled = switchDefn.captureTime == true
    val captureUserEnabled = switchDefn.captureUser == true
    val captureLocationEnabled = switchDefn.captureLocation == true

    // Extract captured value strings from field value
    val captureTime = fieldValue?.captureTime
    val captureUser = fieldValue?.captureUser
    val captureLocation = fieldValue?.captureLocation
    val captureLocationLatLng = fieldValue?.captureLocation?.value?.geoPoint?.toString()

    FieldBase(modifier = modifier) {
        FieldSwitchContent(
            value = currentValue,
            label = properties.label,
            helperText = properties.helperText,
            disabled = properties.disabled,
            readOnly = properties.readOnly,
            isError = error != null,
            errorMessage = error?.message,
            showAsCheckbox = showAsCheckbox,
            checkboxLabel = checkboxLabel,
            labelPlacement = labelPlacement,
            position = position,
            captureTimeEnabled = captureTimeEnabled,
            captureUserEnabled = captureUserEnabled,
            captureLocationEnabled = captureLocationEnabled,
            captureTime = captureTime,
            captureUser = captureUser,
            captureLocation = captureLocation,
            captureLocationLatLng = captureLocationLatLng,
            showCapturedValues = switchDefn.showCapturedValuesOnAside,
            onValueChange = { newChecked ->
                // Preserve existing capture metadata when toggling value
                val updatedValue = fieldValue?.copy(value = newChecked)
                    ?: FieldValueSwitchData(value = newChecked)
                fieldController.onChange(updatedValue)
            }
        )
    }
}

/**
 * Stateless switch field content for optimal recomposition control.
 *
 * Layout:
 * [[Switch][Label]]
 * [RawCaptureExtraProperties]
 * [helperText]
 *
 * Default toggle layout: [Toggle START] [Label END]
 * Label placement can override via [labelPlacement].
 */
@Composable
internal fun FieldSwitchContent(
    value: Boolean,
    label: String?,
    helperText: String?,
    disabled: Boolean,
    readOnly: Boolean,
    isError: Boolean,
    errorMessage: String?,
    showAsCheckbox: Boolean,
    checkboxLabel: String?,
    labelPlacement: EnumDefnPlacement?,
    position: EnumDefnPlacement?,
    captureTimeEnabled: Boolean,
    captureUserEnabled: Boolean,
    captureLocationEnabled: Boolean,
    captureTime: String?,
    captureUser: FieldValueEntUserIdData?,
    captureLocation: FieldValueLocationData?,
    captureLocationLatLng: String?,
    showCapturedValues: List<com.neome.api.meta.base.Types.EnumDefnCaptureValueKind>?,
    onValueChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    val enabled = !disabled && !readOnly

    // Determine display label: checkbox mode uses checkboxLabel if available
    val displayLabel = if (showAsCheckbox) {
        checkboxLabel ?: label
    } else {
        label
    }

    // Resolve row arrangement from position
    val horizontalArrangement = when (position) {
        EnumDefnPlacement.center -> Arrangement.Center
        EnumDefnPlacement.end -> Arrangement.End
        EnumDefnPlacement.spaceBetween -> Arrangement.SpaceBetween
        else -> Arrangement.Start
    }

    // Whether label is placed before (start) the toggle
    val labelBeforeToggle = labelPlacement == EnumDefnPlacement.start

    Column(modifier = modifier.fillMaxWidth()) {
        // Toggle row
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = horizontalArrangement,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (labelBeforeToggle && !displayLabel.isNullOrBlank()) {
                FieldSwitchLabel(
                    text = displayLabel,
                    isError = isError
                )
                Spacer(modifier = Modifier.width(8.dp))
            }

            if (showAsCheckbox) {
                Checkbox(
                    checked = value,
                    onCheckedChange = if (enabled) onValueChange else null,
                    enabled = enabled
                )
            } else {
                Switch(
                    checked = value,
                    onCheckedChange = if (enabled) onValueChange else null,
                    enabled = enabled
                )
            }

            if (!labelBeforeToggle && !displayLabel.isNullOrBlank()) {
                Spacer(modifier = Modifier.width(8.dp))
                FieldSwitchLabel(
                    text = displayLabel,
                    isError = isError
                )
            }
        }

        // Capture metadata rows
        val hasCaptureEnabled = captureTimeEnabled || captureUserEnabled || captureLocationEnabled
        if (hasCaptureEnabled) {
            Spacer(modifier = Modifier.height(2.dp))
            RawCaptureExtraProperties(
                captureTime = captureTime,
                captureUser = captureUser,
                captureLocation = captureLocation,
                captureLocationError = null,   // Future: from capture handler
                captureLocationStatus = null,  // Future: from capture handler
                showCapturedValues = showCapturedValues,
                captureLocationLatLng = captureLocationLatLng,
                onRetryLocation = { },         // Future: capture handler callback
                onOpenLocationInMap = { }      // Future: maps intent callback
            )
        }

        // Supporting text (error or helper)
        if (isError || !helperText.isNullOrBlank()) {
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = errorMessage ?: helperText ?: "",
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

/**
 * Label text for the switch/checkbox toggle.
 */
@Composable
private fun FieldSwitchLabel(
    text: String,
    isError: Boolean,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        style = MaterialTheme.typography.bodyMedium,
        color = if (isError) {
            MaterialTheme.colorScheme.error
        } else {
            MaterialTheme.colorScheme.onSurface
        },
        modifier = modifier
    )
}
