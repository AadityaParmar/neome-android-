// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnAutomationWebhookKind
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.dto.StudioDtoLocationCapture
import com.neome.api.meta.base.dto.StudioEntAutomation
import com.neome.api.meta.base.dto.StudioEntAutomationWebhookEventMap

class StudioEntAutomationWebhook : StudioEntAutomation() {
    val callbackKind: EnumDefnAutomationWebhookKind
    val eventMap: StudioEntAutomationWebhookEventMap
    var locationConfig: StudioDtoLocationCapture? = null
    var spreadsheetId: MetaIdSpreadsheet? = null
}
