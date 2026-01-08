// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import com.neome.api.meta.base.Types.ChatId
import java.util.Date
import com.neome.api.meta.base.Types.EntId
import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.meta.base.Types.MessageId

interface DtoStarMessage
{
  val chatId: ChatId
  val creationDate: String
  val entId: EntId
  val messageId: MessageId
  val messageOffset: Long?
  val senderId: EntUserId
}