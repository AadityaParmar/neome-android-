// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdGrid
import com.neome.api.meta.base.Types.MetaIdLayoutForm
import com.neome.api.meta.base.Types.MetaIdPipelineParam
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioEntAutomationStep
import com.neome.api.meta.base.dto.StudioValueVarIdCondition
import com.neome.api.meta.base.dto.StudioValueVarIdText

interface StudioEntAutomationStepGenerateDocument : StudioEntAutomationStep
{
  val contentLayoutId: MetaIdLayoutForm?
  val fileNameVarId: StudioValueVarIdText?
  val inputFormMappingVarId: MetaIdVar?
  val inputFormPipelineVarId: MetaIdPipelineParam?
  val iterateOnGridFilterVarId: StudioValueVarIdCondition?
  val iterateOnGridId: MetaIdGrid?
  val outputFormPipelineVarId: MetaIdPipelineParam?
  val templateLayoutId: MetaIdLayoutForm?
}