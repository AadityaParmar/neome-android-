package com.neome.core.common.serializer.api.ent.agent.msg

import com.neome.api.ent.agent.msg.MsgAgentActiveStatusUpdate
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.sysId.EntIdSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgAgentActiveStatusUpdateData(
    override val active: Boolean,
    @Serializable(with = EntIdSer::class) override val entId: Types.EntId
) : MsgAgentActiveStatusUpdate
