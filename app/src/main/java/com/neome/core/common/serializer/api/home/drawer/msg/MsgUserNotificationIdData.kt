package com.neome.core.common.serializer.api.home.drawer.msg

import com.neome.api.home.drawer.msg.MsgUserNotificationId
import com.neome.api.nucleus.base.msg.Msg
import kotlinx.serialization.Serializable


@Serializable
data class MsgUserNotificationIdData(
    override val notificationId: String? = null
) : MsgUserNotificationId
