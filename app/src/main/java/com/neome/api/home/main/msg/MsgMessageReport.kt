// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.main.msg

import com.neome.api.meta.base.Types.ChatId
import com.neome.api.meta.base.Types.EntId
import com.neome.api.meta.base.Types.MessageId
import com.neome.api.nucleus.base.msg.Msg
import kotlin.properties.Delegates

open class MsgMessageReport : Msg() {
    lateinit var chatId: ChatId
    lateinit var entId: EntId
    lateinit var messageId: MessageId
    var offset: Number by Delegates.notNull<Number>()
}
