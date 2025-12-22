// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.main.sig

import com.neome.api.home.base.Types.EnumReceiptStatus
import com.neome.api.home.base.dto.DtoMessagePayload
import com.neome.api.meta.base.Types.ChatId
import com.neome.api.meta.base.Types.EntId
import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.meta.base.Types.MessageId
import com.neome.api.nucleus.base.sig.SigVersion

class SigLastMessage : SigVersion() {
    val chatId: ChatId
    val entId: EntId
    val messageId: MessageId
    val messageOffset: number
    val messagePayload: DtoMessagePayload
    val messageSummary: string
    val messageTime: string
    var receiptStatus: EnumReceiptStatus? = null
    val senderId: EntUserId
}
