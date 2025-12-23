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

open class StudioEntAutomationStep : StudioBase() {
    var description: String? = null
    var executionConditionInputPipelineVarId: MetaIdPipelineParam? = null
    var executionConditionVarId: StudioValueVarIdCondition? = null
    lateinit var kind: EnumDefnKindAutomationStep
    lateinit var metaId: MetaIdStep
    lateinit var name: Symbol
    var skipUpdateSpreadsheetTrigger: Boolean? = null
    var terminateFieldId: MetaIdField? = null
    var terminateKind: EnumDefnAutomationTerminateKind? = null
}
