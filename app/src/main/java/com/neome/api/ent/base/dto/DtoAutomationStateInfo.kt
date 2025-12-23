// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.Types.AutomationExecutionId
import java.util.Date
import com.neome.api.ent.base.Types.EnumAutomationStateKind
import com.neome.api.meta.base.Types.EnumDefnKindAutomation
import com.neome.api.meta.base.dto.EnvValidationError

open class DtoAutomationStateInfo
{
  lateinit var callerName: String
  var createdOn: String? = null
  lateinit var eventName: String
  lateinit var executionId: AutomationExecutionId
  var failureError: EnvValidationError? = null
  lateinit var kind: EnumDefnKindAutomation
  var message: String? = null
  lateinit var name: String
  lateinit var stateKind: EnumAutomationStateKind
  lateinit var stepName: String
  var updatedOn: String? = null
}