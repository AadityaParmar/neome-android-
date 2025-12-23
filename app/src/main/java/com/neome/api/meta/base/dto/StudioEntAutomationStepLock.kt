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

open class StudioEntAutomationStepLock : StudioEntAutomationStep()
{
  var errorFieldId: MetaIdField? = null
  var errorRetryCountVarId: MetaIdVar? = null
  var errorRetryDurationVarId: MetaIdVar? = null
  var lockDuration: FieldDtoDuration? = null
  var lockKeyFieldId: MetaIdField? = null
  var operation: EnumDefnLockOperation? = null
  var sourcePipelineVarId: MetaIdPipelineParam? = null
}