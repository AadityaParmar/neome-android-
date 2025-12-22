// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdPipelineVar

class EntVdPipelineVarMap : StudioBase() {
    val keys: MetaIdPipelineVar[]
    val map: Record<MetaIdPipelineVar, EntVdPipelineVar>
}
