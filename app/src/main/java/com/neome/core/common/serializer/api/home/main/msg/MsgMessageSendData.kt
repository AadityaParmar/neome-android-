package com.neome.core.common.serializer.api.home.main.msg

import com.neome.api.core.base.dto.DtoChatMessageOffset
import com.neome.api.home.base.dto.DtoMessagePayload
import com.neome.api.home.base.dto.DtoMessageReplyPayload
import com.neome.api.home.main.msg.MsgMessageSend
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.api.core.base.dto.DtoChatMessageOffsetData
import com.neome.core.common.serializer.api.home.base.dto.DtoMessagePayloadSeal
import com.neome.core.common.serializer.api.home.base.dto.DtoMessageReplyPayloadData
import com.neome.core.common.serializer.sysId.ChatIdSer
import com.neome.core.common.serializer.sysId.MessageIdSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgMessageSendData(
    @Serializable(with = ChatIdSer::class) override val chatId: Types.ChatId,
    override val chatMessageOffset: DtoChatMessageOffsetData? = null,
    @Serializable(with = MessageIdSer::class) override val messageId: Types.MessageId,
    override val payload: DtoMessagePayloadSeal,
    override val replyPayload: DtoMessageReplyPayloadData? = null
) : MsgMessageSend
