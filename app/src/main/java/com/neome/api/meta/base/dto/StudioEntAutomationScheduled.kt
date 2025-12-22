// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

class StudioEntAutomationScheduled : StudioEntAutomation() {
    val eventMap: StudioEntAutomationScheduledEventMap
    var scheduler: StudioVarValueScheduler? = null
}
