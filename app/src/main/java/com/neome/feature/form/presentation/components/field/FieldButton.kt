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
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.neome.api.meta.base.Types.EnumDefnThemeButtonVariant
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.feature.form.presentation.components.base.FieldBase
import com.neome.feature.form.presentation.components.base.rememberFieldController
import com.neome.feature.form.presentation.components.resolveThemeColor
import com.neome.feature.form.presentation.state.FieldEvent
import com.neome.feature.form.presentation.state.FieldProperties

/**
 * Button field component for form.
 *
 * Renders a button with four visual variants controlled by [FieldProperties.buttonVariant]:
 * - `"contained"` (default) — filled [Button]
 * - `"outlined"` — border-only [OutlinedButton]
 * - `"text"` — label-only [TextButton]
 * - `"icon"` — icon-only [IconButton] (no label, no border)
 *
 * [FieldProperties.bgColor] is applied to **all** variants as `containerColor`.
 * When a custom `bgColor` is set, `contentColor` is forced to [Color.White] so
 * the text/icon always contrasts against the custom background.
 *
 * The button carries no stored value. [rememberFieldController] is used solely
 * for consistent access to resolved [FieldProperties] (disabled, hidden, label, etc.).
 *
 * FormCtx is accessed via LocalFormCtx.current inside [rememberFieldController],
 * so this composable must be called inside a Form composable tree.
 *
 * @param defnComp     Field definition containing button configuration
 * @param onFieldEvent Callback to emit field events to the form
 * @param modifier     Modifier for customization
 */
@Composable
fun FieldButton(
    defnComp: DefnCompSeal,
    onFieldEvent: (FieldEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    // Buttons carry no stored value — Unit? as a no-op type
    val fieldController = rememberFieldController<Unit?>(
        defnComp = defnComp,
        onFieldEvent = onFieldEvent
    )

    val buttonId = fieldController.fieldId ?: return

    val (properties, _) = fieldController.field.value

    if (properties.hidden) return

    FieldBase(modifier = modifier, properties = properties) {
        FieldButtonContent(
            properties = properties,
            onClick = {
                onFieldEvent(FieldEvent.Click(buttonId))
            }
        )
    }
}

/**
 * Stateless button content.
 *
 * Resolves variant, bgColor, icon, alignment, and text style from [FieldProperties]
 * then renders the appropriate Material3 button composable.
 *
 * bgColor is applied to every variant. When set, [Color.White] is used as contentColor
 * so text/icons stay legible against custom backgrounds.
 *
 * @param properties Resolved field properties
 * @param onClick     Callback invoked when the button is clicked
 * @param modifier    Modifier for customization
 */
@Composable
internal fun FieldButtonContent(
    properties: FieldProperties,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val variant = properties.buttonVariant ?: EnumDefnThemeButtonVariant.contained.value
    val label = properties.label ?: ""
    val isEnabled = !properties.disabled
    val iconVector = muiIconToImageVector(properties.icon)
    val textStyle = resolveTextStyle(properties.textSize)
    val iconAtEnd = properties.iconPosition == "end"

    // Resolve bgColor once — null means "use the variant's default colour"
    val bgColor: Color? = properties.bgColor?.let { resolveThemeColor(it) }

    // Content colour: white when a custom bg is set, otherwise let the variant decide
    val contentColor: Color? = if (bgColor != null) Color.White else null

    val horizontalArrangement = when (properties.buttonPosition) {
        "start"  -> Arrangement.Start
        "end"    -> Arrangement.End
        "center" -> Arrangement.Center
        else     -> Arrangement.Start
    }

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = horizontalArrangement,
        verticalAlignment = Alignment.CenterVertically
    ) {
        when (variant) {

            // ── icon ────────────────────────────────────────────────────────────
            EnumDefnThemeButtonVariant.icon.value -> {
                if (iconVector != null) {
                    val colors = if (bgColor != null) {
                        IconButtonDefaults.iconButtonColors(
                            containerColor = bgColor,
                            contentColor   = contentColor ?: MaterialTheme.colorScheme.onSurface
                        )
                    } else {
                        IconButtonDefaults.iconButtonColors()
                    }
                    IconButton(
                        onClick = onClick,
                        enabled = isEnabled,
                        colors  = colors
                    ) {
                        Icon(imageVector = iconVector, contentDescription = label)
                    }
                }
            }

            // ── text ─────────────────────────────────────────────────────────────
            EnumDefnThemeButtonVariant.text.value -> {
                val colors = if (bgColor != null) {
                    ButtonDefaults.textButtonColors(
                        containerColor = bgColor,
                        contentColor   = contentColor ?: MaterialTheme.colorScheme.primary
                    )
                } else {
                    ButtonDefaults.textButtonColors()
                }
                TextButton(
                    onClick = onClick,
                    enabled = isEnabled,
                    colors  = colors
                ) {
                    ButtonLabel(label, textStyle, iconVector, iconAtEnd)
                }
            }

            // ── outlined ──────────────────────────────────────────────────────────
            EnumDefnThemeButtonVariant.outlined.value -> {
                val colors = if (bgColor != null) {
                    ButtonDefaults.outlinedButtonColors(
                        containerColor = bgColor,
                        contentColor   = contentColor ?: MaterialTheme.colorScheme.primary
                    )
                } else {
                    ButtonDefaults.outlinedButtonColors()
                }
                OutlinedButton(
                    onClick = onClick,
                    enabled = isEnabled,
                    colors  = colors
                ) {
                    ButtonLabel(label, textStyle, iconVector, iconAtEnd)
                }
            }

            // ── contained (default) ───────────────────────────────────────────────
            else -> {
                val colors = if (bgColor != null) {
                    ButtonDefaults.buttonColors(
                        containerColor = bgColor,
                        contentColor   = contentColor ?: MaterialTheme.colorScheme.onPrimary
                    )
                } else {
                    ButtonDefaults.buttonColors()
                }
                Button(
                    onClick = onClick,
                    enabled = isEnabled,
                    colors  = colors,
                    elevation = if (properties.disableElevation == true) {
                        ButtonDefaults.buttonElevation(
                            defaultElevation  = 0.dp,
                            pressedElevation  = 0.dp,
                            hoveredElevation  = 0.dp
                        )
                    } else {
                        ButtonDefaults.buttonElevation()
                    }
                ) {
                    ButtonLabel(label, textStyle, iconVector, iconAtEnd)
                }
            }
        }
    }
}

