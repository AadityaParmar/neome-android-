// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.dto.StudioEntAutomationStepSendMessageBase
import com.neome.api.meta.base.dto.StudioValueVarIdParagraph

open class StudioEntAutomationStepSendWhatsappDynamicMessage : StudioEntAutomationStepSendMessageBase()
{
  var dataSourceFieldId: MetaIdField? = null
  var messageVarId: StudioValueVarIdParagraph? = null
}