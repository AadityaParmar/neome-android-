// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.MetaIdTableStyle
import java.util.Map

open class DefnMapOfTableStyle {
    var keys: Array<MetaIdTableStyle>? = null
    lateinit var map: Map<MetaIdTableStyle, DefnDtoTableStyle>
}
