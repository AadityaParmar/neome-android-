package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.FieldValueDecimal
import kotlinx.serialization.Serializable


@Serializable
data class FieldValueDecimalData(
    override val value: Double
) : FieldValueDecimal
