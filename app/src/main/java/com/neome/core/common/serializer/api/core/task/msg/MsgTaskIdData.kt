package com.neome.core.common.serializer.api.core.task.msg

import com.neome.api.core.task.msg.MsgTaskId
import com.neome.api.nucleus.base.msg.Msg
import kotlinx.serialization.Serializable


@Serializable
data class MsgTaskIdData(
    override val taskId: String
) : MsgTaskId
