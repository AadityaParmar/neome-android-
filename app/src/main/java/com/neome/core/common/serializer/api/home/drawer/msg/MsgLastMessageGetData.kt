package com.neome.core.common.serializer.api.home.drawer.msg

import com.neome.api.core.base.msg.MsgVersion
import com.neome.api.home.drawer.msg.MsgLastMessageGet
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.sysId.ContactIdSer
import kotlinx.serialization.Serializable


@Serializable
data class MsgLastMessageGetData(
    override val version: String? = null,
    @Serializable(with = ContactIdSer::class) override val chatId: Types.ContactId
) : MsgLastMessageGet
