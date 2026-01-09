package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.DefnDtoTableHeader
import com.neome.api.meta.base.dto.DefnStudioMapOfTableHeader
import com.neome.core.common.serializer.sysId.MetaIdHeaderSer
import kotlinx.serialization.Serializable


@Serializable
data class DefnStudioMapOfTableHeaderData(
    override val keys: Array<@Serializable(with = MetaIdHeaderSer::class) Types.MetaIdHeader>,
    override val map: Map<@Serializable(with = MetaIdHeaderSer::class) Types.MetaIdHeader, DefnDtoTableHeader>
) : DefnStudioMapOfTableHeader
