// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnKindWebhookEvent
import com.neome.api.meta.base.dto.StudioEntAutomationEvent

open class StudioEntAutomationWebhookEvent : StudioEntAutomationEvent()
{
  lateinit var fire: EnumDefnKindWebhookEvent
}