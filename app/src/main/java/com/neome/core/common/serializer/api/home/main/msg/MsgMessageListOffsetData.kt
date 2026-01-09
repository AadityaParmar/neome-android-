package com.neome.core.common.serializer.api.home.main.msg

import com.neome.api.home.main.msg.MsgMessageList
import com.neome.api.home.main.msg.MsgMessageListOffset
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.sysId.ChatIdSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgMessageListOffsetData(
    @Serializable(with = ChatIdSer::class) override val chatId: Types.ChatId,
    override val pageSize: Long? = null,
    override val offset: Long? = null
) : MsgMessageListOffset
