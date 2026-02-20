package com.neome.feature.form.domain.util

import android.util.Log
import com.neome.api.ent.entDrawer.sig.SigEntCaller
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnArgBinder
import com.neome.api.meta.base.Types.EnumDefnArgBinderContext
import com.neome.api.meta.base.Types.EnumDefnArgBinderContextCaller
import com.neome.api.meta.base.Types.EnumDefnCompType
import com.neome.api.meta.base.Types.EnumDefnEventOperator
import com.neome.api.meta.base.Types.EnumDefnFields
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.dto.DefnComp
import com.neome.api.meta.base.dto.DefnEventCondition
import com.neome.api.meta.base.dto.DefnEventConditionMap
import com.neome.api.meta.base.dto.DefnForm
import com.neome.api.meta.base.dto.FieldDtoArg
import com.neome.api.meta.base.dto.FormValue
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueDateData
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueEntUserIdData
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueTextData
import com.neome.core.common.serializer.api.meta.base.dto.StudioDtoArgValueContextCallerData
import com.neome.feature.form.domain.util.FieldVal.FieldValueResolver
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.decodeFromJsonElement
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import java.util.TimeZone


object ConditionResolver {

    private const val TAG = "ConditionResolver"

    private val SET_COMP_TYPES = setOf(
        EnumDefnCompType.setOfUser,
        EnumDefnCompType.setOfRole,
        EnumDefnCompType.setOfText,
        EnumDefnCompType.chipSet,
        EnumDefnCompType.chipSetDate,
        EnumDefnCompType.chipSetDay,
        EnumDefnCompType.chipSetDeviceType,
        EnumDefnCompType.chipSetDeviceSize,
        EnumDefnCompType.chipSetDateTime,
        EnumDefnCompType.chipSetTime
    )


    fun resolve(
        conditionMap: DefnEventConditionMap,
        defnForm: DefnForm,
        formValue: FormValue?,
        getValue: (MetaIdField) -> JsonElement?,
        callerEnt: SigEntCaller? = null
    ): Boolean? {

        return resolveCondition(conditionMap, defnForm, formValue, getValue, callerEnt)
    }

    private fun resolveCondition(
        condition: DefnEventConditionMap,
        defnForm: DefnForm,
        formValue: FormValue?,
        getValue: (MetaIdField) -> JsonElement?,
        callerEnt: SigEntCaller?
    ): Boolean? {
        if (condition.andOr != null) {
            val isAnd = condition.andOr
            val keys = condition.keys ?: return false
            val map = condition.map ?: return false

            val results = keys.map { conditionId ->
                val child = map[conditionId] ?: return@map null
                val childStatement = child.statement

                if (childStatement != null) {
                    resolveStatement(childStatement, defnForm, formValue, getValue, callerEnt)
                } else {
                    resolveCondition(child, defnForm, formValue, getValue, callerEnt)
                }
            }

            return if (isAnd == true) {
                results.all { it == true }
            } else {
                results.any { it == true }
            }
        }

        val statement = condition.statement
        if (statement != null) {
            return resolveStatement(statement, defnForm, formValue, getValue, callerEnt)
        }

        return false
    }

