// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnKindAutoEdge
import com.neome.api.meta.base.Types.MetaIdPipelineParam
import com.neome.api.meta.base.Types.MetaIdVdAutoEdge
import com.neome.api.meta.base.Types.MetaIdVdAutoNode

class EntVdAutoEdge : VdBase() {
    var fromNodeHandleId: string? = null
    val fromNodeId: MetaIdVdAutoNode
    val kind: EnumDefnKindAutoEdge
    val metaId: MetaIdVdAutoEdge
    var outputPipelineParamId: MetaIdPipelineParam? = null
    val toNodeId: MetaIdVdAutoNode
    var value: string? = null
}
