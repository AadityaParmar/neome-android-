// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import java.util.Date
import com.neome.api.meta.base.dto.DefnStudioMapOfDtoOption
import com.neome.api.meta.base.Types.EnumDefnKindAutoNode
import com.neome.api.ent.base.Types.EnumWorkflowResultKind
import com.neome.api.meta.base.dto.EnvValidationError
import com.neome.api.meta.base.Types.WorkflowExecutionId

open class DtoWorkflowExecutionStateInfo
{
  lateinit var callerName: String
  var canAdminResume: Boolean? = null
  var createdOn: String? = null
  lateinit var eventKind: EnumDefnKindAutoNode
  lateinit var executionId: WorkflowExecutionId
  var failureError: EnvValidationError? = null
  var message: String? = null
  lateinit var name: String
  lateinit var nodeName: String
  var resumeOptions: DefnStudioMapOfDtoOption? = null
  lateinit var stateKind: EnumWorkflowResultKind
  var updatedOn: String? = null
}