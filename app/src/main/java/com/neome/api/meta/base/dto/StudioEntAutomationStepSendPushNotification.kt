// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

class StudioEntAutomationStepSendPushNotification : StudioEntAutomationStepSendMessageBase() {
    var messageVarId: StudioValueVarIdParagraph? = null
    var sendCustomMessage: boolean? = null
    var titleVarId: StudioValueVarIdText? = null
}
