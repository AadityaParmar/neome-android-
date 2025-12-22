// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnLayoutGridKind
import com.neome.api.meta.base.Types.MetaIdLayoutGrid
import com.neome.api.meta.base.Types.MetaIdSpreadsheet

class DefnStudioPickLayoutSpreadsheetId : DefnFieldEditable() {
    var excludeLayoutSpreadsheetIdSet: MetaIdLayoutGrid[]? = null
    var filterLayoutKindSet: EnumDefnLayoutGridKind[]? = null
    var showAlias: boolean? = null
    val spreadsheetId: MetaIdSpreadsheet
}
