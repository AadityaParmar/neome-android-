// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnKindScheduledEvent

open class StudioEntAutomationScheduledEvent : StudioEntAutomationEvent() {
    lateinit var fire: EnumDefnKindScheduledEvent
}
