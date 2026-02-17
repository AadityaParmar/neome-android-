package com.neome.feature.form.domain.util.FieldVal

import com.neome.api.meta.base.AnyValue
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.AnyTime
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueColorData
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueDateData
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueDecimalData
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueEmailData
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueHandleData
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueMobileData
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueNumberData
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueParagraphData
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueTextData
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

                Types.EnumDefnCompType.time -> {
                    val stringValue = when (value) {
                        is JsonElement -> value.jsonPrimitive.content
                        else -> value.toString()
                    }
                    AnyValue.create(stringValue, AnyTime::class.java)
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


}
