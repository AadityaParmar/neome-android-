// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.Types.AutomationExecutionId
import com.neome.api.ent.base.Types.EnumAutomationStateKind
import com.neome.api.meta.base.Types.EnumDefnKindAutomation
import com.neome.api.meta.base.dto.EnvValidationError

interface DtoAutomationStateInfo
{
  val callerName: String
  val createdOn: String?
  val eventName: String
  val executionId: AutomationExecutionId
  val failureError: EnvValidationError?
  val kind: EnumDefnKindAutomation
  val message: String?
  val name: String
  val stateKind: EnumAutomationStateKind
  val stepName: String
  val updatedOn: String?
}