package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnThemeStroke
import com.neome.api.meta.base.dto.DefnDtoColor
import com.neome.api.meta.base.dto.DefnDtoLayoutLocmapLineStroke
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import kotlinx.serialization.Serializable


@Serializable
data class DefnDtoLayoutLocmapLineStrokeData(
    override val color: DefnDtoColor? = null,
    @Serializable(with = MetaIdFieldSer::class) override val colorFieldId: Types.MetaIdField? = null,
    override val colorVar: DefnDtoColor? = null,
    @Serializable(with = MetaIdFieldSer::class) override val groupByFieldId: Types.MetaIdField? = null,
    override val stroke: EnumDefnThemeStroke? = null,
    @Serializable(with = MetaIdFieldSer::class) override val strokeFieldId: Types.MetaIdField? = null,
    override val strokeVar: EnumDefnThemeStroke? = null
) : DefnDtoLayoutLocmapLineStroke
