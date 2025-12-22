// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.main.msg

import com.neome.api.meta.base.Types.ChatId
import com.neome.api.meta.base.Types.EntId
import com.neome.api.meta.base.Types.MessageId
import com.neome.api.nucleus.base.msg.Msg

class MsgMessageReport : Msg() {
    val chatId: ChatId
    val entId: EntId
    val messageId: MessageId
    val offset: number
}
