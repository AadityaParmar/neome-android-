// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnEjectionPolicy
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdSpreadsheet

class DefnFieldRefSet : DefnFieldEditable() {
    var allowDuplicateValues: boolean? = null
    var displayFieldId: MetaIdField? = null
    var ejectionPolicy: EnumDefnEjectionPolicy? = null
    var layoutSpreadsheet: DefnLayoutGrid? = null
    var maxSize: number? = null
    val spreadsheetId: MetaIdSpreadsheet
}
