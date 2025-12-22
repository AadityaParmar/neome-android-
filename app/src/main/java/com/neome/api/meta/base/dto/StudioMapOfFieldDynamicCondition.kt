// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdFieldDynamicCondition

class StudioMapOfFieldDynamicCondition : StudioBase() {
    var andOr: boolean? = null
    var keys: MetaIdFieldDynamicCondition[]? = null
    var map: Record<MetaIdFieldDynamicCondition, StudioMapOfFieldDynamicCondition>? = null
    val metaId: MetaIdFieldDynamicCondition
    var statement: StudioDtoFieldDynamicCondition? = null
}
