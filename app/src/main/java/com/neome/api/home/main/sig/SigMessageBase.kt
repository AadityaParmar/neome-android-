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

class SigMessageBase : Sig() {
    val creationTime: string
    var isCallerSender: boolean? = null
    val messageId: MessageId
    val messageOffset: number
    val payload: DtoMessagePayload
    var reactionMap: Record<EntUserId, DtoMessageReaction>? = null
    var replyPayload: DtoMessageReplyPayload? = null
    val senderId: EntUserId
}
