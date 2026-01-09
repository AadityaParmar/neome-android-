package com.neome.core.common.serializer.api.home.base.dto

import com.neome.api.home.base.dto.DtoRecentItem
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.sysId.ChatIdSer
import com.neome.core.common.serializer.sysId.EntIdSer
import kotlinx.serialization.Serializable


@Serializable
data class DtoRecentItemData(
    @Serializable(with = ChatIdSer::class) override val chatId: Types.ChatId,
    @Serializable(with = EntIdSer::class) override val entId: Types.EntId,
    override val isPinned: Boolean? = null
) : DtoRecentItem
