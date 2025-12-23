// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdGroup
import com.neome.api.meta.base.Types.MetaIdRole

open class StudioEntAutomationStepSendMessage : StudioEntAutomationStepSendMessageBase() {
    var groupIdSet: Array<MetaIdGroup>? = null
    var messageVarId: StudioValueVarIdParagraph? = null
    var sendAsComment: Boolean? = null
    var senderFieldId: MetaIdField? = null
    var senderRoleId: MetaIdRole? = null
}
