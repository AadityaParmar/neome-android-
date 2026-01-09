package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.DefnStudioDtoActionPermission
import com.neome.api.meta.base.dto.DefnStudioMapOfActionPermission
import com.neome.core.common.serializer.sysId.MetaIdActionSer
import kotlinx.serialization.Serializable


@Serializable
data class DefnStudioMapOfActionPermissionData(
    override val keys: Array<@Serializable(with = MetaIdActionSer::class) Types.MetaIdAction>,
    override val map: Map<@Serializable(with = MetaIdActionSer::class) Types.MetaIdAction, DefnStudioDtoActionPermission>
) : DefnStudioMapOfActionPermission
