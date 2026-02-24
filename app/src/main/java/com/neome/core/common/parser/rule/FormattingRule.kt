package com.neome.core.common.parser.rule

/**
 * Base class representing a text style that can be active during parsing.
 *
 * Mirrors the backend Java `Style` hierarchy:
 * - [Bold], [Italic], [Strikethrough], [Newline] are singletons (data objects).
 * - [Color] carries a color value string (named or hex).
 *
 * Built-in styles use data objects/classes for correct equals/hashCode
 * (critical for [LinkedHashSet] behavior).
 *
 * **Extensibility**: Subclass [Style] to define custom styles for use with
 * [FormattingRule]. Custom styles that aren't recognized by the built-in
 * [flushBuffer][com.neome.core.common.parser.RawTextParser] will be tracked
 * in the active style set but won't map to bold/italic/strikethrough/color.
 * Override [equals] and [hashCode] for correct set behavior.
 */
abstract class Style {
    data object Bold : Style()
    data object Italic : Style()
    data object Strikethrough : Style()
    data object Newline : Style()
    data class Color(val color: String) : Style()
}

/**
 * Represents an operation to apply at a specific text position.
 *
 * Mirrors the backend Java `StyleAction` class.
 *
 * @property operation  Whether to [ADD] or [REMOVE] the style.
 * @property style      The style to apply or remove.
 * @property charToSkip Number of additional characters to skip past this position.
 *                      For inline delimiters (*, _, ~): 0 (only the delimiter char is skipped).
 *                      For color open tag `[red]`: colorName.length + 1 (skips `red]`).
 *                      For color close tag `[/red]`: colorName.length + 2 (skips `/red]`).
 */
data class StyleAction(
    val operation: StyleOperation,
    val style: Style,
    val charToSkip: Int = 0
)

enum class StyleOperation {
    ADD,
    REMOVE
}

/**
 * Extension point for custom formatting rules.
 *
 * Implementations populate the action map with [StyleAction] entries at
 * specific text positions. The action map is then walked by the parser
 * to produce styled spans.
 *
 * Custom rules are applied AFTER all built-in rules. Since the action map
 * uses [HashMap] semantics (last writer wins), custom rules can override
 * built-in rules at the same position.
 *
 * ## Example
 *
 * ```kotlin
 * class MonospaceRule : FormattingRule {
 *     private val regex = Regex("(?<![a-zA-Z0-9])`(.*?\\S)`(?![a-zA-Z0-9])")
 *
 *     override fun populateActionMap(text: String, actionMap: MutableMap<Int, StyleAction>) {
 *         regex.findAll(text).forEach { match ->
 *             actionMap[match.range.first] = StyleAction(StyleOperation.ADD, MyMonospaceStyle)
 *             actionMap[match.range.last] = StyleAction(StyleOperation.REMOVE, MyMonospaceStyle)
 *         }
 *     }
 * }
 * ```
 */
interface FormattingRule {
    /**
     * Scan [text] for formatting patterns and add corresponding
     * [StyleAction] entries to [actionMap].
     *
     * Actions are keyed by character position. If multiple rules target
     * the same position, the last rule to write wins (HashMap overwrite).
     */
    fun populateActionMap(text: String, actionMap: MutableMap<Int, StyleAction>)
}
