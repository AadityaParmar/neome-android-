package com.neome.feature.form.domain.util.FieldVal

import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.api.meta.base.dto.DefnCompSeal
import com.neome.core.common.serializer.api.meta.base.dto.FieldChipSetDateTimeData
import com.neome.core.common.serializer.api.meta.base.dto.FieldChipSetDayData
import com.neome.core.common.serializer.api.meta.base.dto.FieldChipSetDeviceSizeData
import com.neome.core.common.serializer.api.meta.base.dto.FieldChipSetDeviceTypeData
import com.neome.core.common.serializer.api.meta.base.dto.FieldChipSetTimeData
import com.neome.core.common.serializer.api.meta.base.dto.FieldSetOfEntUserIdData
import com.neome.core.common.serializer.api.meta.base.dto.FieldSetOfOptionIdData
import com.neome.core.common.serializer.api.meta.base.dto.FieldSetOfRoleData
import com.neome.core.common.serializer.api.meta.base.dto.FieldSetOfStringData
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueColorData
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueDateData
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueDecimalData
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueEmailData
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueEntUserIdData
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueHandleData
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueMobileData
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueNumberData
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueOptionIdData
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueParagraphData
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueSwitchData
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueTextData
import com.neome.core.common.serializer.api.meta.base.dto.StudioSetOfDateData
import com.neome.core.logging.AppLogger
import com.neome.feature.utils.JsonParser
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonPrimitive
import kotlinx.serialization.serializerOrNull

internal interface Converter {

    companion object {
        private const val TAG = "FieldValueConverter"
    }