    private fun resolveStatement(
        statement: DefnEventCondition,
        defnForm: DefnForm,
        formValue: FormValue?,
        getValue: (MetaIdField) -> JsonElement?,
        callerEnt: SigEntCaller?
    ): Boolean? {

        val lhs = statement.lhs
        val lhsValue = resolvedFieldValue(lhs, defnForm.compMap, getValue, formValue)
        val rhs = statement.rhs
        val rhsValueArray = getRhsArray(rhs, defnForm, getValue, callerEnt)
        val rhsValue = getRhsValue(rhs, defnForm, formValue, getValue, callerEnt)

        return when (statement.operator) {
            EnumDefnEventOperator.hasNoValue -> isEmptyValue(lhsValue)
            EnumDefnEventOperator.hasValue -> !isEmptyValue(lhsValue)

            EnumDefnEventOperator.equalTo -> evaluateEqualTo(lhsValue, rhsValue, rhsValueArray)
            EnumDefnEventOperator.notEqualTo -> !evaluateEqualTo(lhsValue, rhsValue, rhsValueArray)

            EnumDefnEventOperator.contains -> evaluateContains(lhsValue, rhsValue, rhsValueArray)

            EnumDefnEventOperator.greaterThan -> evaluateComparison(
                lhsValue,
                rhsValue,
                defnForm,
                statement,
                getValue
            ) { a, b -> a > b }

            EnumDefnEventOperator.lessThan -> evaluateComparison(
                lhsValue,
                rhsValue,
                defnForm,
                statement,
                getValue
            ) { a, b -> a < b }

            EnumDefnEventOperator.greaterThanOrEqualTo -> evaluateComparison(
                lhsValue,
                rhsValue,
                defnForm,
                statement,
                getValue
            ) { a, b -> a >= b }

            EnumDefnEventOperator.lessThanOrEqualTo -> evaluateComparison(
                lhsValue,
                rhsValue,
                defnForm,
                statement,
                getValue
            ) { a, b -> a <= b }
        }
    }

    private fun getRhsArray(
        rhs: FieldDtoArg?,
        defnForm: DefnForm,
        getValue: (MetaIdField) -> JsonElement?,
        callerEnt: SigEntCaller?
    ): List<String>? {
        if (rhs == null) return null

        rhs.valueSysIdSet?.let { sysIdSet ->
            return sysIdSet.map { it.getId() ?: "" }
        }

        rhs.valueFieldId?.let { fieldId ->
            val compType = defnForm.compMap[fieldId]?.type
            if (compType != null && compType in SET_COMP_TYPES) {
                return (resolvedFieldValue(
                    fieldId,
                    defnForm.compMap,
                    getValue,
                    null
                ) as? List<Any?>?)?.map { it.toString() }
            }
        }

        rhs.valueSysIdArray?.let { array ->
            return array.map { it.getId() ?: "" }
        }

        rhs.valueTextArray?.let { return it }

        rhs.valueText?.let { text ->
            return resolveContextBinderArray(text, callerEnt)
        }

        return null
    }

    private fun getRhsValue(
        rhs: FieldDtoArg?,
        defnForm: DefnForm,
        formValue: FormValue?,
        getValue: (MetaIdField) -> JsonElement?,
        callerEnt: SigEntCaller?
    ): Any? {
        if (rhs == null) return null

        if (rhs.valueBoolean != null) return rhs.valueBoolean

        if (rhs.valueDate != null) return rhs.valueDate

        if (rhs.valueDouble != null) return rhs.valueDouble

        rhs.valueFieldId?.let { fieldId ->
            return resolvedFieldValue(fieldId, defnForm.compMap, getValue, formValue)
        }

        if (rhs.valueLong != null) return rhs.valueLong

        rhs.valueSysId?.let { return it.getId() ?: "" }

        val argStr = rhs.valueText
        if (argStr != null) {
            return if (callerEnt != null) {
                ArgValueResolver.resolveArgStr(argStr, defnForm, callerEnt, false)
            } else {
                argStr
            }
        }

        rhs.valueSysIdSet?.let { return it.map { sysId -> sysId.getId() ?: "" } }
        rhs.valueSysIdArray?.let { return it.map { sysId -> sysId.getId() ?: "" } }
        rhs.valueTextArray?.let { return it }

        return null
    }

