package com.neome.core.common.serializer.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoAgentAdmin
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.sysId.AdminIdSer
import kotlinx.serialization.Serializable


@Serializable
data class DtoAgentAdminData(
    @Serializable(with = AdminIdSer::class) override val adminId: Types.AdminId,
    override val handle: String,
    override val nickName: String
) : DtoAgentAdmin
