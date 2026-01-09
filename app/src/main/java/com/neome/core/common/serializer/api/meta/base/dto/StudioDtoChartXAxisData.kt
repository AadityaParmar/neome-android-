package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoChartXAxis
import com.neome.api.meta.base.dto.StudioDtoColor
import com.neome.core.common.serializer.sysId.MetaIdChartXAxisSer
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioDtoChartXAxisData(
    override val color: StudioDtoColor? = null,
    @Serializable(with = MetaIdFieldSer::class) override val colorFieldId: Types.MetaIdField? = null,
    @Serializable(with = MetaIdVarSer::class) override val colorVarId: Types.MetaIdVar? = null,
    override val label: String? = null,
    @Serializable(with = MetaIdChartXAxisSer::class) override val metaId: Types.MetaIdChartXAxis,
    @Serializable(with = SymbolSer::class) override val name: Symbol? = null,
    override val valueOptionId: String? = null
) : StudioDtoChartXAxis
