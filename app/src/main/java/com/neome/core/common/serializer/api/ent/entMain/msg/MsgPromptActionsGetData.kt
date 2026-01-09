package com.neome.core.common.serializer.api.ent.entMain.msg

import com.neome.api.ent.entMain.msg.MsgPromptActionsGet
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.sysId.GroupIdSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgPromptActionsGetData(
    @Serializable(with = GroupIdSer::class) override val groupId: Types.GroupId,
    override val promptText: String
) : MsgPromptActionsGet
