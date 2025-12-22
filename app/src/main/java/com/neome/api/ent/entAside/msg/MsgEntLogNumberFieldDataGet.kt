// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entAside.msg

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdGrid
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.Types.RowId
import com.neome.api.nucleus.base.msg.Msg

class MsgEntLogNumberFieldDataGet : Msg() {
    val fieldId: MetaIdField
    var gridId: MetaIdGrid? = null
    var gridRowId: RowId? = null
    val rowId: RowId
    val spreadsheetId: MetaIdSpreadsheet
}
