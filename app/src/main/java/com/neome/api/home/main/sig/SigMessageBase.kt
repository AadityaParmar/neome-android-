// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.main.sig

import kotlin.properties.Delegates
import java.util.Date
import com.neome.api.home.base.dto.DtoMessagePayload
import com.neome.api.home.base.dto.DtoMessageReaction
import com.neome.api.home.base.dto.DtoMessageReplyPayload
import com.neome.api.meta.base.Types.EntUserId
import java.util.Map
import com.neome.api.meta.base.Types.MessageId
import com.neome.api.nucleus.base.sig.Sig

open class SigMessageBase : Sig()
{
  lateinit var creationTime: String
  var isCallerSender: Boolean? = null
  lateinit var messageId: MessageId
  var messageOffset: Number by Delegates.notNull<Number>()
  lateinit var payload: DtoMessagePayload
  var reactionMap: Map<EntUserId, DtoMessageReaction>? = null
  var replyPayload: DtoMessageReplyPayload? = null
  lateinit var senderId: EntUserId
}