// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types.MetaIdEvent
import com.neome.api.meta.base.Types.MetaIdPipelineParam

class StudioEntAutomationEvent : StudioBase() {
    var description: string? = null
    var executionConditionInputPipelineVarId: MetaIdPipelineParam? = null
    var executionConditionVarId: StudioValueVarIdCondition? = null
    val metaId: MetaIdEvent
    val name: Symbol
    var pipelineVarMap: StudioEntPipelineVarMap? = null
    var secondary: string? = null
    val stepMap: StudioEntAutomationStepMap
}
