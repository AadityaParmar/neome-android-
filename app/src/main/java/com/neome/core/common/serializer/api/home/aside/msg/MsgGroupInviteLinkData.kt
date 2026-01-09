package com.neome.core.common.serializer.api.home.aside.msg

import com.neome.api.home.aside.msg.MsgGroupInviteLink
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.sysId.GroupIdSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgGroupInviteLinkData(
    @Serializable(with = GroupIdSer::class) override val groupId: Types.GroupId,
    override val reset: Boolean? = null
) : MsgGroupInviteLink
