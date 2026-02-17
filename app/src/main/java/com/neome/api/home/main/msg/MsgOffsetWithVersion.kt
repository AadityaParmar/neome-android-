// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.main.msg

import com.neome.api.meta.base.Types.ChatId
import com.neome.api.core.base.msg.MsgVersion

interface MsgOffsetWithVersion : MsgVersion
{
  val chatId: ChatId
  val offset: Long
}