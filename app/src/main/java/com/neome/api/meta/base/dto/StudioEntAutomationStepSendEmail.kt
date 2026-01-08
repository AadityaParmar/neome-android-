// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioEntAutomationStepSendMessageBase
import com.neome.api.meta.base.dto.StudioValueVarIdParagraph
import com.neome.api.meta.base.dto.StudioValueVarIdText

interface StudioEntAutomationStepSendEmail : StudioEntAutomationStepSendMessageBase
{
  val bccFieldIdSet: Array<MetaIdField>?
  val bccSetOfUserVarId: MetaIdVar?
  val ccFieldIdSet: Array<MetaIdField>?
  val ccSetOfUserVarId: MetaIdVar?
  val mediaFieldId: MetaIdField?
  val messageVarId: StudioValueVarIdParagraph?
  val replyToFieldId: MetaIdField?
  val replyToSetOfUserVarId: MetaIdVar?
  val subjectVarId: StudioValueVarIdText?
  val toFieldIdSet: Array<MetaIdField>?
}