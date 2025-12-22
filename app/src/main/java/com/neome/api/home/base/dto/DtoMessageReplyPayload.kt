// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import com.neome.api.home.base.Types.EnumMessageType
import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.meta.base.Types.MessageId

class DtoMessageReplyPayload {
    val messageId: MessageId
    val messageType: EnumMessageType
    val senderId: EntUserId
}
