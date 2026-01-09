package com.neome.core.common.serializer.api.core.user.msg

import com.neome.api.core.base.msg.MsgVersion
import com.neome.api.core.user.msg.MsgCallerSettingPut
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement


@Serializable
data class MsgCallerSettingPutData(
    override val version: String? = null,
    override val userSetting: JsonElement
) : MsgCallerSettingPut
