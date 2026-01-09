package com.neome.core.common.serializer.api.home.main.msg

import com.neome.api.home.main.msg.MsgChatBlock
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.sysId.EntUserIdSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgChatBlockData(
    override val block: Boolean,
    @Serializable(with = EntUserIdSer::class) override val chatId: Types.EntUserId
) : MsgChatBlock
