package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.EntVdRect
import com.neome.api.meta.base.dto.EntVdRegion
import com.neome.api.meta.base.dto.Point
import com.neome.api.meta.base.dto.Size
import com.neome.api.meta.base.dto.StudioDtoColor
import com.neome.core.common.serializer.sysId.MetaIdVdRegionSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class EntVdRegionData(
    override val bgClr: StudioDtoColor? = null,
    override val borderClr: StudioDtoColor? = null,
    override val fgClr: StudioDtoColor? = null,
    override val label: String? = null,
    @Serializable(with = SymbolSer::class) override val name: Symbol? = null,
    override val point: Point? = null,
    override val size: Size? = null,
    override val textClr: StudioDtoColor? = null,
    @Serializable(with = MetaIdVdRegionSer::class) override val metaId: Types.MetaIdVdRegion
) : EntVdRegion
