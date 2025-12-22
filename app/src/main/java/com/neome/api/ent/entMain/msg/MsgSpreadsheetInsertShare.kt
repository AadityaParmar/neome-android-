// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.msg

import com.neome.api.meta.base.Types.ChatId
import com.neome.api.meta.base.Types.MetaIdAction
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.nucleus.base.msg.Msg

class MsgSpreadsheetInsertShare : Msg() {
    val actionId: MetaIdAction
    val chatId: ChatId
    var formValueRaw: FormValueRaw? = null
    var reset: boolean? = null
}
