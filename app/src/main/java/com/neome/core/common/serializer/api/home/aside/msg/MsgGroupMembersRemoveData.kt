package com.neome.core.common.serializer.api.home.aside.msg

import com.neome.api.core.base.msg.MsgVersion
import com.neome.api.home.aside.msg.MsgGroupMembersRemove
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.sysId.EntUserIdSer
import com.neome.core.common.serializer.sysId.GroupIdSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgGroupMembersRemoveData(
    override val version: String? = null,
    @Serializable(with = GroupIdSer::class) override val groupId: Types.GroupId,
    override val removeAdminSet: List<@Serializable(with = EntUserIdSer::class) Types.EntUserId>? = null,
    override val removeMemberSet: List<@Serializable(with = EntUserIdSer::class) Types.EntUserId>? = null
) : MsgGroupMembersRemove
