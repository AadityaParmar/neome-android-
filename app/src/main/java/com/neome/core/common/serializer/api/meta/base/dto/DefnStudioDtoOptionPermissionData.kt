package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.DefnStudioDtoOptionPermission
import com.neome.core.common.serializer.sysId.MetaIdRoleSer
import kotlinx.serialization.Serializable


@Serializable
data class DefnStudioDtoOptionPermissionData(
    @Serializable(with = MetaIdRoleSer::class) override val metaId: Types.MetaIdRole,
    override val optionIdSet: List<String>
) : DefnStudioDtoOptionPermission
