package com.neome.feature.form.domain.util

import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueDateData
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueDecimalData
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueEmailData
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueNumberData
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueParagraphData
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueTextData
import com.neome.feature.utils.JsonParser
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonPrimitive

object fieldvalueResolver {

    /**
     * Converts raw primitive values to appropriate field value types based on component type.
     *
     * @param compType The component type (text, number, decimal)
     * @param value The raw primitive value (String, Int, Long, Double, Boolean, JsonElement, etc.)
     * @return The appropriate FieldValue type or null if conversion fails
     */
    fun fnRawValueToFieldValue(compType: Types.EnumDefnCompType, value: Any?): Any? {
        if (value == null) return null

        try {
            return when (compType) {
                Types.EnumDefnCompType.text -> {
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

                Types.EnumDefnCompType.date -> {
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

                Types.EnumDefnCompType.number -> {
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

                Types.EnumDefnCompType.decimal -> {
                    val decimalValue = when (value) {
                        is Long -> value
                        is Int -> value.toLong()
                        is Double -> value.toLong()
                        is Float -> value.toLong()
                        is String -> value.toLongOrNull()
                        is JsonElement -> value.jsonPrimitive.content.toLongOrNull()
                        else -> value.toString().toLongOrNull()
                    }
                    decimalValue?.let { FieldValueDecimalData(it) }
                }

                else -> null
            }
        } catch (e: Exception) {
            return null // Return null if conversion fails
        }
    }

    /**
     * Converts FieldValue data objects back to raw primitive types.
     *
     * @param compType The component type (text, number, decimal)
     * @param value The FieldValue data object (FieldValueTextData, FieldValueNumberData, FieldValueDecimalData, etc.) or JsonElement
     * @return Raw primitive value (String, Long, etc.) or null if conversion fails
     */
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
            return null // Return null if conversion fails
        }
    }
}
