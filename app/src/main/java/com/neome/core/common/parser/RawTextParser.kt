package com.neome.core.common.parser

import com.neome.core.common.parser.model.ParsedText
import com.neome.core.common.parser.model.TextSpan
import com.neome.core.common.parser.rule.FormattingRule
import com.neome.core.common.parser.rule.Style
import com.neome.core.common.parser.rule.StyleAction
import com.neome.core.common.parser.rule.StyleOperation

/**
 * Configuration flags controlling which formatting features are active.
 *
 * All features enabled by default. Disable individual features to skip
 * their processing entirely.
 */
data class ParserConfig(
    val boldEnabled: Boolean = true,
    val italicEnabled: Boolean = true,
    val strikethroughEnabled: Boolean = true,
    val colorEnabled: Boolean = true,
    val newlineEnabled: Boolean = true,
    val escapeEnabled: Boolean = true,
    val linkEnabled: Boolean = true,
    val highlightedWords: List<String> = emptyList(),
    val hyperlinkColor: String = "#1976D2",
    val highlightColor: String = "#FFFF00"
)

/**
 * Main entry point for parsing formatted text.
 *
 * ## Algorithm — Regex Action-Map (Backend-Exact)
 *
 * This parser uses the **same algorithm** as the backend Java `MarkdownTextParser`:
 *
 * 1. **Build action map**: Run precompiled regex patterns over the input.
 *    Each match produces ADD/REMOVE [StyleAction] entries keyed by position.
 * 2. **Walk the text**: Iterate character by character. At each position,
 *    check the action map. If an action exists, flush the text buffer as
 *    a styled span, apply the style change, and skip delimiter characters.
 *    Otherwise, append the character to the buffer.
 *
 * This ensures **byte-for-byte output parity** with the backend for
 * all supported formatting: bold, italic, strikethrough, color tags,
 * and newlines.
 *
 * ## Android-Only Additions
 *
 * The following features are Android-specific and not present in the backend:
 * - **Escape sequences** (`\*`, `\_`, `\~`, `\[`, `\]`, `\\`)
 * - **URL link detection** (post-pass)
 * - **Word highlighting** (post-pass)
 * - **HTML angle bracket escaping** (`<` → `‹`, `>` → `›`)
 *
 * ## Pipeline
 *
 * ```
 * Input → Fast-path → HTML escape → Escape sequences → Build action map → Walk → Link pass → Highlight pass → Output
 * ```
 *
 * ## Thread Safety
 *
 * Immutable after construction. [parse] uses only local variables.
 */
