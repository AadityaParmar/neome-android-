// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnAutomationTerminateKind
import com.neome.api.meta.base.Types.EnumDefnKindAutomationStep
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdPipelineParam
import com.neome.api.meta.base.Types.MetaIdStep
import com.neome.api.meta.base.dto.StudioBase
import com.neome.api.meta.base.dto.StudioValueVarIdCondition
import com.neome.api.meta.base.Symbol

interface StudioEntAutomationStep : StudioBase
{
  val description: String?
  val executionConditionInputPipelineVarId: MetaIdPipelineParam?
  val executionConditionVarId: StudioValueVarIdCondition?
  val kind: EnumDefnKindAutomationStep
  val metaId: MetaIdStep
  val name: Symbol
  val skipUpdateSpreadsheetTrigger: Boolean?
  val terminateFieldId: MetaIdField?
  val terminateKind: EnumDefnAutomationTerminateKind?
}