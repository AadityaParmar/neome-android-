package com.neome.core.common.serializer.api.core.base.dto

import com.neome.api.core.base.dto.NotificationCustomData
import com.neome.api.meta.base.Types
import com.neome.core.common.serializer.sysId.ChatIdSer
import com.neome.core.common.serializer.sysId.EntIdSer
import com.neome.core.common.serializer.sysId.EntUserIdSer
import com.neome.core.common.serializer.sysId.MessageIdSer
import com.neome.core.common.serializer.sysId.MetaIdFormSer
import com.neome.core.common.serializer.sysId.MetaIdSpreadsheetSer
import com.neome.core.common.serializer.sysId.RowIdSer
import kotlinx.serialization.Serializable


@Serializable
data class NotificationCustomDataData(
    @Serializable(with = ChatIdSer::class) override val chatId: Types.ChatId? = null,
    @Serializable(with = EntIdSer::class) override val entId: Types.EntId? = null,
    @Serializable(with = MetaIdFormSer::class) override val formId: Types.MetaIdForm? = null,
    override val isEntInvite: Boolean? = null,
    @Serializable(with = MessageIdSer::class) override val messageId: Types.MessageId? = null,
    override val messageType: String? = null,
    @Serializable(with = ChatIdSer::class) override val parentChatId: Types.ChatId? = null,
    @Serializable(with = MessageIdSer::class) override val parentMessageId: Types.MessageId? = null,
    @Serializable(with = RowIdSer::class) override val rowId: Types.RowId? = null,
    @Serializable(with = EntUserIdSer::class) override val senderId: Types.EntUserId? = null,
    @Serializable(with = MetaIdSpreadsheetSer::class) override val spreadsheetId: Types.MetaIdSpreadsheet? = null
) : NotificationCustomData
