// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types.MetaIdForm
import com.neome.api.meta.base.Types.MetaIdPipelineVar

class StudioEntPipelineVar : StudioBase() {
    var formId: MetaIdForm? = null
    val metaId: MetaIdPipelineVar
    val name: Symbol
}
