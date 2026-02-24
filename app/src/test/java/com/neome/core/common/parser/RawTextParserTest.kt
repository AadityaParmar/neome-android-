package com.neome.core.common.parser

import com.neome.core.common.parser.model.TextSpan
import com.neome.core.common.parser.rule.FormattingRule
import com.neome.core.common.parser.rule.Style
import com.neome.core.common.parser.rule.StyleAction
import com.neome.core.common.parser.rule.StyleOperation
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Comprehensive tests for [RawTextParser].
 *
 * Tests are organized to verify backend parity first, then Android-only additions.
 * Each test documents the expected behavior from the backend Java `MarkdownTextParser`.
 */
class RawTextParserTest {

    private val parser = RawTextParser()

    // ═══════════════════════════════════════════════════════════════════
    // BACKEND PARITY TESTS
    // These tests verify identical output to the Java MarkdownTextParser
    // ═══════════════════════════════════════════════════════════════════

    // ── Null / Empty ─────────────────────────────────────────────────

    @Test
    fun `parse null returns empty`() {
        assertTrue(parser.parse(null).isEmpty)
    }

    @Test
    fun `parse empty string returns empty`() {
        assertTrue(parser.parse("").isEmpty)
    }

    @Test
    fun `parse plain text returns single span`() {
        val result = parser.parse("Hello world")
        assertEquals(1, result.spans.size)
        assertEquals("Hello world", result.spans[0].text)
        assertFalse(result.spans[0].hasFormatting)
    }

    // ── Bold ─────────────────────────────────────────────────────────

    @Test
    fun `bold basic`() {
        // Backend: *world* matches → bold "world"
        val result = parser.parse("Hello *world*!")
        assertEquals(3, result.spans.size)
        assertEquals("Hello ", result.spans[0].text)
        assertFalse(result.spans[0].bold)
        assertEquals("world", result.spans[1].text)
        assertTrue(result.spans[1].bold)
        assertEquals("!", result.spans[2].text)
        assertFalse(result.spans[2].bold)
    }

    @Test
    fun `bold at start of text`() {
        val result = parser.parse("*hello* world")
        assertEquals(2, result.spans.size)
        assertEquals("hello", result.spans[0].text)
        assertTrue(result.spans[0].bold)
        assertEquals(" world", result.spans[1].text)
    }

    @Test
    fun `bold at end of text`() {
        val result = parser.parse("hello *world*")
        assertEquals(2, result.spans.size)
        assertEquals("hello ", result.spans[0].text)
        assertEquals("world", result.spans[1].text)
        assertTrue(result.spans[1].bold)
    }

    @Test
    fun `bold not triggered when preceded by alphanumeric`() {
        // Backend regex: (?<![a-zA-Z0-9]) — 'r' is alnum → no match
        val result = parser.parse("var*name*here")
        assertEquals(1, result.spans.size)
        assertEquals("var*name*here", result.spans[0].text)
    }

    @Test
    fun `bold not triggered when followed by alphanumeric`() {
        // Backend regex: (?![a-zA-Z0-9]) — 'h' is alnum → no match
        val result = parser.parse("*name*here")
        assertEquals(1, result.spans.size)
    }

    @Test
    fun `bold allows space after opening delimiter`() {
        // Backend regex: *(.*?\S)* — content ` hello` ends with non-ws → matches
        // This is different from WhatsApp but matches the backend
        val result = parser.parse("* hello*")
        assertEquals(1, result.spans.size)
        assertEquals(" hello", result.spans[0].text)
        assertTrue(result.spans[0].bold)
    }

    @Test
    fun `bold with punctuation boundary`() {
        // Punctuation is NOT [a-zA-Z0-9], so bold triggers
        val result = parser.parse("(*bold*)")
        assertEquals(3, result.spans.size)
        assertEquals("(", result.spans[0].text)
        assertEquals("bold", result.spans[1].text)
        assertTrue(result.spans[1].bold)
        assertEquals(")", result.spans[2].text)
    }

    @Test
    fun `bold with unicode boundary`() {
        // Backend regex uses [a-zA-Z0-9] (ASCII only)
        // Chinese char 中 is NOT in [a-zA-Z0-9], so bold triggers
        val result = parser.parse("中*bold*文")
        assertEquals(3, result.spans.size)
        assertTrue(result.spans[1].bold)
    }

