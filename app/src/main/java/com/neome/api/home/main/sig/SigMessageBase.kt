// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.main.sig

import com.neome.api.home.base.dto.DtoMessagePayload
import com.neome.api.home.base.dto.DtoMessageReaction
import com.neome.api.home.base.dto.DtoMessageReplyPayload
import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.meta.base.Types.MessageId
import com.neome.api.nucleus.base.sig.Sig

interface SigMessageBase : Sig
{
  val creationTime: String
  val isCallerSender: Boolean?
  val messageId: MessageId
  val messageOffset: Long
  val payload: DtoMessagePayload
  val reactionMap: Map<EntUserId, DtoMessageReaction>?
  val replyPayload: DtoMessageReplyPayload?
  val senderId: EntUserId
}