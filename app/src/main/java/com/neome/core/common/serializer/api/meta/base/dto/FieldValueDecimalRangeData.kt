package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.FieldValueDecimalRange
import kotlinx.serialization.Serializable


@Serializable
data class FieldValueDecimalRangeData(
    override val maxValue: Long? = null,
    override val minValue: Long? = null
) : FieldValueDecimalRange
