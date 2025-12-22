// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.msg

import com.neome.api.meta.base.Types.MetaIdAction
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.nucleus.base.msg.Msg

class MsgSpreadsheetRowSend : Msg() {
    var actionId: MetaIdAction? = null
    val formValueRaw: FormValueRaw
    var mappingVarId: MetaIdVar? = null
    var targetSpreadsheetId: MetaIdSpreadsheet? = null
    var transactionId: string? = null
}
