// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdPipelineParam
import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioEntAutomationStepSendMessageWithSenderField

open class StudioEntAutomationStepSendMessageToUsers : StudioEntAutomationStepSendMessageWithSenderField()
{
  var dataSourceRoleIdSet: Array<MetaIdRole>? = null
  var setOfUserVarId: MetaIdVar? = null
  var targetUserDataSourcePipelineVarId: MetaIdPipelineParam? = null
}