package com.neome.core.common.serializer.api.ent.agent.msg

import com.neome.api.core.base.msg.MsgVersion
import com.neome.api.ent.agent.msg.MsgAgentEntGet
import kotlinx.serialization.Serializable


@Serializable
data class MsgAgentEntGetData(
    override val version: String? = null,
    override val appVersionCode: Long? = null
) : MsgAgentEntGet
