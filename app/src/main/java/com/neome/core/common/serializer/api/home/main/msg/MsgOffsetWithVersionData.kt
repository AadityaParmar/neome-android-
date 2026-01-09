package com.neome.core.common.serializer.api.home.main.msg

import com.neome.api.core.base.msg.MsgVersion
import com.neome.api.home.main.msg.MsgOffsetWithVersion
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.sysId.ChatIdSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgOffsetWithVersionData(
    override val version: String? = null,
    @Serializable(with = ChatIdSer::class) override val chatId: Types.ChatId,
    override val offset: Long? = null
) : MsgOffsetWithVersion
