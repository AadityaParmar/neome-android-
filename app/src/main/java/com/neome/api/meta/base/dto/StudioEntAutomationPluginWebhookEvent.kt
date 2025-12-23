// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnKindPluginWebhookEvent

open class StudioEntAutomationPluginWebhookEvent : StudioEntAutomationEvent() {
    lateinit var fire: EnumDefnKindPluginWebhookEvent
}
