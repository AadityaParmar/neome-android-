package com.neome.feature.form.domain.util

import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueDecimalData
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueNumberData
import com.neome.core.common.serializer.api.meta.base.dto.FieldValueTextData

object fieldValueResolver {

    /**
     * Converts raw primitive values to appropriate field value types based on component type.
     *
     * @param compType The component type (text, number, decimal)
     * @param value The raw primitive value (String, Int, Long, Double, Boolean, etc.)
     * @return The appropriate FieldValue type or null if conversion fails
     */
    fun fnRawValueToFieldValue(compType: Types.EnumDefnCompType, value: Any?): Any? {
        if (value == null) return null

        try {
            return when (compType) {
                Types.EnumDefnCompType.text -> {
                    val stringValue = value.toString()
                    FieldValueTextData(stringValue)
                }

                Types.EnumDefnCompType.number -> {
                    val numberValue = when (value) {
                        is Long -> value
                        is Int -> value.toLong()
                        is Double -> value.toLong()
                        is Float -> value.toLong()
                        is String -> value.toLongOrNull()
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
     * @param value The FieldValue data object (FieldValueTextData, FieldValueNumberData, FieldValueDecimalData, etc.)
     * @return Raw primitive value (String, Long, etc.) or null if conversion fails
     */
    fun fnFieldValueToRawValue(compType: Types.EnumDefnCompType, value: Any?): Any? {
        if (value == null) return null

        try {
            return when (compType) {
                Types.EnumDefnCompType.text -> {
                    when (value) {
                        is FieldValueTextData -> value.value
                        else -> null
                    }
                }

                Types.EnumDefnCompType.number -> {
                    when (value) {
                        is FieldValueNumberData -> value.value
                        else -> null
                    }
                }

                Types.EnumDefnCompType.decimal -> {
                    when (value) {
                        is FieldValueDecimalData -> value.value
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
