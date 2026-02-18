package com.neome.feature.form.presentation.components.field

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.neome.api.meta.base.Types.EnumDefnThemeButtonVariant
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldButtonData
import com.neome.feature.form.presentation.components.base.FieldBase
import com.neome.feature.form.presentation.components.base.rememberFieldController
import com.neome.feature.form.presentation.components.resolveThemeColor
import com.neome.feature.form.presentation.state.FieldEvent
import com.neome.feature.form.presentation.state.FieldProperties

/**
 * Button field component for form.
 *
 * Renders a button with four visual variants controlled by [FieldProperties.buttonVariant]:
 * - `"contained"` (default) — filled [Button] with optional [FieldProperties.bgColor]
 * - `"outlined"` — border-only [OutlinedButton]
 * - `"text"` — label-only [TextButton]
 * - `"icon"` — icon-only [IconButton] (no label, no border)
 *
 * The button is display-only (no stored value). It uses [rememberFieldController] for
 * consistent access to resolved [FieldProperties] (disabled, hidden, label, icon, etc.).
 *
 * FormCtx is accessed via LocalFormCtx.current inside [rememberFieldController],
 * so this composable must be called inside a Form composable tree.
 *
 * @param defnComp  Field definition — must be a [DefnFieldButtonData] for button-specific props
 * @param onFieldEvent Callback to emit field events (used by controller; button click is a no-op value event)
 * @param modifier  Modifier for customization
 */
@Composable
fun FieldButton(
    defnComp: DefnCompSeal,
    onFieldEvent: (FieldEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    // Use Unit? as the value type since buttons carry no stored value
    val fieldController = rememberFieldController<Unit?>(
        defnComp = defnComp,
        onFieldEvent = onFieldEvent
    )

    // Early return if field setup is invalid
    if (fieldController.fieldId == null) return

    val (properties, _) = fieldController.field.value

    // Early return if hidden
    if (properties.hidden) return

    FieldBase(modifier = modifier) {
        FieldButtonContent(properties = properties)
    }
}

/**
 * Stateless button content.
 *
 * Resolves variant, colors, icon, and layout alignment from [FieldProperties],
 * then dispatches to the appropriate Material3 button composable.
 *
 * @param properties Resolved field properties
 * @param modifier   Modifier for customization
 */
@Composable
internal fun FieldButtonContent(
    properties: FieldProperties,
    modifier: Modifier = Modifier
) {
    val variant = properties.buttonVariant ?: EnumDefnThemeButtonVariant.contained.value
    val label = properties.label ?: ""
    val isEnabled = !properties.disabled
    val iconVector = muiIconToImageVector(properties.icon)
    val textStyle = resolveTextStyle(properties.textSize)

    // Resolve horizontal alignment from buttonPosition
    val horizontalArrangement = when (properties.buttonPosition) {
        "start" -> Arrangement.Start
        "end" -> Arrangement.End
        "center" -> Arrangement.Center
        else -> Arrangement.Start   // default: start-aligned
    }

    // Icon is placed before or after the label based on iconPosition
    val iconAtEnd = properties.iconPosition == "end"

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = horizontalArrangement,
        verticalAlignment = Alignment.CenterVertically
    ) {
        when (variant) {
            EnumDefnThemeButtonVariant.icon.value -> {
                // Icon-only button — shows nothing if icon is not resolved
                if (iconVector != null) {
                    IconButton(
                        onClick = { /* action handled externally */ },
                        enabled = isEnabled
                    ) {
                        Icon(
                            imageVector = iconVector,
                            contentDescription = properties.toolTip ?: label
                        )
                    }
                }
            }

            EnumDefnThemeButtonVariant.text.value -> {
                TextButton(
                    onClick = { /* action handled externally */ },
                    enabled = isEnabled
                ) {
                    ButtonLabel(
                        label = label,
                        textStyle = textStyle,
                        iconVector = iconVector,
                        iconAtEnd = iconAtEnd,
                        toolTip = properties.toolTip
                    )
                }
            }

            EnumDefnThemeButtonVariant.outlined.value -> {
                OutlinedButton(
                    onClick = { /* action handled externally */ },
                    enabled = isEnabled
                ) {
                    ButtonLabel(
                        label = label,
                        textStyle = textStyle,
                        iconVector = iconVector,
                        iconAtEnd = iconAtEnd,
                        toolTip = properties.toolTip
                    )
                }
            }

            // "contained" is the default
            else -> {
                // Resolve custom background color if provided
                val bgColor: Color? = properties.bgColor?.let { resolveThemeColor(it) }

                val colors = if (bgColor != null) {
                    ButtonDefaults.buttonColors(containerColor = bgColor)
                } else {
                    ButtonDefaults.buttonColors()
                }

                Button(
                    onClick = { /* action handled externally */ },
                    enabled = isEnabled,
                    elevation = if (properties.disableElevation == true) {
                        ButtonDefaults.buttonElevation(
                            defaultElevation = 0.dp,
                            pressedElevation = 0.dp,
                            hoveredElevation = 0.dp
                        )
                    } else {
                        ButtonDefaults.buttonElevation()
                    },
                    colors = colors
                ) {
                    ButtonLabel(
                        label = label,
                        textStyle = textStyle,
                        iconVector = iconVector,
                        iconAtEnd = iconAtEnd,
                        toolTip = properties.toolTip
                    )
                }
            }
        }
    }
}

