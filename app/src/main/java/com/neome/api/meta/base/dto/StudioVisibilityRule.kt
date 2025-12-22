// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types.MetaIdVisibilityRule

class StudioVisibilityRule : StudioBase() {
    val actionMapIfFalse: StudioVisibilityActionMap
    val actionMapIfTrue: StudioVisibilityActionMap
    var description: string? = null
    val metaId: MetaIdVisibilityRule
    val name: Symbol
    var visibilityCondMap: StudioMapOfVisibilityCondition? = null
}
