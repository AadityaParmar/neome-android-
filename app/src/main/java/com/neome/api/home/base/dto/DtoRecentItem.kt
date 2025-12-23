// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import com.neome.api.meta.base.Types.ChatId
import com.neome.api.meta.base.Types.EntId

open class DtoRecentItem {
    lateinit var chatId: ChatId
    lateinit var entId: EntId
    var isPinned: Boolean? = null
}