class RawTextParser(
    private val config: ParserConfig = ParserConfig(),
    private val extraRules: List<FormattingRule> = emptyList()
) {

    /**
     * Parse a raw formatted string into [ParsedText].
     *
     * Returns [ParsedText.EMPTY] for null/empty input.
     */
    fun parse(text: String?): ParsedText {
        if (text.isNullOrEmpty()) return ParsedText.EMPTY

        // Fast-path: if no formatting markers exist, skip full pipeline
        if (canSkipParsing(text)) {
            return ParsedText(listOf(TextSpan.plain(escapeHtml(text))))
        }

        // Phase 1: Escape HTML angle brackets
        var processed = escapeHtml(text)

        // Phase 2: Apply escape sequences (Android-only)
        //          Replace \* with placeholders so regexes don't see them
        val hasEscapes = config.escapeEnabled && '\\' in processed
        if (hasEscapes) {
            processed = applyEscapePlaceholders(processed)
        }

        // Phase 3: Build action map (regex-based, backend-exact)
        val actionMap = buildActionMap(processed)

        // Phase 4: Walk text with action map → produce spans
        var spans = if (actionMap.isEmpty()) {
            listOf(TextSpan.plain(processed))
        } else {
            walkActionMap(processed, actionMap)
        }

        // Phase 5: Restore escape placeholders in span text
        if (hasEscapes) {
            spans = restoreEscapePlaceholders(spans)
        }

        // Phase 6: Link detection (Android-only post-pass)
        if (config.linkEnabled) {
            spans = applyLinkPass(spans)
        }

        // Phase 7: Word highlighting (Android-only post-pass)
        if (config.highlightedWords.isNotEmpty()) {
            spans = applyHighlightPass(spans, config.highlightedWords)
        }

        return ParsedText(spans)
    }

    // ── Fast-path ────────────────────────────────────────────────────────

    private fun canSkipParsing(text: String): Boolean {
        // Can't skip if extra rules are present — we don't know what they match
        if (extraRules.isNotEmpty()) return false

        val noInlineMarkers = (!config.boldEnabled || '*' !in text) &&
                (!config.italicEnabled || '_' !in text) &&
                (!config.strikethroughEnabled || '~' !in text) &&
                (!config.colorEnabled || ('[' !in text && ']' !in text)) &&
                (!config.newlineEnabled || ('\n' !in text && '\r' !in text)) &&
                (!config.escapeEnabled || '\\' !in text)

        val hasLinks = config.linkEnabled && (
                text.contains("http", ignoreCase = true) ||
                        text.contains("www", ignoreCase = true)
                )

        val hasHighlights = config.highlightedWords.isNotEmpty()

        return noInlineMarkers && !hasLinks && !hasHighlights
    }

    // ── HTML Escape ──────────────────────────────────────────────────────

    private fun escapeHtml(text: String): String {
        if ('<' !in text && '>' !in text) return text
        val sb = StringBuilder(text.length)
        for (c in text) {
            when (c) {
                '<' -> sb.append('\u2039')  // ‹
                '>' -> sb.append('\u203A')  // ›
                else -> sb.append(c)
            }
        }
        return sb.toString()
    }

    // ── Escape Sequences (Android-only) ──────────────────────────────────

    /**
     * Replace escape sequences with Unicode Private Use Area placeholders.
     * This prevents regexes from matching escaped characters.
     */
    private fun applyEscapePlaceholders(text: String): String {
        val sb = StringBuilder(text.length)
        var i = 0
        while (i < text.length) {
            if (text[i] == '\\' && i + 1 < text.length) {
                val placeholder = ESCAPE_PLACEHOLDERS[text[i + 1]]
                if (placeholder != null) {
                    sb.append(placeholder)
                    i += 2
                    continue
                }
            }
            sb.append(text[i])
            i++
        }
        return sb.toString()
    }

    /**
     * Restore placeholders back to original characters in all span texts.
     */
    private fun restoreEscapePlaceholders(spans: List<TextSpan>): List<TextSpan> {
        var anyChanged = false
        val result = spans.map { span ->
            val restored = restorePlaceholders(span.text)
            if (restored !== span.text) {
                anyChanged = true
                span.copy(text = restored)
            } else {
                span
            }
        }
        return if (anyChanged) result else spans
    }

    private fun restorePlaceholders(text: String): String {
        var hasPlaceholder = false
        for (c in text) {
            if (c in PLACEHOLDER_TO_CHAR) {
                hasPlaceholder = true
                break
            }
        }
        if (!hasPlaceholder) return text

        val sb = StringBuilder(text.length)
        for (c in text) {
            sb.append(PLACEHOLDER_TO_CHAR[c] ?: c)
        }
        return sb.toString()
    }

    // ── Action Map (Backend-Exact) ───────────────────────────────────────

    /**
     * Build the action map by running regex patterns in the same order
     * as the backend Java `prepareActionMap()`.
     *
     * Order: Bold → Italic → Strikethrough → Color (named) → Color (hex) → Newline → Extra rules.
     *
     * Uses [HashMap] semantics: if two patterns match at the same position,
     * the later pattern overwrites the earlier one. This matches the backend
     * behavior exactly.
     */
    private fun buildActionMap(text: String): Map<Int, StyleAction> {
        val map = HashMap<Int, StyleAction>()

        // Bold: (?<![a-zA-Z0-9])\*(.*?\S)\*(?![a-zA-Z0-9])
        if (config.boldEnabled) {
            BOLD_REGEX.findAll(text).forEach { match ->
                map[match.range.first] = StyleAction(StyleOperation.ADD, Style.Bold)
                map[match.range.last] = StyleAction(StyleOperation.REMOVE, Style.Bold)
            }
        }

        // Italic: (?<![a-zA-Z0-9])_(.*?\S)_(?![a-zA-Z0-9])
        if (config.italicEnabled) {
            ITALIC_REGEX.findAll(text).forEach { match ->
                map[match.range.first] = StyleAction(StyleOperation.ADD, Style.Italic)
                map[match.range.last] = StyleAction(StyleOperation.REMOVE, Style.Italic)
            }
        }

        // Strikethrough: (?<![a-zA-Z0-9])~(.*?\S)~(?![a-zA-Z0-9])
        if (config.strikethroughEnabled) {
            STRIKETHROUGH_REGEX.findAll(text).forEach { match ->
                map[match.range.first] = StyleAction(StyleOperation.ADD, Style.Strikethrough)
                map[match.range.last] = StyleAction(StyleOperation.REMOVE, Style.Strikethrough)
            }
        }

        // Color (named): \[(\w+)](.*?)\[/\1]
        if (config.colorEnabled) {
            COLOR_REGEX.findAll(text).forEach { match ->
                val colorName = match.groupValues[1]
                val colorStyle = Style.Color(colorName)
                val openSkip = colorName.length + 1    // skip "colorName]"
                val matchEnd = match.range.last + 1    // exclusive end
                val closePos = matchEnd - colorName.length - 3
                val closeSkip = colorName.length + 2   // skip "/colorName]"

                map[match.range.first] = StyleAction(StyleOperation.ADD, colorStyle, openSkip)
                map[closePos] = StyleAction(StyleOperation.REMOVE, colorStyle, closeSkip)
            }

            // Color (hex): \[(#[0-9a-fA-F]{6})](.*?)\[/\1]
            COLOR_HEX_REGEX.findAll(text).forEach { match ->
                val colorHex = match.groupValues[1]
                val colorStyle = Style.Color(colorHex)
                val openSkip = colorHex.length + 1     // skip "#rrggbb]"
                val matchEnd = match.range.last + 1    // exclusive end
                val closePos = matchEnd - colorHex.length - 3
                val closeSkip = colorHex.length + 2    // skip "/#rrggbb]"

                map[match.range.first] = StyleAction(StyleOperation.ADD, colorStyle, openSkip)
                map[closePos] = StyleAction(StyleOperation.REMOVE, colorStyle, closeSkip)
            }
        }

        // Newline: each \r and \n individually
        if (config.newlineEnabled) {
            NEWLINE_REGEX.findAll(text).forEach { match ->
                map[match.range.first] = StyleAction(StyleOperation.ADD, Style.Newline)
            }
        }

        // Extra rules (extensibility)
        for (rule in extraRules) {
            rule.populateActionMap(text, map)
        }

        return map
    }

    // ── Action Map Walker (Backend-Exact) ────────────────────────────────

    /**
     * Walk the text character by character using the action map.
     *
     * Exactly mirrors the backend Java `convertToHtmlText()` method:
     * - At each position, check for an action.
     * - If found: flush buffer, apply action, skip delimiter chars.
     * - If not found: append character to buffer.
     * - position++ always happens (even after charToSkip).
     *
     * Style tracking uses [LinkedHashSet] (insertion order) matching the
     * backend. When multiple colors are active, the **first** one wins
     * (iteration order of LinkedHashSet).
     */
    private fun walkActionMap(
        text: String,
        actionMap: Map<Int, StyleAction>
    ): List<TextSpan> {
        val spans = mutableListOf<TextSpan>()
        val buffer = StringBuilder(minOf(text.length, 256))
        val activeStyles = linkedSetOf<Style>()
        var pos = 0

        while (pos < text.length) {
            val action = actionMap[pos]

            if (action != null) {
                // Flush accumulated text
                flushBuffer(buffer, activeStyles, spans)

                if (action.style is Style.Newline) {
                    spans.add(TextSpan.newline())
                } else {
                    pos += action.charToSkip
                    applyStyleAction(action, activeStyles)
                }
                buffer.clear()
            } else {
                buffer.append(text[pos])
            }

            pos++
        }

        // Flush remaining text
        flushBuffer(buffer, activeStyles, spans)

        return spans
    }

    private fun applyStyleAction(action: StyleAction, activeStyles: MutableSet<Style>) {
        when (action.operation) {
            StyleOperation.ADD -> activeStyles.add(action.style)
            StyleOperation.REMOVE -> activeStyles.remove(action.style)
        }
    }

    /**
     * Convert buffer content to a [TextSpan] with styles from the active set.
     *
     * Matches backend `addSegment()`:
     * - Bold, Italic, Strikethrough flags set by presence in set.
     * - Color: **first** color found in iteration order wins
     *   (LinkedHashSet preserves insertion order).
     */
    private fun flushBuffer(
        buffer: StringBuilder,
        activeStyles: Set<Style>,
        spans: MutableList<TextSpan>
    ) {
        if (buffer.isEmpty()) return

        val text = buffer.toString()
        var bold = false
        var italic = false
        var strikethrough = false
        var color: String? = null

        for (style in activeStyles) {
            when (style) {
                is Style.Bold -> bold = true
                is Style.Italic -> italic = true
                is Style.Strikethrough -> strikethrough = true
                is Style.Color -> if (color == null) color = style.color
                is Style.Newline -> { /* handled separately in walkActionMap */ }
                else -> { /* custom styles: tracked in set but no built-in TextSpan mapping */ }
            }
            // Early exit: all flags set and color found
            if (bold && italic && strikethrough && color != null) break
        }

        spans.add(
            TextSpan(
                text = text,
                bold = bold,
                italic = italic,
                strikethrough = strikethrough,
                color = color
            )
        )
    }

    // ── Link Pass (Android-only) ─────────────────────────────────────────

    private fun applyLinkPass(spans: List<TextSpan>): List<TextSpan> {
        val result = mutableListOf<TextSpan>()
        var anyLinkFound = false

        for (span in spans) {
            if (span.isLink || span.isNewline) {
                result.add(span)
                continue
            }

            val text = span.text
            var lastIdx = 0
            var foundInSpan = false

            URL_REGEX.findAll(text).forEach { match ->
                foundInSpan = true
                anyLinkFound = true

                if (match.range.first > lastIdx) {
                    result.add(span.copy(text = text.substring(lastIdx, match.range.first)))
                }

                val displayText = match.value
                val linkUrl = if (HTTP_PREFIX_REGEX.containsMatchIn(displayText)) {
                    displayText
                } else {
                    "https://$displayText"
                }

                result.add(
                    span.copy(
                        text = displayText,
                        isLink = true,
                        linkUrl = linkUrl,
                        color = config.hyperlinkColor
                    )
                )

                lastIdx = match.range.last + 1
            }

            if (!foundInSpan) {
                result.add(span)
            } else if (lastIdx < text.length) {
                result.add(span.copy(text = text.substring(lastIdx)))
            }
        }

        return if (anyLinkFound) result else spans
    }

    // ── Highlight Pass (Android-only) ────────────────────────────────────

    private fun applyHighlightPass(
        spans: List<TextSpan>,
        words: List<String>
    ): List<TextSpan> {
        val filteredWords = words.filter { it.isNotBlank() }.sortedByDescending { it.length }
        if (filteredWords.isEmpty()) return spans

        val result = mutableListOf<TextSpan>()

        for (span in spans) {
            if (span.isNewline) {
                result.add(span)
                continue
            }

            val segments = splitByHighlights(span.text, filteredWords)
            for ((segText, isHighlight) in segments) {
                result.add(span.copy(text = segText, isHighlighted = isHighlight))
            }
        }

        return result
    }

    private fun splitByHighlights(
        text: String,
        words: List<String>
    ): List<Pair<String, Boolean>> {
        val textLower = text.lowercase()
        val marks = BooleanArray(text.length)

        for (word in words) {
            val wordLower = word.lowercase()
            var searchFrom = 0
            while (true) {
                val idx = textLower.indexOf(wordLower, searchFrom)
                if (idx < 0) break
                for (i in idx until minOf(idx + wordLower.length, text.length)) {
                    marks[i] = true
                }
                searchFrom = idx + 1
            }
        }

        val segments = mutableListOf<Pair<String, Boolean>>()
        var i = 0
        while (i < text.length) {
            val isHighlight = marks[i]
            val start = i
            while (i < text.length && marks[i] == isHighlight) i++
            segments.add(text.substring(start, i) to isHighlight)
        }

        return segments
    }

    // ── Constants ────────────────────────────────────────────────────────

    companion object {
        // ── Backend-exact regex patterns ──
        // These are identical to the Java backend MarkdownTextParser patterns.

        /** Bold: `*content*` with ASCII alphanumeric boundary checks. */
        private val BOLD_REGEX =
            Regex("""(?<![a-zA-Z0-9])\*(.*?\S)\*(?![a-zA-Z0-9])""")

        /** Italic: `_content_` with ASCII alphanumeric boundary checks. */
        private val ITALIC_REGEX =
            Regex("""(?<![a-zA-Z0-9])_(.*?\S)_(?![a-zA-Z0-9])""")

        /** Strikethrough: `~content~` with ASCII alphanumeric boundary checks. */
        private val STRIKETHROUGH_REGEX =
            Regex("""(?<![a-zA-Z0-9])~(.*?\S)~(?![a-zA-Z0-9])""")

        /** Color (named): `[colorName]content[/colorName]` where colorName is `\w+`. */
        private val COLOR_REGEX =
            Regex("""\[(\w+)](.*?)\[/\1]""")

        /** Color (hex): `[#RRGGBB]content[/#RRGGBB]`. */
        private val COLOR_HEX_REGEX =
            Regex("""\[(#[0-9a-fA-F]{6})](.*?)\[/\1]""")

        /** Newline: each `\r` and `\n` individually (backend-exact). */
        private val NEWLINE_REGEX =
            Regex("""[\r\n]""")

        // ── Android-only URL regex ──

        private val URL_REGEX = Regex(
            """(?:https?://|www\.)[a-zA-Z0-9][-a-zA-Z0-9@:%._+~#=]{0,256}\.[a-zA-Z0-9()]{1,6}[-a-zA-Z0-9()@:%_+.~#?&/=]*""",
            RegexOption.IGNORE_CASE
        )

        private val HTTP_PREFIX_REGEX = Regex("^https?://", RegexOption.IGNORE_CASE)

        // ── Escape sequence placeholders (Unicode Private Use Area) ──

        private val ESCAPE_PLACEHOLDERS = mapOf(
            '*' to '\uE001',
            '_' to '\uE002',
            '~' to '\uE003',
            '[' to '\uE004',
            ']' to '\uE005',
            '\\' to '\uE006'
        )

        private val PLACEHOLDER_TO_CHAR = mapOf(
            '\uE001' to '*',
            '\uE002' to '_',
            '\uE003' to '~',
            '\uE004' to '[',
            '\uE005' to ']',
            '\uE006' to '\\'
        )

        /** Shared default instance with all features enabled. */
        val Default = RawTextParser()
    }
}
