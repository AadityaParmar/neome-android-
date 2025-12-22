// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.main.msg

import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.Types.RowId
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.nucleus.base.msg.Msg

class MsgSpreadsheetBulkRowInsert : Msg() {
    val rowMap: Record<RowId, FormValueRaw>
    val spreadsheetId: MetaIdSpreadsheet
}
