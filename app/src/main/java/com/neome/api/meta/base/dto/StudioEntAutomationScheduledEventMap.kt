// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdEvent

interface StudioEntAutomationScheduledEventMap : StudioBase {
    val keys: List<MetaIdEvent>
    val map: Map<MetaIdEvent, StudioEntAutomationScheduledEvent>
}
