// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

open class StudioEntAutomationPluginWebhook : StudioEntAutomation() {
    lateinit var eventMap: StudioEntAutomationPluginWebhookEventMap
    lateinit var pluginApi: StudioDtoPluginApi
}
