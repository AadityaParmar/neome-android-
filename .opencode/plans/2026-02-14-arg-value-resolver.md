# ArgValueResolver Kotlin Port - Implementation Plan

> **For Claude:** REQUIRED SUB-SKILL: Use superpowers:executing-plans to implement this plan task-by-task.

**Goal:** Port `ArgValueResolverPlus.ts` to Kotlin as a set of pure utility objects in the form domain util package, enabling runtime resolution of `DefnDtoText`/`DefnDtoParagraph` variables embedded in form definitions.

**Architecture:** The resolver parses JSON-embedded arg values from `DefnDtoText.value` string lists, resolves them against the form definition and caller entity context, and returns new `DefnDtoTextData`/`DefnDtoParagraphData` instances with resolved plain-text values. `resolveDefnForm` walks the entire form tree, resolving all `*Var` properties on components and returning a new form copy with resolved values. Layout-related resolution is stubbed because the Android serialization layer lacks polymorphic layout deserialization.

**Tech Stack:** Kotlin, kotlinx.serialization (JSON parsing), java.time (date/time), existing project types from `com.neome.api.*` and `com.neome.core.common.serializer.*`

---

## Context for Implementor

### Key Codebase Facts

1. **Two-tier type system:** API interfaces live in `com.neome.api.meta.base.dto` (e.g., `DefnDtoText`). Concrete `@Serializable data class` implementations live in `com.neome.core.common.serializer.api.meta.base.dto` (e.g., `DefnDtoTextData`). Sealed interfaces (e.g., `DefnCompSeal`) enable `when` dispatch on concrete types.

2. **Data classes are flat:** `DefnFieldButtonData` does NOT extend `DefnFieldEditableData`. Instead it directly implements the `DefnFieldButton` interface (which extends `DefnFieldEditable`), flattening ALL inherited properties into its constructor. So `.copy()` on `DefnFieldButtonData` gives access to `helperTextVar`, `placeHolderVar`, `prefixVar`, `suffixVar`, `toastMessageOnClickVar`, `whatsAppMessage`, etc.

3. **`DefnDtoText` and `DefnDtoParagraph` are structurally identical:** Both have `val value: List<String>?`. Many `*Var` properties use `DefnDtoTextData?`, but some use `DefnDtoParagraphData?` (see table below).

4. **Type property:** `DefnComp.type` is `EnumDefnCompType` (not a raw String). Use enum values like `EnumDefnCompType.button`.

5. **Symbol type:** `DtoEntRole.name` is `Symbol` (extends `AnyValue`). Use `.value` to get the underlying `String?`.

6. **Existing JSON parser:** `com.neome.feature.utils.JsonParser.json` is a configured `kotlinx.serialization.json.Json` instance with `ignoreUnknownKeys = true`.

7. **Existing form traversal:** `FormPlus.loopDefnForm(defnForm, cb)` recursively walks the form tree calling `cb(comp, parent)` for each component.

8. **`DefnFormUi`** is the UI-enriched form data class at `com.neome.feature.form.domain.TypesForm.kt:103`. It implements `DefnForm` and has `.copy()`.

9. **`DefnFormData`** also implements `DefnForm` and has `.copy()`. Located at `com.neome.core.common.serializer.api.meta.base.dto.DefnFormData`.

10. **`FormPlus.loopDefnForm`** accepts `DefnFormData`, not `DefnForm` interface. Since `DefnFormUi` is a separate data class that also implements `DefnForm`, you need to handle this. `DefnFormUi` has all the same fields as `DefnFormData` (it was designed to be a superset).

### Property Type Reference

| Data Class | Property | Type |
|---|---|---|
| All `DefnFieldEditable` subtypes | `helperTextVar` | `DefnDtoTextData?` |
| All `DefnFieldEditable` subtypes | `placeHolderVar` | `DefnDtoTextData?` |
| All `DefnFieldEditable` subtypes | `prefixVar` | `DefnDtoTextData?` |
| All `DefnFieldEditable` subtypes | `suffixVar` | `DefnDtoTextData?` |
| `DefnFieldTextData`, `DefnFieldPasswordData`, `DefnFieldEditableTextData` | `defaultVar` | `DefnDtoTextData?` |
| `DefnFieldParagraphData`, `DefnFieldShowCodeData`, `DefnFieldInfoData`, `DefnFieldHtmlData` | `defaultVar` | `DefnDtoParagraphData?` |
| `DefnFieldHtmlData` | `placeHolderVar` | `DefnDtoParagraphData?` |
| `DefnFieldButtonData` | `toastMessageOnClickVar` | `DefnDtoTextData?` |
| `DefnFieldButtonData` | `whatsAppMessage` | `DefnDtoParagraphData?` |
| `DefnFieldSwitchData` | `checkboxLabelVar` | `DefnDtoTextData?` |
| `DefnFieldIdentifierData` | `textPatternVar` | `DefnDtoTextData?` |
| `DefnFieldHyperlinkRowData` | `displayTextVar` | `DefnDtoTextData?` |
| `DefnFieldLabelData` | `textPatternVar` | `DefnDtoTextData?` |
| `DefnFieldInfoData` | `labelPatternVar` | `DefnDtoTextData?` |
| `DefnFieldInfoData` | `textPatternVar` | `DefnDtoTextData?` (inherited from Label) |
| `DefnLayoutFormWatermarkData` | `textPatternVar` | `DefnDtoTextData?` |
| `DefnDtoLayoutCardItemLineSegmentData` | `lineVar` | `DefnDtoTextData?` |
| `DefnDtoLayoutLocmapPinData` | `labelVar` | `DefnDtoTextData?` |
| `DefnDtoLayoutLocmapPinData` | `toolTipVar` | `DefnDtoParagraphData?` |
| `DefnDtoMediaData` | `html` | `DefnDtoParagraphData?` |
| `DefnFormUi` | `chatLabelPatternVar` | `DefnDtoTextData?` |
| `DefnFormUi` | `chatPatternVar` | `DefnDtoParagraphData?` |

### Non-Editable field types (no helperTextVar/placeHolderVar/prefixVar/suffixVar)

- `DefnFieldLabelData` - implements `DefnFieldLabel` (extends `DefnField`, NOT `DefnFieldEditable`)
- `DefnFieldInfoData` - implements `DefnFieldInfo` (extends `DefnFieldLabel`)
- `DefnFieldHtmlData` - implements `DefnFieldHtml` (extends `DefnField`)

### Layout Limitation

`DefnLayoutFormMapData.map` stores `DefnLayoutFormData` (base class: only `metaId`, `name`, `type`). `DefnLayoutGridMapData.map` stores `DefnLayoutGridData` (base class: only `kind`, `metaId`, `name`, etc.). Neither contains subtype-specific properties like `watermark`, `item`, `mapPin`. Polymorphic serialization for layouts is not set up. Layout resolution methods must be **stubbed with TODO**.

