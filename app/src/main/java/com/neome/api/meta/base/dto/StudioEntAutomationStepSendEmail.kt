// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar

class StudioEntAutomationStepSendEmail : StudioEntAutomationStepSendMessageBase() {
    var bccFieldIdSet: MetaIdField[]? = null
    var bccSetOfUserVarId: MetaIdVar? = null
    var ccFieldIdSet: MetaIdField[]? = null
    var ccSetOfUserVarId: MetaIdVar? = null
    var mediaFieldId: MetaIdField? = null
    var messageVarId: StudioValueVarIdParagraph? = null
    var replyToFieldId: MetaIdField? = null
    var replyToSetOfUserVarId: MetaIdVar? = null
    var subjectVarId: StudioValueVarIdText? = null
    var toFieldIdSet: MetaIdField[]? = null
}
