// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdGrid
import com.neome.api.meta.base.Types.MetaIdPipelineParam
import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioEntAutomationStep
import com.neome.api.meta.base.dto.StudioValueVarIdCondition

open class StudioEntAutomationStepSendMessageBase : StudioEntAutomationStep()
{
  var dataSourceRoleIdSet: Array<MetaIdRole>? = null
  var inputFormPipelineVarId: MetaIdPipelineParam? = null
  var iterateOnGridFilterVarId: StudioValueVarIdCondition? = null
  var iterateOnGridId: MetaIdGrid? = null
  var setOfUserVarId: MetaIdVar? = null
  var targetDataSourcePipelineVarId: MetaIdPipelineParam? = null
}