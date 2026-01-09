package com.neome.core.common.serializer.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoEntUserInfo
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.sysId.EntUserIdSer
import com.neome.core.common.serializer.sysId.MediaIdSer
import com.neome.core.common.serializer.sysId.MetaIdRoleSer
import kotlinx.serialization.Serializable


@Serializable
data class DtoEntUserInfoData(
    @Serializable(with = MediaIdSer::class) override val avatarId: Types.MediaId? = null,
    @Serializable(with = EntUserIdSer::class) override val entUserId: Types.EntUserId,
    override val handle: String? = null,
    @Serializable(with = EntUserIdSer::class) override val managerId: Types.EntUserId? = null,
    override val nickName: String,
    override val roleIdSet: Array<@Serializable(with = MetaIdRoleSer::class) Types.MetaIdRole>? = null,
    override val userColor: String
) : DtoEntUserInfo
