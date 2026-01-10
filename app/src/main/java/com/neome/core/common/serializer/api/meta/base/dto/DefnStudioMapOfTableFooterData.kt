package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.DefnDtoTableFooter
import com.neome.api.meta.base.dto.DefnStudioMapOfTableFooter
import com.neome.core.common.serializer.api.meta.base.dto.DefnDtoTableFooterData
import com.neome.core.common.serializer.sysId.MetaIdFooterSer
import kotlinx.serialization.Serializable


@Serializable
data class DefnStudioMapOfTableFooterData(
    override val keys: List<@Serializable(with = MetaIdFooterSer::class) Types.MetaIdFooter>,
    override val map: Map<@Serializable(with = MetaIdFooterSer::class) Types.MetaIdFooter, DefnDtoTableFooterData>
) : DefnStudioMapOfTableFooter
