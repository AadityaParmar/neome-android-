// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdEvent
import com.neome.api.meta.base.Types.MetaIdPipelineParam
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEntAutomationStepMap
import com.neome.api.meta.base.dto.StudioEntPipelineVarMap
import com.neome.api.meta.base.dto.StudioValueVarIdCondition
import com.neome.api.meta.base.Symbol

interface StudioEntAutomationEvent : StudioBase
{
  val description: String?
  val executionConditionInputPipelineVarId: MetaIdPipelineParam?
  val executionConditionVarId: StudioValueVarIdCondition?
  val metaId: MetaIdEvent
  val name: Symbol
  val pipelineVarMap: StudioEntPipelineVarMap?
  val secondary: String?
  val stepMap: StudioEntAutomationStepMap
}