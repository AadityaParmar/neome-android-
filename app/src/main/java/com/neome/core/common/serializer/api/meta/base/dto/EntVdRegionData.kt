package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.EntVdRect
import com.neome.api.meta.base.dto.EntVdRegion
import com.neome.api.meta.base.dto.Point
import com.neome.api.meta.base.dto.Size
import com.neome.api.meta.base.dto.StudioDtoColor
import com.neome.core.common.serializer.api.meta.base.dto.PointData
import com.neome.core.common.serializer.api.meta.base.dto.SizeData
import com.neome.core.common.serializer.api.meta.base.dto.StudioDtoColorData
import com.neome.core.common.serializer.sysId.MetaIdVdRegionSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class EntVdRegionData(
    override val bgClr: StudioDtoColorData? = null,
    override val borderClr: StudioDtoColorData? = null,
    override val fgClr: StudioDtoColorData? = null,
    override val label: String? = null,
    @Serializable(with = SymbolSer::class) override val name: Symbol? = null,
    override val point: PointData? = null,
    override val size: SizeData? = null,
    override val textClr: StudioDtoColorData? = null,
    @Serializable(with = MetaIdVdRegionSer::class) override val metaId: Types.MetaIdVdRegion
) : EntVdRegion
