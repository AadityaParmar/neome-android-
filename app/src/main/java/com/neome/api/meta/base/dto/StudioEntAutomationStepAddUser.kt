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

interface StudioEntAutomationStepAddUser : StudioEntAutomationStep
{
  val avatarFieldId: MetaIdField?
  val inputFormPipelineVarId: MetaIdPipelineParam?
  val iterateOnGridFilterVarId: StudioValueVarIdCondition?
  val iterateOnGridId: MetaIdGrid?
  val managerFieldId: MetaIdField?
  val managerVarId: MetaIdVar?
  val outputFormMappingVarId: MetaIdVar?
  val outputFormPipelineVarId: MetaIdPipelineParam?
  val userHandleFieldId: MetaIdField?
  val userNameFieldId: MetaIdField?
  val userRoleFieldId: MetaIdField?
  val userRoleIdSet: List<MetaIdRole>?
}