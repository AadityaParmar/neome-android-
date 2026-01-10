// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.entMain.sig

import com.neome.api.ent.base.dto.AutomationStepSummary
import com.neome.api.ent.base.dto.DtoAutomationVariableInfo
import com.neome.api.meta.base.Types.AutomationExecutionId
import com.neome.api.nucleus.base.sig.Sig

interface SigAutomationState : Sig {
    val executionId: AutomationExecutionId
    val summaryList: List<AutomationStepSummary>?
    val variables: List<DtoAutomationVariableInfo>?
}
