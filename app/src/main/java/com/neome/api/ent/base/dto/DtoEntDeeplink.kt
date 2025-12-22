// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.ent.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types.EnumDefnKindDeeplink
import com.neome.api.meta.base.Types.MetaIdDeeplink
import com.neome.api.meta.base.dto.StudioModuleSelection

class DtoEntDeeplink {
    val deepLinkId: MetaIdDeeplink
    var description: string? = null
    val kind: EnumDefnKindDeeplink
    var modules: StudioModuleSelection? = null
    val name: Symbol
}
