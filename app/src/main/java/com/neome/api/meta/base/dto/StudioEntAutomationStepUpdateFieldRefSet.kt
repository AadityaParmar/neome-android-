// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnRefSetOperationKind
import com.neome.api.meta.base.Types.EnumDefnSortOrder
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdGrid
import com.neome.api.meta.base.Types.MetaIdPipelineParam
import com.neome.api.meta.base.dto.StudioEntAutomationStep
import com.neome.api.meta.base.dto.StudioValueVarIdCondition

interface StudioEntAutomationStepUpdateFieldRefSet : StudioEntAutomationStep
{
  val inputFormPipelineVarId: MetaIdPipelineParam?
  val iterateOnGridFilterVarId: StudioValueVarIdCondition?
  val iterateOnGridId: MetaIdGrid?
  val operation: EnumDefnRefSetOperationKind?
  val outputFormPipelineVarId: MetaIdPipelineParam?
  val sortOrder: EnumDefnSortOrder?
  val sourceFieldId: MetaIdField?
  val targetFieldId: MetaIdField?
}