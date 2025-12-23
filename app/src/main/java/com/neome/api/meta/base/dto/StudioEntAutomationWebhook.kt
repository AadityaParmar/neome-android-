// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnAutomationWebhookKind
import com.neome.api.meta.base.Types.MetaIdSpreadsheet

open class StudioEntAutomationWebhook : StudioEntAutomation() {
    lateinit var callbackKind: EnumDefnAutomationWebhookKind
    lateinit var eventMap: StudioEntAutomationWebhookEventMap
    var locationConfig: StudioDtoLocationCapture? = null
    var spreadsheetId: MetaIdSpreadsheet? = null
}
