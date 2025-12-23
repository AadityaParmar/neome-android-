// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types.EnumDefnKindAction
import com.neome.api.meta.base.Types.MetaIdAction

open class DtoEntAction {
    lateinit var actionId: MetaIdAction
    var description: String? = null
    var icon: String? = null
    var increaseAsideWidth: Boolean? = null
    lateinit var kind: EnumDefnKindAction
    var label: String? = null
    lateinit var name: Symbol
    var tooltip: String? = null
}
