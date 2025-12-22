// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnFuncArg
import com.neome.api.meta.base.Types.MetaIdFuncArg

class StudioDtoFuncArg : StudioBase() {
    var funcArgKind: EnumDefnFuncArg? = null
    val metaId: MetaIdFuncArg
    val name: string
    var required: boolean? = null
}
