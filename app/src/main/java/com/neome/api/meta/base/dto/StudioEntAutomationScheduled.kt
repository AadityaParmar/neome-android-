// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.StudioEntAutomation
import com.neome.api.meta.base.dto.StudioEntAutomationScheduledEventMap
import com.neome.api.meta.base.dto.StudioVarValueScheduler

open class StudioEntAutomationScheduled : StudioEntAutomation()
{
  lateinit var eventMap: StudioEntAutomationScheduledEventMap
  var scheduler: StudioVarValueScheduler? = null
}