// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.GhostId
import com.neome.api.meta.base.Types.MetaIdPipelineParam
import com.neome.api.meta.base.Types.MetaIdPipelineVar
import com.neome.api.meta.base.Types.MetaIdVdAutoNode

class EntVdWorkflowControl : StudioBase() {
    var inputParamId: MetaIdPipelineParam? = null
    val metaId: GhostId
    var outputParamId: MetaIdPipelineVar? = null
    var sharedParamMap: Record<MetaIdPipelineVar, MetaIdPipelineParam>? = null
    var startNodeId: MetaIdVdAutoNode? = null
}
