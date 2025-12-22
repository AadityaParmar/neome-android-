// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.Types.MetaIdRole
import com.neome.api.meta.base.Symbol

class DtoEntRole {
    var description: string? = null
    var label: string? = null
    val name: Symbol
    val roleId: MetaIdRole
}
