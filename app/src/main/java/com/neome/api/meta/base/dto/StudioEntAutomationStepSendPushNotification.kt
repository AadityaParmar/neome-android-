// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.StudioEntAutomationStepSendMessageBase
import com.neome.api.meta.base.dto.StudioValueVarIdParagraph
import com.neome.api.meta.base.dto.StudioValueVarIdText

open class StudioEntAutomationStepSendPushNotification : StudioEntAutomationStepSendMessageBase()
{
  var messageVarId: StudioValueVarIdParagraph? = null
  var sendCustomMessage: Boolean? = null
  var titleVarId: StudioValueVarIdText? = null
}