/**
 * Renders the button label with optional leading or trailing icon.
 *
 * @param label      Button text label
 * @param textStyle  Typography style for the label
 * @param iconVector Optional icon [ImageVector]; null means no icon shown
 * @param iconAtEnd  When true the icon appears after the label; otherwise before
 * @param toolTip    Content description for the icon (accessibility)
 */
@Composable
private fun ButtonLabel(
    label: String,
    textStyle: TextStyle,
    iconVector: androidx.compose.ui.graphics.vector.ImageVector?,
    iconAtEnd: Boolean,
    toolTip: String?
) {
    if (iconVector != null && !iconAtEnd) {
        Icon(
            imageVector = iconVector,
            contentDescription = toolTip ?: label,
            modifier = Modifier.size(18.dp)
        )
        if (label.isNotEmpty()) {
            Spacer(modifier = Modifier.width(6.dp))
        }
    }

    if (label.isNotEmpty()) {
        Text(text = label, style = textStyle)
    }

    if (iconVector != null && iconAtEnd) {
        if (label.isNotEmpty()) {
            Spacer(modifier = Modifier.width(6.dp))
        }
        Icon(
            imageVector = iconVector,
            contentDescription = toolTip ?: label,
            modifier = Modifier.size(18.dp)
        )
    }
}

/**
 * Maps an [EnumDefnTextSize] value string to a Compose [TextStyle].
 *
 * Falls back to [MaterialTheme.typography.labelLarge] (the standard button text style)
 * when the value is null or unmapped.
 *
 * @param textSizeValue  [EnumDefnTextSize.value] string (e.g., "body1", "h6", "caption")
 * @return Corresponding [TextStyle]
 */
@Composable
private fun resolveTextStyle(textSizeValue: String?): TextStyle {
    val typography = MaterialTheme.typography
    return when (textSizeValue) {
        "h1" -> typography.displayLarge
        "h2" -> typography.displayMedium
        "h3" -> typography.displaySmall
        "h4" -> typography.headlineLarge
        "h5" -> typography.headlineMedium
        "h6" -> typography.headlineSmall
        "subtitle1" -> typography.titleLarge
        "subtitle2" -> typography.titleMedium
        "subtitle3" -> typography.titleSmall
        "body1" -> typography.bodyLarge
        "body2" -> typography.bodyMedium
        "caption" -> typography.bodySmall
        "overline" -> typography.labelSmall
        "button" -> typography.labelLarge
        else -> typography.labelLarge   // default button text style
    }
}
