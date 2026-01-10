// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar

interface StudioEntAutomationStepSendEmail : StudioEntAutomationStepSendMessageBase {
    val bccFieldIdSet: List<MetaIdField>?
    val bccSetOfUserVarId: MetaIdVar?
    val ccFieldIdSet: List<MetaIdField>?
    val ccSetOfUserVarId: MetaIdVar?
    val mediaFieldId: MetaIdField?
    val messageVarId: StudioValueVarIdParagraph?
    val replyToFieldId: MetaIdField?
    val replyToSetOfUserVarId: MetaIdVar?
    val subjectVarId: StudioValueVarIdText?
    val toFieldIdSet: List<MetaIdField>?
}
