// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdGroup
import com.neome.api.meta.base.Types.MetaIdRole

class StudioEntAutomationStepSendMessage : StudioEntAutomationStepSendMessageBase() {
    var groupIdSet: MetaIdGroup[]? = null
    var messageVarId: StudioValueVarIdParagraph? = null
    var sendAsComment: boolean? = null
    var senderFieldId: MetaIdField? = null
    var senderRoleId: MetaIdRole? = null
}
