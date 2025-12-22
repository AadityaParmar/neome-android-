// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnCompType

class StudioDtoArgValueConstant : StudioDtoArgValue() {
    val type: EnumDefnCompType
    var value: any? = null
}
