// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdPipelineParam
import com.neome.api.meta.base.Types.MetaIdSpreadsheet

open class StudioEntAutomationStepRemoveSpreadsheetRows : StudioEntAutomationStep() {
    var conditionVarId: StudioValueVarIdCondition? = null
    var inputFormPipelineVarId: MetaIdPipelineParam? = null
    var targetSpreadsheetId: MetaIdSpreadsheet? = null
}
