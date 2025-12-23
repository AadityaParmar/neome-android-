// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import com.neome.api.home.main.sig.SigMessage
import com.neome.api.meta.base.Types.ChatId
import java.util.Map

open class DtoChatMessageListMap {
    var chatMessageListMap: Map<ChatId, Array<SigMessage>>? = null
}
