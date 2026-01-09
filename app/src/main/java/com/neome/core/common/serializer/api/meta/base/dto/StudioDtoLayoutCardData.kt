package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnGridRenderingMode
import com.neome.api.meta.base.Types.EnumDefnLayoutGridKind
import com.neome.api.meta.base.dto.StudioDtoLayoutCard
import com.neome.api.meta.base.dto.StudioDtoLayoutCardFilter
import com.neome.api.meta.base.dto.StudioDtoLayoutCardItem
import com.neome.api.meta.base.dto.StudioDtoLayoutGrid
import com.neome.core.common.serializer.sysId.MetaIdFieldSer
import com.neome.core.common.serializer.sysId.MetaIdLayoutGridSer
import com.neome.core.common.serializer.sysId.SymbolSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioDtoLayoutCardData(
    override val allowToSwitchLayoutIdSet: Array<@Serializable(with = MetaIdLayoutGridSer::class) Types.MetaIdLayoutGrid>? = null,
    @Serializable(with = MetaIdFieldSer::class) override val bgColorFieldId: Types.MetaIdField? = null,
    override val description: String? = null,
    override val kind: EnumDefnLayoutGridKind,
    override val label: String? = null,
    @Serializable(with = MetaIdLayoutGridSer::class) override val metaId: Types.MetaIdLayoutGrid,
    @Serializable(with = SymbolSer::class) override val name: Symbol,
    @Serializable(with = MetaIdFieldSer::class) override val toolTipFieldId: Types.MetaIdField? = null,
    override val filter: StudioDtoLayoutCardFilter? = null,
    @Serializable(with = MetaIdFieldSer::class) override val groupByFieldId: Types.MetaIdField? = null,
    override val hideBorders: Boolean? = null,
    override val item: StudioDtoLayoutCardItem? = null,
    override val numOfColumns: Long? = null,
    override val renderingMode: EnumDefnGridRenderingMode? = null,
    override val showSearchBar: Boolean? = null
) : StudioDtoLayoutCard
