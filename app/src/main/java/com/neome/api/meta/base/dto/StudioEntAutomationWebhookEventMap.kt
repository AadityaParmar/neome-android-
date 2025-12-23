// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
import com.neome.api.meta.base.Types.MetaIdEvent
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEntAutomationWebhookEvent

open class StudioEntAutomationWebhookEventMap : StudioBase()
{
  lateinit var keys: Array<MetaIdEvent>
  lateinit var map: Map<MetaIdEvent, StudioEntAutomationWebhookEvent>
}