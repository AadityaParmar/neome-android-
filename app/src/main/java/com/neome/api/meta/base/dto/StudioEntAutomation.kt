// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types.EnumDefnKindAutomation
import com.neome.api.meta.base.Types.MetaIdAutomation

open class StudioEntAutomation : StudioBase() {
    var active: Boolean? = null
    var description: String? = null
    lateinit var kind: EnumDefnKindAutomation
    lateinit var metaId: MetaIdAutomation
    var modules: StudioModuleSelection? = null
    lateinit var name: Symbol
    var secondary: String? = null
}
