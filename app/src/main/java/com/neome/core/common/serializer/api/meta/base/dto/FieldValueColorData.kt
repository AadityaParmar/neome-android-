package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.FieldValueColor
import kotlinx.serialization.Serializable


@Serializable
data class FieldValueColorData(
    override val value: String
) : FieldValueColor
