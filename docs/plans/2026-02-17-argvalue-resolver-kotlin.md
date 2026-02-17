# ArgValueResolver Kotlin Implementation Plan

> **For Claude:** REQUIRED SUB-SKILL: Use superpowers:executing-plans to implement this plan task-by-task.

**Goal:** Port TypeScript `ArgValueResolverPlus.ts` to Kotlin, enabling runtime resolution of dynamic field properties (helper text, placeholders, default values) that reference caller context, derived fields, or variables.

**Architecture:** Create serializable data classes for custom value types, implement core resolution methods that parse JSON-encoded arg values and resolve them against caller context/form data, and integrate with the existing immutable DefnFormUi data class architecture using copy() patterns.

**Tech Stack:** Kotlin, kotlinx.serialization, existing Android project structure (Clean Architecture + MVI)

**Source Reference:** `/Users/aditya/Documents/neome/webapp/src/base/plus/ArgValueResolverPlus.ts`

---

## Task 1: Create TypeArgValueResolver.kt — Data Classes for Arg Value Types

**Files:**
- Create: `app/src/main/java/com/neome/feature/form/domain/util/TypeArgValueResolver.kt`

**Context:** These data classes represent the client-side argument value structures that are JSON-encoded in DefnDtoText.value strings. They're Kotlin equivalents of TS interfaces defined in ArgValueResolverPlus.ts lines 49-84.

**Step 1: Create the file with package and imports**

```kotlin
package com.neome.feature.form.domain.util

import com.neome.api.meta.base.Types.EnumDefnArgBinder
import com.neome.api.meta.base.Types.EnumDefnDate
import com.neome.api.meta.base.Types.EnumDefnTime
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

```

**Step 2: Add TypeCustomValueDate data class**

```kotlin
@Serializable
data class TypeCustomValueDate(
    val id: String,
    val kind: String,
    val name: String,
    val value: EnumDefnDate? = null,
    val customDate: String? = null  // ISO date string
)
```

**Step 3: Add TypeCustomValueTime data class**

```kotlin
@Serializable
data class TypeCustomValueTime(
    val id: String,
    val kind: String,
    val name: String,
    val customValue: String? = null,  // "23:59:00" format
    val value: EnumDefnTime? = null
)
```

**Step 4: Add TypeCustomValueDateTime data class**

```kotlin
@Serializable
data class TypeCustomValueDateTime(
    val id: String,
    val kind: String,
    val name: String,
    val value: EnumDefnDate? = null,
    val customDate: String? = null,  // ISO date string
    val customTime: String? = null   // "23:59:00" format
)
```

**Step 5: Add TypeCustomValueSeq data class**

```kotlin
@Serializable
data class TypeCustomValueSeq(
    val id: String,
    val kind: String,
    val name: String
)
```

**Step 6: Add StudioDtoArgValueForClient wrapper class**

```kotlin
/**
 * Client-side wrapper for arg values parsed from DefnDtoText.value strings.
 * The argValue and customValueMap are JsonElement because they're polymorphic -
 * decoded manually based on 'kind' field using existing *Data.serializer() classes.
 */
@Serializable
data class StudioDtoArgValueForClient(
    val kind: EnumDefnArgBinder,
    val argValue: JsonElement,              // Polymorphic - decode per kind
    val customValueMap: JsonElement? = null // Polymorphic - decode per customValueMap.kind
)
```

**Step 7: Verify compilation**

Run: `./gradlew :app:compileDebugKotlin`

Expected: BUILD SUCCESSFUL

**Step 8: Commit**

```bash
git add app/src/main/java/com/neome/feature/form/domain/util/TypeArgValueResolver.kt
git commit -m "feat: add TypeArgValueResolver data classes for arg value serialization"
```

---

## Task 2: Implement Core Resolution Methods

**Files:**
- Modify: `app/src/main/java/com/neome/feature/form/domain/util/ArgValueResolver.kt`

