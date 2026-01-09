package com.neome.core.common.serializer.api.home.main.msg

import com.neome.api.home.main.msg.MsgMessageList
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.sysId.ChatIdSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgMessageListData(
    @Serializable(with = ChatIdSer::class) override val chatId: Types.ChatId,
    override val pageSize: Long? = null
) : MsgMessageList
