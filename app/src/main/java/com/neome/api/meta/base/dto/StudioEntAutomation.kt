// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types.EnumDefnKindAutomation
import com.neome.api.meta.base.Types.MetaIdAutomation

class StudioEntAutomation : StudioBase() {
    var active: boolean? = null
    var description: string? = null
    val kind: EnumDefnKindAutomation
    val metaId: MetaIdAutomation
    var modules: StudioModuleSelection? = null
    val name: Symbol
    var secondary: string? = null
}