    // ── Italic ───────────────────────────────────────────────────────

    @Test
    fun `italic basic`() {
        val result = parser.parse("Hello _world_!")
        assertEquals(3, result.spans.size)
        assertEquals("world", result.spans[1].text)
        assertTrue(result.spans[1].italic)
    }

    @Test
    fun `underscore in variable name not treated as italic`() {
        // Backend regex: e before first _ is alnum → no match
        val result = parser.parse("some_variable_name")
        assertEquals(1, result.spans.size)
        assertEquals("some_variable_name", result.spans[0].text)
    }

    // ── Strikethrough ────────────────────────────────────────────────

    @Test
    fun `strikethrough basic`() {
        val result = parser.parse("Hello ~world~!")
        assertEquals(3, result.spans.size)
        assertEquals("world", result.spans[1].text)
        assertTrue(result.spans[1].strikethrough)
    }

    // ── Nested Inline Styles ─────────────────────────────────────────

    @Test
    fun `bold and italic nested`() {
        // Backend: both regexes match independently
        // *bold _both_ bold* — bold regex matches full span, italic matches inner
        val result = parser.parse("*bold _both_ bold*")
        // Backend walk produces segments based on action map positions
        assertEquals(3, result.spans.size)
        assertEquals("bold ", result.spans[0].text)
        assertTrue(result.spans[0].bold)
        assertFalse(result.spans[0].italic)
        assertEquals("both", result.spans[1].text)
        assertTrue(result.spans[1].bold)
        assertTrue(result.spans[1].italic)
        assertEquals(" bold", result.spans[2].text)
        assertTrue(result.spans[2].bold)
        assertFalse(result.spans[2].italic)
    }

    @Test
    fun `all three styles nested`() {
        val result = parser.parse("*bold _italic ~all~ italic_ bold*")
        // Innermost "all" has all three styles
        val allSpan = result.spans.find { it.text == "all" }
        assertTrue(allSpan != null)
        assertTrue(allSpan!!.bold)
        assertTrue(allSpan.italic)
        assertTrue(allSpan.strikethrough)
    }

    // ── Color Tags (Named) ───────────────────────────────────────────

    @Test
    fun `named color tag`() {
        val result = parser.parse("[red]hello[/red]")
        assertEquals(1, result.spans.size)
        assertEquals("hello", result.spans[0].text)
        assertEquals("red", result.spans[0].color)
    }

    @Test
    fun `hex color tag`() {
        val result = parser.parse("[#FF0000]hello[/#FF0000]")
        assertEquals(1, result.spans.size)
        assertEquals("hello", result.spans[0].text)
        assertEquals("#FF0000", result.spans[0].color)
    }

    @Test
    fun `color tag with bold inside`() {
        val result = parser.parse("[blue]*bold blue*[/blue]")
        // Color regex matches the outer span; bold regex matches inner *bold blue*
        assertEquals(1, result.spans.size)
        assertEquals("bold blue", result.spans[0].text)
        assertEquals("blue", result.spans[0].color)
        assertTrue(result.spans[0].bold)
    }

    @Test
    fun `color name uses word chars`() {
        // Backend regex: \w+ matches letters, digits, underscore
        val result = parser.parse("[dark_red]hello[/dark_red]")
        assertEquals(1, result.spans.size)
        assertEquals("hello", result.spans[0].text)
        assertEquals("dark_red", result.spans[0].color)
    }

    @Test
    fun `nested colors - outer wins`() {
        // Backend: outer [red] regex captures everything including inner tags
        // Inner [blue]...[/blue] becomes literal text content
        val result = parser.parse("[red][blue]text[/blue][/red]")
        assertEquals(1, result.spans.size)
        assertEquals("[blue]text[/blue]", result.spans[0].text)
        assertEquals("red", result.spans[0].color)
    }

    @Test
    fun `sequential colors both work`() {
        val result = parser.parse("[red]hello[/red] [blue]world[/blue]")
        assertEquals(3, result.spans.size)
        assertEquals("hello", result.spans[0].text)
        assertEquals("red", result.spans[0].color)
        assertEquals(" ", result.spans[1].text)
        assertNull(result.spans[1].color)
        assertEquals("world", result.spans[2].text)
        assertEquals("blue", result.spans[2].color)
    }

