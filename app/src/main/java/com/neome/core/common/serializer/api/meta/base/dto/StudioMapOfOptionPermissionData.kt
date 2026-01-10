package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoOptionPermission
import com.neome.api.meta.base.dto.StudioMapOfOptionPermission
import com.neome.core.common.serializer.api.meta.base.dto.StudioDtoOptionPermissionData
import com.neome.core.common.serializer.sysId.MetaIdRoleSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioMapOfOptionPermissionData(
    override val keys: List<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>,
    override val map: Map<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole, StudioDtoOptionPermissionData>
) : StudioMapOfOptionPermission
