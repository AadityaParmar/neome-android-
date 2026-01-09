package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.DefnDtoChartXAxis
import com.neome.api.meta.base.dto.DefnStudioMapOfChartXAxis
import com.neome.core.common.serializer.sysId.MetaIdChartXAxisSer
import kotlinx.serialization.Serializable


@Serializable
data class DefnStudioMapOfChartXAxisData(
    override val keys: Array<@Serializable(with = MetaIdChartXAxisSer::class) Types.MetaIdChartXAxis>,
    override val map: Map<@Serializable(with = MetaIdChartXAxisSer::class) Types.MetaIdChartXAxis, DefnDtoChartXAxis>
) : DefnStudioMapOfChartXAxis
