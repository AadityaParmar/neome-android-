// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entAside.msg

import com.neome.api.ent.base.dto.SpreadsheetFilterComposite
import com.neome.api.meta.base.Types.MetaIdComp
import com.neome.api.meta.base.Types.MetaIdComposite
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdLayoutGrid
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.Types.RowId
import com.neome.api.meta.base.dto.FormValueRaw
import com.neome.api.nucleus.base.msg.Msg

class MsgRefFieldDataPaginatedGet : Msg() {
    var ascOrder: boolean? = null
    var filterValue: SpreadsheetFilterComposite? = null
    val formId: MetaIdForm
    var includeFilters: boolean? = null
    var inputFormCompositeId: MetaIdComposite? = null
    var inputFormGridRowId: RowId? = null
    val inputFormValueRaw: FormValueRaw
    var layoutSpreadsheetId: MetaIdLayoutGrid? = null
    var orderByFieldId: MetaIdField? = null
    var pageNumber: number? = null
    var pageSize: number? = null
    val refFieldId: MetaIdComp
    var searchText: string? = null
    var targetSpreadsheetId: MetaIdSpreadsheet? = null
}