    fun fnRawValueToFieldValue(compType: Types.EnumDefnCompType, value: Any?): Any? {
        if (value == null) return null

        try {
            return when (compType) {
                Types.EnumDefnCompType.text,
                Types.EnumDefnCompType.password,
                Types.EnumDefnCompType.icon,
                Types.EnumDefnCompType.info,
                Types.EnumDefnCompType.identifier,
                Types.EnumDefnCompType.symbol,
                Types.EnumDefnCompType.otp -> {
                    val stringValue = when (value) {
                        is JsonElement -> value.jsonPrimitive.content
                        else -> value.toString()
                    }
                    FieldValueTextData(stringValue)
                }

                Types.EnumDefnCompType.email -> {
                    val stringValue = when (value) {
                        is JsonElement -> value.jsonPrimitive.content
                        else -> value.toString()
                    }
                    FieldValueEmailData(stringValue)
                }

                Types.EnumDefnCompType.mobileNumber -> {
                    val stringValue = when (value) {
                        is JsonElement -> value.jsonPrimitive.content
                        else -> value.toString()
                    }
                    FieldValueMobileData(stringValue)
                }

                Types.EnumDefnCompType.handle -> {
                    val stringValue = when (value) {
                        is JsonElement -> value.jsonPrimitive.content
                        else -> value.toString()
                    }
                    FieldValueHandleData(stringValue)
                }

                Types.EnumDefnCompType.hyperlink -> {
                    val stringValue = when (value) {
                        is JsonElement -> value.jsonPrimitive.content
                        else -> value.toString()
                    }
                    FieldValueTextData(stringValue)
                }

                Types.EnumDefnCompType.color -> {
                    val stringValue = when (value) {
                        is JsonElement -> value.jsonPrimitive.content
                        else -> value.toString()
                    }
                    FieldValueColorData(stringValue)
                }

                Types.EnumDefnCompType.date -> {
                    val stringValue = when (value) {
                        is JsonElement -> value.jsonPrimitive.content
                        else -> value.toString()
                    }
                    FieldValueDateData(stringValue)
                }

                Types.EnumDefnCompType.time -> when (value) {
                    is JsonElement -> value.jsonPrimitive.content
                    else -> value.toString()
                }


                Types.EnumDefnCompType.dateTime -> {
                    val stringValue = when (value) {
                        is JsonElement -> value.jsonPrimitive.content
                        else -> value.toString()
                    }
                    FieldValueDateData(stringValue)
                }

                Types.EnumDefnCompType.paragraph -> {
                    val stringValue = when (value) {
                        is JsonElement -> value.jsonPrimitive.content
                        else -> value.toString()
                    }
                    FieldValueParagraphData(stringValue)
                }

                Types.EnumDefnCompType.number,
                Types.EnumDefnCompType.logNumber,
                Types.EnumDefnCompType.counter,
                Types.EnumDefnCompType.logCounter,
                Types.EnumDefnCompType.rating -> {
                    val numberValue = when (value) {
                        is Long -> value
                        is Int -> value.toLong()
                        is Double -> value.toLong()
                        is Float -> value.toLong()
                        is String -> value.toLongOrNull()
                        is JsonElement -> value.jsonPrimitive.content.toLongOrNull()
                        else -> value.toString().toLongOrNull()
                    }
                    numberValue?.let { FieldValueNumberData(it) }
                }

                Types.EnumDefnCompType.decimal,
                Types.EnumDefnCompType.logDecimal -> {
                    val decimalValue = when (value) {
                        is Long -> value.toDouble()
                        is Int -> value.toDouble()
                        is Double -> value
                        is Float -> value.toDouble()
                        is String -> value.toDoubleOrNull()
                        is JsonElement -> value.jsonPrimitive.content.toDoubleOrNull()
                        else -> value.toString().toDoubleOrNull()
                    }
                    decimalValue?.let { FieldValueDecimalData(it) }
                }

                // Complex types — serialized/deserialized via KSerializer in FieldController
                Types.EnumDefnCompType.pickText -> null

                // ── Set-type fields ────────────────────────────────────────────

                Types.EnumDefnCompType.setOfUser -> {
                    @Suppress("UNCHECKED_CAST")
                    val list = value as? List<Types.EntUserId> ?: return null
                    FieldSetOfEntUserIdData(valueSet = list)
                }

                Types.EnumDefnCompType.setOfRole -> {
                    @Suppress("UNCHECKED_CAST")
                    val list = value as? List<Types.MetaIdRole> ?: return null
                    FieldSetOfRoleData(valueSet = list)
                }

                Types.EnumDefnCompType.setOfText -> {
                    @Suppress("UNCHECKED_CAST")
                    val list = value as? List<String> ?: return null
                    FieldSetOfOptionIdData(valueSet = list)
                }

                Types.EnumDefnCompType.chipSet -> {
                    @Suppress("UNCHECKED_CAST")
                    val list = value as? List<String> ?: return null
                    FieldSetOfStringData(valueSet = list)
                }

                Types.EnumDefnCompType.chipSetDate -> {
                    @Suppress("UNCHECKED_CAST")
                    val list = value as? List<String> ?: return null
                    StudioSetOfDateData(valueSet = list)
                }

                Types.EnumDefnCompType.chipSetDay -> {
                    @Suppress("UNCHECKED_CAST")
                    val list = value as? List<Types.EnumDefnDay> ?: return null
                    FieldChipSetDayData(valueSet = list)
                }

                Types.EnumDefnCompType.chipSetDeviceType -> {
                    @Suppress("UNCHECKED_CAST")
                    val list = value as? List<Types.EnumDeviceType> ?: return null
                    FieldChipSetDeviceTypeData(valueSet = list)
                }

                Types.EnumDefnCompType.chipSetDeviceSize -> {
                    @Suppress("UNCHECKED_CAST")
                    val list = value as? List<Types.EnumDefnDeviceSize> ?: return null
                    FieldChipSetDeviceSizeData(valueSet = list)
                }

                Types.EnumDefnCompType.chipSetDateTime -> {
                    @Suppress("UNCHECKED_CAST")
                    val list = value as? List<String> ?: return null
                    FieldChipSetDateTimeData(valueSet = list)
                }

                Types.EnumDefnCompType.chipSetTime -> {
                    @Suppress("UNCHECKED_CAST")
                    val list = value as? List<Types.AnyTime> ?: return null
                    FieldChipSetTimeData(valueSet = list)
                }

                // ── Bool ───────────────────────────────────────────────────────

                Types.EnumDefnCompType.bool -> {
                    val boolValue = when (value) {
                        is Boolean -> value
                        is String -> value.toBooleanStrictOrNull() ?: false
                        else -> false
                    }
                    FieldValueSwitchData(value = boolValue)
                }

                // ── userId (single user) ───────────────────────────────────────

                Types.EnumDefnCompType.userId,
                Types.EnumDefnCompType.pickUser -> {
                    when (value) {
                        is Types.EntUserId -> FieldValueEntUserIdData(value = value)
                        else -> null
                    }
                }

                else -> null
            }
        } catch (e: Exception) {
            AppLogger.w(TAG, "fnRawValueToFieldValue failed for compType=$compType", e)
            return null
        }
    }

