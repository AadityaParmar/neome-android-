package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.FieldValuePropertyMap
import kotlinx.serialization.Serializable


@Serializable
data class FieldValuePropertyMapData(
    override val keys: List<String>? = null,
    override val values: List<String>? = null
) : FieldValuePropertyMap
