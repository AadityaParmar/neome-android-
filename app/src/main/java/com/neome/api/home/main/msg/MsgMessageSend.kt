// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.main.msg

import com.neome.api.meta.base.Types.ChatId
import com.neome.api.core.base.dto.DtoChatMessageOffset
import com.neome.api.home.base.dto.DtoMessagePayload
import com.neome.api.home.base.dto.DtoMessageReplyPayload
import com.neome.api.meta.base.Types.MessageId
import com.neome.api.nucleus.base.msg.Msg

open class MsgMessageSend : Msg()
{
  lateinit var chatId: ChatId
  var chatMessageOffset: DtoChatMessageOffset? = null
  lateinit var messageId: MessageId
  lateinit var payload: DtoMessagePayload
  var replyPayload: DtoMessageReplyPayload? = null
}