# RawTextParser — Full Context Document

> **Purpose**: This document gives any AI assistant (or developer) the complete mental model of the
> RawTextParser system in one read. Feed this file alongside your change request to get accurate,
> architecture-aligned modifications with zero ramp-up time.

---

## Table of Contents

1. [What This Parser Does](#1-what-this-parser-does)
2. [Origin & Backend Parity](#2-origin--backend-parity)
3. [Supported Formatting Syntax](#3-supported-formatting-syntax)
4. [Architecture Overview](#4-architecture-overview)
5. [File Map & Responsibilities](#5-file-map--responsibilities)
6. [Core Algorithm — Regex Action Map](#6-core-algorithm--regex-action-map)
7. [Data Flow — End to End](#7-data-flow--end-to-end)
8. [Regex Patterns — Backend Exact](#8-regex-patterns--backend-exact)
9. [Action Map Walker — Backend Exact](#9-action-map-walker--backend-exact)
10. [Color Tag Mechanics](#10-color-tag-mechanics)
11. [Newline Handling](#11-newline-handling)
12. [Escape Sequence Handling (Android-Only)](#12-escape-sequence-handling-android-only)
13. [Post-Pass Pipeline (Android-Only)](#13-post-pass-pipeline-android-only)
14. [Configuration System](#14-configuration-system)
15. [Output Model — TextSpan & ParsedText](#15-output-model--textspan--parsedtext)
16. [Compose Integration Layer](#16-compose-integration-layer)
17. [Extensibility Guide — Adding New Rules](#17-extensibility-guide--adding-new-rules)
18. [Performance Characteristics](#18-performance-characteristics)
19. [Edge Cases & Backend-Exact Behaviors](#19-edge-cases--backend-exact-behaviors)
20. [Test Coverage Map](#20-test-coverage-map)
21. [Key Design Decisions & Rationale](#21-key-design-decisions--rationale)
22. [Known Limitations & Future Work](#22-known-limitations--future-work)
23. [Anti-Patterns to Avoid](#23-anti-patterns-to-avoid)
24. [Quick Reference — Class Dependency Graph](#24-quick-reference--class-dependency-graph)
25. [Changelog](#25-changelog)

---

## 1. What This Parser Does

RawTextParser converts plain-text strings containing inline markup into structured styled spans
suitable for rendering in Android UI (Jetpack Compose `AnnotatedString`).

**Think of it as**: A WhatsApp-style text formatter for Android — input `*bold* _italic_` →
output styled spans that Compose renders as **bold** *italic*.

### Input

```
Hello *world*, visit https://example.com for _details_ in [red]red[/red].
```

### Output

A `ParsedText` containing a `List<TextSpan>`:

```
TextSpan("Hello ")
TextSpan("world", bold=true)
TextSpan(", visit ")
TextSpan("https://example.com", isLink=true, linkUrl="https://example.com", color="#1976D2")
TextSpan(" for ")
TextSpan("details", italic=true)
TextSpan(" in ")
TextSpan("red", color="red")
TextSpan(".")
```

---

## 2. Origin & Backend Parity

### Backend Reference

The authoritative source of parsing behavior is the Java backend class:

```
app/src/main/resources/MarkdownTextParserBackend.java
Package: com.neome.app.pdf.xfer.util.MarkdownTextParser
```

**This Android parser uses the SAME algorithm as the backend** (regex action-map), ensuring
byte-for-byte output parity for all supported formatting.

### Algorithm Match

| Aspect            | Backend (Java)                               | Android (Kotlin)                     |
|-------------------|----------------------------------------------|--------------------------------------|
| Pattern detection | Precompiled `java.util.regex.Pattern`        | Kotlin `Regex` (wraps same Pattern)  |
| Action map        | `HashMap<Integer, StyleAction>`              | `HashMap<Int, StyleAction>`          |
| Map collision     | Last regex to write wins (HashMap.put)       | Same (HashMap assignment)            |
| Style tracking    | `LinkedHashSet<Style>`                       | `linkedSetOf<Style>()`               |
| Color priority    | First color in iteration order               | Same (LinkedHashSet insertion order) |
| Walker semantics  | `position += charToSkip; position++`         | Same                                 |
| Newlines          | Each `\r` and `\n` individually              | Same                                 |
| Regex patterns    | Identical lookbehind/lookahead/backreference | Identical                            |

### Android-Only Additions (NOT in Backend)

| Feature                             | Implementation                                                             |
|-------------------------------------|----------------------------------------------------------------------------|
| Escape sequences (`\*`, `\_`, etc.) | Pre-process: replace with Unicode PUA placeholders → post-process: restore |
| URL link detection                  | Post-pass regex on span texts                                              |
| Word highlighting                   | Post-pass with `String.indexOf`                                            |
| HTML angle bracket escaping         | `<` → `‹`, `>` → `›` (before regex phase)                                  |
| Feature toggle config               | `ParserConfig` data class                                                  |

### TypeScript Reference (Legacy)

Earlier TS implementation lives at `app/src/main/resources/MarkdownParser.ts` and
`RawMarkdown.tsx`. The TS code has the same regex patterns but different bugs (single
`activeColor` variable, independent regex passes). The Kotlin v2.0 aligns with the
**backend Java**, not the TS.

---

## 3. Supported Formatting Syntax

| Syntax                        | Renders As                       | Nesting                         | Example                                  |
|-------------------------------|----------------------------------|---------------------------------|------------------------------------------|
| `*text*`                      | **Bold**                         | Yes (via regex overlap)         | `*hello*` → **hello**                    |
| `_text_`                      | *Italic*                         | Yes (via regex overlap)         | `_hello_` → *hello*                      |
| `~text~`                      | ~~Strikethrough~~                | Yes (via regex overlap)         | `~hello~` → ~~hello~~                    |
| `[color]text[/color]`         | Colored text                     | No (outer regex captures inner) | `[red]hello[/red]`                       |
| `[#RRGGBB]text[/#RRGGBB]`     | Hex-colored text                 | No (outer regex captures inner) | `[#FF0000]hello[/#FF0000]`               |
| `https://...` or `www.…`      | Clickable link (Android-only)    | N/A                             | `https://example.com`                    |
| `\*` `\_` `\~` `\[` `\]` `\\` | Literal character (Android-only) | N/A                             | `\*not bold\*` → `*not bold*`            |
| `\n`, `\r`                    | Line break                       | N/A                             | Each `\r` and `\n` is a separate newline |

### Boundary Rules (Regex-Based)

Inline delimiters (`*`, `_`, `~`) use regex patterns with:

- **Negative lookbehind** `(?<![a-zA-Z0-9])`: NOT preceded by ASCII alphanumeric
- **Content** `(.*?\S)`: at least one char, ending with non-whitespace (non-greedy)
- **Negative lookahead** `(?![a-zA-Z0-9])`: NOT followed by ASCII alphanumeric

**Key**: The regex uses `[a-zA-Z0-9]` (ASCII only), NOT Unicode `\w` or `isLetterOrDigit()`.
Unicode characters like `中` are NOT considered alphanumeric for boundary checks.

**Content can start with whitespace**: `* hello*` is valid bold (content ` hello` ends with
non-ws `o`). This matches the backend behavior.

---

## 4. Architecture Overview

```
┌───────────────────────────────────────────────────────────────────────────┐
│                            RawTextParser                                  │
│  (ParserConfig + Pipeline Orchestrator)                                   │
│                                                                           │
│  parse(text) → ParsedText                                                 │
│                                                                           │
│  Pipeline:                                                                │
│  ┌──────────┐ ┌──────────┐ ┌──────────┐ ┌───────────┐ ┌──────────┐      │
│  │Fast-path │→│  HTML    │→│ Escape   │→│Build Action│→│  Walk    │      │
│  │Check     │ │ Escape   │ │Placeholders│ │   Map     │ │Action Map│      │
│  └──────────┘ └──────────┘ └──────────┘ └───────────┘ └──────────┘      │
│       (skip if no markers)  (Android-only)  (Regex-based)  (Backend-exact)│
│                                                    ↓                      │
│                          ┌──────────┐ ┌──────────┐ ┌──────────┐          │
│                          │ Restore  │→│  Link    │→│Highlight │          │
│                          │Placeholders│ │  Pass   │ │  Pass    │          │
│                          └──────────┘ └──────────┘ └──────────┘          │
│                          (Android-only) (Android-only) (Android-only)     │
│                                                    ↓                      │
│                                              ParsedText                   │
└───────────────────────────────────────────────────────────────────────────┘
                                                 ↓
                                      AnnotatedStringExt
                                   (Compose bridge layer)
                                                 ↓
                                          RawTextParserUi Composable
```

### Layer Separation

| Layer                  | Package         | Depends On                       |
|------------------------|-----------------|----------------------------------|
| **Style/Action types** | `parser/rule/`  | Nothing (pure Kotlin)            |
| **Pipeline + Config**  | `parser/`       | `rule/`, `model/`                |
| **Output model**       | `parser/model/` | Nothing (pure Kotlin)            |
| **Compose bridge**     | `parser/ext/`   | `model/`, `parser/` + Compose UI |

The core parser (`rule/`, `model/`, `RawTextParser.kt`) has **zero Android framework
dependencies**. Only `parser/ext/` imports Compose.

---

## 5. File Map & Responsibilities

```
core/common/parser/
│
├── RawTextParser.kt                    [~330 lines]
│   Main entry point. Contains:
│   - ParserConfig data class
│   - parse() pipeline orchestrator
│   - buildActionMap() — regex-based, backend-exact
│   - walkActionMap() — character walker, backend-exact
│   - Escape placeholder pre/post processing
│   - Link post-pass, Highlight post-pass
│   - All regex patterns as companion object vals
│   Thread-safe: immutable after construction.
│
├── RawTextParserContext.md             [THIS FILE]
│
├── model/
│   └── TextSpan.kt                     [44 lines]
│       TextSpan (single styled segment) + ParsedText (wrapper).
│       Pure Kotlin, no framework deps.
│
├── rule/
│   └── FormattingRule.kt               [~80 lines]
│       - Style abstract class (Bold, Italic, Strikethrough, Newline, Color)
│       - StyleAction data class (operation, style, charToSkip)
│       - StyleOperation enum (ADD, REMOVE)
│       - FormattingRule interface (extensibility point)
│
└── ext/
    ├── AnnotatedStringExt.kt           [~150 lines]
    │   ParsedText.toAnnotatedString(), TextSpan.toSpanStyle(),
    │   parseColor() — 25 named colors + hex.
    │
    └── RawTextParserUi.kt                      [~70 lines]
        @Composable drop-in component with memoization + link clicks.

TEST:
test/.../parser/RawTextParserTest.kt    [~350 lines]
    ~50 tests: backend parity + Android-only features.
```

---

## 6. Core Algorithm — Regex Action Map

This is the same algorithm as the backend Java `MarkdownTextParser`.

### Phase 1: Build Action Map

Run precompiled regex patterns over the input in this exact order:

1. **Bold** regex → ADD at `match.start`, REMOVE at `match.end - 1` (charToSkip=0)
2. **Italic** regex → same pattern
3. **Strikethrough** regex → same pattern
4. **Color (named)** regex → ADD at `match.start` (charToSkip=name.length+1), REMOVE at calculated close position (charToSkip=name.length+2)
5. **Color (hex)** regex → same as named but with hex value
6. **Newline** regex → ADD at each `\r` and `\n` position
7. **Extra rules** → custom `FormattingRule` implementations

Result: `HashMap<Int, StyleAction>` — one action per position. **Last writer wins** if
two patterns match at the same position (HashMap overwrite semantics).

### Phase 2: Walk Action Map

Walk the string character by character:

```
pos = 0
buffer = StringBuilder
activeStyles = LinkedHashSet<Style>()  // insertion order

while pos < text.length:
    action = actionMap[pos]
    if action != null:
        flush buffer → TextSpan with current activeStyles
        if action is Newline:
            add newline TextSpan
        else:
            pos += action.charToSkip   // skip delimiter chars
            add/remove style from activeStyles
        clear buffer
    else:
        buffer.append(text[pos])
    pos++                              // ALWAYS increments

flush remaining buffer
```

**Critical**: `pos++` happens after charToSkip. So for `[red]`:

- charToSkip = 4 (skip `red]`)
- `pos += 4`, then `pos++` → total skip = 5 characters = `[red]`

---

## 7. Data Flow — End to End

```
Input: "Hello *world* https://x.com"
  │
  ▼
Phase 1 (Fast-path): text contains '*' → can't skip
  │
  ▼
Phase 2 (HTML escape): no < or > → passthrough
  │
  ▼
Phase 3 (Escape placeholders): no \ → passthrough
  │
  ▼
Phase 4 (Build action map):
  Bold regex finds *world* → ADD Bold at 6, REMOVE Bold at 12
  No italic/strike/color/newline matches
  actionMap = {6: ADD Bold, 12: REMOVE Bold}
  │
  ▼
Phase 5 (Walk action map):
  pos 0-5: "Hello " → buffer
  pos 6: action ADD Bold → flush "Hello " as plain, push Bold
  pos 7-11: "world" → buffer
  pos 12: action REMOVE Bold → flush "world" as bold, pop Bold
  pos 13-end: " https://x.com" → buffer → flush as plain
  │
  Result: [plain("Hello "), bold("world"), plain(" https://x.com")]
  │
  ▼
Phase 6 (Restore placeholders): no placeholders → passthrough
  │
  ▼
Phase 7 (Link pass):
  " https://x.com" contains URL → split into [plain(" "), link("https://x.com")]
  │
  ▼
Phase 8 (Highlight pass): no highlights → passthrough
  │
  ▼
Final: [plain("Hello "), bold("world"), plain(" "), link("https://x.com")]
```

---

## 8. Regex Patterns — Backend Exact

All patterns are identical to the backend Java `MarkdownTextParser`.

| Pattern       | Regex                                        | Notes                                                    |
|---------------|----------------------------------------------|----------------------------------------------------------|
| Bold          | `(?<![a-zA-Z0-9])\*(.*?\S)\*(?![a-zA-Z0-9])` | ASCII boundary, non-greedy content ending in non-ws      |
| Italic        | `(?<![a-zA-Z0-9])_(.*?\S)_(?![a-zA-Z0-9])`   | Same structure                                           |
| Strikethrough | `(?<![a-zA-Z0-9])~(.*?\S)~(?![a-zA-Z0-9])`   | Same structure                                           |
| Color (named) | `\[(\w+)](.*?)\[/\1]`                        | `\w+` = `[a-zA-Z0-9_]`, backreference `\1` for close tag |
| Color (hex)   | `\[(#[0-9a-fA-F]{6})](.*?)\[/\1]`            | Hex with backreference                                   |
| Newline       | `[\r\n]`                                     | Each `\r` and `\n` matched individually                  |

### Important Regex Behaviors

1. **`.` does NOT match `\n`** (no DOTALL flag) → formatting cannot span newlines
2. **`.*?` is non-greedy** → matches shortest possible content
3. **`\w+` in color** matches `[a-zA-Z0-9_]` → color names like `dark_red` or `color2` are valid
4. **Backreference `\1`** → close tag must match open tag exactly (case-sensitive)
5. **Lookbehind/lookahead are ASCII only** → `[a-zA-Z0-9]`, not Unicode-aware
6. **`findAll()` returns non-overlapping matches** → nested colors impossible via regex

---

## 9. Action Map Walker — Backend Exact

### Style Tracking: LinkedHashSet

Uses `linkedSetOf<Style>()` (Kotlin) / `LinkedHashSet<Style>()` (Java).

- **Insertion order preserved** → iteration order is order styles were added
- **First color wins** when flushing buffer: iterate set, take first `Style.Color` found
- **Bold/Italic/Strikethrough/Newline are singletons** (data objects) → `add`/`remove` by equality
- **Color is data class** → `Style.Color("red") == Style.Color("red")` → correct add/remove

### charToSkip Semantics

| Style                   | Open charToSkip                 | Close charToSkip                |
|-------------------------|---------------------------------|---------------------------------|
| Bold (`*`)              | 0                               | 0                               |
| Italic (`_`)            | 0                               | 0                               |
| Strikethrough (`~`)     | 0                               | 0                               |
| Color named (`[red]`)   | name.length + 1 (= 4 for "red") | name.length + 2 (= 5 for "red") |
| Color hex (`[#FF0000]`) | hex.length + 1 (= 8)            | hex.length + 2 (= 9)            |
| Newline                 | N/A (no charToSkip, no pos+=)   | N/A                             |

The walker always does `pos++` after processing, so the character AT the action position
is consumed (not output). Combined with charToSkip, this skips the full delimiter.

### Early Exit Optimization

When flushing buffer, the backend exits early if all three flags (bold, italic, strikethrough)
are set AND a color is found. The Kotlin implementation does the same.

---

## 10. Color Tag Mechanics

### Named Colors: `\w+`

The regex `\[(\w+)]` accepts `[a-zA-Z0-9_]+` for color names. This means:

- `[red]` ✓, `[blue]` ✓, `[dark_red]` ✓, `[color2]` ✓
- `[123]` ✓ (all digits are word chars)
- `[hello world]` ✗ (space is not `\w`)

### Nesting Behavior (Backend-Exact)

**Colors do NOT nest.** The outer regex match consumes the inner tags as content:

```
Input:  [red][blue]text[/blue][/red]

Regex match: [red] captures everything up to [/red]
Content (.*?) = "[blue]text[/blue]"

Output: "[blue]text[/blue]" displayed in RED color
Inner [blue] and [/blue] become literal visible text.
```

### Close Position Calculation

```
matchEnd = match.range.last + 1   // exclusive end (same as Java match.end())
closePos = matchEnd - colorName.length - 3
closeSkip = colorName.length + 2
```

For `[red]hello[/red]` (length 16):

- matchEnd = 16, colorName = "red" (length 3)
- closePos = 16 - 3 - 3 = 10 (the `[` of `[/red]`)
- closeSkip = 5 (skips `/red]`)
- Plus `pos++` skips `[` → total 6 chars = `[/red]` ✓

---

## 11. Newline Handling

### Backend-Exact: Individual Characters

The regex `[\r\n]` matches each `\r` and `\n` as separate characters.

**`\r\n` produces TWO newlines:**

- Position i: `\r` → newline action → flush buffer + add newline span
- Position i+1: `\n` → newline action → flush buffer (empty) + add newline span
- Result: two consecutive newline spans

**`\n` produces ONE newline.**
**`\r` produces ONE newline.**

### Formatting Cannot Span Newlines

Since `.` in regex doesn't match `\n` (no DOTALL flag):

- `*bold\ntext*` → bold regex doesn't match → literal `*bold`, newline, `text*`
- `[red]hello\nworld[/red]` → color regex doesn't match → literal text

---

## 12. Escape Sequence Handling (Android-Only)

### Mechanism: Unicode Placeholder Substitution

Since the backend has no escape support, escapes are implemented as a pre/post-processing
layer that's invisible to the regex engine:

**Pre-process** (before regexes):

```
\* → U+E001
\_ → U+E002
\~ → U+E003
\[ → U+E004
\] → U+E005
\\ → U+E006
```

**Regex runs** → PUA characters are not `*`, `_`, `~`, `[`, `]`, so regexes ignore them.

**Post-process** (after walker produces spans):

```
U+E001 → *
U+E002 → _
U+E003 → ~
U+E004 → [
U+E005 → ]
U+E006 → \
```

### Disable

```kotlin
ParserConfig(escapeEnabled = false)
```

Disabling skips the pre/post-processing entirely, making behavior identical to backend.

---

## 13. Post-Pass Pipeline (Android-Only)

These passes are NOT in the backend. They operate on `List<TextSpan>` after the action-map
walk, never re-scanning the raw input.

### Link Pass

- Iterates spans, skips already-link or newline spans
- Runs `URL_REGEX.findAll()` on each span's text
- Splits matching spans: [before, link-span, after]
- Link spans: `isLink=true`, `linkUrl` normalized with `https://`, `color` from config
- Returns original list if no links found (zero-copy)

**URL Regex**: `(?:https?://|www\.)[a-zA-Z0-9][-a-zA-Z0-9@:%._+~#=]{0,256}\.[a-zA-Z0-9()]{1,6}[-a-zA-Z0-9()@:%_+.~#?&/=]*`

- Requires `http://`, `https://`, or `www.` prefix
- Case-insensitive

### Highlight Pass

- Words filtered (non-blank), sorted by descending length
- For each span: `BooleanArray` marks character positions matching any word
- Uses `String.indexOf` (case-insensitive via `.lowercase()`) — no regex
- Converts marks to contiguous segments: (text, isHighlighted) pairs

---

## 14. Configuration System

```kotlin
data class ParserConfig(
    val boldEnabled: Boolean = true,
    val italicEnabled: Boolean = true,
    val strikethroughEnabled: Boolean = true,
    val colorEnabled: Boolean = true,
    val newlineEnabled: Boolean = true,
    val escapeEnabled: Boolean = true,        // Android-only
    val linkEnabled: Boolean = true,          // Android-only
    val highlightedWords: List<String> = emptyList(),  // Android-only
    val hyperlinkColor: String = "#1976D2",   // Android-only
    val highlightColor: String = "#FFFF00"    // Android-only
)
```

| Flag                           | Effect When Disabled                                    |
|--------------------------------|---------------------------------------------------------|
| `boldEnabled = false`          | Bold regex not run → `*` stays literal                  |
| `italicEnabled = false`        | Italic regex not run → `_` stays literal                |
| `strikethroughEnabled = false` | Strikethrough regex not run → `~` stays literal         |
| `colorEnabled = false`         | Both color regexes not run → `[tag]` stays literal      |
| `newlineEnabled = false`       | Newline regex not run → `\n`/`\r` stays in text         |
| `escapeEnabled = false`        | No placeholder substitution → `\*` is literal `\` + `*` |
| `linkEnabled = false`          | Link post-pass skipped                                  |

**For exact backend parity**: Use `ParserConfig(escapeEnabled = false, linkEnabled = false)`.

---

## 15. Output Model — TextSpan & ParsedText

```kotlin
data class TextSpan(
    val text: String,
    val bold: Boolean = false,
    val italic: Boolean = false,
    val strikethrough: Boolean = false,
    val color: String? = null,      // Named or "#RRGGBB"
    val isLink: Boolean = false,
    val linkUrl: String? = null,
    val isHighlighted: Boolean = false,
    val isNewline: Boolean = false
)

data class ParsedText(val spans: List<TextSpan>)
```

Factory methods: `TextSpan.plain(text)`, `TextSpan.newline()`, `ParsedText.EMPTY`.

---

## 16. Compose Integration Layer

### AnnotatedStringExt.kt

`ParsedText.toAnnotatedString(highlightColor)` → Compose `AnnotatedString` with:

- `SpanStyle` for bold/italic/strikethrough/color
- `pushStringAnnotation(tag="URL")` for links
- 25 named colors + `#RRGGBB` + `#AARRGGBB` hex

### RawTextParserUi.kt — @Composable

```kotlin
@Composable
fun RawTextParserUi(
    text: String?,
    modifier: Modifier = Modifier,
    config: ParserConfig = ParserConfig(),
    style: TextStyle = MaterialTheme.typography.bodyMedium,
    highlightColor: Color = Color.Yellow,
    onLinkClick: ((url: String) -> Unit)? = null
)
```

Uses `remember(config)` for parser, `remember(text, config)` for parsed result.

---

## 17. Extensibility Guide — Adding New Rules

### FormattingRule Interface

```kotlin
interface FormattingRule {
    fun populateActionMap(text: String, actionMap: MutableMap<Int, StyleAction>)
}
```

Custom rules add `StyleAction` entries to the map. The same walker handles them.

### Example: Monospace Rule

```kotlin
class MonospaceRule : FormattingRule {
    private val regex = Regex("""(?<![a-zA-Z0-9])`(.*?\S)`(?![a-zA-Z0-9])""")

    override fun populateActionMap(text: String, actionMap: MutableMap<Int, StyleAction>) {
        regex.findAll(text).forEach { match ->
            actionMap[match.range.first] = StyleAction(StyleOperation.ADD, MyMonospaceStyle)
            actionMap[match.range.last] = StyleAction(StyleOperation.REMOVE, MyMonospaceStyle)
        }
    }
}

val parser = RawTextParser(extraRules = listOf(MonospaceRule()))
```

Custom rules run AFTER built-in rules → can override at same positions.

### Adding a Post-Pass

1. Write: `fun applyMyPass(spans: List<TextSpan>): List<TextSpan>`
2. Insert into pipeline in `RawTextParser.parse()` after the appropriate phase
3. Follow the link/highlight pass pattern

---

## 18. Performance Characteristics

| Phase                        | Time                 | Space                            |
|------------------------------|----------------------|----------------------------------|
| Fast-path check              | O(n)                 | O(1)                             |
| HTML escape                  | O(n)                 | O(n) if needed                   |
| Escape placeholders          | O(n)                 | O(n) if needed                   |
| Build action map (6 regexes) | O(n) each            | O(k) actions                     |
| Walk action map              | O(n)                 | O(n) output + O(s) active styles |
| Restore placeholders         | O(m) spans           | O(1) per span                    |
| Link pass                    | O(n)                 | O(m) spans                       |
| Highlight pass               | O(n × w)             | O(n) marks                       |
| **Total**                    | **O(n × max(6, w))** | **O(n)**                         |

All regexes are precompiled as `companion object val`. Zero regex compilation per `parse()` call.

---

## 19. Edge Cases & Backend-Exact Behaviors

| #  | Scenario                                       | Behavior                                                                                 |
|----|------------------------------------------------|------------------------------------------------------------------------------------------|
| 1  | `null` / `""`                                  | Returns `ParsedText.EMPTY`                                                               |
| 2  | Unclosed `*hello`                              | Regex doesn't match → literal `*hello`                                                   |
| 3  | Empty `**`                                     | Regex needs `.*?\S` (at least 1 non-ws) → no match → literal `**`                        |
| 4  | `* hello*` (space after open)                  | Regex matches: content ` hello` ends with non-ws → bold                                  |
| 5  | `some_var*name*here`                           | Lookbehind: `r` is alnum → no match → literal                                            |
| 6  | `*name*here`                                   | Lookahead: `h` is alnum → no match → literal                                             |
| 7  | `中*bold*文`                                     | `中` not in `[a-zA-Z0-9]` → boundary passes → bold                                        |
| 8  | Nested colors `[red][blue]x[/blue][/red]`      | Outer captures inner → `[blue]x[/blue]` displayed in red                                 |
| 9  | Sequential colors `[red]a[/red][blue]b[/blue]` | Two separate matches → works correctly                                                   |
| 10 | Color across newline `[red]a\nb[/red]`         | `.` doesn't match `\n` → no match → literal                                              |
| 11 | Bold across newline `*a\nb*`                   | Same → no match → literal                                                                |
| 12 | `\r\n`                                         | Two separate newlines (backend-exact)                                                    |
| 13 | HashMap collision (same position)              | Last regex wins (Bold < Italic < Strike < Color < Hex < Newline)                         |
| 14 | `[red]*bold*[/red]`                            | Both color and bold match; bold ADD/REMOVE may collide with color → depends on positions |
| 15 | `[#ff0000]world*[/#ff0000]`                    | Backend main() test case → color="ff0000", text="world*"                                 |
| 16 | `<script>`                                     | `<` → `‹`, `>` → `›` (Android-only)                                                      |
| 17 | `\*escaped\*`                                  | Placeholders hide from regex → literal `*escaped*` (Android-only)                        |
| 18 | `[dark_red]text[/dark_red]`                    | `\w+` matches underscore → valid color name                                              |
| 19 | All features disabled                          | No regexes run, no post-passes → single plain span                                       |

---

## 20. Test Coverage Map

| Category             | # Tests | Key Verifications                                                                                  |
|----------------------|---------|----------------------------------------------------------------------------------------------------|
| Null/Empty           | 3       | null, empty, plain text                                                                            |
| Bold                 | 6       | basic, start, end, boundary rejection (alnum before/after), space-after-open, punctuation, unicode |
| Italic               | 2       | basic, variable name rejection                                                                     |
| Strikethrough        | 1       | basic                                                                                              |
| Nested Inline        | 2       | bold+italic, triple nesting                                                                        |
| Color Tags           | 7       | named, hex, color+bold, \w+ name, nested (outer wins), sequential, unclosed, backend main()        |
| Newlines             | 5       | LF, CR, CRLF (two newlines), consecutive, across-formatting                                        |
| Action Map Collision | 1       | color and bold at same position                                                                    |
| Escape (Android)     | 4       | asterisk, underscore, backslash, bracket                                                           |
| Links (Android)      | 4       | http, www prefix, link+bold, disabled                                                              |
| Highlights (Android) | 3       | single, case-insensitive, preserves formatting                                                     |
| Config Flags         | 4       | bold/italic/color/newline disabled                                                                 |
| HTML Escape          | 1       | angle brackets                                                                                     |
| Malformed            | 3       | unclosed, empty delimiters, deep nesting                                                           |
| Extensibility        | 1       | custom FormattingRule                                                                              |
| Performance          | 1       | 10K repetitions                                                                                    |
| PlainText            | 1       | extraction                                                                                         |
| Fast-path            | 1       | plain text skip                                                                                    |
| Backend-specific     | 2       | first-color-wins, leading-space-bold                                                               |
| **Total**            | **~50** |                                                                                                    |

---

## 21. Key Design Decisions & Rationale

| Decision                                       | Rationale                                                                                     |
|------------------------------------------------|-----------------------------------------------------------------------------------------------|
| **Regex action-map** (not single-pass scanner) | Exact backend parity. The backend uses this algorithm; matching it avoids subtle differences. |
| **Same regex patterns** verbatim               | Ensures identical match boundaries for all inputs                                             |
| **HashMap collision = last writer wins**       | Matches backend's `HashMap.put` overwrite semantics                                           |
| **LinkedHashSet for active styles**            | Matches backend's iteration order → first color wins                                          |
| **`\r` and `\n` individually**                 | Matches backend's `[\r\n]` regex (each char separate)                                         |
| **Escape via PUA placeholders**                | Invisible to regexes; clean pre/post boundary; easy to disable                                |
| **Post-passes for link/highlight**             | Android-only features that don't affect backend parity                                        |
| **Platform-agnostic output model**             | TextSpan has no Compose imports → testable with plain JUnit                                   |
| **Config as data class**                       | Immutable, `remember(config)` works in Compose                                                |

---

## 22. Known Limitations & Future Work

| # | Limitation                                  | Notes                                             |
|---|---------------------------------------------|---------------------------------------------------|
| 1 | Colors don't nest                           | By design — matches backend regex behavior        |
| 2 | Formatting can't span newlines              | By design — `.` doesn't match `\n` without DOTALL |
| 3 | `\r\n` = two newlines                       | Backend-exact; could add config flag if UX issue  |
| 4 | HashMap collision drops style actions       | Backend-exact; rare in practice                   |
| 5 | No monospace/code formatting                | Add via `FormattingRule` extensibility            |
| 6 | No `@mention` or `#channel`                 | Add as post-pass                                  |
| 7 | URL regex won't match bare domains          | By design — reduces false positives               |
| 8 | Named colors limited to 25 in Compose layer | Extend `NAMED_COLORS` map                         |

---

## 23. Anti-Patterns to Avoid

| ❌ Don't                                               | ✅ Do Instead                                           |
|-------------------------------------------------------|--------------------------------------------------------|
| Change regex patterns without checking backend Java   | Patterns must stay identical for parity                |
| Change regex execution order                          | Order determines HashMap collision winners             |
| Use `linkedSetOf` alternatives (e.g., `mutableSetOf`) | Must preserve insertion order for first-color-wins     |
| Add Compose imports to `rule/` or `model/`            | Keep platform deps in `ext/` only                      |
| Mutate TextSpan after creation                        | Use `.copy()`                                          |
| Create regex per `parse()` call                       | Use `companion object val`                             |
| Handle `\r\n` as one newline in core                  | That breaks backend parity (add config flag if needed) |
| Add nesting support for colors                        | Backend doesn't support it; would change output        |

---

## 24. Quick Reference — Class Dependency Graph

```
    Style (abstract class: Bold, Italic, Strikethrough, Newline, Color)
    StyleAction (operation, style, charToSkip)
    StyleOperation (ADD, REMOVE)
    FormattingRule (interface for extra rules)
            │
            ▼
    ParserConfig ──── RawTextParser ──── TextSpan / ParsedText
                          │
                   AnnotatedStringExt
                          │
                   RawTextParserUi (@Composable)
```

### Import Rules

```
model/TextSpan.kt         → imports: nothing
rule/FormattingRule.kt     → imports: nothing
RawTextParser.kt           → imports: model/*, rule/*
ext/AnnotatedStringExt.kt  → imports: model/*, Compose UI
ext/RawTextParserUi.kt             → imports: RawTextParser, ParserConfig, ext/AnnotatedStringExt, Compose UI
```

---

## 25. Changelog

All notable changes to this parser are documented here.

### [2.0.0] — 2026-02-24

**Major Rewrite** — Backend-exact algorithm alignment.

The core parsing engine was rewritten from a single-pass character scanner to a **regex
action-map** approach, matching the backend Java `MarkdownTextParser` byte-for-byte.

#### Changed (Breaking)

- **Core algorithm**: Replaced `InlineScanner` (single-pass char-by-char) with regex-based
  action-map builder + walker, identical to backend `prepareActionMap()` + `convertToHtmlText()`
- **Style system**: Replaced `ActiveStyle`/`RuleMatch` with `Style` abstract class + `StyleAction`,
  matching backend's `Style`/`StyleAction` hierarchy. `Style` is abstract (not sealed) to allow
  custom subclasses via `FormattingRule` extensibility.
- **Boundary checks**: Now use regex `(?<![a-zA-Z0-9])` (ASCII-only) instead of
  `Char.isLetterOrDigit()` (Unicode). `中*bold*文` now triggers bold (matches backend).
- **Open delimiter**: No longer requires non-whitespace after opening `*`. Content `* hello*`
  is now valid bold (matches backend regex `.*?\S`)
- **Color name validation**: Now accepts `\w+` (`[a-zA-Z0-9_]`) instead of alphabetic-only.
  `[dark_red]` and `[color2]` are now valid.
- **Color nesting**: Removed stack-based nesting. Outer color regex captures inner tags as
  literal text (matches backend). `[red][blue]x[/blue][/red]` → `[blue]x[/blue]` in red.
- **First color wins**: When multiple colors active, first in LinkedHashSet iteration order
  wins (was: last color on stack)
- **Newline**: `\r\n` now produces TWO newlines (was: one). Each `\r` and `\n` matched
  individually by `[\r\n]` regex (matches backend).
- **Newline integrated**: Newlines handled in action-map walk (was: separate post-pass)
- **FormattingRule interface**: Simplified from `matchOpen`/`matchClose` per-position to
  `populateActionMap()` — rules contribute to the shared action map

#### Removed

- `scanner/InlineScanner.kt` — replaced by action-map walker in RawTextParser
- `rule/InlineDelimiterRule.kt` — replaced by regex patterns
- `rule/ColorTagRule.kt` — replaced by regex patterns
- `rule/EscapeRule.kt` — replaced by PUA placeholder mechanism in RawTextParser

#### Unchanged

- `model/TextSpan.kt` — output model identical
- `ext/AnnotatedStringExt.kt` — Compose bridge identical
- `ext/RawTextParserUi.kt` — Composable component identical
- `ParserConfig` — same fields (added to config: no new flags, order changed)
- Escape sequences (Android-only) — still supported via placeholder mechanism
- Link detection (Android-only) — still supported via post-pass
- Word highlighting (Android-only) — still supported via post-pass
- HTML angle bracket escaping — still applied
- Fast-path optimization — still active

### [2.0.1] — 2026-02-24

**Bug fixes** — Test verification pass.

#### Fixed

- **Style class**: Changed from `sealed class` to `abstract class` to allow custom `Style`
  subclasses in `FormattingRule` implementations (anonymous objects can't extend sealed classes)
- **Link URL prefix**: Fixed `HTTP_PREFIX_REGEX` check using `.containsMatchIn()` instead of
  `.matches()` — `.matches()` requires entire string to match, causing `https://` to be
  prepended to URLs that already had it
- **Fast-path with extra rules**: `canSkipParsing()` now returns `false` when `extraRules` is
  non-empty, since custom rules may match characters not checked by the fast-path

#### Verified

- All 59 unit tests pass (`./gradlew :app:testDebugUnitTest --tests "...RawTextParserTest"`)

### [1.0.0] — 2026-02-24

**Initial Release** — Ground-up Kotlin rewrite of TS `MarkdownParser.ts`.

#### Added

- Single-pass inline scanner (`InlineScanner.kt`)
- `FormattingRule` interface with `InlineDelimiterRule`, `ColorTagRule`, `EscapeRule`
- `ParserConfig`, `TextSpan`, `ParsedText`, `AnnotatedStringExt`, `RawTextParserUi`
- 5-phase pipeline, fast-path optimization, 44 unit tests
- Android-only: escape sequences, link detection, word highlighting

---

*Last updated: 2026-02-24 — v2.0.1*
