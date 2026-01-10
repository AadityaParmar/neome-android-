package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.DefnStudioDtoActionPermission
import com.neome.api.meta.base.dto.DefnStudioMapOfActionPermission
import com.neome.core.common.serializer.api.meta.base.dto.DefnStudioDtoActionPermissionData
import com.neome.core.common.serializer.sysId.MetaIdActionSer
import kotlinx.serialization.Serializable


@Serializable
data class DefnStudioMapOfActionPermissionData(
    override val keys: List<@Serializable(with = MetaIdActionSer::class) Types.MetaIdAction>,
    override val map: Map<@Serializable(with = MetaIdActionSer::class) Types.MetaIdAction, DefnStudioDtoActionPermissionData>
) : DefnStudioMapOfActionPermission
