package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnThemeStroke
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoColor
import com.neome.api.meta.base.dto.StudioDtoLayoutLocmapLineStroke
import com.neome.core.common.serializer.api.meta.base.dto.StudioDtoColorData
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdVarSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioDtoLayoutLocmapLineStrokeData(
    override val color: StudioDtoColorData? = null,
    @Serializable(with = MetaIdFieldSer::class) override val colorFieldId: Types.MetaIdField? = null,
    @Serializable(with = MetaIdVarSer::class) override val colorVarId: Types.MetaIdVar? = null,
    @Serializable(with = MetaIdFieldSer::class) override val groupByFieldId: Types.MetaIdField? = null,
    override val stroke: EnumDefnThemeStroke? = null,
    @Serializable(with = MetaIdFieldSer::class) override val strokeFieldId: Types.MetaIdField? = null,
    @Serializable(with = MetaIdVarSer::class) override val strokeVarId: Types.MetaIdVar? = null
) : StudioDtoLayoutLocmapLineStroke
