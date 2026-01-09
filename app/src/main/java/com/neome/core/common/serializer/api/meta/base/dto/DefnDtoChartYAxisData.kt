package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.DefnDtoChartYAxis
import com.neome.api.meta.base.dto.DefnDtoColor
import com.neome.core.common.serializer.sysId.MetaIdChartYAxisSer
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import kotlinx.serialization.Serializable


@Serializable
data class DefnDtoChartYAxisData(
    override val color: DefnDtoColor? = null,
    @Serializable(with = MetaIdFieldSer::class) override val colorFieldId: Types.MetaIdField? = null,
    override val colorVar: DefnDtoColor? = null,
    @Serializable(with = MetaIdFieldSer::class) override val fieldId: Types.MetaIdField,
    override val label: String? = null,
    @Serializable(with = MetaIdChartYAxisSer::class) override val metaId: Types.MetaIdChartYAxis
) : DefnDtoChartYAxis
