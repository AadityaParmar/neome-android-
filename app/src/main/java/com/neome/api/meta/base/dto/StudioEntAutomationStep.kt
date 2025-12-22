// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types.EnumDefnAutomationTerminateKind
import com.neome.api.meta.base.Types.EnumDefnKindAutomationStep
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdPipelineParam
import com.neome.api.meta.base.Types.MetaIdStep

class StudioEntAutomationStep : StudioBase() {
    var description: string? = null
    var executionConditionInputPipelineVarId: MetaIdPipelineParam? = null
    var executionConditionVarId: StudioValueVarIdCondition? = null
    val kind: EnumDefnKindAutomationStep
    val metaId: MetaIdStep
    val name: Symbol
    var skipUpdateSpreadsheetTrigger: boolean? = null
    var terminateFieldId: MetaIdField? = null
    var terminateKind: EnumDefnAutomationTerminateKind? = null
}