**Context:** These are the core methods that parse JSON-encoded arg values from DefnDtoText strings and resolve them against caller context, form data, and variables. Direct port of TS methods from lines 385-651.

**Step 1: Add imports and constants**

Replace the existing file content with:

```kotlin
package com.neome.feature.form.domain.util

import android.util.Log
import com.neome.api.ent.entDrawer.sig.SigEntCaller
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnArgBinder
import com.neome.api.meta.base.Types.EnumDefnArgBinderContext
import com.neome.api.meta.base.Types.EnumDefnCompType
import com.neome.api.meta.base.dto.DefnBuildDate
import com.neome.api.meta.base.dto.DefnDtoParagraph
import com.neome.api.meta.base.dto.DefnDtoText
import com.neome.api.meta.base.dto.DefnFieldDate
import com.neome.api.meta.base.dto.DefnFieldDateTime
import com.neome.api.meta.base.dto.DefnFieldPickText
import com.neome.api.meta.base.dto.DefnForm
import com.neome.core.common.serializer.api.meta.base.dto.DefnBuildDateData
import com.neome.core.common.serializer.api.meta.base.dto.DefnDtoParagraphData
import com.neome.core.common.serializer.api.meta.base.dto.DefnDtoTextData
import com.neome.core.common.serializer.api.meta.base.dto.StudioDtoArgValueContextCallerData
import com.neome.core.common.serializer.api.meta.base.dto.StudioDtoArgValueContextCallerSettingData
import com.neome.core.common.serializer.api.meta.base.dto.StudioDtoArgValueContextData
import com.neome.core.common.serializer.api.meta.base.dto.StudioDtoArgValueContextEntData
import com.neome.core.common.serializer.api.meta.base.dto.StudioDtoArgValueDerivedData
import com.neome.feature.utils.JsonParser
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.decodeFromJsonElement

object ArgValueResolver {

    private const val TAG = "ArgValueResolver"

```

**Step 2: Implement resolve() method for DefnDtoText**

```kotlin
    /**
     * Resolves all arg value references in a DefnDtoText.
     * Iterates the value list, resolves each JSON-encoded arg string, returns new DefnDtoTextData.
     */
    fun resolve(
        defnDtoText: DefnDtoText?,
        defnForm: DefnForm,
        callerEnt: SigEntCaller,
        skipResolveSeqVar: Boolean = false
    ): DefnDtoTextData? {
        if (defnDtoText?.value.isNullOrEmpty()) return null

        val newValue = mutableListOf<String>()
        defnDtoText.value?.forEach { argStr ->
            val resolvedVal = resolveArgVal(argStr, defnForm, callerEnt, skipResolveSeqVar)
            if (resolvedVal != null) {
                newValue.add(resolvedVal)
            }
        }

        return if (newValue.isEmpty()) null else DefnDtoTextData(value = newValue)
    }
```

**Step 3: Implement resolveParagraph() method**

```kotlin
    /**
     * Resolves all arg value references in a DefnDtoParagraph.
     * Same as resolve() but returns DefnDtoParagraphData.
     */
    fun resolveParagraph(
        paragraph: DefnDtoParagraph?,
        defnForm: DefnForm,
        callerEnt: SigEntCaller
    ): DefnDtoParagraphData? {
        if (paragraph?.value.isNullOrEmpty()) return null

        val newValue = mutableListOf<String>()
        paragraph.value?.forEach { argStr ->
            val resolvedVal = resolveArgVal(argStr, defnForm, callerEnt, false)
            if (resolvedVal != null) {
                newValue.add(resolvedVal)
            }
        }

        return if (newValue.isEmpty()) null else DefnDtoParagraphData(value = newValue)
    }
```

**Step 4: Implement resolveArgVal() method**

