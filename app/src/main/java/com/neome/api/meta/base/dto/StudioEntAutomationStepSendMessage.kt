// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdGroup
import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.dto.StudioEntAutomationStepSendMessageBase
import com.neome.api.meta.base.dto.StudioValueVarIdParagraph

interface StudioEntAutomationStepSendMessage : StudioEntAutomationStepSendMessageBase
{
  val groupIdSet: List<MetaIdGroup>?
  val messageVarId: StudioValueVarIdParagraph?
  val sendAsComment: Boolean?
  val senderFieldId: MetaIdField?
  val senderRoleId: MetaIdRole?
}