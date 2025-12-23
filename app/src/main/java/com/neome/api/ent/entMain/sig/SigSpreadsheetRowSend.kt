// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.sig

import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.Types.RowId
import com.neome.api.nucleus.base.sig.Sig
import com.neome.api.meta.base.Types.SpreadsheetPartitionId

open class SigSpreadsheetRowSend : Sig()
{
  lateinit var formId: MetaIdForm
  lateinit var rowId: RowId
  lateinit var spreadsheetId: MetaIdSpreadsheet
  lateinit var spreadsheetPartitionId: SpreadsheetPartitionId
}