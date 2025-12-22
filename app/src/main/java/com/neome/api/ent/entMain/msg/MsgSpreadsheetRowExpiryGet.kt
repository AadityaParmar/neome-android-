// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.msg

import com.neome.api.core.base.msg.MsgVersion
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.Types.SpreadsheetPartitionId

class MsgSpreadsheetRowExpiryGet : MsgVersion() {
    val spreadsheetId: MetaIdSpreadsheet
    val spreadsheetPartitionId: SpreadsheetPartitionId
}
