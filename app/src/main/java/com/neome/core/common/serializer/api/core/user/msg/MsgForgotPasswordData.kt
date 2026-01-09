package com.neome.core.common.serializer.api.core.user.msg

import com.neome.api.core.base.msg.MsgHandle
import com.neome.api.core.user.msg.MsgForgotPassword
import kotlinx.serialization.Serializable


@Serializable
data class MsgForgotPasswordData(
    override val handle: String,
    override val newPassword: String
) : MsgForgotPassword
