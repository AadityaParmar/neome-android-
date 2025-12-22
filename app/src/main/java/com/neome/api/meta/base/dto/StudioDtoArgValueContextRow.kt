// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnArgBinderContextRow

class StudioDtoArgValueContextRow : StudioDtoArgValueContext() {
    val attribute: EnumDefnArgBinderContextRow
    var fromAlias: string? = null
}