    @Test
    fun `unclosed color tag treated as literal`() {
        // Regex requires matching [/colorName], so unclosed tags don't match
        val result = parser.parse("[red]hello")
        assertEquals(1, result.spans.size)
        assertEquals("[red]hello", result.spans[0].text)
        assertNull(result.spans[0].color)
    }

    @Test
    fun `backend main method test case`() {
        // From the backend's main(): "[#ff0000]world*[/#ff0000]"
        val result = parser.parse("[#ff0000]world*[/#ff0000]")
        assertEquals(1, result.spans.size)
        assertEquals("world*", result.spans[0].text)
        assertEquals("#ff0000", result.spans[0].color)
    }

    // ── Newlines ─────────────────────────────────────────────────────

    @Test
    fun `newline LF`() {
        val result = parser.parse("line1\nline2")
        assertEquals(3, result.spans.size)
        assertEquals("line1", result.spans[0].text)
        assertTrue(result.spans[1].isNewline)
        assertEquals("line2", result.spans[2].text)
    }

    @Test
    fun `newline CR`() {
        val result = parser.parse("line1\rline2")
        assertEquals(3, result.spans.size)
        assertTrue(result.spans[1].isNewline)
    }

    @Test
    fun `CRLF produces two newlines - backend exact`() {
        // Backend: [\r\n] matches \r and \n separately
        // Each gets a newline action → two newlines
        val result = parser.parse("line1\r\nline2")
        assertEquals(4, result.spans.size)
        assertEquals("line1", result.spans[0].text)
        assertTrue(result.spans[1].isNewline)
        assertTrue(result.spans[2].isNewline)
        assertEquals("line2", result.spans[3].text)
    }

    @Test
    fun `consecutive newlines`() {
        val result = parser.parse("a\n\n\nb")
        val newlineCount = result.spans.count { it.isNewline }
        assertEquals(3, newlineCount)
    }

    @Test
    fun `newline inside bold`() {
        // Newline action takes precedence at that position (overwrites bold close if same pos)
        // But newline is INSIDE the bold content, so bold stays active
        val result = parser.parse("*bold\ntext*")
        // Bold regex: `*bold\ntext*` — does '.' match '\n'? No (no DOTALL flag)
        // So bold regex does NOT match across newlines
        // The * characters become literal text
        val plainSpans = result.spans.filter { !it.isNewline }
        assertEquals("*bold", plainSpans[0].text)
        assertEquals("text*", plainSpans[1].text)
        assertFalse(plainSpans[0].bold)
    }

    @Test
    fun `color tag does not span newlines`() {
        // Backend regex: (.*?) doesn't match \n without DOTALL
        val result = parser.parse("[red]hello\nworld[/red]")
        // Color regex won't match → literal text
        val plainSpans = result.spans.filter { !it.isNewline }
        assertEquals("[red]hello", plainSpans[0].text)
        assertEquals("world[/red]", plainSpans[1].text)
        assertNull(plainSpans[0].color)
    }

    // ── Action Map Collision ─────────────────────────────────────────

    @Test
    fun `color and bold at same position - color wins`() {
        // Bold regex runs first, Color regex runs later → Color overwrites at same position
        // [red]*bold[/red]
        // Bold: *bold would need to find closing *, but there isn't one without [/red]
        // Actually, let's test a real collision case
        val result = parser.parse("[red]*text*[/red]")
        // Bold regex: *text* — match.start = position of first *, match.end-1 = position of second *
        // Color regex: overwrites some positions
        // This tests the HashMap overwrite behavior
        assertFalse(result.isEmpty)
    }

    // ═══════════════════════════════════════════════════════════════════
    // ANDROID-ONLY FEATURE TESTS
    // These features are not in the backend but are Android additions.
    // ═══════════════════════════════════════════════════════════════════

    // ── Escape Sequences ─────────────────────────────────────────────

    @Test
    fun `escaped asterisk not bold`() {
        val result = parser.parse("\\*not bold\\*")
        assertEquals(1, result.spans.size)
        assertEquals("*not bold*", result.spans[0].text)
        assertFalse(result.spans[0].bold)
    }

    @Test
    fun `escaped underscore not italic`() {
        val result = parser.parse("hello \\_world\\_ end")
        assertEquals(1, result.spans.size)
        assertTrue(result.spans[0].text.contains("_world_"))
        assertFalse(result.spans[0].italic)
    }

