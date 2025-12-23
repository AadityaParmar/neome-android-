// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAutoStepWithError
import com.neome.api.meta.base.dto.EntVdWorkflowControlMap
import com.neome.api.meta.base.Types.EnumDefnKindAutoResponseWait

open class EntVdExecuteParallel : EntVdAutoStepWithError()
{
  var responseWaitKind: EnumDefnKindAutoResponseWait? = null
  var workflowControlMap: EntVdWorkflowControlMap? = null
}