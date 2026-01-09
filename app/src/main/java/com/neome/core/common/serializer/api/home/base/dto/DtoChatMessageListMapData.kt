package com.neome.core.common.serializer.api.home.base.dto

import com.neome.api.home.base.dto.DtoChatMessageListMap
import com.neome.api.home.main.sig.SigMessage
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.sysId.ChatIdSer
import kotlinx.serialization.Serializable


@Serializable
data class DtoChatMessageListMapData(
    override val chatMessageListMap: Map<@Serializable(with = ChatIdSer::class) Types.ChatId, Array<SigMessage>>? = null
) : DtoChatMessageListMap
