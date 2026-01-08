// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.main.sig

import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.home.main.sig.SigSpreadsheetRowCommentCount
import com.neome.api.nucleus.base.sig.SigVersion
import com.neome.api.meta.base.Types.SpreadsheetPartitionId

interface SigSpreadsheetRow : SigVersion
{
  val formId: MetaIdForm
  val formValue: FormValueRaw?
  val rowCommentCount: SigSpreadsheetRowCommentCount?
  val spreadsheetId: MetaIdSpreadsheet
  val spreadsheetPartitionId: SpreadsheetPartitionId
  val updatedKeySet: Array<MetaIdComp>?
}