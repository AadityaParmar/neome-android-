package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEntGroup
import com.neome.api.meta.base.dto.StudioEntGroupMap
import com.neome.core.common.serializer.api.meta.base.dto.StudioEntGroupData
import com.neome.core.common.serializer.sysId.MetaIdGroupSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioEntGroupMapData(
    override val keys: List<@Serializable(with = MetaIdGroupSer::class) Types.MetaIdGroup>,
    override val map: Map<@Serializable(with = MetaIdGroupSer::class) Types.MetaIdGroup, StudioEntGroupData>
) : StudioEntGroupMap
