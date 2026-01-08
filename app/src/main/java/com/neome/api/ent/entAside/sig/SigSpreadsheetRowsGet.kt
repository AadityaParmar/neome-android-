// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entAside.sig

import java.util.Map
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.RowId
import java.util.Set
import com.neome.api.nucleus.base.sig.Sig

interface SigSpreadsheetRowsGet : Sig
{
  val dateRowIdSetMap: Map<String, Array<RowId>>?
  val groupByRowIdSetMap: Map<String, Array<RowId>>?
  val outputFormId: MetaIdForm
  val rowIdSet: Array<RowId>?
}