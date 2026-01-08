// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import java.util.Map
import com.neome.api.meta.base.Types.MetaIdEvent
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioEntAutomationWebhookEvent

interface StudioEntAutomationWebhookEventMap : StudioBase
{
  val keys: Array<MetaIdEvent>
  val map: Map<MetaIdEvent, StudioEntAutomationWebhookEvent>
}