package com.neome.core.common.serializer.api.home.drawer.msg

import com.neome.api.core.base.msg.MsgHandle
import com.neome.api.home.drawer.msg.MsgCallerHandleChange
import kotlinx.serialization.Serializable


@Serializable
data class MsgCallerHandleChangeData(
    override val handle: String
) : MsgCallerHandleChange
