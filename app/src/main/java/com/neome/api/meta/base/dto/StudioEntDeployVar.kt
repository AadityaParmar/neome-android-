// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumStudioVarKind
import com.neome.api.meta.base.Types.MetaIdVar

open class StudioEntDeployVar : StudioBase() {
    lateinit var kind: EnumStudioVarKind
    lateinit var metaId: MetaIdVar
    var varValue: Any? = null
}
