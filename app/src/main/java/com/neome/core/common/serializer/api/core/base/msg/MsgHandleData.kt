package com.neome.core.common.serializer.api.core.base.msg

import com.neome.api.core.base.msg.MsgHandle
import com.neome.api.nucleus.base.msg.Msg
import kotlinx.serialization.Serializable


@Serializable
data class MsgHandleData(
    override val handle: String
) : MsgHandle