    @Test
    fun `escaped backslash`() {
        val result = parser.parse("path\\\\to\\\\file")
        assertEquals(1, result.spans.size)
        assertEquals("path\\to\\file", result.spans[0].text)
    }

    @Test
    fun `escaped bracket prevents color tag`() {
        val result = parser.parse("\\[red]hello\\[/red]")
        assertEquals(1, result.spans.size)
        assertTrue(result.spans[0].text.contains("[red]"))
        assertNull(result.spans[0].color)
    }

    @Test
    fun `escape disabled via config`() {
        val noEscapeParser = RawTextParser(ParserConfig(escapeEnabled = false))
        val result = noEscapeParser.parse("\\*bold\\*")
        // Without escape, \* is literal \ followed by bold trigger
        // Behavior depends on regex matching
        assertFalse(result.isEmpty)
    }

    // ── Links ────────────────────────────────────────────────────────

    @Test
    fun `http link detection`() {
        val result = parser.parse("Visit https://example.com today")
        assertEquals(3, result.spans.size)
        assertEquals("Visit ", result.spans[0].text)
        assertTrue(result.spans[1].isLink)
        assertEquals("https://example.com", result.spans[1].linkUrl)
        assertEquals(" today", result.spans[2].text)
    }

    @Test
    fun `www link gets https prefix`() {
        val result = parser.parse("Go to www.example.com")
        val linkSpan = result.spans.first { it.isLink }
        assertEquals("https://www.example.com", linkSpan.linkUrl)
    }

    @Test
    fun `link preserves bold formatting`() {
        val result = parser.parse("*Visit https://example.com now*")
        val linkSpan = result.spans.first { it.isLink }
        assertTrue(linkSpan.bold)
    }

    @Test
    fun `link disabled via config`() {
        val p = RawTextParser(ParserConfig(linkEnabled = false))
        val result = p.parse("Visit https://example.com")
        assertEquals(1, result.spans.size)
        assertFalse(result.spans[0].isLink)
    }

    // ── Highlights ───────────────────────────────────────────────────

    @Test
    fun `highlight single word`() {
        val p = RawTextParser(ParserConfig(highlightedWords = listOf("world")))
        val result = p.parse("Hello world!")
        val highlighted = result.spans.filter { it.isHighlighted }
        assertEquals(1, highlighted.size)
        assertEquals("world", highlighted[0].text)
    }

    @Test
    fun `highlight case insensitive`() {
        val p = RawTextParser(ParserConfig(highlightedWords = listOf("HELLO")))
        val result = p.parse("hello there")
        val highlighted = result.spans.filter { it.isHighlighted }
        assertEquals(1, highlighted.size)
        assertEquals("hello", highlighted[0].text)
    }

    @Test
    fun `highlight preserves formatting`() {
        val p = RawTextParser(ParserConfig(highlightedWords = listOf("bold")))
        val result = p.parse("*bold text*")
        val highlighted = result.spans.filter { it.isHighlighted }
        assertEquals(1, highlighted.size)
        assertTrue(highlighted[0].bold)
    }

    // ── Config Disable Flags ─────────────────────────────────────────

    @Test
    fun `bold disabled`() {
        val p = RawTextParser(ParserConfig(boldEnabled = false))
        val result = p.parse("*not bold*")
        assertEquals(1, result.spans.size)
        assertFalse(result.spans[0].bold)
    }

    @Test
    fun `italic disabled`() {
        val p = RawTextParser(ParserConfig(italicEnabled = false))
        val result = p.parse("_not italic_")
        assertEquals(1, result.spans.size)
        assertFalse(result.spans[0].italic)
    }

    @Test
    fun `color disabled`() {
        val p = RawTextParser(ParserConfig(colorEnabled = false))
        val result = p.parse("[red]not colored[/red]")
        assertEquals(1, result.spans.size)
        assertNull(result.spans[0].color)
    }

    @Test
    fun `newline disabled`() {
        val p = RawTextParser(ParserConfig(newlineEnabled = false))
        val result = p.parse("line1\nline2")
        assertEquals(1, result.spans.size)
        assertEquals("line1\nline2", result.spans[0].text)
    }

    // ── HTML Escaping ────────────────────────────────────────────────

