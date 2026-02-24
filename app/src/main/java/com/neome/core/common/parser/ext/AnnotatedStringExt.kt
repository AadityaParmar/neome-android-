package com.neome.core.common.parser.ext

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import com.neome.core.common.parser.model.ParsedText
import com.neome.core.common.parser.model.TextSpan

/**
 * Annotation tag used for clickable link spans.
 * Use with [AnnotatedString.getStringAnnotations] to retrieve the URL.
 */
const val LINK_ANNOTATION_TAG = "URL"

/**
 * Converts [ParsedText] to a Compose [AnnotatedString].
 *
 * ## Link Handling
 *
 * Links are annotated with tag [LINK_ANNOTATION_TAG] and the URL as the
 * annotation value. Handle clicks using:
 *
 * ```kotlin
 * ClickableText(text = annotatedString) { offset ->
 *     annotatedString.getStringAnnotations(LINK_ANNOTATION_TAG, offset, offset)
 *         .firstOrNull()?.let { annotation ->
 *             // Open annotation.item as URL
 *         }
 * }
 * ```
 *
 * @param highlightColor Background color for highlighted words.
 *   Defaults to yellow.
 */
fun ParsedText.toAnnotatedString(
    highlightColor: Color = Color.Yellow
): AnnotatedString = buildAnnotatedString {
    for (span in spans) {
        val style = span.toSpanStyle(highlightColor)

        if (span.isLink && span.linkUrl != null) {
            pushStringAnnotation(tag = LINK_ANNOTATION_TAG, annotation = span.linkUrl)
            withStyle(style) { append(span.text) }
            pop()
        } else {
            withStyle(style) { append(span.text) }
        }
    }
}

/**
 * Converts a single [TextSpan] to a Compose [SpanStyle].
 */
fun TextSpan.toSpanStyle(highlightColor: Color = Color.Yellow): SpanStyle {
    var fontWeight: FontWeight? = null
    var fontStyle: FontStyle? = null
    var textDecoration: TextDecoration? = null
    var textColor: Color = Color.Unspecified
    var bgColor: Color = Color.Unspecified

    if (bold) fontWeight = FontWeight.Bold
    if (italic) fontStyle = FontStyle.Italic

    if (strikethrough && isLink) {
        textDecoration = TextDecoration.combine(
            listOf(TextDecoration.LineThrough, TextDecoration.Underline)
        )
    } else if (strikethrough) {
        textDecoration = TextDecoration.LineThrough
    } else if (isLink) {
        textDecoration = TextDecoration.Underline
    }

    if (color != null) {
        textColor = parseColor(color)
    }

    if (isHighlighted) {
        bgColor = highlightColor
    }

    return SpanStyle(
        fontWeight = fontWeight,
        fontStyle = fontStyle,
        textDecoration = textDecoration,
        color = if (textColor != Color.Unspecified) textColor else Color.Unspecified,
        background = if (bgColor != Color.Unspecified) bgColor else Color.Unspecified
    )
}

/**
 * Parses a color string to Compose [Color].
 *
 * Supports:
 * - Hex: `#RRGGBB` or `#AARRGGBB`
 * - Named colors: common web color names
 *
 * Returns [Color.Unspecified] if parsing fails.
 */
internal fun parseColor(value: String): Color {
    // Hex color
    if (value.startsWith('#')) {
        return try {
            val hex = value.removePrefix("#")
            when (hex.length) {
                6 -> Color(("FF$hex").toLong(16))
                8 -> Color(hex.toLong(16))
                else -> Color.Unspecified
            }
        } catch (_: NumberFormatException) {
            Color.Unspecified
        }
    }

    // Named colors (common subset)
    return NAMED_COLORS[value.lowercase()] ?: Color.Unspecified
}

/**
 * Map of common named colors. Extend as needed.
 */
private val NAMED_COLORS = mapOf(
    "red" to Color(0xFFFF0000),
    "green" to Color(0xFF008000),
    "blue" to Color(0xFF0000FF),
    "yellow" to Color(0xFFFFFF00),
    "orange" to Color(0xFFFFA500),
    "purple" to Color(0xFF800080),
    "pink" to Color(0xFFFFC0CB),
    "brown" to Color(0xFFA52A2A),
    "black" to Color(0xFF000000),
    "white" to Color(0xFFFFFFFF),
    "gray" to Color(0xFF808080),
    "grey" to Color(0xFF808080),
    "cyan" to Color(0xFF00FFFF),
    "magenta" to Color(0xFFFF00FF),
    "lime" to Color(0xFF00FF00),
    "navy" to Color(0xFF000080),
    "teal" to Color(0xFF008080),
    "maroon" to Color(0xFF800000),
    "olive" to Color(0xFF808000),
    "coral" to Color(0xFFFF7F50),
    "salmon" to Color(0xFFFA8072),
    "gold" to Color(0xFFFFD700),
    "silver" to Color(0xFFC0C0C0),
    "indigo" to Color(0xFF4B0082),
    "violet" to Color(0xFFEE82EE)
)
