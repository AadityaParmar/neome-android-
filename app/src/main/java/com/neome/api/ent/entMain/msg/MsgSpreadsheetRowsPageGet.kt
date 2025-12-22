// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.msg

import com.neome.api.ent.base.dto.SpreadsheetFilterComposite
import com.neome.api.meta.base.Types.MetaIdAction
import com.neome.api.meta.base.Types.MetaIdComposite
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdLayoutGrid
import com.neome.api.meta.base.Types.RowId
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.nucleus.base.msg.Msg

class MsgSpreadsheetRowsPageGet : Msg() {
    val actionId: MetaIdAction
    var ascOrder: boolean? = null
    var filterValue: SpreadsheetFilterComposite? = null
    var includeFilters: boolean? = null
    var inputFormCompositeId: MetaIdComposite? = null
    var inputFormGridRowId: RowId? = null
    var inputFormValueRaw: FormValueRaw? = null
    var layoutSpreadsheetId: MetaIdLayoutGrid? = null
    var orderByFieldId: MetaIdField? = null
    var pageNumber: number? = null
    var pageSize: number? = null
    var searchText: string? = null
}
