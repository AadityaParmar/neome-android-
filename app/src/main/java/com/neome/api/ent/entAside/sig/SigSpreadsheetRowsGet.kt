// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entAside.sig

import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.RowId
import com.neome.api.nucleus.base.sig.Sig
import java.util.Map

open class SigSpreadsheetRowsGet : Sig() {
    var dateRowIdSetMap: Map<String, Array<RowId>>? = null
    var groupByRowIdSetMap: Map<String, Array<RowId>>? = null
    lateinit var outputFormId: MetaIdForm
    var rowIdSet: Array<RowId>? = null
}
