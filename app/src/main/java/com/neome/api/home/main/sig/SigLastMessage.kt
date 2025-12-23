// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.main.sig

import kotlin.properties.Delegates
import com.neome.api.meta.base.Types.ChatId
import java.util.Date
import com.neome.api.home.base.dto.DtoMessagePayload
import com.neome.api.meta.base.Types.EntId
import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.home.base.Types.EnumReceiptStatus
import com.neome.api.meta.base.Types.MessageId
import com.neome.api.nucleus.base.sig.SigVersion

open class SigLastMessage : SigVersion()
{
  lateinit var chatId: ChatId
  lateinit var entId: EntId
  lateinit var messageId: MessageId
  var messageOffset: Number by Delegates.notNull<Number>()
  lateinit var messagePayload: DtoMessagePayload
  lateinit var messageSummary: String
  lateinit var messageTime: String
  var receiptStatus: EnumReceiptStatus? = null
  lateinit var senderId: EntUserId
}