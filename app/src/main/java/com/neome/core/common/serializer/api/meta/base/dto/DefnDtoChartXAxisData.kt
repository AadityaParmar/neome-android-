package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.DefnDtoChartXAxis
import com.neome.api.meta.base.dto.DefnDtoColor
import com.neome.core.common.serializer.sysId.MetaIdChartXAxisSer
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import kotlinx.serialization.Serializable


@Serializable
data class DefnDtoChartXAxisData(
    override val color: DefnDtoColor? = null,
    @Serializable(with = MetaIdFieldSer::class) override val colorFieldId: Types.MetaIdField? = null,
    override val colorVar: DefnDtoColor? = null,
    override val label: String? = null,
    @Serializable(with = MetaIdChartXAxisSer::class) override val metaId: Types.MetaIdChartXAxis,
    override val valueOptionId: String? = null
) : DefnDtoChartXAxis
