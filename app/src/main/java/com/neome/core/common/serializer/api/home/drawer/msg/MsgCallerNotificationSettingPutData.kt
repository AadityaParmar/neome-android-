package com.neome.core.common.serializer.api.home.drawer.msg

import com.neome.api.core.base.dto.DtoNotificationSetting
import com.neome.api.home.drawer.msg.MsgCallerNotificationSettingPut
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.api.core.base.dto.DtoNotificationSettingData
import kotlinx.serialization.Serializable


@Serializable
data class MsgCallerNotificationSettingPutData(
    override val notificationSetting: DtoNotificationSettingData
) : MsgCallerNotificationSettingPut
