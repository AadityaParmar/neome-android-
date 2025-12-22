// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdFieldDynamicCondition

class DefnMapOfDynamicCondition {
    var andOr: boolean? = null
    var keys: MetaIdFieldDynamicCondition[]? = null
    var map: Record<MetaIdFieldDynamicCondition, DefnMapOfDynamicCondition>? = null
    val metaId: MetaIdFieldDynamicCondition
    var statement: DefnDtoDynamicCondition? = null
}
