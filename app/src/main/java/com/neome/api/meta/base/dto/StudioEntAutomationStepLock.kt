// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnLockOperation
import com.neome.api.meta.base.dto.FieldDtoDuration
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdPipelineParam
import com.neome.api.meta.base.Types.MetaIdVar
import com.neome.api.meta.base.dto.StudioEntAutomationStep

interface StudioEntAutomationStepLock : StudioEntAutomationStep
{
  val errorFieldId: MetaIdField?
  val errorRetryCountVarId: MetaIdVar?
  val errorRetryDurationVarId: MetaIdVar?
  val lockDuration: FieldDtoDuration?
  val lockKeyFieldId: MetaIdField?
  val operation: EnumDefnLockOperation?
  val sourcePipelineVarId: MetaIdPipelineParam?
}