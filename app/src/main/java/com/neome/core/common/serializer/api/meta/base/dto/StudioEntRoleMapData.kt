package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEntRole
import com.neome.api.meta.base.dto.StudioEntRoleMap
import com.neome.core.common.serializer.api.meta.base.dto.StudioEntRoleData
import com.neome.core.common.serializer.sysId.MetaIdRoleSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioEntRoleMapData(
    override val keys: List<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>,
    override val map: Map<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole, StudioEntRoleData>
) : StudioEntRoleMap
