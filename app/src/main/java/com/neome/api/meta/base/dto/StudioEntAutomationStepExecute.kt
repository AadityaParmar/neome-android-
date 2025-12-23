// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdAutomation
import com.neome.api.meta.base.Types.MetaIdGrid
import com.neome.api.meta.base.Types.MetaIdPipelineParam
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioEntAutomationStep
import com.neome.api.meta.base.dto.StudioValueVarIdCondition

open class StudioEntAutomationStepExecute : StudioEntAutomationStep()
{
  var automationId: MetaIdAutomation? = null
  var exposeOutputAsPipelineVariable: Boolean? = null
  var inputFormPipelineVarId: MetaIdPipelineParam? = null
  var iterateOnGridFilterVarId: StudioValueVarIdCondition? = null
  var iterateOnGridId: MetaIdGrid? = null
  var outputFormPipelineVarId: MetaIdPipelineParam? = null
  var sourceToTargetMappingVarId: MetaIdVar? = null
  var targetToSourceMappingVarId: MetaIdVar? = null
}