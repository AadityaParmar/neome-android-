package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.FieldValueDate
import kotlinx.serialization.Serializable


@Serializable
data class FieldValueDateData(
    override val value: String
) : FieldValueDate
