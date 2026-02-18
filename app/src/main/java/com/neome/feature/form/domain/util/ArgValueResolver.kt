package com.neome.feature.form.domain.util

import android.util.Log
import com.neome.api.ent.entDrawer.sig.SigEntCaller
import com.neome.api.meta.base.SysId
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnArgBinder
import com.neome.api.meta.base.Types.EnumDefnArgBinderContext
import com.neome.api.meta.base.Types.EnumDefnCompType
import com.neome.api.meta.base.dto.DefnDtoParagraph
import com.neome.api.meta.base.dto.DefnDtoText
import com.neome.api.meta.base.dto.DefnFieldDate
import com.neome.api.meta.base.dto.DefnFieldDateTime
import com.neome.api.meta.base.dto.DefnFieldEditable
import com.neome.api.meta.base.dto.DefnFieldEditableText
import com.neome.api.meta.base.dto.DefnFieldPickText
import com.neome.api.meta.base.dto.DefnForm
import com.neome.core.common.serializer.api.meta.base.dto.DefnBuildDateData
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
import com.neome.core.common.serializer.api.meta.base.dto.StudioDtoArgValueContextCallerData
import com.neome.core.common.serializer.api.meta.base.dto.StudioDtoArgValueContextCallerSettingData
import com.neome.core.common.serializer.api.meta.base.dto.StudioDtoArgValueContextData
import com.neome.core.common.serializer.api.meta.base.dto.StudioDtoArgValueContextEntData
import com.neome.core.common.serializer.api.meta.base.dto.StudioDtoArgValueDerivedData
import com.neome.core.common.serializer.api.meta.base.dto.StudioDtoArgValueFieldData
import com.neome.feature.form.domain.DefnFormUi
import com.neome.feature.form.domain.util.FieldVal.FieldValueResolver
import com.neome.feature.utils.JsonParser
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.decodeFromJsonElement
import kotlinx.serialization.json.jsonObject

object ArgValueResolver {

