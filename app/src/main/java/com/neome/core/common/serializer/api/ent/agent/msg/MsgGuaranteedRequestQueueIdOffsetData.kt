package com.neome.core.common.serializer.api.ent.agent.msg

import com.neome.api.ent.agent.msg.MsgGuaranteedRequestQueueIdOffset
import com.neome.api.nucleus.base.msg.Msg
import kotlinx.serialization.Serializable


@Serializable
data class MsgGuaranteedRequestQueueIdOffsetData(
    override val offset: Long? = null,
    override val queueId: String
) : MsgGuaranteedRequestQueueIdOffset
