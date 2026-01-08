// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnLogOperationKind
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdPipelineParam
import com.neome.api.meta.base.Types.MetaIdSpreadsheet
import com.neome.api.meta.base.dto.StudioBuildArgBinderHolder
import com.neome.api.meta.base.dto.StudioEntAutomationStep
import com.neome.api.meta.base.dto.StudioValueVarIdText

interface StudioEntAutomationStepUpdateFieldLogNumber : StudioEntAutomationStep
{
  val customMessageVarId: StudioValueVarIdText?
  val operation: EnumDefnLogOperationKind?
  val rowFieldId: MetaIdField?
  val sourcePipelineVarId: MetaIdPipelineParam?
  val targetFieldId: MetaIdField?
  val targetSpreadsheetId: MetaIdSpreadsheet?
  val value: StudioBuildArgBinderHolder?
}