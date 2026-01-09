package com.neome.core.common.serializer.api.home.drawer.msg

import com.neome.api.home.base.dto.DtoGroupSettings
import com.neome.api.home.drawer.msg.MsgGroupCreate
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.sysId.EntUserIdSer
import com.neome.core.common.serializer.sysId.MediaIdAvatarSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgGroupCreateData(
    override val about: String? = null,
    @Serializable(with = MediaIdAvatarSer::class) override val mediaIdAvatar: Types.MediaIdAvatar? = null,
    override val members: Array<@Serializable(with = EntUserIdSer::class) Types.EntUserId>,
    override val name: String,
    override val settings: DtoGroupSettings
) : MsgGroupCreate
