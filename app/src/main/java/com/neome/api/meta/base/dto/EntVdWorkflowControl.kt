// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.GhostId
import com.neome.api.meta.base.Types.MetaIdPipelineParam
import com.neome.api.meta.base.Types.MetaIdPipelineVar
import com.neome.api.meta.base.Types.MetaIdVdAutoNode
import com.neome.api.meta.base.dto.StudioBase

interface EntVdWorkflowControl : StudioBase
{
  val inputParamId: MetaIdPipelineParam?
  val metaId: GhostId
  val outputParamId: MetaIdPipelineVar?
  val sharedParamMap: Map<MetaIdPipelineVar, MetaIdPipelineParam>?
  val startNodeId: MetaIdVdAutoNode?
}