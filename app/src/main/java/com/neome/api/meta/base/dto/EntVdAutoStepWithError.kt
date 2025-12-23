// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAutoStep
import com.neome.api.meta.base.Types.EnumDefnNodeTerminateKind

open class EntVdAutoStepWithError : EntVdAutoStep()
{
  var terminateKind: EnumDefnNodeTerminateKind? = null
}