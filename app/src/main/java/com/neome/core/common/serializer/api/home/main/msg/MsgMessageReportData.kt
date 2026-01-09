package com.neome.core.common.serializer.api.home.main.msg

import com.neome.api.home.main.msg.MsgMessageReport
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.sysId.ChatIdSer
import com.neome.core.common.serializer.sysId.EntIdSer
import com.neome.core.common.serializer.sysId.MessageIdSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgMessageReportData(
    @Serializable(with = ChatIdSer::class) override val chatId: Types.ChatId,
    @Serializable(with = EntIdSer::class) override val entId: Types.EntId,
    @Serializable(with = MessageIdSer::class) override val messageId: Types.MessageId,
    override val offset: Long? = null
) : MsgMessageReport
