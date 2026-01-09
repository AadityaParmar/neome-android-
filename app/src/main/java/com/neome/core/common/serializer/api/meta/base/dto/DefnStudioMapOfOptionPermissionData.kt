package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.DefnStudioDtoOptionPermission
import com.neome.api.meta.base.dto.DefnStudioMapOfOptionPermission
import com.neome.core.common.serializer.sysId.MetaIdRoleSer
import kotlinx.serialization.Serializable


@Serializable
data class DefnStudioMapOfOptionPermissionData(
    override val keys: Array<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>,
    override val map: Map<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole, DefnStudioDtoOptionPermission>
) : DefnStudioMapOfOptionPermission