```kotlin
    /**
     * Parses and resolves a single arg value string.
     * If it's JSON, parse as StudioDtoArgValueForClient and dispatch by kind.
     * Otherwise return as-is.
     */
    private fun resolveArgVal(
        argStr: String,
        defnForm: DefnForm,
        callerEnt: SigEntCaller,
        skipResolveSeqVar: Boolean
    ): String? {
        if (argStr.isBlank() || !JsonParser.isJsonString(argStr)) {
            return argStr
        }

        return try {
            val parsed = JsonParser.json.decodeFromString<StudioDtoArgValueForClient>(argStr)
            when (parsed.kind) {
                EnumDefnArgBinder.Context -> {
                    resolveArgValCtx(parsed.argValue, argStr, callerEnt)
                }
                EnumDefnArgBinder.derived -> {
                    resolveArgValDerived(parsed.argValue, argStr, defnForm, callerEnt)
                }
                EnumDefnArgBinder.variable -> {
                    resolveArgValVariable(parsed.argValue, argStr, callerEnt, parsed.customValueMap, skipResolveSeqVar)
                }
                EnumDefnArgBinder.field -> {
                    argStr  // Passthrough - resolved later
                }
                else -> argStr
            }
        } catch (e: Exception) {
            Log.e(TAG, "Failed to parse arg value: $argStr", e)
            argStr
        }
    }
```

**Step 5: Implement resolveArgValCtx() method**

```kotlin
    /**
     * Resolves context-based arg values (caller, callerSetting, ent, row).
     */
    private fun resolveArgValCtx(
        argValJson: JsonElement,
        argStr: String,
        callerEnt: SigEntCaller
    ): String? {
        val contextData = JsonParser.json.decodeFromJsonElement<StudioDtoArgValueContextData>(argValJson)

        return when (contextData.kind) {
            EnumDefnArgBinderContext.caller -> {
                val caller = JsonParser.json.decodeFromJsonElement<StudioDtoArgValueContextCallerData>(argValJson)
                when (caller.attribute) {
                    Types.EnumDefnArgBinderContextCaller.userId -> callerEnt.userId
                    Types.EnumDefnArgBinderContextCaller.entUserId -> callerEnt.entUserId
                    Types.EnumDefnArgBinderContextCaller.nickName -> callerEnt.nickName
                    Types.EnumDefnArgBinderContextCaller.handle -> callerEnt.handle
                    Types.EnumDefnArgBinderContextCaller.color -> callerEnt.color
                    Types.EnumDefnArgBinderContextCaller.email,
                    Types.EnumDefnArgBinderContextCaller.mobileNumber -> callerEnt.handle
                    Types.EnumDefnArgBinderContextCaller.managerId -> callerEnt.managerId
                    Types.EnumDefnArgBinderContextCaller.roles -> {
                        callerEnt.roleMap.values.joinToString(", ") { role ->
                            role.label ?: role.name
                        }
                    }
                    else -> argStr
                }
            }
            EnumDefnArgBinderContext.callerSetting -> {
                val setting = JsonParser.json.decodeFromJsonElement<StudioDtoArgValueContextCallerSettingData>(argValJson)
                val variable = callerEnt.userSettingVarMap?.get(setting.userSettingVarId)
                variable?.value?.toString() ?: argStr
            }
            EnumDefnArgBinderContext.ent -> {
                val ent = JsonParser.json.decodeFromJsonElement<StudioDtoArgValueContextEntData>(argValJson)
                when (ent.attribute) {
                    Types.EnumDefnArgBinderContextEnt.id -> callerEnt.entId
                    Types.EnumDefnArgBinderContextEnt.timeZone -> callerEnt.timeZone
                    Types.EnumDefnArgBinderContextEnt.displayDateFormat -> callerEnt.displayDateFormat
                    else -> argStr
                }
            }
            EnumDefnArgBinderContext.row -> argStr  // Resolve after value
            else -> argStr
        }
    }
```

**Step 6: Implement resolveArgValDerived() method**

