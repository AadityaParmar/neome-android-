package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoTableFooter
import com.neome.api.meta.base.dto.StudioMapOfTableFooter
import com.neome.core.common.serializer.api.meta.base.dto.StudioDtoTableFooterData
import com.neome.core.common.serializer.sysId.MetaIdFooterSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioMapOfTableFooterData(
    override val keys: List<@Serializable(with = MetaIdFooterSer::class) Types.MetaIdFooter>,
    override val map: Map<@Serializable(with = MetaIdFooterSer::class) Types.MetaIdFooter, StudioDtoTableFooterData>
) : StudioMapOfTableFooter
