package com.neome.core.common.serializer.api.home.aside.msg

import com.neome.api.core.base.dto.DtoNotificationSetting
import com.neome.api.home.aside.msg.MsgCallerChatNotificationSettingPut
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.api.core.base.dto.DtoNotificationSettingData
import com.neome.core.common.serializer.sysId.ChatIdSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgCallerChatNotificationSettingPutData(
    @Serializable(with = ChatIdSer::class) override val chatId: Types.ChatId,
    override val notificationSetting: DtoNotificationSettingData? = null
) : MsgCallerChatNotificationSettingPut
