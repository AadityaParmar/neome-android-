package com.neome.core.common.serializer.api.home.drawer.msg

import com.neome.api.home.drawer.msg.MsgCallerPasswordReset
import com.neome.api.nucleus.base.msg.Msg
import kotlinx.serialization.Serializable


@Serializable
data class MsgCallerPasswordResetData(
    override val newPassword: String
) : MsgCallerPasswordReset
