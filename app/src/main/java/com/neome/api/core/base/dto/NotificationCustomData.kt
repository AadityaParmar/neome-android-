// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.base.dto

import com.neome.api.meta.base.Types.ChatId
import com.neome.api.meta.base.Types.EntId
import com.neome.api.meta.base.Types.EntUserId
import com.neome.api.meta.base.Types.MessageId
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.Types.RowId

class NotificationCustomData {
    var chatId: ChatId? = null
    var entId: EntId? = null
    var formId: MetaIdForm? = null
    var isEntInvite: boolean? = null
    var messageId: MessageId? = null
    var messageType: string? = null
    var parentChatId: ChatId? = null
    var parentMessageId: MessageId? = null
    var rowId: RowId? = null
    var senderId: EntUserId? = null
    var spreadsheetId: MetaIdSpreadsheet? = null
}
