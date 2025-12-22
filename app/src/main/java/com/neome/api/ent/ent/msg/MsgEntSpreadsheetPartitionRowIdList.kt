// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.ent.msg

import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.nucleus.base.msg.Msg

class MsgEntSpreadsheetPartitionRowIdList : Msg() {
    val pageSize: number
    val spreadsheetId: MetaIdSpreadsheet
    val toRowOrderVer: string
}
