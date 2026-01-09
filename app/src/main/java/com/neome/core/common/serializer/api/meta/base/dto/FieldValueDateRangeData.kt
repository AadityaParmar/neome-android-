package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.FieldValueDateRange
import kotlinx.serialization.Serializable


@Serializable
data class FieldValueDateRangeData(
    override val from: String? = null,
    override val to: String? = null
) : FieldValueDateRange
