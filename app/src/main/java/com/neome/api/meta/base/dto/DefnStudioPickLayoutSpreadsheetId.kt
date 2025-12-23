// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnLayoutGridKind
import com.neome.api.meta.base.Types.MetaIdLayoutGrid
import com.neome.api.meta.base.Types.MetaIdSpreadsheet

open class DefnStudioPickLayoutSpreadsheetId : DefnFieldEditable() {
    var excludeLayoutSpreadsheetIdSet: Array<MetaIdLayoutGrid>? = null
    var filterLayoutKindSet: Array<EnumDefnLayoutGridKind>? = null
    var showAlias: Boolean? = null
    lateinit var spreadsheetId: MetaIdSpreadsheet
}
