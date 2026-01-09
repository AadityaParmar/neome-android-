package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioVarValueDecimal
import kotlinx.serialization.Serializable


@Serializable
data class StudioVarValueDecimalData(
    override val value: Long? = null
) : StudioVarValueDecimal
