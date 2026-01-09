package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.FieldValuePropertyMap
import kotlinx.serialization.Serializable


@Serializable
data class FieldValuePropertyMapData(
    override val keys: Array<String>? = null,
    override val values: Array<String>? = null
) : FieldValuePropertyMap