    fun fnFieldValueToRawValue(compType: Types.EnumDefnCompType, value: Any?): Any? {
        if (value == null) return null

        try {
            return when (compType) {
                Types.EnumDefnCompType.text -> {
                    when (value) {
                        is FieldValueTextData -> value.value
                        is JsonElement -> JsonParser.json.decodeFromJsonElement(
                            FieldValueTextData.serializer(),
                            value
                        ).value

                        else -> null
                    }
                }

                Types.EnumDefnCompType.email -> {
                    when (value) {
                        is FieldValueEmailData -> value.value
                        is JsonElement -> JsonParser.json.decodeFromJsonElement(
                            FieldValueEmailData.serializer(),
                            value
                        ).value

                        else -> null
                    }
                }

                Types.EnumDefnCompType.date -> {
                    when (value) {
                        is FieldValueDateData -> value.value
                        is JsonElement -> JsonParser.json.decodeFromJsonElement(
                            FieldValueDateData.serializer(),
                            value
                        ).value

                        else -> null
                    }
                }

                Types.EnumDefnCompType.paragraph -> {
                    when (value) {
                        is FieldValueParagraphData -> value.value
                        is JsonElement -> JsonParser.json.decodeFromJsonElement(
                            FieldValueParagraphData.serializer(),
                            value
                        ).value

                        else -> null
                    }
                }

                Types.EnumDefnCompType.number -> {
                    when (value) {
                        is FieldValueNumberData -> value.value
                        is JsonElement -> JsonParser.json.decodeFromJsonElement(
                            FieldValueNumberData.serializer(),
                            value
                        ).value

                        else -> null
                    }
                }

                Types.EnumDefnCompType.decimal -> {
                    when (value) {
                        is FieldValueDecimalData -> value.value
                        is JsonElement -> JsonParser.json.decodeFromJsonElement(
                            FieldValueDecimalData.serializer(),
                            value
                        ).value

                        else -> null
                    }
                }

                Types.EnumDefnCompType.pickText -> {
                    when (value) {
                        is FieldValueOptionIdData -> value.optionId
                        is JsonElement -> JsonParser.json.decodeFromJsonElement(
                            FieldValueOptionIdData.serializer(),
                            value
                        ).optionId

                        else -> null
                    }
                }

                Types.EnumDefnCompType.setOfText -> {
                    when (value) {
                        is FieldSetOfOptionIdData -> value.valueSet
                        is JsonElement -> JsonParser.json.decodeFromJsonElement(
                            FieldSetOfOptionIdData.serializer(),
                            value
                        ).valueSet

                        else -> null
                    }
                }

                // ── Set-type fields ────────────────────────────────────────────

                Types.EnumDefnCompType.setOfUser -> {
                    when (value) {
                        is FieldSetOfEntUserIdData -> value.valueSet
                        is JsonElement -> JsonParser.json.decodeFromJsonElement(
                            FieldSetOfEntUserIdData.serializer(),
                            value
                        ).valueSet

                        else -> null
                    }
                }

                Types.EnumDefnCompType.setOfRole -> {
                    when (value) {
                        is FieldSetOfRoleData -> value.valueSet
                        is JsonElement -> JsonParser.json.decodeFromJsonElement(
                            FieldSetOfRoleData.serializer(),
                            value
                        ).valueSet

                        else -> null
                    }
                }

                Types.EnumDefnCompType.chipSet -> {
                    when (value) {
                        is FieldSetOfStringData -> value.valueSet
                        is JsonElement -> JsonParser.json.decodeFromJsonElement(
                            FieldSetOfStringData.serializer(),
                            value
                        ).valueSet

                        else -> null
                    }
                }

                Types.EnumDefnCompType.chipSetDate -> {
                    when (value) {
                        is StudioSetOfDateData -> value.valueSet
                        is JsonElement -> JsonParser.json.decodeFromJsonElement(
                            StudioSetOfDateData.serializer(),
                            value
                        ).valueSet

                        else -> null
                    }
                }

                Types.EnumDefnCompType.chipSetDay -> {
                    when (value) {
                        is FieldChipSetDayData -> value.valueSet
                        is JsonElement -> JsonParser.json.decodeFromJsonElement(
                            FieldChipSetDayData.serializer(),
                            value
                        ).valueSet

                        else -> null
                    }
                }

                Types.EnumDefnCompType.chipSetDeviceType -> {
                    when (value) {
                        is FieldChipSetDeviceTypeData -> value.valueSet
                        is JsonElement -> JsonParser.json.decodeFromJsonElement(
                            FieldChipSetDeviceTypeData.serializer(),
                            value
                        ).valueSet

                        else -> null
                    }
                }

                Types.EnumDefnCompType.chipSetDeviceSize -> {
                    when (value) {
                        is FieldChipSetDeviceSizeData -> value.valueSet
                        is JsonElement -> JsonParser.json.decodeFromJsonElement(
                            FieldChipSetDeviceSizeData.serializer(),
                            value
                        ).valueSet

                        else -> null
                    }
                }

                Types.EnumDefnCompType.chipSetDateTime -> {
                    when (value) {
                        is FieldChipSetDateTimeData -> value.valueSet
                        is JsonElement -> JsonParser.json.decodeFromJsonElement(
                            FieldChipSetDateTimeData.serializer(),
                            value
                        ).valueSet

                        else -> null
                    }
                }

                Types.EnumDefnCompType.chipSetTime -> {
                    when (value) {
                        is FieldChipSetTimeData -> value.valueSet
                        is JsonElement -> JsonParser.json.decodeFromJsonElement(
                            FieldChipSetTimeData.serializer(),
                            value
                        ).valueSet

                        else -> null
                    }
                }

                // ── Bool ───────────────────────────────────────────────────────

                Types.EnumDefnCompType.bool -> {
                    when (value) {
                        is FieldValueSwitchData -> value.value
                        is JsonElement -> JsonParser.json.decodeFromJsonElement(
                            FieldValueSwitchData.serializer(),
                            value
                        ).value

                        else -> null
                    }
                }

                // ── userId (single user) ───────────────────────────────────────

                Types.EnumDefnCompType.userId,
                Types.EnumDefnCompType.pickUser -> {
                    when (value) {
                        is FieldValueEntUserIdData -> value.value
                        is JsonElement -> JsonParser.json.decodeFromJsonElement(
                            FieldValueEntUserIdData.serializer(),
                            value
                        ).value

                        else -> null
                    }
                }

                else -> null
            }
        } catch (e: Exception) {
            AppLogger.w(TAG, "fnFieldValueToRawValue failed for compType=$compType", e)
            return null
        }
    }

