// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdGrid
import com.neome.api.meta.base.Types.MetaIdPipelineParam
import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioEntAutomationStep
import com.neome.api.meta.base.dto.StudioValueVarIdCondition

open class StudioEntAutomationStepUpdateUser : StudioEntAutomationStep()
{
  var avatarFieldId: MetaIdField? = null
  var inputFormPipelineVarId: MetaIdPipelineParam? = null
  var iterateOnGridFilterVarId: StudioValueVarIdCondition? = null
  var iterateOnGridId: MetaIdGrid? = null
  var managerFieldId: MetaIdField? = null
  var managerVarId: MetaIdVar? = null
  var userActivateFieldId: MetaIdField? = null
  var userActivateVarId: MetaIdVar? = null
  var userIdFieldId: MetaIdField? = null
  var userNameFieldId: MetaIdField? = null
  var userRoleFieldId: MetaIdField? = null
  var userRoleIdSet: Array<MetaIdRole>? = null
}