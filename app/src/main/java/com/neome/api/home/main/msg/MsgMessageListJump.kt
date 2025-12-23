// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.main.msg

import com.neome.api.meta.base.Types.MessageId
import com.neome.api.home.main.msg.MsgMessageList

open class MsgMessageListJump : MsgMessageList()
{
  var messageId: MessageId? = null
  var offset: Number? = null
}