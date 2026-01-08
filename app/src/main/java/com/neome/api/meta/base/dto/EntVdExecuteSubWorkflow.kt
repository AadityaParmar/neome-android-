// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.dto.EntVdAutoStepWithOutputAndError
import com.neome.api.meta.base.Types.MetaIdPipelineParam
import com.neome.api.meta.base.Types.MetaIdPipelineVar
import com.neome.api.meta.base.Types.MetaIdVdAutoNode

interface EntVdExecuteSubWorkflow : EntVdAutoStepWithOutputAndError
{
  val sharedParamMap: Map<MetaIdPipelineVar, MetaIdPipelineParam>?
  val startNodeId: MetaIdVdAutoNode?
}