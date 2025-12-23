// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdAutomation
import com.neome.api.meta.base.Types.MetaIdPipelineParam
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioEntAutomationStep

open class StudioEntAutomationStepExecuteAsync : StudioEntAutomationStep()
{
  var automationId: MetaIdAutomation? = null
  var inputFormPipelineVarId: MetaIdPipelineParam? = null
  var sourceToTargetMappingVarId: MetaIdVar? = null
}