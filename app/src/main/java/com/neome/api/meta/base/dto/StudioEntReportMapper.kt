// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdReport
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.Types.MetaIdVar

class StudioEntReportMapper : StudioEntReport() {
    var inputFormMappingVarId: MetaIdVar? = null
    var mappedReportId: MetaIdReport? = null
    var outputFormMappingVarId: MetaIdVar? = null
    var saveToSpreadsheetId: MetaIdSpreadsheet? = null
}