---

## Task 1: Create `StringPlus.kt` - JSON String Detection Utility

**Files:**
- Create: `app/src/main/java/com/neome/feature/form/domain/util/StringPlus.kt`

**Step 1: Create the file**

```kotlin
package com.neome.feature.form.domain.util

import kotlinx.serialization.json.Json

/**
 * String utility functions for form resolution.
 */
object StringPlus {

    /**
     * Returns true if the given string is valid JSON.
     *
     * Port of: webapp/src/base/plus/StringPlus.ts > isJsonString
     */
    fun isJsonString(str: String): Boolean {
        return try {
            Json.parseToJsonElement(str)
            true
        } catch (_: Exception) {
            false
        }
    }
}
```

**Step 2: Verify it compiles**

Run: `./gradlew compileDebugKotlin 2>&1 | tail -5`
Expected: BUILD SUCCESSFUL

**Step 3: Commit**

```bash
git add app/src/main/java/com/neome/feature/form/domain/util/StringPlus.kt
git commit -m "feat(form): add StringPlus utility with isJsonString"
```

---

## Task 2: Create `DatePlus.kt` - Date/Time Resolution Utilities

**Files:**
- Create: `app/src/main/java/com/neome/feature/form/domain/util/DatePlus.kt`

**Step 1: Create the file**

```kotlin
package com.neome.feature.form.domain.util

import com.neome.api.meta.base.Types.EnumDefnDate
import com.neome.api.meta.base.Types.EnumDefnTime
import com.neome.api.meta.base.dto.DefnBuildDate
import com.neome.api.meta.base.dto.DefnBuildDateTime
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import java.time.temporal.TemporalAdjusters

/**
 * Date/time utility functions for form arg-value resolution.
 *
 * Port of:
 * - webapp/src/base/plus/NeomeDatePlus.ts (calcDefnBuildDate, calcDefnBuildDateTime, resolveEnumDefnDate)
 * - webapp/src/base/plus/ArgBinderPlus.ts (resolveTimeValue)
 * - webapp/src/base/plus/DatePlus.ts (formatDate, dateToLocalString)
 */
object DatePlus {

    // region --- Time Resolution ---

    /**
     * Resolves an [EnumDefnTime] to a time string.
     * Currently only "now" is defined, returning the current time in "HH:mm:ss" format.
     *
     * Port of: ArgBinderPlus.ts > resolveTimeValue
     */
    fun resolveTimeValue(value: EnumDefnTime?): String? {
        if (value == null) return null
        return when (value) {
            EnumDefnTime.now -> {
                val now = LocalDateTime.now()
                now.format(DateTimeFormatter.ofPattern("HH:mm:ss"))
            }
        }
    }

    // endregion

    // region --- Enum Date Resolution ---

    /**
     * Resolves an [EnumDefnDate] to an ISO date string based on the current date/time.
     * Returns null for context-dependent values like createdOn/updatedOn.
     *
     * Port of: NeomeDatePlus.ts > resolveEnumDefnDate
     */
    fun resolveEnumDefnDate(value: EnumDefnDate): String? {
        val now = ZonedDateTime.now(ZoneOffset.UTC)

        return when (value) {
            EnumDefnDate.now -> now.toInstant().toString()
            EnumDefnDate.yesterday -> now.minusDays(1).toInstant().toString()
            EnumDefnDate.tomorrow -> now.plusDays(1).toInstant().toString()

            EnumDefnDate.startOfWeek -> now
                .with(TemporalAdjusters.previousOrSame(java.time.DayOfWeek.SUNDAY))
                .toLocalDate().atStartOfDay(ZoneOffset.UTC).toInstant().toString()

            EnumDefnDate.endOfWeek -> now
                .with(TemporalAdjusters.nextOrSame(java.time.DayOfWeek.SATURDAY))
                .toLocalDate().atTime(23, 59, 59, 999_000_000)
                .atZone(ZoneOffset.UTC).toInstant().toString()

            EnumDefnDate.startOfMonth -> now.toLocalDate()
                .with(TemporalAdjusters.firstDayOfMonth())
                .atStartOfDay(ZoneOffset.UTC).toInstant().toString()

            EnumDefnDate.endOfMonth -> now.toLocalDate()
                .with(TemporalAdjusters.lastDayOfMonth())
                .atTime(23, 59, 59, 999_000_000)
                .atZone(ZoneOffset.UTC).toInstant().toString()

            EnumDefnDate.startOfYear -> LocalDate.of(now.year, 1, 1)
                .atStartOfDay(ZoneOffset.UTC).toInstant().toString()

            EnumDefnDate.endOfYear -> LocalDate.of(now.year, 12, 31)
                .atTime(23, 59, 59, 999_000_000)
                .atZone(ZoneOffset.UTC).toInstant().toString()

            EnumDefnDate.lastWeek -> now.minusWeeks(1).toInstant().toString()
            EnumDefnDate.nextWeek -> now.plusWeeks(1).toInstant().toString()
            EnumDefnDate.lastMonth -> now.minusMonths(1).toInstant().toString()
            EnumDefnDate.nextMonth -> now.plusMonths(1).toInstant().toString()
            EnumDefnDate.lastQuarter -> now.minusMonths(3).toInstant().toString()
            EnumDefnDate.nextQuarter -> now.plusMonths(3).toInstant().toString()
            EnumDefnDate.lastYear -> now.minusYears(1).toInstant().toString()
            EnumDefnDate.nextYear -> now.plusYears(1).toInstant().toString()

            // Context-dependent — need row data to resolve
            EnumDefnDate.createdOn,
            EnumDefnDate.updatedOn -> null
        }
    }

    // endregion

    // region --- DefnBuild Date/DateTime Resolution ---

    /**
     * Resolves a [DefnBuildDate] to an ISO date string.
     * Tries customValue first, then resolves the enum value using the given timezone.
     *
     * Port of: NeomeDatePlus.ts > calcDefnBuildDate
     */
    fun calcDefnBuildDate(defnBuildDate: DefnBuildDate, timeZone: String): String? {
        val customDate = defnBuildDate.customValue
        val value = defnBuildDate.value

        if (customDate != null) {
            return customDate
        }

        if (value != null) {
            val isoDate = resolveEnumDefnDate(value)
            if (isoDate != null) {
                return convertDateForServer(timeZone, isoDate)
            }
        }

        return null
    }

    /**
     * Resolves a [DefnBuildDateTime] to an ISO date-time string.
     * Handles custom date + optional time component, or enum value + optional time.
     *
     * Port of: NeomeDatePlus.ts > calcDefnBuildDateTime
     */
    fun calcDefnBuildDateTime(defnBuildDateTime: DefnBuildDateTime, timeZone: String): String? {
        val customDate = defnBuildDateTime.customValue
        val value = defnBuildDateTime.value
        val time = defnBuildDateTime.time?.value // AnyTime extends AnyValue, .value is String?

        if (customDate != null) {
            if (time != null) {
                return applyTimeToIsoDate(customDate, time)
            }
            return customDate
        }

        if (value != null) {
            val isoDate = resolveEnumDefnDate(value)
            if (isoDate != null) {
                if (time != null) {
                    return applyTimeToIsoDate(isoDate, time)
                }
                return isoDate
            }
        }

        return null
    }

    // endregion

    // region --- Date Formatting ---

    /**
     * Formats an ISO date string using the given format.
     * Falls back to locale default if format is null.
     *
     * Port of: DatePlus.ts > formatDate
     *
     * @param dateStrISO ISO 8601 date string
     * @param dateTimeFormat format pattern, or "ISO"/"UTC"/"local", or null for locale default
     * @param includeTime whether to include time in the output
     */
    fun formatDate(dateStrISO: String, dateTimeFormat: String?, includeTime: Boolean): String? {
        val instant = parseIsoDate(dateStrISO) ?: return null

        if (includeTime) {
            val zonedDateTime = instant.atZone(ZoneId.systemDefault())
            return when (dateTimeFormat) {
                "ISO" -> instant.toString()
                "UTC" -> instant.atZone(ZoneOffset.UTC)
                    .format(DateTimeFormatter.RFC_1123_DATE_TIME)
                "local" -> zonedDateTime.format(
                    DateTimeFormatter.ofLocalizedDateTime(java.time.format.FormatStyle.MEDIUM)
                )
                null -> zonedDateTime.format(
                    DateTimeFormatter.ofLocalizedDateTime(java.time.format.FormatStyle.MEDIUM)
                )
                else -> tryFormatWithPattern(zonedDateTime, dateTimeFormat)
            }
        } else {
            val localDate = instant.atZone(ZoneOffset.UTC).toLocalDate()
            return when (dateTimeFormat) {
                "ISO" -> localDate.toString()
                "UTC" -> localDate.toString()
                "local" -> localDate.format(
                    DateTimeFormatter.ofLocalizedDate(java.time.format.FormatStyle.MEDIUM)
                )
                null -> localDate.format(
                    DateTimeFormatter.ofLocalizedDate(java.time.format.FormatStyle.MEDIUM)
                )
                else -> tryFormatWithPattern(
                    localDate.atStartOfDay(ZoneId.systemDefault()),
                    dateTimeFormat
                )
            }
        }
    }

    /**
     * Converts an ISO date string to a locale-formatted date string.
     *
     * Port of: DatePlus.ts > dateToLocalString
     */
    fun dateToLocalString(value: String): String {
        val instant = parseIsoDate(value)
            ?: return value
        val localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate()
        return localDate.format(
            DateTimeFormatter.ofLocalizedDate(java.time.format.FormatStyle.MEDIUM)
        )
    }

    // endregion

    // region --- Private Helpers ---

    /**
     * Strips the time component from a date and adjusts for timezone difference.
     *
     * Port of: NeomeDatePlus.ts > convertDateForServer
     */
    private fun convertDateForServer(timeZone: String, isoDate: String): String {
        val instant = parseIsoDate(isoDate) ?: return isoDate
        val zoneId = tryParseZoneId(timeZone) ?: return isoDate

        val localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate()
        return localDate.atStartOfDay(zoneId).toInstant().toString()
    }

    /**
     * Parses an ISO date string to an [Instant].
     * Handles both full ISO-8601 and date-only formats.
     */
    private fun parseIsoDate(dateStr: String): Instant? {
        return try {
            Instant.parse(dateStr)
        } catch (_: DateTimeParseException) {
            try {
                LocalDate.parse(dateStr).atStartOfDay(ZoneOffset.UTC).toInstant()
            } catch (_: DateTimeParseException) {
                null
            }
        }
    }

    /**
     * Applies a time string ("HH:mm:ss") to an ISO date string.
     */
    private fun applyTimeToIsoDate(isoDate: String, time: String): String {
        val instant = parseIsoDate(isoDate) ?: return isoDate
        val parts = time.split(":")
        if (parts.size < 3) return isoDate

        val hour = parts[0].toIntOrNull() ?: 0
        val min = parts[1].toIntOrNull() ?: 0
        val sec = parts[2].toIntOrNull() ?: 0

        val zonedDateTime = instant.atZone(ZoneOffset.UTC)
        return zonedDateTime
            .withHour(hour)
            .withMinute(min)
            .withSecond(sec)
            .toInstant()
            .toString()
    }

    /**
     * Tries to parse a timezone string to a [ZoneId].
     */
    private fun tryParseZoneId(timeZone: String): ZoneId? {
        return try {
            ZoneId.of(timeZone)
        } catch (_: Exception) {
            null
        }
    }

    /**
     * Tries to format a [ZonedDateTime] with the given pattern.
     * Falls back to ISO format on parse failure.
     */
    private fun tryFormatWithPattern(dateTime: ZonedDateTime, pattern: String): String {
        return try {
            dateTime.format(DateTimeFormatter.ofPattern(pattern))
        } catch (_: IllegalArgumentException) {
            dateTime.toInstant().toString()
        }
    }

    // endregion
}
```

