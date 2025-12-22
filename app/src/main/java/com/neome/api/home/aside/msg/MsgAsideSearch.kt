// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.aside.msg

import com.neome.api.meta.base.Types.ChatId
import com.neome.api.nucleus.base.msg.Msg

class MsgAsideSearch : Msg() {
    val chatId: ChatId
    var pageSize: number? = null
    val searchId: string
    val searchQuery: string
}
