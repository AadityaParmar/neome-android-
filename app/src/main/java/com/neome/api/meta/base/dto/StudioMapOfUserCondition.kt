// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdUserCondition
import java.util.Map

open class StudioMapOfUserCondition : StudioBase() {
    var andOr: Boolean? = null
    var keys: Array<MetaIdUserCondition>? = null
    var map: Map<MetaIdUserCondition, StudioMapOfUserCondition>? = null
    lateinit var metaId: MetaIdUserCondition
    var statement: StudioDtoUserConditionStatement? = null
}
