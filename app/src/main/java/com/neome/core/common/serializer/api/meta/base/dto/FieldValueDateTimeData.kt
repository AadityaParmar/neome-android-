package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.FieldValueDateTime
import kotlinx.serialization.Serializable


@Serializable
data class FieldValueDateTimeData(
    override val value: String
) : FieldValueDateTime
