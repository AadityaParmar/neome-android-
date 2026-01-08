// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.sig

import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.Types.RowId
import com.neome.api.nucleus.base.sig.Sig
import com.neome.api.meta.base.Types.SpreadsheetPartitionId

interface SigSpreadsheetRowSend : Sig
{
  val formId: MetaIdForm
  val rowId: RowId
  val spreadsheetId: MetaIdSpreadsheet
  val spreadsheetPartitionId: SpreadsheetPartitionId
}