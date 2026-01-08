// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnKindAutoEdge
import com.neome.api.meta.base.Types.MetaIdPipelineParam
import com.neome.api.meta.base.Types.MetaIdVdAutoEdge
import com.neome.api.meta.base.Types.MetaIdVdAutoNode
import com.neome.api.meta.base.dto.VdBase

interface EntVdAutoEdge : VdBase
{
  val fromNodeHandleId: String?
  val fromNodeId: MetaIdVdAutoNode
  val kind: EnumDefnKindAutoEdge
  val metaId: MetaIdVdAutoEdge
  val outputPipelineParamId: MetaIdPipelineParam?
  val toNodeId: MetaIdVdAutoNode
  val value: String?
}