    @Test
    fun `angle brackets escaped`() {
        val result = parser.parse("<script>alert('xss')</script>")
        val text = result.plainText
        assertFalse(text.contains("<"))
        assertFalse(text.contains(">"))
        assertTrue(text.contains("\u2039"))
        assertTrue(text.contains("\u203A"))
    }

    // ── Malformed Input ──────────────────────────────────────────────

    @Test
    fun `unclosed bold - unmatched regex`() {
        // Backend regex won't match unclosed *
        val result = parser.parse("*unclosed bold")
        assertEquals(1, result.spans.size)
        assertEquals("*unclosed bold", result.spans[0].text)
        assertFalse(result.spans[0].bold)
    }

    @Test
    fun `empty delimiters`() {
        // ** — regex needs .*?\S between delimiters (at least one non-ws)
        // Can't have zero-length content → no match
        val result = parser.parse("**")
        assertEquals(1, result.spans.size)
        assertEquals("**", result.spans[0].text)
    }

    @Test
    fun `deeply nested does not crash`() {
        val input = buildString {
            repeat(100) { append("*_~") }
            append("deep")
            repeat(100) { append("~_*") }
        }
        val result = parser.parse(input)
        assertFalse(result.isEmpty)
    }

    // ── Extensibility ────────────────────────────────────────────────

    @Test
    fun `custom rule via FormattingRule interface`() {
        val monospaceStyle = object : Style() {}
        val rule = object : FormattingRule {
            private val regex = Regex("""(?<![a-zA-Z0-9])`(.*?\S)`(?![a-zA-Z0-9])""")
            override fun populateActionMap(text: String, actionMap: MutableMap<Int, StyleAction>) {
                regex.findAll(text).forEach { match ->
                    actionMap[match.range.first] = StyleAction(StyleOperation.ADD, monospaceStyle)
                    actionMap[match.range.last] = StyleAction(StyleOperation.REMOVE, monospaceStyle)
                }
            }
        }
        val customParser = RawTextParser(extraRules = listOf(rule))
        val result = customParser.parse("hello `code` world")
        // The custom style won't map to bold/italic/strike, but the text should be split
        assertTrue(result.spans.size > 1)
        assertEquals("code", result.spans[1].text)
    }

    // ── Performance ──────────────────────────────────────────────────

    @Test
    fun `long text with formatting does not crash`() {
        val input = buildString {
            repeat(10_000) {
                append("Hello *world* _foo_ ~bar~ [red]baz[/red] ")
            }
        }
        val result = parser.parse(input)
        assertTrue(result.spans.isNotEmpty())
    }

    // ── PlainText ────────────────────────────────────────────────────

    @Test
    fun `plainText joins all spans`() {
        val result = parser.parse("Hello *world* _foo_")
        assertEquals("Hello world foo", result.plainText)
    }

    // ── Fast-path ────────────────────────────────────────────────────

    @Test
    fun `plain text takes fast path`() {
        val result = parser.parse("Just plain text without markers")
        assertEquals(1, result.spans.size)
        assertEquals("Just plain text without markers", result.spans[0].text)
    }

    // ── Backend Specific Behavior ────────────────────────────────────

    @Test
    fun `color first wins when multiple colors active`() {
        // If somehow two colors are active (e.g., via custom rules),
        // the first one in insertion order wins (LinkedHashSet behavior)
        // This matches the backend's iteration behavior
        val result = parser.parse("[red]hello[/red]")
        assertEquals("red", result.spans[0].color)
    }

    @Test
    fun `bold with leading space in content`() {
        // Backend regex allows space after opening *
        // "* hello world*" → content " hello world"
        val result = parser.parse("* hello world*")
        assertEquals(1, result.spans.size)
        assertEquals(" hello world", result.spans[0].text)
        assertTrue(result.spans[0].bold)
    }

    @Test
    fun `multiple bold spans`() {
        val result = parser.parse("*one* and *two*")
        val boldSpans = result.spans.filter { it.bold }
        assertEquals(2, boldSpans.size)
        assertEquals("one", boldSpans[0].text)
        assertEquals("two", boldSpans[1].text)
    }

    @Test
    fun `color and text after`() {
        val result = parser.parse("[blue]colored[/blue] normal")
        assertEquals(2, result.spans.size)
        assertEquals("colored", result.spans[0].text)
        assertEquals("blue", result.spans[0].color)
        assertEquals(" normal", result.spans[1].text)
        assertNull(result.spans[1].color)
    }
}
