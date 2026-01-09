package com.neome.core.common.serializer.api.core.user.msg

import com.neome.api.core.user.msg.MsgFCMToken
import com.neome.api.nucleus.base.msg.Msg
import kotlinx.serialization.Serializable


@Serializable
data class MsgFCMTokenData(
    override val fcmToken: String
) : MsgFCMToken
