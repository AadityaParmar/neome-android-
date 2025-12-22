// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdVisibilityCondition

class DefnVisibilityConditionMap {
    var andOr: boolean? = null
    var keys: MetaIdVisibilityCondition[]? = null
    var map: Record<MetaIdVisibilityCondition, DefnVisibilityConditionMap>? = null
    val metaId: MetaIdVisibilityCondition
    var statement: DefnVisibilityCondition? = null
}
