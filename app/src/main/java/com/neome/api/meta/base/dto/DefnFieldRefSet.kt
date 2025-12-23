// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnEjectionPolicy
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdSpreadsheet

open class DefnFieldRefSet : DefnFieldEditable() {
    var allowDuplicateValues: Boolean? = null
    var displayFieldId: MetaIdField? = null
    var ejectionPolicy: EnumDefnEjectionPolicy? = null
    var layoutSpreadsheet: DefnLayoutGrid? = null
    var maxSize: Number? = null
    lateinit var spreadsheetId: MetaIdSpreadsheet
}
