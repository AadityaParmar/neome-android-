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
import com.neome.api.meta.base.dto.StudioValueParagraph
import com.neome.api.meta.base.dto.StudioValueText

interface EntVdAiAgentControl : StudioBase
{
  val description: StudioValueParagraph?
  val metaId: GhostId
  val name: StudioValueText?
  val sharedParamMap: Map<MetaIdPipelineVar, MetaIdPipelineParam>?
  val startNodeId: MetaIdVdAutoNode?
}