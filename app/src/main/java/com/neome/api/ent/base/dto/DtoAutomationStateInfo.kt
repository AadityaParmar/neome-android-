// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.ent.base.Types.EnumAutomationStateKind
import com.neome.api.meta.base.Types.AutomationExecutionId
import com.neome.api.meta.base.Types.EnumDefnKindAutomation
import com.neome.api.meta.base.dto.EnvValidationError

class DtoAutomationStateInfo {
    val callerName: string
    var createdOn: string? = null
    val eventName: string
    val executionId: AutomationExecutionId
    var failureError: EnvValidationError? = null
    val kind: EnumDefnKindAutomation
    var message: string? = null
    val name: string
    val stateKind: EnumAutomationStateKind
    val stepName: string
    var updatedOn: string? = null
}
