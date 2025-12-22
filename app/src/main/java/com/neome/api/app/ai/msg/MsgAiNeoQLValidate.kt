// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.app.ai.msg

import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.dto.FormRefKey
import com.neome.api.nucleus.base.msg.Msg

class MsgAiNeoQLValidate : Msg() {
    var inputFormRefKey: FormRefKey? = null
    val neoQL: string
    var outputFormRefKey: FormRefKey? = null
    var paramMap: Record<string, FormRefKey>? = null
    val spreadsheetIdSet: MetaIdSpreadsheet[]
}
