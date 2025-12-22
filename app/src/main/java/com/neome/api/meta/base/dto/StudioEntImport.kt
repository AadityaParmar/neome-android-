// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types.EnumDefnKindImport
import com.neome.api.meta.base.Types.MetaIdPlugin

class StudioEntImport : StudioBase() {
    var description: string? = null
    var kind: EnumDefnKindImport? = null
    val metaId: MetaIdPlugin
    var modules: StudioModuleSelection? = null
    var name: Symbol? = null
}
