// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import com.neome.api.meta.base.Types.ChatId
import com.neome.api.meta.base.Types.EntId
import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.meta.base.Types.MessageId

class DtoStarMessage {
    val chatId: ChatId
    val creationDate: string
    val entId: EntId
    val messageId: MessageId
    val messageOffset: number
    val senderId: EntUserId
}
