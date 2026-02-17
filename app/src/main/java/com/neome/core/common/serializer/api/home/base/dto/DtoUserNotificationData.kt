package com.neome.core.common.serializer.api.home.base.dto

import com.neome.api.core.base.dto.NotificationCustomData
import com.neome.api.home.base.dto.DtoUserNotification
import com.neome.api.meta.base.Types.EnumDefnKindNotification
import kotlinx.serialization.Serializable


@Serializable
data class DtoUserNotificationData(
    override val body: String,
    override val createdOn: String? = null,
    override val customData: NotificationCustomData? = null,
    override val id: String,
    override val isRead: Boolean? = null,
    override val kind: EnumDefnKindNotification? = null,
    override val title: String
) : DtoUserNotification
