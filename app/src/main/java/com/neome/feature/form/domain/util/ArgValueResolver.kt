package com.neome.feature.form.domain.util

import android.util.Log
import com.neome.api.ent.entDrawer.sig.SigEntCaller
import com.neome.api.meta.base.Types.EnumDefnArgBinder
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
import com.neome.core.common.serializer.api.meta.base.dto.FormValueData
import com.neome.feature.form.domain.DefnFormUi
import com.neome.feature.utils.JsonParser
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

        if (argStr.isBlank() || !JsonParser.isJsonString(argStr)) {
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
                val compId = FormPlus.getCompMetaId(comp)
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

    // region --- Field Value Default Resolution ---

    /**
     * Resolves arg-value variables embedded in a [DefnDtoText] for field-value
     * default resolution.
     *
     * TODO: Implement full arg-value resolution with form value context.
     * For now, returns a simple joinToString of the text value list.
     *
     * @param defnForm the form definition for field lookups
     * @param formValue the current form value (for future context-aware resolution)
     * @param defnDtoText the text definition containing potential arg-value strings
     * @return resolved plain-text string, or null if input is null/empty
     */
    fun resolveArgForFieldVal(
        defnForm: DefnForm,
        formValue: FormValueData?,
        defnDtoText: DefnDtoText?
    ): String? {
        if (defnDtoText == null) return null
        return defnDtoText.value?.joinToString("")
    }

    /**
     * Resolves arg-value variables embedded in a [DefnDtoParagraph] for field-value
     * default resolution.
     *
     * TODO: Implement full arg-value resolution with form value context.
     * For now, returns a simple joinToString of the paragraph value list.
     *
     * @param defnForm the form definition for field lookups
     * @param formValue the current form value (for future context-aware resolution)
     * @param defnDtoParagraph the paragraph definition containing potential arg-value strings
     * @return resolved plain-text string, or null if input is null/empty
     */
    fun resolveArgForFieldVal(
        defnForm: DefnForm,
        formValue: FormValueData?,
        defnDtoParagraph: DefnDtoParagraph?
    ): String? {
        if (defnDtoParagraph == null) return null
        return defnDtoParagraph.value?.joinToString("")
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
        return compMap.entries.find { it.key.getId() == fieldId }?.value
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
        val entry = callerEnt.roleMap.entries.find { it.key.getId() == roleIdStr }
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
