// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdLayoutGrid
import com.neome.api.meta.base.Types.MetaIdSpreadsheet

class StudioDtoRefTarget : StudioBase() {
    var displayFieldIdSet: MetaIdField[]? = null
    var filterConditionVarId: StudioValueVarIdCondition? = null
    val metaId: MetaIdSpreadsheet
    var name: Symbol? = null
    var overrideLayoutSpreadsheetId: MetaIdLayoutGrid? = null
}
