// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnKindHyperlink
import com.neome.api.meta.base.Types.MetaIdVar

class StudioVarValueHyperlink {
    var color: StudioDtoColor? = null
    var colorVarId: MetaIdVar? = null
    var displayText: string? = null
    var kind: EnumDefnKindHyperlink? = null
    var value: string? = null
}
