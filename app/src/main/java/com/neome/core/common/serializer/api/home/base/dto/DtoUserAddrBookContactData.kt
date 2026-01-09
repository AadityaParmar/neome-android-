package com.neome.core.common.serializer.api.home.base.dto

import com.neome.api.home.base.dto.DtoUserAddrBookContact
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.sysId.EntUserIdSer
import com.neome.core.common.serializer.sysId.MediaIdAvatarSer
import kotlinx.serialization.Serializable


@Serializable
data class DtoUserAddrBookContactData(
    @Serializable(with = EntUserIdSer::class) override val entUserId: Types.EntUserId,
    override val handle: String,
    @Serializable(with = MediaIdAvatarSer::class) override val mediaIdAvatar: Types.MediaIdAvatar? = null,
    override val nickName: String
) : DtoUserAddrBookContact
