// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAutoStepWithError
import com.neome.api.meta.base.Types.MetaIdPipelineParam
import com.neome.api.meta.base.Types.MetaIdPipelineVar
import com.neome.api.meta.base.Types.MetaIdVdAutoNode
import com.neome.api.meta.base.dto.StudioBuildArgBinder
import com.neome.api.meta.base.dto.StudioDtoArgValueParameter

interface EntVdExecuteScheduler : EntVdAutoStepWithError
{
  val forRemoveSchedulerIdField: StudioDtoArgValueParameter?
  val scheduleTrigger: StudioBuildArgBinder?
  val sharedParamMap: Map<MetaIdPipelineVar, MetaIdPipelineParam>?
  val startNodeId: MetaIdVdAutoNode?
}