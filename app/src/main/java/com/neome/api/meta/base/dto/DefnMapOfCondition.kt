// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdCondition

class DefnMapOfCondition {
    var andOr: boolean? = null
    var keys: MetaIdCondition[]? = null
    var map: Record<MetaIdCondition, DefnMapOfCondition>? = null
    val metaId: MetaIdCondition
    var statement: DefnDtoConditionStatement? = null
}