    private const val TAG = "ArgValueResolver"

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
            val resolvedVal = resolveArgStr(argStr, defnForm, callerEnt, skipResolveSeqVar)
            if (resolvedVal != null) {
                newValue.add(resolvedVal)
            }
        }

        return if (newValue.isEmpty()) null else DefnDtoTextData(value = newValue)
    }

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
            val resolvedVal = resolveArgStr(argStr, defnForm, callerEnt, false)
            if (resolvedVal != null) {
                newValue.add(resolvedVal)
            }
        }

        return if (newValue.isEmpty()) null else DefnDtoParagraphData(value = newValue)
    }

    fun resolveArgForFieldVal(
        defnForm: DefnForm,
        formValue: FormValueData,
        defnDtoText: DefnDtoText,
    ): String {

        val newValue = mutableListOf<String>()
        defnDtoText.value?.forEach { argStr ->
            if (argStr.isNotBlank())
                newValue.add(resolveArgStrField(argStr, defnForm, formValue))
        }
        return newValue.joinToString(", ")
    }

    fun resolveArgForFieldVal(
        defnForm: DefnForm,
        formValue: FormValueData,
        defnDtoText: DefnDtoParagraph,
    ): String {

        val newValue = mutableListOf<String>()
        defnDtoText.value?.forEach { argStr ->
            if (argStr.isNotBlank())
                newValue.add(resolveArgStrField(argStr, defnForm, formValue))
        }
        return newValue.joinToString(", ")
    }

    fun resolveArgStrField(
        argStr: String,
        defnForm: DefnForm,
        formValue: FormValueData,
    ): String {
        if (argStr.isBlank() || !JsonParser.isJsonString(argStr)) {
            return argStr
        }

        return try {
            val parsed = JsonParser.json.decodeFromString<StudioDtoArgValueForClient>(argStr)
            when (parsed.kind) {

                EnumDefnArgBinder.field -> {
                    val parsedField = JsonParser.json.decodeFromJsonElement<StudioDtoArgValueFieldData>(parsed.argValue)
                    val comp = defnForm.compMap[parsedField.fieldId] as? DefnCompSeal ?: return ""
                    val fieldValue = formValue.valueMap[parsedField.fieldId] ?: return ""
                    return FieldValueResolver.fnResolveFieldValueToSting(comp, fieldValue) ?: ""
                }

                else -> return argStr
            }

        } catch (e: Exception) {
            Log.e(TAG, "Failed to parse arg value: $argStr", e)
            ""
        }
    }

    /**
     * Parses and resolves a single arg value string.
     * If it's JSON, parse as StudioDtoArgValueForClient and dispatch by kind.
     * Otherwise return as-is.
     */
    fun resolveArgStr(
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
                    Types.EnumDefnArgBinderContextCaller.userId -> callerEnt.userId.toString()
                    Types.EnumDefnArgBinderContextCaller.entUserId -> callerEnt.entUserId.toString()
                    Types.EnumDefnArgBinderContextCaller.nickName -> callerEnt.nickName
                    Types.EnumDefnArgBinderContextCaller.handle -> callerEnt.handle
                    Types.EnumDefnArgBinderContextCaller.color -> callerEnt.color
                    Types.EnumDefnArgBinderContextCaller.email,
                    Types.EnumDefnArgBinderContextCaller.mobileNumber -> callerEnt.handle

                    Types.EnumDefnArgBinderContextCaller.managerId -> callerEnt.managerId?.toString()
                    Types.EnumDefnArgBinderContextCaller.roles -> {
                        callerEnt.roleMap.values.joinToString(", ") { role ->
                            role.label ?: role.name.toString()
                        }
                    }

                    else -> argStr
                }
            }

            EnumDefnArgBinderContext.callerSetting -> {
                val setting =
                    JsonParser.json.decodeFromJsonElement<StudioDtoArgValueContextCallerSettingData>(argValJson)
                val variable = callerEnt.userSettingVarMap?.get(setting.userSettingVarId)
                variable?.value?.toString() ?: argStr
            }

            EnumDefnArgBinderContext.ent -> {
                val ent = JsonParser.json.decodeFromJsonElement<StudioDtoArgValueContextEntData>(argValJson)
                when (ent.attribute) {
                    Types.EnumDefnArgBinderContextEnt.id -> callerEnt.entId.toString()
                    Types.EnumDefnArgBinderContextEnt.timeZone -> callerEnt.timeZone?.toString()
                    Types.EnumDefnArgBinderContextEnt.displayDateFormat -> callerEnt.displayDateFormat
                    else -> argStr
                }
            }

            EnumDefnArgBinderContext.row -> argStr  // Resolve after value
            else -> argStr
        }
    }

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
                val optionMap = pickText?.optionMap
                if (optionId != null && optionMap?.map != null) {
                    optionMap.map[optionId]?.value ?: optionId
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
                    val roleId = SysId.create<Types.MetaIdRole>(optionId)
                    callerEnt.roleMap[roleId]?.name?.toString() ?: optionId
                } else {
                    null
                }
            }

            else -> null
        }
    }

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
                val timeZone = callerEnt.timeZone?.toString()
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
                val timeZone = callerEnt.timeZone?.toString()
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

    /**
     * Resolves DefnFieldEditable base properties (helperTextVar, placeHolderVar, prefixVar, suffixVar)
     * for any DefnCompSeal that implements DefnFieldEditable.
     * Uses JSON round-trip to generically update properties without type-casting to each concrete class.
     */
    private fun resolveEditableProps(
        comp: DefnCompSeal,
        defnForm: DefnForm,
        callerEnt: SigEntCaller
    ): DefnCompSeal {
        if (comp !is DefnFieldEditable) return comp

        val editable = comp as DefnFieldEditable
        val resolvedHelperTextVar = resolve(editable.helperTextVar, defnForm, callerEnt)
        val resolvedPlaceHolderVar = resolve(editable.placeHolderVar, defnForm, callerEnt)
        val resolvedPrefixVar = resolve(editable.prefixVar, defnForm, callerEnt)
        val resolvedSuffixVar = resolve(editable.suffixVar, defnForm, callerEnt)

        val jsonMap = JsonParser.json.encodeToJsonElement(
            DefnCompSeal.serializer(), comp
        ).jsonObject.toMutableMap()

        jsonMap.putResolved("helperTextVar", resolvedHelperTextVar)
        jsonMap.putResolved("placeHolderVar", resolvedPlaceHolderVar)
        jsonMap.putResolved("prefixVar", resolvedPrefixVar)
        jsonMap.putResolved("suffixVar", resolvedSuffixVar)

        return JsonParser.json.decodeFromJsonElement(
            DefnCompSeal.serializer(), JsonObject(jsonMap)
        )
    }

    /**
     * Resolves DefnFieldEditableText.defaultVar (DefnDtoText type)
     * for any DefnCompSeal that implements DefnFieldEditableText.
     * Uses JSON round-trip to generically update the property without type-casting to each concrete class.
     */
    private fun resolveEditableTextProps(
        comp: DefnCompSeal,
        defnForm: DefnForm,
        callerEnt: SigEntCaller
    ): DefnCompSeal {
        if (comp !is DefnFieldEditableText) return comp

        val editableText = comp as DefnFieldEditableText
        val resolvedDefaultVar = resolve(editableText.defaultVar, defnForm, callerEnt)

        val jsonMap = JsonParser.json.encodeToJsonElement(
            DefnCompSeal.serializer(), comp
        ).jsonObject.toMutableMap()

        jsonMap.putResolved("defaultVar", resolvedDefaultVar)

        return JsonParser.json.decodeFromJsonElement(
            DefnCompSeal.serializer(), JsonObject(jsonMap)
        )
    }

    /**
     * Helper to put a resolved DefnDtoTextData into a mutable JSON map.
     * If the resolved value is null, removes the key; otherwise encodes and puts it.
     */
    private fun MutableMap<String, JsonElement>.putResolved(
        key: String,
        value: DefnDtoTextData?
    ) {
        if (value != null) {
            this[key] = JsonParser.json.encodeToJsonElement(DefnDtoTextData.serializer(), value)
        } else {
            this.remove(key)
        }
    }

    /**
     * Resolves all DefnDtoText/DefnDtoParagraph properties on a component.
     * First resolves DefnFieldEditable and DefnFieldEditableText base properties generically,
     * then pattern matches on concrete Data types for type-specific properties.
     */
    private fun resolveDefnComp(
        comp: DefnCompSeal,
        defnForm: DefnForm,
        callerEnt: SigEntCaller
    ): DefnCompSeal {

        // Step 1: Generically resolve DefnFieldEditable base props
        val editableResolved = resolveEditableProps(comp, defnForm, callerEnt)

        // Step 2: Generically resolve DefnFieldEditableText.defaultVar
        val resolved = resolveEditableTextProps(editableResolved, defnForm, callerEnt)

        // Step 3: Handle type-specific properties beyond editable base
        return when (resolved) {
            is DefnFieldButtonData -> resolved.copy(
                toastMessageOnClickVar = resolve(resolved.toastMessageOnClickVar, defnForm, callerEnt),
                whatsAppMessage = resolveParagraph(resolved.whatsAppMessage, defnForm, callerEnt)
            )

            is DefnFieldSwitchData -> resolved.copy(
                checkboxLabelVar = resolve(resolved.checkboxLabelVar, defnForm, callerEnt)
            )

            is DefnFieldIdentifierData -> resolved.copy(
                textPatternVar = resolve(resolved.textPatternVar, defnForm, callerEnt)
            )

            is DefnFieldHyperlinkRowData -> resolved.copy(
                displayTextVar = resolve(resolved.displayTextVar, defnForm, callerEnt)
            )

            is DefnFieldLabelData -> resolved.copy(
                textPatternVar = resolve(resolved.textPatternVar, defnForm, callerEnt)
            )

            is DefnFieldInfoData -> resolved.copy(
                labelPatternVar = resolve(resolved.labelPatternVar, defnForm, callerEnt),
                defaultVar = resolveParagraph(resolved.defaultVar, defnForm, callerEnt),
                textPatternVar = resolve(resolved.textPatternVar, defnForm, callerEnt)
            )

            is DefnFieldParagraphData -> resolved.copy(
                defaultVar = resolveParagraph(resolved.defaultVar, defnForm, callerEnt)
            )

            is DefnFieldShowCodeData -> resolved.copy(
                defaultVar = resolveParagraph(resolved.defaultVar, defnForm, callerEnt)
            )

            is DefnFieldHtmlData -> resolved.copy(
                defaultVar = resolveParagraph(resolved.defaultVar, defnForm, callerEnt),
                placeHolderVar = resolveParagraph(resolved.placeHolderVar, defnForm, callerEnt)
            )

            is DefnGridData -> resolved  // Skip grid resolution

            else -> resolved
        }
    }

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

}
