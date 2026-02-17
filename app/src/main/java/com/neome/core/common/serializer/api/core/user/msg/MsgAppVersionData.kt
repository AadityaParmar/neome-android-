package com.neome.core.common.serializer.api.core.user.msg

import com.neome.api.core.user.msg.MsgAppVersion
import com.neome.api.meta.base.Types.EnumDeviceType
import com.neome.api.nucleus.base.msg.Msg
import kotlinx.serialization.Serializable


@Serializable
data class MsgAppVersionData(
    override val deviceType: EnumDeviceType,
    override val versionCode: Long
) : MsgAppVersion
