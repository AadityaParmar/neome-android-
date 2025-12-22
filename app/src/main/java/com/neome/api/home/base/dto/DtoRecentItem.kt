// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import com.neome.api.meta.base.Types.ChatId
import com.neome.api.meta.base.Types.EntId

class DtoRecentItem {
    val chatId: ChatId
    val entId: EntId
    var isPinned: boolean? = null
}
