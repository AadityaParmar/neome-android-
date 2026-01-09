package com.neome.core.common.serializer.api.core.base.dto

import com.neome.api.core.base.dto.DtoEntChatNotificationSetting
import com.neome.api.core.base.dto.DtoNotificationSetting
import com.neome.api.meta.base.Types
import com.neome.api.meta.base.dto.GsonCto
import com.neome.core.common.serializer.sysId.ChatIdSer
import kotlinx.serialization.Serializable


@Serializable
data class DtoEntChatNotificationSettingData(
    override val entNotificationSetting: DtoNotificationSetting? = null,
    override val map: Map<@Serializable(with = ChatIdSer::class) Types.ChatId, DtoNotificationSetting>? = null
) : DtoEntChatNotificationSetting
