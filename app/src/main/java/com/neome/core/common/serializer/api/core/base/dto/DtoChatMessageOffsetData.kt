package com.neome.core.common.serializer.api.core.base.dto

import com.neome.api.core.base.dto.DtoChatMessageOffset
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.sysId.ChatIdSer
import com.neome.core.common.serializer.sysId.MetaIdSpreadsheetSer
import kotlinx.serialization.Serializable


@Serializable
data class DtoChatMessageOffsetData(
    @Serializable(with = ChatIdSer::class) override val chatId: Types.ChatId? = null,
    override val offset: Long? = null,
    @Serializable(with = MetaIdSpreadsheetSer::class) override val spreadsheetId: Types.MetaIdSpreadsheet? = null
) : DtoChatMessageOffset
