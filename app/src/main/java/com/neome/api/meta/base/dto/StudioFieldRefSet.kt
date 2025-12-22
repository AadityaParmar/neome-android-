// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnEjectionPolicy
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdLayoutGrid
import com.neome.api.meta.base.Types.MetaIdSpreadsheet

class StudioFieldRefSet : StudioFieldEditable() {
    var allowDuplicateValues: boolean? = null
    var displayFieldId: MetaIdField? = null
    var ejectionPolicy: EnumDefnEjectionPolicy? = null
    var filterConditionVarId: StudioValueVarIdCondition? = null
    var layoutSpreadsheetId: MetaIdLayoutGrid? = null
    var maxSize: number? = null
    var spreadsheetId: MetaIdSpreadsheet? = null
}
