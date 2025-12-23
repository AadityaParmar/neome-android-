// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar

open class StudioEntAutomationStepSendEmail : StudioEntAutomationStepSendMessageBase() {
    var bccFieldIdSet: Array<MetaIdField>? = null
    var bccSetOfUserVarId: MetaIdVar? = null
    var ccFieldIdSet: Array<MetaIdField>? = null
    var ccSetOfUserVarId: MetaIdVar? = null
    var mediaFieldId: MetaIdField? = null
    var messageVarId: StudioValueVarIdParagraph? = null
    var replyToFieldId: MetaIdField? = null
    var replyToSetOfUserVarId: MetaIdVar? = null
    var subjectVarId: StudioValueVarIdText? = null
    var toFieldIdSet: Array<MetaIdField>? = null
}
