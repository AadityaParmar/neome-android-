package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnPermission
import com.neome.api.meta.base.dto.DefnDtoPermissionMatrix
import com.neome.core.common.serializer.sysId.MetaIdRoleSer
import kotlinx.serialization.Serializable


@Serializable
data class DefnDtoPermissionMatrixData(
    override val defaultPermission: EnumDefnPermission? = null,
    override val keys: Array<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null,
    override val map: Map<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole, EnumDefnPermission>? = null
) : DefnDtoPermissionMatrix
