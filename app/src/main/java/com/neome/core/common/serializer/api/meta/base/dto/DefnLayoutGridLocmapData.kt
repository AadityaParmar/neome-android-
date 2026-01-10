package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnLayoutGridKind
import com.neome.api.meta.base.Types.EnumDefnMapRenderingMode
import com.neome.api.meta.base.dto.DefnDtoLayoutLocmapLineStroke
import com.neome.api.meta.base.dto.DefnDtoLayoutLocmapPin
import com.neome.api.meta.base.dto.DefnLayoutGrid
import com.neome.api.meta.base.dto.DefnLayoutGridLocmap
import com.neome.core.common.serializer.api.meta.base.dto.DefnDtoLayoutLocmapLineStrokeData
import com.neome.core.common.serializer.api.meta.base.dto.DefnDtoLayoutLocmapPinData
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdLayoutGridSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class DefnLayoutGridLocmapData(
    override val allowToSwitchLayoutIdSet: List<@Serializable(with = MetaIdLayoutGridSer::class) Types.MetaIdLayoutGrid>? = null,
    @Serializable(with = MetaIdFieldSer::class) override val bgColorFieldId: Types.MetaIdField? = null,
    override val description: String? = null,
    override val kind: EnumDefnLayoutGridKind,
    override val label: String? = null,
    @Serializable(with = MetaIdLayoutGridSer::class) override val metaId: Types.MetaIdLayoutGrid,
    @Serializable(with = SymbolSer::class) override val name: Symbol,
    @Serializable(with = MetaIdFieldSer::class) override val toolTipFieldId: Types.MetaIdField? = null,
    override val lineStroke: DefnDtoLayoutLocmapLineStrokeData? = null,
    override val liveLocationPin: DefnDtoLayoutLocmapPinData? = null,
    @Serializable(with = MetaIdFieldSer::class) override val locationFieldId: Types.MetaIdField? = null,
    override val mapPin: DefnDtoLayoutLocmapPinData? = null,
    override val renderingMode: EnumDefnMapRenderingMode? = null
) : DefnLayoutGridLocmap