    private fun resolveContextBinderArray(
        text: String,
        callerEnt: SigEntCaller?
    ): List<String>? {
        return try {
            val argValue = Json.decodeFromString<StudioDtoArgValueForClient>(text)
            if (argValue.kind == EnumDefnArgBinder.Context) {
                val callerData = Json.decodeFromJsonElement<StudioDtoArgValueContextCallerData>(argValue.argValue)
                if (callerData.kind == EnumDefnArgBinderContext.caller
                    && callerData.attribute == EnumDefnArgBinderContextCaller.roles
                ) {
                    callerEnt?.roleIdSet?.map { it.getId() ?: "" } ?: emptyList()
                } else null
            } else null
        } catch (e: Exception) {
            Log.w(TAG, "Failed to resolve context binder array from: $text", e)
            null
        }
    }

    fun resolvedFieldValue(
        fieldId: MetaIdField,
        compMap: Map<Types.MetaIdComp, DefnComp>?,
        getValue: (MetaIdField) -> JsonElement?,
        formValue: FormValue?
    ): Any? {
        val compType = compMap?.get(fieldId)?.type

        if (compType == null && fieldId.isSystem()) {
            val systemCompType = FormPlus.getSystemFieldCompType(fieldId) ?: return null
            if (formValue == null) return null

            return when (fieldId.getId()) {
                EnumDefnFields.CreatedBy.value ->
                    formValue.createdBy?.let {
                        FieldValueResolver.fnFieldValueToRawValue(systemCompType, FieldValueEntUserIdData(value = it))
                    }

                EnumDefnFields.UpdatedBy.value ->
                    formValue.updatedBy?.let {
                        FieldValueResolver.fnFieldValueToRawValue(systemCompType, FieldValueEntUserIdData(value = it))
                    }

                EnumDefnFields.CreatedOn.value ->
                    formValue.createdOn?.let {
                        FieldValueResolver.fnFieldValueToRawValue(systemCompType, FieldValueDateData(value = it))
                    }

                EnumDefnFields.UpdatedOn.value ->
                    formValue.updatedOn?.let {
                        FieldValueResolver.fnFieldValueToRawValue(systemCompType, FieldValueDateData(value = it))
                    }

                EnumDefnFields.RowId.value ->
                    FieldValueResolver.fnFieldValueToRawValue(systemCompType, formValue.rowId)

                EnumDefnFields.RowOrder.value ->
                    formValue.rowOrder?.let {
                        FieldValueResolver.fnFieldValueToRawValue(systemCompType, FieldValueTextData(value = it))
                    }

                else -> null
            }
        }

        if (compType != null) {
            val jsonValue = getValue(fieldId)
            return FieldValueResolver.fnFieldValueToRawValue(compType, jsonValue)
        }

        return null
    }

    private fun isEmptyValue(value: Any?): Boolean {
        return when (value) {
            null -> true
            is String -> value.isEmpty()
            is List<*> -> value.isEmpty()
            else -> false
        }
    }

    private fun evaluateEqualTo(
        lhsValue: Any?,
        rhsValue: Any?,
        rhsValueArray: List<String>?
    ): Boolean {
        if (rhsValueArray != null && lhsValue is List<*>) {
            val lhsList = lhsValue as List<String>
            if (rhsValueArray.size != lhsList.size) return false
            return rhsValueArray.toSet() == lhsList.toSet()
        }

        if (rhsValueArray != null && lhsValue is String) {
            return rhsValueArray.contains(lhsValue)
        }

        if (lhsValue is List<*> && rhsValue is String) {
            return lhsValue.contains(rhsValue)
        }

        return lhsValue == rhsValue
    }

    private fun evaluateContains(
        lhsValue: Any?,
        rhsValue: Any?,
        rhsValueArray: List<String>?
    ): Boolean {
        if (rhsValueArray != null && lhsValue is String) {
            return rhsValueArray.contains(lhsValue)
        }

        if (lhsValue is List<*> && rhsValue is String) {
            return lhsValue.contains(rhsValue)
        }

        if (rhsValueArray != null && lhsValue is List<*>) {
            val lhsSet = (lhsValue as List<String>).toSet()
            return rhsValueArray.any { it in lhsSet }
        }

        return false
    }

