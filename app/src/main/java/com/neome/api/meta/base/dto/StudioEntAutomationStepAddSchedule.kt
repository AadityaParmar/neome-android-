// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdAutomation
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdPipelineParam
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioEntAutomationStep

interface StudioEntAutomationStepAddSchedule : StudioEntAutomationStep
{
  val automationId: MetaIdAutomation?
  val dateTimeFieldId: MetaIdField?
  val inputFormPipelineVarId: MetaIdPipelineParam?
  val outputFormPipelineVarId: MetaIdPipelineParam?
  val schedulerFieldId: MetaIdField?
  val sourceToTargetMappingVarId: MetaIdVar?
}