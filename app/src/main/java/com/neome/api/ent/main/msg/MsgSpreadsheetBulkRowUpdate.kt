// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.main.msg

import com.neome.api.meta.base.Types.MetaIdAction
import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.api.meta.base.Types.RowId
import com.neome.api.nucleus.base.msg.Msg

class MsgSpreadsheetBulkRowUpdate : Msg() {
    val actionId: MetaIdAction
    val rowIdSet: RowId[]
    val valueMap: Record<MetaIdComp, any>
}
