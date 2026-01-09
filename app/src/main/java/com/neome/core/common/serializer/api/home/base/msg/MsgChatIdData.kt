package com.neome.core.common.serializer.api.home.base.msg

import com.neome.api.home.base.msg.MsgChatId
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.sysId.ChatIdSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgChatIdData(
    @Serializable(with = ChatIdSer::class) override val chatId: Types.ChatId
) : MsgChatId
