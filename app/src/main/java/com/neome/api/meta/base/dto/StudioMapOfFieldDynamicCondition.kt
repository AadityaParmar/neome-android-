// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdFieldDynamicCondition
import java.util.Map

open class StudioMapOfFieldDynamicCondition : StudioBase() {
    var andOr: Boolean? = null
    var keys: Array<MetaIdFieldDynamicCondition>? = null
    var map: Map<MetaIdFieldDynamicCondition, StudioMapOfFieldDynamicCondition>? = null
    lateinit var metaId: MetaIdFieldDynamicCondition
    var statement: StudioDtoFieldDynamicCondition? = null
}
