package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnCompType
import com.neome.api.meta.base.dto.FieldValueDynamic
import kotlinx.serialization.Serializable


@Serializable
data class FieldValueDynamicData(
    override val fieldType: EnumDefnCompType? = null,
    override val value: String
) : FieldValueDynamic
