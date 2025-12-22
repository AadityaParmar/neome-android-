// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnKindHyperlink
import com.neome.api.meta.base.Types.MetaIdHyperlink

class DefnDtoHyperLink {
    var color: DefnDtoColor? = null
    var colorVar: DefnDtoColor? = null
    var displayText: string? = null
    var kind: EnumDefnKindHyperlink? = null
    val metaId: MetaIdHyperlink
    var value: string? = null
}
