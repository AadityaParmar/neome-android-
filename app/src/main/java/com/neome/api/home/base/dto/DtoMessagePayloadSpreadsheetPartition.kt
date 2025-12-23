// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.home.base.dto

import com.neome.api.home.main.sig.SigSpreadsheetRow
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.Types.RowId
import com.neome.api.meta.base.Types.SpreadsheetPartitionId

open class DtoMessagePayloadSpreadsheetPartition : DtoMessagePayload() {
    lateinit var chatBubbleHeader: DtoChatBubbleHeader
    lateinit var formId: MetaIdForm
    var partitionList: Array<DtoPartition>? = null
    var rowId: RowId? = null
    lateinit var spreadsheetId: MetaIdSpreadsheet
    lateinit var spreadsheetPartitionId: SpreadsheetPartitionId
    var spreadsheetRow: SigSpreadsheetRow? = null
}
