package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnShowBorderKind
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoLayoutGrid
import com.neome.api.meta.base.dto.StudioDtoPlaceHolder
import com.neome.api.meta.base.dto.StudioMapOfLayoutGrid
import com.neome.core.common.serializer.sysId.MetaIdLayoutGridSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioMapOfLayoutGridData(
    @Serializable(with = MetaIdLayoutGridSer::class) override val asideDefaultLayoutId: Types.MetaIdLayoutGrid? = null,
    override val keys: Array<@Serializable(with = MetaIdLayoutGridSer::class) Types.MetaIdLayoutGrid>,
    override val map: Map<@Serializable(with = MetaIdLayoutGridSer::class) Types.MetaIdLayoutGrid, StudioDtoLayoutGrid>,
    override val placeholder: StudioDtoPlaceHolder? = null,
    override val showBorderSet: Array<EnumDefnShowBorderKind>? = null
) : StudioMapOfLayoutGrid
