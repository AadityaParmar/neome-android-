// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import com.neome.api.home.main.sig.SigSpreadsheetRow
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.Types.RowId
import com.neome.api.meta.base.Types.SpreadsheetPartitionId

class DtoMessagePayloadSpreadsheetPartition : DtoMessagePayload() {
    val chatBubbleHeader: DtoChatBubbleHeader
    val formId: MetaIdForm
    var partitionList: DtoPartition[]? = null
    var rowId: RowId? = null
    val spreadsheetId: MetaIdSpreadsheet
    val spreadsheetPartitionId: SpreadsheetPartitionId
    var spreadsheetRow: SigSpreadsheetRow? = null
}
