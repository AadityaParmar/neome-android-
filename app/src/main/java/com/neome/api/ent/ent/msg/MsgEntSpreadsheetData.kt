// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.ent.msg

import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.nucleus.base.msg.Msg

class MsgEntSpreadsheetData : Msg() {
    var fromGridVer: string? = null
    val pageSize: number
    val spreadsheetId: MetaIdSpreadsheet
    val toGridVer: string
}
