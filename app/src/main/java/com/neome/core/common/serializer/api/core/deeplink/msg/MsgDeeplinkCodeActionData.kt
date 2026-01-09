package com.neome.core.common.serializer.api.core.deeplink.msg

import com.neome.api.core.deeplink.msg.MsgDeeplinkCode
import com.neome.api.core.deeplink.msg.MsgDeeplinkCodeAction
import com.neome.api.meta.base.Types.EnumDeviceType
import com.neome.api.meta.base.dto.FormValueRaw
import kotlinx.serialization.Serializable


@Serializable
data class MsgDeeplinkCodeActionData(
    override val deeplinkCode: String,
    override val deviceName: String? = null,
    override val deviceType: EnumDeviceType? = null,
    override val formValueRaw: FormValueRaw? = null
) : MsgDeeplinkCodeAction