**Step 2: Verify it compiles**

Run: `./gradlew compileDebugKotlin 2>&1 | tail -5`
Expected: BUILD SUCCESSFUL

**Step 3: Commit**

```bash
git add app/src/main/java/com/neome/feature/form/domain/util/DatePlus.kt
git commit -m "feat(form): add DatePlus utility with date/time resolution functions"
```

---

## Task 3: Create `ArgValueResolver.kt` - Private Data Classes + resolve + resolveArgVal

**Files:**
- Create: `app/src/main/java/com/neome/feature/form/domain/util/ArgValueResolver.kt`

**Step 1: Create the file**

```kotlin
package com.neome.feature.form.domain.util

import android.util.Log
import com.neome.api.ent.entDrawer.sig.SigEntCaller
import com.neome.api.meta.base.Types.EnumDefnArgBinder
import com.neome.api.meta.base.Types.EnumDefnArgBinderContext
import com.neome.api.meta.base.Types.EnumDefnCompType
import com.neome.api.meta.base.Types.EnumDefnDate
import com.neome.api.meta.base.Types.EnumDefnTime
import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.api.meta.base.dto.DefnComp
import com.neome.api.meta.base.dto.DefnDtoParagraph
import com.neome.api.meta.base.dto.DefnDtoText
import com.neome.api.meta.base.dto.DefnField
import com.neome.api.meta.base.dto.DefnFieldDate
import com.neome.api.meta.base.dto.DefnFieldDateTime
import com.neome.api.meta.base.dto.DefnFieldPickText
import com.neome.api.meta.base.dto.DefnForm
import com.neome.api.meta.base.dto.DefnGrid
import com.neome.api.meta.base.dto.DefnSection
import com.neome.api.meta.base.dto.DefnTab
import com.neome.api.meta.base.dto.DefnWizard
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.core.common.serializer.api.meta.base.dto.DefnDtoParagraphData
import com.neome.core.common.serializer.api.meta.base.dto.DefnDtoTextData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldButtonData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldHtmlData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldHyperlinkRowData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldIdentifierData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldInfoData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldLabelData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldParagraphData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldShowCodeData
import com.neome.core.common.serializer.api.meta.base.dto.DefnFieldSwitchData
import com.neome.core.common.serializer.api.meta.base.dto.DefnGridData
import com.neome.feature.form.domain.DefnFormUi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject

/**
 * Resolves arg-value variables embedded in [DefnDtoText] and [DefnDtoParagraph] properties.
 *
 * [DefnDtoText.value] contains a list of strings. Each string is either:
 * - A plain text literal (e.g., "Hello ")
 * - A JSON-encoded [ArgValueForClient] object (e.g., `{"kind":"context","argValue":{...}}`)
 *
 * This resolver parses each string, resolves the arg-value based on its kind
 * (context, derived, variable, field), and returns a new [DefnDtoTextData] with
 * the resolved plain-text values.
 *
 * Port of: webapp/src/base/plus/ArgValueResolverPlus.ts > ArgValueResolver
 */
object ArgValueResolver {

    private const val TAG = "ArgValueResolver"

    // region --- Private Data Classes (JSON-embedded types) ---

    /**
     * Represents a variable's custom value metadata.
     * Parsed from JSON strings embedded in DefnDtoText.value entries.
     *
     * Port of: ArgValueResolverPlus.ts > TypeCustomValueMap
     */
    @Serializable
    private data class CustomValueMap(
        val id: String = "",
        val kind: String = "",
        val name: String = ""
    )

    /**
     * Custom value for date variables.
     * Port of: ArgValueResolverPlus.ts > TypeCustomValueDate
     */
    @Serializable
    private data class CustomValueDate(
        val id: String = "",
        val kind: String = "",
        val name: String = "",
        val value: EnumDefnDate? = null,
        val customDate: String? = null // ISO date string
    )

    /**
     * Custom value for time variables.
     * Port of: ArgValueResolverPlus.ts > TypeCustomValueTime
     */
    @Serializable
    private data class CustomValueTime(
        val id: String = "",
        val kind: String = "",
        val name: String = "",
        val customValue: String? = null, // "HH:mm:ss" format
        val value: EnumDefnTime? = null
    )

    /**
     * Custom value for dateTime variables.
     * Port of: ArgValueResolverPlus.ts > TypeCustomValueDateTime
     */
    @Serializable
    private data class CustomValueDateTime(
        val id: String = "",
        val kind: String = "",
        val name: String = "",
        val value: EnumDefnDate? = null,
        val customDate: String? = null,
        val customTime: String? = null // "HH:mm:ss" format
    )

    /**
     * The client-side arg-value wrapper parsed from JSON in DefnDtoText.value entries.
     * Port of: ArgValueResolverPlus.ts > StudioDtoArgValueForClient
     */
    @Serializable
    private data class ArgValueForClient(
        val kind: EnumDefnArgBinder,
        val argValue: JsonObject,
        val customValueMap: JsonObject? = null
    )

    /**
     * Minimal parsed derived arg-value.
     */
    @Serializable
    private data class ParsedArgValueDerived(
        val derivedFieldId: String,
        val derivedFieldType: EnumDefnCompType? = null,
        val valueBoolean: Boolean? = null,
        val valueDate: String? = null,
        val valueDouble: Double? = null,
        val valueLong: Long? = null,
        val valueOptionId: String? = null,
        val valueText: String? = null
    )

    /**
     * Lenient JSON parser for embedded arg-value JSON strings.
     * These strings may have unknown keys that the outer JsonParser does not expect.
     */
    private val lenientJson = Json {
        ignoreUnknownKeys = true
        coerceInputValues = true
        isLenient = true
    }

    // endregion

    // region --- Public API ---

    /**
     * Resolves a [DefnDtoText] by processing each string in its value list.
     * Returns a new [DefnDtoTextData] with resolved plain-text values.
     *
     * Port of: ArgValueResolverPlus.ts > resolve (returns { value: newValue })
     *
     * @param defnDtoText the text definition containing arg-value JSON strings
     * @param defnForm the form definition for field lookups
     * @param callerEnt the caller entity for context resolution
     * @param skipResolveSeqVar if true, sequence variables return the raw JSON string
     * @return resolved [DefnDtoTextData] or null if input is null
     */
    fun resolve(
        defnDtoText: DefnDtoText?,
        defnForm: DefnForm,
        callerEnt: SigEntCaller,
        skipResolveSeqVar: Boolean = false
    ): DefnDtoTextData? {
        if (defnDtoText == null) return null

        val resolved = resolveValueList(defnDtoText.value, defnForm, callerEnt, skipResolveSeqVar)
        return DefnDtoTextData(value = resolved)
    }

    /**
     * Resolves a [DefnDtoParagraph] by processing each string in its value list.
     * Returns a new [DefnDtoParagraphData] with resolved plain-text values.
     *
     * Needed because some *Var properties use DefnDtoParagraph instead of DefnDtoText.
     * Both interfaces have identical structure: val value: List<String>?
     *
     * @param defnDtoParagraph the paragraph definition containing arg-value JSON strings
     * @param defnForm the form definition for field lookups
     * @param callerEnt the caller entity for context resolution
     * @param skipResolveSeqVar if true, sequence variables return the raw JSON string
     * @return resolved [DefnDtoParagraphData] or null if input is null
     */
    fun resolveParagraph(
        defnDtoParagraph: DefnDtoParagraph?,
        defnForm: DefnForm,
        callerEnt: SigEntCaller,
        skipResolveSeqVar: Boolean = false
    ): DefnDtoParagraphData? {
        if (defnDtoParagraph == null) return null

        val resolved = resolveValueList(
            defnDtoParagraph.value, defnForm, callerEnt, skipResolveSeqVar
        )
        return DefnDtoParagraphData(value = resolved)
    }

    // endregion

    // region --- Value List Resolution ---

    /**
     * Core resolution logic: iterates through each string in the value list,
     * resolves arg-values, and collects non-null results.
     */
    private fun resolveValueList(
        valueList: List<String>?,
        defnForm: DefnForm,
        callerEnt: SigEntCaller,
        skipResolveSeqVar: Boolean
    ): List<String> {
        val result = mutableListOf<String>()
        valueList?.forEach { argStr ->
            val resolvedVal = resolveArgVal(argStr, defnForm, callerEnt, skipResolveSeqVar)
            if (resolvedVal != null) {
                result.add(resolvedVal)
            }
        }
        return result
    }

    // endregion

    // region --- Arg Value Resolution ---

    /**
     * Resolves a single arg-value string.
     * If the string is not valid JSON, returns it as-is (plain text literal).
     * If it is JSON, parses and dispatches based on [EnumDefnArgBinder] kind.
     *
     * Port of: ArgValueResolverPlus.ts > resolveArgVal
     */
    private fun resolveArgVal(
        argStr: String,
        defnForm: DefnForm,
        callerEnt: SigEntCaller,
        skipResolveSeqVar: Boolean
    ): String? {
        if (argStr.isBlank() || !StringPlus.isJsonString(argStr)) {
            return argStr
        }

        return try {
            val parsed = lenientJson.decodeFromString<ArgValueForClient>(argStr)

            when (parsed.kind) {
                EnumDefnArgBinder.Context ->
                    resolveArgValCtx(parsed.argValue, argStr)

                EnumDefnArgBinder.derived ->
                    resolveArgValDerived(parsed.argValue, argStr, defnForm, callerEnt)

                EnumDefnArgBinder.variable ->
                    resolveArgValVariable(
                        argStr, callerEnt, parsed.customValueMap, skipResolveSeqVar
                    )

                EnumDefnArgBinder.field ->
                    argStr // Field values are resolved later with actual row data

                else -> argStr
            }
        } catch (e: Exception) {
            Log.e(TAG, "Failed to parse arg value: $argStr", e)
            argStr
        }
    }

    // endregion

    // region --- Context Resolution ---

    /**
     * Resolves a context-type arg value.
     * Currently returns the raw JSON string for all context types
     * (caller, callerSetting, ent, row values need runtime data to resolve).
     *
     * Port of: ArgValueResolverPlus.ts > resolveArgValCtx
     */
    private fun resolveArgValCtx(
        argValueJson: JsonObject,
        argStr: String
    ): String {
        // TODO: Resolve caller/ent context values when runtime data is available
        return argStr
    }

    // endregion

    // region --- Derived Resolution ---

    /**
     * Resolves a derived-type arg value by extracting the pre-computed value
     * from the arg-value payload based on the derived field's type.
     *
     * Port of: ArgValueResolverPlus.ts > resolveArgValDerived
     */
    private fun resolveArgValDerived(
        argValueJson: JsonObject,
        argStr: String,
        defnForm: DefnForm,
        callerEnt: SigEntCaller
    ): String? {
        val argValue = try {
            lenientJson.decodeFromJsonElement(
                ParsedArgValueDerived.serializer(), argValueJson
            )
        } catch (_: Exception) {
            return argStr
        }

        val derivedFieldType = argValue.derivedFieldType ?: return argStr

        // Look up the field in the compMap
        val field = findCompByFieldId(defnForm.compMap, argValue.derivedFieldId) ?: return argStr

        return when (derivedFieldType) {
            EnumDefnCompType.bool -> {
                val valueBoolean = argValue.valueBoolean
                if (valueBoolean != null) {
                    if (valueBoolean) "Yes" else "No"
                } else null
            }

            EnumDefnCompType.date,
            EnumDefnCompType.dateTime -> {
                val valueDate = argValue.valueDate ?: return null
                val isDateTime = (derivedFieldType == EnumDefnCompType.dateTime)
                val displayDateFormat = getDisplayDateFormat(field, callerEnt)

                if (displayDateFormat != null) {
                    DatePlus.formatDate(valueDate, displayDateFormat, isDateTime)
                } else {
                    DatePlus.dateToLocalString(valueDate)
                }
            }

            EnumDefnCompType.rating,
            EnumDefnCompType.decimal -> {
                argValue.valueDouble?.toString()
            }

            EnumDefnCompType.number,
            EnumDefnCompType.counter -> {
                argValue.valueLong?.toString()
            }

            EnumDefnCompType.symbol,
            EnumDefnCompType.text,
            EnumDefnCompType.paragraph,
            EnumDefnCompType.hyperlink,
            EnumDefnCompType.mobileNumber,
            EnumDefnCompType.email,
            EnumDefnCompType.handle,
            EnumDefnCompType.spreadsheetId -> {
                argValue.valueText
            }

            EnumDefnCompType.pickText -> {
                val optionId = argValue.valueOptionId
                if (optionId != null) {
                    val pickText = field as? DefnFieldPickText
                    pickText?.optionMap?.map?.get(optionId)?.value ?: optionId
                } else {
                    optionId
                }
            }

            EnumDefnCompType.language,
            EnumDefnCompType.timeZone,
            EnumDefnCompType.currency -> {
                argValue.valueOptionId
            }

            EnumDefnCompType.pickTree -> "" // TODO: implement pickTree resolution
            EnumDefnCompType.paymentStatus -> "" // TODO: implement paymentStatus resolution

            EnumDefnCompType.pickRole -> {
                val optionId = argValue.valueOptionId
                if (optionId != null) {
                    findRoleName(callerEnt, optionId)
                } else {
                    optionId
                }
            }

            else -> argStr
        }
    }

    // endregion

    // region --- Variable Resolution ---

    /**
     * Resolves a variable-type arg value using the customValueMap metadata.
     * Dispatches based on the variable kind (date, dateTime, time, sequence, etc.).
     *
     * Port of: ArgValueResolverPlus.ts > resolveArgValVariable
     */
    private fun resolveArgValVariable(
        argStr: String,
        callerEnt: SigEntCaller,
        customValueMapJson: JsonObject?,
        skipResolveSeqVar: Boolean
    ): String? {
        if (customValueMapJson == null) return null

        val baseMap = try {
            lenientJson.decodeFromJsonElement(CustomValueMap.serializer(), customValueMapJson)
        } catch (_: Exception) {
            return null
        }

        return when (baseMap.kind) {
            "date" -> resolveVariableDate(customValueMapJson, callerEnt)
            "dateTime" -> resolveVariableDateTime(customValueMapJson, callerEnt)
            "time" -> resolveVariableTime(customValueMapJson)
            "sequence" -> {
                if (skipResolveSeqVar) argStr else baseMap.name
            }
            "setOfDate" -> baseMap.name // TODO: proper resolution
            else -> baseMap.name
        }
    }

    /**
     * Resolves a date-kind variable using DefnBuildDate-style logic.
     */
    private fun resolveVariableDate(
        json: JsonObject,
        callerEnt: SigEntCaller
    ): String? {
        val variable = try {
            lenientJson.decodeFromJsonElement(CustomValueDate.serializer(), json)
        } catch (_: Exception) {
            return null
        }

        val timeZone = callerEnt.timeZone?.value
        if (timeZone != null) {
            val defnBuildDate = object : com.neome.api.meta.base.dto.DefnBuildDate {
                override val customValue = variable.customDate
                override val value = variable.value
            }
            val dateIsoStr = DatePlus.calcDefnBuildDate(defnBuildDate, timeZone)
            if (dateIsoStr != null) {
                return DatePlus.formatDate(dateIsoStr, callerEnt.displayDateFormat, false)
            }
        } else {
            return variable.customDate
        }

        return null
    }

    /**
     * Resolves a dateTime-kind variable using DefnBuildDateTime-style logic.
     */
    private fun resolveVariableDateTime(
        json: JsonObject,
        callerEnt: SigEntCaller
    ): String? {
        val variable = try {
            lenientJson.decodeFromJsonElement(CustomValueDateTime.serializer(), json)
        } catch (_: Exception) {
            return null
        }

        val timeZone = callerEnt.timeZone?.value
        if (timeZone != null) {
            val defnBuildDateTime = object : com.neome.api.meta.base.dto.DefnBuildDateTime {
                override val customValue = variable.customDate
                override val value = variable.value
                override val time = variable.customTime?.let { timeStr ->
                    com.neome.api.meta.base.AnyValue.create(
                        timeStr, com.neome.api.meta.base.Types.AnyTime::class.java
                    )
                }
            }
            val dateIsoStr = DatePlus.calcDefnBuildDateTime(defnBuildDateTime, timeZone)
            if (dateIsoStr != null) {
                return DatePlus.formatDate(dateIsoStr, callerEnt.displayDateFormat, true)
            }
        } else {
            return variable.customDate
        }

        return null
    }

    /**
     * Resolves a time-kind variable. Returns customValue or resolves the enum time value.
     */
    private fun resolveVariableTime(json: JsonObject): String? {
        val variable = try {
            lenientJson.decodeFromJsonElement(CustomValueTime.serializer(), json)
        } catch (_: Exception) {
            return null
        }

        if (variable.customValue != null) {
            return variable.customValue
        }

        return DatePlus.resolveTimeValue(variable.value)
    }

    // endregion

    // region --- DefnComp Resolution ---

    /**
     * Resolves all *Var properties on a single [DefnCompSeal] component.
     * Returns a new copy of the component with resolved values, or the original if unchanged.
     *
     * This handles:
     * 1. Type-specific properties dispatched via sealed class matching
     * 2. Common editable properties (helperTextVar, placeHolderVar, prefixVar, suffixVar)
     *    are resolved within each type-specific branch since data classes are flat
     *
     * Port of: ArgValueResolverPlus.ts > resolveDefnComp
     */
    internal fun resolveDefnComp(
        defnComp: DefnCompSeal,
        defnForm: DefnForm,
        callerEnt: SigEntCaller
    ): DefnCompSeal {
        return when (defnComp) {
            is DefnFieldButtonData -> defnComp.copy(
                helperTextVar = resolve(defnComp.helperTextVar, defnForm, callerEnt),
                placeHolderVar = resolve(defnComp.placeHolderVar, defnForm, callerEnt),
                prefixVar = resolve(defnComp.prefixVar, defnForm, callerEnt),
                suffixVar = resolve(defnComp.suffixVar, defnForm, callerEnt),
                toastMessageOnClickVar = resolve(
                    defnComp.toastMessageOnClickVar, defnForm, callerEnt
                ),
                whatsAppMessage = resolveParagraph(
                    defnComp.whatsAppMessage, defnForm, callerEnt
                )
            )

            is DefnFieldSwitchData -> defnComp.copy(
                helperTextVar = resolve(defnComp.helperTextVar, defnForm, callerEnt),
                placeHolderVar = resolve(defnComp.placeHolderVar, defnForm, callerEnt),
                prefixVar = resolve(defnComp.prefixVar, defnForm, callerEnt),
                suffixVar = resolve(defnComp.suffixVar, defnForm, callerEnt),
                checkboxLabelVar = resolve(defnComp.checkboxLabelVar, defnForm, callerEnt)
            )

            is DefnFieldIdentifierData -> defnComp.copy(
                helperTextVar = resolve(defnComp.helperTextVar, defnForm, callerEnt),
                placeHolderVar = resolve(defnComp.placeHolderVar, defnForm, callerEnt),
                prefixVar = resolve(defnComp.prefixVar, defnForm, callerEnt),
                suffixVar = resolve(defnComp.suffixVar, defnForm, callerEnt),
                textPatternVar = resolve(defnComp.textPatternVar, defnForm, callerEnt)
            )

            is DefnFieldHyperlinkRowData -> defnComp.copy(
                helperTextVar = resolve(defnComp.helperTextVar, defnForm, callerEnt),
                placeHolderVar = resolve(defnComp.placeHolderVar, defnForm, callerEnt),
                prefixVar = resolve(defnComp.prefixVar, defnForm, callerEnt),
                suffixVar = resolve(defnComp.suffixVar, defnForm, callerEnt),
                displayTextVar = resolve(defnComp.displayTextVar, defnForm, callerEnt)
            )

            is DefnFieldInfoData -> defnComp.copy(
                textPatternVar = resolve(defnComp.textPatternVar, defnForm, callerEnt),
                labelPatternVar = resolve(defnComp.labelPatternVar, defnForm, callerEnt),
                defaultVar = resolveParagraph(defnComp.defaultVar, defnForm, callerEnt)
            )

            is DefnFieldLabelData -> defnComp.copy(
                textPatternVar = resolve(defnComp.textPatternVar, defnForm, callerEnt)
            )

            is DefnFieldParagraphData -> defnComp.copy(
                helperTextVar = resolve(defnComp.helperTextVar, defnForm, callerEnt),
                placeHolderVar = resolve(defnComp.placeHolderVar, defnForm, callerEnt),
                prefixVar = resolve(defnComp.prefixVar, defnForm, callerEnt),
                suffixVar = resolve(defnComp.suffixVar, defnForm, callerEnt),
                defaultVar = resolveParagraph(defnComp.defaultVar, defnForm, callerEnt)
            )

            is DefnFieldShowCodeData -> defnComp.copy(
                helperTextVar = resolve(defnComp.helperTextVar, defnForm, callerEnt),
                placeHolderVar = resolve(defnComp.placeHolderVar, defnForm, callerEnt),
                prefixVar = resolve(defnComp.prefixVar, defnForm, callerEnt),
                suffixVar = resolve(defnComp.suffixVar, defnForm, callerEnt),
                defaultVar = resolveParagraph(defnComp.defaultVar, defnForm, callerEnt)
            )

            is DefnFieldHtmlData -> defnComp.copy(
                defaultVar = resolveParagraph(defnComp.defaultVar, defnForm, callerEnt),
                placeHolderVar = resolveParagraph(defnComp.placeHolderVar, defnForm, callerEnt)
            )

            is DefnGridData -> {
                resolveGridLayoutMap(defnComp, defnForm, callerEnt)
                defnComp // Grid itself has no *Var properties to copy-resolve
            }

            else -> defnComp
        }
    }

    // endregion

    // region --- Form Resolution ---

    /**
     * Resolves all arg-value variables across an entire [DefnFormUi].
     *
     * Walks the component tree, resolves all *Var properties on each component,
     * resolves form-level chatLabelPatternVar and chatPatternVar,
     * and returns a new [DefnFormUi] copy with all resolved values.
     *
     * Port of: ArgValueResolverPlus.ts > resolveDefnForm
     *
     * @param defnForm the form definition (with UI permission maps from FilterForm.prepare)
     * @param callerEnt the caller entity for context resolution
     * @return a new [DefnFormUi] with resolved *Var properties
     */
    fun resolveDefnForm(defnForm: DefnFormUi, callerEnt: SigEntCaller): DefnFormUi {
        // 1. Resolve form-level text variables
        val resolvedChatLabel = resolve(defnForm.chatLabelPatternVar, defnForm, callerEnt)
        val resolvedChatPattern = resolveParagraph(defnForm.chatPatternVar, defnForm, callerEnt)

        // 2. Resolve layout map variables (stubbed — see resolveFormLayoutMap)
        resolveFormLayoutMap(defnForm, callerEnt)

        // 3. Walk component tree and resolve each component's *Var properties
        val mutableCompMap = defnForm.compMap.toMutableMap()

        FormPlus.loopDefnForm(defnForm) { comp, _ ->
            val resolvedComp = resolveDefnComp(comp, defnForm, callerEnt)
            if (resolvedComp !== comp) {
                val compId = getCompMetaId(comp)
                if (compId != null) {
                    mutableCompMap[compId] = resolvedComp
                }
            }
            null // continue iteration
        }

        // 4. Return new form copy with resolved values
        return defnForm.copy(
            chatLabelPatternVar = resolvedChatLabel ?: defnForm.chatLabelPatternVar,
            chatPatternVar = resolvedChatPattern ?: defnForm.chatPatternVar,
            compMap = mutableCompMap
        )
    }

    // endregion

    // region --- Layout Resolution Stubs ---
    // These methods are stubbed because the Android serialization layer stores
    // DefnLayoutFormData/DefnLayoutGridData (base classes) in the layout maps,
    // not the subtypes (DefnLayoutFormTemplateData, DefnLayoutCardData, DefnLayoutGridLocmapData).
    // Full implementation requires polymorphic layout serialization.

    /**
     * STUB: Resolves variables in form layout map (watermarks in templates).
     *
     * Port of: ArgValueResolverPlus.ts > resolveFormLayoutMap
     * TODO: Implement when layout map uses polymorphic serialization
     * (DefnLayoutFormMapData.map needs to store DefnLayoutFormTemplateData, not DefnLayoutFormData)
     */
    private fun resolveFormLayoutMap(defnForm: DefnForm, callerEnt: SigEntCaller) {
        // TODO: Layout map resolution requires polymorphic layout serialization.
        // The current DefnLayoutFormMapData.map stores DefnLayoutFormData (base class)
        // which does not have the watermark property from DefnLayoutFormTemplate.
        //
        // When implemented, this should:
        // 1. Iterate defnForm.layoutMap?.keys
        // 2. For each layout with type == EnumDefnFormLayoutType.template, cast to template
        // 3. Resolve watermark.textPatternVar via resolve()
    }

    /**
     * STUB: Resolves variables in grid layout map (card items, locmap pins).
     *
     * Port of: ArgValueResolverPlus.ts > resolveGridLayoutMap
     * TODO: Implement when layout grid map uses polymorphic serialization
     * (DefnLayoutGridMapData.map needs to store DefnLayoutCardData/DefnLayoutGridLocmapData)
     */
    private fun resolveGridLayoutMap(
        grid: DefnGridData,
        defnForm: DefnForm,
        callerEnt: SigEntCaller
    ) {
        // TODO: Grid layout resolution requires polymorphic layout serialization.
        // The current DefnLayoutGridMapData.map stores DefnLayoutGridData (base class)
        // which does not have item (card), mapPin, liveLocationPin (locmap) properties.
        //
        // When implemented, this should:
        // 1. Iterate grid.layoutGridMap?.keys
        // 2. For "card"/"list" kinds: resolve card item line segments' lineVar
        // 3. For "map" kind: resolve locmap pin labelVar and toolTipVar
        // 4. Resolve media html for card items
    }

    // endregion

    // region --- Private Helpers ---

    /**
     * Finds a component in the compMap by its field ID string.
     * MetaIdComp keys use AnyValue.toString() which returns value property.
     */
    private fun findCompByFieldId(
        compMap: Map<MetaIdComp, DefnComp>,
        fieldId: String
    ): DefnComp? {
        return compMap.entries.find { it.key.value == fieldId }?.value
    }

    /**
     * Extracts the displayDateFormat from a date/dateTime field,
     * falling back to the callerEnt's displayDateFormat.
     */
    private fun getDisplayDateFormat(field: DefnComp, callerEnt: SigEntCaller): String? {
        val fieldFormat = when (field) {
            is DefnFieldDate -> field.displayDateFormat
            is DefnFieldDateTime -> field.displayDateFormat
            else -> null
        }
        return fieldFormat ?: callerEnt.displayDateFormat
    }

    /**
     * Finds a role name from the callerEnt's roleMap by role ID string.
     * DtoEntRole.name is Symbol (extends AnyValue), use .value for the string.
     */
    private fun findRoleName(callerEnt: SigEntCaller, roleIdStr: String): String? {
        val entry = callerEnt.roleMap.entries.find { it.key.value == roleIdStr }
        return entry?.value?.name?.value
    }

    /**
     * Extracts the MetaIdComp from a DefnCompSeal.
     * Same helper pattern used by FilterForm.
     */
    private fun getCompMetaId(comp: DefnCompSeal): MetaIdComp? {
        return (comp as? DefnField)?.metaId
            ?: (comp as? DefnSection)?.metaId
            ?: (comp as? DefnGrid)?.metaId
            ?: (comp as? DefnTab)?.metaId
            ?: (comp as? DefnWizard)?.metaId
    }

    // endregion
}
```

