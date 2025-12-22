// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdPipelineParam

class EntVdAutoStepWithOutput : EntVdAutoStep() {
    var outputParamId: MetaIdPipelineParam? = null
    var outputParamName: string? = null
}
