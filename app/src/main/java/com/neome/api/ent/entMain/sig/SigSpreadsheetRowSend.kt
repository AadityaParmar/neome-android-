// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.sig

import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.Types.RowId
import com.neome.api.meta.base.Types.SpreadsheetPartitionId
import com.neome.api.nucleus.base.sig.Sig

class SigSpreadsheetRowSend : Sig() {
    val formId: MetaIdForm
    val rowId: RowId
    val spreadsheetId: MetaIdSpreadsheet
    val spreadsheetPartitionId: SpreadsheetPartitionId
}
