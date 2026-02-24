package com.neome.feature.form.presentation.components.field

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.neome.api.meta.base.Types.EnumDefnPlacement
import com.neome.api.meta.base.Types.EnumDefnTextSize
import com.neome.api.meta.base.Types.EnumDefnThemeDividerKind
import com.neome.api.meta.base.dto.DefnFieldInfo
import com.neome.core.common.parser.ext.RawTextParserUi
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.core.common.serializer.api.meta.base.dto.DefnDtoColorData
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueTextData
import com.neome.feature.form.presentation.components.base.FieldBase
import com.neome.feature.form.presentation.components.base.rememberFieldController
import com.neome.feature.form.presentation.components.resolveThemeColor
import com.neome.feature.form.presentation.state.FieldEvent

/**
 * Info field component for form.
 *
 * Displays read-only formatted text inside an optional bordered box wrapper,
 * rendered through [RawTextParserUi]. Supports configurable padding, border,
 * background color, text styling, line count limitation, flex grow behaviour,
 * an optional label, and a conditional close button that hides the component.
 *
 * The definition type is [DefnFieldInfoData] and the field value type is
 * [FieldValueTextData].
 *
 * FormCtx is accessed via LocalFormCtx.current inside rememberFieldController,
 * so this composable must be called inside a Form composable tree.
 *
 * @param defnComp Field definition containing info field configuration
 * @param onFieldEvent Callback to emit field events to the form
 * @param modifier Modifier for customization
 */
