// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdVisibilityCondition
import java.util.Map

open class StudioMapOfVisibilityCondition : StudioBase() {
    var andOr: Boolean? = null
    var keys: Array<MetaIdVisibilityCondition>? = null
    var map: Map<MetaIdVisibilityCondition, StudioMapOfVisibilityCondition>? = null
    lateinit var metaId: MetaIdVisibilityCondition
    var statement: StudioDtoVisibilityCondition? = null
}
