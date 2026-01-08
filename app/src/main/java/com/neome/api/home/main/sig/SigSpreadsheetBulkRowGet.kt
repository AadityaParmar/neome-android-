// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.main.sig

import java.util.Map
import com.neome.api.meta.base.Types.RowId
import java.util.Set
import com.neome.api.nucleus.base.sig.Sig
import com.neome.api.home.main.sig.SigSpreadsheetRow

interface SigSpreadsheetBulkRowGet : Sig
{
  val expiredRowIdSet: Array<RowId>?
  val inProgressRowIdSet: Array<RowId>?
  val rowMap: Map<RowId, SigSpreadsheetRow>?
}