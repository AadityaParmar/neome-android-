package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.FieldValueDateTimeRange
import kotlinx.serialization.Serializable


@Serializable
data class FieldValueDateTimeRangeData(
    override val from: String? = null,
    override val to: String? = null
) : FieldValueDateTimeRange
