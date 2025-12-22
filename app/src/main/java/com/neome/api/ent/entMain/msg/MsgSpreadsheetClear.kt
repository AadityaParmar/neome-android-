// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.msg

import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.nucleus.base.msg.Msg

class MsgSpreadsheetClear : Msg() {
    val spreadsheetId: MetaIdSpreadsheet
}
