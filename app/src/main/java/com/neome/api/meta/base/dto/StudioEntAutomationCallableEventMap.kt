// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdEvent
import java.util.Map

open class StudioEntAutomationCallableEventMap : StudioBase() {
    lateinit var keys: Array<MetaIdEvent>
    lateinit var map: Map<MetaIdEvent, StudioEntAutomationCallableEvent>
}
