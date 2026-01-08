// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdPipelineParam
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.dto.StudioEntAutomationStep
import com.neome.api.meta.base.dto.StudioValueVarIdCondition

interface StudioEntAutomationStepRemoveSpreadsheetRows : StudioEntAutomationStep
{
  val conditionVarId: StudioValueVarIdCondition?
  val inputFormPipelineVarId: MetaIdPipelineParam?
  val targetSpreadsheetId: MetaIdSpreadsheet?
}