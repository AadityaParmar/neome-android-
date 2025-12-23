// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdLayoutGrid
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.dto.StudioValueVarIdCondition

open class DtoEntActionRowUpdate : DtoEntAction() {
    var filterConditionVarId: StudioValueVarIdCondition? = null
    var layoutSpreadsheetId: MetaIdLayoutGrid? = null
    var lookupFieldId: MetaIdField? = null
    lateinit var spreadsheetFormId: MetaIdForm
    lateinit var spreadsheetId: MetaIdSpreadsheet
}
