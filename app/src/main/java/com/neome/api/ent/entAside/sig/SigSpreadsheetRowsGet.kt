// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entAside.sig

import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.RowId
import com.neome.api.nucleus.base.sig.Sig

interface SigSpreadsheetRowsGet : Sig
{
  val dateRowIdSetMap: Map<String, Set<RowId>>?
  val groupByRowIdSetMap: Map<String, Set<RowId>>?
  val outputFormId: MetaIdForm
  val rowIdSet: List<RowId>?
}