// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.main.msg

import kotlin.properties.Delegates
import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.nucleus.base.msg.Msg

open class MsgChatBlock : Msg()
{
  var block: Boolean by Delegates.notNull<Boolean>()
  lateinit var chatId: EntUserId
}