**Step 2: Verify it compiles**

Run: `./gradlew compileDebugKotlin 2>&1 | tail -5`
Expected: BUILD SUCCESSFUL

**Step 3: Commit**

```bash
git add app/src/main/java/com/neome/feature/form/domain/util/ArgValueResolver.kt
git commit -m "feat(form): add ArgValueResolver with full arg-value resolution pipeline"
```

---

## Task 4: Update `FieldPropertyResolver.resolveArgValue` to Delegate

**Files:**
- Modify: `app/src/main/java/com/neome/feature/form/domain/util/FieldPropertyResolver.kt` (lines 837-854)

**Step 1: Replace the stub `resolveArgValue` method**

Find the existing method (around line 844):

```kotlin
    fun resolveArgValue(dtoText: DefnDtoText?): String? {
        if (dtoText == null) return null

        // Basic placeholder implementation
        // In a real implementation, this would resolve variables from context,
        // perform calculations, etc. based on the DefnDtoText structure

        // For now, return a simple representation
        // This prevents the function from always returning null
        return dtoText.toString()
    }
```

Replace it with:

```kotlin
    /**
     * Resolves a [DefnDtoText] variable to a plain string.
     *
     * When [defnForm] and [callerEnt] are available, delegates to [ArgValueResolver]
     * for full arg-value resolution. Otherwise, falls back to joining the raw value list.
     *
     * @param dtoText The DefnDtoText to resolve
     * @param defnForm The form definition (optional, needed for field lookups)
     * @param callerEnt The caller entity (optional, needed for context resolution)
     * @return Resolved string value or null
     */
    fun resolveArgValue(
        dtoText: DefnDtoText?,
        defnForm: DefnFormData? = null,
        callerEnt: SigEntCaller? = null
    ): String? {
        if (dtoText == null) return null

        if (defnForm != null && callerEnt != null) {
            val resolved = ArgValueResolver.resolve(dtoText, defnForm, callerEnt)
            return resolved?.value?.joinToString("")
        }

        // Fallback: join raw values without resolution
        return dtoText.value?.joinToString("")
    }
```

