// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.core.base.dto

import com.neome.api.meta.base.Types.ChatId
import com.neome.api.meta.base.Types.MetaIdSpreadsheet

open class DtoChatMessageOffset {
    var chatId: ChatId? = null
    var offset: Number? = null
    var spreadsheetId: MetaIdSpreadsheet? = null
}
