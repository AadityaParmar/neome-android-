// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdGrid
import com.neome.api.meta.base.Types.MetaIdPipelineParam
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.Types.MetaIdVar

open class StudioEntAutomationStepInsertIntoSpreadsheet : StudioEntAutomationStep() {
    var exposeOutputAsPipelineVariable: Boolean? = null
    var inputFormPipelineVarId: MetaIdPipelineParam? = null
    var iterateOnGridFilterVarId: StudioValueVarIdCondition? = null
    var iterateOnGridId: MetaIdGrid? = null
    var outputFormPipelineVarId: MetaIdPipelineParam? = null
    var sourceToTargetMappingVarId: MetaIdVar? = null
    var targetSpreadsheetId: MetaIdSpreadsheet? = null
    var targetToSourceMappingVarId: MetaIdVar? = null
}
