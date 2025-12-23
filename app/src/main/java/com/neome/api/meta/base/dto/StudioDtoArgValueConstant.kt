// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.meta.base.dto

import com.neome.api.meta.base.Types.EnumDefnCompType

open class StudioDtoArgValueConstant : StudioDtoArgValue() {
    lateinit var type: EnumDefnCompType
    var value: Any? = null
}
