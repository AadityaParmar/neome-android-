// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.msg

import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.Types.RowId
import com.neome.api.nucleus.base.msg.Msg

class MsgSpreadsheetHistoryGet : Msg() {
    var offset: string? = null
    var pageSize: number? = null
    var rowId: RowId? = null
    var searchText: string? = null
    val spreadsheetId: MetaIdSpreadsheet
}
