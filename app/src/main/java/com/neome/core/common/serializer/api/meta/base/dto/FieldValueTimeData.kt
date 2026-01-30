package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.FieldValueTime
import kotlinx.serialization.Serializable


@Serializable
data class FieldValueTimeData(
    override val value: String
) : FieldValueTime
