// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.ent.sig

import com.neome.api.meta.base.Types.RowId
import com.neome.api.nucleus.base.sig.Sig

open class SigEntSpreadsheetPartitionRowIdList : Sig()
{
  lateinit var bottomRowOrderVer: String
  lateinit var rowIdList: Array<RowId>
}