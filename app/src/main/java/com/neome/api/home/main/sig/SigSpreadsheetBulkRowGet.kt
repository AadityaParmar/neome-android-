// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.main.sig

import com.neome.api.meta.base.Types.RowId
import com.neome.api.nucleus.base.sig.Sig

class SigSpreadsheetBulkRowGet : Sig() {
    var expiredRowIdSet: RowId[]? = null
    var inProgressRowIdSet: RowId[]? = null
    var rowMap: Record<RowId, SigSpreadsheetRow>? = null
}
