// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAutoStepWithError
import com.neome.api.meta.base.dto.EntVdWorkflowControlMap
import com.neome.api.meta.base.Types.EnumDefnKindAutoResponseWait

interface EntVdExecuteParallel : EntVdAutoStepWithError
{
  val responseWaitKind: EnumDefnKindAutoResponseWait?
  val workflowControlMap: EntVdWorkflowControlMap?
}