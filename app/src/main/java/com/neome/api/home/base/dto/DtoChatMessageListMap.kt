// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import com.neome.api.home.main.sig.SigMessage
import com.neome.api.meta.base.Types.ChatId

class DtoChatMessageListMap {
    var chatMessageListMap: Record<ChatId, SigMessage[]>? = null
}
