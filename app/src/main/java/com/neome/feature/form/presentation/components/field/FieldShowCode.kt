package com.neome.feature.form.presentation.components.field

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.neome.api.meta.base.Types.EnumDefnCodeType
import com.neome.api.meta.base.dto.DefnFieldShowCode
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueTextData
import com.neome.feature.form.presentation.components.base.FieldBase
import com.neome.feature.form.presentation.components.base.rememberFieldController
import com.neome.feature.form.presentation.state.FieldEvent

/**
 * Show-code field component for form.
 *
 * Renders a QR code or barcode based on [DefnFieldShowCode.codeType].
 * The encoded value comes from the field value ([FieldValueTextData]).
 * An optional label is shown above the code when [DefnFieldShowCode.showLabel] is true.
 *
 * FormCtx is accessed via LocalFormCtx.current inside rememberFieldController,
 * so this composable must be called inside a Form composable tree.
 *
 * @param defnComp Field definition containing show-code configuration
 * @param onFieldEvent Callback to emit field events to the form
 * @param modifier Modifier for customization
 */
@Composable
fun FieldShowCode(
    defnComp: DefnCompSeal,
    onFieldEvent: (FieldEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    // Stable field controller remembered across recompositions
    val fieldController = rememberFieldController<FieldValueTextData>(
        defnComp = defnComp,
        onFieldEvent = onFieldEvent
    )

    // Early return if field setup is invalid
    if (fieldController.fieldId == null) return

    // Read reactive field value
    val fieldValue = fieldController.value.value

    // Read reactive field properties
    val (properties, _) = fieldController.field.value

    // Early return if field is hidden
    if (properties.hidden) return

    // Cast to DefnFieldShowCode to access show-code-specific properties
    val defn = defnComp as? DefnFieldShowCode ?: return

    // Resolve the value to encode — field value takes precedence over default
    val codeValue = fieldValue?.value ?: defn.defaultValue
    val codeType = defn.codeType
    val label = if (defn.showLabel == true) properties.label else null

    // Nothing to render if there is no value or code type
    if (codeValue.isNullOrBlank() || codeType == null) return

    // Delegate to stateless content
    FieldBase(modifier = modifier, properties = properties) {
        FieldShowCodeContent(
            value = codeValue,
            codeType = codeType,
            label = label
        )
    }
}

/**
 * Stateless show-code content for optimal recomposition control.
 *
 * Renders an optional label above the QR code or barcode produced by [RawShowCode].
 *
 * @param value The string to encode
 * @param codeType Whether to render a QR code or barcode
 * @param label Optional label displayed above the code
 * @param modifier Modifier for customization
 */
@Composable
private fun FieldShowCodeContent(
    value: String,
    codeType: EnumDefnCodeType,
    label: String?,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        // Optional label
        if (!label.isNullOrEmpty()) {
            Text(
                text = label,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(bottom = 4.dp)
            )
        }

        // QR code or barcode
        RawShowCode(
            value = value,
            codeType = codeType
        )
    }
}
