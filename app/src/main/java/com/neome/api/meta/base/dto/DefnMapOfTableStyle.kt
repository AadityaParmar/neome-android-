// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdTableStyle

class DefnMapOfTableStyle {
    var keys: MetaIdTableStyle[]? = null
    val map: Record<MetaIdTableStyle, DefnDtoTableStyle>
}
