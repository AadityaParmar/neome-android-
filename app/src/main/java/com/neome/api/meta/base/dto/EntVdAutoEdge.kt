// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnKindAutoEdge
import com.neome.api.meta.base.Types.MetaIdPipelineParam
import com.neome.api.meta.base.Types.MetaIdVdAutoEdge
import com.neome.api.meta.base.Types.MetaIdVdAutoNode

open class EntVdAutoEdge : VdBase() {
    var fromNodeHandleId: String? = null
    lateinit var fromNodeId: MetaIdVdAutoNode
    lateinit var kind: EnumDefnKindAutoEdge
    lateinit var metaId: MetaIdVdAutoEdge
    var outputPipelineParamId: MetaIdPipelineParam? = null
    lateinit var toNodeId: MetaIdVdAutoNode
    var value: String? = null
}
