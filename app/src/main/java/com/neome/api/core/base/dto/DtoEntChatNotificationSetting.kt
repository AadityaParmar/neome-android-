// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.base.dto

import com.neome.api.meta.base.Types.ChatId
import com.neome.api.meta.base.dto.GsonCto

class DtoEntChatNotificationSetting : GsonCto() {
    var entNotificationSetting: DtoNotificationSetting? = null
    var map: Record<ChatId, DtoNotificationSetting>? = null
}
