// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdGrid
import com.neome.api.meta.base.Types.MetaIdPipelineParam
import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.dto.StudioEntAutomationStep
import com.neome.api.meta.base.dto.StudioValueVarIdCondition
import com.neome.api.meta.base.dto.StudioValueVarIdParagraph

interface StudioEntAutomationStepSendMessageWithSenderField : StudioEntAutomationStep
{
  val inputFormPipelineVarId: MetaIdPipelineParam?
  val iterateOnGridFilterVarId: StudioValueVarIdCondition?
  val iterateOnGridId: MetaIdGrid?
  val messageVarId: StudioValueVarIdParagraph?
  val senderFieldId: MetaIdField?
  val senderRoleId: MetaIdRole?
}