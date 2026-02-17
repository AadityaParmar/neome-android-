package com.neome.core.common.serializer.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoAgentEntUser
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.sysId.EntUserIdSer
import com.neome.core.common.serializer.sysId.MetaIdRoleSer
import kotlinx.serialization.Serializable


@Serializable
data class DtoAgentEntUserData(
    @Serializable(with = EntUserIdSer::class) override val entUserId: Types.EntUserId,
    override val handle: String,
    override val nickName: String,
    override val roleIdSet: Set<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null,
    override val userColor: String
) : DtoAgentEntUser
