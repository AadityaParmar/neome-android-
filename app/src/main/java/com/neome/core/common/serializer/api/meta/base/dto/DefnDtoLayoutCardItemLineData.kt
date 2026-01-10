package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnDtoLayoutCardItemLine
import com.neome.api.meta.base.dto.DefnDtoLayoutCardItemLineSegment
import com.neome.core.common.serializer.api.meta.base.dto.DefnDtoLayoutCardItemLineSegmentData
import kotlinx.serialization.Serializable


@Serializable
data class DefnDtoLayoutCardItemLineData(
    override val caption: DefnDtoLayoutCardItemLineSegmentData? = null,
    override val first: DefnDtoLayoutCardItemLineSegmentData? = null,
    override val middle: DefnDtoLayoutCardItemLineSegmentData? = null
) : DefnDtoLayoutCardItemLine
