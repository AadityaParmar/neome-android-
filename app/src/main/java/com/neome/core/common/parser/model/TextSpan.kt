package com.neome.core.common.parser.model

/**
 * Represents a single styled segment of parsed text.
 *
 * Immutable value type — safe for caching, comparison, and snapshot-based UI.
 * The parser produces a list of these; the UI layer converts them to
 * platform-specific representations (AnnotatedString, Spannable, etc.).
 */
data class TextSpan(
    val text: String,
    val bold: Boolean = false,
    val italic: Boolean = false,
    val strikethrough: Boolean = false,
    val color: String? = null,           // Named color or "#RRGGBB"
    val isLink: Boolean = false,
    val linkUrl: String? = null,         // Normalized URL for navigation
    val isHighlighted: Boolean = false,
    val isNewline: Boolean = false       // Explicit newline separator
) {
    val hasFormatting: Boolean
        get() = bold || italic || strikethrough || color != null ||
                isLink || isHighlighted

    companion object {
        fun plain(text: String) = TextSpan(text = text)
        fun newline() = TextSpan(text = "\n", isNewline = true)
    }
}

/**
 * Result of a full parse operation. Wraps the span list and provides
 * convenience accessors.
 */
data class ParsedText(
    val spans: List<TextSpan>
) {
    val isEmpty: Boolean get() = spans.isEmpty()
    val plainText: String get() = spans.joinToString("") { it.text }

    companion object {
        val EMPTY = ParsedText(emptyList())
    }
}
