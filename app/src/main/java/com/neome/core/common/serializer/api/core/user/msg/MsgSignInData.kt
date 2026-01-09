package com.neome.core.common.serializer.api.core.user.msg

import com.neome.api.core.base.msg.MsgHandle
import com.neome.api.core.user.msg.MsgSignIn
import com.neome.api.meta.base.Types.EnumDeviceType
import kotlinx.serialization.Serializable


@Serializable
data class MsgSignInData(
    override val handle: String,
    override val deviceName: String,
    override val deviceType: EnumDeviceType,
    override val password: String,
    override val rememberMe: Boolean
) : MsgSignIn
