// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.main.msg

import kotlin.properties.Delegates
import com.neome.api.meta.base.Types.ChatId
import com.neome.api.core.base.msg.MsgVersion

open class MsgOffsetWithVersion : MsgVersion()
{
  lateinit var chatId: ChatId
  var offset: Number by Delegates.notNull<Number>()
}