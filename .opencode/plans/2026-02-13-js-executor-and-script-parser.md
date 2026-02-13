# JsExecutor & JsScriptParser Implementation Plan

> **For Claude:** REQUIRED SUB-SKILL: Use superpowers:executing-plans to implement this plan task-by-task.

**Goal:** Create standalone utilities for executing JavaScript strings and parsing template strings with `${f:fieldId}` placeholder substitution.

**Architecture:** Two independent utility objects in `feature/form/domain/util/`. `JsExecutor` wraps Mozilla Rhino to evaluate JavaScript and return `Any?`. `JsScriptParser` uses regex to find `${f:...}` placeholders and substitutes them from a provided `Map<String, Any?>`. They are standalone - no integration with `CalcFormula` yet.

**Tech Stack:** Mozilla Rhino 1.7.15 (pure Java JS engine), JUnit 4, Kotlin

---

### Task 1: Add Rhino Dependency

**Files:**
- Modify: `gradle/libs.versions.toml:1-71`
- Modify: `app/build.gradle.kts:59-103`

**Step 1: Add Rhino version and library to version catalog**

In `gradle/libs.versions.toml`, add to `[versions]` section (after line 21):

```toml
rhino = "1.7.15"
```

Add to `[libraries]` section (after line 51, before the CameraX comment):

```toml
rhino = { group = "org.mozilla", name = "rhino", version.ref = "rhino" }
```

**Step 2: Add Rhino dependency to app build**

In `app/build.gradle.kts`, add after the `konform-jvm` line (line 102):

```kotlin
implementation(libs.rhino)
```

**Step 3: Verify build compiles**

Run: `./gradlew app:compileDebugKotlin`
Expected: BUILD SUCCESSFUL

**Step 4: Commit**

```bash
git add gradle/libs.versions.toml app/build.gradle.kts
git commit -m "build: add Mozilla Rhino JS engine dependency"
```

---

### Task 2: Create JsExecutor - Failing Tests

**Files:**
- Create: `app/src/test/java/com/neome/feature/form/domain/util/JsExecutorTest.kt`

**Step 1: Write failing tests for JsExecutor**

```kotlin
package com.neome.feature.form.domain.util

import org.junit.Test
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue

class JsExecutorTest {

    @Test
    fun `execute simple arithmetic returns number`() {
        val result = JsExecutor.execute("2 + 3")
        // Rhino returns Double for numeric results
        assertEquals(5.0, (result as Number).toDouble(), 0.001)
    }

    @Test
    fun `execute string concatenation returns string`() {
        val result = JsExecutor.execute("'hello' + ' ' + 'world'")
        assertEquals("hello world", result)
    }

    @Test
    fun `execute boolean expression returns boolean`() {
        val result = JsExecutor.execute("5 > 3")
        assertEquals(true, result)
    }

    @Test
    fun `execute null literal returns null`() {
        val result = JsExecutor.execute("null")
        assertNull(result)
    }

    @Test
    fun `execute undefined returns null`() {
        val result = JsExecutor.execute("undefined")
        assertNull(result)
    }

    @Test
    fun `execute multiline script returns last expression`() {
        val script = """
            var a = 10;
            var b = 20;
            a + b;
        """.trimIndent()
        val result = JsExecutor.execute(script)
        assertEquals(30.0, (result as Number).toDouble(), 0.001)
    }

    @Test
    fun `execute with syntax error returns null`() {
        val result = JsExecutor.execute("var x = ;")
        assertNull(result)
    }

    @Test
    fun `execute with runtime error returns null`() {
        val result = JsExecutor.execute("undeclaredVariable.property")
        assertNull(result)
    }

    @Test
    fun `execute empty string returns null`() {
        val result = JsExecutor.execute("")
        assertNull(result)
    }

    @Test
    fun `execute blank string returns null`() {
        val result = JsExecutor.execute("   ")
        assertNull(result)
    }

    @Test
    fun `execute math functions work`() {
        val result = JsExecutor.execute("Math.max(10, 20)")
        assertEquals(20.0, (result as Number).toDouble(), 0.001)
    }

    @Test
    fun `execute string methods work`() {
        val result = JsExecutor.execute("'HELLO'.toLowerCase()")
        assertEquals("hello", result)
    }

    @Test
    fun `execute ternary operator works`() {
        val result = JsExecutor.execute("true ? 'yes' : 'no'")
        assertEquals("yes", result)
    }

    @Test
    fun `execute function declaration and call works`() {
        val script = """
            function add(a, b) { return a + b; }
            add(3, 4);
        """.trimIndent()
        val result = JsExecutor.execute(script)
        assertEquals(7.0, (result as Number).toDouble(), 0.001)
    }

    @Test
    fun `execute with bindings provides variables to script`() {
        val bindings = mapOf(
            "price" to 100,
            "quantity" to 5
        )
        val result = JsExecutor.execute("price * quantity", bindings)
        assertEquals(500.0, (result as Number).toDouble(), 0.001)
    }

    @Test
    fun `execute with string binding`() {
        val bindings = mapOf("name" to "World")
        val result = JsExecutor.execute("'Hello ' + name", bindings)
        assertEquals("Hello World", result)
    }

    @Test
    fun `execute with null binding value`() {
        val bindings = mapOf("x" to null)
        val result = JsExecutor.execute("x === null", bindings)
        assertEquals(true, result)
    }

    @Test
    fun `execute with double binding`() {
        val bindings = mapOf("rate" to 0.15)
        val result = JsExecutor.execute("100 * rate", bindings)
        assertEquals(15.0, (result as Number).toDouble(), 0.001)
    }

    @Test
    fun `execute with empty bindings map`() {
        val result = JsExecutor.execute("42", emptyMap())
        assertEquals(42.0, (result as Number).toDouble(), 0.001)
    }
}
```

