// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdGrid
import com.neome.api.meta.base.Types.MetaIdPipelineParam
import com.neome.api.meta.base.Types.MetaIdReport
import com.neome.api.meta.base.Types.MetaIdVar

open class StudioEntAutomationStepCallReport : StudioEntAutomationStep() {
    var errorFieldId: MetaIdField? = null
    var errorRetryCountVarId: MetaIdVar? = null
    var errorRetryDurationVarId: MetaIdVar? = null
    var exposeOutputAsPipelineVariable: Boolean? = null
    var inputFormPipelineVarId: MetaIdPipelineParam? = null
    var iterateOnGridFilterVarId: StudioValueVarIdCondition? = null
    var iterateOnGridId: MetaIdGrid? = null
    var outputPipelineVarId: MetaIdPipelineParam? = null
    var reportInputMappingVarId: MetaIdVar? = null
    var reportOutputMappingVarId: MetaIdVar? = null
    var targetReportId: MetaIdReport? = null
}
