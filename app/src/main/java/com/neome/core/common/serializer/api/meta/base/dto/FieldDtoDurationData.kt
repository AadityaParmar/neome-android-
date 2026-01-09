package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnDurationUnit
import com.neome.api.meta.base.dto.FieldDtoDuration
import kotlinx.serialization.Serializable


@Serializable
data class FieldDtoDurationData(
    override val unit: EnumDefnDurationUnit? = null,
    override val value: Long? = null
) : FieldDtoDuration
