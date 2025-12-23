// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.msg

import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.Types.RowId
import com.neome.api.nucleus.base.msg.Msg

open class MsgSpreadsheetRowShare : Msg() {
    var reset: Boolean? = null
    lateinit var rowId: RowId
    lateinit var spreadsheetId: MetaIdSpreadsheet
}
