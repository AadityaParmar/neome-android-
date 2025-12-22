// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.ent.base.Types.EnumWorkflowResultKind
import com.neome.api.meta.base.Types.EnumDefnKindAutoNode
import com.neome.api.meta.base.Types.WorkflowExecutionId
import com.neome.api.meta.base.dto.DefnStudioMapOfDtoOption
import com.neome.api.meta.base.dto.EnvValidationError

class DtoWorkflowExecutionStateInfo {
    val callerName: string
    var canAdminResume: boolean? = null
    var createdOn: string? = null
    val eventKind: EnumDefnKindAutoNode
    val executionId: WorkflowExecutionId
    var failureError: EnvValidationError? = null
    var message: string? = null
    val name: string
    val nodeName: string
    var resumeOptions: DefnStudioMapOfDtoOption? = null
    val stateKind: EnumWorkflowResultKind
    var updatedOn: string? = null
}