    fun fnJsonElementFieldValue(compType: Types.EnumDefnCompType, value: JsonElement?): Any? {
        if (value == null) return null

        return try {
            fnRawValueToFieldValue(compType, fnFieldValueToRawValue(compType, value))
        } catch (e: Exception) {
            AppLogger.w(TAG, "fnJsonElementFieldValue failed for compType=$compType", e)
            null
        }
    }

    fun fnFieldValueToJsonElement(compType: Types.EnumDefnCompType, value: Any?): JsonElement? {
        if (value == null) return null

        return try {
            val kSerializer = serializerOrNull(value::class.java)
                ?: return null
            JsonParser.json.encodeToJsonElement(
                kSerializer,
                value
            )
        } catch (e: Exception) {
            AppLogger.w(TAG, "fnFieldValueToJsonElement failed for ${value::class.simpleName}", e)
            null
        }
    }

    fun fnResolveNumericValue(compType: Types.EnumDefnCompType, value: Any?): Long? {

        val fieldValueForAnyValue = if (value is JsonElement) fnJsonElementFieldValue(compType, value) else value

        return when (fieldValueForAnyValue) {
            is Long -> fieldValueForAnyValue
            is Int -> fieldValueForAnyValue.toLong()
            is Double -> fieldValueForAnyValue.toLong()
            is Float -> fieldValueForAnyValue.toLong()
            is String -> fieldValueForAnyValue.toLongOrNull()
            is FieldValueDecimalData -> fieldValueForAnyValue.value?.toLong()
            is FieldValueNumberData -> fieldValueForAnyValue.value
            else -> fieldValueForAnyValue.toString().toLongOrNull()
        }
    }

    fun fnResolveNumericDecimalValue(compType: Types.EnumDefnCompType, value: Any?): Double? {

        val fieldValueForAnyValue = if (value is JsonElement) fnJsonElementFieldValue(compType, value) else value

        return when (fieldValueForAnyValue) {
            is Long -> fieldValueForAnyValue.toDouble()
            is Int -> fieldValueForAnyValue.toDouble()
            is Double -> fieldValueForAnyValue
            is Float -> fieldValueForAnyValue.toDouble()
            is String -> fieldValueForAnyValue.toDoubleOrNull()
            is FieldValueDecimalData -> fieldValueForAnyValue.value
            is FieldValueNumberData -> fieldValueForAnyValue.value?.toDouble()
            else -> value.toString().toDoubleOrNull()
        }
    }

    fun fnResolveFieldValueToSting(defnComp: DefnCompSeal, value: JsonElement?): String? {
        val compType = defnComp.type
        return fnFieldValueToRawValue(compType, value)?.toString()
    }


}
