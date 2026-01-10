package com.neome.core.common.serializer.api.meta.base.dto

import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioDtoActionPermission
import com.neome.api.meta.base.dto.StudioMapOfActionPermission
import com.neome.core.common.serializer.api.meta.base.dto.StudioDtoActionPermissionData
import com.neome.core.common.serializer.sysId.MetaIdActionSer
import kotlinx.serialization.Serializable


@Serializable
data class StudioMapOfActionPermissionData(
    override val keys: List<@Serializable(with = MetaIdActionSer::class) Types.MetaIdAction>,
    override val map: Map<@Serializable(with = MetaIdActionSer::class) Types.MetaIdAction, StudioDtoActionPermissionData>
) : StudioMapOfActionPermission
