package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnKindNoteStatus
import com.neome.api.meta.base.Types.EnumDefnTextSize
import com.neome.api.meta.base.dto.EntVdNote
import com.neome.api.meta.base.dto.EntVdRect
import com.neome.api.meta.base.dto.Point
import com.neome.api.meta.base.dto.Size
import com.neome.api.meta.base.dto.StudioDtoColor
import com.neome.core.common.serializer.sysId.AdminIdSer
import com.neome.core.common.serializer.sysId.MetaIdVdNoteSer
import com.neome.core.common.serializer.sysId.MetaIdVdRegionSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class EntVdNoteData(
    override val bgClr: StudioDtoColor? = null,
    override val borderClr: StudioDtoColor? = null,
    override val fgClr: StudioDtoColor? = null,
    override val label: String? = null,
    @Serializable(with = SymbolSer::class) override val name: Symbol? = null,
    override val point: Point? = null,
    override val size: Size? = null,
    override val textClr: StudioDtoColor? = null,
    @Serializable(with = AdminIdSer::class) override val adminId: Types.AdminId? = null,
    @Serializable(with = MetaIdVdNoteSer::class) override val metaId: Types.MetaIdVdNote,
    @Serializable(with = MetaIdVdRegionSer::class) override val parentRegionId: Types.MetaIdVdRegion? = null,
    override val status: EnumDefnKindNoteStatus? = null,
    override val textSize: EnumDefnTextSize? = null,
    override val value: String? = null
) : EntVdNote
