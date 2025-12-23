// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdPipelineParam
import com.neome.api.meta.base.dto.StudioEntAutomationStep

open class StudioEntAutomationStepClearPipeline : StudioEntAutomationStep()
{
  var pipelineParamSet: Array<MetaIdPipelineParam>? = null
}