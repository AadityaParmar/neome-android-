// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types.EnumStudioCompType
import com.neome.api.meta.base.Types.MetaIdFieldDynamicRule
import com.neome.api.meta.base.Types.MetaIdVar

open class StudioDtoDynamicRule : StudioBase() {
    var conditionNode: StudioMapOfFieldDynamicCondition? = null
    lateinit var fieldType: EnumStudioCompType
    lateinit var metaId: MetaIdFieldDynamicRule
    lateinit var name: Symbol
    var sourceVarId: MetaIdVar? = null
}
