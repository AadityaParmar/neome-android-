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

open class StudioEntAutomationEvent : StudioBase()
{
  var description: String? = null
  var executionConditionInputPipelineVarId: MetaIdPipelineParam? = null
  var executionConditionVarId: StudioValueVarIdCondition? = null
  lateinit var metaId: MetaIdEvent
  lateinit var name: Symbol
  var pipelineVarMap: StudioEntPipelineVarMap? = null
  var secondary: String? = null
  lateinit var stepMap: StudioEntAutomationStepMap
}