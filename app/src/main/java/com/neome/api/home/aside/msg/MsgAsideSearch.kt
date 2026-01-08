// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.aside.msg

import com.neome.api.meta.base.Types.ChatId
import com.neome.api.nucleus.base.msg.Msg

interface MsgAsideSearch : Msg
{
  val chatId: ChatId
  val pageSize: Long?
  val searchId: String
  val searchQuery: String
}