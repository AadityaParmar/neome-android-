// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.msg

import com.neome.api.core.base.msg.MsgVersion
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.Types.RowId
import com.neome.api.meta.base.dto.FormValueRaw

class MsgSpreadsheetRowMarkRead : MsgVersion() {
    val formValueRaw: FormValueRaw
    val rowId: RowId
    val spreadsheetId: MetaIdSpreadsheet
}
