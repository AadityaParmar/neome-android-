package com.neome.core.common.serializer.api.home.main.sig

import com.neome.api.home.base.Types.EnumReceiptStatus
import com.neome.api.home.base.dto.DtoMessagePayload
import com.neome.api.home.main.sig.SigLastMessage
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.sig.SigVersion
import com.neome.core.common.serializer.api.home.base.dto.DtoMessagePayloadSeal
import com.neome.core.common.serializer.sysId.ChatIdSer
import com.neome.core.common.serializer.sysId.EntIdSer
import com.neome.core.common.serializer.sysId.EntUserIdSer
import com.neome.core.common.serializer.sysId.MessageIdSer
import kotlinx.serialization.Serializable


@Serializable
data class SigLastMessageData(
    override val version: String,
    @Serializable(with = ChatIdSer::class) override val chatId: Types.ChatId,
    @Serializable(with = EntIdSer::class) override val entId: Types.EntId,
    @Serializable(with = MessageIdSer::class) override val messageId: Types.MessageId,
    override val messageOffset: Long,
    override val messagePayload: DtoMessagePayloadSeal,
    override val messageSummary: String,
    override val messageTime: String,
    override val receiptStatus: EnumReceiptStatus? = null,
    @Serializable(with = EntUserIdSer::class) override val senderId: Types.EntUserId
) : SigLastMessage
