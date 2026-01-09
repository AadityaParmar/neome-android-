package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnPermission
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoPermissionMatrix
import com.neome.core.common.serializer.sysId.MetaIdRoleSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioDtoPermissionMatrixData(
    override val defaultPermission: EnumDefnPermission? = null,
    override val keys: Array<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>,
    override val map: Map<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole, EnumDefnPermission>
) : StudioDtoPermissionMatrix
