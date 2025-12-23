// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.main.sig

import kotlin.properties.Delegates
import com.neome.api.meta.base.Types.ChatId
import com.neome.api.meta.base.Types.EntId
import com.neome.api.nucleus.base.sig.Sig
import com.neome.api.home.main.sig.SigMessage

open class SigMessageList : Sig()
{
  var bottomOffset: Number by Delegates.notNull<Number>()
  lateinit var chatId: ChatId
  lateinit var chatIdHash: String
  lateinit var entId: EntId
  lateinit var messageList: Array<SigMessage>
  var pageBottomOffset: Number by Delegates.notNull<Number>()
  var pageTopOffset: Number by Delegates.notNull<Number>()
  var readOffset: Number by Delegates.notNull<Number>()
  var topOffset: Number by Delegates.notNull<Number>()
}