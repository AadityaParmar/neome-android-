// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import com.neome.api.home.base.dto.DtoChatBubbleHeader
import com.neome.api.home.base.dto.DtoMessagePayload
import com.neome.api.home.base.dto.DtoPartition
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.Types.RowId
import com.neome.api.home.main.sig.SigSpreadsheetRow
import com.neome.api.meta.base.Types.SpreadsheetPartitionId

interface DtoMessagePayloadSpreadsheetPartition : DtoMessagePayload
{
  val chatBubbleHeader: DtoChatBubbleHeader
  val formId: MetaIdForm
  val partitionList: Array<DtoPartition>?
  val rowId: RowId?
  val spreadsheetId: MetaIdSpreadsheet
  val spreadsheetPartitionId: SpreadsheetPartitionId
  val spreadsheetRow: SigSpreadsheetRow?
}