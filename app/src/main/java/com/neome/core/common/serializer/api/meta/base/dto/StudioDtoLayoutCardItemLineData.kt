package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoLayoutCardItemLine
import com.neome.api.meta.base.dto.StudioDtoLayoutCardItemLineSegment
import kotlinx.serialization.Serializable


@Serializable
data class StudioDtoLayoutCardItemLineData(
    override val caption: StudioDtoLayoutCardItemLineSegment? = null,
    override val first: StudioDtoLayoutCardItemLineSegment? = null,
    override val middle: StudioDtoLayoutCardItemLineSegment? = null
) : StudioDtoLayoutCardItemLine
