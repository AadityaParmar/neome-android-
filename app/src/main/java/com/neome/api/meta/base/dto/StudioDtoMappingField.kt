// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdMapping

open class StudioDtoMappingField : StudioBase() {
    lateinit var from: StudioBuildArgBinder
    lateinit var metaId: MetaIdMapping
    var name: Symbol? = null
    var primary: Boolean? = null
    lateinit var to: MetaIdField
}
