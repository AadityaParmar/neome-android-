package com.neome.core.common.serializer.api.ent.base.dto

import com.neome.api.ent.base.dto.DtoEntUserAvatar
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.sysId.EntUserIdSer
import com.neome.core.common.serializer.sysId.MediaIdSer
import kotlinx.serialization.Serializable


@Serializable
data class DtoEntUserAvatarData(
    @Serializable(with = MediaIdSer::class) override val avatarId: Types.MediaId? = null,
    @Serializable(with = EntUserIdSer::class) override val entUserId: Types.EntUserId,
    override val handle: String,
    override val nickName: String
) : DtoEntUserAvatar
