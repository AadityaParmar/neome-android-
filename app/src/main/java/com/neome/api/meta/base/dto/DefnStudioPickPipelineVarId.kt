// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.DefnFieldEditable
import com.neome.api.meta.base.dto.DefnStudioMapOfDtoOption
import com.neome.api.meta.base.Types.EnumDefnPipelineFormKind
import com.neome.api.meta.base.Types.MetaIdAutomation
import com.neome.api.meta.base.Types.MetaIdEvent
import com.neome.api.meta.base.Types.MetaIdPipelineVar
import com.neome.api.meta.base.Types.MetaIdStep

interface DefnStudioPickPipelineVarId : DefnFieldEditable
{
  val automationEventId: MetaIdEvent?
  val automationId: MetaIdAutomation?
  val automationStepId: MetaIdStep?
  val excludePipelineVarIdSet: Array<MetaIdPipelineVar>?
  val includeOptionMap: DefnStudioMapOfDtoOption?
  val multiSelect: Boolean?
  val pipelineFormKind: EnumDefnPipelineFormKind?
}