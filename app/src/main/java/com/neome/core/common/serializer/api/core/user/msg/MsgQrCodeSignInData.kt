package com.neome.core.common.serializer.api.core.user.msg

import com.neome.api.core.user.msg.MsgQrCodeSignIn
import com.neome.api.meta.base.Types.EnumDeviceType
import com.neome.api.nucleus.base.msg.Msg
import kotlinx.serialization.Serializable


@Serializable
data class MsgQrCodeSignInData(
    override val deviceName: String,
    override val deviceType: EnumDeviceType,
    override val rememberMe: Boolean? = null
) : MsgQrCodeSignIn
