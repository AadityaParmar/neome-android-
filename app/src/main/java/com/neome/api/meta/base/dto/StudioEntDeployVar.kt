// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumStudioVarKind
import com.neome.api.meta.base.Types.MetaIdVar

class StudioEntDeployVar : StudioBase() {
    val kind: EnumStudioVarKind
    val metaId: MetaIdVar
    var varValue: any? = null
}
