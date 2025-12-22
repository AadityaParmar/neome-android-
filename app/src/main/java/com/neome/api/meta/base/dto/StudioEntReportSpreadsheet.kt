// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.Types.MetaIdVar

class StudioEntReportSpreadsheet : StudioEntReport() {
    var ascOrder: boolean? = null
    var filterConditionVarId: StudioValueVarIdCondition? = null
    var fromSpreadsheetId: MetaIdSpreadsheet? = null
    var limit: number? = null
    var orderByFieldId: MetaIdField? = null
    var outputFormMappingVarId: MetaIdVar? = null
}
