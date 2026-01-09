package com.neome.core.common.serializer.api.home.drawer.msg

import com.neome.api.home.drawer.msg.MsgCallerDeviceState
import com.neome.api.nucleus.base.msg.Msg
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement


@Serializable
data class MsgCallerDeviceStateData(
    override val state: JsonElement
) : MsgCallerDeviceState
