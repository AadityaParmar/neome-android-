package com.neome.core.common.parser.ext

import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.TextStyle
import com.neome.core.common.parser.ParserConfig
import com.neome.core.common.parser.RawTextParser

/**
 * Composable that renders formatted text using [RawTextParser].
 *
 * Supports bold, italic, strikethrough, color tags, links, highlights,
 * and newlines. Links are clickable and open in the default browser.
 *
 * @param text             Raw formatted string to parse and display.
 * @param modifier         Compose modifier.
 * @param config           Parser configuration (toggle features, set colors).
 * @param style            Base text style.
 * @param highlightColor   Background color for highlighted words.
 * @param onLinkClick      Optional callback for link clicks. If null,
 *                         links open via [LocalUriHandler].
 */
@Composable
fun RawTextParserUi(
    text: String?,
    modifier: Modifier = Modifier,
    config: ParserConfig = ParserConfig(),
    style: TextStyle = MaterialTheme.typography.bodyMedium,
    highlightColor: Color = Color.Yellow,
    onLinkClick: ((url: String) -> Unit)? = null
) {
    if (text.isNullOrEmpty()) return

    val parser = remember(config) { RawTextParser(config) }
    val parsed = remember(text, config) { parser.parse(text) }

    if (parsed.isEmpty) return

    val annotatedString = remember(parsed, highlightColor) {
        parsed.toAnnotatedString(highlightColor)
    }

    val uriHandler = LocalUriHandler.current

    ClickableText(
        text = annotatedString,
        modifier = modifier,
        style = style,
        onClick = { offset ->
            annotatedString.getStringAnnotations(
                tag = LINK_ANNOTATION_TAG,
                start = offset,
                end = offset
            ).firstOrNull()?.let { annotation ->
                if (onLinkClick != null) {
                    onLinkClick(annotation.item)
                } else {
                    try {
                        uriHandler.openUri(annotation.item)
                    } catch (_: Exception) {
                        // Silently ignore invalid URIs
                    }
                }
            }
        }
    )
}
