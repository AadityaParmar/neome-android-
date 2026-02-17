package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.StudioVarValueNumber
import kotlinx.serialization.Serializable


@Serializable
data class StudioVarValueNumberData(
    override val value: Long
) : StudioVarValueNumber