    private fun evaluateComparison(
        lhsValue: Any?,
        rhsValue: Any?,
        defnForm: DefnForm,
        statement: DefnEventCondition,
        getValue: (MetaIdField) -> JsonElement?,
        compare: (Long, Long) -> Boolean
    ): Boolean {
        val lhsNum = toNumeric(lhsValue)
        val rhsNum = toNumeric(rhsValue)
        if (lhsNum != null && rhsNum != null) {
            return compare(lhsNum, rhsNum)
        }

        val lhsDate = getFieldDateValue(defnForm, statement.lhs, getValue)
        val rhsDate = getRhsDate(defnForm, statement.rhs, getValue)
        if (lhsDate != null && rhsDate != null) {
            return compare(lhsDate, rhsDate)
        }

        return false
    }

    private fun toNumeric(value: Any?): Long? {
        return when (value) {
            is Long -> value
            is Int -> value.toLong()
            is Double -> value.toLong()
            is Float -> value.toLong()
            is String -> value.toLongOrNull()
            else -> null
        }
    }

    private fun getFieldDateValueAsNumber(compType: EnumDefnCompType, fieldValue: Any?): Long? {
        if (fieldValue == null) return null
        return when (compType) {
            EnumDefnCompType.date -> {
                val dateStr = fieldValue as? String ?: return null
                try {
                    val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US)
                    sdf.timeZone = TimeZone.getDefault()
                    val date = sdf.parse(dateStr) ?: return null
                    val cal = Calendar.getInstance()
                    cal.time = date
                    cal.set(Calendar.HOUR_OF_DAY, 0)
                    cal.set(Calendar.MINUTE, 0)
                    cal.set(Calendar.SECOND, 0)
                    cal.set(Calendar.MILLISECOND, 0)
                    cal.timeInMillis
                } catch (e: Exception) {
                    Log.w(TAG, "Failed to parse date: $dateStr", e)
                    null
                }
            }

            EnumDefnCompType.dateTime -> {
                val dateStr = fieldValue as? String ?: return null
                try {
                    val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US)
                    sdf.timeZone = TimeZone.getDefault()
                    val date = sdf.parse(dateStr) ?: return null
                    date.time
                } catch (e: Exception) {
                    Log.w(TAG, "Failed to parse dateTime: $dateStr", e)
                    null
                }
            }

            EnumDefnCompType.time -> {
                val timeStr = fieldValue as? String ?: return null
                try {
                    val parts = timeStr.split(":")
                    if (parts.size >= 2) {
                        val concatenated = parts.joinToString("")
                        concatenated.toLongOrNull()
                    } else null
                } catch (e: Exception) {
                    Log.w(TAG, "Failed to parse time: $timeStr", e)
                    null
                }
            }

            else -> null
        }
    }

    private fun getFieldDateValue(
        defnForm: DefnForm,
        fieldId: MetaIdField,
        getValue: (MetaIdField) -> JsonElement?
    ): Long? {
        val compType = defnForm.compMap[fieldId]?.type ?: return null
        val rawValue = getValue(fieldId) ?: return null
        return getFieldDateValueAsNumber(compType, rawValue)
    }

    private fun getRhsDate(
        defnForm: DefnForm,
        rhs: FieldDtoArg?,
        getValue: (MetaIdField) -> JsonElement?
    ): Long? {
        if (rhs == null) return null

        rhs.valueDate?.let { dateStr ->
            return try {
                val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US)
                sdf.timeZone = TimeZone.getDefault()
                sdf.parse(dateStr)?.time
            } catch (e: Exception) {
                Log.w(TAG, "Failed to parse RHS date: $dateStr", e)
                null
            }
        }

        rhs.valueFieldId?.let { fieldId ->
            return getFieldDateValue(defnForm, fieldId, getValue)
        }

        return null
    }


}
