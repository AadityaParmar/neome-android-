package com.neome.core.common.serializer.api.home.main.msg

import com.neome.api.core.base.dto.DtoChatMessageOffset
import com.neome.api.home.base.dto.DtoMessagePayload
import com.neome.api.home.main.msg.MsgMessageEdit
import com.neome.api.home.main.msg.MsgOffset
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.api.home.base.dto.DtoMessagePayloadSeal
import com.neome.core.common.serializer.sysId.ChatIdSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgMessageEditData(
    @Serializable(with = ChatIdSer::class) override val chatId: Types.ChatId,
    override val offset: Long? = null,
    override val chatMessageOffset: DtoChatMessageOffset? = null,
    override val dtoMessagePayload: DtoMessagePayloadSeal? = null
) : MsgMessageEdit
