package com.neome.core.common.serializer.api.home.drawer.msg

import com.neome.api.home.drawer.msg.MsgGroupCandidateListGet
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.sysId.GroupIdSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgGroupCandidateListGetData(
    @Serializable(with = GroupIdSer::class) override val groupId: Types.GroupId? = null
) : MsgGroupCandidateListGet