**Step 2: Add import at the top of the file (if not already present)**

```kotlin
import com.neome.api.ent.entDrawer.sig.SigEntCaller
```

**Step 3: Verify it compiles**

Run: `./gradlew compileDebugKotlin 2>&1 | tail -5`
Expected: BUILD SUCCESSFUL

Existing call sites use `resolveArgValue(defnComp.helperTextVar)` with a single argument.
Since `defnForm` and `callerEnt` have default values of `null`, this still compiles and uses the fallback path.

**Step 4: Commit**

```bash
git add app/src/main/java/com/neome/feature/form/domain/util/FieldPropertyResolver.kt
git commit -m "feat(form): update FieldPropertyResolver.resolveArgValue to delegate to ArgValueResolver"
```

---

## Task 5: Final Build Verification

**Step 1: Run full debug compilation**

Run: `./gradlew compileDebugKotlin 2>&1 | tail -20`
Expected: BUILD SUCCESSFUL

**Step 2: If there are compilation errors, fix them**

Common issues to watch for:
- Import conflicts between interface types and Data class types
- `MetaIdComp` type mismatches (`MetaIdField`, `MetaIdSection`, etc. are subtypes of `MetaIdComp`)
- `DefnCompSeal` sealed interface `when` exhaustiveness — always include `else ->` branches
- `EnumDefnArgBinder.Context` has capital C (it's annotated with `@SerialName("context")`)
- `FormPlus.loopDefnForm` accepts `DefnFormData` — `DefnFormUi` also implements `DefnForm` but is a separate class. Check if `loopDefnForm` accepts `DefnFormUi` or only `DefnFormData`.
  - If `loopDefnForm` only accepts `DefnFormData`, you may need to add an overload or use a different traversal approach for `DefnFormUi` (e.g., iterate `compMap` directly instead of tree walking).

**Step 3: Commit if any fixes were needed**

```bash
git add -A
git commit -m "fix(form): resolve ArgValueResolver compilation issues"
```

---

## File Summary

| File | Action | Lines (approx) |
|---|---|---|
| `app/src/main/java/com/neome/feature/form/domain/util/StringPlus.kt` | Create | ~20 |
| `app/src/main/java/com/neome/feature/form/domain/util/DatePlus.kt` | Create | ~200 |
| `app/src/main/java/com/neome/feature/form/domain/util/ArgValueResolver.kt` | Create | ~450 |
| `app/src/main/java/com/neome/feature/form/domain/util/FieldPropertyResolver.kt` | Modify (lines 837-854) | ~20 changed |

## TS-to-Kotlin Method Mapping

| TypeScript Method | Kotlin Method | Location |
|---|---|---|
| `ArgValueResolver.resolve()` | `ArgValueResolver.resolve()` + `resolveParagraph()` | ArgValueResolver.kt |
| `ArgValueResolver.resolveDefnForm()` | `ArgValueResolver.resolveDefnForm()` | ArgValueResolver.kt |
| `ArgValueResolver.resolveDefnComp()` | `ArgValueResolver.resolveDefnComp()` | ArgValueResolver.kt |
| `ArgValueResolver.resolveArgVal()` | `ArgValueResolver.resolveArgVal()` | ArgValueResolver.kt |
| `ArgValueResolver.resolveArgValCtx()` | `ArgValueResolver.resolveArgValCtx()` | ArgValueResolver.kt |
| `ArgValueResolver.resolveArgValDerived()` | `ArgValueResolver.resolveArgValDerived()` | ArgValueResolver.kt |
| `ArgValueResolver.resolveArgValVariable()` | `ArgValueResolver.resolveArgValVariable()` | ArgValueResolver.kt |
| `ArgValueResolver.resolveFormLayoutMap()` | `ArgValueResolver.resolveFormLayoutMap()` (STUB) | ArgValueResolver.kt |
| `ArgValueResolver.resolveGridLayoutMap()` | `ArgValueResolver.resolveGridLayoutMap()` (STUB) | ArgValueResolver.kt |
| `ArgValueResolver.resolveCardItem()` | STUB (inside resolveGridLayoutMap TODO) | ArgValueResolver.kt |
| `ArgValueResolver.resolveCardItemLine()` | STUB (inside resolveGridLayoutMap TODO) | ArgValueResolver.kt |
| `ArgValueResolver.resolveCardItemLineSegment()` | STUB (inside resolveGridLayoutMap TODO) | ArgValueResolver.kt |
| `ArgValueResolver.resolveLocmapPin()` | STUB (inside resolveGridLayoutMap TODO) | ArgValueResolver.kt |
| `ArgValueResolver.resolveMedia()` | STUB (inside resolveGridLayoutMap TODO) | ArgValueResolver.kt |
| `ArgValueResolver.resolveWatermark()` | STUB (inside resolveFormLayoutMap TODO) | ArgValueResolver.kt |
| `isJsonString()` | `StringPlus.isJsonString()` | StringPlus.kt |
| `resolveTimeValue()` | `DatePlus.resolveTimeValue()` | DatePlus.kt |
| `formatDate()` | `DatePlus.formatDate()` | DatePlus.kt |
| `dateToLocalString()` | `DatePlus.dateToLocalString()` | DatePlus.kt |
| `calcDefnBuildDate()` | `DatePlus.calcDefnBuildDate()` | DatePlus.kt |
| `calcDefnBuildDateTime()` | `DatePlus.calcDefnBuildDateTime()` | DatePlus.kt |
| `resolveEnumDefnDate()` | `DatePlus.resolveEnumDefnDate()` | DatePlus.kt |
