// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types.MetaIdField
import com.neome.api.meta.base.Types.MetaIdMapping

class StudioDtoMappingField : StudioBase() {
    val from: StudioBuildArgBinder
    val metaId: MetaIdMapping
    var name: Symbol? = null
    var primary: boolean? = null
    val to: MetaIdField
}
