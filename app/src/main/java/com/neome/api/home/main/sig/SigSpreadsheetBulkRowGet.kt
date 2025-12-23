// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.main.sig

import java.util.Map
import com.neome.api.meta.base.Types.RowId
import java.util.Set
import com.neome.api.nucleus.base.sig.Sig
import com.neome.api.home.main.sig.SigSpreadsheetRow

open class SigSpreadsheetBulkRowGet : Sig()
{
  var expiredRowIdSet: Array<RowId>? = null
  var inProgressRowIdSet: Array<RowId>? = null
  var rowMap: Map<RowId, SigSpreadsheetRow>? = null
}