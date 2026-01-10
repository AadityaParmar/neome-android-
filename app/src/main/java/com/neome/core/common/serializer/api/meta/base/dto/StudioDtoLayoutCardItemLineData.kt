package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoLayoutCardItemLine
import com.neome.api.meta.base.dto.StudioDtoLayoutCardItemLineSegment
import com.neome.core.common.serializer.api.meta.base.dto.StudioDtoLayoutCardItemLineSegmentData
import kotlinx.serialization.Serializable


@Serializable
data class StudioDtoLayoutCardItemLineData(
    override val caption: StudioDtoLayoutCardItemLineSegmentData? = null,
    override val first: StudioDtoLayoutCardItemLineSegmentData? = null,
    override val middle: StudioDtoLayoutCardItemLineSegmentData? = null
) : StudioDtoLayoutCardItemLine