```kotlin
    /**
     * Resolves derived field values (values from other fields in the form).
     */
    private fun resolveArgValDerived(
        argValueJson: JsonElement,
        argStr: String,
        defnForm: DefnForm,
        callerEnt: SigEntCaller
    ): String? {
        val argValue = JsonParser.json.decodeFromJsonElement<StudioDtoArgValueDerivedData>(argValueJson)
        val field = defnForm.compMap[argValue.derivedFieldId] ?: return argStr

        return when (argValue.derivedFieldType) {
            EnumDefnCompType.bool -> {
                when (argValue.valueBoolean) {
                    true -> "Yes"
                    false -> "No"
                    null -> null
                }
            }
            EnumDefnCompType.date, EnumDefnCompType.dateTime -> {
                val valueDate = argValue.valueDate
                if (valueDate is String) {
                    val comp = field as? DefnFieldDate ?: field as? DefnFieldDateTime
                    val isDateTime = comp is DefnFieldDateTime
                    val displayDateFormat = when (comp) {
                        is DefnFieldDate -> comp.displayDateFormat
                        is DefnFieldDateTime -> comp.displayDateFormat
                        else -> null
                    } ?: callerEnt.displayDateFormat

                    if (displayDateFormat != null) {
                        DatePlus.formatDate(valueDate, displayDateFormat, isDateTime)
                    } else {
                        DatePlus.dateToLocalString(valueDate)
                    }
                } else {
                    valueDate
                }
            }
            EnumDefnCompType.rating, EnumDefnCompType.decimal -> {
                argValue.valueDouble?.toString()
            }
            EnumDefnCompType.number, EnumDefnCompType.counter -> {
                argValue.valueLong?.toString()
            }
            EnumDefnCompType.symbol, EnumDefnCompType.text, EnumDefnCompType.paragraph,
            EnumDefnCompType.hyperlink, EnumDefnCompType.mobileNumber, EnumDefnCompType.email,
            EnumDefnCompType.handle, EnumDefnCompType.spreadsheetId -> {
                argValue.valueText
            }
            EnumDefnCompType.pickText -> {
                val optionId = argValue.valueOptionId
                val pickText = field as? DefnFieldPickText
                if (optionId != null && pickText?.optionMap?.map != null) {
                    pickText.optionMap.map[optionId]?.value ?: optionId
                } else {
                    optionId
                }
            }
            EnumDefnCompType.language, EnumDefnCompType.timeZone, EnumDefnCompType.currency -> {
                argValue.valueOptionId
            }
            EnumDefnCompType.pickTree, EnumDefnCompType.paymentStatus -> {
                ""  // TODO
            }
            EnumDefnCompType.pickRole -> {
                val optionId = argValue.valueOptionId
                if (optionId != null) {
                    callerEnt.roleMap[optionId]?.name ?: optionId
                } else {
                    optionId
                }
            }
            else -> null
        }
    }
```

**Step 7: Implement resolveArgValVariable() method**

