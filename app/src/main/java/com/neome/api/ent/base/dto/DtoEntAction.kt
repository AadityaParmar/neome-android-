// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types.EnumDefnKindAction
import com.neome.api.meta.base.Types.MetaIdAction

class DtoEntAction {
    val actionId: MetaIdAction
    var description: string? = null
    var icon: string? = null
    var increaseAsideWidth: boolean? = null
    val kind: EnumDefnKindAction
    var label: string? = null
    val name: Symbol
    var tooltip: string? = null
}
