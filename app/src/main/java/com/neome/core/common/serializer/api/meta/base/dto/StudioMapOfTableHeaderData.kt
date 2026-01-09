package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoTableHeader
import com.neome.api.meta.base.dto.StudioMapOfTableHeader
import com.neome.core.common.serializer.sysId.MetaIdHeaderSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioMapOfTableHeaderData(
    override val keys: Array<@Serializable(with = MetaIdHeaderSer::class) Types.MetaIdHeader>,
    override val map: Map<@Serializable(with = MetaIdHeaderSer::class) Types.MetaIdHeader, StudioDtoTableHeader>
) : StudioMapOfTableHeader
