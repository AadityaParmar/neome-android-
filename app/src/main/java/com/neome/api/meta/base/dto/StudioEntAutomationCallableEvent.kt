// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnKindCallableEvent
import com.neome.api.meta.base.dto.StudioEntAutomationEvent

interface StudioEntAutomationCallableEvent : StudioEntAutomationEvent
{
  val fire: EnumDefnKindCallableEvent
}