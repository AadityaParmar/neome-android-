// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.StudioDtoPluginApi
import com.neome.api.meta.base.dto.StudioEntAutomation
import com.neome.api.meta.base.dto.StudioEntAutomationPluginWebhookEventMap

interface StudioEntAutomationPluginWebhook : StudioEntAutomation
{
  val eventMap: StudioEntAutomationPluginWebhookEventMap
  val pluginApi: StudioDtoPluginApi
}