package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnShowBorderKind
import com.neome.api.meta.base.dto.DefnDtoPlaceholder
import com.neome.api.meta.base.dto.DefnLayoutGrid
import com.neome.api.meta.base.dto.DefnLayoutGridMap
import com.neome.core.common.serializer.sysId.MetaIdLayoutGridSer
import kotlinx.serialization.Serializable


@Serializable
data class DefnLayoutGridMapData(
    @Serializable(with = MetaIdLayoutGridSer::class) override val asideDefaultLayoutId: Types.MetaIdLayoutGrid? = null,
    override val keys: Array<@Serializable(with = MetaIdLayoutGridSer::class) Types.MetaIdLayoutGrid>,
    override val map: Map<@Serializable(with = MetaIdLayoutGridSer::class) Types.MetaIdLayoutGrid, DefnLayoutGrid>,
    override val placeholder: DefnDtoPlaceholder? = null,
    override val showBorderSet: Array<EnumDefnShowBorderKind>? = null
) : DefnLayoutGridMap
