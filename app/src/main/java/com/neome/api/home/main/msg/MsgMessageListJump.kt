// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.main.msg

import com.neome.api.meta.base.Types.MessageId

class MsgMessageListJump : MsgMessageList() {
    var messageId: MessageId? = null
    var offset: number? = null
}
