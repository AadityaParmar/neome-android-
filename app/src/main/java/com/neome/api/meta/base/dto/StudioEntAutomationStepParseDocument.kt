// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdGrid
import com.neome.api.meta.base.Types.MetaIdPipelineParam
import com.neome.api.meta.base.Types.MetaIdVar

class StudioEntAutomationStepParseDocument : StudioEntAutomationStep() {
    var aiInstructions: string? = null
    var documentFieldId: MetaIdField? = null
    var exposeOutputAsPipelineVariable: boolean? = null
    var inputFormPipelineVarId: MetaIdPipelineParam? = null
    var iterateOnGridFilterVarId: StudioValueVarIdCondition? = null
    var iterateOnGridId: MetaIdGrid? = null
    var outputFormPipelineVarId: MetaIdPipelineParam? = null
    var outputMappingVarId: MetaIdVar? = null
    var schemaFormId: MetaIdForm? = null
}
