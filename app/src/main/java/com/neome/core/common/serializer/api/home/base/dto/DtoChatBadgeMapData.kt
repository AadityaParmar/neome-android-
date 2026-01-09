package com.neome.core.common.serializer.api.home.base.dto

import com.neome.api.home.base.dto.DtoChatBadgeMap
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.sysId.ChatIdSer
import kotlinx.serialization.Serializable


@Serializable
data class DtoChatBadgeMapData(
    override val chatBadgeMap: Map<@Serializable(with = ChatIdSer::class) Types.ChatId, Long>? = null
) : DtoChatBadgeMap
