// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.aside.msg

import com.neome.api.meta.base.Types.ChatId
import com.neome.api.nucleus.base.msg.Msg

open class MsgAsideSearch : Msg()
{
  lateinit var chatId: ChatId
  var pageSize: Number? = null
  lateinit var searchId: String
  lateinit var searchQuery: String
}