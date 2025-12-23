// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdPipelineParam
import com.neome.api.meta.base.Types.MetaIdVar

open class StudioDtoUserFilter : StudioBase() {
    var userPipelineParamId: MetaIdPipelineParam? = null
    var userVarId: MetaIdVar? = null
    var users: StudioBuildArgBinder? = null
}
