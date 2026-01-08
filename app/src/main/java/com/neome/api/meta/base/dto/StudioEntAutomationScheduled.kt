// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.StudioEntAutomation
import com.neome.api.meta.base.dto.StudioEntAutomationScheduledEventMap
import com.neome.api.meta.base.dto.StudioVarValueScheduler

interface StudioEntAutomationScheduled : StudioEntAutomation
{
  val eventMap: StudioEntAutomationScheduledEventMap
  val scheduler: StudioVarValueScheduler?
}