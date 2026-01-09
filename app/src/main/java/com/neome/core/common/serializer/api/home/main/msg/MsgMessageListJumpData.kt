package com.neome.core.common.serializer.api.home.main.msg

import com.neome.api.home.main.msg.MsgMessageList
import com.neome.api.home.main.msg.MsgMessageListJump
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.sysId.ChatIdSer
import com.neome.core.common.serializer.sysId.MessageIdSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgMessageListJumpData(
    @Serializable(with = ChatIdSer::class) override val chatId: Types.ChatId,
    override val pageSize: Long? = null,
    @Serializable(with = MessageIdSer::class) override val messageId: Types.MessageId? = null,
    override val offset: Long? = null
) : MsgMessageListJump