**Step 2: Run tests to verify they fail**

Run: `./gradlew app:testDebugUnitTest --tests "com.neome.feature.form.domain.util.JsExecutorTest" 2>&1 | tail -20`
Expected: FAIL - compilation error, `JsExecutor` does not exist

**Step 3: Commit failing tests**

```bash
git add app/src/test/java/com/neome/feature/form/domain/util/JsExecutorTest.kt
git commit -m "test: add failing tests for JsExecutor"
```

---

### Task 3: Implement JsExecutor

**Files:**
- Create: `app/src/main/java/com/neome/feature/form/domain/util/JsExecutor.kt`

**Step 1: Implement JsExecutor**

```kotlin
package com.neome.feature.form.domain.util

import org.mozilla.javascript.Context
import org.mozilla.javascript.Scriptable
import org.mozilla.javascript.Undefined

/**
 * Executes JavaScript code strings using Mozilla Rhino engine.
 *
 * Usage:
 * ```
 * val result = JsExecutor.execute("2 + 3") // returns 5.0
 * val result = JsExecutor.execute("price * qty", mapOf("price" to 100, "qty" to 5)) // returns 500.0
 * ```
 *
 * Returns `Any?` - the JS result coerced to a Kotlin type:
 * - JS number -> Double
 * - JS string -> String
 * - JS boolean -> Boolean
 * - JS null/undefined -> null
 *
 * Returns null on empty input, syntax errors, or runtime errors.
 */
object JsExecutor {

    /**
     * Execute a JavaScript string and return the result.
     *
     * @param script The JavaScript code to execute
     * @param bindings Optional map of variable name -> value to inject into the JS scope
     * @return The result of the last expression, or null on error/empty input
     */
    fun execute(script: String, bindings: Map<String, Any?> = emptyMap()): Any? {
        if (script.isBlank()) return null

        val cx = Context.enter()
        try {
            // Interpreted mode required for Android (no JIT bytecode generation)
            cx.optimizationLevel = -1
            val scope = cx.initStandardObjects()

            // Inject bindings into scope
            for ((name, value) in bindings) {
                val jsValue = Context.javaToJS(value, scope)
                scope.put(name, scope, jsValue)
            }

            val result = cx.evaluateString(scope, script, "formula", 1, null)
            return normalizeResult(result, scope)
        } catch (_: Exception) {
            return null
        } finally {
            Context.exit()
        }
    }

    /**
     * Converts Rhino JS result to Kotlin-friendly types.
     */
    private fun normalizeResult(result: Any?, scope: Scriptable): Any? {
        return when {
            result == null -> null
            result is Undefined -> null
            else -> {
                val unwrapped = Context.jsToJava(result, Any::class.java)
                when {
                    unwrapped == null -> null
                    unwrapped is Undefined -> null
                    else -> unwrapped
                }
            }
        }
    }
}
```

