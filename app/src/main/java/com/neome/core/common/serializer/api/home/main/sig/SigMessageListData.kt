package com.neome.core.common.serializer.api.home.main.sig

import com.neome.api.home.main.sig.SigMessage
import com.neome.api.home.main.sig.SigMessageList
import com.neome.api.meta.base.Types
import com.neome.api.nucleus.base.sig.Sig
import com.neome.core.common.serializer.api.home.main.sig.SigMessageData
import com.neome.core.common.serializer.sysId.ChatIdSer
import com.neome.core.common.serializer.sysId.EntIdSer
import kotlinx.serialization.Serializable


@Serializable
data class SigMessageListData(
    override val bottomOffset: Long? = null,
    @Serializable(with = ChatIdSer::class) override val chatId: Types.ChatId,
    override val chatIdHash: String,
    @Serializable(with = EntIdSer::class) override val entId: Types.EntId,
    override val messageList: List<SigMessageData>,
    override val pageBottomOffset: Long? = null,
    override val pageTopOffset: Long? = null,
    override val readOffset: Long? = null,
    override val topOffset: Long? = null
) : SigMessageList
