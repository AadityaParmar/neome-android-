package com.neome.core.common.serializer.api.home.drawer.sig

import com.neome.api.home.base.dto.DtoUserNotification
import com.neome.api.home.drawer.sig.SigUserNotificationList
import com.neome.api.nucleus.base.sig.SigVersion
import com.neome.core.common.serializer.api.home.base.dto.DtoUserNotificationData
import kotlinx.serialization.Serializable


@Serializable
data class SigUserNotificationListData(
    override val version: String,
    override val notificationList: List<DtoUserNotificationData>
) : SigUserNotificationList