**Step 2: Run tests to verify they pass**

Run: `./gradlew app:testDebugUnitTest --tests "com.neome.feature.form.domain.util.JsExecutorTest" 2>&1 | tail -20`
Expected: All 19 tests PASS

**Step 3: Commit**

```bash
git add app/src/main/java/com/neome/feature/form/domain/util/JsExecutor.kt
git commit -m "feat: implement JsExecutor with Mozilla Rhino engine"
```

---

### Task 4: Create JsScriptParser - Failing Tests

**Files:**
- Create: `app/src/test/java/com/neome/feature/form/domain/util/JsScriptParserTest.kt`

**Step 1: Write failing tests for JsScriptParser**

```kotlin
package com.neome.feature.form.domain.util

import org.junit.Test
import org.junit.Assert.assertEquals

class JsScriptParserTest {

    @Test
    fun `parse replaces single field placeholder`() {
        val template = "\${f:amount}"
        val values = mapOf("amount" to 100)
        val result = JsScriptParser.parse(template, values)
        assertEquals("100", result)
    }

    @Test
    fun `parse replaces multiple field placeholders`() {
        val template = "\${f:price} * \${f:quantity}"
        val values = mapOf("price" to 50, "quantity" to 3)
        val result = JsScriptParser.parse(template, values)
        assertEquals("50 * 3", result)
    }

    @Test
    fun `parse replaces duplicate placeholders`() {
        val template = "\${f:x} + \${f:x}"
        val values = mapOf("x" to 5)
        val result = JsScriptParser.parse(template, values)
        assertEquals("5 + 5", result)
    }

    @Test
    fun `parse with string value wraps in quotes`() {
        val template = "\${f:name}"
        val values = mapOf("name" to "Alice")
        val result = JsScriptParser.parse(template, values)
        assertEquals("'Alice'", result)
    }

    @Test
    fun `parse with null value replaces with null literal`() {
        val template = "\${f:missing}"
        val values = mapOf("missing" to null)
        val result = JsScriptParser.parse(template, values)
        assertEquals("null", result)
    }

    @Test
    fun `parse with missing key replaces with null literal`() {
        val template = "\${f:unknown}"
        val values = emptyMap<String, Any?>()
        val result = JsScriptParser.parse(template, values)
        assertEquals("null", result)
    }

    @Test
    fun `parse with double value preserves decimal`() {
        val template = "\${f:rate}"
        val values = mapOf("rate" to 0.15)
        val result = JsScriptParser.parse(template, values)
        assertEquals("0.15", result)
    }

    @Test
    fun `parse with boolean value`() {
        val template = "\${f:active}"
        val values = mapOf("active" to true)
        val result = JsScriptParser.parse(template, values)
        assertEquals("true", result)
    }

    @Test
    fun `parse with long value`() {
        val template = "\${f:count}"
        val values = mapOf("count" to 999999999L)
        val result = JsScriptParser.parse(template, values)
        assertEquals("999999999", result)
    }

    @Test
    fun `parse with no placeholders returns original string`() {
        val template = "2 + 3"
        val result = JsScriptParser.parse(template, emptyMap())
        assertEquals("2 + 3", result)
    }

    @Test
    fun `parse empty string returns empty string`() {
        val result = JsScriptParser.parse("", emptyMap())
        assertEquals("", result)
    }

    @Test
    fun `parse preserves surrounding text`() {
        val template = "Math.max(\${f:a}, \${f:b}) + 10"
        val values = mapOf("a" to 5, "b" to 8)
        val result = JsScriptParser.parse(template, values)
        assertEquals("Math.max(5, 8) + 10", result)
    }

    @Test
    fun `parse with dotted field key`() {
        val template = "\${f:Details.Field1}"
        val values = mapOf("Details.Field1" to 42)
        val result = JsScriptParser.parse(template, values)
        assertEquals("42", result)
    }

    @Test
    fun `parse complex formula with mixed types`() {
        val template = "\${f:price} * \${f:qty} * (1 - \${f:discount})"
        val values = mapOf(
            "price" to 100.0,
            "qty" to 5,
            "discount" to 0.1
        )
        val result = JsScriptParser.parse(template, values)
        assertEquals("100.0 * 5 * (1 - 0.1)", result)
    }

    @Test
    fun `parse string value escapes single quotes`() {
        val template = "\${f:name}"
        val values = mapOf("name" to "O'Brien")
        val result = JsScriptParser.parse(template, values)
        assertEquals("'O\\'Brien'", result)
    }
}
```

