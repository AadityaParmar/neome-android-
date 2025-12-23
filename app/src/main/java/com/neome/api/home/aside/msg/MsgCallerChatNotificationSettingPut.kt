// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.aside.msg

import com.neome.api.meta.base.Types.ChatId
import com.neome.api.core.base.dto.DtoNotificationSetting
import com.neome.api.nucleus.base.msg.Msg

open class MsgCallerChatNotificationSettingPut : Msg()
{
  lateinit var chatId: ChatId
  var notificationSetting: DtoNotificationSetting? = null
}