// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types.EnumDefnKindImport
import com.neome.api.meta.base.Types.MetaIdPlugin

open class StudioEntImport : StudioBase() {
    var description: String? = null
    var kind: EnumDefnKindImport? = null
    lateinit var metaId: MetaIdPlugin
    var modules: StudioModuleSelection? = null
    var name: Symbol? = null
}
