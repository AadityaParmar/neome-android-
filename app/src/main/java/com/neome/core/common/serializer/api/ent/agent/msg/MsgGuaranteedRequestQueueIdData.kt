package com.neome.core.common.serializer.api.ent.agent.msg

import com.neome.api.ent.agent.msg.MsgGuaranteedRequestQueueId
import com.neome.api.nucleus.base.msg.Msg
import kotlinx.serialization.Serializable


@Serializable
data class MsgGuaranteedRequestQueueIdData(
    override val pageSize: Long? = null,
    override val queueId: String,
    override val startOffset: Long? = null
) : MsgGuaranteedRequestQueueId
