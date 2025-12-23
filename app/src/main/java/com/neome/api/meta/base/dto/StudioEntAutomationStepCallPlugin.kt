// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdGrid
import com.neome.api.meta.base.Types.MetaIdPipelineParam
import com.neome.api.meta.base.Types.MetaIdPlugin
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.Types.PluginApiId

open class StudioEntAutomationStepCallPlugin : StudioEntAutomationStep() {
    var errorFieldId: MetaIdField? = null
    var errorRetryCountVarId: MetaIdVar? = null
    var errorRetryDurationVarId: MetaIdVar? = null
    var exposeOutputAsPipelineVariable: Boolean? = null
    var inputFormPipelineVarId: MetaIdPipelineParam? = null
    var iterateOnGridFilterVarId: StudioValueVarIdCondition? = null
    var iterateOnGridId: MetaIdGrid? = null
    var outputFormPipelineVarId: MetaIdPipelineParam? = null
    var pluginInputMappingVarId: MetaIdVar? = null
    var pluginOutputMappingVarId: MetaIdVar? = null
    var targetPluginApiId: PluginApiId? = null
    var targetPluginId: MetaIdPlugin? = null
}
