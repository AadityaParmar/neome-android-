// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdPipelineParam

open class EntVdAiWithOutput : EntVdAi() {
    var outputParamId: MetaIdPipelineParam? = null
    var outputParamName: String? = null
}
