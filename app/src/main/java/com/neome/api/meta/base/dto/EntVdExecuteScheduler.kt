// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdPipelineParam
import com.neome.api.meta.base.Types.MetaIdPipelineVar
import com.neome.api.meta.base.Types.MetaIdVdAutoNode

class EntVdExecuteScheduler : EntVdAutoStepWithError() {
    var forRemoveSchedulerIdField: StudioDtoArgValueParameter? = null
    var scheduleTrigger: StudioBuildArgBinder? = null
    var sharedParamMap: Record<MetaIdPipelineVar, MetaIdPipelineParam>? = null
    var startNodeId: MetaIdVdAutoNode? = null
}
