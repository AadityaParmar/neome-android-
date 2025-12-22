// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdUserCondition

class StudioMapOfUserCondition : StudioBase() {
    var andOr: boolean? = null
    var keys: MetaIdUserCondition[]? = null
    var map: Record<MetaIdUserCondition, StudioMapOfUserCondition>? = null
    val metaId: MetaIdUserCondition
    var statement: StudioDtoUserConditionStatement? = null
}
