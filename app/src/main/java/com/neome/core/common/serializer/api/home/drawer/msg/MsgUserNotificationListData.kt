package com.neome.core.common.serializer.api.home.drawer.msg

import com.neome.api.core.base.msg.MsgVersion
import com.neome.api.home.drawer.msg.MsgUserNotificationList
import kotlinx.serialization.Serializable


@Serializable
data class MsgUserNotificationListData(
    override val version: String? = null,
    override val limit: Long? = null,
    override val offset: Long? = null
) : MsgUserNotificationList
