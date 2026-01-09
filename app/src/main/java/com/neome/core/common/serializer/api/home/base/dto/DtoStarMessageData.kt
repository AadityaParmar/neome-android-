package com.neome.core.common.serializer.api.home.base.dto

import com.neome.api.home.base.dto.DtoStarMessage
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.sysId.ChatIdSer
import com.neome.core.common.serializer.sysId.EntIdSer
import com.neome.core.common.serializer.sysId.EntUserIdSer
import com.neome.core.common.serializer.sysId.MessageIdSer
import kotlinx.serialization.Serializable


@Serializable
data class DtoStarMessageData(
    @Serializable(with = ChatIdSer::class) override val chatId: Types.ChatId,
    override val creationDate: String,
    @Serializable(with = EntIdSer::class) override val entId: Types.EntId,
    @Serializable(with = MessageIdSer::class) override val messageId: Types.MessageId,
    override val messageOffset: Long? = null,
    @Serializable(with = EntUserIdSer::class) override val senderId: Types.EntUserId
) : DtoStarMessage