```kotlin
    /**
     * Resolves variable arg values using customValueMap.
     */
    private fun resolveArgValVariable(
        argValueJson: JsonElement,
        argStr: String,
        callerEnt: SigEntCaller,
        customValueMapJson: JsonElement?,
        skipResolveSeqVar: Boolean
    ): String? {
        if (customValueMapJson == null) return null

        // Decode as base to get kind
        val baseMap = JsonParser.json.decodeFromJsonElement<TypeCustomValueDate>(customValueMapJson)
        
        return when (baseMap.kind) {
            "date" -> {
                val variable = JsonParser.json.decodeFromJsonElement<TypeCustomValueDate>(customValueMapJson)
                val defnBuildDate = DefnBuildDateData(
                    customValue = variable.customDate,
                    value = variable.value
                )
                val timeZone = callerEnt.timeZone
                if (timeZone != null) {
                    val dateIsoStr = DatePlus.calcDefnBuildDate(defnBuildDate, timeZone)
                    if (dateIsoStr != null) {
                        DatePlus.formatDate(dateIsoStr, callerEnt.displayDateFormat, false)
                    } else {
                        defnBuildDate.customValue
                    }
                } else {
                    defnBuildDate.customValue
                }
            }
            "dateTime" -> {
                val variable = JsonParser.json.decodeFromJsonElement<TypeCustomValueDateTime>(customValueMapJson)
                val defnBuildDate = DefnBuildDateData(
                    customValue = variable.customDate,
                    value = variable.value
                )
                val timeZone = callerEnt.timeZone
                if (timeZone != null) {
                    val dateIsoStr = DatePlus.calcDefnBuildDateTime(defnBuildDate, timeZone)
                    if (dateIsoStr != null) {
                        DatePlus.formatDate(dateIsoStr, callerEnt.displayDateFormat, true)
                    } else {
                        defnBuildDate.customValue
                    }
                } else {
                    defnBuildDate.customValue
                }
            }
            "time" -> {
                val variable = JsonParser.json.decodeFromJsonElement<TypeCustomValueTime>(customValueMapJson)
                variable.customValue ?: DatePlus.resolveTimeValue(variable.value?.value)
            }
            "sequence" -> {
                val variable = JsonParser.json.decodeFromJsonElement<TypeCustomValueSeq>(customValueMapJson)
                if (skipResolveSeqVar) argStr else variable.name
            }
            "setOfDate" -> baseMap.name  // TODO
            else -> baseMap.name
        }
    }

}
```

**Step 8: Verify compilation**

Run: `./gradlew :app:compileDebugKotlin`

Expected: BUILD SUCCESSFUL (may show warnings about TODO DatePlus methods)

**Step 9: Commit**

```bash
git add app/src/main/java/com/neome/feature/form/domain/util/ArgValueResolver.kt
git commit -m "feat: implement core arg value resolution methods"
```

---

## Task 3: Implement resolveDefnComp — Component Property Resolution

**Files:**
- Modify: `app/src/main/java/com/neome/feature/form/domain/util/ArgValueResolver.kt`

**Context:** This method resolves all DefnDtoText/DefnDtoParagraph properties on a component by pattern matching on concrete Data types and using copy() to create new instances. Port of TS lines 101-237.

**Step 1: Add additional imports for component types**

Add these imports after the existing import block:

```kotlin
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
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
```

**Step 2: Add resolveDefnComp() method before the closing brace**

