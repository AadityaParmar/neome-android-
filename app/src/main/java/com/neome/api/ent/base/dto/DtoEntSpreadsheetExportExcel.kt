// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.Types.MetaIdAction
import com.neome.api.meta.base.Types.MetaIdLayoutGrid
import com.neome.api.meta.base.Types.RowId

class DtoEntSpreadsheetExportExcel {
    var layoutSpreadsheetId: MetaIdLayoutGrid? = null
    var rowIdSet: RowId[]? = null
    val spreadsheetEditorActionId: MetaIdAction
}
