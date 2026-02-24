package com.neome.feature.form.presentation.components.field

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.neome.api.meta.base.Types.EnumDefnErrorSeverity
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldErrorData
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueErrorData
import com.neome.feature.form.presentation.components.base.FieldBase
import com.neome.feature.form.presentation.components.base.rememberFieldController
import com.neome.feature.form.presentation.state.FieldEvent

/**
 * Error field component for form.
 *
 * Displays a red background box with error text and an optional close button.
 * The close button allows dismissing the error when defn.showCloseButton is true.
 *
 * FormCtx is accessed via LocalFormCtx.current inside rememberFieldController,
 * so this composable must be called inside a Form composable tree.
 *
 * @param defnComp Field definition containing field configuration
 * @param onFieldEvent Callback to emit field events to the form
 * @param modifier Modifier for customization
 */
@Composable
fun FieldError(
    defnComp: DefnCompSeal,
    onFieldEvent: (FieldEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    // Stable field controller remembered across recompositions
    val fieldController = rememberFieldController<FieldValueErrorData>(
        defnComp = defnComp,
        onFieldEvent = onFieldEvent
    )

    // Early return if field setup is invalid
    if (fieldController.fieldId == null) return

    // Read reactive field value (derivedStateOf provides fine-grained recomposition)
    val fieldValue = fieldController.value.value

    // Read reactive field properties and error
    val (properties, _) = fieldController.field.value

    // Early return if field is hidden
    if (properties.hidden) return

    // Only show error if errorReason exists
    val errorReason = fieldValue?.errorReason
    if (errorReason == null) return

    // Delegate to stateless content for optimal recomposition
    FieldBase(modifier = modifier, properties = properties) {
        FieldErrorContent(
            defn = defnComp as? DefnFieldErrorData,
            fieldValue = fieldValue,
            onDismiss = {
                fieldController.onChange(null)
            }
        )
    }
}

/**
 * Stateless error field content for optimal recomposition control.
 *
 * @param defn Field definition containing showCloseButton configuration
 * @param fieldValue Field value containing error information
 * @param onDismiss Callback when close button is clicked
 * @param modifier Modifier for customization
 */
@Composable
private fun FieldErrorContent(
    defn: DefnFieldErrorData?,
    fieldValue: FieldValueErrorData,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier
) {
    val showCloseButton = defn?.showCloseButton == true
    val backgroundColor = getBackgroundColor(fieldValue.severity)
    val resolvedErrorMessage = resolveError(
        fieldValue.errorReason,
        fieldValue.errorParameterSet ?: emptyList()
    )

    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(backgroundColor)
            .padding(start = 8.dp, top = 8.dp, bottom = 8.dp, end = 8.dp)
    ) {
        Text(
            text = resolvedErrorMessage,
            style = MaterialTheme.typography.bodyMedium,
            color = Color.White,
            modifier = Modifier.align(Alignment.CenterStart)
        )

        if (showCloseButton) {
            IconButton(
                onClick = onDismiss,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .size(24.dp)
            ) {
                Icon(
                    painter = painterResource(id = android.R.drawable.ic_menu_close_clear_cancel),
                    contentDescription = "Dismiss error",
                    tint = Color.White,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}

/**
 * Maps error severity to background color.
 *
 * @param severity The error severity level
 * @return Color representing the severity
 */
private fun getBackgroundColor(severity: EnumDefnErrorSeverity): Color {
    return when (severity) {
        EnumDefnErrorSeverity.error -> Color(0xFFDC2626) // Red
        EnumDefnErrorSeverity.suggestion -> Color(0xFF0EA5E9) // Light blue
        EnumDefnErrorSeverity.warning -> Color(0xFFF59E0B) // Amber
    }
}

/**
 * Resolves error message by replacing %s placeholders with provided parameters.
 *
 * @param message The error message with %s placeholders
 * @param params List of parameters to replace placeholders
 * @return Resolved error message
 */
private fun resolveError(message: String, params: List<String>): String {
    if (params.isEmpty()) return message

    val paramList = params.toMutableList()
    return message.replace(Regex("%s")) {
        if (paramList.isNotEmpty()) paramList.removeAt(0) else it.value
    }
}
