// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAutoStepWithError
import java.util.Map
import com.neome.api.meta.base.Types.MetaIdPipelineParam
import com.neome.api.meta.base.Types.MetaIdPipelineVar
import com.neome.api.meta.base.Types.MetaIdVdAutoNode
import com.neome.api.meta.base.dto.StudioBuildArgBinder
import com.neome.api.meta.base.dto.StudioDtoArgValueParameter

open class EntVdExecuteScheduler : EntVdAutoStepWithError()
{
  var forRemoveSchedulerIdField: StudioDtoArgValueParameter? = null
  var scheduleTrigger: StudioBuildArgBinder? = null
  var sharedParamMap: Map<MetaIdPipelineVar, MetaIdPipelineParam>? = null
  var startNodeId: MetaIdVdAutoNode? = null
}