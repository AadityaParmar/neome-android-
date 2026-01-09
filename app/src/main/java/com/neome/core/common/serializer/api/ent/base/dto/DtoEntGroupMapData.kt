package com.neome.core.common.serializer.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoEntGroup
import com.neome.api.ent.base.dto.DtoEntGroupMap
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.sysId.GroupIdSer
import kotlinx.serialization.Serializable


@Serializable
data class DtoEntGroupMapData(
    override val entGroupMap: Map<@Serializable(with = GroupIdSer::class) Types.GroupId, DtoEntGroup>
) : DtoEntGroupMap
