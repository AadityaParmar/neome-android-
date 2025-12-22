// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnKindWebhookEvent
import com.neome.api.meta.base.dto.StudioEntAutomationEvent

class StudioEntAutomationWebhookEvent : StudioEntAutomationEvent() {
    val fire: EnumDefnKindWebhookEvent
}
