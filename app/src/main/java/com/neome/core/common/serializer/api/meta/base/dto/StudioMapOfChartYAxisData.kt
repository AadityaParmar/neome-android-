package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoChartYAxis
import com.neome.api.meta.base.dto.StudioMapOfChartYAxis
import com.neome.core.common.serializer.api.meta.base.dto.StudioDtoChartYAxisData
import com.neome.core.common.serializer.sysId.MetaIdChartYAxisSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioMapOfChartYAxisData(
    override val keys: List<@Serializable(with = MetaIdChartYAxisSer::class) Types.MetaIdChartYAxis>,
    override val map: Map<@Serializable(with = MetaIdChartYAxisSer::class) Types.MetaIdChartYAxis, StudioDtoChartYAxisData>
) : StudioMapOfChartYAxis
