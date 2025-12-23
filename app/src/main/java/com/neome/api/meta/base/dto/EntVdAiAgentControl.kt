// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.GhostId
import com.neome.api.meta.base.Types.MetaIdPipelineParam
import com.neome.api.meta.base.Types.MetaIdPipelineVar
import com.neome.api.meta.base.Types.MetaIdVdAutoNode
import java.util.Map

open class EntVdAiAgentControl : StudioBase() {
    var description: StudioValueParagraph? = null
    lateinit var metaId: GhostId
    var name: StudioValueText? = null
    var sharedParamMap: Map<MetaIdPipelineVar, MetaIdPipelineParam>? = null
    var startNodeId: MetaIdVdAutoNode? = null
}
