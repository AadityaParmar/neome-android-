// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAutoStepWithOutput
import com.neome.api.meta.base.Types.EnumDefnNodeTerminateKind

interface EntVdAutoStepWithOutputAndError : EntVdAutoStepWithOutput
{
  val terminateKind: EnumDefnNodeTerminateKind?
}