@Composable
fun FieldInfo(
    defnComp: DefnCompSeal,
    onFieldEvent: (FieldEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    val fieldController = rememberFieldController<FieldValueTextData>(
        defnComp = defnComp,
        onFieldEvent = onFieldEvent
    )

    // Early return if field setup is invalid
    if (fieldController.fieldId == null) return

    // Read reactive field value
    val fieldValue = fieldController.value.value

    // Read reactive field properties and error
    val (properties, _) = fieldController.field.value

    // Early return if field is hidden
    if (properties.hidden) return

    // Cast to DefnFieldInfo to access info-specific properties
    val defn = defnComp as? DefnFieldInfo ?: return

    // Local visibility state — toggled by close button
    val isVisible = rememberSaveable { mutableStateOf(true) }

    // If the component has been dismissed via close button, don't render
    if (!isVisible.value) return

    // Resolve display text
    val textValue = fieldValue?.value
    val label = if (defn.showLabel == true) defn.label else null

    // If there is no label and no text, don't render anything
    if (label.isNullOrEmpty() && textValue.isNullOrEmpty()) return

    // Delegate to stateless content
    FieldBase(modifier = modifier, properties = properties) {
        FieldInfoContent(
            defn = defn,
            textValue = textValue,
            label = label,
            onDismiss = {
                isVisible.value = false
                fieldController.onChange(null)
            }
        )
    }
}

/**
 * Stateless info field content for optimal recomposition control.
 *
 * Renders an optional label above a bordered/padded box that contains
 * [RawTextParserUi] for formatted text display, with a conditional
 * close button positioned at the top-end corner.
 *
 * @param defn Info field definition with styling and behaviour config
 * @param textValue The raw text string to render
 * @param label Optional label to display above the info box
 * @param onDismiss Callback when the close button is clicked
 * @param modifier Modifier for customization
 */
@Composable
private fun FieldInfoContent(
    defn: DefnFieldInfo,
    textValue: String?,
    label: String?,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier
) {
    // ── Resolve definition properties ──────────────────────────────────

    val showCloseButton = defn.showCloseButton == true
    val showBorder = defn.showBorder == true
    val flexGrow = defn.flexGrow == true

    // Padding: prefer *Var over direct, fall back to pt/pb/pl/pr Long values
    val topPadding = resolveDividerPadding(defn.topPaddingVar ?: defn.topPadding)
        ?: resolveLongPadding(defn.pt)
    val bottomPadding = resolveDividerPadding(defn.bottomPaddingVar ?: defn.bottomPadding)
        ?: resolveLongPadding(defn.pb)
    val leftPadding = resolveDividerPadding(defn.leftPaddingVar ?: defn.leftPadding)
        ?: resolveLongPadding(defn.pl)
    val rightPadding = resolveDividerPadding(defn.rightPaddingVar ?: defn.rightPadding)
        ?: resolveLongPadding(defn.pr)

    // Line count: prefer lineCountVar over lineCount
    val lineCount = (defn.lineCountVar ?: defn.lineCount)?.toInt()

    // Text size / style
    val textSize = defn.textSizeVar ?: defn.textSize
    val justifyText = defn.justifyTextVar ?: defn.justifyText
    val bold = defn.boldVar ?: defn.bold ?: false
    val italic = defn.italicVar ?: defn.italic ?: false
    val underline = defn.underlineVar ?: defn.underline ?: false
    val strikeThrough = defn.strikeThroughVar ?: defn.strikeThrough ?: false
    val opacity = (defn.opacityVar ?: defn.opacity)?.toFloat() ?: 1f

    // Colors — bgColor is nullable so the wrapper can skip background when unset
    val bgColorData = (defn.bgColor ?: defn.bgColorVar) as? DefnDtoColorData
    val textColorData = defn.colorVar as? DefnDtoColorData
    val bgColor: Color? = if (bgColorData?.value != null) resolveThemeColor(bgColorData) else null
    val textColor = resolveThemeColor(textColorData)
    val borderColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)

    // Build text style from definition
    val baseStyle = resolveInfoTextStyle(textSize)
    val resolvedTextAlign = resolveTextAlign(justifyText)
    val textStyle = baseStyle.merge(
        TextStyle(
            color = textColor,
            fontWeight = if (bold) FontWeight.Bold else null,
            fontStyle = if (italic) FontStyle.Italic else null,
            textDecoration = buildTextDecoration(underline, strikeThrough),
            textAlign = resolvedTextAlign ?: TextAlign.Unspecified
        )
    )

    // maxLines: only constrain when not flexGrow
    val maxLines = if (!flexGrow && lineCount != null && lineCount > 0) lineCount else Int.MAX_VALUE

    // ── Layout ─────────────────────────────────────────────────────────

    Column(modifier = modifier.fillMaxWidth()) {
        // Optional label above the info box
        if (!label.isNullOrEmpty()) {
            Text(
                text = label,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(bottom = 4.dp)
            )
        }

        // Bordered wrapper box
        InfoBoxWrapper(
            showBorder = showBorder,
            showCloseButton = showCloseButton,
            flexGrow = flexGrow,
            bgColor = bgColor,
            borderColor = borderColor,
            topPadding = topPadding,
            bottomPadding = bottomPadding,
            leftPadding = leftPadding,
            rightPadding = rightPadding,
            opacity = opacity,
            onDismiss = onDismiss
        ) {
            if (!textValue.isNullOrEmpty()) {
                RawTextParserUi(
                    text = textValue,
                    style = textStyle,
                    maxLines = maxLines,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

/**
 * Box wrapper for the info field content.
 *
 * Applies optional border, background, padding, and hosts the close button
 * at the top-end position when enabled.
 *
 * @param showBorder Whether to draw a 1dp border
 * @param showCloseButton Whether to show the close/dismiss icon
 * @param flexGrow Whether the box should expand to fill available space
 * @param bgColor Background color for the box, null means no background
 * @param borderColor Border color when border is shown
 * @param topPadding Top padding inside the box
 * @param bottomPadding Bottom padding inside the box
 * @param leftPadding Left padding inside the box
 * @param rightPadding Right padding inside the box
 * @param opacity Opacity applied to the entire wrapper
 * @param onDismiss Callback when close button is clicked
 * @param content The composable content (RawTextParserUi)
 */
@Composable
private fun InfoBoxWrapper(
    showBorder: Boolean,
    showCloseButton: Boolean,
    flexGrow: Boolean,
    bgColor: Color?,
    borderColor: Color,
    topPadding: Dp,
    bottomPadding: Dp,
    leftPadding: Dp,
    rightPadding: Dp,
    opacity: Float,
    onDismiss: () -> Unit,
    content: @Composable () -> Unit
) {
    val shape = RoundedCornerShape(4.dp)

    // Extra end padding when close button is visible to avoid text overlap
    val effectiveEndPadding = if (showCloseButton) {
        maxOf(rightPadding, 32.dp)
    } else {
        rightPadding
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .alpha(opacity)
            .clip(shape)
            .then(
                if (showBorder) {
                    Modifier.border(
                        border = BorderStroke(1.dp, borderColor),
                        shape = shape
                    )
                } else {
                    Modifier
                }
            )
            .then(
                if (bgColor != null) {
                    Modifier.background(bgColor, shape)
                } else {
                    Modifier
                }
            )
            .padding(
                start = leftPadding,
                top = topPadding,
                end = effectiveEndPadding,
                bottom = bottomPadding
            )
    ) {
        // Text content
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterStart)
        ) {
            content()
        }

        // Close button — top-end position
        if (showCloseButton) {
            IconButton(
                onClick = onDismiss,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .size(24.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Dismiss info",
                    tint = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}

// ── Utility functions ──────────────────────────────────────────────────────

/**
 * Maps [EnumDefnThemeDividerKind] to a padding [Dp] value.
 *
 * - [EnumDefnThemeDividerKind.thin] → 1.dp
 * - [EnumDefnThemeDividerKind.thick] → 4.dp
 *
 * @return Resolved padding or null if input is null
 */
private fun resolveDividerPadding(kind: EnumDefnThemeDividerKind?): Dp? {
    return when (kind) {
        EnumDefnThemeDividerKind.thin -> 1.dp
        EnumDefnThemeDividerKind.thick -> 4.dp
        null -> null
    }
}

/**
 * Converts a nullable [Long] padding value to [Dp].
 * Falls back to 4.dp as a sensible default when null.
 *
 * @return Resolved padding
 */
private fun resolveLongPadding(value: Long?): Dp {
    return (value ?: 4L).toInt().dp
}

/**
 * Maps an [EnumDefnTextSize] to a Compose [TextStyle] using Material3 typography.
 *
 * Defaults to [MaterialTheme.typography.bodyMedium] when null or unmapped.
 */
@Composable
private fun resolveInfoTextStyle(textSize: EnumDefnTextSize?): TextStyle {
    val t = MaterialTheme.typography
    return when (textSize) {
        EnumDefnTextSize.h1 -> t.displayLarge
        EnumDefnTextSize.h2 -> t.displayMedium
        EnumDefnTextSize.h3 -> t.displaySmall
        EnumDefnTextSize.h4 -> t.headlineLarge
        EnumDefnTextSize.h5 -> t.headlineMedium
        EnumDefnTextSize.h6 -> t.headlineSmall
        EnumDefnTextSize.subtitle1 -> t.titleLarge
        EnumDefnTextSize.subtitle2 -> t.titleMedium
        EnumDefnTextSize.subtitle3 -> t.titleSmall
        EnumDefnTextSize.subtitle4 -> t.titleSmall
        EnumDefnTextSize.body1 -> t.bodyLarge
        EnumDefnTextSize.body2 -> t.bodyMedium
        EnumDefnTextSize.caption -> t.bodySmall
        EnumDefnTextSize.overline -> t.labelSmall
        EnumDefnTextSize.button -> t.labelLarge
        EnumDefnTextSize.inherit -> t.bodyMedium
        null -> t.bodyMedium
    }
}

/**
 * Builds a combined [TextDecoration] from underline and strikethrough flags.
 *
 * @return Combined decoration, or null if neither flag is set
 */
private fun buildTextDecoration(underline: Boolean, strikeThrough: Boolean): TextDecoration? {
    val decorations = buildList {
        if (underline) add(TextDecoration.Underline)
        if (strikeThrough) add(TextDecoration.LineThrough)
    }
    return if (decorations.isEmpty()) null else TextDecoration.combine(decorations)
}

/**
 * Maps [EnumDefnPlacement] to Compose [TextAlign].
 *
 * @return Resolved text alignment, or null for default behaviour
 */
private fun resolveTextAlign(placement: EnumDefnPlacement?): TextAlign? {
    return when (placement) {
        EnumDefnPlacement.start -> TextAlign.Start
        EnumDefnPlacement.center -> TextAlign.Center
        EnumDefnPlacement.end -> TextAlign.End
        EnumDefnPlacement.justify -> TextAlign.Justify
        else -> null
    }
}
