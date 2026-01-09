package com.neome.core.common.serializer.api.home.drawer.sig

import com.neome.api.home.drawer.sig.SigUserAvatar
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.sig.SigVersion
import com.neome.core.common.serializer.sysId.EntIdSer
import com.neome.core.common.serializer.sysId.EntUserIdSer
import com.neome.core.common.serializer.sysId.MediaIdSer
import kotlinx.serialization.Serializable


@Serializable
data class SigUserAvatarData(
    override val version: String,
    override val about: String? = null,
    @Serializable(with = MediaIdSer::class) override val avatarId: Types.MediaId? = null,
    @Serializable(with = EntIdSer::class) override val entId: Types.EntId,
    @Serializable(with = EntUserIdSer::class) override val entUserId: Types.EntUserId,
    override val firstName: String,
    override val handle: String? = null,
    override val isBlocked: Boolean? = null,
    override val isDeleted: Boolean? = null,
    override val lastName: String,
    override val nickName: String? = null,
    override val userColor: String
) : SigUserAvatar
