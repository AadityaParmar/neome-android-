// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdGrid
import com.neome.api.meta.base.Types.MetaIdLayoutForm
import com.neome.api.meta.base.Types.MetaIdPipelineParam
import com.neome.api.meta.base.Types.MetaIdVar

class StudioEntAutomationStepGenerateDocument : StudioEntAutomationStep() {
    var contentLayoutId: MetaIdLayoutForm? = null
    var fileNameVarId: StudioValueVarIdText? = null
    var inputFormMappingVarId: MetaIdVar? = null
    var inputFormPipelineVarId: MetaIdPipelineParam? = null
    var iterateOnGridFilterVarId: StudioValueVarIdCondition? = null
    var iterateOnGridId: MetaIdGrid? = null
    var outputFormPipelineVarId: MetaIdPipelineParam? = null
    var templateLayoutId: MetaIdLayoutForm? = null
}
