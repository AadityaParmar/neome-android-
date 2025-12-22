// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entAside.sig

import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.RowId
import com.neome.api.nucleus.base.sig.Sig

class SigSpreadsheetRowsGet : Sig() {
    var dateRowIdSetMap: Record<string, RowId[]>? = null
    var groupByRowIdSetMap: Record<string, RowId[]>? = null
    val outputFormId: MetaIdForm
    var rowIdSet: RowId[]? = null
}
