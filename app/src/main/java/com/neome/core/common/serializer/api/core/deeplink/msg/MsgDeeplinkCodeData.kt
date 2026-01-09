package com.neome.core.common.serializer.api.core.deeplink.msg

import com.neome.api.core.deeplink.msg.MsgDeeplinkCode
import com.neome.api.meta.base.Types.EnumDeviceType
import com.neome.api.nucleus.base.msg.Msg
import kotlinx.serialization.Serializable


@Serializable
data class MsgDeeplinkCodeData(
    override val deeplinkCode: String,
    override val deviceName: String? = null,
    override val deviceType: EnumDeviceType? = null
) : MsgDeeplinkCode
