// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.main.msg

import com.neome.api.core.base.msg.MsgVersion
import com.neome.api.meta.base.Types.ChatId

class MsgOffsetWithVersion : MsgVersion() {
    val chatId: ChatId
    val offset: number
}