/**
 * Renders a button's label with optional leading or trailing icon.
 *
 * @param label      Button text; empty string means no text is rendered
 * @param textStyle  Typography style for the label text
 * @param iconVector Optional icon; null means no icon is shown
 * @param iconAtEnd  When `true` the icon appears after the label, otherwise before
 */
@Composable
private fun ButtonLabel(
    label: String,
    textStyle: TextStyle,
    iconVector: ImageVector?,
    iconAtEnd: Boolean
) {
    if (iconVector != null && !iconAtEnd) {
        Icon(
            imageVector        = iconVector,
            contentDescription = label,
            modifier           = Modifier.size(18.dp)
        )
        if (label.isNotEmpty()) Spacer(Modifier.width(6.dp))
    }

    if (label.isNotEmpty()) {
        Text(text = label, style = textStyle)
    }

    if (iconVector != null && iconAtEnd) {
        if (label.isNotEmpty()) Spacer(Modifier.width(6.dp))
        Icon(
            imageVector        = iconVector,
            contentDescription = label,
            modifier           = Modifier.size(18.dp)
        )
    }
}

/**
 * Maps an [com.neome.api.meta.base.Types.EnumDefnTextSize] value string to a Compose [TextStyle].
 *
 * Defaults to [MaterialTheme.typography.labelLarge] (standard button text) when the
 * value is null or unmapped.
 */
@Composable
private fun resolveTextStyle(textSizeValue: String?): TextStyle {
    val t = MaterialTheme.typography
    return when (textSizeValue) {
        "h1"        -> t.displayLarge
        "h2"        -> t.displayMedium
        "h3"        -> t.displaySmall
        "h4"        -> t.headlineLarge
        "h5"        -> t.headlineMedium
        "h6"        -> t.headlineSmall
        "subtitle1" -> t.titleLarge
        "subtitle2" -> t.titleMedium
        "subtitle3" -> t.titleSmall
        "body1"     -> t.bodyLarge
        "body2"     -> t.bodyMedium
        "caption"   -> t.bodySmall
        "overline"  -> t.labelSmall
        "button"    -> t.labelLarge
        else        -> t.labelLarge
    }
}
