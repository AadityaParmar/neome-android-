// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumStudioVarKind

open class DefnStudioSetOfVarId : DefnFieldEditable() {
    var varKind: EnumStudioVarKind? = null
    var varKindSet: Array<EnumStudioVarKind>? = null
}
