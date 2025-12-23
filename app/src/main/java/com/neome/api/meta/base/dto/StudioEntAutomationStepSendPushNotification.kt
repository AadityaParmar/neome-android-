// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

open class StudioEntAutomationStepSendPushNotification : StudioEntAutomationStepSendMessageBase() {
    var messageVarId: StudioValueVarIdParagraph? = null
    var sendCustomMessage: Boolean? = null
    var titleVarId: StudioValueVarIdText? = null
}
