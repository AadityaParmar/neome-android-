package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.DefnDtoChartYAxis
import com.neome.api.meta.base.dto.DefnStudioMapOfChartYAxis
import com.neome.core.common.serializer.sysId.MetaIdChartYAxisSer
import kotlinx.serialization.Serializable


@Serializable
data class DefnStudioMapOfChartYAxisData(
    override val keys: Array<@Serializable(with = MetaIdChartYAxisSer::class) Types.MetaIdChartYAxis>,
    override val map: Map<@Serializable(with = MetaIdChartYAxisSer::class) Types.MetaIdChartYAxis, DefnDtoChartYAxis>
) : DefnStudioMapOfChartYAxis
