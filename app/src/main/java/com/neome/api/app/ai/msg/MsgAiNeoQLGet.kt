// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.app.ai.msg

import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.dto.FormRefKey
import com.neome.api.nucleus.base.msg.Msg

class MsgAiNeoQLGet : Msg() {
    var inputFormRefKey: FormRefKey? = null
    var neoQL: string? = null
    var outputFormRefKey: FormRefKey? = null
    var paramMap: Record<string, FormRefKey>? = null
    val spreadsheetIdSet: MetaIdSpreadsheet[]
    val userMessage: string
}
