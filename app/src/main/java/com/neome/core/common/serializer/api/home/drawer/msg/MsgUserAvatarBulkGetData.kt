package com.neome.core.common.serializer.api.home.drawer.msg

import com.neome.api.home.drawer.msg.MsgUserAvatarBulkGet
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.sysId.EntUserIdSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgUserAvatarBulkGetData(
    override val userIdVersionMap: Map<@Serializable(with = EntUserIdSer::class) Types.EntUserId, String>
) : MsgUserAvatarBulkGet