```kotlin
    /**
     * Resolves all DefnDtoText/DefnDtoParagraph properties on a component.
     * Pattern matches on concrete Data types and uses copy() to create new resolved instances.
     */
    private fun resolveDefnComp(
        comp: DefnCompSeal,
        defnForm: DefnForm,
        callerEnt: SigEntCaller
    ): DefnCompSeal {
        return when (comp) {
            is DefnFieldButtonData -> comp.copy(
                // Editable base props
                helperTextVar = resolve(comp.helperTextVar, defnForm, callerEnt),
                placeHolderVar = resolve(comp.placeHolderVar, defnForm, callerEnt),
                prefixVar = resolve(comp.prefixVar, defnForm, callerEnt),
                suffixVar = resolve(comp.suffixVar, defnForm, callerEnt),
                // Type-specific
                toastMessageOnClickVar = resolve(comp.toastMessageOnClickVar, defnForm, callerEnt),
                whatsAppMessage = resolveParagraph(comp.whatsAppMessage, defnForm, callerEnt)
            )

            is DefnFieldSwitchData -> comp.copy(
                // Editable base props
                helperTextVar = resolve(comp.helperTextVar, defnForm, callerEnt),
                placeHolderVar = resolve(comp.placeHolderVar, defnForm, callerEnt),
                prefixVar = resolve(comp.prefixVar, defnForm, callerEnt),
                suffixVar = resolve(comp.suffixVar, defnForm, callerEnt),
                // Type-specific
                checkboxLabelVar = resolve(comp.checkboxLabelVar, defnForm, callerEnt)
            )

            is DefnFieldIdentifierData -> comp.copy(
                // Editable base props
                helperTextVar = resolve(comp.helperTextVar, defnForm, callerEnt),
                placeHolderVar = resolve(comp.placeHolderVar, defnForm, callerEnt),
                prefixVar = resolve(comp.prefixVar, defnForm, callerEnt),
                suffixVar = resolve(comp.suffixVar, defnForm, callerEnt),
                // Type-specific
                textPatternVar = resolve(comp.textPatternVar, defnForm, callerEnt)
            )

            is DefnFieldHyperlinkRowData -> comp.copy(
                // Editable base props
                helperTextVar = resolve(comp.helperTextVar, defnForm, callerEnt),
                placeHolderVar = resolve(comp.placeHolderVar, defnForm, callerEnt),
                prefixVar = resolve(comp.prefixVar, defnForm, callerEnt),
                suffixVar = resolve(comp.suffixVar, defnForm, callerEnt),
                // Type-specific
                displayTextVar = resolve(comp.displayTextVar, defnForm, callerEnt)
            )

            is DefnFieldLabelData -> comp.copy(
                // Type-specific (NO editable base - extends DefnField not DefnFieldEditable)
                textPatternVar = resolve(comp.textPatternVar, defnForm, callerEnt)
            )

            is DefnFieldInfoData -> comp.copy(
                // Type-specific (NO editable base - extends DefnFieldLabel which extends DefnField)
                labelPatternVar = resolve(comp.labelPatternVar, defnForm, callerEnt),
                defaultVar = resolveParagraph(comp.defaultVar, defnForm, callerEnt),
                textPatternVar = resolve(comp.textPatternVar, defnForm, callerEnt)
            )

            is DefnFieldParagraphData -> comp.copy(
                // Editable base props
                helperTextVar = resolve(comp.helperTextVar, defnForm, callerEnt),
                placeHolderVar = resolve(comp.placeHolderVar, defnForm, callerEnt),
                prefixVar = resolve(comp.prefixVar, defnForm, callerEnt),
                suffixVar = resolve(comp.suffixVar, defnForm, callerEnt),
                // Type-specific (defaultVar is DefnDtoParagraph, not DefnDtoText)
                defaultVar = resolveParagraph(comp.defaultVar, defnForm, callerEnt)
            )

            is DefnFieldShowCodeData -> comp.copy(
                // Editable base props
                helperTextVar = resolve(comp.helperTextVar, defnForm, callerEnt),
                placeHolderVar = resolve(comp.placeHolderVar, defnForm, callerEnt),
                prefixVar = resolve(comp.prefixVar, defnForm, callerEnt),
                suffixVar = resolve(comp.suffixVar, defnForm, callerEnt),
                // Type-specific
                defaultVar = resolveParagraph(comp.defaultVar, defnForm, callerEnt)
            )

            is DefnFieldHtmlData -> comp.copy(
                // Type-specific (NO editable base - extends DefnField not DefnFieldEditable)
                defaultVar = resolveParagraph(comp.defaultVar, defnForm, callerEnt),
                placeHolderVar = resolveParagraph(comp.placeHolderVar, defnForm, callerEnt)
            )

            is DefnGridData -> {
                // Skip - resolveGridLayoutMap excluded per instructions
                comp
            }

            else -> comp  // All other types - no var properties to resolve
        }
    }
```

**Step 3: Verify compilation**

Run: `./gradlew :app:compileDebugKotlin`

Expected: BUILD SUCCESSFUL

**Step 4: Commit**

```bash
git add app/src/main/java/com/neome/feature/form/domain/util/ArgValueResolver.kt
git commit -m "feat: implement resolveDefnComp for component property resolution"
```

---

## Task 4: Implement resolveDefnForm — Top-Level Form Resolution

**Files:**
- Modify: `app/src/main/java/com/neome/feature/form/domain/util/ArgValueResolver.kt`

**Context:** This is the public entry point that resolves all arg values in a DefnFormUi and returns a new resolved form. Port of TS lines 654-676 (minus resolveFormLayoutMap).

