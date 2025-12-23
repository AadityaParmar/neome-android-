// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.sig

import com.neome.api.ent.base.dto.AutomationStepSummary
import com.neome.api.ent.base.dto.DtoAutomationVariableInfo
import com.neome.api.meta.base.Types.AutomationExecutionId
import com.neome.api.nucleus.base.sig.Sig

open class SigAutomationState : Sig() {
    lateinit var executionId: AutomationExecutionId
    var summaryList: Array<AutomationStepSummary>? = null
    var variables: Array<DtoAutomationVariableInfo>? = null
}
