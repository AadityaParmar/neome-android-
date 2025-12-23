// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types.MetaIdVisibilityRule

open class StudioVisibilityRule : StudioBase() {
    lateinit var actionMapIfFalse: StudioVisibilityActionMap
    lateinit var actionMapIfTrue: StudioVisibilityActionMap
    var description: String? = null
    lateinit var metaId: MetaIdVisibilityRule
    lateinit var name: Symbol
    var visibilityCondMap: StudioMapOfVisibilityCondition? = null
}