**Step 1: Add DefnFormUi import**

Add this import:

```kotlin
import com.neome.feature.form.domain.DefnFormUi
```

**Step 2: Add resolveDefnForm() method before the closing brace**

```kotlin
    /**
     * Resolves all arg values in a DefnFormUi.
     * Returns a new DefnFormUi with resolved form properties and component map.
     */
    fun resolveDefnForm(defnForm: DefnFormUi, callerEnt: SigEntCaller): DefnFormUi {
        // Resolve form-level properties
        val resolvedChatLabelPatternVar = resolve(defnForm.chatLabelPatternVar, defnForm, callerEnt)
        val resolvedChatPatternVar = resolveParagraph(defnForm.chatPatternVar, defnForm, callerEnt)

        // Skip resolveFormLayoutMap - excluded per instructions

        // Build new compMap with all components resolved
        val newCompMap = defnForm.compMap.mapValues { (_, comp) ->
            resolveDefnComp(comp as DefnCompSeal, defnForm, callerEnt)
        }

        // Return new DefnFormUi with resolved properties
        return defnForm.copy(
            chatLabelPatternVar = resolvedChatLabelPatternVar,
            chatPatternVar = resolvedChatPatternVar,
            compMap = newCompMap
        )
    }
```

**Step 3: Verify compilation**

Run: `./gradlew :app:compileDebugKotlin`

Expected: BUILD SUCCESSFUL

**Step 4: Format the file**

Run: `./gradlew :app:formatKotlin` (if available) or use IDE formatter

**Step 5: Review final file structure**

The ArgValueResolver.kt should now have:
- Constants: `TAG`
- Public methods: `resolve()`, `resolveParagraph()`, `resolveDefnForm()`
- Private methods: `resolveArgVal()`, `resolveArgValCtx()`, `resolveArgValDerived()`, `resolveArgValVariable()`, `resolveDefnComp()`

**Step 6: Commit**

```bash
git add app/src/main/java/com/neome/feature/form/domain/util/ArgValueResolver.kt
git commit -m "feat: implement resolveDefnForm for top-level form resolution"
```

**Step 7: Final verification - check both files compile together**

Run: `./gradlew :app:compileDebugKotlin`

Expected: BUILD SUCCESSFUL

---

## Completion Checklist

- [x] Task 1: TypeArgValueResolver.kt created with 6 data classes
- [x] Task 2: Core resolution methods implemented (resolve, resolveArgVal, resolveArgValCtx, resolveArgValDerived, resolveArgValVariable, resolveParagraph)
- [x] Task 3: resolveDefnComp implemented with 10 component type branches
- [x] Task 4: resolveDefnForm implemented as public entry point
- [x] All tasks committed with descriptive messages
- [x] No compilation errors
- [x] Skipped resolveFormLayoutMap and grid layout resolution per instructions

## Notes

**Missing implementations (existing TODO stubs):**
- `DatePlus.formatDate()` - calls will throw TODO at runtime
- `DatePlus.calcDefnBuildDate()` - calls will throw TODO at runtime
- `DatePlus.calcDefnBuildDateTime()` - calls will throw TODO at runtime
- `DatePlus.resolveTimeValue()` - calls will throw TODO at runtime
- `DatePlus.dateToLocalString()` - calls will throw TODO at runtime

These are existing TODO stubs in the codebase and should be implemented separately.

**Architecture notes:**
- All component resolution uses immutable `copy()` pattern
- JSON parsing uses existing `JsonParser` singleton
- Manual decoding of polymorphic types via `JsonElement` + `decodeFromJsonElement`
- Error handling: try-catch in `resolveArgVal` logs and returns original string
- No grid layout map resolution per user instructions

**Testing recommendations (for future work):**
- Unit tests for each resolve method with mock SigEntCaller
- Test JSON parsing edge cases
- Test component copy() with null values
- Integration test with real DefnFormUi from database
