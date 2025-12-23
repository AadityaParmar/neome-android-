// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdLayoutGrid
import com.neome.api.meta.base.Types.MetaIdSpreadsheet

open class StudioEntActionRowUpdate : StudioEntAction() {
    var filterConditionVarId: StudioValueVarIdCondition? = null
    var layoutSpreadsheetId: MetaIdLayoutGrid? = null
    var lookupFieldId: MetaIdField? = null
    var spreadsheetId: MetaIdSpreadsheet? = null
}