**Step 2: Run tests to verify they fail**

Run: `./gradlew app:testDebugUnitTest --tests "com.neome.feature.form.domain.util.JsScriptParserTest" 2>&1 | tail -20`
Expected: FAIL - compilation error, `JsScriptParser` does not exist

**Step 3: Commit failing tests**

```bash
git add app/src/test/java/com/neome/feature/form/domain/util/JsScriptParserTest.kt
git commit -m "test: add failing tests for JsScriptParser"
```

---

### Task 5: Implement JsScriptParser

**Files:**
- Create: `app/src/main/java/com/neome/feature/form/domain/util/JsScriptParser.kt`

**Step 1: Implement JsScriptParser**

```kotlin
package com.neome.feature.form.domain.util

/**
 * Parses template strings containing `${f:fieldKey}` placeholders and replaces
 * them with actual values from a provided map.
 *
 * Placeholder syntax: `${f:<key>}` where `<key>` is a lookup key in the values map.
 * Keys can contain dots (e.g. `${f:Details.Field1}`).
 *
 * Value substitution rules:
 * - String values are wrapped in single quotes with internal quotes escaped: `'value'`
 * - Number/Boolean values are inserted as-is: `42`, `true`
 * - Null or missing keys are replaced with the literal `null`
 *
 * Usage:
 * ```
 * val script = JsScriptParser.parse(
 *     "\${f:price} * \${f:qty}",
 *     mapOf("price" to 100, "qty" to 5)
 * )
 * // script = "100 * 5"
 * ```
 */
object JsScriptParser {

    // Matches ${f:someKey} or ${f:some.dotted.key}
    // Group 1 captures the key part after "f:"
    private val PLACEHOLDER_REGEX = Regex("""\$\{f:([^}]+)}""")

    /**
     * Replace all `${f:key}` placeholders in [template] with values from [values].
     *
     * @param template The template string containing `${f:...}` placeholders
     * @param values Map of key -> value for substitution
     * @return The template with all placeholders replaced
     */
    fun parse(template: String, values: Map<String, Any?>): String {
        if (template.isEmpty()) return template

        return PLACEHOLDER_REGEX.replace(template) { matchResult ->
            val key = matchResult.groupValues[1]
            val value = values[key]
            valueToJsLiteral(value)
        }
    }

    /**
     * Converts a Kotlin value to a JS literal string representation.
     *
     * @param value The value to convert
     * @return JS literal: quoted string, number, boolean, or "null"
     */
    private fun valueToJsLiteral(value: Any?): String {
        if (value == null) return "null"

        return when (value) {
            is String -> {
                val escaped = value.replace("'", "\\'")
                "'$escaped'"
            }
            is Number -> value.toString()
            is Boolean -> value.toString()
            else -> {
                val escaped = value.toString().replace("'", "\\'")
                "'$escaped'"
            }
        }
    }
}
```

**Step 2: Run tests to verify they pass**

Run: `./gradlew app:testDebugUnitTest --tests "com.neome.feature.form.domain.util.JsScriptParserTest" 2>&1 | tail -20`
Expected: All 15 tests PASS

**Step 3: Commit**

```bash
git add app/src/main/java/com/neome/feature/form/domain/util/JsScriptParser.kt
git commit -m "feat: implement JsScriptParser for template placeholder substitution"
```

---

### Task 6: Integration Test - Parse Then Execute

**Files:**
- Create: `app/src/test/java/com/neome/feature/form/domain/util/JsParseAndExecuteTest.kt`

**Step 1: Write integration tests that combine parser + executor**

