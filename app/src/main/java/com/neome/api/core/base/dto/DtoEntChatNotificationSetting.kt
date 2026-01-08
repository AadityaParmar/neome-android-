// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.base.dto

import com.neome.api.meta.base.Types.ChatId
import com.neome.api.core.base.dto.DtoNotificationSetting
import com.neome.api.meta.base.dto.GsonCto

interface DtoEntChatNotificationSetting : GsonCto
{
  val entNotificationSetting: DtoNotificationSetting?
  val map: Map<ChatId, DtoNotificationSetting>?
}