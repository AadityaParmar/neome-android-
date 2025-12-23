// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdGrid
import com.neome.api.meta.base.Types.MetaIdPipelineParam
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioEntAutomationStep
import com.neome.api.meta.base.dto.StudioValueVarIdCondition

open class StudioEntAutomationStepCopyField : StudioEntAutomationStep()
{
  var mappingVarId: MetaIdVar? = null
  var sourceGridFilterVarId: StudioValueVarIdCondition? = null
  var sourceGridId: MetaIdGrid? = null
  var sourcePipelineVarId: MetaIdPipelineParam? = null
  var targetPipelineVarId: MetaIdPipelineParam? = null
}