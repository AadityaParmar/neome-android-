// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.msg

import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.Types.RowId
import com.neome.api.nucleus.base.msg.Msg

open class MsgSpreadsheetRowRemove : Msg() {
    lateinit var formId: MetaIdForm
    var rowId: RowId? = null
    var rowIdSet: Array<RowId>? = null
    lateinit var spreadsheetId: MetaIdSpreadsheet
    var transactionId: String? = null
}
