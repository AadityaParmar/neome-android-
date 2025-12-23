// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdGrid
import com.neome.api.meta.base.Types.MetaIdPipelineParam
import com.neome.api.meta.base.Types.MetaIdSpreadsheet

open class StudioEntAutomationStepRemoveFromSpreadsheet : StudioEntAutomationStep() {
    var inputFormPipelineVarId: MetaIdPipelineParam? = null
    var iterateOnGridFilterVarId: StudioValueVarIdCondition? = null
    var iterateOnGridId: MetaIdGrid? = null
    var rowIdFieldId: MetaIdField? = null
    var targetSpreadsheetId: MetaIdSpreadsheet? = null
}
