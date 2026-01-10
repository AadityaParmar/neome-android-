package com.neome.core.common.serializer.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoEntActionPermission
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.Types.EnumDefnDeviceSize
import com.neome.core.common.serializer.sysId.MetaIdActionSer
import kotlinx.serialization.Serializable


@Serializable
data class DtoEntActionPermissionData(
    @Serializable(with = MetaIdActionSer::class) override val actionId: Types.MetaIdAction,
    override val deviceSizeSet: List<EnumDefnDeviceSize>? = null,
    override val hidden: Boolean? = null,
    override val menuGroup: String? = null
) : DtoEntActionPermission
