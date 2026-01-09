package com.neome.core.common.serializer.api.home.base.dto

import com.neome.api.home.base.dto.DtoGroupMemberKey
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.sysId.EntUserIdSer
import kotlinx.serialization.Serializable


@Serializable
data class DtoGroupMemberKeyData(
    @Serializable(with = EntUserIdSer::class) override val entUserId: Types.EntUserId,
    override val handle: String,
    override val name: String
) : DtoGroupMemberKey
