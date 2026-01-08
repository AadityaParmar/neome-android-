// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.dto.StudioEntAutomationStepSendMessageBase
import com.neome.api.meta.base.dto.StudioMapOfVarIdText

interface StudioEntAutomationStepSendWhatsappTemplateMessage : StudioEntAutomationStepSendMessageBase
{
  val carouselCardMessageVarMap: StudioMapOfVarIdText?
  val dataSourceFieldId: MetaIdField?
  val mediaFieldId: MetaIdField?
  val messageVarMap: StudioMapOfVarIdText?
  val templateGroupId: String?
}