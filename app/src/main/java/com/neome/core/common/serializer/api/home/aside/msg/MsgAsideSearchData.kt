package com.neome.core.common.serializer.api.home.aside.msg

import com.neome.api.home.aside.msg.MsgAsideSearch
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.msg.Msg
import com.neome.core.common.serializer.sysId.ChatIdSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgAsideSearchData(
    @Serializable(with = ChatIdSer::class) override val chatId: Types.ChatId,
    override val pageSize: Long? = null,
    override val searchId: String,
    override val searchQuery: String
) : MsgAsideSearch
