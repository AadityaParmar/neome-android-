// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entAside.msg

import com.neome.api.ent.base.dto.SpreadsheetFilterComposite
import com.neome.api.meta.base.Types.MetaIdAction
import com.neome.api.meta.base.Types.MetaIdComposite
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.Types.RowId
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.nucleus.base.msg.Msg

class MsgSpreadsheetRowsGet : Msg() {
    val actionId: MetaIdAction
    var ascOrder: boolean? = null
    var dateFieldId: MetaIdField? = null
    var filterValue: SpreadsheetFilterComposite? = null
    var groupByFieldId: MetaIdField? = null
    var inputFormCompositeId: MetaIdComposite? = null
    var inputFormGridRowId: RowId? = null
    var inputFormValueRaw: FormValueRaw? = null
    var searchText: string? = null
    var sortByFieldIdSet: MetaIdField[]? = null
    val spreadsheetId: MetaIdSpreadsheet
}
