// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.msg

import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.Types.RowId
import com.neome.api.nucleus.base.msg.Msg

interface MsgSpreadsheetRowRemove : Msg {
    val formId: MetaIdForm
    val rowId: RowId?
    val rowIdSet: List<RowId>?
    val spreadsheetId: MetaIdSpreadsheet
    val transactionId: String?
}
