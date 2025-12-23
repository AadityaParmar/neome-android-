// neome.ai API - do not change
//
@file:Suppress("unused", "MemberVisibilityCanBePrivate", "CanBeParameter", "PropertyName")


package com.neome.api.studio.base.dto

import com.neome.api.meta.base.Symbol
import com.neome.api.meta.base.Types.EnumDefnUserSettingValue

open class DtoEntUserSettingValue {
    var name: Symbol? = null
    var value: Any? = null
    lateinit var valueStatus: EnumDefnUserSettingValue
}
