// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdGrid
import com.neome.api.meta.base.Types.MetaIdPipelineParam
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioEntAutomationStep
import com.neome.api.meta.base.dto.StudioValueVarIdCondition

interface StudioEntAutomationStepCopyField : StudioEntAutomationStep
{
  val mappingVarId: MetaIdVar?
  val sourceGridFilterVarId: StudioValueVarIdCondition?
  val sourceGridId: MetaIdGrid?
  val sourcePipelineVarId: MetaIdPipelineParam?
  val targetPipelineVarId: MetaIdPipelineParam?
}