// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.GhostId
import java.util.Map
import com.neome.api.meta.base.Types.MetaIdPipelineParam
import com.neome.api.meta.base.Types.MetaIdPipelineVar
import com.neome.api.meta.base.Types.MetaIdVdAutoNode
import com.neome.api.meta.base.dto.StudioBase

open class EntVdWorkflowControl : StudioBase()
{
  var inputParamId: MetaIdPipelineParam? = null
  lateinit var metaId: GhostId
  var outputParamId: MetaIdPipelineVar? = null
  var sharedParamMap: Map<MetaIdPipelineVar, MetaIdPipelineParam>? = null
  var startNodeId: MetaIdVdAutoNode? = null
}