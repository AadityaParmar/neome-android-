// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdPipelineParam
import com.neome.api.meta.base.Types.MetaIdPipelineVar
import com.neome.api.meta.base.Types.MetaIdVdAutoNode
import java.util.Map

open class EntVdExecuteSubWorkflow : EntVdAutoStepWithOutputAndError() {
    var sharedParamMap: Map<MetaIdPipelineVar, MetaIdPipelineParam>? = null
    var startNodeId: MetaIdVdAutoNode? = null
}
