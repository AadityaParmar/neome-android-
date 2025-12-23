// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.home.base.Types.EnumMessageType
import com.neome.api.meta.base.Types.MessageId

open class DtoMessageReplyPayload
{
  lateinit var messageId: MessageId
  lateinit var messageType: EnumMessageType
  lateinit var senderId: EntUserId
}