```kotlin
package com.neome.feature.form.domain.util

import org.junit.Test
import org.junit.Assert.assertEquals

/**
 * Integration tests: parse a template with JsScriptParser, then execute with JsExecutor.
 * Validates the two utilities work together end-to-end.
 */
class JsParseAndExecuteTest {

    private fun parseAndExecute(template: String, values: Map<String, Any?>): Any? {
        val script = JsScriptParser.parse(template, values)
        return JsExecutor.execute(script)
    }

    @Test
    fun `simple addition formula`() {
        val result = parseAndExecute(
            "\${f:a} + \${f:b}",
            mapOf("a" to 10, "b" to 20)
        )
        assertEquals(30.0, (result as Number).toDouble(), 0.001)
    }

    @Test
    fun `price calculation with discount`() {
        val result = parseAndExecute(
            "\${f:price} * \${f:qty} * (1 - \${f:discount})",
            mapOf("price" to 100, "qty" to 5, "discount" to 0.1)
        )
        assertEquals(450.0, (result as Number).toDouble(), 0.001)
    }

    @Test
    fun `string concatenation formula`() {
        val result = parseAndExecute(
            "\${f:first} + ' ' + \${f:last}",
            mapOf("first" to "John", "last" to "Doe")
        )
        assertEquals("John Doe", result)
    }

    @Test
    fun `conditional formula with ternary`() {
        val result = parseAndExecute(
            "\${f:score} >= 50 ? 'Pass' : 'Fail'",
            mapOf("score" to 75)
        )
        assertEquals("Pass", result)
    }

    @Test
    fun `math function in formula`() {
        val result = parseAndExecute(
            "Math.round(\${f:value} * 100) / 100",
            mapOf("value" to 3.14159)
        )
        assertEquals(3.14, (result as Number).toDouble(), 0.001)
    }

    @Test
    fun `null value handling in formula`() {
        val result = parseAndExecute(
            "\${f:x} === null ? 0 : \${f:x}",
            mapOf("x" to null)
        )
        assertEquals(0.0, (result as Number).toDouble(), 0.001)
    }

    @Test
    fun `formula with dotted field keys`() {
        val result = parseAndExecute(
            "\${f:Details.Price} * \${f:Details.Quantity}",
            mapOf("Details.Price" to 25, "Details.Quantity" to 4)
        )
        assertEquals(100.0, (result as Number).toDouble(), 0.001)
    }
}
```

**Step 2: Run all tests to verify they pass**

Run: `./gradlew app:testDebugUnitTest --tests "com.neome.feature.form.domain.util.*" 2>&1 | tail -30`
Expected: All 41 tests PASS (19 JsExecutor + 15 JsScriptParser + 7 integration)

**Step 3: Commit**

```bash
git add app/src/test/java/com/neome/feature/form/domain/util/JsParseAndExecuteTest.kt
git commit -m "test: add integration tests for JsScriptParser + JsExecutor pipeline"
```

---

### Task 7: Run Full Test Suite

**Step 1: Run all project tests to ensure nothing is broken**

Run: `./gradlew app:testDebugUnitTest 2>&1 | tail -30`
Expected: BUILD SUCCESSFUL, all existing tests still pass

**Step 2: Final commit if any cleanup was needed**

If all tests pass, no commit needed. If any adjustments were required, commit them.

---

## Summary

| File | Action | Description |
|------|--------|-------------|
| `gradle/libs.versions.toml` | Modify | Add `rhino = "1.7.15"` version + library entry |
| `app/build.gradle.kts` | Modify | Add `implementation(libs.rhino)` |
| `app/src/main/java/.../util/JsExecutor.kt` | Create | Rhino-based JS string executor, returns `Any?` |
| `app/src/main/java/.../util/JsScriptParser.kt` | Create | Regex-based `${f:key}` placeholder substitution |
| `app/src/test/.../util/JsExecutorTest.kt` | Create | 19 unit tests for JsExecutor |
| `app/src/test/.../util/JsScriptParserTest.kt` | Create | 15 unit tests for JsScriptParser |
| `app/src/test/.../util/JsParseAndExecuteTest.kt` | Create | 7 integration tests for combined pipeline |

**Total: 7 tasks, 41 tests, 7 commits**
