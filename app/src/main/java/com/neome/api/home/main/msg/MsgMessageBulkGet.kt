// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.main.msg

import com.neome.api.meta.base.Types.ChatId
import java.util.Map
import com.neome.api.nucleus.base.msg.Msg

open class MsgMessageBulkGet : Msg()
{
  lateinit var chatId: ChatId
  lateinit var offsetMap: Map<Number, String>
}