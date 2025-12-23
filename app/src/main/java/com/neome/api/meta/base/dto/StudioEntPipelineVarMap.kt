// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdPipelineVar
import java.util.Map

open class StudioEntPipelineVarMap : StudioBase() {
    lateinit var keys: Array<MetaIdPipelineVar>
    lateinit var map: Map<MetaIdPipelineVar, StudioEntPipelineVar>
}
