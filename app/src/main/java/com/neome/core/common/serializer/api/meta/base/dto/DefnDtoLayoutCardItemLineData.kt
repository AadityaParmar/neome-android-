package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoLayoutCardItemLine
import com.neome.api.meta.base.dto.DefnDtoLayoutCardItemLineSegment
import kotlinx.serialization.Serializable


@Serializable
data class DefnDtoLayoutCardItemLineData(
    override val caption: DefnDtoLayoutCardItemLineSegment? = null,
    override val first: DefnDtoLayoutCardItemLineSegment? = null,
    override val middle: DefnDtoLayoutCardItemLineSegment? = null
) : DefnDtoLayoutCardItemLine
