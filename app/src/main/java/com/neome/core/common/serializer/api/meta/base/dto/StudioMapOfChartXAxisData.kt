package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoChartXAxis
import com.neome.api.meta.base.dto.StudioMapOfChartXAxis
import com.neome.core.common.serializer.sysId.MetaIdChartXAxisSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioMapOfChartXAxisData(
    override val keys: Array<@Serializable(with = MetaIdChartXAxisSer::class) Types.MetaIdChartXAxis>,
    override val map: Map<@Serializable(with = MetaIdChartXAxisSer::class) Types.MetaIdChartXAxis, StudioDtoChartXAxis>
) : StudioMapOfChartXAxis
