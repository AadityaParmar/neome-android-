package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.FieldValueNumber
import kotlinx.serialization.Serializable


@Serializable
data class FieldValueNumberData(
    override val value: Long
) : FieldValueNumber
