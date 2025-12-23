// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.base.dto

import com.neome.api.meta.base.Types.ChatId
import com.neome.api.core.base.dto.DtoNotificationSetting
import com.neome.api.meta.base.dto.GsonCto
import java.util.Map

open class DtoEntChatNotificationSetting : GsonCto()
{
  var entNotificationSetting: DtoNotificationSetting? = null
  var map: Map<ChatId, DtoNotificationSetting>? = null
}