// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdGroup

open class StudioEntAutomationStepSendMessageToGroups :
    StudioEntAutomationStepSendMessageWithSenderField() {
    var groupIdSet: Array<MetaIdGroup>? = null
}
