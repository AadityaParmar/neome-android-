// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdAction
import com.neome.api.meta.base.Types.MetaIdDeeplink
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdGrid
import com.neome.api.meta.base.Types.MetaIdPipelineParam
import com.neome.api.meta.base.Types.MetaIdVar

class StudioEntAutomationStepGenerateDeeplink : StudioEntAutomationStep() {
    var deeplinkFieldId: MetaIdField? = null
    var deeplinkId: MetaIdDeeplink? = null
    var inputFormMappingVarId: MetaIdVar? = null
    var inputFormPipelineVarId: MetaIdPipelineParam? = null
    var iterateOnGridFilterVarId: StudioValueVarIdCondition? = null
    var iterateOnGridId: MetaIdGrid? = null
    var outputFormPipelineVarId: MetaIdPipelineParam? = null
    var spreadsheetEditorActionId: MetaIdAction? = null
}
