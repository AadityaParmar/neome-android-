// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types.MetaIdRole

class StudioDtoOptionPermission : StudioBase() {
    val metaId: MetaIdRole
    var name: Symbol? = null
    val optionIdSet: string[]
}
