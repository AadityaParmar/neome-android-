// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import com.neome.api.meta.base.Types.ChatId
import com.neome.api.meta.base.Types.EntId
import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.meta.base.Types.MessageId
import kotlin.properties.Delegates

open class DtoStarMessage {
    lateinit var chatId: ChatId
    lateinit var creationDate: String
    lateinit var entId: EntId
    lateinit var messageId: MessageId
    var messageOffset: Number by Delegates.notNull<Number>()
    lateinit var senderId: EntUserId
}
