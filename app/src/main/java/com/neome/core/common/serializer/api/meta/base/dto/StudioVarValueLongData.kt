package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.StudioVarValueLong
import kotlinx.serialization.Serializable


@Serializable
data class StudioVarValueLongData(
    override val value: Long
) : StudioVarValueLong
