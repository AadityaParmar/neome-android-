package com.neome.core.common.serializer.api.home.main.msg

import com.neome.api.core.base.dto.DtoChatMessageOffset
import com.neome.api.home.main.msg.MsgOffset
import com.neome.api.home.main.msg.MsgReaction
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.api.core.base.dto.DtoChatMessageOffsetData
import com.neome.core.common.serializer.sysId.ChatIdSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgReactionData(
    @Serializable(with = ChatIdSer::class) override val chatId: Types.ChatId,
    override val offset: Long? = null,
    override val chatMessageOffset: DtoChatMessageOffsetData? = null,
    override val reaction: String? = null
) : MsgReaction
