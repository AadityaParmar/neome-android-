// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdLayoutGrid
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.Types.MetaIdSpreadsheetRef

class StudioSpreadsheetRef : StudioComposite() {
    var filterConditionVarId: StudioValueVarIdCondition? = null
    var layoutSpreadsheetId: MetaIdLayoutGrid? = null
    var maxRecords: number? = null
    val metaId: MetaIdSpreadsheetRef
    var refTargetFieldId: MetaIdField? = null
    var rowActionPermissionMap: StudioMapOfActionPermission? = null
    var spreadsheetId: MetaIdSpreadsheet? = null
}
