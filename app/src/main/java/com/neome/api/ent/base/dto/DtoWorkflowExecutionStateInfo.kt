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

interface DtoWorkflowExecutionStateInfo
{
  val callerName: String
  val canAdminResume: Boolean?
  val createdOn: String?
  val eventKind: EnumDefnKindAutoNode
  val executionId: WorkflowExecutionId
  val failureError: EnvValidationError?
  val message: String?
  val name: String
  val nodeName: String
  val resumeOptions: DefnStudioMapOfDtoOption?
  val stateKind: EnumWorkflowResultKind
  val updatedOn: String?
}